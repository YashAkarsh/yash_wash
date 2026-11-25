package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
@g1.d0
public final class r1 extends g1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @c.o0
    private e f15788a;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f15789d;

    public r1(@c.m0 e eVar, int i7) {
        this.f15788a = eVar;
        this.f15789d = i7;
    }

    @Override // com.google.android.gms.common.internal.o
    @c.g
    public final void M3(int i7, @c.m0 IBinder iBinder, @c.o0 Bundle bundle) {
        u.l(this.f15788a, "onPostInitComplete can be called only once per call to getRemoteService");
        this.f15788a.W(i7, iBinder, bundle, this.f15789d);
        this.f15788a = null;
    }

    @Override // com.google.android.gms.common.internal.o
    @c.g
    public final void b4(int i7, @c.m0 IBinder iBinder, @c.m0 zzj zzjVar) {
        e eVar = this.f15788a;
        u.l(eVar, "onPostInitCompleteWithConnectionInfo can be called only once per call togetRemoteService");
        u.k(zzjVar);
        e.k0(eVar, zzjVar);
        M3(i7, iBinder, zzjVar.f15841a);
    }

    @Override // com.google.android.gms.common.internal.o
    @c.g
    public final void w2(int i7, @c.o0 Bundle bundle) {
        Log.wtf("GmsClient", "received deprecated onAccountValidationComplete callback, ignoring", new Exception());
    }
}
