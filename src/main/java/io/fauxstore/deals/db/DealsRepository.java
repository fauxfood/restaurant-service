package io.fauxstore.deals.db;

import io.fauxstore.deals.Deal;
import io.honeycomb.beeline.spring.beans.aspects.ChildSpan;
import io.honeycomb.beeline.spring.beans.aspects.SpanField;
import io.honeycomb.beeline.tracing.Beeline;
import org.jdbi.v3.core.Jdbi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DealsRepository {
    private final Jdbi jdbi;
    private final Beeline beeline;


    @Autowired
    public DealsRepository(Jdbi jdbi, Beeline beeline) {
        this.jdbi = jdbi;
        this.beeline = beeline;
    }

    @ChildSpan("insertDeal")
    public void insertDeal(Deal deal){
        jdbi.useExtension(DealsDao.class, dao-> dao.insert(deal));
    }

    @ChildSpan("selectSomeDeals")
    public List<Deal> selectSomeDeals(@SpanField Integer numberOfDeals) {
        return jdbi.withExtension(DealsDao.class, dao-> dao.selectN(numberOfDeals));
    }
}
