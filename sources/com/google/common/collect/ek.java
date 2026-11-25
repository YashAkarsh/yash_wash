package com.google.common.collect;

import java.util.Comparator;
import java.util.NavigableSet;

/* JADX INFO: loaded from: classes2.dex */
@s1.b(emulated = true)
final class ek<E> extends md.m<E> implements wf<E> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final long f20220f = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private transient ek<E> f20221e;

    ek(wf<E> wfVar) {
        super(wfVar);
    }

    @Override // com.google.common.collect.wf
    public wf<E> C() {
        ek<E> ekVar = this.f20221e;
        if (ekVar != null) {
            return ekVar;
        }
        ek<E> ekVar2 = new ek<>(c0().C());
        ekVar2.f20221e = this;
        this.f20221e = ekVar2;
        return ekVar2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.md.m
    /* JADX INFO: renamed from: G0, reason: merged with bridge method [inline-methods] */
    public NavigableSet<E> F0() {
        return af.P(c0().e());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.common.collect.md.m, com.google.common.collect.x5
    /* JADX INFO: renamed from: H0, reason: merged with bridge method [inline-methods] */
    public wf<E> c0() {
        return (wf) super.c0();
    }

    @Override // com.google.common.collect.wf, com.google.common.collect.qf
    public Comparator<? super E> comparator() {
        return c0().comparator();
    }

    @Override // com.google.common.collect.wf
    public hd.a<E> firstEntry() {
        return c0().firstEntry();
    }

    @Override // com.google.common.collect.wf
    public wf<E> g0(E e8, s0 s0Var) {
        return md.I(c0().g0(e8, s0Var));
    }

    @Override // com.google.common.collect.wf
    public hd.a<E> lastEntry() {
        return c0().lastEntry();
    }

    @Override // com.google.common.collect.wf
    public wf<E> o0(E e8, s0 s0Var) {
        return md.I(c0().o0(e8, s0Var));
    }

    @Override // com.google.common.collect.wf
    public hd.a<E> pollFirstEntry() {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.wf
    public hd.a<E> pollLastEntry() {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.wf
    public wf<E> v0(E e8, s0 s0Var, E e9, s0 s0Var2) {
        return md.I(c0().v0(e8, s0Var, e9, s0Var2));
    }

    @Override // com.google.common.collect.md.m, com.google.common.collect.x5, com.google.common.collect.hd
    public NavigableSet<E> e() {
        return (NavigableSet) super.e();
    }
}
