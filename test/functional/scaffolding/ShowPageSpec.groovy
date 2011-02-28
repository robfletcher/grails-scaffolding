package scaffolding

import scaffolding.example.*
import static scaffolding.example.Genre.scifi

class ShowPageSpec extends NoJavascriptSpec {

	def cleanupSpec() {
		Book.withNewSession {
			Book.list()*.delete()
			Author.list()*.delete()
		}
	}

	def "null and blank values are not displayed in show pages"() {
		given: "a domain instance with some blank fields"
		def book = Book.withNewSession {
			new Book(title: "Neuromancer", yearOfPublication: "1984", averageRating: 5).save(failOnError: true)
		}

		when: "I visit the show book page"
		go "/book/show/$book.id"

		then: "non-null values are displayed"
		$("#title-label").next(".property-value").text() == "Neuromancer"

		and: "null values are not displayed"
		$("#authors-label").empty
		$("#genre-label").empty
		$("#numberOfPages-label").empty
	}

	def "fields are displayed when they have values"() {
		given: "a domain instance with some blank fields"
		def book = Book.withNewSession {
			def author = new Author(name: "William Gibson")
			new Book(title: "Count Zero", authors: [author], yearOfPublication: "1986", averageRating: 4, genre: scifi, numberOfPages: 336).save(failOnError: true)
		}

		when: "I visit the show book page"
		go "/book/show/$book.id"

		then: "non-null values are displayed"
		$("#title-label").next(".property-value").text() == "Count Zero"
		$("#authors-label").next(".property-value").text() == "William Gibson"
		$("#genre-label").next(".property-value").text() == "scifi"
		$("#numberOfPages-label").next(".property-value").text() == "336"
	}

}
