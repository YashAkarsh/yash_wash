package kotlinx.coroutines;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: classes2.dex */
@Target({ElementType.TYPE, ElementType.METHOD})
@y4.f(allowedTargets = {y4.b.CLASS, y4.b.FUNCTION, y4.b.TYPEALIAS, y4.b.PROPERTY})
@kotlin.c1(level = kotlin.c1.a.ERROR, message = "This is an internal kotlinx.coroutines API that should not be used from outside of kotlinx.coroutines. No compatibility guarantees are provided. It is recommended to report your use-case of internal API to kotlinx.coroutines issue tracker, so stable API could be provided instead")
@Retention(RetentionPolicy.CLASS)
@y4.e(y4.a.BINARY)
public @interface j2 {
}
