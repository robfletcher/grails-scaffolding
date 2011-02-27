package scaffolding.example

class Book {

	String title
	List<Author> authors
	String yearOfPublication
	Integer averageRating
	Integer numberOfPages
	Genre genre
	boolean ebook
	// date field
	Date dateCreated
	Date lastUpdated

	static hasMany = [authors: Author]

    static constraints = {
		title blank: false
		authors minSize: 1
		yearOfPublication blank: false, matches: /\d{4}/
		averageRating range: 1..5
		numberOfPages nullable: true, min: 0
		genre nullable: true
		ebook()
    }

	static mapping = {
		sort yearOfPublication: "desc"
	}

	String toString() {
		title
	}
}

enum Genre {
	biography, crime, fiction, reference, scifi, comic, nonFiction
}