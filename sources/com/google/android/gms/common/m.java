package com.google.android.gms.common;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.util.Log;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
@c1.a
@com.google.android.gms.common.internal.y
public class m {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    private static m f15871c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f15872a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile String f15873b;

    public m(@c.m0 Context context) {
        this.f15872a = context.getApplicationContext();
    }

    @c1.a
    @c.m0
    public static m a(@c.m0 Context context) {
        com.google.android.gms.common.internal.u.k(context);
        synchronized (m.class) {
            if (f15871c == null) {
                j0.d(context);
                f15871c = new m(context);
            }
        }
        return f15871c;
    }

    @Nullable
    static final f0 e(PackageInfo packageInfo, f0... f0VarArr) {
        Signature[] signatureArr = packageInfo.signatures;
        if (signatureArr == null) {
            return null;
        }
        if (signatureArr.length != 1) {
            Log.w("GoogleSignatureVerifier", "Package has more than one signature.");
            return null;
        }
        g0 g0Var = new g0(packageInfo.signatures[0].toByteArray());
        for (int i7 = 0; i7 < f0VarArr.length; i7++) {
            if (f0VarArr[i7].equals(g0Var)) {
                return f0VarArr[i7];
            }
        }
        return null;
    }

    public static final boolean f(@c.m0 PackageInfo packageInfo, boolean z7) {
        if (packageInfo != null && packageInfo.signatures != null) {
            if ((z7 ? e(packageInfo, i0.f15583a) : e(packageInfo, i0.f15583a[0])) != null) {
                return true;
            }
        }
        return false;
    }

    @SuppressLint({"PackageManagerGetSignatures"})
    private final q0 g(String str, boolean z7, boolean z8) {
        q0 q0VarC;
        ApplicationInfo applicationInfo;
        if (str == null) {
            return q0.c("null pkg");
        }
        if (str.equals(this.f15873b)) {
            return q0.b();
        }
        if (j0.e()) {
            q0VarC = j0.b(str, l.k(this.f15872a), false, false);
        } else {
            try {
                PackageInfo packageInfo = this.f15872a.getPackageManager().getPackageInfo(str, 64);
                boolean zK = l.k(this.f15872a);
                if (packageInfo == null) {
                    q0VarC = q0.c("null pkg");
                } else {
                    Signature[] signatureArr = packageInfo.signatures;
                    if (signatureArr == null || signatureArr.length != 1) {
                        q0VarC = q0.c("single cert required");
                    } else {
                        g0 g0Var = new g0(packageInfo.signatures[0].toByteArray());
                        String str2 = packageInfo.packageName;
                        q0 q0VarA = j0.a(str2, g0Var, zK, false);
                        q0VarC = (!q0VarA.f15891a || (applicationInfo = packageInfo.applicationInfo) == null || (applicationInfo.flags & 2) == 0 || !j0.a(str2, g0Var, false, true).f15891a) ? q0VarA : q0.c("debuggable release cert app rejected");
                    }
                }
            } catch (PackageManager.NameNotFoundException e8) {
                return q0.d(str.length() != 0 ? "no pkg ".concat(str) : new String("no pkg "), e8);
            }
        }
        if (q0VarC.f15891a) {
            this.f15873b = str;
        }
        return q0VarC;
    }

    @c1.a
    public boolean b(@c.m0 PackageInfo packageInfo) {
        if (packageInfo == null) {
            return false;
        }
        if (f(packageInfo, false)) {
            return true;
        }
        if (f(packageInfo, true)) {
            if (l.k(this.f15872a)) {
                return true;
            }
            Log.w("GoogleSignatureVerifier", "Test-keys aren't accepted on this build.");
        }
        return false;
    }

    @c1.a
    @com.google.android.gms.common.internal.y
    public boolean c(@c.m0 String str) {
        q0 q0VarG = g(str, false, false);
        q0VarG.e();
        return q0VarG.f15891a;
    }

    @c1.a
    @com.google.android.gms.common.internal.y
    public boolean d(int i7) {
        q0 q0VarC;
        String[] packagesForUid = this.f15872a.getPackageManager().getPackagesForUid(i7);
        if (packagesForUid == null || (packagesForUid.length) == 0) {
            q0VarC = q0.c("no pkgs");
        } else {
            q0VarC = null;
            for (String str : packagesForUid) {
                q0VarC = g(str, false, false);
                if (!q0VarC.f15891a) {
                }
            }
            com.google.android.gms.common.internal.u.k(q0VarC);
        }
        q0VarC.e();
        return q0VarC.f15891a;
    }
}
