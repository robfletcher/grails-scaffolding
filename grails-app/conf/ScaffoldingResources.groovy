modules = {
	
	// an AJAX loading indicator
	"grails.ajax.loader" {
		defaultBundle "scaffolding"
		dependsOn "modernizr", "jquery"
		resource "js/grails.ajaxloader.js"
		resource "js/grails.ajaxloader.loader.js"
		resource "css/grails.ajaxloader.css"
	}
	
	// an autocomplete control to replace multiple-select inputs for one-to-many and many-to-many relationships
	"grails.autocomplete" {
		defaultBundle "scaffolding"
		dependsOn "modernizr", "jquery"
		resource "js/grails.autocomplete.js"
		resource "js/grails.autocomplete.loader.js"
		resource "css/grails.autocomplete.css"
	}
	
	// AJAX-enables scaffolded list pages
	"grails.list" {
		defaultBundle "scaffolding"
		dependsOn "modernizr", "jquery"
		resource "js/grails.list.js"
		resource "js/grails.list.loader.js"
	}
	
	// uses native range inputs instead of selects in browsers that support them
	"grails.range" {
		defaultBundle "scaffolding"
		dependsOn "modernizr", "jquery"
		resource "js/grails.range.js"
		resource "js/grails.range.loader.js"
		resource "css/grails.range.css"
	}
	
	// replaces standard error messages with tooltips attached to each individual field
	"grails.errors" {
		defaultBundle "scaffolding"
		dependsOn "modernizr", "jquery"
		resource "js/grails.errors.js"
		resource "js/grails.errors.loader.js"
		resource "css/grails.errors.css"
	}
	
	// replaces flash and error messages with a fade-out message
	"grails.alerts" {
		defaultBundle "scaffolding"
		dependsOn "modernizr", "jquery"
		resource "js/grails.alerts.js"
		resource "js/grails.alerts.loader.js"
		resource "css/grails.alerts.css"
	}
	
	// some basic form enhancements
	"grails.forms" {
		defaultBundle "scaffolding"
		dependsOn "modernizr", "jquery"
		resource "js/grails.forms.js"
	}
	
	// prevents FOUC by fading body in after document load is complete
	"grails.fouc" {
		defaultBundle "scaffolding"
		dependsOn "modernizr", "jquery"
		resource "js/grails.fouc.js"
		resource "css/grails.fouc.css"
	}
	
	// top-level module that pulls in everything else
    "scaffolding" {
		defaultBundle "scaffolding"
		dependsOn "grails.ajax.loader", "grails.autocomplete", "grails.list", "grails.range", "grails.errors", "grails.alerts", "grails.forms", "grails.fouc"
	}
	
}