package com.google.android.gms.security;

import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.util.Log;
import c.m0;
import c.o0;
import c.z;
import com.google.android.gms.common.h;
import com.google.android.gms.common.i;
import com.google.android.gms.common.internal.u;
import com.google.android.gms.common.j;
import com.google.android.gms.common.l;
import com.google.android.gms.dynamite.DynamiteModule;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @m0
    public static final String f16741a = "GmsCore_OpenSSL";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final h f16742b = h.i();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Object f16743c = new Object();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @z("ProviderInstaller.lock")
    private static Method f16744d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @z("ProviderInstaller.lock")
    private static Method f16745e = null;

    /* JADX INFO: renamed from: com.google.android.gms.security.a$a, reason: collision with other inner class name */
    public interface InterfaceC0188a {
        void a();

        void b(int i7, @o0 Intent intent);
    }

    public static void a(@m0 Context context) throws i, j {
        Context contextB;
        u.l(context, "Context must not be null");
        f16742b.p(context, 11925000);
        synchronized (f16743c) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            try {
                contextB = DynamiteModule.e(context, DynamiteModule.f16044f, "com.google.android.gms.providerinstaller.dynamite").b();
            } catch (DynamiteModule.a e8) {
                String strValueOf = String.valueOf(e8.getMessage());
                Log.w("ProviderInstaller", strValueOf.length() != 0 ? "Failed to load providerinstaller module: ".concat(strValueOf) : new String("Failed to load providerinstaller module: "));
                contextB = null;
            }
            if (contextB != null) {
                e(contextB, context, "com.google.android.gms.providerinstaller.ProviderInstallerImpl");
                return;
            }
            long jElapsedRealtime2 = SystemClock.elapsedRealtime();
            Context contextI = l.i(context);
            if (contextI != null) {
                try {
                    if (f16745e == null) {
                        Class cls = Long.TYPE;
                        f16745e = d(contextI, "com.google.android.gms.common.security.ProviderInstallerImpl", "reportRequestStats", new Class[]{Context.class, cls, cls});
                    }
                    f16745e.invoke(null, context, Long.valueOf(jElapsedRealtime), Long.valueOf(jElapsedRealtime2));
                } catch (Exception e9) {
                    String strValueOf2 = String.valueOf(e9.getMessage());
                    Log.w("ProviderInstaller", strValueOf2.length() != 0 ? "Failed to report request stats: ".concat(strValueOf2) : new String("Failed to report request stats: "));
                }
            }
            if (contextI != null) {
                e(contextI, context, "com.google.android.gms.common.security.ProviderInstallerImpl");
            } else {
                Log.e("ProviderInstaller", "Failed to get remote context");
                throw new i(8);
            }
        }
    }

    public static void b(@m0 Context context, @m0 InterfaceC0188a interfaceC0188a) {
        u.l(context, "Context must not be null");
        u.l(interfaceC0188a, "Listener must not be null");
        u.f("Must be called on the UI thread");
        new b(context, interfaceC0188a).execute(new Void[0]);
    }

    private static Method d(Context context, String str, String str2, Class[] clsArr) throws NoSuchMethodException, ClassNotFoundException {
        return context.getClassLoader().loadClass(str).getMethod(str2, clsArr);
    }

    @z("ProviderInstaller.lock")
    private static void e(Context context, Context context2, String str) throws i {
        try {
            if (f16744d == null) {
                f16744d = d(context, str, "insertProvider", new Class[]{Context.class});
            }
            f16744d.invoke(null, context);
        } catch (Exception e8) {
            Throwable cause = e8.getCause();
            if (Log.isLoggable("ProviderInstaller", 6)) {
                String strValueOf = String.valueOf(cause == null ? e8.getMessage() : cause.getMessage());
                Log.e("ProviderInstaller", strValueOf.length() != 0 ? "Failed to install provider: ".concat(strValueOf) : new String("Failed to install provider: "));
            }
            throw new i(8);
        }
    }
}
