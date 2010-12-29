package scaffolding

import geb.Page

class BookCreatePage extends Page {

	static url = "/book/create"
	static at = { title == "Create Book" }
	static content = {
		bookForm { $("form") }
		createButton(to: BookShowPage) { $("fieldset.buttons input.save") }
	}

}
