package androidx.core.content.pm;

import android.annotation.SuppressLint;
import android.content.pm.PermissionInfo;
import android.os.Build;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes.dex */
public final class k {

    @c.t0(28)
    static class a {
        private a() {
        }

        @c.t
        static int a(PermissionInfo permissionInfo) {
            return permissionInfo.getProtection();
        }

        @c.t
        static int b(PermissionInfo permissionInfo) {
            return permissionInfo.getProtectionFlags();
        }
    }

    @c.x0({c.x0.a.LIBRARY})
    @Retention(RetentionPolicy.SOURCE)
    public @interface b {
    }

    @c.x0({c.x0.a.LIBRARY})
    @SuppressLint({"UniqueConstants"})
    @Retention(RetentionPolicy.SOURCE)
    public @interface c {
    }

    private k() {
    }

    @SuppressLint({"WrongConstant"})
    public static int a(@c.m0 PermissionInfo permissionInfo) {
        return Build.VERSION.SDK_INT >= 28 ? a.a(permissionInfo) : permissionInfo.protectionLevel & 15;
    }

    @SuppressLint({"WrongConstant"})
    public static int b(@c.m0 PermissionInfo permissionInfo) {
        return Build.VERSION.SDK_INT >= 28 ? a.b(permissionInfo) : permissionInfo.protectionLevel & (-16);
    }
}
