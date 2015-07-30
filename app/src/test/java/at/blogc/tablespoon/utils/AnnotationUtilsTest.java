package at.blogc.tablespoon.utils;

import org.junit.Test;

import java.lang.reflect.Field;

import at.blogc.tablespoon.annotations.PrimaryKey;
import at.blogc.tablespoon.annotations.Table;
import at.blogc.tablespoon.fixtures.UsersTable;

import static org.junit.Assert.assertNotNull;

/**
 * Created by cliff on 30/07/15.
 */
public class AnnotationUtilsTest
{
    @Test
    public void testFindAnnotation() throws NoSuchFieldException
    {
        final Table table = AnnotationUtils.findAnnotation(UsersTable.class, Table.class);
        assertNotNull(table);

        final Field field = UsersTable.class.getField("id");
        final PrimaryKey primaryKey = AnnotationUtils.findAnnotation(field, PrimaryKey.class);
        assertNotNull(primaryKey);
    }
}
