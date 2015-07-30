package at.blogc.tablespoon.builders;

import java.lang.reflect.Field;

import at.blogc.tablespoon.annotations.PrimaryKey;
import at.blogc.tablespoon.core.Column;
import at.blogc.tablespoon.core.DataType;
import at.blogc.tablespoon.utils.AnnotationUtils;
import at.blogc.tablespoon.utils.Sanitize;
import at.blogc.tablespoon.utils.TextUtils;

/**
 * Created by cliff on 14/07/15.
 */
public class ColumnBuilder implements SQLiteObjectBuilder<Column>
{
    private Field column;

    public ColumnBuilder(final Field column)
    {
        super();

        this.column = column;
    }

    private at.blogc.tablespoon.annotations.Column findColumnAnnotation()
    {
        return AnnotationUtils.findAnnotation(this.column, at.blogc.tablespoon.annotations.Column.class);
    }

    private PrimaryKey findPrimaryKeyAnnotation()
    {
        return AnnotationUtils.findAnnotation(this.column, PrimaryKey.class);
    }

    private String getColumnName()
    {
        final at.blogc.tablespoon.annotations.Column columnAnnotation = this.findColumnAnnotation();
        if (columnAnnotation != null)
        {
            final String columnName = columnAnnotation.name();
            if (!TextUtils.isEmpty(columnName))
            {
                return columnName;
            }
        }

        return Sanitize.columnName(this.column);
    }

    private DataType getDataType()
    {
        final Class clazz = this.column.getType();
        return DataType.fromClass(clazz);
    }

    private boolean isPrimaryKey()
    {
        return this.findPrimaryKeyAnnotation() != null;
    }

    private boolean isAutoIncrement()
    {
        final PrimaryKey primaryKey = this.findPrimaryKeyAnnotation();
        if (primaryKey != null)
        {
            return primaryKey.autoIncrement();
        }

        return false;
    }

    /*
     * SQLiteObjectBuilder<Column>
     */

    @Override
    public Column build() throws IllegalStateException
    {
        if (this.column == null)
        {
            throw new IllegalStateException("column cannot be null.");
        }

        final String columnName = this.getColumnName();
        final DataType dataType = this.getDataType();
        final boolean isPrimaryKey = this.isPrimaryKey();
        final boolean isAutoIncrement = isPrimaryKey && this.isAutoIncrement();

        return new Column(columnName)
                .setDataType(dataType)
                .setPrimaryKey(isPrimaryKey, isAutoIncrement);
    }
}
