package d;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.b1;
import kotlin.k;
import y4.e;
import y4.f;

/* JADX INFO: loaded from: classes.dex */
@Target({ElementType.ANNOTATION_TYPE})
@k(message = "This annotation has been replaced by `@RequiresOptIn`", replaceWith = @b1(expression = "RequiresOptIn", imports = {"androidx.annotation.RequiresOptIn"}))
@f(allowedTargets = {y4.b.ANNOTATION_CLASS})
@Retention(RetentionPolicy.CLASS)
@e(y4.a.BINARY)
public @interface a {

    /* JADX INFO: renamed from: d.a$a, reason: collision with other inner class name */
    public enum EnumC0404a {
        WARNING,
        ERROR
    }

    EnumC0404a level() default EnumC0404a.ERROR;
}
