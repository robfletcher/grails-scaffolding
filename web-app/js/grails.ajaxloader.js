(function($) {
	/**
	 * Creates an AJAX loading indicator.
	 */
	$.fn.grailsAjaxLoader = function(options) {
		$('<div class="ajax-loading">Loading&hellip;</div>')
				.appendTo(this)
				.bind('ajaxSend', function() {
					$(this).animate({
						height: 'show'
					}, 'fast');
				})
				.bind('ajaxComplete', function() {
					$(this).animate({
						height: 'hide'
					}, 'fast');
				})
				.hide();
	};
})(jQuery);