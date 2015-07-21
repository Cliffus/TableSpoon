package at.blogc.tablespoon.core;

import org.junit.Test;

import at.blogc.tablespoon.core.Column;
import at.blogc.tablespoon.core.DataType;

import static org.junit.Assert.assertEquals;

public class ColumnTest
{
    @Test
    public void testInteger()
    {
        final Column column1 = new Column("column1")
                .setDataType(DataType.INTEGER);

        final String sql = column1.generateSQL();
        System.out.println("SQL: " + sql);

        assertEquals("column1 INTEGER", sql);
    }

    @Test
    public void testText()
    {
        final Column column2 = new Column("column2")
                .setDataType(DataType.TEXT);

        final String sql = column2.generateSQL();
        System.out.println("SQL: " + sql);

        assertEquals("column2 TEXT", sql);
    }

    @Test
    public void testNone()
    {
        final Column column3 = new Column("column3")
                .setDataType(DataType.NONE);

        final String sql = column3.generateSQL();
        System.out.println("SQL: " + sql);

        assertEquals("column3 NONE", sql);
    }

    @Test
    public void testNumeric()
    {
        final Column column4 = new Column("column4")
                .setDataType(DataType.NUMERIC);

        final String sql = column4.generateSQL();
        System.out.println("SQL: " + sql);

        assertEquals("column4 NUMERIC", sql);
    }

    @Test
    public void testReal()
    {
        final Column column5 = new Column("column5")
                .setDataType(DataType.REAL);

        final String sql = column5.generateSQL();
        System.out.println("SQL: " + sql);

        assertEquals("column5 REAL", sql);
    }

    @Test
    public void testPrimaryKey()
    {
        final Column column6 = new Column("column6")
                .setDataType(DataType.INTEGER)
                .setPrimaryKey(true, false);

        final String sql = column6.generateSQL();
        System.out.println("SQL: " + sql);

        assertEquals("column6 INTEGER PRIMARY KEY", sql);
    }

    @Test
    public void testPrimaryKeyAutoIncrement()
    {
        final Column column7 = new Column("column7")
                .setDataType(DataType.INTEGER)
                .setPrimaryKey(true, true);

        final String sql = column7.generateSQL();
        System.out.println("SQL: " + sql);

        assertEquals("column7 INTEGER PRIMARY KEY AUTOINCREMENT", sql);
    }

    @Test(expected = IllegalStateException.class)
    public void testInvalidPrimaryKey()
    {
        final Column column8 = new Column("column8")
                .setDataType(DataType.TEXT)
                .setPrimaryKey(true, true);

        final String sql = column8.generateSQL();
        System.out.println("SQL: " + sql);

        column8.generateSQL();
    }
}
