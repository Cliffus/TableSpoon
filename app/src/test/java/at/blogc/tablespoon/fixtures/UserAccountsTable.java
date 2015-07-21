package at.blogc.tablespoon.fixtures;

import at.blogc.tablespoon.annotations.IfNotExists;
import at.blogc.tablespoon.annotations.PrimaryKey;

@IfNotExists
public class UserAccountsTable
{
    @PrimaryKey(autoIncrement = true)
    public int id;

    public String name;
    public String address;
}
