package no.fint.model.resource.optimized;

import lombok.Getter;

public class OptimizedLink {

    @Getter
    private int fintLinksConfigurationId;

    @Getter
    private String urlSuffixId;

    public OptimizedLink(int fintLinksConfigurationId, String urlSuffixId) {
        this.fintLinksConfigurationId = fintLinksConfigurationId;
        this.urlSuffixId = urlSuffixId;
    }
}
