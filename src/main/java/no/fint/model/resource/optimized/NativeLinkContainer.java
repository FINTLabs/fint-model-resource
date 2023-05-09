package no.fint.model.resource.optimized;

import no.fint.model.resource.Link;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class NativeLinkContainer implements LinkContainer {

    private final Map<String, List<Link>> links;

    public NativeLinkContainer(Map<String, List<Link>> links) {
        this.links = links;
    }

    @Override
    public Map<String, List<Link>> getLinks() {
        return links;
    }

    @Override
    public void setLinks(Map<String, List<Link>> links) {
        this.links.putAll(links);
    }

    @Override
    public void addLink(String key, Link link) {
        links.computeIfAbsent(key, (k) -> new ArrayList<>()).add(link);
    }
}
