package no.fint.model.resource

import com.fasterxml.jackson.databind.ObjectMapper
import no.fint.model.resource.testutils.PersonResource
import no.fint.model.resource.testutils.PersonResources
import spock.lang.Specification

class AbstractCollectionResourcesSpec extends Specification {
    private PersonResources personResources

    void setup() {
        personResources = new PersonResources()
        personResources.addResource(new PersonResource('test1'))
        personResources.addResource(new PersonResource('test2'))
    }

    def "Get total_items"() {
        expect:
        personResources.totalItems == 2
    }

    def "Serialize and deserialize PersonResources and get content"() {
        given:
        def objectMapper = new ObjectMapper()

        when:
        def serialized = objectMapper.writeValueAsString(personResources)
        def deserialized = objectMapper.readValue(serialized, PersonResources)
        def personResources = deserialized.getContent()

        then:
        personResources.size() == 2
        personResources.collect { it.name }.containsAll(['test1', 'test2'])
    }
}
