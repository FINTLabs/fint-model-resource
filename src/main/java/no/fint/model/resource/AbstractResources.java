package no.fint.model.resource;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public abstract class AbstractResources implements FintLinks {
    @Getter
    protected final Map<String, List<Link>> links = Collections.synchronizedMap(new LinkedHashMap<>());

    public void addSelf(Link link) {
        addLink("self", link);
    }

    @JsonProperty("total_items")
    public abstract int getTotalItems();

}
