<!doctype html>
<html>
	<head>
		<meta name="layout" content="qunit">
		<g:javascript library="application"/>
		<script>
			$(document).ready(function() {

				if (Modernizr.inputtypes.range) {

					test('range select should be replaced with a range input', function() {
						var rating = $('#rating');
						ok(rating.is('input'), 'select should be replaced with range input');
						equal(rating.attr('type'), 'range', 'input type');
						equal(rating.attr('min'), '1', 'minimum value of range');
						equal(rating.attr('max'), '5', 'maximum value of range');
					});

					test('range value should be picked up from selected option', function() {
						var rating = $('#rating-with-selection');
						equal(rating.val(), '3', 'range value');
						equal(rating.prev('output').text(), '3', 'range output text');
					});

				} else {

					test('range select should not be changed', function() {
						ok($('#rating').is('select'), 'this browser does not support range inputs so select should be unchanged');
					});
				}

			});
		</script>
	</head>
	<body>
		<form>
			<div class="fieldcontain">
				<label for="rating">Rating</label>
				<select id="rating" name="rating" class="range">
					<option value="1">1</option>
					<option value="2">2</option>
					<option value="3">3</option>
					<option value="4">4</option>
					<option value="5">5</option>
				</select>
			</div>
			<div class="fieldcontain">
				<label for="rating-with-selection">Rating with selection</label>
				<select id="rating-with-selection" name="rating-with-selection" class="range">
					<option value="1">1</option>
					<option value="2">2</option>
					<option value="3" selected>3</option>
					<option value="4">4</option>
					<option value="5">5</option>
				</select>
			</div>
		</form>
	</body>
</html>