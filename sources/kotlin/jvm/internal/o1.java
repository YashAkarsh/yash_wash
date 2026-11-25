package kotlin.jvm.internal;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: classes2.dex */
@Target({ElementType.TYPE})
@kotlin.g1(version = i2.a.f34096f)
@y4.f(allowedTargets = {y4.b.CLASS})
@Retention(RetentionPolicy.CLASS)
@y4.e(y4.a.BINARY)
public @interface o1 {
    @h5.h(name = "b")
    String[] b() default {};
}
