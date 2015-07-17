package at.blogc.tablespoon.core;

/**
 * Created by cliff on 06/07/15.
 */
public interface SQLiteObject
{
    /**
     * Generates the corresponding SQL for this Object.
     *
     * @return the SQL statement
     * @throws IllegalStateException
     */
    String generateSQL() throws IllegalStateException;
}
