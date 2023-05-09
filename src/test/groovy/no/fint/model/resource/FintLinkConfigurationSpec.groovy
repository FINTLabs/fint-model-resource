package no.fint.model.resource

import no.fint.model.resource.optimized.FintLinksConfiguration
import spock.lang.Specification

class FintLinkConfigurationSpec extends Specification{
    FintLinksConfiguration splitter = new FintLinksConfiguration()

    def "splitUrl returns correct index when URL is valid"() {
        given:
        String url = "https://api.felleskomponent.no/utdanning/elev/person/fodselsnummer/12345612345"

        expect:
        splitter.splitUrl(url) == 66
    }

    def "splitUrl returns correct index when URL is too short"() {
        given:
        String url = "https://api.felleskomponent.no/utdanning/elev/person/fodselsnummer"

        expect:
        splitter.splitUrl(url) == -1
    }

    def "splitUrl returns -1 when URL is null"() {
        given:
        String url = null

        expect:
        splitter.splitUrl(url) == -1
    }

    def "splitUrl returns -1 when URL is empty string"() {
        given:
        String url = ""

        expect:
        splitter.splitUrl(url) == -1
    }

    def "splitUrl returns -1 when URL does not start with https://"() {
        given:
        String url = "http://api.felleskomponent.no/utdanning/elev/person/fodselsnummer/12345612345"

        expect:
        splitter.splitUrl(url) == -1
    }

    def "splitUrl returns -1 when URL does not contain felleskomponent.no"() {
        given:
        String url = "https://api.example.com/utdanning/elev/person/fodselsnummer/12345612345"

        expect:
        splitter.splitUrl(url) == -1
    }
}
