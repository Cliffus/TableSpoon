package at.blogc.tablespoon.tables;

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
    int id;

    @Index("idx_users_name")
    String name;

    @ColumnName("street")
    String address;

    Long timestamp;

    Float floatValue;
}
