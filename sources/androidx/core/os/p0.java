package androidx.core.os;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Process;
import android.os.UserHandle;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public final class p0 {

    @c.t0(16)
    static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final Object f6098a = new Object();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static Method f6099b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static boolean f6100c;

        private a() {
        }

        @SuppressLint({"PrivateApi"})
        static boolean a(int i7) {
            try {
                synchronized (f6098a) {
                    if (!f6100c) {
                        f6100c = true;
                        f6099b = Class.forName("android.os.UserId").getDeclaredMethod("isApp", Integer.TYPE);
                    }
                }
                Method method = f6099b;
                if (method != null) {
                    Boolean bool = (Boolean) method.invoke(null, Integer.valueOf(i7));
                    if (bool != null) {
                        return bool.booleanValue();
                    }
                    throw new NullPointerException();
                }
            } catch (Exception e8) {
                e8.printStackTrace();
            }
            return true;
        }
    }

    @c.t0(17)
    static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final Object f6101a = new Object();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static Method f6102b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static boolean f6103c;

        private b() {
        }

        @SuppressLint({"DiscouragedPrivateApi"})
        static boolean a(int i7) {
            try {
                synchronized (f6101a) {
                    if (!f6103c) {
                        f6103c = true;
                        f6102b = UserHandle.class.getDeclaredMethod("isApp", Integer.TYPE);
                    }
                }
                Method method = f6102b;
                if (method != null) {
                    Boolean bool = (Boolean) method.invoke(null, Integer.valueOf(i7));
                    if (bool != null) {
                        return bool.booleanValue();
                    }
                    throw new NullPointerException();
                }
            } catch (Exception e8) {
                e8.printStackTrace();
            }
            return true;
        }
    }

    @c.t0(24)
    static class c {
        private c() {
        }

        static boolean a(int i7) {
            return Process.isApplicationUid(i7);
        }
    }

    private p0() {
    }

    public static boolean a(int i7) {
        return Build.VERSION.SDK_INT >= 24 ? c.a(i7) : b.a(i7);
    }
}
