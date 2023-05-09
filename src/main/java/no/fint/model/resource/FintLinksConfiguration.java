package no.fint.model.resource;

import java.util.HashMap;
import java.util.Map;

public class FintLinksConfiguration {

    private final Map<Integer, String> links;

    public FintLinksConfiguration() {
        this.links = new HashMap<>();
    }

    public OptimizedLink addLink(Link link) {
        // Sjekk if null
        // Sjekk om den finnes
        // Splitt id verdi fra href
        return null;
    }

}
