package kotlin;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: classes2.dex */
@Target({ElementType.TYPE})
@g1(version = "1.3")
@y4.f(allowedTargets = {y4.b.CLASS})
@Retention(RetentionPolicy.RUNTIME)
@y4.e(y4.a.RUNTIME)
public @interface i0 {

    public static final class a {
        @k(level = m.WARNING, message = "Bytecode version had no significant use in Kotlin metadata and it will be removed in a future version.")
        public static /* synthetic */ void a() {
        }

        @g1(version = "1.2")
        public static /* synthetic */ void b() {
        }

        @g1(version = "1.1")
        public static /* synthetic */ void c() {
        }
    }

    @h5.h(name = "bv")
    int[] bv() default {1, 0, 3};

    @h5.h(name = "d1")
    String[] d1() default {};

    @h5.h(name = "d2")
    String[] d2() default {};

    @h5.h(name = "k")
    int k() default 1;

    @h5.h(name = "mv")
    int[] mv() default {};

    @h5.h(name = "pn")
    String pn() default "";

    @h5.h(name = "xi")
    int xi() default 0;

    @h5.h(name = "xs")
    String xs() default "";
}
