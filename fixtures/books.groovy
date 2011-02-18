import scaffolding.example.Book
import static scaffolding.example.Genre.*

include "authors"

fixture {

	neuromancer(Book) {
		title = "Neuromancer"
		authors = [ref("williamGibson")]
		yearOfPublication = "1984"
		averageRating = 5
		numberOfPages = 320
		ebook = false
		genre = scifi
	}

	countZero(Book) {
		title = "Count Zero"
		authors = [ref("williamGibson")]
		yearOfPublication = "1986"
		averageRating = 4
		numberOfPages = 336
		ebook = false
		genre = scifi
	}

	monaLisa(Book) {
		title = "Mona Lisa Overdrive"
		authors = [ref("williamGibson")]
		yearOfPublication = "1988"
		averageRating = 3
		numberOfPages = 320
		ebook = false
		genre = scifi
	}

	burningChrome(Book) {
		title = "Burning Chrome"
		authors = [ref("williamGibson")]
		yearOfPublication = "1986"
		averageRating = 4
		numberOfPages = 224
		ebook = false
		genre = scifi
	}

	differenceEngine(Book) {
		title = "The Difference Engine"
		authors = [ref("williamGibson"), ref("bruceSterling")]
		yearOfPublication = "1990"
		averageRating = 3
		numberOfPages = 400
		ebook = false
		genre = scifi
	}

	virtualLight(Book) {
		title = "Virtual Light"
		authors = [ref("williamGibson")]
		yearOfPublication = "1993"
		averageRating = 4
		numberOfPages = 304
		ebook = false
		genre = scifi
	}

	idoru(Book) {
		title = "Idoru"
		authors = [ref("williamGibson")]
		yearOfPublication = "1997"
		averageRating = 3
		numberOfPages = 304
		ebook = false
		genre = scifi
	}

	allTomorrowsParties(Book) {
		title = "All Tomorrow's Parties"
		authors = [ref("williamGibson")]
		yearOfPublication = "1999"
		averageRating = 4
		numberOfPages = 288
		ebook = false
		genre = scifi
	}

	patternRecognition(Book) {
		title = "Pattern Recognition"
		authors = [ref("williamGibson")]
		yearOfPublication = "2003"
		averageRating = 4
		numberOfPages = 368
		ebook = false
		genre = fiction
	}

	spookCountry(Book) {
		title = "Spook Country"
		authors = [ref("williamGibson")]
		yearOfPublication = "2007"
		averageRating = 3
		numberOfPages = 384
		ebook = false
		genre = fiction
	}

	zeroHistory(Book) {
		title = "Zero History"
		authors = [ref("williamGibson")]
		yearOfPublication = "2010"
		averageRating = 4
		numberOfPages = 416
		ebook = false
		genre = fiction
	}

}