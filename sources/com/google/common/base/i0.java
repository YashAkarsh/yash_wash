package com.google.common.base;

import java.util.Collections;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
@s1.b
final class i0<T> extends a0<T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final long f19427c = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final T f19428b;

    i0(T t7) {
        this.f19428b = t7;
    }

    @Override // com.google.common.base.a0
    public Set<T> b() {
        return Collections.singleton(this.f19428b);
    }

    @Override // com.google.common.base.a0
    public T e() {
        return this.f19428b;
    }

    @Override // com.google.common.base.a0
    public boolean equals(Object obj) {
        if (obj instanceof i0) {
            return this.f19428b.equals(((i0) obj).f19428b);
        }
        return false;
    }

    @Override // com.google.common.base.a0
    public boolean f() {
        return true;
    }

    @Override // com.google.common.base.a0
    public a0<T> h(a0<? extends T> a0Var) {
        e0.E(a0Var);
        return this;
    }

    @Override // com.google.common.base.a0
    public int hashCode() {
        return this.f19428b.hashCode() + 1502476572;
    }

    @Override // com.google.common.base.a0
    public T i(p0<? extends T> p0Var) {
        e0.E(p0Var);
        return this.f19428b;
    }

    @Override // com.google.common.base.a0
    public T j(T t7) {
        e0.F(t7, "use Optional.orNull() instead of Optional.or(null)");
        return this.f19428b;
    }

    @Override // com.google.common.base.a0
    public T k() {
        return this.f19428b;
    }

    @Override // com.google.common.base.a0
    public <V> a0<V> o(s<? super T, V> sVar) {
        return new i0(e0.F(sVar.apply(this.f19428b), "the Function passed to Optional.transform() must not return null."));
    }

    @Override // com.google.common.base.a0
    public String toString() {
        return "Optional.of(" + this.f19428b + ")";
    }
}
