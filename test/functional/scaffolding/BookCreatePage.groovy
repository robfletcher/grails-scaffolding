package scaffolding

import geb.Page

class BookCreatePage extends Page {

	static url = "/book/create"
	static at = { title == "Create Book" }
	static content = {
		book { $("form") }
		createButton(to: BookShowPage) { $("input.save") }
	}

}
