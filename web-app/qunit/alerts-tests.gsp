<!doctype html>
<html>
	<head>
		<meta name="layout" content="qunit">
		<script src="../js/grails.alerts.js"></script>
		<script>
			$(document).ready(function() {
				module('grailsAlerts');
				
				test('alert should wrap the node it was called on', function() {
					$('.message').grailsAlert({hideAfterMillis: 0});

					var alert = $('.alert');
					equal(alert.find('.message').size(), 1, 'message should be inside an alert');
				});

				test('alerts should have a button to allow them to be closed', function() {
					$('.message').grailsAlert({hideAfterMillis: 0});

					var alert = $('.alert');
					var closeButton = alert.find('a.dismiss-alert');
					
					equal(closeButton.size(), 1, 'there should be a close button');
					ok(alert.is(':visible'), 'the alert should be visible to start with');
					equal(alert.attr('aria-hidden'), undefined);
					
					stop();
					closeButton.click();
					setTimeout(function() {
						ok(alert.is(':not(:visible)'), 'the alert should disappear when the link is clicked');
						equal(alert.attr('aria-hidden'), 'true');
						start();
					}, 500);
				});

				test('alerts should disappear after a few seconds', function() {
					$('.message').grailsAlert({hideAfterMillis: 250});

					var alert = $('.alert');
					
					ok(alert.is(':visible'), 'the alert should be visible to start with');
					equal(alert.attr('aria-hidden'), undefined);
					
					stop();
					setTimeout(function() {
						ok(alert.is(':not(:visible)'), 'the alert should disappear after a timeout');
						equal(alert.attr('aria-hidden'), 'true');
						start();
					}, 500);
				});

			});
		</script>
	</head>
	<body>
		<div class="message">A flash message</div>
	</body>
</html>