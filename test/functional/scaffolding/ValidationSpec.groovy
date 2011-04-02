package scaffolding

import grails.plugin.geb.GebSpec
import scaffolding.pages.*

class ValidationSpec extends GebSpec {

	@Override
	String getBaseUrl() {
		super.getBaseUrl() ?: "http://localhost:8080/"
	}

	def "error messages are displayed for fields in error on a create page"() {
		given: "I visit the create book page"
		to BookCreatePage

		when: "I attempt to create a new book without completing any fields"
		disableAutomaticValidation()
		createButton.click()

		then: "I am returned to the create book page"
		at BookCreatePage

		and: "errors are not displayed in an alert dialog"
		errors == []

		and: "errors are displayed next to the fields themselves"
		hasError("title")
		errorTooltip("title") == "Property [title] of class [class scaffolding.example.Book] cannot be blank"
		hasError("yearOfPublication")
		errorTooltip("yearOfPublication") == "Property [yearOfPublication] of class [class scaffolding.example.Book] cannot be blank"
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
		disableAutomaticValidation()
		updateButton.click()

		then: "I am returned to the edit page"
		at BookEditPage

		and: "errors are displayed in an alert dialog"
		errors == [
			"Property [authors] of class [class scaffolding.example.Book] with value [[]] is less than the minimum size of [1]",
			"Property [title] of class [class scaffolding.example.Book] cannot be blank",
			"Property [yearOfPublication] of class [class scaffolding.example.Book] cannot be blank"
		]

		and: "errors are displayed next to the fields themselves"
		hasError("title")
		hasError("yearOfPublication")

		cleanup:
		withConfirm {
			deleteButton.click()
		}
	}

}
