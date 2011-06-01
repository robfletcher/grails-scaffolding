(function($) {
	// if the browser supports range inputs use them instead of selects for range properties
	if (Modernizr.inputtypes.range) {
		$('select.range').grailsRange();
	}
})(jQuery);