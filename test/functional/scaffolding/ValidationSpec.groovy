package scaffolding

import grails.plugin.geb.GebSpec

class ValidationSpec extends GebSpec {

	@Override
	String getBaseUrl() {
		super.getBaseUrl() ?: "http://localhost:8080/"
	}

	def "mandatory indicators are displayed on create page"() {
		given:
		to BookCreatePage

		expect:
		isRequired("title")
		!isRequired("authors")
		isRequired("yearOfPublication")
	}

	def "mandatory indicators are displayed on edit page"() {
		given:
		to BookCreatePage
		book.title = "Neuromancer"
		book.yearOfPublication = "1984"
		createButton.click()
		editButton.click()

		expect:
		at BookEditPage
		isRequired("title")
		!isRequired("authors")
		isRequired("yearOfPublication")

		cleanup:
		withConfirm {
			deleteButton.click()
		}
	}

	def "error messages displayed for fields in error"() {
		given:
		to BookCreatePage

		when:
		createButton.click()

		then:
		at BookCreatePage

		and:
		errors == [
				"Property [title] of class [class scaffolding.example.Book] cannot be blank",
				"Property [yearOfPublication] of class [class scaffolding.example.Book] cannot be blank"
		]

		and:
		hasError("title")
		hasError("yearOfPublication")
	}

}
