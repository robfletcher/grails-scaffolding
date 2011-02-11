(function($) {
	/**
	 * Replaces range selects with an HTML5 range control.
	 */
	$.fn.grailsRange = function() {
		return this.each(function() {
			var select = $(this);
			var min = select.find('option[value!=""]:first').attr('value');
			var max = select.find('option:last-child').attr('value');
			var value = select.val();
			var name = select.attr('name');
			var id = select.attr('id');

			// create a new range input with min & max based on the first & last options in the select
			var input = $('<input>', {
				type: 'range',
				name: name,
				id: id,
				min: min,
				max: max
			});
			input.bind('change', function() {
				$('output[for=' + this.id + ']').html($(this).val());
			});

			// create an output element to echo back the current range value (tabindex -1 is needed for Opera)
			var output = $('<output for="' + id + '"></output>').attr('tabindex', '-1');

			// if there's a current selection set the range value and the initial output text
			if (value) {
				input.val(value);
				output.html(value);
			} else {
				input.val(min);
				output.html(min);
			}

			// replace the select with the range input and insert the output before it
			select.replaceWith(input);
			input.before(output);
		});
	};
})(jQuery);