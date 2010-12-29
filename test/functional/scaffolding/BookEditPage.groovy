package scaffolding

import geb.Page

class BookEditPage extends Page {

	static url = "/book/edit"
	static at = { title == "Edit Book" }
	static content = {
		book { $("form") }
		updateButton(to: BookShowPage) { $("input.save") }
	}

}
