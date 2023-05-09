package no.fint.model.resource.optimized;


import no.fint.model.resource.Link;

import java.util.*;

public class FintCoreLinks {

    private LinkContainer linkContainer;

    public FintCoreLinks()  {
         linkContainer = new NativeLinkContainer(createLinks());
    }

    public Map<String, List<Link>> getLinks() {
        return linkContainer.getLinks();
    }

    public Map<String, List<Link>> getLinksIfPresent() {
        if (linkContainer.getLinks().isEmpty()) {
            return null;
        }
        return linkContainer.getLinks();
    }

    public void setLinks(Map<String, List<Link>> links) {
        if (links != null) {
            linkContainer.setLinks(links);
        }
    }

    public void addLink(String key, Link link) {
        linkContainer.addLink(key, link);
    }

    public Map<String, List<Link>> createLinks() {
        return Collections.synchronizedMap(new LinkedHashMap<>());
    }
}
