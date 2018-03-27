package no.fint.model.resource;

import com.fasterxml.jackson.annotation.JsonAnyGetter;

import java.util.*;

public abstract class AbstractLinks {
    private Map<String, List<Link<?>>> customLinks = Collections.synchronizedMap(new LinkedHashMap<>());

    @JsonAnyGetter
    public Map<String, List<Link<?>>> getCustomLinks() {
        return customLinks;
    }

    public boolean containsCustomLinks() {
        return customLinks.size() > 0;
    }

    public void addRelasjon(String key, Link<?> link) {
        customLinks.computeIfAbsent(key, (k) -> new ArrayList<>()).add(link);
    }
}
