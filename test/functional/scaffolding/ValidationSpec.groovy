package scaffolding

import grails.plugin.geb.GebSpec

class ValidationSpec extends GebSpec {

	@Override
	String getBaseUrl() {
		super.getBaseUrl() ?: "http://localhost:8080/"
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
