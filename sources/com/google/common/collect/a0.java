package com.google.common.collect;

import java.lang.Comparable;

/* JADX INFO: loaded from: classes2.dex */
@s1.c
abstract class a0<C extends Comparable> implements be<C> {
    a0() {
    }

    @Override // com.google.common.collect.be
    public boolean a(C c8) {
        return j(c8) != null;
    }

    @Override // com.google.common.collect.be
    public void b(xd<C> xdVar) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.be
    public void clear() {
        b(xd.a());
    }

    @Override // com.google.common.collect.be
    public /* synthetic */ void d(Iterable iterable) {
        ae.a(this, iterable);
    }

    @Override // com.google.common.collect.be
    public void e(be<C> beVar) {
        d(beVar.o());
    }

    @Override // com.google.common.collect.be
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof be) {
            return o().equals(((be) obj).o());
        }
        return false;
    }

    @Override // com.google.common.collect.be
    public /* synthetic */ void f(Iterable iterable) {
        ae.c(this, iterable);
    }

    @Override // com.google.common.collect.be
    public boolean g(be<C> beVar) {
        return l(beVar.o());
    }

    @Override // com.google.common.collect.be
    public void h(xd<C> xdVar) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.be
    public final int hashCode() {
        return o().hashCode();
    }

    @Override // com.google.common.collect.be
    public boolean isEmpty() {
        return o().isEmpty();
    }

    @Override // com.google.common.collect.be
    public abstract xd<C> j(C c8);

    @Override // com.google.common.collect.be
    public abstract boolean k(xd<C> xdVar);

    @Override // com.google.common.collect.be
    public /* synthetic */ boolean l(Iterable iterable) {
        return ae.b(this, iterable);
    }

    @Override // com.google.common.collect.be
    public void p(be<C> beVar) {
        f(beVar.o());
    }

    @Override // com.google.common.collect.be
    public boolean q(xd<C> xdVar) {
        return !m(xdVar).isEmpty();
    }

    @Override // com.google.common.collect.be
    public final String toString() {
        return o().toString();
    }
}
