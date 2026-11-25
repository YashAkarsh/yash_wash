package com.google.common.collect;

import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@s1.b(serializable = true)
final class i0 extends td<Object> implements Serializable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static final i0 f20398c = new i0();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final long f20399d = 0;

    i0() {
    }

    private Object readResolve() {
        return f20398c;
    }

    @Override // com.google.common.collect.td
    public <S> td<S> F() {
        return this;
    }

    @Override // com.google.common.collect.td
    public <E> List<E> H(Iterable<E> iterable) {
        return ib.r(iterable);
    }

    @Override // com.google.common.collect.td, java.util.Comparator
    public int compare(Object obj, Object obj2) {
        return 0;
    }

    @Override // com.google.common.collect.td
    public <E> d7<E> l(Iterable<E> iterable) {
        return d7.p(iterable);
    }

    public String toString() {
        return "Ordering.allEqual()";
    }
}
