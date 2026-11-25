package androidx.core.content;

import android.content.Context;
import android.os.Binder;
import android.os.Process;
import c.m0;
import c.o0;
import c.x0;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes.dex */
public final class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f5768a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f5769b = -1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f5770c = -2;

    @x0({x0.a.LIBRARY_GROUP_PREFIX})
    @Retention(RetentionPolicy.SOURCE)
    public @interface a {
    }

    private w() {
    }

    public static int a(@m0 Context context, @m0 String str) {
        return c(context, str, Binder.getCallingPid(), Binder.getCallingUid(), Binder.getCallingPid() == Process.myPid() ? context.getPackageName() : null);
    }

    public static int b(@m0 Context context, @m0 String str, @o0 String str2) {
        if (Binder.getCallingPid() == Process.myPid()) {
            return -1;
        }
        return c(context, str, Binder.getCallingPid(), Binder.getCallingUid(), str2);
    }

    public static int c(@m0 Context context, @m0 String str, int i7, int i8, @o0 String str2) {
        if (context.checkPermission(str, i7, i8) == -1) {
            return -1;
        }
        String strF = androidx.core.app.p.f(str);
        if (strF == null) {
            return 0;
        }
        if (str2 == null) {
            String[] packagesForUid = context.getPackageManager().getPackagesForUid(i8);
            if (packagesForUid == null || packagesForUid.length <= 0) {
                return -1;
            }
            str2 = packagesForUid[0];
        }
        return (Process.myUid() == i8 && androidx.core.util.r.a(context.getPackageName(), str2) ? androidx.core.app.p.a(context, i8, strF, str2) : androidx.core.app.p.e(context, strF, str2)) == 0 ? 0 : -2;
    }

    public static int d(@m0 Context context, @m0 String str) {
        return c(context, str, Process.myPid(), Process.myUid(), context.getPackageName());
    }
}
