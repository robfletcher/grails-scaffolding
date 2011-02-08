<!doctype html>
<html>
	<head>
		<meta name="layout" content="qunit">
		<script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.8.9/jquery-ui.min.js"></script>
		<g:javascript library="grails.autocomplete"/>
		<script>
			$(document).ready(function() {
				module('grailsAutocompleteInput', {
					setup: function() {
						$('select').grailsAutocomplete();
					}
				});

				test('output field is initialized with selected values', function() {
					var output = $('output[for=pre-selected]');

					ok(output.is('output'), 'output element should exist');
					equal(output.find('li .value').length, 2, 'number of selected options');
					equal(output.find('li .value').eq(0).text(), 'Catflap', 'output text');
					equal(output.find('li .value').eq(1).text(), 'Marzipan', 'output text');
				});

				test('label for select is re-directed to autocompleter', function() {
					var select = $('select#many-to-many');
					var autocompleter = $('input#many-to-many-autocompleter');
					var label = select.prev();

					ok(autocompleter.is('input[type=search]'), 'autocompleter should exist');
					equal(label.attr('for'), autocompleter.attr('id'), 'label should point to autocompleter');
				});

				test('typing in an autocompleter triggers option popup', function() {
					var select = $('select#many-to-many');
					var autocompleter = $('input#many-to-many-autocompleter');
					var output = $('output[for=many-to-many]');

					autocompleter.autocomplete('search', 'a');

					var results = $(".ui-autocomplete .ui-menu-item");
					equal(results.length, 3, 'items in search results');
					equal(results.eq(0).text(), 'Catflap', 'search results');
					equal(results.eq(1).text(), 'Rubberplant', 'search results');
					equal(results.eq(2).text(), 'Marzipan', 'search results');
				});

				test('option list is filtered by autocomplete value', function() {
					var select = $('select#many-to-many');
					var autocompleter = $('input#many-to-many-autocompleter');
					var output = $('output[for=many-to-many]');

					autocompleter.autocomplete('search', 'an');

					var results = $('.ui-autocomplete .ui-menu-item');
					equal(results.length, 2, 'items in search results');
					equal(results.eq(0).text(), 'Rubberplant', 'search results');
					equal(results.eq(1).text(), 'Marzipan', 'search results');
				});

				test('selecting an autocomplete option adds to output', function() {
					var select = $('select#many-to-many');
					var autocompleter = $('input#many-to-many-autocompleter');
					var output = $('output[for=many-to-many]');

					autocompleter.autocomplete('search', 'a');
					stop();

					setTimeout(function() {
						$('.ui-autocomplete .ui-menu-item a').eq(1).trigger('mouseover').click();
						var selectedItems = $('output[for=many-to-many li .value');
						equal(selectedItems.length, 1, 'selected items');
						equal(selectedItems.text(), 'Rubberplant', 'selected item');
						start();
					}, 200);
				});

				test('remove a selected item', function() {
					var select = $('select#pre-selected');
					var output = $('output[for=pre-selected]');

					output.find('a.autocomplete-delete-button').eq(1).click();

					equal(output.find('li').length, 1, 'items remaining in output');
					equal(select.find('option:selected').length, 1, 'remaining selected items');
					equal(select.find('option:selected').text(), 'Catflap', 'remaining selected item');
				});
			});
		</script>
	</head>
	<body>
		<form>
			<div class="fieldcontain">
				<label for="many-to-one">Many-to-one select</label>
				<select id="many-to-one" name="many-to-one" class="many-to-one">
					<option value=""></option>
					<option value="1">Catflap</option>
					<option value="2">Rubberplant</option>
					<option value="3">Marzipan</option>
				</select>
			</div>
			<div class="fieldcontain">
				<label for="many-to-many">Many-to-many select</label>
				<select id="many-to-many" name="many-to-many" class="many-to-many" multiple>
					<option value="1">Catflap</option>
					<option value="2">Rubberplant</option>
					<option value="3">Marzipan</option>
				</select>
			</div>
			<div class="fieldcontain">
				<label for="pre-selected">Many-to-many select</label>
				<select id="pre-selected" name="pre-selected" class="many-to-many" multiple>
					<option value="1" selected>Catflap</option>
					<option value="2">Rubberplant</option>
					<option value="3" selected>Marzipan</option>
				</select>
			</div>
		</form>
	</body>
</html>