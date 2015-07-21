package at.blogc.tablespoon;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

import at.blogc.tablespoon.builders.TableBuilder;
import at.blogc.tablespoon.core.SQLiteObject;
import at.blogc.tablespoon.utils.Log;
import at.blogc.tablespoon.utils.Utils;

/**
 * Created by cliff on 02/07/15.
 */
public final class TableSpoon
{
    private static final String TAG = "TableSpoon";

    private final Log log;
    private Context context;

    private String databaseName;
    private int databaseVersion;

    private TableSpoon()
    {
        super();

        this.log = new Log();
    }

    /**
     * Create the {@link SQLiteOpenHelper} object.
     *
     * @param tables
     * @return
     */
    public SQLiteOpenHelper create(final @NonNull Class... tables)
    {
        // validate tables
        this.log.d(TAG, "Validating tables...");

        if (tables == null || tables.length == 0)
        {
            throw new IllegalArgumentException("tables cannot be null or empty.");
        }

        for (final Class aClass : tables)
        {
            this.log.d(TAG, aClass.getName() + ".class");
            Utils.validateTableClass(aClass);
        }

        this.log.d(TAG, "All tables are valid.");

        // loop over all classes and generate SQL
        final List<SQLiteObject> sqLiteObjects = new ArrayList<>();
        SQLiteObject sqLiteObject;

        for (final Class clazz : tables)
        {
            this.log.d(TAG, "Building table for class " + clazz.getName());
            sqLiteObject = new TableBuilder(clazz).build();
            sqLiteObjects.add(sqLiteObject);
        }

        // create database helper object
        final SQLiteOpenHelper sqLiteOpenHelper = new SQLiteOpenHelper(this.context, this.databaseName, null, this.databaseVersion)
        {
            @Override
            public void onCreate(final SQLiteDatabase db)
            {
                for (final SQLiteObject sqLiteObject : sqLiteObjects)
                {
                    db.execSQL(sqLiteObject.generateSQL());
                }
            }

            @Override
            public void onUpgrade(final SQLiteDatabase db, final int oldVersion, final int newVersion)
            {
                //TODO support upgrades
            }
        };

        return sqLiteOpenHelper;
    }

    public static final class Builder
    {
        private final TableSpoon tableSpoon;

        public Builder()
        {
            super();

            this.tableSpoon = new TableSpoon();
        }

        /**
         *
         *
         * @param context
         * @return
         */
        public Builder setContext(final Context context)
        {
            this.tableSpoon.context = context;

            return this;
        }

        /**
         * Enable or disable logging.
         *
         * @param loggingEnabled
         * @return
         */
        public Builder setLoggingEnabled(final boolean loggingEnabled)
        {
            this.tableSpoon.log.setLoggingEnabled(loggingEnabled);

            return this;
        }

        /**
         * Sets the database name.
         *
         * @param databaseName
         * @return
         */
        public Builder setDatabaseName(final String databaseName)
        {
            this.tableSpoon.databaseName = databaseName;

            return this;
        }

        /**
         * Sets the database version (starting at 1). By default, TableSpoon uses 1.
         * @param databaseVersion
         * @return
         */
        public Builder setDatabaseVersion(final int databaseVersion)
        {
            this.tableSpoon.databaseVersion = databaseVersion;

            return this;
        }

        /**
         * Create the {@link TableSpoon} instance.
         * @return
         */
        public TableSpoon build()
        {
            if (this.tableSpoon.context == null)
            {
                throw new IllegalStateException("context is required to create database.");
            }

            if (this.tableSpoon.databaseName == null || this.tableSpoon.databaseName.isEmpty())
            {
                throw new IllegalStateException("database name cannot be null or empty.");
            }

            if (this.tableSpoon.databaseVersion <= 0)
            {
                throw new IllegalStateException("database version should start at 1.");
            }

            return this.tableSpoon;
        }
    }
}
