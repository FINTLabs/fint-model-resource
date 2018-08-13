package no.fint.model.resource;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.type.TypeReference;
import lombok.*;

import java.util.*;

@JsonIgnoreProperties(ignoreUnknown = true)
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public abstract class AbstractCollectionResources<T> {
    protected AbstractCollectionResources(Collection<T> input) {
        this();
        embedded.entries.addAll(input);
    }

    @JsonProperty("_embedded")
    protected EmbeddedResources<T> embedded = new EmbeddedResources<>();

    @Getter
    @JsonProperty("_links")
    protected final Map<String, List<Link>> links = new LinkedHashMap<>();

    @JsonProperty("total_items")
    public int getTotalItems() {
        return embedded.entries.size();
    }

    public void addResource(T resource) {
        embedded.entries.add(resource);
    }

    protected void addLink(String key, Link link) {
        getLinks().computeIfAbsent(key, (k) -> new ArrayList<>()).add(link);
    }

    public void addSelf(Link link) {
        addLink("self", link);
    }

    @JsonIgnore
    public List<Link> getSelfLinks() {
        return links.get("self");
    }

    @JsonIgnore
    public List<T> getContent() {
        return embedded.entries;
    }

    @Deprecated
    @JsonIgnore
    public abstract TypeReference<List<T>> getTypeReference();

    @Data
    @NoArgsConstructor
    public static class EmbeddedResources<T> {
        @JsonProperty("_entries")
        public List<T> entries = new ArrayList<>();
    }
}
