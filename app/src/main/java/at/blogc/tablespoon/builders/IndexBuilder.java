package at.blogc.tablespoon.builders;

import at.blogc.tablespoon.core.Index;

/**
 * Created by cliff on 15/07/15.
 */
public class IndexBuilder implements SQLiteObjectBuilder<Index>
{
    private final Class table;

    public IndexBuilder(final Class table)
    {
        super();

        this.table = table;
    }

    /*
     * SQLiteObjectBuilder<Index>
     */

    @Override
    public Index build() throws IllegalStateException
    {
        if (this.table == null)
        {
            throw new IllegalStateException("table cannot be null.");
        }

        return null;
    }
}
