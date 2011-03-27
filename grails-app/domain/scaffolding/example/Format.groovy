package scaffolding.example

class Format {
	static belongsTo = [book: Book]
	FormatType type
	float price
	
	static constraints = {
		price scale: 2
	}
	
	String toString() {
		"$type: £$price"
	}
}

enum FormatType {
	hardback, paperback, kindle
}