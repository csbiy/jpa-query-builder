package persistence.sql.domain;

import org.junit.jupiter.api.Test;
import persistence.sql.ddl.Person;
import persistence.sql.dml.DmlQueryBuilder;

import static org.assertj.core.api.Assertions.assertThat;

class DatabaseTableTest {

    @Test
    void should_create_column_cause_when_id_does_not_exist() {
        Person person = new Person("cs", 29, "katd216@gmail.com", 1);
        DatabaseTable table = new DatabaseTable(person);
        String columnClause = table.columnClause();

        assertThat(columnClause).isEqualTo("nick_name,old,email");
    }

    @Test
    void should_create_column_cause_when_id_exist() {
        Person person = new Person(1l,"cs", 29, "katd216@gmail.com", 1);
        DatabaseTable table = new DatabaseTable(person);
        String columnClause = table.columnClause();

        assertThat(columnClause).isEqualTo("id,nick_name,old,email");
    }

    @Test
    void should_create_value_cause_when_id_does_not_exist() {
        Person person = new Person("cs", 29, "katd216@gmail.com", 1);
        DatabaseTable table = new DatabaseTable(person);
        String valueClause = table.valueClause();


        assertThat(valueClause).isEqualTo("'cs',29,'katd216@gmail.com'");
    }

    @Test
    void should_create_value_cause_when_id_exist() {
        Person person = new Person(1l,"cs", 29, "katd216@gmail.com", 1);
        DatabaseTable table = new DatabaseTable(person);
        String valueClause = table.valueClause();


        assertThat(valueClause).isEqualTo("1,'cs',29,'katd216@gmail.com'");
    }
}