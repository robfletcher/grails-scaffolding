<!doctype html>
<html>
	<head>
		<meta name="layout" content="qunit">
		<g:javascript library="grails.range"/>
		<script>
			$(document).ready(function() {
				module('grailsRange', {
					setup: function() {
						$('select.range').grailsRange();
					}
				});

				test('range select should be replaced with a range input', function() {
					var input = $('#range');
					ok(input.is('input'), 'select should be replaced with range input');
					equal(input.attr('type'), 'range', 'input type');
					equal(input.attr('min'), '1', 'minimum value of range');
					equal(input.attr('max'), '5', 'maximum value of range');
				});

				test('initial value should be minimum if there is no selection', function() {
					var input = $('#range');
					var output = $('output[for=range]');
					equal(input.val(), input.attr('min'), 'input value');
					equal(output.text(), input.val(), 'range output text')
				});

				test('range value should be picked up from selected option', function() {
					var input = $('#range-with-selection');
					var output = $('output[for=range-with-selection]');
					equal(input.val(), '3', 'range value');
					equal(output.text(), input.val(), 'range output text');
				});

				test('a placeholder option should be ignored', function() {
					var range = $('#range-with-placeholder');
					equal(range.attr('min'), '1', 'minimum value of range');
				});

				test('value of range should be reflected in associated output element', function() {
					var input = $('#range');
					var output = $('output[for=range]');
					equal(output.text(), '1', 'initial output text');
					input.val('2').trigger('change');
					equal(output.text(), '2', 'output text after adjusting slider');
				});
			});
		</script>
	</head>
	<body>
		<form>
			<div class="fieldcontain">
				<label for="range">range</label>
				<g:select from="${1..5}" name="range" class="range"/>
			</div>
			<div class="fieldcontain">
				<label for="range-with-selection">range with selection</label>
				<g:select from="${1..5}" name="range-with-selection" class="range" value="3"/>
			</div>
			<div class="fieldcontain">
				<label for="range-with-placeholder">range with placeholder</label>
				<g:select from="${1..5}" name="range-with-placeholder" class="range" noSelection="['': 'Please select something']"/>
			</div>
		</form>
	</body>
</html>