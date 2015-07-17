package at.blogc.tablespoon.builders;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

import at.blogc.tablespoon.annotations.ColumnName;
import at.blogc.tablespoon.annotations.PrimaryKey;
import at.blogc.tablespoon.core.Column;
import at.blogc.tablespoon.core.DataType;
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

    private String getColumnName()
    {
        final Annotation[] annotations = this.column.getDeclaredAnnotations();
        for (final Annotation annotation : annotations)
        {
            if (annotation instanceof ColumnName)
            {
                final ColumnName columnName = (ColumnName) annotation;
                if (!TextUtils.isEmpty(columnName.value()))
                {
                    return columnName.value();
                }
            }
        }

        return this.column.getName();
    }

    private DataType getDataType()
    {
        final Class clazz = this.column.getType();

        return DataType.fromClass(clazz);
    }

    private boolean isPrimaryKey()
    {
        return this.column.isAnnotationPresent(PrimaryKey.class);
    }

    private boolean isAutoIncrement()
    {
        final Annotation[] annotations = this.column.getDeclaredAnnotations();
        for (final Annotation annotation : annotations)
        {
            if (annotation instanceof PrimaryKey)
            {
                final PrimaryKey primaryKey = (PrimaryKey) annotation;
                return primaryKey.autoIncrement();
            }
        }

        return false;
    }

    /*
     * SQLiteObjectBuilder<Column>
     */

    @Override
    public Column build() throws IllegalStateException
    {
        final String columnName = this.getColumnName();
        final DataType dataType = this.getDataType();
        final boolean isPrimaryKey = this.isPrimaryKey();
        final boolean isAutoIncrement = isPrimaryKey && this.isAutoIncrement();

        return new Column(columnName)
                .setDataType(dataType)
                .setPrimaryKey(isPrimaryKey, isAutoIncrement);
    }
}
