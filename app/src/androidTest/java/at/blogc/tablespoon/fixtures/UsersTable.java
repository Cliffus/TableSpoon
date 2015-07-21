package at.blogc.tablespoon.fixtures;

import at.blogc.tablespoon.annotations.ColumnName;
import at.blogc.tablespoon.annotations.Index;
import at.blogc.tablespoon.annotations.PrimaryKey;
import at.blogc.tablespoon.annotations.Table;

@Table(name = "users", ifNotExists = true)
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
