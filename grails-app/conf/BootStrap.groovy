import grails.util.GrailsUtil

class BootStrap {

	def fixtureLoader

	def init = { servletContext ->
		if (GrailsUtil.environment == "development") {
			fixtureLoader.load("books")
		}
	}

	def destroy = {
	}
}
