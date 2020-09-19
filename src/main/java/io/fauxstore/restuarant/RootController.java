package io.fauxstore.restuarant;

import io.fauxstore.restuarant.db.RestaurantsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RootController {
    private final RestaurantsRepository restaurantsRepo;

    @Autowired
    public RootController(RestaurantsRepository restaurantsRepo) {
        this.restaurantsRepo = restaurantsRepo;
    }

    @RequestMapping("/")
    @ResponseBody
    String home() {
        return "Welcome to Restaurants service (maybe you wanted /restaurants)";
    }

    @RequestMapping("/restaurants")
    List<Restaurant> restaurants() {
        final List<Restaurant> restaurants = restaurantsRepo.allRestaurants();
        return restaurants;
    }
}
