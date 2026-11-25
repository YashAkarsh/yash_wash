package com.google.common.base;

import java.lang.ref.WeakReference;
import java.util.Locale;
import java.util.ServiceConfigurationError;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
@s1.b(emulated = true)
final class d0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Logger f19338a = Logger.getLogger(d0.class.getName());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final c0 f19339b = e();

    private static final class b implements c0 {
        private b() {
        }

        @Override // com.google.common.base.c0
        public h a(String str) {
            return new v(Pattern.compile(str));
        }

        @Override // com.google.common.base.c0
        public boolean b() {
            return true;
        }
    }

    private d0() {
    }

    static h a(String str) {
        e0.E(str);
        return f19339b.a(str);
    }

    static String b(String str) {
        if (j(str)) {
            return null;
        }
        return str;
    }

    static String c(double d8) {
        return String.format(Locale.ROOT, "%.4g", Double.valueOf(d8));
    }

    static <T extends Enum<T>> a0<T> d(Class<T> cls, String str) {
        WeakReference<? extends Enum<?>> weakReference = k.a(cls).get(str);
        return weakReference == null ? a0.a() : a0.g(cls.cast(weakReference.get()));
    }

    private static c0 e() {
        return new b();
    }

    private static void f(ServiceConfigurationError serviceConfigurationError) {
        f19338a.log(Level.WARNING, "Error loading regex compiler, falling back to next option", (Throwable) serviceConfigurationError);
    }

    static String g(String str) {
        return str == null ? "" : str;
    }

    static boolean h() {
        return f19339b.b();
    }

    static e i(e eVar) {
        return eVar.K();
    }

    static boolean j(String str) {
        return str == null || str.isEmpty();
    }

    static long k() {
        return System.nanoTime();
    }
}
