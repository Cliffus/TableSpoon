package at.blogc.tablespoon.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by cliff on 02/07/15.
 */
@Documented
@Target(FIELD)
@Retention(RUNTIME)
public @interface PrimaryKey
{
    /**
     * Enable or disable autoincrement, default = true.
     * @return
     */
    boolean autoIncrement() default false;
}
