package at.blogc.tablespoon.utils;

/**
 * Created by cliff on 13/07/15.
 */
public class StringUtils
{
    private static final String regex_camelCaseToUnderscore = "([a-z])([A-Z]+)";
    private static final String replacement_camelCaseToUnderscore = "$1_$2";

    public static String camelCaseToUnderscores(final String input)
    {
        return input
                .replaceAll(regex_camelCaseToUnderscore, replacement_camelCaseToUnderscore)
                .toLowerCase();
    }
}
