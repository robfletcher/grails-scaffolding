(function($) {
	/**
	 * Decorates many-to-one and many-to-many multiple selects with autocomplete controls.
	 */
	$.fn.grailsAutocomplete = function() {
		return this.each(function() {
			var select = $(this);

			// create an autocomplete element to proxy the select
			var autocompleter = $('<input>', {
				id: select.attr('id') + '-autocompleter',
				type: 'search'
			}).autocomplete({
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
			});

			// create an output element that mirrors the content of the select when it changes
			var selectedList = $('<ul/>', { 
				id: select.attr('id') + '-selected', 
				class: 'autocomplete-selected' 
			});
			
			// whenever selection changes (whether due to autocompleter or any other trigger) update the selected list
			select.bind('change', function() {
				var selectedItems = selectedList.find('li');
				$(this).find('option').each(function(index) {
					var option = $(this);
					var optionId = option.attr('value');
					var optionText = option.text();
					
					var matchingItem = selectedItems.filter(function() {
						return $(this).data('object-id') == optionId;
					});
					
					if (matchingItem.length > 0 && option.is(':not(:selected)')) {
						matchingItem.slideUp(50, function() {
							$(this).remove();
						});
					} else if (matchingItem.length === 0 && option.is(':selected')) {
						var newItem = $('<li><span class="value">' + optionText + '</span><a class="autocomplete-remove-selection" href="#" role="button"></a></li>').data('object-id', optionId);
						newItem.hide().appendTo(selectedList).slideDown(50);
					}
				});
			});

			// each element in the selected list has a button that can be used to remove it from the selection
			$('.autocomplete-remove-selection').live('click', function() {
				var objectId = $(this).parent('li').data('object-id');
				select.find('option[value=' + objectId + ']').attr('selected', false);
				select.trigger('change');
				return false;
			});

			// point the label for the select at the autocompleter instead
			$('label[for=' + select.attr('id') + ']').attr('for', autocompleter.attr('id'));

			autocompleter.insertAfter(select);
			selectedList.insertAfter(autocompleter).width(autocompleter.outerWidth());
			select.trigger('change');
			select.hide();
		});
	};
})(jQuery);