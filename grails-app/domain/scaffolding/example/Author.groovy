package scaffolding.example

class Author {

	String name
	String email
	String website
	Date dateCreated
	Date lastUpdated

    static constraints = {
		name blank: false, unique: true
		email nullable: true, email: true
		website nullable: true, url: true
    }

	String toString() {
		name
	}
}
