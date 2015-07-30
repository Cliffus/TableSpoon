package at.blogc.tablespoon.builders;

import org.junit.Test;

import at.blogc.tablespoon.core.SQLiteObject;
import at.blogc.tablespoon.fixtures.StaticUsersTable;
import at.blogc.tablespoon.fixtures.TableWithoutColumns;
import at.blogc.tablespoon.fixtures.UserAccountsTable;
import at.blogc.tablespoon.fixtures.UsersTable;
import at.blogc.tablespoon.fixtures.UsersTableWithStaticFields;
import at.blogc.tablespoon.fixtures.UsersTableWithTransientField;

import static org.junit.Assert.assertEquals;

/**
 * Created by cliff on 16/07/15.
 */
public class TableBuilderTest
{
    @Test
    public void testTableBuilderWithTableName()
    {
        final SQLiteObject sqLiteObject = new TableBuilder(UsersTable.class).build();

        final String sql = sqLiteObject.generateSQL();
        System.out.println("SQL: " + sql);

        assertEquals("CREATE TABLE IF NOT EXISTS users (id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, street TEXT, timestamp NUMERIC, float_value REAL, double_value REAL, integer_value INTEGER);", sql);
    }

    @Test
    public void testTableBuilderWithoutTableName()
    {
        final SQLiteObject sqLiteObject = new TableBuilder(UserAccountsTable.class).build();

        final String sql = sqLiteObject.generateSQL();
        System.out.println("SQL: " + sql);

        assertEquals("CREATE TABLE IF NOT EXISTS user_accounts (id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, address TEXT);", sql);
    }

    @Test
    public void testTableBuilderWithStaticFields()
    {
        final SQLiteObject sqLiteObject = new TableBuilder(UsersTableWithStaticFields.class).build();

        final String sql = sqLiteObject.generateSQL();
        System.out.println("SQL: " + sql);

        assertEquals("CREATE TABLE users (id INTEGER PRIMARY KEY, name TEXT, address TEXT, timestamp NUMERIC, floatValue REAL, doubleValue REAL, integerValue INTEGER);", sql);
    }

    @Test
    public void testTableBuilderWithStaticClass()
    {
        final SQLiteObject sqLiteObject = new TableBuilder(StaticUsersTable.UsersTable.class).build();

        final String sql = sqLiteObject.generateSQL();
        System.out.println("SQL: " + sql);

        assertEquals("CREATE TABLE IF NOT EXISTS users (id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, street TEXT, timestamp NUMERIC, float_value REAL, double_value REAL, integer_value INTEGER);", sql);
    }

    @Test
    public void testTableBuilderWithTransientField()
    {
        final SQLiteObject sqLiteObject = new TableBuilder(UsersTableWithTransientField.class).build();

        final String sql = sqLiteObject.generateSQL();
        System.out.println("SQL: " + sql);

        assertEquals("CREATE TABLE IF NOT EXISTS users (id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, street TEXT, timestamp NUMERIC, float_value REAL, double_value REAL, integer_value INTEGER);", sql);
    }

    @Test(expected = IllegalStateException.class)
    public void testTableBuilderWithInvalidTableClass()
    {
        new TableBuilder(null).build();
    }

    @Test(expected = IllegalStateException.class)
    public void testTableBuilderWithoutColumns()
    {
        new TableBuilder(TableWithoutColumns.class).build();
    }
}
