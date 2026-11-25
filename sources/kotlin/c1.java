package kotlin;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: classes2.dex */
@Target({ElementType.ANNOTATION_TYPE})
@g1(version = "1.3")
@y4.f(allowedTargets = {y4.b.ANNOTATION_CLASS})
@Retention(RetentionPolicy.CLASS)
@y4.e(y4.a.BINARY)
public @interface c1 {

    public enum a {
        WARNING,
        ERROR
    }

    a level() default a.ERROR;

    String message() default "";
}
