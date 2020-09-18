package db.migration;

import io.fauxstore.deals.Deal;
import io.fauxstore.deals.db.DealsRepository;
import org.flywaydb.core.api.migration.BaseJavaMigration;
import org.flywaydb.core.api.migration.Context;
import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.sqlobject.SqlObjectPlugin;

import java.sql.Statement;
import java.util.stream.IntStream;

public class V2__PopulateDealsTable extends BaseJavaMigration {
    @Override
    public void migrate(Context context) throws Exception {
        final Jdbi jdbi = Jdbi.create(context.getConnection());
        jdbi.installPlugin(new SqlObjectPlugin());

        final DealsRepository dealsRepository = new DealsRepository(jdbi);

        IntStream.rangeClosed(1, 100).forEach(x -> dealsRepository.insertDeal(Deal.fakeDeal()));
    }
}
