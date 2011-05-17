package scaffolding.pages

class Form {
	
	String errorTooltip(String fieldName) {
		form."$fieldName"().jquery.trigger("focus")
		form."$fieldName"().next(".error-tooltip").text()
	}

	boolean hasError(String fieldName) {
		form."$fieldName"().parent(".fieldcontain").hasClass("error")
	}

	boolean isRequired(String fieldName) {
		form."$fieldName"().parent(".fieldcontain").hasClass("required")
	}

	String errorFor(String fieldName) {
		form."$fieldName"().next(".error").find("li").text()
	}
	
	void disableAutomaticValidation() {
		form.jquery.attr("novalidate", "")
	}

}