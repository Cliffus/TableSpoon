package at.blogc.tablespoon.test;

import org.junit.Test;

import at.blogc.tablespoon.test.tables.UsersTable;
import at.blogc.tablespoon.utils.Sanitize;

import static org.junit.Assert.assertEquals;

/**
 * Created by cliff on 13/07/15.
 */
public class SanitizeTest
{
    @Test
    public void testTableName()
    {
        final String tableName = Sanitize.tableName(UsersTable.class);
        System.out.println("testTableName: " + tableName);

        assertEquals("users", tableName);
    }
}
