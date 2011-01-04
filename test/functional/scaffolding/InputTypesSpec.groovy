package scaffolding

import spock.lang.Unroll

class InputTypesSpec extends NoJavascriptSpec {

	@Unroll("the #input input is type #expectedType")
	def "appropriate input types are used"() {
		given:
		to BookCreatePage

		expect:
		$(input).@type == expectedType

		where:
		input            | expectedType
		"#title"         | "text"
		"#numberOfPages" | "number"
		"#ebook"         | "checkbox"
	}

	def "many-to-many input is rendered as a multiple select"() {
		given:
		to BookCreatePage

		expect:
		$("#authors").is("select")
		$("#authors").@multiple == "yes"
	}

}
