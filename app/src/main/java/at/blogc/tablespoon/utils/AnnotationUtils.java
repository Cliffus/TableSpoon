package at.blogc.tablespoon.utils;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;

/**
 * Created by cliff on 02/07/15.
 */
public class AnnotationUtils
{
    public static <T extends Annotation> T findAnnotation(final AnnotatedElement annotatedElement, final Class<T> clazz)
    {
        final Annotation[] annotations = annotatedElement.getDeclaredAnnotations();
        for (final Annotation annotation : annotations)
        {
            if (annotation.annotationType() == clazz)
            {
                return (T) annotation;
            }
        }

        return null;
    }
}
