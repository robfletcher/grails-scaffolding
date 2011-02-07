<!doctype html>
<html>
	<head>
		<meta name="layout" content="qunit">
		<script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.8.9/jquery-ui.min.js"></script>
		<g:javascript library="application"/>
		<script>
			$(document).ready(function() {
				module('grailsAutocompleteInput', {
					teardown: function() {
						$(':ui-autocomplete').autocomplete('close');
					}
				});


				test('output field is initialized with selected values', function() {
					var output = $('output[for=many-to-many-select]');

					ok(output.is('output'), 'output element should exist');
					equal(output.text(), 'Catflap, Marzipan', 'output text');
				});

				test('label for select is re-directed to autocompleter', function() {
					var select = $('select#many-to-many-select');
					var autocompleter = $('input#many-to-many-select-autocompleter');
					var label = select.prev();

					ok(autocompleter.is('input[type=search]'), 'autocompleter should exist');
					equal(label.attr('for'), autocompleter.attr('id'), 'label should point to autocompleter');
				});

				test('typing in an autocompleter triggers option popup', function() {
					var select = $('select#many-to-many-select');
					var autocompleter = $('input#many-to-many-select-autocompleter');
					var output = $('output[for=many-to-many-select]');

					autocompleter.autocomplete('search', 'a');

					var results = $(".ui-menu .ui-menu-item");
					equal(results.length, 3, 'items in search results');
					equal(results.eq(0).text(), 'Catflap', 'search results');
					equal(results.eq(1).text(), 'Rubberplant', 'search results');
					equal(results.eq(2).text(), 'Marzipan', 'search results');
				});

				test('option list is filtered by autocomplete value', function() {
					var select = $('select#many-to-many-select');
					var autocompleter = $('input#many-to-many-select-autocompleter');
					var output = $('output[for=many-to-many-select]');

					autocompleter.autocomplete('search', 'an');

					var results = $('.ui-menu .ui-menu-item');
					equal(results.length, 2, 'items in search results');
					equal(results.eq(0).text(), 'Rubberplant', 'search results');
					equal(results.eq(1).text(), 'Marzipan', 'search results');
				});
			});
		</script>
	</head>
	<body>
		<form>
			<div class="fieldcontain">
				<label for="many-to-one-select">Many-to-one select</label>
				<select id="many-to-one-select" name="many-to-one-select" class="many-to-one">
					<option value=""></option>
					<option value="1">Catflap</option>
					<option value="2">Rubberplant</option>
					<option value="3">Marzipan</option>
				</select>
			</div>
			<div class="fieldcontain">
				<label for="many-to-many-select">Many-to-many select</label>
				<select id="many-to-many-select" name="many-to-many-select" class="many-to-many" multiple>
					<option value="1" selected>Catflap</option>
					<option value="2">Rubberplant</option>
					<option value="3" selected>Marzipan</option>
				</select>
			</div>
		</form>
	</body>
</html>