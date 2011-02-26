grails.project.class.dir = "target/classes"
grails.project.test.class.dir = "target/test-classes"
grails.project.test.reports.dir = "target/test-reports"
//grails.project.war.file = "target/${appName}-${appVersion}.war"
grails.project.dependency.resolution = {
    inherits("global")
    log "warn"
    repositories {
        grailsPlugins()
        grailsHome()
        grailsCentral()
        mavenLocal()
        mavenCentral()
    }
    dependencies {
		test "org.seleniumhq.selenium:selenium-firefox-driver:latest.integration"
		test("org.seleniumhq.selenium:selenium-htmlunit-driver:latest.integration") {
			exclude "xml-apis"
		}
    }
}
