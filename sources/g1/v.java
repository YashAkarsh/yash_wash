package g1;

import android.os.Build;

/* JADX INFO: loaded from: classes.dex */
@d0
@c1.a
public final class v {
    private v() {
    }

    @c1.a
    public static boolean a() {
        return true;
    }

    @c1.a
    public static boolean b() {
        return true;
    }

    @c1.a
    public static boolean c() {
        return true;
    }

    @c1.a
    public static boolean d() {
        return true;
    }

    @c1.a
    public static boolean e() {
        return true;
    }

    @c1.a
    public static boolean f() {
        return true;
    }

    @c1.a
    public static boolean g() {
        return true;
    }

    @c1.a
    public static boolean h() {
        return true;
    }

    @c1.a
    public static boolean i() {
        return true;
    }

    @c1.a
    public static boolean j() {
        return true;
    }

    @c1.a
    public static boolean k() {
        return true;
    }

    @c1.a
    public static boolean l() {
        return true;
    }

    @c1.a
    public static boolean m() {
        return Build.VERSION.SDK_INT >= 24;
    }

    @c1.a
    public static boolean n() {
        return Build.VERSION.SDK_INT >= 26;
    }

    @c1.a
    public static boolean o() {
        return Build.VERSION.SDK_INT >= 28;
    }

    @c1.a
    public static boolean p() {
        return Build.VERSION.SDK_INT >= 29;
    }

    @c1.a
    public static boolean q() {
        return Build.VERSION.SDK_INT >= 30;
    }

    @c1.a
    public static boolean r() {
        if (Build.VERSION.SDK_INT >= 31) {
            return true;
        }
        if (!q()) {
            return false;
        }
        String str = Build.VERSION.CODENAME;
        return str.length() == 1 && str.charAt(0) >= 'S' && str.charAt(0) <= 'Z';
    }

    @c1.a
    public static boolean s() {
        if (!r()) {
            return false;
        }
        String str = Build.VERSION.CODENAME;
        return str.charAt(0) >= 'T' && str.charAt(0) <= 'Z';
    }
}
