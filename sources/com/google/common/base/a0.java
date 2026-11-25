package com.google.common.base;

import java.io.Serializable;
import java.util.Iterator;
import java.util.Optional;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
@s1.b(serializable = true)
public abstract class a0<T> implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final long f19286a = 0;

    static class a implements Iterable<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Iterable f19287a;

        /* JADX INFO: renamed from: com.google.common.base.a0$a$a, reason: collision with other inner class name */
        class C0221a extends b<T> {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private final Iterator<? extends a0<? extends T>> f19288c;

            C0221a() {
                this.f19288c = (Iterator) e0.E(a.this.f19287a.iterator());
            }

            @Override // com.google.common.base.b
            protected T a() {
                while (this.f19288c.hasNext()) {
                    a0<? extends T> next = this.f19288c.next();
                    if (next.f()) {
                        return next.e();
                    }
                }
                return b();
            }
        }

        a(Iterable iterable) {
            this.f19287a = iterable;
        }

        @Override // java.lang.Iterable
        public Iterator<T> iterator() {
            return new C0221a();
        }
    }

    a0() {
    }

    public static <T> a0<T> a() {
        return com.google.common.base.a.p();
    }

    public static <T> a0<T> c(Optional<T> optional) {
        if (optional == null) {
            return null;
        }
        return d(optional.orElse(null));
    }

    public static <T> a0<T> d(T t7) {
        return t7 == null ? a() : new i0(t7);
    }

    public static <T> a0<T> g(T t7) {
        return new i0(e0.E(t7));
    }

    @s1.a
    public static <T> Iterable<T> l(Iterable<? extends a0<? extends T>> iterable) {
        e0.E(iterable);
        return new a(iterable);
    }

    public static <T> Optional<T> n(a0<T> a0Var) {
        if (a0Var == null) {
            return null;
        }
        return a0Var.m();
    }

    public abstract Set<T> b();

    public abstract T e();

    public abstract boolean equals(Object obj);

    public abstract boolean f();

    public abstract a0<T> h(a0<? extends T> a0Var);

    public abstract int hashCode();

    @s1.a
    public abstract T i(p0<? extends T> p0Var);

    public abstract T j(T t7);

    public abstract T k();

    public Optional<T> m() {
        return Optional.ofNullable(k());
    }

    public abstract <V> a0<V> o(s<? super T, V> sVar);

    public abstract String toString();
}
