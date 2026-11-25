package com.google.common.collect;

import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
@s1.b(serializable = true)
final class t0<F, T> extends td<F> implements Serializable {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final long f21096e = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final com.google.common.base.s<F, ? extends T> f21097c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final td<T> f21098d;

    t0(com.google.common.base.s<F, ? extends T> sVar, td<T> tdVar) {
        this.f21097c = (com.google.common.base.s) com.google.common.base.e0.E(sVar);
        this.f21098d = (td) com.google.common.base.e0.E(tdVar);
    }

    @Override // com.google.common.collect.td, java.util.Comparator
    public int compare(F f8, F f9) {
        return this.f21098d.compare(this.f21097c.apply(f8), this.f21097c.apply(f9));
    }

    @Override // java.util.Comparator
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof t0)) {
            return false;
        }
        t0 t0Var = (t0) obj;
        return this.f21097c.equals(t0Var.f21097c) && this.f21098d.equals(t0Var.f21098d);
    }

    public int hashCode() {
        return com.google.common.base.y.b(this.f21097c, this.f21098d);
    }

    public String toString() {
        return this.f21098d + ".onResultOf(" + this.f21097c + ")";
    }
}
