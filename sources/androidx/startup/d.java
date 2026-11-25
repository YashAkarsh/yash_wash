package androidx.startup;

import android.util.Log;
import c.m0;
import c.o0;
import c.x0;

/* JADX INFO: loaded from: classes.dex */
@x0({x0.a.LIBRARY})
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f9815a = "StartupLogger";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final boolean f9816b = false;

    private d() {
    }

    public static void a(@m0 String str, @o0 Throwable th) {
        Log.e(f9815a, str, th);
    }

    public static void b(@m0 String str) {
        Log.i(f9815a, str);
    }

    public static void c(@m0 String str) {
        Log.w(f9815a, str);
    }
}
