(function($) {
	$(document).ready(function() {

		// add confirmations to delete buttons, etc.
		$('[data-confirmation-message]').click(function() {
			return confirm($(this).data('confirmation-message'));
		});
	});
})(jQuery);