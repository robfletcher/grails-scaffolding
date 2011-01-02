package scaffolding

import grails.plugin.geb.GebSpec
import org.openqa.selenium.WebDriver
import org.openqa.selenium.firefox.*

abstract class NoJavascriptSpec extends GebSpec {

	@Override
	WebDriver createDriver() {
		def profile = new FirefoxProfile()
		profile.setPreference("javascript.enabled", false)
		new FirefoxDriver(profile)
	}

	@Override
	String getBaseUrl() {
		super.getBaseUrl() ?: "http://localhost:8080/"
	}

	def cleanupSpec() {
		browser.driver.close()
	}

}
