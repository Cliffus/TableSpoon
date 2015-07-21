package at.blogc.tablespoon.builders;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

import at.blogc.tablespoon.annotations.IfNotExists;
import at.blogc.tablespoon.annotations.TableName;
import at.blogc.tablespoon.core.Column;
import at.blogc.tablespoon.core.Table;
import at.blogc.tablespoon.utils.Sanitize;

/**
 * Created by cliff on 12/07/15.
 */
public class TableBuilder implements SQLiteObjectBuilder<Table>
{
    private final Class table;

    public TableBuilder(final Class table)
    {
        super();

        this.table = table;
    }

    private String getTableName()
    {
        final Annotation[] annotations = this.table.getDeclaredAnnotations();
        for (final Annotation annotation : annotations)
        {
            if (annotation instanceof TableName)
            {
                final TableName tableAnnotation = (TableName) annotation;
                return tableAnnotation.value();
            }
        }

        return Sanitize.tableName(this.table);
    }

    private boolean getIfNotExists()
    {
        return this.table.isAnnotationPresent(IfNotExists.class);
    }

    private Column[] getColumns()
    {
        final List<Column> columnsList = new ArrayList<>();
        boolean isTransient;
        Column column;

        final Field[] fields = this.table.getDeclaredFields();
        for (final Field field : fields)
        {
            isTransient = Modifier.isTransient(field.getModifiers());
            if (!isTransient)
            {
                column = new ColumnBuilder(field).build();
                columnsList.add(column);
            }
        }

        final Column[] columns = new Column[columnsList.size()];
        columnsList.toArray(columns);

        return columns;
    }

    /*
     * SQLiteObjectBuilder<Table>
     */

    @Override
    public Table build() throws IllegalStateException
    {
        if (this.table == null)
        {
            throw new IllegalStateException("table cannot be null.");
        }

        final String tableName = this.getTableName();
        final boolean ifNotExists = this.getIfNotExists();
        final Column[] columns = this.getColumns();

        if (columns.length == 0)
        {
            throw new IllegalStateException("columns cannot be null or empty.");
        }

        return new Table(tableName)
                .setIfNotExists(ifNotExists)
                .addColumns(columns);
    }
}
