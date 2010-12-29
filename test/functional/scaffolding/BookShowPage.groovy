package scaffolding

import java.text.SimpleDateFormat
import geb.*

class BookShowPage extends Page {

	static url = "/book/show"
	static at = { title == "Show Book" }
	static content = {
		book { module BookDetail, $("dl") }
		editButton(to: BookEditPage) { $("input.edit") }
		deleteButton(to: BookListPage) { $("input.delete") }
	}
}

class BookDetail extends Module {

	static content = {
		id { $("dt", text: "Id").next("dd").text().toLong() }
		title { $("dt", text: "Title").next("dd").text() }
		authors {
			def node = $("dt", text: "Authors")
			def definitions = []
			while (node.next().is("dd")) {
				definitions << node.next().text()
				node = node.next()
			}
			definitions
		}
		yearOfPublication { $("dt", text: "Year Of Publication").next("dd").text().toInteger() }
		dateCreated { new SimpleDateFormat("yyyy-MM-dd HH:mm:ss Z").parse($("dt", text: "Date Created").text()) }
		lastUpdated { new SimpleDateFormat("yyyy-MM-dd HH:mm:ss Z").parse($("dt", text: "Last Updated").text()) }
	}
	
}
