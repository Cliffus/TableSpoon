package at.blogc.tablespoon.fixtures;

import at.blogc.tablespoon.annotations.Column;
import at.blogc.tablespoon.annotations.PrimaryKey;
import at.blogc.tablespoon.annotations.Table;

@Table(name = "users")
public class UsersTableWithStaticFields
{
    @PrimaryKey()
    public static int id;

    @Column(name = "name")
    public static String COLUMN_NAME;
    @Column(name = "address")
    public static String COLUMN_ADDRESS;
    @Column(name = "timestamp")
    public static Long COLUMN_TIMESTAMP;
    @Column(name = "floatValue")
    public static Float COLUMN_FLOAT_VALUE;
    @Column(name = "doubleValue")
    public static Double COLUMN_DOUBLE_VALUE;
    @Column(name = "integerValue")
    public static Integer COLUMN_INTEGER_VALUE;
}
