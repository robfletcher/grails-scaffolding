package scaffolding.example

class Cover {
	static belongsTo = Book
	String filename
	byte[] image
	
	String toString() {
		filename
	}

    static mapping = {
        image sqlType: "blob"
    }
}