package at.blogc.tablespoon.test;

import org.junit.Test;

import at.blogc.tablespoon.test.tables.UsersTable;
import at.blogc.tablespoon.utils.StringUtils;

import static org.junit.Assert.assertEquals;

/**
 * Created by cliff on 13/07/15.
 */
public class StringUtilsTest
{
    @Test
    public void testCamelCaseToUnderscores()
    {
        final String tableName = StringUtils.camelCaseToUnderscores(UsersTable.class.getSimpleName());
        System.out.println("testCamelCaseToUnderscores: " + tableName);

        assertEquals("users_table", tableName);
    }
}
