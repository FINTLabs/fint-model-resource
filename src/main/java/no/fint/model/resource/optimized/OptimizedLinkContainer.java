package no.fint.model.resource.optimized;

import lombok.extern.slf4j.Slf4j;
import no.fint.model.resource.Link;

import java.util.*;
import java.util.stream.Collectors;

public class OptimizedLinkContainer implements LinkContainer {

    private final FintLinksConfiguration fintLinksConfiguration;

    private Map<String, List<OptimizedLink>> links = new HashMap<>();

    public OptimizedLinkContainer(Map<String, List<Link>> nativeLinks, FintLinksConfiguration configuration) {
        this.fintLinksConfiguration = configuration;

        setLinks(nativeLinks, configuration);
    }

    private void setLinks(Map<String, List<Link>> nativeLinks, FintLinksConfiguration configuration) {
        nativeLinks.forEach((key, value) -> {
            List<OptimizedLink> optimizedLinks = toOptimized(value, configuration);
            links.computeIfAbsent(key, k -> new ArrayList<>()).addAll(optimizedLinks);
        });
    }

    private List<OptimizedLink> toOptimized(List<Link> nativeLink, FintLinksConfiguration configuration) {
        return Optional.ofNullable(nativeLink)
                .orElseGet(ArrayList::new)
                .stream()
                .map(fintLinksConfiguration::addLink)
                .collect(Collectors.toList());
    }

    @Override
    public Map<String, List<Link>> getLinks() {

        Map<String, List<Link>> nativeLinks = new HashMap<>();
         links.forEach((key, link) -> {
             List<Link> links = Optional.ofNullable(link)
                     .orElseGet(ArrayList::new)
                     .stream()
                     .map(fintLinksConfiguration::getLink)
                     .collect(Collectors.toList());

             nativeLinks.put(key, links);
         });

         return nativeLinks;
    }

    @Override
    public void setLinks(Map<String, List<Link>> links) {
        links.clear();
        setLinks(links, fintLinksConfiguration);
    }

    @Override
    public void addLink(String key, Link link) {
        OptimizedLink optimizedLink = fintLinksConfiguration.addLink(link);
        links.computeIfAbsent(key, k -> new ArrayList<>()).add(optimizedLink);
    }
}
