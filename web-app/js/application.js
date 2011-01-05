//var Ajax;
//if (Ajax && (Ajax != null)) {
//	Ajax.Responders.register({
//	  onCreate: function() {
//        if($('spinner') && Ajax.activeRequestCount>0)
//          Effect.Appear('spinner',{duration:0.5,queue:'end'});
//	  },
//	  onComplete: function() {
//        if($('spinner') && Ajax.activeRequestCount==0)
//          Effect.Fade('spinner',{duration:0.5,queue:'end'});
//	  }
//	});
//}

$(document).ready(function() {

	// replace range selects with HTML5 range control if supported
	if (Modernizr.inputtypes.range) {
		$("select.range").each(function() {
			var select = $(this);
			var range = $('<input>', {
				type: "range",
				name: select.attr("name"),
				id: select.attr("id"),
				min: select.find("option:first-child").attr("value"),
				max: select.find("option:last-child").attr("value"),
				onchange: function() {
					$('output[for=' + $(this).attr('id') + ']').html($(this).val());
				}
			});
			var output = $('<output for="' + select.attr("id") + '"></output>');
			var value = select.find("option[selected]").attr("value");
			if (value) {
				range.val(value);
				output.html(value);
			}
			select.replaceWith(range);
			range.after(output);
		});
	}

	if (Modernizr.history) {
		if ($(".pagination a, th.sortable a")) {
			// store current table state in history
			history.replaceState({html: $(".content").html()}, "");
		}

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

	// prevent FOUC by only making body visible once document is ready
	$("body").addClass("ready");

	// focus first error field (this only works once page content is visible)
	$(".error:first").find("input, select, textarea").focus();
});