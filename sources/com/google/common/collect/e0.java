package com.google.common.collect;

import java.util.Comparator;
import java.util.Iterator;
import java.util.NavigableSet;

/* JADX INFO: loaded from: classes2.dex */
@s1.b(emulated = true)
abstract class e0<E> extends y<E> implements wf<E> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @l6
    final Comparator<? super E> f20186c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private transient wf<E> f20187d;

    class a extends o4<E> {
        a() {
        }

        @Override // com.google.common.collect.o4
        Iterator<hd.a<E>> G0() {
            return e0.this.k();
        }

        @Override // com.google.common.collect.o4
        wf<E> H0() {
            return e0.this;
        }

        @Override // com.google.common.collect.o4, com.google.common.collect.j5, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
        public Iterator<E> iterator() {
            return e0.this.descendingIterator();
        }
    }

    e0() {
        this(td.A());
    }

    @Override // com.google.common.collect.wf
    public wf<E> C() {
        wf<E> wfVar = this.f20187d;
        if (wfVar != null) {
            return wfVar;
        }
        wf<E> wfVarH = h();
        this.f20187d = wfVarH;
        return wfVarH;
    }

    @Override // com.google.common.collect.wf, com.google.common.collect.qf
    public Comparator<? super E> comparator() {
        return this.f20186c;
    }

    Iterator<E> descendingIterator() {
        return md.p(C());
    }

    @Override // com.google.common.collect.wf
    public hd.a<E> firstEntry() {
        Iterator<hd.a<E>> itG = g();
        if (itG.hasNext()) {
            return itG.next();
        }
        return null;
    }

    wf<E> h() {
        return new a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.y
    /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
    public NavigableSet<E> a() {
        return new zf.b(this);
    }

    abstract Iterator<hd.a<E>> k();

    @Override // com.google.common.collect.wf
    public hd.a<E> lastEntry() {
        Iterator<hd.a<E>> itK = k();
        if (itK.hasNext()) {
            return itK.next();
        }
        return null;
    }

    @Override // com.google.common.collect.wf
    public hd.a<E> pollFirstEntry() {
        Iterator<hd.a<E>> itG = g();
        if (!itG.hasNext()) {
            return null;
        }
        hd.a<E> next = itG.next();
        hd.a<E> aVarM = md.m(next.getElement(), next.getCount());
        itG.remove();
        return aVarM;
    }

    @Override // com.google.common.collect.wf
    public hd.a<E> pollLastEntry() {
        Iterator<hd.a<E>> itK = k();
        if (!itK.hasNext()) {
            return null;
        }
        hd.a<E> next = itK.next();
        hd.a<E> aVarM = md.m(next.getElement(), next.getCount());
        itK.remove();
        return aVarM;
    }

    @Override // com.google.common.collect.wf
    public wf<E> v0(E e8, s0 s0Var, E e9, s0 s0Var2) {
        com.google.common.base.e0.E(s0Var);
        com.google.common.base.e0.E(s0Var2);
        return o0(e8, s0Var).g0(e9, s0Var2);
    }

    e0(Comparator<? super E> comparator) {
        this.f20186c = (Comparator) com.google.common.base.e0.E(comparator);
    }

    @Override // com.google.common.collect.y, com.google.common.collect.hd
    public NavigableSet<E> e() {
        return (NavigableSet) super.e();
    }
}
