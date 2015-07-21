package at.blogc.tablespoon.fixtures;

import at.blogc.tablespoon.annotations.PrimaryKey;
import at.blogc.tablespoon.annotations.Table;

@Table(ifNotExists = true)
public class UserAccountsTable
{
    @PrimaryKey(autoIncrement = true)
    public int id;

    public String name;
    public String address;
}
