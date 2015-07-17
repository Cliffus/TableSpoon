package at.blogc.tablespoon.core;

/**
 * Created by cliff on 08/07/15.
 */
public enum DataType
{
    TEXT    (new Class[]{ String.class, CharSequence.class, Character.class }),
    INTEGER (new Class[]{ Integer.class, Integer.TYPE, Boolean.class }),
    REAL    (new Class[]{ Float.class, Double.class }),
    NUMERIC (new Class[]{ Long.class }),
    NONE;

    final Class[] clazz;

    DataType()
    {
        this.clazz = new Class[0];
    }

    DataType(final Class[] clazz)
    {
        this.clazz = clazz;
    }

    public static DataType fromClass(final Class clazz)
    {
        for (final DataType dataType : DataType.values())
        {
            for (final Class aClass : dataType.clazz)
            {
                if (aClass == clazz)
                {
                    return dataType;
                }
            }
        }

        return NONE;
    }
}
