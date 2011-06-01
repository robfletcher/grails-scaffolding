<!doctype html>
<html>
	<head>
		<meta name="layout" content="qunit">
		<script src="../js/grails.errors.js"></script>
		<script>
			$(document).ready(function() {
				module('grailsErrorTooltips', {
					setup: function() {
						$('.errors li').grailsErrorTooltips();
					}
				});

				test('global errors should remain in the list', function() {
					var errors = $('.errors li');
					equal(errors.size(), 2, 'number of error messages');
					equal(errors.first().text(), 'A global error', 'first error message');
				});

				test('errors related to a field that is not present should remain in the list', function() {
					var errors = $('.errors li');
					equal(errors.size(), 2, 'number of error messages');
					equal(errors.last().text(), 'An error for a field that is not in the form', 'last error message');
				});
				
				test('error related to an input should be replaced with a tooltip', function() {
					var input = $('#title');
					var tooltip = input.next();
					ok(tooltip.is('.error-tooltip'));
					equal(tooltip.text(), 'An error for the title field');
				});

				test('valid input should not have a tooltip', function() {
					var input = $('#genre');
					equal(input.next('.error-tooltip').size(), 0, 'there should be no tooltip next to the input');
				});

				test('inputs and error tooltips should have aria attributes', function() {
					var input = $('#title');
					var tooltip = input.next();
					equal(tooltip.attr('role'), 'tooltip');
					equal(input.attr('aria-invalid'), 'true');
				});

				test('tooltips should only be visible when input is focused', function() {
					var input = $('#title');
					var tooltip = input.next();
					ok(tooltip.is(':not(:visible)'), 'tooltip should not be visible until input is focused');
					equal(tooltip.attr('aria-hidden'), 'true');
					input.trigger('focus');
					ok(tooltip.is(':visible'), 'tooltip should become visible when input is focused');
					equal(tooltip.attr('aria-hidden'), undefined);
					input.trigger('blur');
					ok(tooltip.is(':not(:visible)'), 'tooltip should become invisible when input is de-focused');
					equal(tooltip.attr('aria-hidden'), 'true');
				});
				
				test('the original error container remains in the DOM if there are still messages in it', function() {
					equal($('.errors').size(), 1, 'error container should still be present');
				});

				module('grailsErrorTooltips', {
					setup: function() {
						var errors = $('.errors li');
						errors.first().remove();
						errors.last().remove();
						errors.grailsErrorTooltips();
					}
				});

				test('the original error container is removed from the DOM if there are no remaining messages in it', function() {
					equal($('.errors').size(), 0, 'error container should have been removed');
				});

			});
		</script>
	</head>
	<body>
		<ul class="errors">
			<li>A global error</li>
			<li data-field-id="title">An error for the title field</li>
			<li data-field-id="no-such-input">An error for a field that is not in the form</li>
		</ul>
		<form>
			<div class="fieldcontain">
				<label for="title">Title</label>
				<input id="title" type="text" name="title">
			</div>
			<div class="fieldcontain">
				<label for="genre">Genre</label>
				<input id="genre" type="text" name="genre">
			</div>
		</form>
	</body>
</html>