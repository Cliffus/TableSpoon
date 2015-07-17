package at.blogc.tablespoon;

import android.app.Application;
import android.database.sqlite.SQLiteOpenHelper;
import android.test.ApplicationTestCase;

import at.blogc.tablespoon.tables.UsersTable;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class ApplicationTest extends ApplicationTestCase<Application>
{
    public ApplicationTest()
    {
        super(Application.class);

        this.createApplication();

        final TableSpoon tableSpoon = new TableSpoon.Builder()
                .setContext(this.getContext())
                .setLoggingEnabled(true)
                .setDatabaseName("tablespoon")
                .build();

        final SQLiteOpenHelper sqLiteOpenHelper = tableSpoon.create(UsersTable.class);
        sqLiteOpenHelper.getWritableDatabase();
    }
}