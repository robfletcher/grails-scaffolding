(function($) {
	/**
	 * Turns field-specific errors into tooltips shown on focus.
	 */
	$.fn.grailsErrorTooltips = function(options) {
		// settings that can be overridden with arguments
		var settings = {
			hide: true // if true, hides the tooltips until the corresponding input is focused
		};
		if (options) {
			$.extend(settings, options);
		}
		
		var container = $(this).parent();

		this.each(function() {
			// grab the error message and its input
			var errorMessage = $(this).text();
			var fieldId = $(this).data('field-id');
			var input = $('#' + fieldId);

			if (input.size() == 1) {
				// remove the original error message from the DOM
				$(this).remove();

				// create a tooltip adjacent to the input
				var errorBox = $('<div></div>').text(errorMessage).addClass('error-tooltip').attr('role', 'tooltip');
				input.attr('aria-invalid', 'true').after(errorBox);

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
				if (settings.hide) {
					errorBox.hide().attr('aria-hidden', true);
					input.focus(function() {
						errorBox.show().removeAttr('aria-hidden');
					}).blur(function() {
						errorBox.hide().attr('aria-hidden', 'true');
					});
				}
			}
		});
			
		// if all error messages have been turned into tooltips remove the message container
		if (container.has(this).size() == 0) {
			container.remove();
		}
		
		return this;
	};
})(jQuery);