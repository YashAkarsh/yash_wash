package com.google.common.collect;

import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
@s1.b(serializable = true)
final class qd<T> extends td<T> implements Serializable {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final long f20991d = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final td<? super T> f20992c;

    qd(td<? super T> tdVar) {
        this.f20992c = tdVar;
    }

    @Override // com.google.common.collect.td
    public <S extends T> td<S> B() {
        return this;
    }

    @Override // com.google.common.collect.td
    public <S extends T> td<S> C() {
        return this.f20992c.C();
    }

    @Override // com.google.common.collect.td
    public <S extends T> td<S> F() {
        return this.f20992c.F().C();
    }

    @Override // com.google.common.collect.td, java.util.Comparator
    public int compare(T t7, T t8) {
        if (t7 == t8) {
            return 0;
        }
        if (t7 == null) {
            return -1;
        }
        if (t8 == null) {
            return 1;
        }
        return this.f20992c.compare(t7, t8);
    }

    @Override // java.util.Comparator
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof qd) {
            return this.f20992c.equals(((qd) obj).f20992c);
        }
        return false;
    }

    public int hashCode() {
        return this.f20992c.hashCode() ^ 957692532;
    }

    public String toString() {
        return this.f20992c + ".nullsFirst()";
    }
}
