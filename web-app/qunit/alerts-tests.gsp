<!doctype html>
<html>
	<head>
		<meta name="layout" content="qunit">
		<g:javascript library="grails.alerts"/>
		<script>
			$(document).ready(function() {
				module('grailsAlerts');

				test('alerts should have a button to allow them to be closed', function() {
					$('.message').grailsAlert({hideAfterMillis: 0});

					var alert = $('.message');
					var closeButton = alert.find('a.dismiss-alert');
					
					equal(closeButton.size(), 1, 'there should be a close button');
					ok(alert.is(':visible'), 'the alert should be visible to start with');
					
					stop();
					closeButton.click();
					setTimeout(function() {
						ok(alert.is(':not(:visible)'), 'the alert should disappear when the link is clicked');
						start();
					}, 500);
				});

				test('alerts should disappear after a few seconds', function() {
					$('.message').grailsAlert({hideAfterMillis: 250});

					var alert = $('.message');
					
					ok(alert.is(':visible'), 'the alert should be visible to start with');
					
					stop();
					setTimeout(function() {
						ok(alert.is(':not(:visible)'), 'the alert should disappear after a timeout');
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