package no.fint.model.resource;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.type.TypeReference;
import lombok.*;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public abstract class AbstractCollectionResources<T> {
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

    @JsonIgnore
    public List<Link> getSelfLinks() {
        return links.get("self");
    }

    @JsonIgnore
    public List<T> getContent() {
        return embedded.entries;
    }

    @Deprecated
    public abstract TypeReference<List<T>> getTypeReference();

    @Data
    @NoArgsConstructor
    public static class EmbeddedResources<T> {
        @JsonProperty("_entries")
        public List<T> entries = new ArrayList<>();
    }
}
