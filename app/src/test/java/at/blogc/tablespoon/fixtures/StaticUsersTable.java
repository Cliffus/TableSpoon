package at.blogc.tablespoon.fixtures;

import at.blogc.tablespoon.annotations.ColumnName;
import at.blogc.tablespoon.annotations.IfNotExists;
import at.blogc.tablespoon.annotations.PrimaryKey;
import at.blogc.tablespoon.annotations.TableName;

public class StaticUsersTable
{
    @TableName("users")
    @IfNotExists
    public static class UsersTable
    {
        @PrimaryKey(autoIncrement = true)
        public int id;

        public String name;

        @ColumnName("street")
        public String address;

        public Long timestamp;

        public Float floatValue;

        public Double doubleValue;

        public Integer integerValue;
    }
}

