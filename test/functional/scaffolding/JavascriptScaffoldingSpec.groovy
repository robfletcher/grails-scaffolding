package scaffolding

import spock.lang.Stepwise
import scaffolding.example.*
import scaffolding.pages.*
import grails.plugin.geb.GebSpec

@Stepwise
class JavascriptScaffoldingSpec extends GebSpec {

	def cleanupSpec() {
		Author.withNewSession { session ->
			Book.list()*.delete()
			Author.list()*.delete()
			session.flush()
		}
	}

	def "set up a couple of authors"() {
		given:
		to AuthorCreatePage

		when:
		author.name = name
		createButton.click()

		then:
		at AuthorShowPage
		author.name == name

		where:
		name << ["William Gibson", "Bruce Sterling"]
	}

	def "view empty book list"() {
		given:
		to BookListPage

		expect:
		books.empty
	}

	def "add new book"() {
		given:
		to BookCreatePage

		when:
		book.title = "Neuromancer"
		autocomplete(book.authors(), "William Gibson")
		book.yearOfPublication = "1984"

		and:
		createButton.click()

		then:
		at BookShowPage
		book.title == "Neuromancer"
		book.authors == ["William Gibson"]
		book.yearOfPublication == 1984
	}

	def "view book list"() {
		given:
		to BookListPage

		expect:
		books.size() == 1
	}

	def "show book"() {
		when:
		books[0].showLink.click()

		then:
		at BookShowPage
		book.title == "Neuromancer"
		book.authors == ["William Gibson"]
		book.yearOfPublication == 1984
	}

	def "navigate to edit book page"() {
		when:
		editButton.click()

		then:
		at BookEditPage
	}

	def "edit book"() {
		when:
		book.title = "The Difference Engine"
		autocomplete(book.authors(), "Bruce Sterling")
		book.yearOfPublication = "1990"
		updateButton.click()

		then:
		at BookShowPage
		book.title == "The Difference Engine"
		book.authors == ["Bruce Sterling", "William Gibson"]
		book.yearOfPublication == 1990
	}

	def "delete book"() {
		when:
		deleteButton.click()

		then:
		at BookListPage
		message ==~ /Book \d+ deleted/
		books.empty
	}
	
	private void autocomplete(field, value) {
		def fieldId = field.@id
		$("#$fieldId-autocompleter") << value
		waitFor {
			$(".ui-autocomplete").displayed
		}
		$(".ui-autocomplete a").jquery.mouseover().click()
		waitFor {
			value in $("#$fieldId-selected li .value")*.text()
		}
	}

}