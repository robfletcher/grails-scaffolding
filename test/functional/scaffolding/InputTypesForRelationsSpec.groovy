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
		$(input).is(expectedType)

		where:
		url                               | input      | expectedType
		"/book/create"                    | "#authors" | "select" // many-to-many
		"/format/create?book.id=$book.id" | "#book"    | "select" // many-to-one
	}
	
	def "no input is rendered for a one-to-many relationship"() {
		given: go "/book/create"
		expect: $("#formats").empty
	}
	
}