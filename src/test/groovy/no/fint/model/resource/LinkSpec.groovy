package no.fint.model.resource

import no.fint.model.resource.testutils.PersonResource
import spock.lang.Specification

class LinkSpec extends Specification {

    def "Create Link with placeholder"() {
        when:
        def link = Link.with(PersonResource, '/id')

        then:
        link.href == '${resource.testutils.person}/id'
    }
}
