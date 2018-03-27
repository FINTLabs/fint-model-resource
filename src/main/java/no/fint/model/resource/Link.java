package no.fint.model.resource;

import lombok.Getter;
import lombok.ToString;

@ToString
public class Link<T> {
    @Getter
    private String href;

    public void setVerdi(String verdi) {
        href = verdi;
    }
}

