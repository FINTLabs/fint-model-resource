package no.novari.model.resource.testutils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import no.novari.model.resource.FintLinks;
import no.novari.model.resource.Link;

import java.util.List;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonResource implements FintLinks {
    @Getter
    private final Map<String, List<Link>> links = createLinks();

    private String name;
}
