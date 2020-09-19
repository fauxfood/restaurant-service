package io.fauxstore.restuarant;

import lombok.Builder;
import lombok.Value;

import java.util.List;

@Value
@Builder
public class RestaurantMenu {
    List<MenuItem> menuItems;
}
