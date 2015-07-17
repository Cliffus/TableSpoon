package at.blogc.tablespoon.builders;

import at.blogc.tablespoon.core.SQLiteObject;

/**
 * Created by cliff on 12/07/15.
 */
public interface SQLiteObjectBuilder<T extends SQLiteObject>
{
    T build() throws IllegalStateException;
}
