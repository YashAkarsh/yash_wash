package androidx.core.os;

import android.annotation.SuppressLint;
import android.os.Build;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: androidx.core.os.a$a, reason: collision with other inner class name */
    @c.v0
    public @interface InterfaceC0067a {
    }

    private a() {
    }

    @c.k(api = 24)
    @Deprecated
    public static boolean a() {
        return Build.VERSION.SDK_INT >= 24;
    }

    @c.k(api = 25)
    @Deprecated
    public static boolean b() {
        return Build.VERSION.SDK_INT >= 25;
    }

    @c.k(api = 26)
    @Deprecated
    public static boolean c() {
        return Build.VERSION.SDK_INT >= 26;
    }

    @c.k(api = 27)
    @Deprecated
    public static boolean d() {
        return Build.VERSION.SDK_INT >= 27;
    }

    @c.k(api = 28)
    @Deprecated
    public static boolean e() {
        return Build.VERSION.SDK_INT >= 28;
    }

    @c.x0({c.x0.a.TESTS})
    protected static boolean f(@c.m0 String str, @c.m0 String str2) {
        if ("REL".equals(str2)) {
            return false;
        }
        Locale locale = Locale.ROOT;
        return str2.toUpperCase(locale).compareTo(str.toUpperCase(locale)) >= 0;
    }

    @c.k(api = 29)
    @Deprecated
    public static boolean g() {
        return Build.VERSION.SDK_INT >= 29;
    }

    @c.k(api = 30)
    @Deprecated
    public static boolean h() {
        return Build.VERSION.SDK_INT >= 30;
    }

    @c.k(api = 31, codename = "S")
    @SuppressLint({"RestrictedApi"})
    @Deprecated
    public static boolean i() {
        int i7 = Build.VERSION.SDK_INT;
        return i7 >= 31 || (i7 >= 30 && f("S", Build.VERSION.CODENAME));
    }

    @c.k(api = 32, codename = "Sv2")
    @InterfaceC0067a
    @Deprecated
    public static boolean j() {
        int i7 = Build.VERSION.SDK_INT;
        return i7 >= 32 || (i7 >= 31 && f("Sv2", Build.VERSION.CODENAME));
    }

    @c.k(api = 33, codename = "Tiramisu")
    @InterfaceC0067a
    public static boolean k() {
        int i7 = Build.VERSION.SDK_INT;
        return i7 >= 33 || (i7 >= 32 && f("Tiramisu", Build.VERSION.CODENAME));
    }

    @c.k(codename = "UpsideDownCake")
    @InterfaceC0067a
    public static boolean l() {
        return Build.VERSION.SDK_INT >= 33 && f("UpsideDownCake", Build.VERSION.CODENAME);
    }
}
