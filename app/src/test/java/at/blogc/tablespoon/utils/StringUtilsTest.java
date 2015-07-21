package at.blogc.tablespoon.utils;

import org.junit.Test;

import at.blogc.tablespoon.fixtures.UserAccountsTable;
import at.blogc.tablespoon.fixtures.UsersTable;
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
        String tableName = StringUtils.camelCaseToUnderscores(UsersTable.class.getSimpleName());
        System.out.println("testCamelCaseToUnderscores: " + tableName);

        assertEquals("users_table", tableName);

        tableName = StringUtils.camelCaseToUnderscores(UserAccountsTable.class.getSimpleName());
        System.out.println("testCamelCaseToUnderscores: " + tableName);

        assertEquals("user_accounts_table", tableName);
    }
}
