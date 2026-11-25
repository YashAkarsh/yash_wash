package androidx.core.content;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.util.Log;
import androidx.core.os.a1;
import c.m0;
import c.o0;
import c.t0;
import c.x0;
import com.google.common.util.concurrent.l1;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Iterator;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: classes.dex */
public final class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @x0({x0.a.LIBRARY})
    public static final String f5766a = "PackageManagerCompat";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SuppressLint({"ActionValue"})
    public static final String f5767b = "android.intent.action.AUTO_REVOKE_PERMISSIONS";

    @t0(30)
    private static class a {
        private a() {
        }

        static boolean a(@m0 Context context) {
            return !context.getPackageManager().isAutoRevokeWhitelisted();
        }
    }

    @x0({x0.a.LIBRARY})
    @Retention(RetentionPolicy.SOURCE)
    public @interface b {
    }

    private v() {
    }

    @x0({x0.a.LIBRARY})
    public static boolean a(@m0 PackageManager packageManager) {
        int i7 = Build.VERSION.SDK_INT;
        boolean z7 = i7 >= 30;
        boolean z8 = i7 < 30;
        boolean z9 = b(packageManager) != null;
        if (z7) {
            return true;
        }
        return z8 && z9;
    }

    @o0
    @x0({x0.a.LIBRARY})
    public static String b(@m0 PackageManager packageManager) {
        String str = null;
        Iterator<ResolveInfo> it = packageManager.queryIntentActivities(new Intent(f5767b).setData(Uri.fromParts("package", "com.example", null)), 0).iterator();
        while (it.hasNext()) {
            String str2 = it.next().activityInfo.packageName;
            if (packageManager.checkPermission("android.permission.PACKAGE_VERIFICATION_AGENT", str2) == 0) {
                if (str != null) {
                    return str;
                }
                str = str2;
            }
        }
        return str;
    }

    @m0
    public static l1<Integer> c(@m0 Context context) {
        androidx.concurrent.futures.e<Integer> eVarU = androidx.concurrent.futures.e.u();
        if (!a1.a(context)) {
            eVarU.p(0);
            Log.e(f5766a, "User is in locked direct boot mode");
            return eVarU;
        }
        if (!a(context.getPackageManager())) {
            eVarU.p(1);
            return eVarU;
        }
        int i7 = context.getApplicationInfo().targetSdkVersion;
        if (i7 < 30) {
            eVarU.p(0);
            Log.e(f5766a, "Target SDK version below API 30");
            return eVarU;
        }
        int i8 = Build.VERSION.SDK_INT;
        if (i8 >= 31) {
            if (a.a(context)) {
                eVarU.p(Integer.valueOf(i7 >= 31 ? 5 : 4));
            } else {
                eVarU.p(2);
            }
            return eVarU;
        }
        if (i8 == 30) {
            eVarU.p(Integer.valueOf(a.a(context) ? 4 : 2));
            return eVarU;
        }
        final a0 a0Var = new a0(context);
        eVarU.I(new Runnable() { // from class: androidx.core.content.t
            @Override // java.lang.Runnable
            public final void run() {
                a0Var.b();
            }
        }, Executors.newSingleThreadExecutor());
        a0Var.a(eVarU);
        return eVarU;
    }
}
