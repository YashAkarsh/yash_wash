package com.google.android.gms.common.wrappers;

import android.annotation.TargetApi;
import android.app.AppOpsManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.os.Binder;
import android.os.Process;
import androidx.core.util.s;
import c.m0;
import g1.v;

/* JADX INFO: loaded from: classes.dex */
@c1.a
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @m0
    protected final Context f16000a;

    public c(@m0 Context context) {
        this.f16000a = context;
    }

    @c1.a
    public int a(@m0 String str) {
        return this.f16000a.checkCallingOrSelfPermission(str);
    }

    @c1.a
    public int b(@m0 String str, @m0 String str2) {
        return this.f16000a.getPackageManager().checkPermission(str, str2);
    }

    @c1.a
    @m0
    public ApplicationInfo c(@m0 String str, int i7) throws PackageManager.NameNotFoundException {
        return this.f16000a.getPackageManager().getApplicationInfo(str, i7);
    }

    @c1.a
    @m0
    public CharSequence d(@m0 String str) throws PackageManager.NameNotFoundException {
        return this.f16000a.getPackageManager().getApplicationLabel(this.f16000a.getPackageManager().getApplicationInfo(str, 0));
    }

    @c1.a
    @m0
    public s<CharSequence, Drawable> e(@m0 String str) throws PackageManager.NameNotFoundException {
        ApplicationInfo applicationInfo = this.f16000a.getPackageManager().getApplicationInfo(str, 0);
        return s.a(this.f16000a.getPackageManager().getApplicationLabel(applicationInfo), this.f16000a.getPackageManager().getApplicationIcon(applicationInfo));
    }

    @c1.a
    @m0
    public PackageInfo f(@m0 String str, int i7) throws PackageManager.NameNotFoundException {
        return this.f16000a.getPackageManager().getPackageInfo(str, i7);
    }

    @c1.a
    public boolean g() {
        String nameForUid;
        if (Binder.getCallingUid() == Process.myUid()) {
            return a.a(this.f16000a);
        }
        if (!v.n() || (nameForUid = this.f16000a.getPackageManager().getNameForUid(Binder.getCallingUid())) == null) {
            return false;
        }
        return this.f16000a.getPackageManager().isInstantApp(nameForUid);
    }

    @TargetApi(19)
    public final boolean h(int i7, @m0 String str) {
        if (v.h()) {
            try {
                AppOpsManager appOpsManager = (AppOpsManager) this.f16000a.getSystemService("appops");
                if (appOpsManager == null) {
                    throw new NullPointerException("context.getSystemService(Context.APP_OPS_SERVICE) is null");
                }
                appOpsManager.checkPackage(i7, str);
                return true;
            } catch (SecurityException unused) {
                return false;
            }
        }
        String[] packagesForUid = this.f16000a.getPackageManager().getPackagesForUid(i7);
        if (str != null && packagesForUid != null) {
            for (String str2 : packagesForUid) {
                if (str.equals(str2)) {
                    return true;
                }
            }
        }
        return false;
    }
}
