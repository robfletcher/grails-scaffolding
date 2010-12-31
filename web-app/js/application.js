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
	if (Modernizr.history) {
		// decorate list pagination & sorting controls with AJAX
		$(".pagination a, th.sortable a").live("click", function() {
			var url = $(this).attr("href");
			$(".content").load(url + " .content");
			return false;
		});
	}

	// prevent FOUC by only making body visible once document is ready
	$("body").addClass("ready");
});