package scaffolding.pages

import geb.*

class BookShowPage extends Page {

	static url = "/book/show"
	static at = { title == "Show Book" }
	static content = {
		book { module BookDetail, $("ol.book") }
		editButton(to: BookEditPage) { $(".buttons .edit") }
		deleteButton(to: BookListPage) { $(".buttons .delete") }
	}
}

class BookDetail extends Module {

	static content = {
		title { $("#title-label").next(".property-value").text() }
		authors {
			def node = $("#authors-label").next()
			def values = []
			while (node.hasClass("property-value")) {
				values << node.text()
				node = node.next()
			}
			values
		}
		yearOfPublication { $("#yearOfPublication-label").next(".property-value").text().toInteger() }
	}
	
}
