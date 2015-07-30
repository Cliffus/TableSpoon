package at.blogc.tablespoon.fixtures;

import at.blogc.tablespoon.annotations.Column;
import at.blogc.tablespoon.annotations.PrimaryKey;
import at.blogc.tablespoon.annotations.Table;

@Table(name = "users", ifNotExists = true)
public class UsersTable
{
    @PrimaryKey(autoIncrement = true)
    public int id;

    public String name;

    @Column(name = "street")
    public String address;

    public Long timestamp;

    public Float floatValue;

    public Double doubleValue;

    public Integer integerValue;
}
