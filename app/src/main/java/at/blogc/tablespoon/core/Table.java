package at.blogc.tablespoon.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import at.blogc.tablespoon.utils.TextUtils;

/**
 * Created by cliff on 06/07/15.
 */
public class Table implements SQLiteObject
{
    private final String tableName;
    private final List<Column> columns;
    private boolean ifNotExists;

    public Table(final String tableName)
    {
        super();

        this.tableName = tableName;
        this.columns = new ArrayList<>();
    }

    public Table addColumns(final Column... columns)
    {
        if (columns == null || columns.length == 0)
        {
            throw new IllegalArgumentException("columns cannot be null or empty.");
        }

        final List<Column> columnList = Arrays.asList(columns);
        this.columns.addAll(columnList);

        return this;
    }

    public Table setIfNotExists(final boolean ifNotExists)
    {
        this.ifNotExists = ifNotExists;

        return this;
    }

    public String getTableName()
    {
        return tableName;
    }

    public List<Column> getColumns()
    {
        return columns;
    }

    public boolean isIfNotExists()
    {
        return ifNotExists;
    }

    /*
     * SQLiteObject
     */

    @Override
    public String generateSQL() throws IllegalStateException
    {
        if (TextUtils.isEmpty(this.tableName))
        {
            throw new IllegalStateException("tableName cannot be null or empty.");
        }

        //TODO validate tableName for invalid characters

        if (this.columns.isEmpty())
        {
            throw new IllegalStateException("columns cannot be empty");
        }

        final StringBuilder stringBuilder = new StringBuilder();

        // CREATE STATEMENT
        stringBuilder.append("CREATE TABLE ");

        // IF NOT EXISTS
        if (this.ifNotExists)
        {
            stringBuilder.append("IF NOT EXISTS ");
        }

        // TABLE NAME
        stringBuilder.append(this.tableName).append(" ");

        // COLUMNS
        stringBuilder.append("(");

        Column column;
        for (int i = 0; i < this.columns.size(); i++)
        {
            if (i > 0)
            {
                stringBuilder.append(", ");
            }

            column = this.columns.get(i);
            stringBuilder.append(column.generateSQL());
        }

        stringBuilder.append(");");

        return stringBuilder.toString();
    }
}
