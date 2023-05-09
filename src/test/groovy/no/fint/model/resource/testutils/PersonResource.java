package no.fint.model.resource.testutils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import no.fint.model.resource.FintLinks;
import no.fint.model.resource.Link;

import java.util.List;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonResource implements FintLinks {

    @Override
    public Map<String, List<Link>> getLinks() {
        return createLinks();
    }

    private String name;
}
