package no.fint.model.resource.optimized;

import no.fint.model.resource.Link;

import java.util.List;
import java.util.Map;

public interface LinkContainer {
    Map<String, List<Link>> getLinks();

    void setLinks(Map<String, List<Link>> links);

    void addLink(String key, Link link);
}
