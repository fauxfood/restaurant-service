package io.fauxstore.deals.db;

import io.fauxstore.deals.Deal;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import java.util.UUID;

interface DealsDao {
    @SqlUpdate("INSERT INTO deals(description, promo_code) VALUES (:description, :promoCode)")
    @GetGeneratedKeys
    UUID insert(@BindBean Deal deal);
}
