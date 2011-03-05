(function($) {
	/**
	 * Turns field-specific errors into tooltips shown on focus.
	 */
	$.fn.grailsErrors = function(options) {
		this.each(function() {
			// grab the error box and its input
			var errorBox = $(this);
			var input = errorBox.prev(':input');

			errorBox.addClass('error-tooltip');

			// insert a pointer between the input and the tooltip
			var pointer = $('<div class="tooltip-pointer"/>');
			errorBox.prepend(pointer);

			// position the error box to the right of the input and vertically aligned with it
			var inputOffset = input.offset();
			var inputMidpoint = input.outerHeight() / 2;
			var errorBoxMidpoint = errorBox.outerHeight() / 2;

			errorBox.offset({
				left: inputOffset.left + input.outerWidth() + pointer.outerWidth(),
				top: inputOffset.top - (errorBoxMidpoint - inputMidpoint)
			});

			// position the pointer vertically in the middle of the error box
			pointer.offset({
				top: errorBox.offset().top - ((pointer.outerHeight() / 2) - errorBoxMidpoint)
			});

			// hide the error box until its input is focused
			errorBox.hide();
			input.focus(function() {
				errorBox.show();
			}).blur(function() {
				errorBox.hide();
			});
		});
	};
})(jQuery);