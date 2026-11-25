package kotlin;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: classes2.dex */
@Target({ElementType.ANNOTATION_TYPE})
@g1(version = "1.2")
@k(message = "Please use RequiresOptIn instead.")
@l(errorSince = i2.a.f34096f, warningSince = "1.4")
@Retention(RetentionPolicy.CLASS)
@y4.f(allowedTargets = {y4.b.ANNOTATION_CLASS})
@y4.e(y4.a.BINARY)
public @interface q {

    public enum a {
        WARNING,
        ERROR
    }

    a level() default a.ERROR;
}
