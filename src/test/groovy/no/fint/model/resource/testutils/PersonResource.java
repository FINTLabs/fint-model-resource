package no.fint.model.resource.testutils;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.*;
import no.fint.model.resource.FintLinks;
import no.fint.model.resource.Link;

import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
public class PersonResource implements FintLinks {

    private String name;

    // Default constructor
    public PersonResource() {
    }

    public PersonResource(String name) {
        this.name = name;
    }

    private Map<String, List<Link>> links = createLinks();

    @Override
    public Map<String, List<Link>> getLinks() {
        return links;
    }


}
