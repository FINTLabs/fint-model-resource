package no.fint.model.resource;


import java.util.*;

public class FintCoreLinks {

    private final Map<String, List<Link>> links;

    public FintCoreLinks() {
        this.links = createLinks();
    }

    public Map<String, List<Link>> getLinks() {
        return links;
    }

    public Map<String, List<Link>> getLinksIfPresent() {
        if (links.isEmpty()) {
            return null;
        }
        return links;
    }

    public void setLinks(Map<String, List<Link>> links) {
        if (links != null) {
            this.links.putAll(links);
        }
    }

    public void addLink(String key, Link link) {
        links.computeIfAbsent(key, (k) -> new ArrayList<>()).add(link);
    }

    public Map<String, List<Link>> createLinks() {
        return Collections.synchronizedMap(new LinkedHashMap<>());
    }

}
