package scaffolding

import scaffolding.pages.BookCreatePage
import spock.lang.Unroll

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
		$("#authors").@multiple == "yes"
	}

}
