grails.servlet.version = "3.0"
grails.project.class.dir = "target/classes"
grails.project.test.class.dir = "target/test-classes"
grails.project.test.reports.dir = "target/test-reports"
grails.project.target.level = 1.6
grails.project.source.level = 1.6

grails.project.dependency.resolution = {

    inherits("global") {

    }
    log "error"
    checksums true
    legacyResolve false

    repositories {
        inherits true

        grailsPlugins()
        grailsHome()
        grailsCentral()

        mavenLocal()
        mavenCentral()

        mavenRepo 'http://artifactory.milesburton.com/artifactory/remote-repos'
        mavenRepo 'http://artifactory.milesburton.com/artifactory/public'
        mavenRepo 'http://oss.sonatype.org/content/repositories/snapshots/'
    }

    def gebVersion = "0.9.0"
    def seleniumVersion = "2.21.0"

    dependencies {

        compile 'joda-time:joda-time:2.0',
                'com.popcornteam:restclient:1.0.130113.1729'


        test("org.seleniumhq.selenium:selenium-htmlunit-driver:$seleniumVersion") {
            exclude "xml-apis"
        }

        test "org.seleniumhq.selenium:selenium-chrome-driver:$seleniumVersion",
                "org.seleniumhq.selenium:selenium-firefox-driver:$seleniumVersion",
                "org.spockframework:spock-grails-support:0.7-groovy-2.0",
                "org.gebish:geb-spock:$gebVersion",
                'org.objenesis:objenesis:1.2',
                'cglib:cglib:3.0'


    }

    plugins {

        runtime ":jquery:1.8.0"
        runtime ":resources:1.1.6"
        runtime ":cors:1.0.3"

        build ":tomcat:$grailsVersion"

        compile ':cache:1.0.0'
        compile ":cache-headers:1.1.5"

        test(":spock:0.7") {
            exclude "spock-grails-support"
        }

        test ":geb:$gebVersion"
    }
}
