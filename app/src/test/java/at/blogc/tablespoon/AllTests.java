package at.blogc.tablespoon;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import at.blogc.tablespoon.builders.ColumnBuilderTest;
import at.blogc.tablespoon.builders.IndexBuilderTest;
import at.blogc.tablespoon.builders.TableBuilderTest;
import at.blogc.tablespoon.core.ColumnTest;
import at.blogc.tablespoon.core.IndexTest;
import at.blogc.tablespoon.core.TableTest;
import at.blogc.tablespoon.utils.SanitizeTest;
import at.blogc.tablespoon.utils.StringUtilsTest;

/**
 * Created by cliff on 09/07/15.
 */

@RunWith(Suite.class)
@Suite.SuiteClasses({ColumnBuilderTest.class, IndexBuilderTest.class, TableBuilderTest.class,
        ColumnTest.class, IndexTest.class, TableTest.class, SanitizeTest.class, StringUtilsTest.class})
public class AllTests
{

}
