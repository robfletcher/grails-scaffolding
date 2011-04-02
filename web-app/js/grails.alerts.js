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
			elements.slideDown('fast').removeAttr('aria-hidden');
			if (settings.hideAfterMillis > 0) {
				setTimeout(function() {
					hide(elements)
				}, settings.hideAfterMillis);
			}
		}

		function hide(elements) {
			elements.slideUp('fast').attr('aria-hidden', 'true');
		}

		this.wrap('<div class="alert" role="alert"/>');
		var alert = this.parent();
		alert.append('<a href="#" class="dismiss-alert" title="close">close</a>');
		// alert.hide();
		$('a.dismiss-alert').live('click', function() {
			hide(alert);
			return false;
		});

		show(alert);
	};
})(jQuery);