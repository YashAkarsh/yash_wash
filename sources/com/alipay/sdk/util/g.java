package com.alipay.sdk.util;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.alipay.android.app.IAlixPay;

/* JADX INFO: loaded from: classes.dex */
class g implements ServiceConnection {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ f f13801a;

    g(f fVar) {
        this.f13801a = fVar;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        synchronized (this.f13801a.f13795c) {
            this.f13801a.f13794b = IAlixPay.Stub.asInterface(iBinder);
            this.f13801a.f13795c.notify();
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        this.f13801a.f13794b = null;
    }
}
