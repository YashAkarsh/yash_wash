package androidx.core.app;

import android.app.AppOpsManager;
import android.content.Context;
import android.os.Binder;
import android.os.Build;

/* JADX INFO: loaded from: classes.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f5461a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f5462b = 1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f5463c = 2;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f5464d = 3;

    @c.t0(19)
    static class a {
        private a() {
        }

        @c.t
        static int a(AppOpsManager appOpsManager, String str, int i7, String str2) {
            return appOpsManager.noteOp(str, i7, str2);
        }

        @c.t
        static int b(AppOpsManager appOpsManager, String str, int i7, String str2) {
            return appOpsManager.noteOpNoThrow(str, i7, str2);
        }
    }

    @c.t0(23)
    static class b {
        private b() {
        }

        @c.t
        static <T> T a(Context context, Class<T> cls) {
            return (T) context.getSystemService(cls);
        }

        @c.t
        static int b(AppOpsManager appOpsManager, String str, String str2) {
            return appOpsManager.noteProxyOp(str, str2);
        }

        @c.t
        static int c(AppOpsManager appOpsManager, String str, String str2) {
            return appOpsManager.noteProxyOpNoThrow(str, str2);
        }

        @c.t
        static String d(String str) {
            return AppOpsManager.permissionToOp(str);
        }
    }

    @c.t0(29)
    static class c {
        private c() {
        }

        @c.t
        static int a(@c.o0 AppOpsManager appOpsManager, @c.m0 String str, int i7, @c.m0 String str2) {
            if (appOpsManager == null) {
                return 1;
            }
            return appOpsManager.checkOpNoThrow(str, i7, str2);
        }

        @c.m0
        @c.t
        static String b(@c.m0 Context context) {
            return context.getOpPackageName();
        }

        @c.o0
        @c.t
        static AppOpsManager c(@c.m0 Context context) {
            return (AppOpsManager) context.getSystemService(AppOpsManager.class);
        }
    }

    private p() {
    }

    public static int a(@c.m0 Context context, int i7, @c.m0 String str, @c.m0 String str2) {
        if (Build.VERSION.SDK_INT < 29) {
            return e(context, str, str2);
        }
        AppOpsManager appOpsManagerC = c.c(context);
        int iA = c.a(appOpsManagerC, str, Binder.getCallingUid(), str2);
        return iA != 0 ? iA : c.a(appOpsManagerC, str, i7, c.b(context));
    }

    public static int b(@c.m0 Context context, @c.m0 String str, int i7, @c.m0 String str2) {
        return a.a((AppOpsManager) context.getSystemService("appops"), str, i7, str2);
    }

    public static int c(@c.m0 Context context, @c.m0 String str, int i7, @c.m0 String str2) {
        return a.b((AppOpsManager) context.getSystemService("appops"), str, i7, str2);
    }

    public static int d(@c.m0 Context context, @c.m0 String str, @c.m0 String str2) {
        return b.b((AppOpsManager) b.a(context, AppOpsManager.class), str, str2);
    }

    public static int e(@c.m0 Context context, @c.m0 String str, @c.m0 String str2) {
        return b.c((AppOpsManager) b.a(context, AppOpsManager.class), str, str2);
    }

    @c.o0
    public static String f(@c.m0 String str) {
        return b.d(str);
    }
}
