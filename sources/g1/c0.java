package g1;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.PackageManager;
import android.util.Log;
import c.m0;

/* JADX INFO: loaded from: classes.dex */
@c1.a
public final class c0 {
    private c0() {
    }

    @c1.a
    public static boolean a(@m0 Context context, int i7) {
        if (!b(context, i7, "com.google.android.gms")) {
            return false;
        }
        try {
            return com.google.android.gms.common.m.a(context).b(context.getPackageManager().getPackageInfo("com.google.android.gms", 64));
        } catch (PackageManager.NameNotFoundException unused) {
            if (Log.isLoggable("UidVerifier", 3)) {
                Log.d("UidVerifier", "Package manager can't find google play services package, defaulting to false");
            }
            return false;
        }
    }

    @c1.a
    @TargetApi(19)
    public static boolean b(@m0 Context context, int i7, @m0 String str) {
        return com.google.android.gms.common.wrappers.d.a(context).h(i7, str);
    }
}
