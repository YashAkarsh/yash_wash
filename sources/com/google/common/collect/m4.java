package com.google.common.collect;

/* JADX INFO: loaded from: classes2.dex */
@s1.c
final class m4<E> extends q9<E> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final transient q9<E> f20601f;

    m4(q9<E> q9Var) {
        this.f20601f = q9Var;
    }

    @Override // com.google.common.collect.p8
    hd.a<E> A(int i7) {
        return this.f20601f.entrySet().a().O().get(i7);
    }

    @Override // com.google.common.collect.q9, com.google.common.collect.wf
    /* JADX INFO: renamed from: N0 */
    public q9<E> o0(E e8, s0 s0Var) {
        return this.f20601f.g0(e8, s0Var).C();
    }

    @Override // com.google.common.collect.wf
    public hd.a<E> firstEntry() {
        return this.f20601f.lastEntry();
    }

    @Override // com.google.common.collect.x6
    boolean h() {
        return this.f20601f.h();
    }

    @Override // com.google.common.collect.hd
    public int l0(Object obj) {
        return this.f20601f.l0(obj);
    }

    @Override // com.google.common.collect.wf
    public hd.a<E> lastEntry() {
        return this.f20601f.firstEntry();
    }

    @Override // com.google.common.collect.q9, com.google.common.collect.wf
    /* JADX INFO: renamed from: s0, reason: merged with bridge method [inline-methods] */
    public q9<E> C() {
        return this.f20601f;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, com.google.common.collect.hd
    public int size() {
        return this.f20601f.size();
    }

    @Override // com.google.common.collect.q9, com.google.common.collect.p8
    /* JADX INFO: renamed from: t0 */
    public s9<E> e() {
        return this.f20601f.e().descendingSet();
    }

    @Override // com.google.common.collect.q9, com.google.common.collect.wf
    /* JADX INFO: renamed from: w0 */
    public q9<E> g0(E e8, s0 s0Var) {
        return this.f20601f.o0(e8, s0Var).C();
    }
}
