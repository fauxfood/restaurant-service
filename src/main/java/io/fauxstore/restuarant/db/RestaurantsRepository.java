package io.fauxstore.restuarant.db;

import io.fauxstore.restuarant.MenuItem;
import io.fauxstore.restuarant.Restaurant;
import io.honeycomb.beeline.spring.beans.aspects.ChildSpan;
import io.honeycomb.beeline.spring.beans.aspects.SpanField;
import io.honeycomb.beeline.tracing.Beeline;
import org.jdbi.v3.core.Jdbi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantsRepository {
    private final Jdbi jdbi;
    private final Beeline beeline;


    @Autowired
    public RestaurantsRepository(Jdbi jdbi, Beeline beeline) {
        this.jdbi = jdbi;
        this.beeline = beeline;
    }

    @ChildSpan("allRestaurants")
    public List<Restaurant> allRestaurants() {
        return jdbi.withExtension(RestaurantsDao.class, dao-> dao.selectAllRestaurants());
    }

    @ChildSpan("restaurantMenu")
    public List<MenuItem> restaurantMenu(@SpanField String slug) {
        return jdbi.withExtension(RestaurantsDao.class, dao-> dao.selectMenuItemsForRestaurant(slug));
    }
}
