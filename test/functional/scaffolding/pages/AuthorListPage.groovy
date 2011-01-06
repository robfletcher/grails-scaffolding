package scaffolding.pages

import geb.Page

class AuthorListPage extends Page {

	static url = "/author/list"
	static at = { title == "Author List" }
	static content = {
		message(required: false) { $(".message").text() }
	}

}
