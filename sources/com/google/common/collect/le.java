package com.google.common.collect;

import java.util.Comparator;
import java.util.function.ObjIntConsumer;

/* JADX INFO: loaded from: classes2.dex */
@s1.c
final class le<E> extends q9<E> {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final long[] f20591j = {0};

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    static final q9<Comparable> f20592k = new le(td.A());

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @s1.d
    final transient me<E> f20593f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final transient long[] f20594g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final transient int f20595h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final transient int f20596i;

    le(Comparator<? super E> comparator) {
        this.f20593f = s9.m0(comparator);
        this.f20594g = f20591j;
        this.f20595h = 0;
        this.f20596i = 0;
    }

    private int Q0(int i7) {
        long[] jArr = this.f20594g;
        int i8 = this.f20595h;
        return (int) (jArr[(i8 + i7) + 1] - jArr[i8 + i7]);
    }

    @Override // com.google.common.collect.p8
    hd.a<E> A(int i7) {
        return md.m(this.f20593f.a().get(i7), Q0(i7));
    }

    @Override // com.google.common.collect.q9, com.google.common.collect.wf
    /* JADX INFO: renamed from: N0, reason: merged with bridge method [inline-methods] */
    public q9<E> o0(E e8, s0 s0Var) {
        return R0(this.f20593f.O0(e8, com.google.common.base.e0.E(s0Var) == s0.CLOSED), this.f20596i);
    }

    q9<E> R0(int i7, int i8) {
        com.google.common.base.e0.f0(i7, i8, this.f20596i);
        if (i7 == i8) {
            return q9.u0(comparator());
        }
        return (i7 == 0 && i8 == this.f20596i) ? this : new le(this.f20593f.M0(i7, i8), this.f20594g, this.f20595h + i7, i8 - i7);
    }

    @Override // com.google.common.collect.wf
    public hd.a<E> firstEntry() {
        if (isEmpty()) {
            return null;
        }
        return A(0);
    }

    @Override // com.google.common.collect.x6
    boolean h() {
        return this.f20595h > 0 || this.f20596i < this.f20594g.length - 1;
    }

    @Override // com.google.common.collect.p8, com.google.common.collect.hd
    public void h0(ObjIntConsumer<? super E> objIntConsumer) {
        com.google.common.base.e0.E(objIntConsumer);
        for (int i7 = 0; i7 < this.f20596i; i7++) {
            objIntConsumer.accept(this.f20593f.a().get(i7), Q0(i7));
        }
    }

    @Override // com.google.common.collect.hd
    public int l0(Object obj) {
        int iIndexOf = this.f20593f.indexOf(obj);
        if (iIndexOf >= 0) {
            return Q0(iIndexOf);
        }
        return 0;
    }

    @Override // com.google.common.collect.wf
    public hd.a<E> lastEntry() {
        if (isEmpty()) {
            return null;
        }
        return A(this.f20596i - 1);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, com.google.common.collect.hd
    public int size() {
        long[] jArr = this.f20594g;
        int i7 = this.f20595h;
        return com.google.common.primitives.c0.x(jArr[this.f20596i + i7] - jArr[i7]);
    }

    @Override // com.google.common.collect.q9, com.google.common.collect.p8
    /* JADX INFO: renamed from: t0, reason: merged with bridge method [inline-methods] */
    public s9<E> e() {
        return this.f20593f;
    }

    @Override // com.google.common.collect.q9, com.google.common.collect.wf
    /* JADX INFO: renamed from: w0, reason: merged with bridge method [inline-methods] */
    public q9<E> g0(E e8, s0 s0Var) {
        return R0(0, this.f20593f.N0(e8, com.google.common.base.e0.E(s0Var) == s0.CLOSED));
    }

    le(me<E> meVar, long[] jArr, int i7, int i8) {
        this.f20593f = meVar;
        this.f20594g = jArr;
        this.f20595h = i7;
        this.f20596i = i8;
    }
}
