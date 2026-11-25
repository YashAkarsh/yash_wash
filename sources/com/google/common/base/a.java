package com.google.common.base;

import java.util.Collections;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
@s1.b
final class a<T> extends a0<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final a<Object> f19284b = new a<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final long f19285c = 0;

    private a() {
    }

    static <T> a0<T> p() {
        return f19284b;
    }

    private Object readResolve() {
        return f19284b;
    }

    @Override // com.google.common.base.a0
    public Set<T> b() {
        return Collections.emptySet();
    }

    @Override // com.google.common.base.a0
    public T e() {
        throw new IllegalStateException("Optional.get() cannot be called on an absent value");
    }

    @Override // com.google.common.base.a0
    public boolean equals(Object obj) {
        return obj == this;
    }

    @Override // com.google.common.base.a0
    public boolean f() {
        return false;
    }

    @Override // com.google.common.base.a0
    public a0<T> h(a0<? extends T> a0Var) {
        return (a0) e0.E(a0Var);
    }

    @Override // com.google.common.base.a0
    public int hashCode() {
        return 2040732332;
    }

    @Override // com.google.common.base.a0
    public T i(p0<? extends T> p0Var) {
        return (T) e0.F(p0Var.get(), "use Optional.orNull() instead of a Supplier that returns null");
    }

    @Override // com.google.common.base.a0
    public T j(T t7) {
        return (T) e0.F(t7, "use Optional.orNull() instead of Optional.or(null)");
    }

    @Override // com.google.common.base.a0
    public T k() {
        return null;
    }

    @Override // com.google.common.base.a0
    public <V> a0<V> o(s<? super T, V> sVar) {
        e0.E(sVar);
        return a0.a();
    }

    @Override // com.google.common.base.a0
    public String toString() {
        return "Optional.absent()";
    }
}
