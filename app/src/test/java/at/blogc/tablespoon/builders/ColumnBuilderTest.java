package at.blogc.tablespoon.builders;

import org.junit.Test;

import java.lang.reflect.Field;

import at.blogc.tablespoon.core.SQLiteObject;
import at.blogc.tablespoon.fixtures.DataTypesTable;
import at.blogc.tablespoon.fixtures.UsersTable;
import at.blogc.tablespoon.fixtures.UsersTableWithStaticFields;

import static org.junit.Assert.assertEquals;

/**
 * Created by cliff on 20/07/15.
 */
public class ColumnBuilderTest
{
    @Test
    public void testColumnBuilderWithColumnName() throws NoSuchFieldException
    {
        final Field field = UsersTableWithStaticFields.class.getField("COLUMN_NAME");
        final SQLiteObject sqLiteObject = new ColumnBuilder(field).build();

        final String sql = sqLiteObject.generateSQL();
        System.out.println("SQL: " + sql);

        assertEquals("name TEXT", sql);
    }

    @Test
    public void testColumnBuilderWithoutColumnName() throws NoSuchFieldException
    {
        final Field field = UsersTable.class.getField("name");
        final SQLiteObject sqLiteObject = new ColumnBuilder(field).build();

        final String sql = sqLiteObject.generateSQL();
        System.out.println("SQL: " + sql);

        assertEquals("name TEXT", sql);
    }

    @Test
    public void testColumnBuilderWithPrimaryKey() throws NoSuchFieldException
    {
        final Field field = UsersTableWithStaticFields.class.getField("id");
        final SQLiteObject sqLiteObject = new ColumnBuilder(field).build();

        final String sql = sqLiteObject.generateSQL();
        System.out.println("SQL: " + sql);

        assertEquals("id INTEGER PRIMARY KEY", sql);
    }

    @Test
    public void testColumnBuilderWithPrimaryKeyAutoIncrement() throws NoSuchFieldException
    {
        final Field field = UsersTable.class.getField("id");
        final SQLiteObject sqLiteObject = new ColumnBuilder(field).build();

        final String sql = sqLiteObject.generateSQL();
        System.out.println("SQL: " + sql);

        assertEquals("id INTEGER PRIMARY KEY AUTOINCREMENT", sql);
    }

    @Test
    public void testColumnBuilderDataTypes() throws NoSuchFieldException
    {
        // String
        Field field = DataTypesTable.class.getField("string");
        SQLiteObject sqLiteObject = new ColumnBuilder(field).build();

        String sql = sqLiteObject.generateSQL();
        System.out.println("SQL: " + sql);

        assertEquals("string TEXT", sql);


        // CharSequence
        field = DataTypesTable.class.getField("charSequence");
        sqLiteObject = new ColumnBuilder(field).build();

        sql = sqLiteObject.generateSQL();
        System.out.println("SQL: " + sql);

        assertEquals("char_sequence TEXT", sql);


        // Character
        field = DataTypesTable.class.getField("character");
        sqLiteObject = new ColumnBuilder(field).build();

        sql = sqLiteObject.generateSQL();
        System.out.println("SQL: " + sql);

        assertEquals("character TEXT", sql);


        // char
        field = DataTypesTable.class.getField("nativeCharacter");
        sqLiteObject = new ColumnBuilder(field).build();

        sql = sqLiteObject.generateSQL();
        System.out.println("SQL: " + sql);

        assertEquals("native_character TEXT", sql);


        // Enum
        field = DataTypesTable.class.getField("enumm");
        sqLiteObject = new ColumnBuilder(field).build();

        sql = sqLiteObject.generateSQL();
        System.out.println("SQL: " + sql);

        assertEquals("enumm TEXT", sql);


        // Integer
        field = DataTypesTable.class.getField("integer");
        sqLiteObject = new ColumnBuilder(field).build();

        sql = sqLiteObject.generateSQL();
        System.out.println("SQL: " + sql);

        assertEquals("integer INTEGER", sql);


        // int
        field = DataTypesTable.class.getField("nativeInteger");
        sqLiteObject = new ColumnBuilder(field).build();

        sql = sqLiteObject.generateSQL();
        System.out.println("SQL: " + sql);

        assertEquals("native_integer INTEGER", sql);


        // Boolean
        field = DataTypesTable.class.getField("booleann");
        sqLiteObject = new ColumnBuilder(field).build();

        sql = sqLiteObject.generateSQL();
        System.out.println("SQL: " + sql);

        assertEquals("booleann INTEGER", sql);


        // boolean
        field = DataTypesTable.class.getField("nativeBoolean");
        sqLiteObject = new ColumnBuilder(field).build();

        sql = sqLiteObject.generateSQL();
        System.out.println("SQL: " + sql);

        assertEquals("native_boolean INTEGER", sql);

        // Short
        field = DataTypesTable.class.getField("shortt");
        sqLiteObject = new ColumnBuilder(field).build();

        sql = sqLiteObject.generateSQL();
        System.out.println("SQL: " + sql);

        assertEquals("shortt INTEGER", sql);


        // short
        field = DataTypesTable.class.getField("nativeShort");
        sqLiteObject = new ColumnBuilder(field).build();

        sql = sqLiteObject.generateSQL();
        System.out.println("SQL: " + sql);

        assertEquals("native_short INTEGER", sql);


        // Float
        field = DataTypesTable.class.getField("floatt");
        sqLiteObject = new ColumnBuilder(field).build();

        sql = sqLiteObject.generateSQL();
        System.out.println("SQL: " + sql);

        assertEquals("floatt REAL", sql);


        // float
        field = DataTypesTable.class.getField("nativeFloat");
        sqLiteObject = new ColumnBuilder(field).build();

        sql = sqLiteObject.generateSQL();
        System.out.println("SQL: " + sql);

        assertEquals("native_float REAL", sql);


        // Double
        field = DataTypesTable.class.getField("doublee");
        sqLiteObject = new ColumnBuilder(field).build();

        sql = sqLiteObject.generateSQL();
        System.out.println("SQL: " + sql);

        assertEquals("doublee REAL", sql);


        // double
        field = DataTypesTable.class.getField("nativeDouble");
        sqLiteObject = new ColumnBuilder(field).build();

        sql = sqLiteObject.generateSQL();
        System.out.println("SQL: " + sql);

        assertEquals("native_double REAL", sql);


        // Long
        field = DataTypesTable.class.getField("longg");
        sqLiteObject = new ColumnBuilder(field).build();

        sql = sqLiteObject.generateSQL();
        System.out.println("SQL: " + sql);

        assertEquals("longg NUMERIC", sql);


        // long
        field = DataTypesTable.class.getField("nativeLong");
        sqLiteObject = new ColumnBuilder(field).build();

        sql = sqLiteObject.generateSQL();
        System.out.println("SQL: " + sql);

        assertEquals("native_long NUMERIC", sql);

        // Object
        field = DataTypesTable.class.getField("object");
        sqLiteObject = new ColumnBuilder(field).build();

        sql = sqLiteObject.generateSQL();
        System.out.println("SQL: " + sql);

        assertEquals("object NONE", sql);

        // File
        field = DataTypesTable.class.getField("file");
        sqLiteObject = new ColumnBuilder(field).build();

        sql = sqLiteObject.generateSQL();
        System.out.println("SQL: " + sql);

        assertEquals("file NONE", sql);
    }

    @Test(expected = IllegalStateException.class)
    public void testColumnBuilderWithInvalidField()
    {
        new ColumnBuilder(null).build();
    }
}
