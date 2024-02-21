package persistence.sql.ddl;

import persistence.sql.ddl.view.mysql.MySQLPrimaryKeyResolver;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class DdlQueryBuilderFactory {

    private final Map<DatabaseDialect, DdlQueryBuilder> factory;

    public DdlQueryBuilderFactory() {
        factory = new HashMap<>();
        factory.put(DatabaseDialect.MYSQL, new DdlQueryBuilder(new MySQLPrimaryKeyResolver()));
    }

    public DdlQueryBuilder getInstance(DatabaseDialect dialect) {
        return Optional.of(factory.get(dialect))
                .orElseThrow(IllegalArgumentException::new);
    }
}
