package at.blogc.tablespoon.utils;

import java.lang.reflect.Field;

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
                .replace("_table", "")
                .replace("table_", "");
    }

    public static String columnName(final Field column)
    {
        if (column == null)
        {
            throw new IllegalArgumentException("column cannot be null.");
        }

        return StringUtils.camelCaseToUnderscores(column.getName())
                .replace("_column", "")
                .replace("column_", "");
    }
}
