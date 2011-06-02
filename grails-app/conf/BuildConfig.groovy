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
//		test "org.seleniumhq.selenium:selenium-firefox-driver:latest.integration"
//		test("org.seleniumhq.selenium:selenium-htmlunit-driver:latest.integration") {
//			exclude "xml-apis"
//		}
    }
	plugins {
		compile ":enhanced-scaffolding:1.0"
		compile ":cache-headers:1.1.5"
		compile ":cached-resources:1.0"
		compile ":fixtures:1.0.7-SNAPSHOT"
		compile ":hibernate:$grailsVersion"
		compile ":jquery:1.6.1.1"
		compile ":jquery-ui:1.8.10.1"
		compile ":modernizr:1.7.2"
		compile ":resources:1.0"
		build ":cloud-foundry:1.0.0.M3"
		build ":tomcat:$grailsVersion"
//		test ":spock:0.6-SNAPSHOT"
		test ":geb:0.5.1"
	}
}
