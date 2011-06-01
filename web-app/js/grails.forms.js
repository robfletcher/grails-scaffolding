(function($) {
	$(function() {
		// if the browser properly supports number inputs they should not be empty
		if (Modernizr.inputtypes.number) {
			$('input[type=number][value=]').val(0);
		}

		// focus first field, or preferentially first error field (this only works once page content is visible)
		if ($('.error').length == 0) $(':input:not(:hidden):not(:button):not(:submit):not(:reset):first').focus();
		else $('.error:first :input').focus();
	});
})(jQuery);