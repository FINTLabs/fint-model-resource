package no.fint.model.resource;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public interface FintLinks {
    List<List<? extends Link>> getLinkLists();
    default Map<String, List<Link<?>>> getCustomLinks() {
        return new LinkedHashMap<>();
    }
}
