package io.fauxstore.restuarant.db;

import io.fauxstore.restuarant.MenuItem;
import io.fauxstore.restuarant.Restaurant;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.statement.SqlQuery;

import java.util.List;

interface RestaurantsDao {

    @SqlQuery("SELECT * FROM restaurants")
    @RegisterRowMapper(RestaurantsMapper.class)
    List<Restaurant> selectAllRestaurants();

    @SqlQuery("SELECT * FROM menu_items mi INNER JOIN restaurants r ON (mi.restaurant_id = r.id) WHERE r.slug =:slug")
    @RegisterRowMapper(MenuItemsMapper.class)
    List<MenuItem> selectMenuItemsForRestaurant(@Bind("slug") String slug);
}
