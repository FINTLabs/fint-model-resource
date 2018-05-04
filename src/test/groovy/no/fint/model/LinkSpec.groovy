package no.fint.model

import no.fint.model.resource.Link
import no.fint.model.resource.testutils.PersonResource
import no.fint.model.testutils.Person
import spock.lang.Specification

class LinkSpec extends Specification {

    def "Create Link with PersonResource placeholder"() {
        when:
        def link = Link.with(PersonResource, '/id')

        then:
        link.href == '${testutils.person}/id'
    }

    def "Create Link with Person placeholder"() {
        when:
        def link = Link.with(Person, '/id')

        then:
        link.href == '${testutils.person}/id'
    }

    def "Two links with same href are considered equal"() {
        when:
        def link1 = Link.with(Person, 'id', '123')
        def link2 = Link.with(Person, 'id', '123')

        then:

        link1.equals(link2)
        link2.equals(link1)
        link1.hashCode() == link2.hashCode()
    }
}
