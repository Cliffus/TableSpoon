package at.blogc.tablespoon.fixtures;

import at.blogc.tablespoon.annotations.Column;
import at.blogc.tablespoon.annotations.PrimaryKey;
import at.blogc.tablespoon.annotations.Table;

@Table(name = "users")
public class UsersTableWithNotNullColumn
{
    @PrimaryKey(autoIncrement = true)
    public int id;

    @Column(notNull = true)
    public String name;
    public String address;
    public Long timestamp;
    public Float floatValue;
    public Double doubleValue;
    public Integer integerValue;
}
