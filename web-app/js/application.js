(function($) {
	$(document).ready(function() {

		// if the browser supports range inputs use them instead of selects for range properties
		if (Modernizr.inputtypes.range) {
			$('select.range').grailsRange();
		}

		// if the browser properly supports number inputs they should not be empty
		if (Modernizr.inputtypes.number) {
			$('input[type=number][value=]').val(0);
		}

		// if the browser supports history use AJAX on list pages
		if (Modernizr.history) {
			$('.scaffold-list').grailsList();
		}

		// if jQuery-UI is available use autocomplete for many-* inputs
		if ($().autocomplete != undefined) {
			$('select.many-to-many').grailsAutocomplete();
		}

		// respond to AJAX events with a visual indicator
		$('body').grailsAjaxLoader();

		// put close button on error and message alerts
		$('.errors, .message').grailsAlert();

		$('.field-error').grailsErrors();

		// prevent FOUC by only making body visible once document is ready
		$('body').addClass('ready');

		// focus first field, or preferentially first error field (this only works once page content is visible)
		if ($('.error').length == 0) $(':input:not(:hidden):not(:button):not(:submit):not(:reset):first').focus();
		else $('.error:first :input').focus();

	});
})(jQuery);