package scaffolding

import grails.util.*
import spock.lang.*

class InputTypesSpec extends NoJavascriptSpec {

	def setup() {
		go "/thing/create"
	}
	
	@Unroll("the #input input is type #expectedType")
	def "appropriate input types are used"() {
		expect:
		$(input).is("input")
		$(input).@type == expectedType

		where:
		input       | expectedType
		"#name"     | "text"
		"#email"    | "email"
		"#website"  | "url"
		"#password" | "password"
		"#number"   | "number"
		"#file"     | "file"
		"#aBoolean" | "checkbox"
	}
	
	@Unroll("the #input input is a #expectedType")
	def "appropriate input tags are used"() {
		expect:
		$(input).is(expectedType)

		where:
		input               | expectedType
		"#longText"         | "textarea"
		"#optionalLongText" | "textarea"
	}
	
	@Unroll("#input is a select with the options #options")
	def "select inputs have the correct options"() {
		expect:
		$(input).is("select")
		$(input).find("option")*.text() == options
		
		where:
		input                 | options
		"#inListText"         | ["catflap", "rubberplant", "marzipan"]
		"#optionalInListText" | ["", "catflap", "rubberplant", "marzipan"]
		"#numberInRange"      | ["1", "2", "3", "4", "5"]
		"#numberInList"       | ["1", "2", "3", "5"]
		"#anEnum"             | Environment.values()*.toString()
		"#optionalEnum"       | [""] + Environment.values()*.toString()
	}
	
	@Unroll("the #input input has #attribute='#value'")
	def "inputs have correct attributes"() {
		expect:
		$(input).@"$attribute" == value
		
		where:
		input                  | attribute   | value
		"#name"                | "maxlength" | "40"
		"#textWithMatches"     | "pattern"   | /\w+/
		"#numberWithMin"       | "min"       | "0"
		"#numberWithMax"       | "max"       | "10"
		"#numberWithMinAndMax" | "min"       | "1"
		"#numberWithMinAndMax" | "max"       | "100"
	}
	
	@Unroll("the #input input has the #attribute attribute")
	def "inputs have correct boolean attributes"() {
		expect:
		!($(input).@"$attribute" in [null, "", false, "false"]) // drivers handle boolean attributes differently
		
		and:
		$(input).parent().hasClass("required")
		
		where:
		input            | attribute
		"#name"          | "required"
		"#email"         | "required"
		"#inListText"    | "required"
		"#number"        | "required"
		"#numberInRange" | "required"
		"#numberInList"  | "required"
		"#anEnum"        | "required"
	}
	
	@Unroll("the #input input does not have the #attribute attribute")
	def "inputs do not have inappropriate boolean attributes"() {
		expect:
		$(input).@"$attribute" in [null, "", false, "false"] // drivers handle boolean attributes differently
		
		and:
		!$(input).parent().hasClass("required")
		
		where:
		input                 | attribute
		"#optionalText"       | "required"
		"#website"            | "required"
		"#optionalInListText" | "required"
		"#file"               | "required"
		"#optionalNumber"     | "required"
		"#aBoolean"           | "required"
		"#optionalEnum"       | "required"
	}
}
