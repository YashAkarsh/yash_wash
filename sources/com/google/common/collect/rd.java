package com.google.common.collect;

import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
@s1.b(serializable = true)
final class rd<T> extends td<T> implements Serializable {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final long f21002d = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final td<? super T> f21003c;

    rd(td<? super T> tdVar) {
        this.f21003c = tdVar;
    }

    @Override // com.google.common.collect.td
    public <S extends T> td<S> B() {
        return this.f21003c.B();
    }

    @Override // com.google.common.collect.td
    public <S extends T> td<S> C() {
        return this;
    }

    @Override // com.google.common.collect.td
    public <S extends T> td<S> F() {
        return this.f21003c.F().B();
    }

    @Override // com.google.common.collect.td, java.util.Comparator
    public int compare(T t7, T t8) {
        if (t7 == t8) {
            return 0;
        }
        if (t7 == null) {
            return 1;
        }
        if (t8 == null) {
            return -1;
        }
        return this.f21003c.compare(t7, t8);
    }

    @Override // java.util.Comparator
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof rd) {
            return this.f21003c.equals(((rd) obj).f21003c);
        }
        return false;
    }

    public int hashCode() {
        return this.f21003c.hashCode() ^ (-921210296);
    }

    public String toString() {
        return this.f21003c + ".nullsLast()";
    }
}
