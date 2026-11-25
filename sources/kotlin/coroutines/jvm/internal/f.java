package kotlin.coroutines.jvm.internal;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.g1;

/* JADX INFO: loaded from: classes2.dex */
@Target({ElementType.TYPE})
@g1(version = "1.3")
@y4.f(allowedTargets = {y4.b.CLASS})
@Retention(RetentionPolicy.RUNTIME)
public @interface f {
    @h5.h(name = "c")
    String c() default "";

    @h5.h(name = "f")
    String f() default "";

    @h5.h(name = "i")
    int[] i() default {};

    @h5.h(name = "l")
    int[] l() default {};

    @h5.h(name = "m")
    String m() default "";

    @h5.h(name = "n")
    String[] n() default {};

    @h5.h(name = "s")
    String[] s() default {};

    @h5.h(name = "v")
    int v() default 1;
}
