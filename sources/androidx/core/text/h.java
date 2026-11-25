package androidx.core.text;

import android.annotation.SuppressLint;
import android.icu.util.ULocale;
import android.os.Build;
import android.util.Log;
import c.t0;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f6259a = "ICUCompat";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Method f6260b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Method f6261c;

    @t0(21)
    static class a {
        private a() {
        }

        @c.t
        static String a(Locale locale) {
            return locale.getScript();
        }
    }

    @t0(24)
    static class b {
        private b() {
        }

        @c.t
        static ULocale a(Object obj) {
            return ULocale.addLikelySubtags(i.a(obj));
        }

        @c.t
        static ULocale b(Locale locale) {
            return ULocale.forLocale(locale);
        }

        @c.t
        static String c(Object obj) {
            return i.a(obj).getScript();
        }
    }

    static {
        if (Build.VERSION.SDK_INT < 24) {
            try {
                f6261c = Class.forName("libcore.icu.ICU").getMethod("addLikelySubtags", Locale.class);
            } catch (Exception e8) {
                throw new IllegalStateException(e8);
            }
        }
    }

    private h() {
    }

    @SuppressLint({"BanUncheckedReflection"})
    private static String a(Locale locale) {
        String string = locale.toString();
        try {
            Method method = f6261c;
            if (method != null) {
                return (String) method.invoke(null, string);
            }
        } catch (IllegalAccessException e8) {
            Log.w(f6259a, e8);
        } catch (InvocationTargetException e9) {
            Log.w(f6259a, e9);
        }
        return string;
    }

    @SuppressLint({"BanUncheckedReflection"})
    private static String b(String str) {
        try {
            Method method = f6260b;
            if (method != null) {
                return (String) method.invoke(null, str);
            }
        } catch (IllegalAccessException e8) {
            Log.w(f6259a, e8);
        } catch (InvocationTargetException e9) {
            Log.w(f6259a, e9);
        }
        return null;
    }

    @c.o0
    public static String c(@c.m0 Locale locale) {
        if (Build.VERSION.SDK_INT >= 24) {
            return b.c(b.a(b.b(locale)));
        }
        try {
            return a.a((Locale) f6261c.invoke(null, locale));
        } catch (IllegalAccessException e8) {
            Log.w(f6259a, e8);
            return a.a(locale);
        } catch (InvocationTargetException e9) {
            Log.w(f6259a, e9);
            return a.a(locale);
        }
    }
}
