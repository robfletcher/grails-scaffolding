package scaffolding.pages

import geb.Page

@Mixin(Form)
class BookEditPage extends Page {

	static url = "/book/edit"
	static at = { title == "Edit Book" }
	static content = {
		book { $("form") }
		updateButton(to: BookShowPage) { $("input.save") }
		deleteButton(to: BookListPage) { $("input.delete") }
		errors(required: false) { $(".errors li")*.text() }
	}

	private getForm() {
		book
	}
	
}
