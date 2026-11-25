package androidx.core.app;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public final class r {

    @c.t0(18)
    static class a {
        private a() {
        }

        @c.t
        static IBinder a(Bundle bundle, String str) {
            return bundle.getBinder(str);
        }

        @c.t
        static void b(Bundle bundle, String str, IBinder iBinder) {
            bundle.putBinder(str, iBinder);
        }
    }

    @SuppressLint({"BanUncheckedReflection"})
    static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final String f5465a = "BundleCompatBaseImpl";

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static Method f5466b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static boolean f5467c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static Method f5468d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static boolean f5469e;

        private b() {
        }

        public static IBinder a(Bundle bundle, String str) {
            if (!f5467c) {
                try {
                    Method method = Bundle.class.getMethod("getIBinder", String.class);
                    f5466b = method;
                    method.setAccessible(true);
                } catch (NoSuchMethodException e8) {
                    Log.i(f5465a, "Failed to retrieve getIBinder method", e8);
                }
                f5467c = true;
            }
            Method method2 = f5466b;
            if (method2 != null) {
                try {
                    return (IBinder) method2.invoke(bundle, str);
                } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e9) {
                    Log.i(f5465a, "Failed to invoke getIBinder via reflection", e9);
                    f5466b = null;
                }
            }
            return null;
        }

        public static void b(Bundle bundle, String str, IBinder iBinder) {
            if (!f5469e) {
                try {
                    Method method = Bundle.class.getMethod("putIBinder", String.class, IBinder.class);
                    f5468d = method;
                    method.setAccessible(true);
                } catch (NoSuchMethodException e8) {
                    Log.i(f5465a, "Failed to retrieve putIBinder method", e8);
                }
                f5469e = true;
            }
            Method method2 = f5468d;
            if (method2 != null) {
                try {
                    method2.invoke(bundle, str, iBinder);
                } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e9) {
                    Log.i(f5465a, "Failed to invoke putIBinder via reflection", e9);
                    f5468d = null;
                }
            }
        }
    }

    private r() {
    }

    @c.o0
    public static IBinder a(@c.m0 Bundle bundle, @c.o0 String str) {
        return a.a(bundle, str);
    }

    public static void b(@c.m0 Bundle bundle, @c.o0 String str, @c.o0 IBinder iBinder) {
        a.b(bundle, str, iBinder);
    }
}
