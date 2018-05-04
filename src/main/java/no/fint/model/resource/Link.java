package no.fint.model.resource;

import lombok.*;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Link implements Serializable {
    @Getter
    private String href;

    public void setVerdi(String verdi) {
        href = verdi;
    }

    public static Link with(String verdi) {
        return new Link(verdi);
    }

    public static Link with(Class<?> placeholderClass, String... pathElements) {
        return with(placeholderClass, String.join("/", pathElements));
    }

    public static Link with(Class<?> placeholderClass, String path) {
        String placeholder = Link.getHrefPlaceholder(placeholderClass);
        path = path.replaceFirst("^/", "");
        return new Link(String.format("${%s}/%s", placeholder, path));
    }

    public static String getHrefPlaceholder(Class<?> placeholderClass) {
        return placeholderClass.getName()
                .replaceFirst("^no\\.fint\\.model(\\.resource)?\\.", "")
                .replaceFirst("Resource$", "")
                .toLowerCase();
    }
}

