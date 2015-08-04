package at.blogc.tablespoon.core;

import at.blogc.tablespoon.utils.TextUtils;

/**
 * Created by cliff on 06/07/15.
 */
public class Column implements SQLiteObject
{
    //TODO default value
    //TODO not null
    //TODO CHECK (my_id BETWEEN 0 AND 100)

    private final String columnName;
    private DataType dataType;
    private boolean primaryKey;
    private boolean autoIncrement;
    private boolean unique;

    public Column(final String columnName)
    {
        super();

        this.columnName = columnName;
    }

    public Column setDataType(final DataType dataType)
    {
        this.dataType = dataType;

        return this;
    }

    public Column setPrimaryKey(final boolean primaryKey, final boolean autoIncrement)
    {
        //TODO ASC / DESC
        this.primaryKey = primaryKey;
        this.autoIncrement = autoIncrement;

        return this;
    }

    public Column setUnique(final boolean unique)
    {
        this.unique = unique;

        return this;
    }

    public String getColumnName()
    {
        return columnName;
    }

    public DataType getDataType()
    {
        return dataType;
    }

    public boolean isPrimaryKey()
    {
        return primaryKey;
    }

    public boolean isAutoIncrement()
    {
        return autoIncrement;
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
        if (TextUtils.isEmpty(this.columnName))
        {
            throw new IllegalStateException("columnName cannot be null or empty.");
        }

        //TODO validate tableName for invalid characters

        if (this.dataType == null)
        {
            throw new IllegalStateException("dataType cannot be null or empty.");
        }

        if (this.primaryKey && this.dataType != DataType.INTEGER)
        {
            throw new IllegalStateException("primaryKey must be of DataType INTEGER.");
        }

        final StringBuilder stringBuilder = new StringBuilder();

        // COLUMN NAME
        stringBuilder.append(this.columnName).append(" ");

        // DATA TYPE
        stringBuilder.append(this.dataType.name());

        // UNIQUE
        if (!this.primaryKey && this.unique)
        {
            stringBuilder.append(" UNIQUE");
        }

        // PRIMARY KEY
        if (this.primaryKey)
        {
            stringBuilder.append(" PRIMARY KEY");

            // AUTO_INCREMENT
            if (this.autoIncrement)
            {
                stringBuilder.append(" AUTOINCREMENT");
            }
        }

        return stringBuilder.toString();
    }
}
