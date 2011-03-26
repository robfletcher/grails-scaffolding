package scaffolding

import grails.util.*
import scaffolding.example.*
import spock.lang.*

class InputValuesSpec extends NoJavascriptSpec {

	@Shared Thing thingInstance = new Thing(
		name: "whatever",
		optionalText: "whatever",
		email: "whoever@whatever.com",
		website: "http://whatever.com/",
		password: "whatever",
		longText: "whatever",
		optionalLongText: "whatever",
		number: 5,
		optionalNumber: 5,
		numberWithMin: 5,
		numberWithMax: 5,
		numberWithMinAndMax: 5,
		inListText: "rubberplant",
		optionalInListText: "rubberplant",
		numberInRange: 5,
		numberInList: 5,
		anEnum: Environment.DEVELOPMENT,
		optionalEnum: Environment.DEVELOPMENT
	)

	def setupSpec() {
		Thing.withNewSession {
			thingInstance.save(failOnError: true, flush: true)
		}
	}
	
	def cleanupSpec() {
		Thing.withNewSession {
			thingInstance.delete(flush: true)
		}
	}
	
	def setup() {
		go "/thing/edit/$thingInstance.id"
	}
	
	@Unroll("the value of the #input input should be '#value'")
	def "text input values"() {
		expect:
		$(input).value() == value as String
		
		where:
		input            | value
		"#name"          | thingInstance.name
		"#email"         | thingInstance.email
		"#website"       | thingInstance.website
		"#password"      | thingInstance.password
		"#longText"      | thingInstance.longText
		"#number"        | thingInstance.number
		"#inListText"    | thingInstance.inListText
		"#numberInRange" | thingInstance.numberInRange
		"#numberInList"  | thingInstance.numberInList
		"#anEnum"        | thingInstance.anEnum
	}
	
}