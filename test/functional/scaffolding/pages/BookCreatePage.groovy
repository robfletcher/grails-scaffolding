package scaffolding.pages

import geb.Page

@Mixin(Form)
class BookCreatePage extends Page {

	static url = "/book/create"
	static at = { title == "Create Book" }
	static content = {
		book { $("form") }
		createButton(to: BookShowPage) { $("input.save") }
		errors(required: false) { $(".errors li")*.text() }
	}
	
	private getForm() {
		book
	}
	
}
