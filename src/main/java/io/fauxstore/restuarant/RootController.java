package io.fauxstore.restuarant;

import io.fauxstore.restuarant.db.RestaurantsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RootController {
    private final RestaurantsRepository restaurantsRepo;

    @Autowired
    public RootController(RestaurantsRepository restaurantsRepo) {
        this.restaurantsRepo = restaurantsRepo;
    }

    @GetMapping("/")
    @ResponseBody
    String home() {
        return "Welcome to Restaurants service (maybe you wanted /restaurants)";
    }

    @GetMapping("/restaurants")
    List<Restaurant> restaurants() {
        final List<Restaurant> restaurants = restaurantsRepo.allRestaurants();
        return restaurants;
    }

    @GetMapping("/restaurants/{slug}/menu")
    RestaurantMenu restaurantMenu(@PathVariable("slug") String slug) {
        final List<MenuItem> menuItems = restaurantsRepo.restaurantMenu(slug);
        return RestaurantMenu.builder()
                .menuItems(menuItems)
            .build();
    }
}