import scaffolding.example.Book
import grails.util.GrailsUtil

class BootStrap {

	def fixtureLoader

	def init = { servletContext ->
//		if (GrailsUtil.environment != "test" && Book.count() == 0) {
//			fixtureLoader.load("books")
//		}
	}

	def destroy = {
	}
}
