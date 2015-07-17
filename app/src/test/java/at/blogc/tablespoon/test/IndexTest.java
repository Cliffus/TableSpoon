package at.blogc.tablespoon.test;

import org.junit.Test;

import at.blogc.tablespoon.core.Index;
import static org.junit.Assert.assertEquals;

public class IndexTest
{
    @Test
    public void testCreateIndex()
    {
        final Index index = new Index()
                .setTableName("test")
                .setColumns("column1", "column2", "column3");

        final String sql = index.generateSQL();
        System.out.println("SQL: " + sql);

        assertEquals("CREATE INDEX idx_test_column1_column2_column3 ON test (column1, column2, column3);", sql);
    }

    @Test
    public void testCreateIndexIfNotExists()
    {
        final Index index = new Index()
                .setIfNotExists(true)
                .setTableName("test")
                .setColumns("column1", "column2", "column3");

        final String sql = index.generateSQL();
        System.out.println("SQL: " + sql);

        assertEquals("CREATE INDEX IF NOT EXISTS idx_test_column1_column2_column3 ON test (column1, column2, column3);", sql);
    }

    @Test
    public void testCreateUniqueIndex()
    {
        final Index index = new Index()
                .setIfNotExists(true)
                .setTableName("test")
                .setUnique(true)
                .setColumns("column1", "column2", "column3");

        final String sql = index.generateSQL();
        System.out.println("SQL: " + sql);

        assertEquals("CREATE UNIQUE INDEX IF NOT EXISTS idx_test_column1_column2_column3 ON test (column1, column2, column3);", sql);
    }
}
