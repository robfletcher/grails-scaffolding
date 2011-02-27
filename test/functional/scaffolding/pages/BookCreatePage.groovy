package scaffolding.pages

import geb.Page

class BookCreatePage extends Page {

	static url = "/book/create"
	static at = { title == "Create Book" }
	static content = {
		book { $("form") }
		createButton(to: BookShowPage) { $("input.save") }
		errors(required: false) { $(".errors li")*.text() }
	}

	boolean hasError(String fieldName) {
		book."$fieldName"().parent(".fieldcontain").hasClass("error")
	}

	boolean isRequired(String fieldName) {
		book."$fieldName"().parent(".fieldcontain").hasClass("required")
	}

	String errorFor(String fieldName) {
		book."$fieldName"().parent(".fieldcontain").next(".error").find("li").text()
	}

}
