package net.kjp12.bic.deprecated;//Created on 7/8/18.

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Now you can deprecate using a deprecated annotation. Why? Because why not.
 *
 * @deprecated Deprecated before it was even released?! What's this!
 */

@Deprecated
@java.lang.Deprecated
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.CONSTRUCTOR, ElementType.FIELD, ElementType.LOCAL_VARIABLE, ElementType.METHOD, ElementType.PACKAGE, ElementType.PARAMETER, ElementType.TYPE})
public @interface Deprecated {
}