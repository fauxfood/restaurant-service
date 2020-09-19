package io.fauxstore.restuarant.db;

import io.fauxstore.restuarant.Restaurant;
import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RestaurantsMapper implements RowMapper<Restaurant> {
    @Override
    public Restaurant map(ResultSet rs, StatementContext ctx) throws SQLException {
        return Restaurant.builder()
                .slug(rs.getString("slug"))
                .name(rs.getString("name"))
            .build();
    }
}
