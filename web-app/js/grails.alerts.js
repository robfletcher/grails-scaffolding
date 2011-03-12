(function($) {
	/**
	 * Turns flash messages into popup dialogs
	 */
	$.fn.grailsAlert = function(options) {
		// settings that can be overridden with arguments
		var settings = {
			hideAfterMillis: 5000 // if zero alert remains visible, otherwise it is hidden after this many millis
		};
		if (options) {
			$.extend(settings, options);
		}

		function show(elements) {
			elements.animate({height: 'show'}, 'fast').removeAttr('aria-hidden');
			if (settings.hideAfterMillis > 0) {
				setTimeout(function() {
					hide(elements)
				}, settings.hideAfterMillis);
			}
		}

		function hide(elements) {
			elements.animate({height: 'hide'}, 'fast').attr('aria-hidden', 'true');
		}

		this.hide().append('<a href="#" class="dismiss-alert" title="close">&times;</a>');
		$('a.dismiss-alert').live('click', function() {
			hide($(this).parent());
			return false;
		});

		show(this);
	};
})(jQuery);