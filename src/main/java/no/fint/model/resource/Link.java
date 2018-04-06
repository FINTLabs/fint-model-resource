package no.fint.model.resource;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Link implements Serializable {
    @Getter
    private String href;

    public void setVerdi(String verdi) {
        href = verdi;
    }

    public static Link with(String verdi) {
        return new Link(verdi);
    }
}

