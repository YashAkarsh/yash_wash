package kotlin;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: classes2.dex */
@Target({ElementType.TYPE, ElementType.METHOD, ElementType.CONSTRUCTOR, ElementType.ANNOTATION_TYPE})
@y4.c
@y4.f(allowedTargets = {y4.b.CLASS, y4.b.FUNCTION, y4.b.PROPERTY, y4.b.ANNOTATION_CLASS, y4.b.CONSTRUCTOR, y4.b.PROPERTY_SETTER, y4.b.PROPERTY_GETTER, y4.b.TYPEALIAS})
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface k {
    m level() default m.WARNING;

    String message();

    b1 replaceWith() default @b1(expression = "", imports = {});
}
