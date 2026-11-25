package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import android.os.DeadObjectException;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Status;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class n0 implements k1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final n1 f15338a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f15339b = false;

    public n0(n1 n1Var) {
        this.f15338a = n1Var;
    }

    @Override // com.google.android.gms.common.api.internal.k1
    public final void a(@c.o0 Bundle bundle) {
    }

    @Override // com.google.android.gms.common.api.internal.k1
    public final void b() {
        if (this.f15339b) {
            this.f15339b = false;
            this.f15338a.s(new m0(this, this));
        }
    }

    @Override // com.google.android.gms.common.api.internal.k1
    public final void c(ConnectionResult connectionResult, com.google.android.gms.common.api.a<?> aVar, boolean z7) {
    }

    @Override // com.google.android.gms.common.api.internal.k1
    public final void d(int i7) {
        this.f15338a.r(null);
        this.f15338a.f15354q.b(i7, this.f15339b);
    }

    @Override // com.google.android.gms.common.api.internal.k1
    public final void e() {
    }

    @Override // com.google.android.gms.common.api.internal.k1
    public final <A extends com.google.android.gms.common.api.a.b, R extends com.google.android.gms.common.api.t, T extends e.a<R, A>> T f(T t7) {
        h(t7);
        return t7;
    }

    @Override // com.google.android.gms.common.api.internal.k1
    public final boolean g() {
        if (this.f15339b) {
            return false;
        }
        Set<g3> set = this.f15338a.f15353p.f15310z;
        if (set == null || set.isEmpty()) {
            this.f15338a.r(null);
            return true;
        }
        this.f15339b = true;
        Iterator<g3> it = set.iterator();
        while (it.hasNext()) {
            it.next().k();
        }
        return false;
    }

    @Override // com.google.android.gms.common.api.internal.k1
    public final <A extends com.google.android.gms.common.api.a.b, T extends e.a<? extends com.google.android.gms.common.api.t, A>> T h(T t7) {
        try {
            this.f15338a.f15353p.A.a(t7);
            j1 j1Var = this.f15338a.f15353p;
            com.google.android.gms.common.api.a.f fVar = j1Var.f15302r.get(t7.y());
            com.google.android.gms.common.internal.u.l(fVar, "Appropriate Api was not requested.");
            if (fVar.a() || !this.f15338a.f15346i.containsKey(t7.y())) {
                t7.A(fVar);
            } else {
                t7.a(new Status(17));
            }
        } catch (DeadObjectException unused) {
            this.f15338a.s(new l0(this, this));
        }
        return t7;
    }

    final void j() {
        if (this.f15339b) {
            this.f15339b = false;
            this.f15338a.f15353p.A.b();
            g();
        }
    }
}
