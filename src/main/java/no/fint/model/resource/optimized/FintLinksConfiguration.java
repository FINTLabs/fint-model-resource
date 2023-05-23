package no.fint.model.resource.optimized;

import lombok.Getter;
import no.fint.model.resource.Link;

import java.util.HashMap;
import java.util.Map;

public class FintLinksConfiguration {

    @Getter
    private final Map<Integer, String> prefixes;

    public FintLinksConfiguration() {
        this.prefixes = new HashMap<>();
    }

    public OptimizedLink addLink(Link link) {
        if (link == null || link.getHref() == null || link.getHref().isEmpty()) {
            return null;
        }

        int index = splitUrl(link.getHref());
        if (index == -1){
            return new OptimizedLink(-1, link.getHref());
        }
        String urlPrefix = link.getHref().substring(0, index);
        String urlSuffixId = link.getHref().substring(index);

        if (prefixes.containsValue(urlPrefix)) {
            Integer key = getKey(prefixes, urlPrefix);
            return new OptimizedLink(key.intValue(), urlSuffixId);
        } else {
            int key = prefixes.size();
            prefixes.put(key, urlPrefix);
            return new OptimizedLink(key, urlSuffixId);
        }
    }

    public Link getLink(OptimizedLink optimizedLink) {
        if (optimizedLink == null) return null;

        long fintLinksConfigurationId = optimizedLink.getFintLinksConfigurationId();
        String urlSuffixId = optimizedLink.getUrlSuffixId();
        String href = fintLinksConfigurationId < 0 ? urlSuffixId : prefixes.getOrDefault(fintLinksConfigurationId, "") + urlSuffixId;

        Link link = new Link();
        link.setVerdi(href);
        return link;
    }

    private int splitUrl(String href) {
        if (href == null || href.equals("")) return -1;
        if (!href.startsWith("https://")) return -1;
        if (!href.contains("felleskomponent.no")) return -1;
        return findNthOccurrence(href, '/', 7) + 1;
    }

    public int findNthOccurrence(String str, char c, int n) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == c) {
                count++;
                if (count == n) {
                    return i;
                }
            }
        }
        return -1; // returnerer -1 hvis det ikke finnes n-te forekomst
    }

    public static Integer getKey(Map<Integer, String> map, String value) {
        for (var entry : map.entrySet()) {
            if (entry.getValue().equals(value)) {
                return entry.getKey();
            }
        }
        return null;
    }
}
