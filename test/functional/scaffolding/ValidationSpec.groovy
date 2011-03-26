package scaffolding

import grails.plugin.geb.GebSpec
import scaffolding.pages.*

class ValidationSpec extends GebSpec {

	@Override
	String getBaseUrl() {
		super.getBaseUrl() ?: "http://localhost:8080/"
	}

	def "mandatory indicators are displayed on create page"() {
		given: "I am on the create book page"
		to BookCreatePage

		expect: "mandatory fields are marked with a mandatory indicator"
		isRequired("title")
		isRequired("yearOfPublication")

		and: "non mandatory fields do not have a mandatory indicator"
		!isRequired("authors")

		and: "no mandatory indicator is displayed on a checkbox"
		!isRequired("ebook")
	}

	def "mandatory indicators are displayed on edit page"() {
		given: "I am on the edit page for n existing book"
		to BookCreatePage
		book.title = "Neuromancer"
		book.yearOfPublication = "1984"
		createButton.click()
		editButton.click()

		expect: "mandatory fields are marked with a mandatory indicator"
		at BookEditPage
		isRequired("title")
		isRequired("yearOfPublication")

		and: "non mandatory fields do not have a mandatory indicator"
		!isRequired("authors")

		and: "no mandatory indicator is displayed on a checkbox"
		!isRequired("ebook")

		cleanup:
		withConfirm {
			deleteButton.click()
		}
	}

	def "error messages are displayed for fields in error on a create page"() {
		given: "I visit the create book page"
		to BookCreatePage

		when: "I attempt to create a new book without completing any fields"
		createButton.click()

		then: "I am returned to the create book page"
		at BookCreatePage

		and: "errors are displayed in an alert dialog"
		errors == "Book could not be created. Please correct any errors and try again."

		and: "errors are displayed next to the fields themselves"
		hasError("title")
		errorFor("title") == "Property [title] of class [class scaffolding.example.Book] cannot be blank"
		hasError("yearOfPublication")
		errorFor("yearOfPublication") == "Property [yearOfPublication] of class [class scaffolding.example.Book] cannot be blank"
	}

	def "error messages are displayed for fields in error on an edit page"() {
		given: "I am on the edit page for n existing book"
		to BookCreatePage
		book.title = "Neuromancer"
		book.yearOfPublication = "1984"
		createButton.click()
		editButton.click()

		when: "I try to update the book with invalid data"
		book.title = ""
		book.yearOfPublication = ""
		updateButton.click()

		then: "I am returned to the edit page"
		at BookEditPage

		and: "errors are displayed in an alert dialog"
		errors ==~ /Book \d+ could not be created. Please correct any errors and try again./

		and: "errors are displayed next to the fields themselves"
		hasError("title")
		errorFor("title") == "Property [title] of class [class scaffolding.example.Book] cannot be blank"
		hasError("yearOfPublication")
		errorFor("yearOfPublication") == "Property [yearOfPublication] of class [class scaffolding.example.Book] cannot be blank"

		cleanup:
		withConfirm {
			deleteButton.click()
		}
	}

}
