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
						$.fx.off = true;
						$('select').grailsAutocomplete();
					}
				});

				test('output field is initialized with selected values', function() {
					var output = $('#pre-selected-selected');

					ok(output.is('ul#pre-selected-selected'), 'output element should exist');
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

					autocompleter.autocomplete('search', 'a');

					var results = $(".ui-autocomplete .ui-menu-item");
					equal(results.length, 3, 'items in search results');
					equal(results.eq(0).text(), 'Catflap', 'search results');
					equal(results.eq(1).text(), 'Rubberplant', 'search results');
					equal(results.eq(2).text(), 'Marzipan', 'search results');
				});

				test('option list is filtered by entered term', function() {
					var select = $('select#many-to-many');
					var autocompleter = $('input#many-to-many-autocompleter');

					autocompleter.autocomplete('search', 'an');

					var results = $('.ui-autocomplete .ui-menu-item');
					equal(results.length, 2, 'items in search results');
					equal(results.eq(0).text(), 'Rubberplant', 'search results');
					equal(results.eq(1).text(), 'Marzipan', 'search results');
				});

				test('autocomplete is case-insensetive', function() {
					var select = $('select#many-to-many');
					var autocompleter = $('input#many-to-many-autocompleter');

					autocompleter.autocomplete('search', 'cat');

					var results = $('.ui-autocomplete .ui-menu-item');
					equal(results.length, 1, 'items in search results');
					equal(results.eq(0).text(), 'Catflap', 'search results');
				});

				test('option list is filtered by currently selected items', function() {
					var select = $('select#pre-selected');
					var autocompleter = $('input#pre-selected-autocompleter');

					autocompleter.autocomplete('search', 'a');

					var results = $('.ui-autocomplete .ui-menu-item');
					equal(results.length, 1, 'items in search results');
					equal(results.text(), 'Rubberplant', 'search results');
				});

				test('selecting an autocomplete option adds to output', function() {
					var select = $('select#many-to-many');
					var autocompleter = $('input#many-to-many-autocompleter');
					var output = $('#many-to-many-selected');

					autocompleter.autocomplete('search', 'a');
					$('.ui-autocomplete .ui-menu-item a').eq(1).trigger('mouseover').click();

					var selectedItems = output.find('li .value');
					equal(selectedItems.length, 1, 'selected items');
					equal(selectedItems.text(), 'Rubberplant', 'selected item');
				});

				test('selecting an autocomplete option clears term from input', function() {
					var autocompleter = $('input#many-to-many-autocompleter');

					autocompleter.autocomplete('search', 'a');
					$('.ui-autocomplete .ui-menu-item a').eq(1).trigger('mouseover').click();

					equal(autocompleter.val(), '', 'autocompleter value');
				});

				test('selected item can be removed by clicking delete button', function() {
					var select = $('select#pre-selected');
					var output = $('#pre-selected-selected');

					output.find('a.autocomplete-remove-selection').eq(1).click();

					equal(output.find('li').length, 1, 'items remaining in output');
					equal(select.find('option:selected').length, 1, 'remaining selected items');
					equal(select.find('option:selected').text(), 'Catflap', 'remaining selected item');
				});
				
				test('only one option can be selected in a many-to-one autocompleter', function() {
					var select = $('select#many-to-one');
					var autocompleter = $('input#many-to-one-autocompleter');
					var output = $('#many-to-one-selected');
					
					// search and select once
					autocompleter.autocomplete('search', 'cat');
					$('.ui-autocomplete .ui-menu-item a').trigger('mouseover').click();
					
					equal(select.val(), '1', 'selected option');
					equal(output.find('li .value').text(), 'Catflap', 'selected item');
					
					// search and select again should replace existing selection
					autocompleter.autocomplete('search', 'rub');
					$('.ui-autocomplete .ui-menu-item a').trigger('mouseover').click();
					
					equal(select.val(), '2', 'selected option');
					equal(output.find('li .value').text(), 'Rubberplant', 'selected item');
				})
				
				test('multiple options can be selected in a many-to-many autocompleter', function() {
					var select = $('select#many-to-many');
					var autocompleter = $('input#many-to-many-autocompleter');
					var output = $('#many-to-many-selected');
					
					// search and select once
					autocompleter.autocomplete('search', 'cat');
					$('.ui-autocomplete .ui-menu-item a').trigger('mouseover').click();
					
					deepEqual(select.val(), ['1'], 'selected option');
					equal(output.find('li .value').text(), 'Catflap', 'selected item');
					
					// search and select again should add to existing selection
					autocompleter.autocomplete('search', 'rub');
					$('.ui-autocomplete .ui-menu-item a').trigger('mouseover').click();
					
					deepEqual(select.val(), ['1', '2'], 'selected option');
					deepEqual(output.find('li .value').map(function() { return $(this).text(); }).toArray(), ['Catflap', 'Rubberplant'], 'selected item');
				})
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