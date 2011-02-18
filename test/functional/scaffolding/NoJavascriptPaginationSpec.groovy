package scaffolding

import scaffolding.pages.BookListPage
import spock.lang.Stepwise
import scaffolding.example.*

@Stepwise
class NoJavascriptPaginationSpec extends NoJavascriptSpec {

	def setupSpec() {
		Book.withNewSession {
			def author = new Author(name: "William Gibson").save(failOnError: true)
			new Book(title: "Neuromancer", authors: [author], yearOfPublication: "1984", averageRating: 5).save(failOnError: true)
			new Book(title: "Burning Chrome", authors: [author], yearOfPublication: "1986", averageRating: 3).save(failOnError: true)
			new Book(title: "Count Zero", authors: [author], yearOfPublication: "1986", averageRating: 4).save(failOnError: true)
			new Book(title: "Mona Lisa Overdrive", authors: [author], yearOfPublication: "1988", averageRating: 3).save(failOnError: true)
			new Book(title: "The Difference Engine", authors: [author], yearOfPublication: "1990", averageRating: 4).save(failOnError: true)
			new Book(title: "Virtual Light", authors: [author], yearOfPublication: "1993", averageRating: 5).save(failOnError: true)
			new Book(title: "Idoru", authors: [author], yearOfPublication: "1996", averageRating: 4).save(failOnError: true)
			new Book(title: "All Tomorrow's Parties", authors: [author], yearOfPublication: "1999", averageRating: 3).save(failOnError: true)
			new Book(title: "Pattern Recognition", authors: [author], yearOfPublication: "2003", averageRating: 5).save(failOnError: true)
			new Book(title: "Spook Country", authors: [author], yearOfPublication: "2007", averageRating: 4).save(failOnError: true)
			new Book(title: "Zero History", authors: [author], yearOfPublication: "2010", averageRating: 4).save(failOnError: true)
		}
	}

	def cleanupSpec() {
		Book.withNewSession {
			Book.list()*.delete()
			Author.list()*.delete()
		}
	}

	def "initial page displays 10 books"() {
		when:
		to BookListPage

		then:
		pagination.currentPage == 1
		books.size() == 10
	}

	def "clicking next goes to page 2"() {
		when:
		pagination.nextPage()

		then:
		pagination.currentPage == 2
		books.size() == 1
	}

	def "clicking browser back button returns to first page"() {
		when:
		driver.navigate().back()

		then:
		pagination.currentPage == 1
		books.size() == 10
	}

}
