package scaffolding.pages

import geb.*

class AuthorShowPage extends Page {

	static url = "/author/show"
	static at = { title == "Show Author" }
	static content = {
		author { module AuthorDetail, $("ol.author") }
		deleteButton(to: AuthorListPage) { $("input.delete") }
	}

}

class AuthorDetail extends Module {
	static content = {
		name { $("#name-label").next(".property-value").text() }
	}
}