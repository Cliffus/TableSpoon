package at.blogc.tablespoon.fixtures;

import at.blogc.tablespoon.annotations.PrimaryKey;
import at.blogc.tablespoon.annotations.TableName;

@TableName("users")
public class UsersTableWithInvalidPrimaryKey
{
    @PrimaryKey(autoIncrement = true)
    private String id;

    public static String name;
    public static String address;
    public static Long timestamp;
    public static Float floatValue;
    public static Double doubleColumn;
    public static Integer integerValue;
}
