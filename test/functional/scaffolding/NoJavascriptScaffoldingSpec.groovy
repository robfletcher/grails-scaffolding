package scaffolding

import spock.lang.*
import grails.plugin.geb.*

@Stepwise
class NoJavascriptScaffoldingSpec extends GebSpec {

	@Override
	String getBaseUrl() {
		super.getBaseUrl() ?: "http://localhost:8080/"
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
		bookForm.title = "Neuromancer"
		bookForm.authors = ["William Gibson"]
		bookForm.yearOfPublication = "1984"
		
		and:
		createButton.click()
		
		then:
		at BookShowPage
		bookTitle == "Neuromancer"
		authors == ["William Gibson"]
		yearOfPublication == "1984"
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