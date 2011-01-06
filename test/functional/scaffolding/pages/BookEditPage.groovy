package scaffolding.pages

import geb.Page

class BookEditPage extends Page {

	static url = "/book/edit"
	static at = { title == "Edit Book" }
	static content = {
		book { $("form") }
		updateButton(to: BookShowPage) { $("input.save") }
		deleteButton(to: BookListPage) { $("input.delete") }
		errors(required: false) { $(".errors li")*.text() }
	}

	boolean hasError(String fieldName) {
		book."$fieldName"().parent("li").hasClass("error")
	}

	boolean isRequired(String fieldName) {
		book."$fieldName"().parent("li").hasClass("required")
	}

}
