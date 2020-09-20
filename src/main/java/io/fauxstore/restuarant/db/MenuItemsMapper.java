package io.fauxstore.restuarant.db;

import io.fauxstore.restuarant.MenuItem;
import io.fauxstore.restuarant.Restaurant;
import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class MenuItemsMapper implements RowMapper<MenuItem> {
    @Override
    public MenuItem map(ResultSet rs, StatementContext ctx) throws SQLException {
        final BigDecimal price = BigDecimal.valueOf(rs.getInt("price_cents")).movePointLeft(2);
        final UUID id = UUID.fromString(rs.getString("id"));
        return MenuItem.builder()
                .id(id)
                .name(rs.getString("name"))
                .description(rs.getString("description"))
                .price(price)
            .build();
    }
}
