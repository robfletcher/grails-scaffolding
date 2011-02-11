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
				source: function(ui, callback) {
					var term = ui.term.toLowerCase();
					// get all unselected options and filter by the search term entered
					var options = select.find('option:not(:selected)').filter(function() {
						return $(this).text().toLowerCase().indexOf(term) != -1;
					}).map(function(index, option) {
						return { id: $(option).attr('value'), value: $(option).text() };
					});
					callback(options);
				},
				select: function(event, ui) {
					// select the corresponding option in the original select element
					var matchingOption = select.find('option[value=' + ui.item.id + ']');
					matchingOption.attr('selected', true);
					select.trigger('change');
					// clear the search input and prevent default behaviour that completes the term
					$(this).val('');
					return false;
				}
			});

			// create an output element that mirrors the content of the select when it changes
			var output = $('<div/>', { id: select.attr('id') + '-output', class: 'output' }).data('for', select.attr('id'));
			select.bind('change', function() {
				var selectedOptions = '<ul>';
				$(this).find('option:selected').each(function() {
					selectedOptions += '<li data-object-id="' + $(this).val() + '"><span class="value">' + $(this).text() + '</span><a class="autocomplete-delete-button" href="#">X</a></li>';
				});
				selectedOptions += '</ul>';
				$('#' + this.id + '-output').html(selectedOptions);
			});

			// each selected element has a button that can be used to remove it from the selection
			$('.autocomplete-delete-button').live('click', function() {
				var objectId = $(this).parent('li').data('object-id');
				var selectId = $(this).parents('.output').data('for');
				var select = $('select#' + selectId);
				select.find('option[value=' + objectId + ']').attr('selected', false);
				select.trigger('change');
				return false;
			});

			// point the label for the select at the autocompleter instead
			$('label[for=' + select.attr('id') + ']').attr('for', autocompleter.attr('id'));

			select.after(output).after(autocompleter);
			select.trigger('change');
			select.hide();
		});
	};
})(jQuery);