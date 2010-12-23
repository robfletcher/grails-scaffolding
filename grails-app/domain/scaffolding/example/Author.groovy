package scaffolding.example

class Author {

	String name
	Date dateCreated
	Date lastUpdated

    static constraints = {
		name blank: false, unique: true
    }

	String toString() {
		name
	}
}
