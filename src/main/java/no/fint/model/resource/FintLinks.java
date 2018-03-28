package no.fint.model.resource;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface FintLinks {
    Map<String, List<Link>> getLinks();

    @JsonGetter("_links")
    default Map<String, List<Link>> getLinksIfPresent() {
        if (getLinks().isEmpty()) {
            return null;
        }
        return getLinks();
    }

    @JsonSetter("_links")
    default void setLinks(Map<String, List<Link>> links) {
        getLinks().putAll(links);
    }

    default void addLink(String key, Link link) {
        getLinks().computeIfAbsent(key, (k) -> new ArrayList<>()).add(link);
    }
}
