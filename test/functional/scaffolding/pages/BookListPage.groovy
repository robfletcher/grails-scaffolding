package scaffolding.pages

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
		pagination { module Pagination, $(".pagination") }
		message(required: false) { $(".message").text() }
	}

}

class BookRow extends Module {
	static content = {
		cell { i -> $("td", i) }
		title { cell(0).text() }
		yearOfPublication { cell(1).text().toInteger() }
		averageRating { cell(2).text().toInteger() }
		genre { cell(3).text() }
		ebook { cell(4).text().toBoolean() }
		showLink(to: BookShowPage) { cell(0).find("a") }
	}

	@Override
	String toString() {
		title
	}

}

class Pagination extends Module {

    static content = {
        links(required: false) { $("a") }
        currentPage(required: false) { $(".currentStep")?.text()?.toInteger() ?: 1 }
        nextLink(required: false) { links.filter(".nextLink") }
        previousLink(required: false) { links.filter(".prevLink") }
    }

    boolean isFirstPage() {
        previousLink.empty
    }

    boolean isLastPage() {
        nextLink.empty
    }

    void toPage(int pageNumber) {
        def link = links.filter(text: "$pageNumber")
        if (!link) throw new IllegalArgumentException("Page number $pageNumber not present in pagination")
        link.click()
    }

    void nextPage() {
        if (lastPage) throw new IllegalStateException("Already on the last page")
        nextLink.click()
    }

    void previousPage() {
        if (firstPage) throw new IllegalStateException("Already on the first page")
        previousLink.click()
    }
}