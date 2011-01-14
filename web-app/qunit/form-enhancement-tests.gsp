<!doctype html>
<html>
	<head>
		<meta name="layout" content="qunit">
		<g:javascript library="application"/>
		<script>
			$(document).ready(function() {

				test('first field with an error should be focused', function() {
					ok($('input:focus').is('#genre'));
				});

				if (Modernizr.inputtypes.range) {

					test('range select should be replaced with a range input', function() {
						var rating = $('#rating');
						ok(rating.is('input'), '"rating" should be replace with an input');
						equal(rating.attr('type'), 'range', '"rating" should be type "range"');
						equal(rating.attr('min'), '1', '"rating" should have a min value of 1');
						equal(rating.attr('max'), '5', '"rating" should have a max value of 5');
					});

					test('range value should be picked up from selected option', function() {
						var rating = $('#rating');
						equal(rating.val(), '3', '"rating" value should be "3"');
						equal(rating.prev('output').text(), '3', 'displayed ouput should be "3"');
					});

				} else {

					test('range select should not be changed', function() {
						ok($('#rating').is('select'), 'this browser does not support range inputs so "rating" should still be a select');
					});
				}

			});
		</script>
	</head>
	<body>
		<form>
			<div class="fieldcontain">
				<label for="title">Name</label>
				<input id="title" type="text" name="title">
			</div>
			<div class="fieldcontain">
				<label for="rating">Rating</label>
				<select id="rating" name="rating" class="range">
					<option value="1">1</option>
					<option value="2">2</option>
					<option value="3" selected>3</option>
					<option value="4">4</option>
					<option value="5">5</option>
				</select>
			</div>
			<div class="fieldcontain error">
				<label for="genre">Genre</label>
				<input id="genre" type="text" name="genre">
			</div>
		</form>
	</body>
</html>