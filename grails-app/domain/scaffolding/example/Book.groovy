package scaffolding.example

class Book {

	String title
	List<Author> authors
	// numeric field
	// boolean field
	// enum field
	// date field

	static hasMany = [authors: Author]

    static constraints = {
		title blank: false
		authors min: 1
    }

	String toString() {
		title
	}
}
