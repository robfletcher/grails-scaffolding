package org.codehaus.groovy.grails.plugins.web.taglib

class ScaffoldingTagLib {

	def hasGlobalErrors = { attrs, body ->
		def errorList = new ValidationTagLib().extractErrors(attrs)
		if (errorList.any { it.hasGlobalErrors() }) {
			out << body()
		}
	}

}
