import scaffolding.example.Book
import static scaffolding.example.Genre.*

include "authors"

fixture {

	neuromancer(Book) {
		title = "Neuromancer"
		authors = [ref("gibson")]
		yearOfPublication = "1984"
		averageRating = 5
		numberOfPages = 320
		ebook = false
		genre = scifi
	}

	countZero(Book) {
		title = "Count Zero"
		authors = [ref("gibson")]
		yearOfPublication = "1986"
		averageRating = 4
		numberOfPages = 336
		ebook = false
		genre = scifi
	}

	monaLisa(Book) {
		title = "Mona Lisa Overdrive"
		authors = [ref("gibson")]
		yearOfPublication = "1988"
		averageRating = 3
		numberOfPages = 320
		ebook = false
		genre = scifi
	}

	burningChrome(Book) {
		title = "Burning Chrome"
		authors = [ref("gibson")]
		yearOfPublication = "1986"
		averageRating = 4
		numberOfPages = 224
		ebook = false
		genre = scifi
	}

	differenceEngine(Book) {
		title = "The Difference Engine"
		authors = [ref("gibson"), ref("sterling")]
		yearOfPublication = "1990"
		averageRating = 3
		numberOfPages = 400
		ebook = false
		genre = scifi
	}

	virtualLight(Book) {
		title = "Virtual Light"
		authors = [ref("gibson")]
		yearOfPublication = "1993"
		averageRating = 4
		numberOfPages = 304
		ebook = false
		genre = scifi
	}

	idoru(Book) {
		title = "Idoru"
		authors = [ref("gibson")]
		yearOfPublication = "1997"
		averageRating = 3
		numberOfPages = 304
		ebook = false
		genre = scifi
	}

	allTomorrowsParties(Book) {
		title = "All Tomorrow's Parties"
		authors = [ref("gibson")]
		yearOfPublication = "1999"
		averageRating = 4
		numberOfPages = 288
		ebook = false
		genre = scifi
	}

	patternRecognition(Book) {
		title = "Pattern Recognition"
		authors = [ref("gibson")]
		yearOfPublication = "2003"
		averageRating = 4
		numberOfPages = 368
		ebook = false
		genre = fiction
	}

	spookCountry(Book) {
		title = "Spook Country"
		authors = [ref("gibson")]
		yearOfPublication = "2007"
		averageRating = 3
		numberOfPages = 384
		ebook = false
		genre = fiction
	}

	zeroHistory(Book) {
		title = "Zero History"
		authors = [ref("gibson")]
		yearOfPublication = "2010"
		averageRating = 4
		numberOfPages = 416
		ebook = false
		genre = fiction
	}

	dragonTattoo(Book) {
		title = "The Girl With The Dragon Tattoo"
		authors = [ref("larsson")]
		yearOfPublication = "2008"
		averageRating = 4
		numberOfPages = 542
		ebook = false
		genre = fiction
	}

	playedWithFire(Book) {
		title = "The Girl Who Played With Fire"
		authors = [ref("larsson")]
		yearOfPublication = "2009"
		averageRating = 4
		numberOfPages = 608
		ebook = false
		genre = fiction
	}

	hornetsNest(Book) {
		title = "The Girl Who Kicked The Hornets' Nest"
		authors = [ref("larsson")]
		yearOfPublication = "2010"
		averageRating = 4
		numberOfPages = 656
		ebook = false
		genre = fiction
	}
	
	watchmen(Book) {
		title = "Watchmen"
		authors = [ref("moore"), ref("gibbons")]
		yearOfPublication = "1987"
		averageRating = 5
		numberOfPages = 424
		ebook = false
		genre = comic
	}

	nineteenEightyFour(Book) {
		title = "Nineteen Eighty-four"
		authors = [ref("orwell")]
		yearOfPublication = "1948"
		averageRating = 5
		numberOfPages = 424
		ebook = false
		genre = fiction
	}

	fearAndLoathing(Book) {
		title = "Fear and Loathing in Las Vegas"
		authors = [ref("thompson")]
		yearOfPublication = "1972"
		averageRating = 5
		numberOfPages = 240
		ebook = false
		genre = biography
	}

	roadToSerfdom(Book) {
		title = "The Road to Serfdom"
		authors = [ref("hayek")]
		yearOfPublication = "1944"
		averageRating = 4
		numberOfPages = 272
		ebook = false
		genre = nonFiction
	}

	openSociety1(Book) {
		title = "The Open Society and Its Enemies: Volume 1: The Spell of Plato"
		authors = [ref("popper")]
		yearOfPublication = "1945"
		averageRating = 4
		numberOfPages = 432
		ebook = false
		genre = nonFiction
	}

	openSociety2(Book) {
		title = "The Open Society and Its Enemies: Volume 2: Hegel and Marx"
		authors = [ref("popper")]
		yearOfPublication = "1945"
		averageRating = 4
		numberOfPages = 480
		ebook = false
		genre = nonFiction
	}

	insteadOfABook(Book) {
		title = "Instead of a Book by a Man Too Busy to Write One"
		authors = [ref("tucker")]
		yearOfPublication = "1897"
		averageRating = 4
		numberOfPages = 507
		ebook = false
		genre = nonFiction
	}

	progressiveEnhancement(Book) {
		title = "Designing with Progressive Enhancement"
		authors = [ref("parker"), ref("jehl"), ref("wachs"), ref("toland")]
		yearOfPublication = "2010"
		averageRating = 5
		numberOfPages = 456
		ebook = true
		genre = nonFiction
	}

}