package io.fauxstore.restuarant.db;

import io.fauxstore.restuarant.Restaurant;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import org.jdbi.v3.sqlobject.statement.SqlQuery;

import java.util.List;

interface RestaurantsDao {

    @SqlQuery("SELECT * FROM restaurants")
    @RegisterRowMapper(RestaurantsMapper.class)
    List<Restaurant> selectAllRestaurants();
}
