(function($) {
	// if the browser supports history use AJAX on list pages
	if (Modernizr.history) {
		$('.scaffold-list').grailsList();
	}
})(jQuery);