package c;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: classes.dex */
@Target({ElementType.ANNOTATION_TYPE, ElementType.METHOD, ElementType.CONSTRUCTOR, ElementType.FIELD, ElementType.PARAMETER})
@Documented
@Retention(RetentionPolicy.CLASS)
public @interface w0 {

    @Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
    public @interface a {
        w0 value() default @w0;
    }

    @Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
    public @interface b {
        w0 value() default @w0;
    }

    String[] allOf() default {};

    String[] anyOf() default {};

    boolean conditional() default false;

    String value() default "";
}
