package scaffolding.example

class Address {
	String street
	String city
	String postCode
	
	static constraints = {
		street()
		city()
		postCode()
	}
}
