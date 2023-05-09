package no.fint.model.resource.testutils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import no.fint.model.resource.FintLinks;
import no.fint.model.resource.Link;

import java.util.List;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonResource implements FintLinks {

    private Map<String, List<Link>> links = createLinks();

    @Override
    public Map<String, List<Link>> getLinks() {
        return links;
    }

    private String name;
}
