package at.blogc.tablespoon.fixtures;

import at.blogc.tablespoon.annotations.ColumnName;
import at.blogc.tablespoon.annotations.PrimaryKey;
import at.blogc.tablespoon.annotations.Table;

@Table(name = "users")
public class UsersTableWithStaticFields
{
    @PrimaryKey()
    public static int id;

    @ColumnName("name")
    public static String COLUMN_NAME;
    @ColumnName("address")
    public static String COLUMN_ADDRESS;
    @ColumnName("timestamp")
    public static Long COLUMN_TIMESTAMP;
    @ColumnName("floatValue")
    public static Float COLUMN_FLOAT_VALUE;
    @ColumnName("doubleValue")
    public static Double COLUMN_DOUBLE_VALUE;
    @ColumnName("integerValue")
    public static Integer COLUMN_INTEGER_VALUE;
}
