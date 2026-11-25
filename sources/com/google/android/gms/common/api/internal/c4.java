package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import java.util.concurrent.locks.Lock;

/* JADX INFO: loaded from: classes.dex */
final class c4 implements d2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ e0 f15175a;

    /* synthetic */ c4(e0 e0Var, b4 b4Var) {
        this.f15175a = e0Var;
    }

    @Override // com.google.android.gms.common.api.internal.d2
    public final void a(@c.o0 Bundle bundle) {
        this.f15175a.f15201o.lock();
        try {
            e0.B(this.f15175a, bundle);
            this.f15175a.f15198l = ConnectionResult.D;
            e0.C(this.f15175a);
        } finally {
            this.f15175a.f15201o.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.internal.d2
    public final void b(int i7, boolean z7) {
        Lock lock;
        this.f15175a.f15201o.lock();
        try {
            e0 e0Var = this.f15175a;
            if (e0Var.f15200n || e0Var.f15199m == null || !e0Var.f15199m.s0()) {
                this.f15175a.f15200n = false;
                e0.A(this.f15175a, i7, z7);
                lock = this.f15175a.f15201o;
            } else {
                this.f15175a.f15200n = true;
                this.f15175a.f15193g.i0(i7);
                lock = this.f15175a.f15201o;
            }
            lock.unlock();
        } catch (Throwable th) {
            this.f15175a.f15201o.unlock();
            throw th;
        }
    }

    @Override // com.google.android.gms.common.api.internal.d2
    public final void c(@c.m0 ConnectionResult connectionResult) {
        this.f15175a.f15201o.lock();
        try {
            this.f15175a.f15198l = connectionResult;
            e0.C(this.f15175a);
        } finally {
            this.f15175a.f15201o.unlock();
        }
    }
}
