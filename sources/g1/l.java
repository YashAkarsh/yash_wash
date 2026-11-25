package g1;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import c.m0;
import c.o0;

/* JADX INFO: loaded from: classes.dex */
@c1.a
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @o0
    private static Boolean f33992a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @o0
    private static Boolean f33993b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @o0
    private static Boolean f33994c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @o0
    private static Boolean f33995d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @o0
    private static Boolean f33996e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @o0
    private static Boolean f33997f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @o0
    private static Boolean f33998g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @o0
    private static Boolean f33999h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @o0
    private static Boolean f34000i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @o0
    private static Boolean f34001j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @o0
    private static Boolean f34002k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @o0
    private static Boolean f34003l;

    private l() {
    }

    @c1.a
    public static boolean a(@m0 Context context) {
        PackageManager packageManager = context.getPackageManager();
        if (f34000i == null) {
            boolean z7 = false;
            if (v.n() && packageManager.hasSystemFeature("android.hardware.type.automotive")) {
                z7 = true;
            }
            f34000i = Boolean.valueOf(z7);
        }
        return f34000i.booleanValue();
    }

    @c1.a
    public static boolean b(@m0 Context context) {
        if (f34003l == null) {
            boolean z7 = false;
            if (v.q() && context.getPackageManager().hasSystemFeature("com.google.android.play.feature.HPE_EXPERIENCE")) {
                z7 = true;
            }
            f34003l = Boolean.valueOf(z7);
        }
        return f34003l.booleanValue();
    }

    @c1.a
    public static boolean c(@m0 Context context) {
        if (f33997f == null) {
            PackageManager packageManager = context.getPackageManager();
            boolean z7 = false;
            if (packageManager.hasSystemFeature("com.google.android.feature.services_updater") && packageManager.hasSystemFeature("cn.google.services")) {
                z7 = true;
            }
            f33997f = Boolean.valueOf(z7);
        }
        return f33997f.booleanValue();
    }

    @c1.a
    public static boolean d(@m0 Context context) {
        if (f33992a == null) {
            boolean z7 = false;
            if (!g(context) && !k(context) && !n(context)) {
                if (f33999h == null) {
                    f33999h = Boolean.valueOf(context.getPackageManager().hasSystemFeature("org.chromium.arc"));
                }
                if (!f33999h.booleanValue() && !a(context) && !i(context)) {
                    if (f34002k == null) {
                        f34002k = Boolean.valueOf(context.getPackageManager().hasSystemFeature("com.google.android.feature.AMATI_EXPERIENCE"));
                    }
                    if (!f34002k.booleanValue() && !b(context)) {
                        z7 = true;
                    }
                }
            }
            f33992a = Boolean.valueOf(z7);
        }
        return f33992a.booleanValue();
    }

    @c1.a
    public static boolean e(@m0 Context context) {
        return o(context.getResources());
    }

    @c1.a
    @TargetApi(21)
    public static boolean f(@m0 Context context) {
        return m(context);
    }

    @c1.a
    public static boolean g(@m0 Context context) {
        return h(context.getResources());
    }

    @c1.a
    public static boolean h(@m0 Resources resources) {
        if (resources == null) {
            return false;
        }
        if (f33993b == null) {
            f33993b = Boolean.valueOf((resources.getConfiguration().screenLayout & 15) > 3 || o(resources));
        }
        return f33993b.booleanValue();
    }

    @c1.a
    public static boolean i(@m0 Context context) {
        PackageManager packageManager = context.getPackageManager();
        if (f34001j == null) {
            boolean z7 = true;
            if (!packageManager.hasSystemFeature("com.google.android.tv") && !packageManager.hasSystemFeature("android.hardware.type.television") && !packageManager.hasSystemFeature("android.software.leanback")) {
                z7 = false;
            }
            f34001j = Boolean.valueOf(z7);
        }
        return f34001j.booleanValue();
    }

    @c1.a
    public static boolean j() {
        int i7 = com.google.android.gms.common.l.f15857a;
        return "user".equals(Build.TYPE);
    }

    @c1.a
    @TargetApi(20)
    public static boolean k(@m0 Context context) {
        PackageManager packageManager = context.getPackageManager();
        if (f33995d == null) {
            boolean z7 = false;
            if (v.i() && packageManager.hasSystemFeature("android.hardware.type.watch")) {
                z7 = true;
            }
            f33995d = Boolean.valueOf(z7);
        }
        return f33995d.booleanValue();
    }

    @c1.a
    @TargetApi(26)
    public static boolean l(@m0 Context context) {
        if (!k(context)) {
            return false;
        }
        if (v.m()) {
            return m(context) && !v.n();
        }
        return true;
    }

    @TargetApi(21)
    public static boolean m(@m0 Context context) {
        if (f33996e == null) {
            boolean z7 = false;
            if (v.j() && context.getPackageManager().hasSystemFeature("cn.google")) {
                z7 = true;
            }
            f33996e = Boolean.valueOf(z7);
        }
        return f33996e.booleanValue();
    }

    public static boolean n(@m0 Context context) {
        if (f33998g == null) {
            boolean z7 = true;
            if (!context.getPackageManager().hasSystemFeature("android.hardware.type.iot") && !context.getPackageManager().hasSystemFeature("android.hardware.type.embedded")) {
                z7 = false;
            }
            f33998g = Boolean.valueOf(z7);
        }
        return f33998g.booleanValue();
    }

    public static boolean o(@m0 Resources resources) {
        boolean z7 = false;
        if (resources == null) {
            return false;
        }
        if (f33994c == null) {
            Configuration configuration = resources.getConfiguration();
            if ((configuration.screenLayout & 15) <= 3 && configuration.smallestScreenWidthDp >= 600) {
                z7 = true;
            }
            f33994c = Boolean.valueOf(z7);
        }
        return f33994c.booleanValue();
    }
}
