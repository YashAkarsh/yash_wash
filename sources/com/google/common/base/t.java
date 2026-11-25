package com.google.common.base;

import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
@s1.a
@s1.b
final class t<F, T> extends l<F> implements Serializable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final long f19541c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final s<F, ? extends T> f19542a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final l<T> f19543b;

    t(s<F, ? extends T> sVar, l<T> lVar) {
        this.f19542a = (s) e0.E(sVar);
        this.f19543b = (l) e0.E(lVar);
    }

    @Override // com.google.common.base.l
    protected boolean a(F f8, F f9) {
        return this.f19543b.d(this.f19542a.apply(f8), this.f19542a.apply(f9));
    }

    @Override // com.google.common.base.l
    protected int b(F f8) {
        return this.f19543b.f(this.f19542a.apply(f8));
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof t)) {
            return false;
        }
        t tVar = (t) obj;
        return this.f19542a.equals(tVar.f19542a) && this.f19543b.equals(tVar.f19543b);
    }

    public int hashCode() {
        return y.b(this.f19542a, this.f19543b);
    }

    public String toString() {
        return this.f19543b + ".onResultOf(" + this.f19542a + ")";
    }
}
