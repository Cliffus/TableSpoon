package at.blogc.tablespoon.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by cliff on 02/07/15.
 */
@Documented
@Target(TYPE)
@Retention(RUNTIME)
public @interface Table
{
    String name() default "";
    boolean ifNotExists() default false;
}
