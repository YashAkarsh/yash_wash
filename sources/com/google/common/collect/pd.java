package com.google.common.collect;

import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
@s1.b(serializable = true)
final class pd extends td<Comparable> implements Serializable {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    static final pd f20900e = new pd();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final long f20901f = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private transient td<Comparable> f20902c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private transient td<Comparable> f20903d;

    private pd() {
    }

    private Object readResolve() {
        return f20900e;
    }

    @Override // com.google.common.collect.td
    public <S extends Comparable> td<S> B() {
        td<S> tdVar = (td<S>) this.f20902c;
        if (tdVar != null) {
            return tdVar;
        }
        td<S> tdVarB = super.B();
        this.f20902c = tdVarB;
        return tdVarB;
    }

    @Override // com.google.common.collect.td
    public <S extends Comparable> td<S> C() {
        td<S> tdVar = (td<S>) this.f20903d;
        if (tdVar != null) {
            return tdVar;
        }
        td<S> tdVarC = super.C();
        this.f20903d = tdVarC;
        return tdVarC;
    }

    @Override // com.google.common.collect.td
    public <S extends Comparable> td<S> F() {
        return oe.f20853c;
    }

    @Override // com.google.common.collect.td, java.util.Comparator
    /* JADX INFO: renamed from: J, reason: merged with bridge method [inline-methods] */
    public int compare(Comparable comparable, Comparable comparable2) {
        com.google.common.base.e0.E(comparable);
        com.google.common.base.e0.E(comparable2);
        return comparable.compareTo(comparable2);
    }

    public String toString() {
        return "Ordering.natural()";
    }
}
