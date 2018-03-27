package no.fint.model.resource;

import lombok.Data;
import no.fint.model.resource.Link;

import java.util.List;

@Data
public class CollectionLinks {
    private List<Link<String>> self;
}
