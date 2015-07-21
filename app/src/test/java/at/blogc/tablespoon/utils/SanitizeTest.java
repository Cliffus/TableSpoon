package at.blogc.tablespoon.utils;

import org.junit.Test;

import java.lang.reflect.Field;

import at.blogc.tablespoon.fixtures.UserAccountsTable;
import at.blogc.tablespoon.fixtures.UsersTable;
import at.blogc.tablespoon.fixtures.UsersTableWithInvalidPrimaryKey;

import static org.junit.Assert.assertEquals;

/**
 * Created by cliff on 13/07/15.
 */
public class SanitizeTest
{
    @Test
    public void testTableName()
    {
        String tableName = Sanitize.tableName(UsersTable.class);
        System.out.println("testTableName: " + tableName);

        assertEquals("users", tableName);

        tableName = Sanitize.tableName(UserAccountsTable.class);
        System.out.println("testTableName: " + tableName);

        assertEquals("user_accounts", tableName);
    }

    @Test
    public void testColumnName() throws NoSuchFieldException
    {
        Field field = UsersTableWithInvalidPrimaryKey.class.getField("integerValue");
        String columnName = Sanitize.columnName(field);
        System.out.println("testColumnName: " + columnName);

        assertEquals("integer_value", columnName);

        field = UsersTableWithInvalidPrimaryKey.class.getField("doubleColumn");
        columnName = Sanitize.columnName(field);
        System.out.println("testColumnName: " + columnName);

        assertEquals("double", columnName);
    }
}
