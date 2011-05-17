package scaffolding.pages

import geb.Page

@Mixin(Form)
class AuthorCreatePage extends Page {

	static url = "/author/create"
	static at = { title == "Create Author" }
	static content = {
		author { $("form") }
		createButton(to: BookShowPage) { $("input.save") }
	}
	
	private getForm() {
		author
	}
	
}
