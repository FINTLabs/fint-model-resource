package no.fint.model.resource.testutils;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import no.fint.model.resource.FintCoreLinks;
import no.fint.model.resource.FintLinks;
import no.fint.model.resource.Link;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Data
public class PersonResource implements FintLinks {

    private FintCoreLinks fintCoreLinks;

    @JsonProperty("name")
    private String name;

    public PersonResource() {
        fintCoreLinks = new FintCoreLinks();
    }

    public PersonResource(String name) {
        this();
        this.name = name;
    }

    public PersonResource(String name, Map<String, List<Link>> links) {
        this();
        this.name = name;
        fintCoreLinks.setLinks(links);
    }

    private Map<String, List<Link>> links = createLinks();

    @Override
    public Map<String, List<Link>> getLinksIfPresent() {
        return fintCoreLinks.getLinksIfPresent();
    }

    @Override
    public Map<String, List<Link>> getLinks() {
        return fintCoreLinks.getLinks();
    }

    @Override
    public void setLinks(Map<String, List<Link>> links) {
        fintCoreLinks.setLinks(links);
    }

    @Override
    public void addLink(String key, Link link) {
        fintCoreLinks.addLink(key, link);
    }

}
