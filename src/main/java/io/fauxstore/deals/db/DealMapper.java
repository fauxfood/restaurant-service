package io.fauxstore.deals.db;

import io.fauxstore.deals.Deal;
import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DealMapper implements RowMapper<Deal> {
    @Override
    public Deal map(ResultSet rs, StatementContext ctx) throws SQLException {
        return Deal.builder()
                .description(rs.getString("description"))
                .promoCode(rs.getString("promo_code"))
            .build();
    }
}
