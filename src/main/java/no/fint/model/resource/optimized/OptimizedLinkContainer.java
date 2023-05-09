package no.fint.model.resource.optimized;

import no.fint.model.resource.Link;

import java.util.List;
import java.util.Map;

public class OptimizedLinkContainer implements LinkContainer{

    private final FintLinksConfiguration fintLinksConfiguration;

    private Map<String, List<OptimizedLink>> links;

    public OptimizedLinkContainer(Map<String, List<Link>> links, FintLinksConfiguration configuration) {
        this.fintLinksConfiguration = configuration;

        // todo konvertere Link til OptimizeLinks
    }

    @Override
    public Map<String, List<Link>> getLinks() {
        return null;
    }

    @Override
    public void setLinks(Map<String, List<Link>> links) {

    }

    @Override
    public void addLink(String key, Link link) {

    }
}
