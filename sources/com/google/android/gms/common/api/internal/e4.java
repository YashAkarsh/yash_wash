package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import java.util.concurrent.locks.Lock;

/* JADX INFO: loaded from: classes.dex */
final class e4 implements d2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ e0 f15205a;

    /* synthetic */ e4(e0 e0Var, d4 d4Var) {
        this.f15205a = e0Var;
    }

    @Override // com.google.android.gms.common.api.internal.d2
    public final void a(@c.o0 Bundle bundle) {
        this.f15205a.f15201o.lock();
        try {
            this.f15205a.f15199m = ConnectionResult.D;
            e0.C(this.f15205a);
        } finally {
            this.f15205a.f15201o.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.internal.d2
    public final void b(int i7, boolean z7) {
        Lock lock;
        this.f15205a.f15201o.lock();
        try {
            e0 e0Var = this.f15205a;
            if (e0Var.f15200n) {
                e0Var.f15200n = false;
                e0.A(this.f15205a, i7, z7);
                lock = this.f15205a.f15201o;
            } else {
                e0Var.f15200n = true;
                this.f15205a.f15192f.i0(i7);
                lock = this.f15205a.f15201o;
            }
            lock.unlock();
        } catch (Throwable th) {
            this.f15205a.f15201o.unlock();
            throw th;
        }
    }

    @Override // com.google.android.gms.common.api.internal.d2
    public final void c(@c.m0 ConnectionResult connectionResult) {
        this.f15205a.f15201o.lock();
        try {
            this.f15205a.f15199m = connectionResult;
            e0.C(this.f15205a);
        } finally {
            this.f15205a.f15201o.unlock();
        }
    }
}
