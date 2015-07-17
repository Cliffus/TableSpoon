package at.blogc.tablespoon.test;

import org.junit.Test;

import at.blogc.tablespoon.core.Column;
import at.blogc.tablespoon.core.DataType;
import at.blogc.tablespoon.core.Table;

import static org.junit.Assert.assertEquals;


public class TableTest
{
    @Test
    public void testCreateTable()
    {
        final Column column1 = new Column("column1")
                .setDataType(DataType.INTEGER);

        final Column column2 = new Column("column2")
                .setDataType(DataType.TEXT);

        final Column column3 = new Column("column3")
                .setDataType(DataType.NONE);

        final Column column4 = new Column("column4")
                .setDataType(DataType.NUMERIC);

        final Column column5 = new Column("column5")
                .setDataType(DataType.REAL);

        final Table table = new Table("test")
                .addColumns(column1, column2, column3, column4, column5);

        final String sql = table.generateSQL();
        System.out.println("SQL: " + sql);

        assertEquals("CREATE TABLE test (column1 INTEGER, column2 TEXT, column3 NONE, column4 NUMERIC, column5 REAL);", sql);
    }

    @Test
    public void testCreateTableIfNotExists()
    {
        final Column column1 = new Column("column1")
                .setDataType(DataType.INTEGER);

        final Column column2 = new Column("column2")
                .setDataType(DataType.TEXT);

        final Column column3 = new Column("column3")
                .setDataType(DataType.NONE);

        final Column column4 = new Column("column4")
                .setDataType(DataType.NUMERIC);

        final Column column5 = new Column("column5")
                .setDataType(DataType.REAL);

        final Table table = new Table("test")
                .setIfNotExists(true)
                .addColumns(column1, column2, column3, column4, column5);

        final String sql = table.generateSQL();
        System.out.println("SQL: " + sql);

        assertEquals("CREATE TABLE IF NOT EXISTS test (column1 INTEGER, column2 TEXT, column3 NONE, column4 NUMERIC, column5 REAL);", sql);
    }
}
