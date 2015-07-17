package at.blogc.tablespoon.utils;

/**
 * Created by cliff on 02/07/15.
 */
public class Log
{
    private boolean loggingEnabled;

    public void setLoggingEnabled(final boolean loggingEnabled)
    {
        this.loggingEnabled = loggingEnabled;
    }

    public int d(final String tag, final String msg)
    {
        return this.loggingEnabled
                ?  android.util.Log.d(tag, msg)
                : -1;
    }

    public int d(final String tag, final String msg, final Throwable tr)
    {
        return this.loggingEnabled
                ?  android.util.Log.d(tag, msg, tr)
                : -1;
    }
}
