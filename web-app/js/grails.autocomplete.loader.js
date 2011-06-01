(function($) {
	// if jQuery-UI is available use autocomplete for many-* inputs
	if ($.autocomplete != undefined) {
		$('select.many-to-many').grailsAutocomplete();
	}
})(jQuery);