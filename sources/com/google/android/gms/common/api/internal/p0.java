package com.google.android.gms.common.api.internal;

import android.os.Looper;
import com.google.android.gms.common.ConnectionResult;
import java.lang.ref.WeakReference;
import java.util.concurrent.locks.Lock;

/* JADX INFO: loaded from: classes.dex */
final class p0 implements com.google.android.gms.common.internal.e.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final WeakReference<a1> f15379a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.google.android.gms.common.api.a<?> f15380b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f15381c;

    public p0(a1 a1Var, com.google.android.gms.common.api.a<?> aVar, boolean z7) {
        this.f15379a = new WeakReference<>(a1Var);
        this.f15380b = aVar;
        this.f15381c = z7;
    }

    @Override // com.google.android.gms.common.internal.e.c
    public final void a(@c.m0 ConnectionResult connectionResult) {
        Lock lock;
        a1 a1Var = this.f15379a.get();
        if (a1Var == null) {
            return;
        }
        com.google.android.gms.common.internal.u.r(Looper.myLooper() == a1Var.f15144a.f15353p.r(), "onReportServiceBinding must be called on the GoogleApiClient handler thread");
        a1Var.f15145b.lock();
        try {
            if (a1Var.o(0)) {
                if (!connectionResult.s0()) {
                    a1Var.m(connectionResult, this.f15380b, this.f15381c);
                }
                if (a1Var.p()) {
                    a1Var.n();
                }
                lock = a1Var.f15145b;
            } else {
                lock = a1Var.f15145b;
            }
            lock.unlock();
        } catch (Throwable th) {
            a1Var.f15145b.unlock();
            throw th;
        }
    }
}
