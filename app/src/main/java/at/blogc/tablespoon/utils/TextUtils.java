package at.blogc.tablespoon.utils;

/**
 * Created by cliff on 08/07/15.
 */
public class TextUtils
{
    public static boolean isEmpty(final CharSequence string)
    {
        return string == null || string.length() == 0;
    }
}
