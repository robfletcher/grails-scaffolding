package scaffolding

import geb.Page
import geb.Module
import java.text.SimpleDateFormat

class BookListPage extends Page {

	static url = "/book/list"
	static at = { title == "Book List" }
	static content = {
		books {
			$("tbody tr").collect {
				module BookRow, it
			}
		}
	}

}

class BookRow extends Module {
	static content = {
		cell { i -> $("td", i) }
		id { cell(0).text().toLong() }
		title { cell(1).text() }
		yearOfPublication { cell(2).text().toInteger() }
		dateCreated { new SimpleDateFormat("yyyy-MM-dd HH:mm:ss Z").parse(cell(3).text()) }
		lastUpdated { new SimpleDateFormat("yyyy-MM-dd HH:mm:ss Z").parse(cell(4).text()) }
	}

	@Override
	String toString() {
		title
	}

}