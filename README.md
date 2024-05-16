# fint-model-resource

FINT Resource Model contains the core classes for FINT data models containing HATEOAS relations.

## Usage

FINT Resource classes all implement `FintLinks`, and from this base interface you can get any FINT resource's `self` link using
`getSelfLinks()`, and any links to other resources using `getLinks()`. 

This base interface also has methods for producing links.  The `addSelf(Link)` can be used to add a `self` link - this is typically
done by the FINT API itself.

To add links to other resources, FINT resource classes contain `addXXX(Link)` methods for producing specific links, but the base 
interface contains `addLink(String, Link)` that can be used as well.

Links are URIs, typically https URIs.  The `Link` class has a static `Link.with(String)` that can be used if the full URI to the
target is known.

## Robust links

Full https URIs are sensitive to changes in the FINT API deployment configuration.  To ensure that links are robust,
the FINT APIs also support convenience methods that enables implementors to generate links when the target Java class is known.
In these cases the methods `Link.with(Class, String...)` or `Link.with(Class, String)` come in handy.  The first argument is the
Java class of the target resource, so to link to a `Person` you use `Link.with(Person.class, ...)`.

The second parameter(s) are the path element that specify the identifier for the target.  They are typically built using two fields,
the name of  the identifier field, and the identifier value.  To produce a link to a `Person` with a `fodselsnummer` of `12345678901`,
this becomes:

```java
Link linktoPerson = Link.with(Person.class, "fodselsnummer", "12345678901");
```

