package b4;

import android.content.Context;
import android.os.Build;
import android.util.Log;
import d4.f;
import java.util.Arrays;
import java.util.Locale;
import m4.e;

/* JADX INFO: loaded from: classes2.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Context f11316a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f11317b = false;

    public static String a() {
        return String.format(Locale.US, "%s (%d)", a.f11301g, 90);
    }

    public static synchronized void b(Context context) {
        e(context, new c.b().a());
    }

    public static synchronized void c(Context context, boolean z7, boolean z8) {
        e(context, new c.b().a());
    }

    public static synchronized void d(Context context) {
        e(context, new c.b().a());
    }

    public static synchronized void e(Context context, c cVar) {
        if (f11316a == null) {
            f11316a = context.getApplicationContext();
        }
        if (cVar == null) {
            cVar = new c.b().a();
        }
        Log.d("Realtek", cVar.toString());
        f11317b = cVar.c();
        k4.b.f34437j = cVar.a();
        k4.b.n(cVar.b(), cVar.d());
        if (k4.a.j() == null) {
            k4.a.k(context);
        }
        e.c(f11316a);
        if (f.y() == null) {
            f.A(f11316a);
        }
        if (e4.d.h() == null) {
            e4.d.i();
        }
        m4.c.a().c(new m4.c.a(a.f11303i, "rtk-core", a.f11301g));
        StringBuilder sb = new StringBuilder();
        sb.append("SDK_INT: " + Build.VERSION.SDK_INT);
        sb.append("\nDevice name: " + Build.DEVICE);
        sb.append("\nAndroid Version: " + Build.VERSION.RELEASE);
        sb.append("\nManufacture: " + Build.MANUFACTURER);
        sb.append("\nModel: " + Build.MODEL);
        sb.append("\nsupportedABIS: " + Arrays.toString(Build.SUPPORTED_ABIS));
        k4.b.e(sb.toString());
    }

    public static synchronized void f(Context context, boolean z7) {
        e(context, new c.b().b(z7).a());
    }

    public static boolean g() {
        return f.y().B();
    }
}
