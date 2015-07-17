package at.blogc.tablespoon.test.tables;

import at.blogc.tablespoon.annotations.ColumnName;
import at.blogc.tablespoon.annotations.IfNotExists;
import at.blogc.tablespoon.annotations.Index;
import at.blogc.tablespoon.annotations.PrimaryKey;
import at.blogc.tablespoon.annotations.TableName;

@TableName("users")
@IfNotExists
public class UsersTable
{
    @PrimaryKey(autoIncrement = true)
    private int id;

    @Index("idx_users_name")
    private String name;

    @ColumnName("street")
    private String address;

    private Long timestamp;

    private Float floatValue;

    private Double doubleValue;

    private Integer integerValue;
}
