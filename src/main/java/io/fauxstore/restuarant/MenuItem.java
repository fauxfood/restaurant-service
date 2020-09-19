package io.fauxstore.restuarant;

import lombok.Builder;
import lombok.Value;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.UUID;

@Value
@Builder
public class MenuItem {
    private final UUID id;
    private final String name;
    private final String description;
    private final BigDecimal price;
}
