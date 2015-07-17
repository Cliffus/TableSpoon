package at.blogc.tablespoon.utils;

/**
 * Created by cliff on 02/07/15.
 */
public class Utils
{
    public static <T> void validateTableClass(Class<T> table)
    {
        if (table.isInterface())
        {
            throw new IllegalStateException("Only class definitions are supported.");
        }

        // Prevent class from extending other interfaces. This not only avoids a bug in
        // Android (http://b.android.com/58753) but it forces composition of API declarations which is
        // the recommended pattern.
        if (table.getInterfaces().length > 0)
        {
            throw new IllegalStateException("Class definitions must not extend other interfaces.");
        }

        if (table.getFields().length == 0)
        {
            throw new IllegalStateException("Class definitions must have fields.");
        }
    }
}
