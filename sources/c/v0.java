package c;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: classes.dex */
@Target({ElementType.ANNOTATION_TYPE})
@y4.f(allowedTargets = {y4.b.ANNOTATION_CLASS})
@Retention(RetentionPolicy.CLASS)
@y4.e(y4.a.BINARY)
public @interface v0 {

    public enum a {
        WARNING,
        ERROR
    }

    a level() default a.ERROR;
}
