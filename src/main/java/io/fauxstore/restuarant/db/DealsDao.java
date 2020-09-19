package io.fauxstore.restuarant.db;

import io.fauxstore.restuarant.Deal;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import java.util.List;
import java.util.UUID;

interface DealsDao {
    @SqlUpdate("INSERT INTO deals(description, promo_code) VALUES (:description, :promoCode)")
    @GetGeneratedKeys
    UUID insert(@BindBean Deal deal);

    @SqlQuery("SELECT * FROM deals LIMIT :n")
    @RegisterRowMapper(DealMapper.class)
    List<Deal> selectN(@Bind Integer n);
}
