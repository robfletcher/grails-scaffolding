package scaffolding.example

class Author {

	String name

    static constraints = {
		name blank: false, unique: true
    }

	String toString() {
		name
	}
}
