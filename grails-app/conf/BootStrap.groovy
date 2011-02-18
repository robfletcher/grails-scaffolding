import scaffolding.example.Book

class BootStrap {

	def fixtureLoader

	def init = { servletContext ->
		if (Book.count() == 0) {
			fixtureLoader.load("books")
		}
	}

	def destroy = {
	}
}
