package no.fint.model.resource

import no.fint.model.resource.testutils.PersonResource
import spock.lang.Specification

class FintLinksSpec extends Specification {
    PersonResource personResource

    void setup() {
        personResource = new PersonResource()
    }

    def "Return null if links is empty"() {
        when:
        def links = personResource.getLinksIfPresent()

        then:
        links == null
    }

    def "Return values if links is not empty"() {
        when:
        personResource.setLinks(['test': []])
        def links = personResource.getLinksIfPresent()

        then:
        links.size() == 1
        links.keySet()[0] == 'test'
    }

    def "Add link"() {
        when:
        personResource.addLink('test', Link.with('http://localhost:123'))
        personResource.addLink('test', Link.with('http://localhost:234'))
        def links = personResource.links

        then:
        links.size() == 1
        links.keySet()[0] == 'test'
        links['test'].size() == 2
    }
}
