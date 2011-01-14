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

			});
		</script>
	</head>
	<body>
		<form>
			<div class="fieldcontain">
				<label for="title">Title</label>
				<input id="title" type="text" name="title">
			</div>
			<div class="fieldcontain error">
				<label for="genre">Genre</label>
				<input id="genre" type="text" name="genre">
			</div>
		</form>
	</body>
</html>