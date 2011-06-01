(function($) {
	$(function() {
		// prevent FOUC by only making body visible once document is ready
		$('body').addClass('ready');
	});
})(jQuery);