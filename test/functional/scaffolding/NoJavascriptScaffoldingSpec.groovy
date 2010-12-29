package scaffolding

import spock.lang.*
import grails.plugin.geb.*

@Stepwise
class NoJavascriptScaffoldingSpec extends GebSpec {

	@Shared Map<String, Long> authorIds = [:]

	@Override
	String getBaseUrl() {
		super.getBaseUrl() ?: "http://localhost:8080/"
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

		cleanup:
		authorIds[name] = author.id

		where:
		name << ["William Gibson", "Bruce Sterling"]
	}

	def "view empty list"() {
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
		book.authors = [authorIds["William Gibson"].toString()] // TODO: this really sucks, should be able to set select by option text
		book.yearOfPublication = "1984"
		
		and:
		createButton.click()
		
		then:
		at BookShowPage
		book.title == "Neuromancer"
		book.authors == ["William Gibson"]
		book.yearOfPublication == 1984
	}
	
	def "view list"() {
		given:
		to BookListPage
		
		expect:
		books.size() == 1
	}

	def "show instance"() {

	}

	def "edit instance"() {

	}

	def "delete instance"() {
		
	}
	
}