package scaffolding

import grails.util.*
import spock.lang.*
import scaffolding.example.*

class InputTypesForRelationsSpec extends NoJavascriptSpec {
	
	@Shared Book book
	
	def setupSpec() {
		Book.withNewSession { session ->
			def author = new Author(name: "William Gibson").save(failOnError: true)
			book = new Book(title: "Zero History", authors: [author], yearOfPublication: "2010", averageRating: 4, numberOfPages: 416, genre: Genre.fiction)
			book.save(flush: true, failOnError: true)
		}
	}
	
	def cleanupSpec() {
		Book.withNewSession { session ->
			book.delete()
			book.authors*.delete()
			session.flush()
		}
	}
	
	def setup() {
		go "/thing/create"
	}
	
	@Unroll("the #input field on #url is a #expectedType")
	def "appropriate input types are used"() {
		given:
		go url
		
		expect:
		$(input).is("select")
		
		and:
		$(input).find("option")*.text() == options

		where:
		url                               | input      | options
		"/book/create"                    | "#authors" | ["William Gibson"] // many-to-many
		"/format/create?book.id=$book.id" | "#book"    | ["Zero History"]   // many-to-one
	}
	
	def "no input is rendered for a one-to-many relationship"() {
		given: go "/book/create"
		expect: $("#formats").empty
	}
	
	@Unroll("the #input input has the #attribute attribute")
	def "inputs have correct boolean attributes"() {
		given:
		go url
		
		expect:
		!($(input).@"$attribute" in [null, "", false, "false"]) // drivers handle boolean attributes differently
		
		and:
		$(input).parent().hasClass("required")
		
		where:
		url                               | input   | attribute
		"/format/create?book.id=$book.id" | "#book" | "required"
	}
	
	@Unroll("the #input input does not have the #attribute attribute")
	def "inputs do not have inappropriate boolean attributes"() {
		given:
		go url
		
		expect:
		$(input).@"$attribute" in [null, "", false, "false"] // drivers handle boolean attributes differently
		
		and:
		!$(input).parent().hasClass("required")
		
		where:
		url            | input   | attribute
		"/book/create" | "#book" | "required"
	}
}