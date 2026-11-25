package com.google.android.gms.common;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.RemoteException;
import android.os.StrictMode;
import android.util.Log;
import com.google.android.gms.common.internal.j1;
import com.google.android.gms.common.internal.k1;
import com.google.android.gms.dynamite.DynamiteModule;
import java.security.MessageDigest;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes.dex */
final class j0 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static volatile k1 f15850e;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static Context f15852g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final h0 f15846a = new b0(f0.y0("0\u0082\u0005È0\u0082\u0003° \u0003\u0002\u0001\u0002\u0002\u0014\u0010\u008ae\bsù/\u008eQí"));

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final h0 f15847b = new c0(f0.y0("0\u0082\u0006\u00040\u0082\u0003ì \u0003\u0002\u0001\u0002\u0002\u0014\u0003£²\u00ad×árÊkì"));

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static final h0 f15848c = new d0(f0.y0("0\u0082\u0004C0\u0082\u0003+ \u0003\u0002\u0001\u0002\u0002\t\u0000Âà\u0087FdJ0\u008d0"));

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static final h0 f15849d = new e0(f0.y0("0\u0082\u0004¨0\u0082\u0003\u0090 \u0003\u0002\u0001\u0002\u0002\t\u0000Õ\u0085¸l}ÓNõ0"));

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final Object f15851f = new Object();

    static q0 a(String str, f0 f0Var, boolean z7, boolean z8) {
        StrictMode.ThreadPolicy threadPolicyAllowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            return f(str, f0Var, z7, z8);
        } finally {
            StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
        }
    }

    /* JADX WARN: Type inference failed for: r6v0, types: [android.os.IBinder, com.google.android.gms.dynamic.d] */
    static q0 b(String str, boolean z7, boolean z8, boolean z9) {
        q0 q0VarD;
        StrictMode.ThreadPolicy threadPolicyAllowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            com.google.android.gms.common.internal.u.k(f15852g);
            try {
                g();
                try {
                    zzq zzqVarW3 = f15850e.w3(new zzn(str, z7, false, com.google.android.gms.dynamic.f.z3(f15852g), false));
                    if (zzqVarW3.Q()) {
                        q0VarD = q0.b();
                    } else {
                        String strK = zzqVarW3.K();
                        if (strK == null) {
                            strK = "error checking package certificate";
                        }
                        q0VarD = zzqVarW3.p0() == 4 ? q0.d(strK, new PackageManager.NameNotFoundException()) : q0.c(strK);
                    }
                } catch (RemoteException e8) {
                    Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e8);
                    q0VarD = q0.d("module call", e8);
                }
            } catch (DynamiteModule.a e9) {
                Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e9);
                String strValueOf = String.valueOf(e9.getMessage());
                q0VarD = q0.d(strValueOf.length() != 0 ? "module init: ".concat(strValueOf) : new String("module init: "), e9);
            }
            StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
            return q0VarD;
        } catch (Throwable th) {
            StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
            throw th;
        }
    }

    static /* synthetic */ String c(boolean z7, String str, f0 f0Var) throws Exception {
        String str2 = true != (!z7 && f(str, f0Var, true, false).f15891a) ? "not allowed" : "debug cert rejected";
        MessageDigest messageDigestB = g1.a.b("SHA-1");
        com.google.android.gms.common.internal.u.k(messageDigestB);
        return String.format("%s: pkg=%s, sha1=%s, atk=%s, ver=%s", str2, str, g1.n.a(messageDigestB.digest(f0Var.z3())), Boolean.valueOf(z7), "12451000.false");
    }

    static synchronized void d(Context context) {
        if (f15852g != null) {
            Log.w("GoogleCertificates", "GoogleCertificates has been initialized already");
        } else if (context != null) {
            f15852g = context.getApplicationContext();
        }
    }

    static boolean e() {
        StrictMode.ThreadPolicy threadPolicyAllowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            try {
                g();
                return f15850e.b();
            } finally {
                StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
            }
        } catch (RemoteException | DynamiteModule.a e8) {
            Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e8);
            StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
            return false;
        }
    }

    private static q0 f(final String str, final f0 f0Var, final boolean z7, boolean z8) {
        try {
            g();
            com.google.android.gms.common.internal.u.k(f15852g);
            try {
                return f15850e.m3(new zzs(str, f0Var, z7, z8), com.google.android.gms.dynamic.f.z3(f15852g.getPackageManager())) ? q0.b() : new p0(new Callable() { // from class: com.google.android.gms.common.a0
                    @Override // java.util.concurrent.Callable
                    public final Object call() {
                        return j0.c(z7, str, f0Var);
                    }
                }, null);
            } catch (RemoteException e8) {
                Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e8);
                return q0.d("module call", e8);
            }
        } catch (DynamiteModule.a e9) {
            Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e9);
            String strValueOf = String.valueOf(e9.getMessage());
            return q0.d(strValueOf.length() != 0 ? "module init: ".concat(strValueOf) : new String("module init: "), e9);
        }
    }

    private static void g() throws DynamiteModule.a {
        if (f15850e != null) {
            return;
        }
        com.google.android.gms.common.internal.u.k(f15852g);
        synchronized (f15851f) {
            if (f15850e == null) {
                f15850e = j1.u0(DynamiteModule.e(f15852g, DynamiteModule.f16044f, "com.google.android.gms.googlecertificates").d("com.google.android.gms.common.GoogleCertificatesImpl"));
            }
        }
    }
}
