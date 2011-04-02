(function($) {
	/**
	 * Creates an AJAX loading indicator.
	 */
	$.fn.grailsAjaxLoader = function(options) {
		$('<div class="ajax-loading">Loading&hellip;</div>')
				.appendTo(this)
				.bind('ajaxSend', function() {
					$(this).slideDown('fast');
				})
				.bind('ajaxComplete', function() {
					$(this).slideUp('fast');
				})
				.hide();
	};
})(jQuery);