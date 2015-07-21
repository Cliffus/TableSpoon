package at.blogc.tablespoon.core;

import org.junit.Test;

import java.io.File;

import static org.junit.Assert.assertEquals;

/**
 * Created by cliff on 21/07/15.
 */
public class DataTypeTest
{
    @Test
    public void testDataTypes()
    {
        // String
        DataType dataType = DataType.fromClass(String.class);
        assertEquals(DataType.TEXT, dataType);

        // CharSequence
        dataType = DataType.fromClass(CharSequence.class);
        assertEquals(DataType.TEXT, dataType);

        // Character
        dataType = DataType.fromClass(Character.class);
        assertEquals(DataType.TEXT, dataType);

        // char
        dataType = DataType.fromClass(Character.TYPE);
        assertEquals(DataType.TEXT, dataType);

        // Enum
        dataType = DataType.fromClass(DataType.class);
        assertEquals(DataType.TEXT, dataType);

        // Integer
        dataType = DataType.fromClass(Integer.class);
        assertEquals(DataType.INTEGER, dataType);

        // int
        dataType = DataType.fromClass(Integer.TYPE);
        assertEquals(DataType.INTEGER, dataType);

        // Boolean
        dataType = DataType.fromClass(Boolean.class);
        assertEquals(DataType.INTEGER, dataType);

        // boolean
        dataType = DataType.fromClass(Boolean.TYPE);
        assertEquals(DataType.INTEGER, dataType);

        // Short
        dataType = DataType.fromClass(Short.class);
        assertEquals(DataType.INTEGER, dataType);

        // short
        dataType = DataType.fromClass(Short.TYPE);
        assertEquals(DataType.INTEGER, dataType);

        // Float
        dataType = DataType.fromClass(Float.class);
        assertEquals(DataType.REAL, dataType);

        // float
        dataType = DataType.fromClass(Float.TYPE);
        assertEquals(DataType.REAL, dataType);

        // Double
        dataType = DataType.fromClass(Double.class);
        assertEquals(DataType.REAL, dataType);

        // double
        dataType = DataType.fromClass(Double.TYPE);
        assertEquals(DataType.REAL, dataType);

        // Long
        dataType = DataType.fromClass(Long.class);
        assertEquals(DataType.NUMERIC, dataType);

        // long
        dataType = DataType.fromClass(Long.TYPE);
        assertEquals(DataType.NUMERIC, dataType);

        // Object
        dataType = DataType.fromClass(Object.class);
        assertEquals(DataType.NONE, dataType);

        // File
        dataType = DataType.fromClass(File.class);
        assertEquals(DataType.NONE, dataType);
    }
}
