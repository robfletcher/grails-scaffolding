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
				max: max,
				change: function() {
					$('output[for=' + this.id + ']').html($(this).val());
				}
			});

			// create an output element to echo back the current range value (tabindex -1 is needed for Opera)
			var output = $('<output for="' + id + '" class="range-output"></output>').attr('tabindex', '-1');

			// if there's a current selection set the range value and the initial output text
			input.val(value ? value : min);

			// replace the select with the range input and insert the output before it
			select.replaceWith(input);
			input.before(output);
			input.trigger('change');
		});
	};
})(jQuery);