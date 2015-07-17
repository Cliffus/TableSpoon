package at.blogc.tablespoon.test;

import org.junit.Test;

import at.blogc.tablespoon.builders.TableBuilder;
import at.blogc.tablespoon.core.SQLiteObject;
import at.blogc.tablespoon.test.tables.UsersTable;

/**
 * Created by cliff on 16/07/15.
 */
public class BuildersTest
{
    @Test
    public void testTableBuilder()
    {
        final SQLiteObject sqLiteObject = new TableBuilder(UsersTable.class).build();

        final String sql = sqLiteObject.generateSQL();
        System.out.println("SQL: " + sql);
    }
}
