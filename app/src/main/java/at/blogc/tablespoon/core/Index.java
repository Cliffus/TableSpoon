package at.blogc.tablespoon.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import at.blogc.tablespoon.utils.TextUtils;

/**
 * Created by cliff on 06/07/15.
 */
public class Index implements SQLiteObject
{
    private String indexName;
    private String tableName;
    private List<String> columns;
    private boolean ifNotExists;
    private boolean unique;

    public Index()
    {
        super();

        this.columns = new ArrayList<>();
    }

    public Index setIndexName(final String indexName)
    {
        this.indexName = indexName;

        return this;
    }

    public Index setTableName(final String tableName)
    {
        this.tableName = tableName;

        return this;
    }

    public Index setColumns(final String... columns)
    {
        if (columns == null || columns.length == 0)
        {
            throw new IllegalArgumentException("columns cannot be null or empty.");
        }

        final List<String> columnsList = Arrays.asList(columns);
        this.columns.addAll(columnsList);

        return this;
    }

    public Index setIfNotExists(final boolean ifNotExists)
    {
        this.ifNotExists = ifNotExists;

        return this;
    }

    public Index setUnique(final boolean unique)
    {
        this.unique = unique;

        return this;
    }

    public String getIndexName()
    {
        return indexName;
    }

    public String getTableName()
    {
        return tableName;
    }

    public List<String> getColumns()
    {
        return columns;
    }

    public boolean isIfNotExists()
    {
        return ifNotExists;
    }

    public boolean isUnique()
    {
        return unique;
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
        stringBuilder.append("CREATE ");

        if (this.unique)
        {
            stringBuilder.append("UNIQUE ");
        }

        stringBuilder.append("INDEX ");

        // IF NOT EXISTS
        if (this.ifNotExists)
        {
            stringBuilder.append("IF NOT EXISTS ");
        }

        // INDEX NAME
        if (TextUtils.isEmpty(this.indexName))
        {
            stringBuilder.append("idx_").append(this.tableName);

            String column;
            for (int i = 0; i < this.columns.size(); i++)
            {
                column = this.columns.get(i);
                stringBuilder.append("_").append(column);
            }
        }
        else
        {
            stringBuilder.append(this.indexName);
        }

        stringBuilder.append(" ");

        // ON
        stringBuilder.append("ON ").append(this.tableName);

        // COLUMNS
        stringBuilder.append(" (");

        String column;
        for (int i = 0; i < this.columns.size(); i++)
        {
            if (i > 0)
            {
                stringBuilder.append(", ");
            }

            column = this.columns.get(i);
            stringBuilder.append(column);
        }

        stringBuilder.append(");");

        return stringBuilder.toString();
    }
}
