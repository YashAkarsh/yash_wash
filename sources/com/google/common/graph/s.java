package com.google.common.graph;

import com.google.common.collect.td;
import com.google.common.collect.wb;
import java.util.Comparator;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@s1.a
@u1.j
public final class s<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final b f21677a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Comparator<T> f21678b;

    static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f21679a;

        static {
            int[] iArr = new int[b.values().length];
            f21679a = iArr;
            try {
                iArr[b.UNORDERED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f21679a[b.INSERTION.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f21679a[b.SORTED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public enum b {
        UNORDERED,
        INSERTION,
        SORTED
    }

    private s(b bVar, Comparator<T> comparator) {
        this.f21677a = (b) com.google.common.base.e0.E(bVar);
        this.f21678b = comparator;
        com.google.common.base.e0.g0((bVar == b.SORTED) == (comparator != null));
    }

    public static <S> s<S> d() {
        return new s<>(b.INSERTION, null);
    }

    public static <S extends Comparable<? super S>> s<S> e() {
        return new s<>(b.SORTED, td.A());
    }

    public static <S> s<S> f(Comparator<S> comparator) {
        return new s<>(b.SORTED, comparator);
    }

    public static <S> s<S> h() {
        return new s<>(b.UNORDERED, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    <T1 extends T> s<T1> a() {
        return this;
    }

    public Comparator<T> b() {
        Comparator<T> comparator = this.f21678b;
        if (comparator != null) {
            return comparator;
        }
        throw new UnsupportedOperationException("This ordering does not define a comparator.");
    }

    <K extends T, V> Map<K, V> c(int i7) {
        int i8 = a.f21679a[this.f21677a.ordinal()];
        if (i8 == 1) {
            return wb.k0(i7);
        }
        if (i8 == 2) {
            return wb.o0(i7);
        }
        if (i8 == 3) {
            return wb.q0(b());
        }
        throw new AssertionError();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof s)) {
            return false;
        }
        s sVar = (s) obj;
        return this.f21677a == sVar.f21677a && com.google.common.base.y.a(this.f21678b, sVar.f21678b);
    }

    public b g() {
        return this.f21677a;
    }

    public int hashCode() {
        return com.google.common.base.y.b(this.f21677a, this.f21678b);
    }

    public String toString() {
        com.google.common.base.x.b bVarF = com.google.common.base.x.c(this).f("type", this.f21677a);
        Comparator<T> comparator = this.f21678b;
        if (comparator != null) {
            bVarF.f("comparator", comparator);
        }
        return bVarF.toString();
    }
}
