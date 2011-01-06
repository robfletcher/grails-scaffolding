package scaffolding

import scaffolding.example.Genre
import scaffolding.pages.BookCreatePage
import spock.lang.*

class InputTypesSpec extends NoJavascriptSpec {

	@Unroll("the #input input is type #expectedType")
	def "appropriate input types are used"() {
		given:
		to BookCreatePage

		expect:
		$(input).is("input")
		$(input).@type == expectedType

		where:
		input            | expectedType
		"#title"         | "text"
		"#numberOfPages" | "number"
		"#ebook"         | "checkbox"
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

}
