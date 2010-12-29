package scaffolding

import geb.Page

class AuthorCreatePage extends Page {

	static url = "/author/create"
	static at = { title == "Create Author" }
	static content = {
		author { $("form") }
		createButton(to: BookShowPage) { $("input.save") }
	}
	
}
