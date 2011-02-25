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
		$("dt", text: "Title").next("dd").text() == "Neuromancer"

		and: "null values are not displayed"
		$("dt", text: "Authors").empty
		$("dt", text: "Genre").empty
		$("dt", text: "Number Of Pages").empty
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
		$("dt", text: "Title").next("dd").text() == "Count Zero"
		$("dt", text: "Authors").next("dd").text() == "William Gibson"
		$("dt", text: "Genre").next("dd").text() == "scifi"
		$("dt", text: "Number Of Pages").next("dd").text() == "336"
	}

}
