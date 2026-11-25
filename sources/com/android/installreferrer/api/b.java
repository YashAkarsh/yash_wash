package com.android.installreferrer.api;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import c.m0;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
class b extends com.android.installreferrer.api.a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String f13933e = "InstallReferrerClient";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final int f13934f = 80837300;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final String f13935g = "com.android.vending";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final String f13936h = "com.google.android.finsky.externalreferrer.GetInstallReferrerService";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final String f13937i = "com.google.android.finsky.BIND_GET_INSTALL_REFERRER_SERVICE";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f13938a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f13939b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private com.google.android.finsky.externalreferrer.a f13940c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private ServiceConnection f13941d;

    /* JADX INFO: renamed from: com.android.installreferrer.api.b$b, reason: collision with other inner class name */
    @Retention(RetentionPolicy.SOURCE)
    public @interface InterfaceC0159b {

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public static final int f13942q = 0;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public static final int f13943r = 1;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public static final int f13944s = 2;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public static final int f13945t = 3;
    }

    private final class c implements ServiceConnection {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final com.android.installreferrer.api.c f13946a;

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            v0.a.a(b.f13933e, "Install Referrer service connected.");
            b.this.f13940c = com.google.android.finsky.externalreferrer.a.AbstractBinderC0175a.i0(iBinder);
            b.this.f13938a = 2;
            this.f13946a.onInstallReferrerSetupFinished(0);
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            v0.a.b(b.f13933e, "Install Referrer service disconnected.");
            b.this.f13940c = null;
            b.this.f13938a = 0;
            this.f13946a.onInstallReferrerServiceDisconnected();
        }

        private c(com.android.installreferrer.api.c cVar) {
            if (cVar == null) {
                throw new RuntimeException("Please specify a listener to know when setup is done.");
            }
            this.f13946a = cVar;
        }
    }

    public b(@m0 Context context) {
        this.f13939b = context.getApplicationContext();
    }

    private boolean h() {
        try {
            return this.f13939b.getPackageManager().getPackageInfo("com.android.vending", 128).versionCode >= f13934f;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    @Override // com.android.installreferrer.api.a
    public void a() {
        this.f13938a = 3;
        if (this.f13941d != null) {
            v0.a.a(f13933e, "Unbinding from service.");
            this.f13939b.unbindService(this.f13941d);
            this.f13941d = null;
        }
        this.f13940c = null;
    }

    @Override // com.android.installreferrer.api.a
    public d b() throws RemoteException {
        if (!c()) {
            throw new IllegalStateException("Service not connected. Please start a connection before using the service.");
        }
        Bundle bundle = new Bundle();
        bundle.putString("package_name", this.f13939b.getPackageName());
        try {
            return new d(this.f13940c.d3(bundle));
        } catch (RemoteException e8) {
            v0.a.b(f13933e, "RemoteException getting install referrer information");
            this.f13938a = 0;
            throw e8;
        }
    }

    @Override // com.android.installreferrer.api.a
    public boolean c() {
        return (this.f13938a != 2 || this.f13940c == null || this.f13941d == null) ? false : true;
    }

    @Override // com.android.installreferrer.api.a
    public void e(@m0 com.android.installreferrer.api.c cVar) {
        ServiceInfo serviceInfo;
        if (c()) {
            v0.a.a(f13933e, "Service connection is valid. No need to re-initialize.");
            cVar.onInstallReferrerSetupFinished(0);
            return;
        }
        int i7 = this.f13938a;
        if (i7 == 1) {
            v0.a.b(f13933e, "Client is already in the process of connecting to the service.");
            cVar.onInstallReferrerSetupFinished(3);
            return;
        }
        if (i7 == 3) {
            v0.a.b(f13933e, "Client was already closed and can't be reused. Please create another instance.");
            cVar.onInstallReferrerSetupFinished(3);
            return;
        }
        v0.a.a(f13933e, "Starting install referrer service setup.");
        this.f13941d = new c(cVar);
        Intent intent = new Intent(f13937i);
        intent.setComponent(new ComponentName("com.android.vending", f13936h));
        List<ResolveInfo> listQueryIntentServices = this.f13939b.getPackageManager().queryIntentServices(intent, 0);
        if (listQueryIntentServices == null || listQueryIntentServices.isEmpty() || (serviceInfo = listQueryIntentServices.get(0).serviceInfo) == null) {
            this.f13938a = 0;
            v0.a.a(f13933e, "Install Referrer service unavailable on device.");
            cVar.onInstallReferrerSetupFinished(2);
            return;
        }
        String str = serviceInfo.packageName;
        String str2 = serviceInfo.name;
        if (!"com.android.vending".equals(str) || str2 == null || !h()) {
            v0.a.b(f13933e, "Play Store missing or incompatible. Version 8.3.73 or later required.");
            this.f13938a = 0;
            cVar.onInstallReferrerSetupFinished(2);
        } else {
            if (this.f13939b.bindService(new Intent(intent), this.f13941d, 1)) {
                v0.a.a(f13933e, "Service was bonded successfully.");
                return;
            }
            v0.a.b(f13933e, "Connection to service is blocked.");
            this.f13938a = 0;
            cVar.onInstallReferrerSetupFinished(1);
        }
    }
}
