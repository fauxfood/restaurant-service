package io.fauxstore.restuarant;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class Restaurant {
    private final String slug;
    private final String name;
}
