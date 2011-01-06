package scaffolding.pages

import geb.*

class AuthorShowPage extends Page {

	static url = "/author/show"
	static at = { title == "Show Author" }
	static content = {
		author { module AuthorDetail, $("dl") }
		deleteButton(to: AuthorListPage) { $("input.delete") }
	}

}

class AuthorDetail extends Module {
	static content = {
		id { $("dt", text: "Id").next("dd").text().toLong() }
		name { $("dt", text: "Name").next("dd").text() }
	}
}