package at.blogc.tablespoon.utils;

/**
 * Created by cliff on 13/07/15.
 */
public class Sanitize
{
    public static String tableName(final Class table)
    {
        if (table == null)
        {
            throw new IllegalArgumentException("table cannot be null.");
        }

        return StringUtils.camelCaseToUnderscores(table.getSimpleName())
                .replace("_table", "");
    }
}
