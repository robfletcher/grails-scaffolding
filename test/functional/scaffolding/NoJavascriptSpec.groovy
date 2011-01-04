package scaffolding

import grails.plugin.geb.GebSpec
import org.openqa.selenium.WebDriver
import org.openqa.selenium.htmlunit.HtmlUnitDriver

abstract class NoJavascriptSpec extends GebSpec {

	@Override
	WebDriver createDriver() {
		def driver = new HtmlUnitDriver()
		driver.javascriptEnabled = false
		driver
	}

	@Override
	String getBaseUrl() {
		super.getBaseUrl() ?: "http://localhost:8080/"
	}

	def cleanupSpec() {
		browser.driver.close()
	}

}
