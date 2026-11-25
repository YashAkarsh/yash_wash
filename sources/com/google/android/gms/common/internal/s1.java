package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;

/* JADX INFO: loaded from: classes.dex */
@g1.d0
public final class s1 implements ServiceConnection {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f15794a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ e f15795b;

    public s1(e eVar, int i7) {
        this.f15795b = eVar;
        this.f15794a = i7;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        e eVar = this.f15795b;
        if (iBinder == null) {
            e.l0(eVar, 16);
            return;
        }
        synchronized (eVar.f15692n) {
            e eVar2 = this.f15795b;
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
            eVar2.f15693o = (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof p)) ? new h1(iBinder) : (p) iInterfaceQueryLocalInterface;
        }
        this.f15795b.m0(0, null, this.f15794a);
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        synchronized (this.f15795b.f15692n) {
            this.f15795b.f15693o = null;
        }
        Handler handler = this.f15795b.f15690l;
        handler.sendMessage(handler.obtainMessage(6, this.f15794a, 1));
    }
}
