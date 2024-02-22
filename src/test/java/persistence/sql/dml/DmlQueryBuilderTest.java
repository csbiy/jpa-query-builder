package persistence.sql.dml;

import org.junit.jupiter.api.Test;
import persistence.sql.ddl.Person;

import static org.assertj.core.api.Assertions.assertThat;

class DmlQueryBuilderTest {

    private final DmlQueryBuilder dmlQueryBuilder = new DmlQueryBuilder();

    @Test
    void should_create_insert_query() {
        Person person = new Person("cs", 29, "katd216@gmail.com", 1);

        String query = dmlQueryBuilder.insert(person);

        assertThat(query).isEqualTo("insert into users(nick_name,old,email) values('cs',29,'katd216@gmail.com');");
    }

    @Test
    void should_create_find_all_query() {
        String query = dmlQueryBuilder.findAll(Person.class);

        assertThat(query).isEqualTo("select * from users;");
    }
}