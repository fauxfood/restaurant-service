package io.fauxstore.deals.db;

import io.fauxstore.deals.Deal;
import org.jdbi.v3.core.Jdbi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DealsRepository {
    private final Jdbi jdbi;


    @Autowired
    public DealsRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public void insertDeal(Deal deal){
        jdbi.useExtension(DealsDao.class, dao-> dao.insert(deal));
    }

    public List<Deal> selectSomeDeals(Integer numberOfDeals) {
        return jdbi.withExtension(DealsDao.class, dao-> dao.selectN(numberOfDeals));
    }
}
