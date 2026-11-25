package androidx.browser.customtabs;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
public abstract class g implements ServiceConnection {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f2207a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final android.support.customtabs.a f2208b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private android.support.customtabs.c f2209c;

    public g(f fVar) {
        this.f2208b = android.support.customtabs.a.AbstractBinderC0000a.i0(fVar.c());
    }

    public boolean a(Context context, String str) {
        Intent intent = new Intent();
        intent.setClassName(str, PostMessageService.class.getName());
        return context.bindService(intent, this, 1);
    }

    public final boolean b(Bundle bundle) {
        if (this.f2209c == null) {
            return false;
        }
        synchronized (this.f2207a) {
            try {
                try {
                    this.f2209c.Z2(this.f2208b, bundle);
                } catch (RemoteException unused) {
                    return false;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return true;
    }

    public void c() {
    }

    public void d() {
    }

    public final boolean e(String str, Bundle bundle) {
        if (this.f2209c == null) {
            return false;
        }
        synchronized (this.f2207a) {
            try {
                try {
                    this.f2209c.L3(this.f2208b, str, bundle);
                } catch (RemoteException unused) {
                    return false;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return true;
    }

    public void f(Context context) {
        context.unbindService(this);
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.f2209c = android.support.customtabs.c.a.i0(iBinder);
        c();
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        this.f2209c = null;
        d();
    }
}
