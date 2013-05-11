grails.servlet.version = "2.5" // Change depending on target container compliance (2.5 or 3.0)
grails.project.class.dir = "target/classes"
grails.project.test.class.dir = "target/test-classes"
grails.project.test.reports.dir = "target/test-reports"
grails.project.target.level = 1.6
grails.project.source.level = 1.6
//grails.project.war.file = "target/${appName}-${appVersion}.war"

// uncomment (and adjust settings) to fork the JVM to isolate classpaths
//grails.project.fork = [
//   run: [maxMemory:1024, minMemory:64, debug:false, maxPerm:256]
//]

grails.project.dependency.resolution = {
    // inherit Grails' default dependencies
    inherits("global") {
        // specify dependency exclusions here; for example, uncomment this to disable ehcache:
        // excludes 'ehcache'
    }
    log "error" // log level of Ivy resolver, either 'error', 'warn', 'info', 'debug' or 'verbose'
    checksums true // Whether to verify checksums on resolve
    legacyResolve false // whether to do a secondary resolve on plugin installation, not advised and here for backwards compatibility


    repositories {
        inherits true // Whether to inherit repository definitions from plugins

        grailsPlugins()
        grailsHome()
        grailsCentral()

        mavenLocal()
        mavenCentral()

        mavenRepo 'http://artifactory.milesburton.com/artifactory/remote-repos'
        mavenRepo 'http://artifactory.milesburton.com/artifactory/public'
    }

    def gebVersion = "0.9.0-SNAPSHOT"
    def seleniumVersion = "2.21.0"

    dependencies {
        compile 'joda-time:joda-time:2.0',
                'com.popcornteam:restclient:1.0.130113.1729'


        test("org.seleniumhq.selenium:selenium-htmlunit-driver:$seleniumVersion") {
            exclude "xml-apis"
        }
        test("org.seleniumhq.selenium:selenium-chrome-driver:$seleniumVersion")
        test("org.seleniumhq.selenium:selenium-firefox-driver:$seleniumVersion")


        test "org.spockframework:spock-grails-support:0.7-groovy-2.0",
                "org.gebish:geb-spock:$gebVersion"

    }

    plugins {

        runtime ":jquery:1.8.0"
        runtime ":resources:1.1.6"
        runtime ":cors:1.0.3"

        // Uncomment these (or add new ones) to enable additional resources capabilities
        //runtime ":zipped-resources:1.0"
        //runtime ":cached-resources:1.0"
        //runtime ":yui-minify-resources:0.1.4"

        build ":tomcat:$grailsVersion"

        compile ':cache:1.0.0'
        compile ":cache-headers:1.1.5"

        test(":spock:0.7") {
            exclude "spock-grails-support"
        }

        test ":geb:$gebVersion"
    }
}
