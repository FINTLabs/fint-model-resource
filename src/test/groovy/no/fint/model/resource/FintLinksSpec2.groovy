package no.fint.model.resource

import no.fint.model.resource.testutils.PersonResource
import no.fint.model.testutils.Person

class FintLinksSpec2 {
    def "test getLinksIfPresent when links are empty"() {
        setup:
        FintLinks fintLinks = new PersonResource()

        when:
        Map<String, List<Link>> result = fintLinks.getLinksIfPresent()

        then:
        result == null
    }

    def "test getLinksIfPresent when links are not empty"() {
        setup:
        FintLinks fintLinks = new PersonResource()
        Link link = new Link("http://example.com")
        fintLinks.addLink("test", link)

        when:
        Map<String, List<Link>> result = fintLinks.getLinksIfPresent()

        then:
        result.size() == 1
        result.get("test").size() == 1
        result.get("test")[0] == link
    }

    def "test setLinks and addLink"() {
        setup:
        FintLinks fintLinks = new PersonResource()
        Map<String, List<Link>> links = new HashMap<>()
        Link link1 = new Link("http://example.com/1")
        Link link2 = new Link("http://example.com/2")
        links.put("test", [link1, link2])

        when:
        fintLinks.setLinks(links)
        fintLinks.addLink("test", new Link("http://example.com/3"))

        then:
        fintLinks.getLinks().size() == 1
        fintLinks.getLinks().get("test").size() == 3
    }

    def "test addSelf"() {
        setup:
        FintLinks fintLinks = new PersonResource()
        Link link = new Link("http://example.com")

        when:
        fintLinks.addSelf(link)

        then:
        fintLinks.getSelfLinks().size() == 1
        fintLinks.getSelfLinks()[0] == link
    }

    def "test getNestedResources"() {
        setup:
        FintLinks fintLinks = new PersonResource()

        when:
        List<FintLinks> nestedResources = fintLinks.getNestedResources()

        then:
        nestedResources.size() == 0
    }
}
