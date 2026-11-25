package org.junit;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: classes3.dex */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface m {

    public static class a extends Throwable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final long f39913a = 1;

        private a() {
        }
    }

    Class<? extends Throwable> expected() default a.class;

    long timeout() default 0;
}
