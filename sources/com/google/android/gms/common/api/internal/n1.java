package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import com.google.android.gms.common.ConnectionResult;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import javax.annotation.concurrent.GuardedBy;

/* JADX INFO: loaded from: classes.dex */
public final class n1 implements f2, z3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Lock f15340a;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Condition f15341d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Context f15342e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final com.google.android.gms.common.h f15343f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final m1 f15344g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final Map<com.google.android.gms.common.api.a.c<?>, com.google.android.gms.common.api.a.f> f15345h;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @c.o0
    final com.google.android.gms.common.internal.f f15347j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    final Map<com.google.android.gms.common.api.a<?>, Boolean> f15348k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @c.o0
    final com.google.android.gms.common.api.a.AbstractC0179a<? extends com.google.android.gms.signin.f, com.google.android.gms.signin.a> f15349l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @d6.c
    private volatile k1 f15350m;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    int f15352o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    final j1 f15353p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    final d2 f15354q;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final Map<com.google.android.gms.common.api.a.c<?>, ConnectionResult> f15346i = new HashMap();

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @c.o0
    private ConnectionResult f15351n = null;

    public n1(Context context, j1 j1Var, Lock lock, Looper looper, com.google.android.gms.common.h hVar, Map<com.google.android.gms.common.api.a.c<?>, com.google.android.gms.common.api.a.f> map, @c.o0 com.google.android.gms.common.internal.f fVar, Map<com.google.android.gms.common.api.a<?>, Boolean> map2, @c.o0 com.google.android.gms.common.api.a.AbstractC0179a<? extends com.google.android.gms.signin.f, com.google.android.gms.signin.a> abstractC0179a, ArrayList<y3> arrayList, d2 d2Var) {
        this.f15342e = context;
        this.f15340a = lock;
        this.f15343f = hVar;
        this.f15345h = map;
        this.f15347j = fVar;
        this.f15348k = map2;
        this.f15349l = abstractC0179a;
        this.f15353p = j1Var;
        this.f15354q = d2Var;
        int size = arrayList.size();
        for (int i7 = 0; i7 < size; i7++) {
            arrayList.get(i7).a(this);
        }
        this.f15344g = new m1(this, looper);
        this.f15341d = lock.newCondition();
        this.f15350m = new b1(this);
    }

    final void c() {
        this.f15340a.lock();
        try {
            this.f15353p.R();
            this.f15350m = new n0(this);
            this.f15350m.e();
            this.f15341d.signalAll();
        } finally {
            this.f15340a.unlock();
        }
    }

    final void d() {
        this.f15340a.lock();
        try {
            this.f15350m = new a1(this, this.f15347j, this.f15348k, this.f15343f, this.f15349l, this.f15340a, this.f15342e);
            this.f15350m.e();
            this.f15341d.signalAll();
        } finally {
            this.f15340a.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.internal.f2
    @GuardedBy("mLock")
    public final ConnectionResult e() {
        h();
        while (this.f15350m instanceof a1) {
            try {
                this.f15341d.await();
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
                return new ConnectionResult(15, null);
            }
        }
        if (this.f15350m instanceof n0) {
            return ConnectionResult.D;
        }
        ConnectionResult connectionResult = this.f15351n;
        return connectionResult != null ? connectionResult : new ConnectionResult(13, null);
    }

    @Override // com.google.android.gms.common.api.internal.f2
    public final boolean f() {
        return this.f15350m instanceof a1;
    }

    @Override // com.google.android.gms.common.api.internal.f2
    @GuardedBy("mLock")
    public final ConnectionResult g(long j7, TimeUnit timeUnit) {
        h();
        long nanos = timeUnit.toNanos(j7);
        while (this.f15350m instanceof a1) {
            if (nanos <= 0) {
                n();
                return new ConnectionResult(14, null);
            }
            try {
                nanos = this.f15341d.awaitNanos(nanos);
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
                return new ConnectionResult(15, null);
            }
            Thread.currentThread().interrupt();
            return new ConnectionResult(15, null);
        }
        if (this.f15350m instanceof n0) {
            return ConnectionResult.D;
        }
        ConnectionResult connectionResult = this.f15351n;
        return connectionResult != null ? connectionResult : new ConnectionResult(13, null);
    }

    @Override // com.google.android.gms.common.api.internal.f2
    @GuardedBy("mLock")
    public final void h() {
        this.f15350m.b();
    }

    @Override // com.google.android.gms.common.api.internal.f2
    @GuardedBy("mLock")
    public final <A extends com.google.android.gms.common.api.a.b, R extends com.google.android.gms.common.api.t, T extends e.a<R, A>> T i(@c.m0 T t7) {
        t7.s();
        this.f15350m.f(t7);
        return t7;
    }

    @Override // com.google.android.gms.common.api.internal.f
    public final void i0(int i7) {
        this.f15340a.lock();
        try {
            this.f15350m.d(i7);
        } finally {
            this.f15340a.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.internal.f2
    public final boolean j() {
        return this.f15350m instanceof n0;
    }

    @Override // com.google.android.gms.common.api.internal.f2
    @GuardedBy("mLock")
    public final <A extends com.google.android.gms.common.api.a.b, T extends e.a<? extends com.google.android.gms.common.api.t, A>> T k(@c.m0 T t7) {
        t7.s();
        return (T) this.f15350m.h(t7);
    }

    @Override // com.google.android.gms.common.api.internal.f2
    @GuardedBy("mLock")
    public final void l() {
        if (this.f15350m instanceof n0) {
            ((n0) this.f15350m).j();
        }
    }

    @Override // com.google.android.gms.common.api.internal.f2
    public final void m() {
    }

    @Override // com.google.android.gms.common.api.internal.f2
    @GuardedBy("mLock")
    public final void n() {
        if (this.f15350m.g()) {
            this.f15346i.clear();
        }
    }

    @Override // com.google.android.gms.common.api.internal.f2
    public final boolean o(w wVar) {
        return false;
    }

    @Override // com.google.android.gms.common.api.internal.f2
    public final void p(String str, @c.o0 FileDescriptor fileDescriptor, PrintWriter printWriter, @c.o0 String[] strArr) {
        String strConcat = String.valueOf(str).concat("  ");
        printWriter.append((CharSequence) str).append("mState=").println(this.f15350m);
        for (com.google.android.gms.common.api.a<?> aVar : this.f15348k.keySet()) {
            printWriter.append((CharSequence) str).append((CharSequence) aVar.d()).println(":");
            ((com.google.android.gms.common.api.a.f) com.google.android.gms.common.internal.u.k(this.f15345h.get(aVar.b()))).o(strConcat, fileDescriptor, printWriter, strArr);
        }
    }

    @Override // com.google.android.gms.common.api.internal.f2
    @c.o0
    @GuardedBy("mLock")
    public final ConnectionResult q(@c.m0 com.google.android.gms.common.api.a<?> aVar) {
        com.google.android.gms.common.api.a.c<?> cVarB = aVar.b();
        if (!this.f15345h.containsKey(cVarB)) {
            return null;
        }
        if (this.f15345h.get(cVarB).a()) {
            return ConnectionResult.D;
        }
        if (this.f15346i.containsKey(cVarB)) {
            return this.f15346i.get(cVarB);
        }
        return null;
    }

    final void r(@c.o0 ConnectionResult connectionResult) {
        this.f15340a.lock();
        try {
            this.f15351n = connectionResult;
            this.f15350m = new b1(this);
            this.f15350m.e();
            this.f15341d.signalAll();
        } finally {
            this.f15340a.unlock();
        }
    }

    final void s(l1 l1Var) {
        this.f15344g.sendMessage(this.f15344g.obtainMessage(1, l1Var));
    }

    final void t(RuntimeException runtimeException) {
        this.f15344g.sendMessage(this.f15344g.obtainMessage(2, runtimeException));
    }

    @Override // com.google.android.gms.common.api.internal.f
    public final void y0(@c.o0 Bundle bundle) {
        this.f15340a.lock();
        try {
            this.f15350m.a(bundle);
        } finally {
            this.f15340a.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.internal.z3
    public final void z3(@c.m0 ConnectionResult connectionResult, @c.m0 com.google.android.gms.common.api.a<?> aVar, boolean z7) {
        this.f15340a.lock();
        try {
            this.f15350m.c(connectionResult, aVar, z7);
        } finally {
            this.f15340a.unlock();
        }
    }
}
