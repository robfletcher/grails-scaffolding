package org.codehaus.groovy.grails.plugins.web.taglib

import grails.plugin.spock.TagLibSpec
import scaffolding.example.Book

class ScaffoldingTagLibSpec extends TagLibSpec {

	private static final NO_OUTPUT = "null" // mocked tag coerces null to a String

	def setup() {
		mockDomain Book
	}

    void "hasGlobalErrors only renders body if global errors are present"() {
		given:
		def bean = new Book()
		bean.errors.reject "epic.fail"

		expect:
		hasGlobalErrors(bean: bean) { "body" } == "body"
    }

    void "hasGlobalErrors does not render body if no errors present"() {
		given:
		def bean = new Book()

		expect:
		hasGlobalErrors(bean: bean) { "body" } == NO_OUTPUT
    }

    void "hasGlobalErrors does not render body if only field errors present"() {
		given:
		def bean = new Book()
		bean.errors.rejectValue "title", "fail"

		expect:
		hasGlobalErrors(bean: bean) { "body" } == NO_OUTPUT
    }
}
