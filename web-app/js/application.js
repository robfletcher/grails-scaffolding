$(document).ready(function() {
	if (Modernizr.inputtypes.range) {
		initRangeInputs();
	}

	if (Modernizr.history) {
		initAjaxPagination();
	}

	// prevent FOUC by only making body visible once document is ready
	$("body").addClass("ready");

	// focus first error field (this only works once page content is visible)
	$(".error:first").find("input, select, textarea").focus();
});

/**
 * Replaces range selects with an HTML5 range control.
 */
function initRangeInputs() {
	$("select.range").each(function() {
		var select = $(this);
		var min = select.find("option:first-child").attr("value");
		var max = select.find("option:last-child").attr("value");
		var value = select.val();
		var name = select.attr("name");
		var id = select.attr("id");

		// create a new range input with min & max based on the first & last options in the select
		var range = $('<input>', {
			type: "range",
			name: name,
			id: id,
			min: min,
			max: max,
			onchange: function() {
				$('output[for=' + this.id + ']').html($(this).val());
			}
		});

		// create an output element to echo back the current range value (tabindex -1 is needed for Opera)
		var output = $('<output for="' + id + '"></output>').attr("tabindex", "-1");

		// if there's a current selection set the range value and the initial output text
		if (value) {
			range.val(value);
			output.html(value);
		} else {
			range.val(min);
			output.html(max);
		}

		// replace the select with the range input and insert the output before it
		select.replaceWith(range);
		range.before(output);
	});
}

/**
 * AJAX-enables pagination and sorting controls in a table.
 */
function initAjaxPagination() {
	if ($(".pagination a, th.sortable a")) {
		// store current table state in history
		history.replaceState({html: $(".content").html()}, "");

		// decorate list pagination & sorting controls with AJAX
		$(".pagination a, th.sortable a").live("click", function() {
			var url = $(this).attr("href");
			$(".content").load(url + " .content > *", function() {
				// put the new content into history and update the URL
				history.pushState({html: $(".content").html()}, "", url);
			});
			return false;
		});

		// handle back button
		window.onpopstate = function(event) {
			// retrieve previous content from history if there is any
			if (event.state) {
				$(".content").html(event.state.html);
			}
		};
	}
}
