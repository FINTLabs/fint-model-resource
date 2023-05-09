package no.fint.model.resource.testutils;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import no.fint.model.resource.FintLinks;
import no.fint.model.resource.Link;

import java.util.List;
import java.util.Map;

@Data
public class PersonResource implements FintLinks {

    @JsonProperty("name")
    private String name;

    public PersonResource() {
    }

    public PersonResource(String name) {
        this.name = name;
    }

    public PersonResource(String name, Map<String, List<Link>> links) {
        this.name = name;
        this.links = links;
    }

    private Map<String, List<Link>> links = createLinks();

    @Override
    public Map<String, List<Link>> getLinks() {
        return links;
    }
}
