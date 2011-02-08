(function($) {
	/**
	 * Decorates many-to-many multiple selects with autocomplete controls.
	 */
	$.fn.grailsAutocomplete = function() {
		return this.each(function() {
			var select = $(this);
			var listdata = [];
			select.find('option').each(function() {
				listdata.push({id: $(this).attr('value'), value: $(this).text()});
			});

			// create an autocomplete element to proxy the select
			var autocompleter = $('<input>', {
				id: select.attr('id') + '-autocompleter',
				type: 'search'
			}).autocomplete({
				source: listdata,
				select: function(event, ui) {
					var matchingOption = select.find('option[value=' + ui.item.id + ']');
					matchingOption.attr('selected', true);
					$(this).val('');
					select.trigger('change');
					return false;
				}
			});

			// create an output element that mirrors the content of the select when it changes
			var output = $('<output for="' + select.attr('id') + '"></output>');
			select.bind('change', function() {
				var selectedOptions = '<ul>';
				$(this).find('option:selected').each(function() {
					selectedOptions += '<li data-id="' + $(this).val() + '"><span class="value">' + $(this).text() + '</span><a class="autocomplete-delete-button" href="#">X</a></li>';
				});
				selectedOptions += '</ul>';
				$('output[for=' + this.id + ']').html(selectedOptions);
			});

			$('.autocomplete-delete-button').live('click', function() {
				var id = $(this).parent('li').data('id');
				var selectId = $(this).parents('output')[0].getAttribute('for');
				var select = $('select#' + selectId);
				select.find('option[value=' + id + ']').attr('selected', false);
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