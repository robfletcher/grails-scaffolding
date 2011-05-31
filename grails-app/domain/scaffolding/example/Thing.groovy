package scaffolding.example

import grails.util.*

class Thing {
	
	static final int TEXTAREA_SIZE = 251

	// text inputs
	String name
	String optionalText
	String email
	String website
	String password
	String textWithMatches
	// textareas
	String longText
	String optionalLongText
	// numeric inputs
	Integer number
	Integer optionalNumber
	Integer numberWithMin
	Integer numberWithMax
	Integer numberWithMinAndMax
	// selects
	String inListText
	String optionalInListText
	Integer numberInRange
	Integer numberInList
	Environment anEnum
	Environment optionalEnum
	// checkbox
	boolean aBoolean
	// file
	byte[] file
	// embedded type
	Address address 
	
	static constraints = {
		name maxSize: 40, blank: false
		optionalText()
		email email: true, blank: false
		website url: true
		password password: true
		textWithMatches matches: /\w+/
		inListText inList: ["catflap", "rubberplant", "marzipan"], blank: false
		optionalInListText inList: ["catflap", "rubberplant", "marzipan"]
		longText maxSize: TEXTAREA_SIZE, blank: false
		optionalLongText maxSize: TEXTAREA_SIZE
		number()
		optionalNumber nullable: true
		numberInRange range: 1..5
		numberInList inList: [1, 2, 3, 5]
		numberWithMin min: 0
		numberWithMax max: 10
		numberWithMinAndMax min: 1, max: 100
		anEnum()
		optionalEnum nullable: true
		aBoolean()
		file nullable: true
		address nullable: true
	}
	
	static embedded = ["address"]
	
}
