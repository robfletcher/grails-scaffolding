package scaffolding

import scaffolding.example.Genre
import scaffolding.pages.BookCreatePage
import spock.lang.*
import scaffolding.pages.AuthorCreatePage

class InputTypesSpec extends NoJavascriptSpec {

	@Unroll("the #input input is type #expectedType")
	def "appropriate input types are used"() {
		given:
		to page

		expect:
		$(input).is("input")
		$(input).@type == expectedType

		where:
		page             | input            | expectedType
		BookCreatePage   | "#title"         | "text"
		BookCreatePage   | "#numberOfPages" | "number"
		BookCreatePage   | "#ebook"         | "checkbox"
		AuthorCreatePage | "#email"         | "email"
		AuthorCreatePage | "#website"       | "url"
	}

	@Ignore("only valid for webkit and opera")
	def "numeric properties with a range constraint are rendered as range inputs"() {
		given:
		to BookCreatePage

		expect:
		$("#averageRating").is("input")
		$("#averageRating").@type == "range"
		$("#averageRating").@min == "1"
		$("#averageRating").@max == "5"
	}

	def "many-to-many input is rendered as a multiple select"() {
		given:
		to BookCreatePage

		expect:
		$("#authors").is("select")
		$("#authors").@multiple == "multiple"
	}

	def "enum input is a select"() {
		given:
		to BookCreatePage

		expect:
		$("#genre").is("select")
		$("#genre option")*.@value == [""] + Genre.values()*.toString()
	}

	def "numeric input with a min constraint has a min attribute"() {
		given:
		to BookCreatePage

		expect:
		$("#numberOfPages").@min == "0"
	}

}
