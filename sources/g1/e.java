package g1;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import c.m0;
import c.o0;

/* JADX INFO: loaded from: classes.dex */
@c1.a
public class e {
    private e() {
    }

    @c1.a
    public static int a(@m0 Context context, @m0 String str) {
        ApplicationInfo applicationInfo;
        Bundle bundle;
        PackageInfo packageInfoB = b(context, str);
        if (packageInfoB == null || (applicationInfo = packageInfoB.applicationInfo) == null || (bundle = applicationInfo.metaData) == null) {
            return -1;
        }
        return bundle.getInt("com.google.android.gms.version", -1);
    }

    @o0
    @c1.a
    public static PackageInfo b(@m0 Context context, @m0 String str) {
        try {
            return com.google.android.gms.common.wrappers.d.a(context).f(str, 128);
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    @c1.a
    public static boolean c() {
        return false;
    }
}
