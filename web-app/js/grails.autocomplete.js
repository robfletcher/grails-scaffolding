(function($) {
	/**
	 * Decorates many-to-one and many-to-many multiple selects with autocomplete controls.
	 */
	$.fn.grailsAutocomplete = function(options) {
		// settings that can be overridden with arguments
		var settings = {
			minLength: 0,          // as per same property on jQuery UI autocomplete
			removeLabel: 'Remove', // label for the remove button that appears next to each selected item
			speed: 50              // speed of animation used when selected items are added and removed
		};
		if (options) {
			$.extend(settings, options);
		}
		
		return this.each(function() {
			var select = $(this);
			var selectId = select.attr('id');
		
			// create an autocomplete element to proxy the select
			var autocompleter = $('<input id="' + selectId + '-autocompleter" type="search">').autocomplete({
				minLength: 0,
				// the data source for the autocompleter is all the unselected options from the select filtered by the entered text
				source: function(ui, callback) {
					var term = ui.term.toLowerCase();
					var options = select.find('option:not(:selected)').filter(function() {
						return $(this).text().toLowerCase().indexOf(term) != -1;
					}).map(function(index, option) {
						return { id: $(option).attr('value'), value: $(option).text() };
					});
					callback(options);
				},
				// when an autocomplete suggestion is chosen the corresponding option in the select is selected
				select: function(event, ui) {
					var matchingOption = select.find('option[value=' + ui.item.id + ']');
					matchingOption.attr('selected', true);
					select.trigger('change');
					// clear the search input and prevent default behaviour
					$(this).val('');
					return false;
				}
			}).bind('blur', function() {
				$(this).val('');
			});
		
			// create an output element that mirrors the content of the select when it changes
			var selectedList = $('<ul/>', { 
				'id': selectId + '-selected', 
				'class': 'autocomplete-selected' 
			});

			// function that can update the selected item list based on the current state of the original select element
			function updateSelection(event, speed) {
				if (speed === undefined) speed = settings.speed;
				
				var selectedItems = selectedList.find('li');
				select.find('option').each(function(index) {
					var option = $(this);
					var optionId = option.attr('value');
					var optionText = option.text();
				
					var matchingItem = selectedItems.filter(function() {
						return $(this).data('object-id') == optionId;
					});
					
					if (matchingItem.length > 0 && option.is(':not(:selected)')) {
						matchingItem.slideUp(speed, function() {
							$(this).remove();
						});
					} else if (matchingItem.length === 0 && option.is(':selected')) {
						var newItem = $('<li><span class="value">' + optionText + '</span></li>').data('object-id', optionId);
						$('<a class="autocomplete-remove-selection" href="#" role="button"></a>').appendTo(newItem).attr('title', settings.removeLabel).text(settings.removeLabel);
						newItem.hide().appendTo(selectedList).slideDown(speed);
					}
				});
			}
					
			// whenever selection changes update the selected list
			select.bind('change', updateSelection);
		
			// each element in the selected list has a button that can be used to remove it from the selection
			$('a.autocomplete-remove-selection').live('click', function() {
				var objectId = $(this).parent('li').data('object-id');
				select.find('option[value=' + objectId + ']').attr('selected', false);
				select.trigger('change');
				return false;
			});
		
			select.hide();
			// point the label for the select at the autocompleter instead
			$('label[for=' + selectId + ']').attr('for', autocompleter.attr('id'));
		
			autocompleter.insertAfter(select);
			if (autocompleter.outerWidth() < select.outerWidth()) {
				autocompleter.width(select.outerWidth());
			}
			selectedList.insertAfter(autocompleter).width(autocompleter.outerWidth()).offset({left: autocompleter.offset().left});
			updateSelection(null, 0);
		});
	};
})(jQuery);