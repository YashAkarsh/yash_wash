package com.google.common.collect;

import java.util.Comparator;
import java.util.Iterator;
import java.util.NavigableSet;

/* JADX INFO: loaded from: classes2.dex */
@s1.a
@s1.b(emulated = true)
public abstract class g6<E> extends x5<E> implements wf<E> {

    protected abstract class a extends o4<E> {
        public a() {
        }

        @Override // com.google.common.collect.o4
        wf<E> H0() {
            return g6.this;
        }
    }

    protected class b extends zf.b<E> {
        public b() {
            super(g6.this);
        }
    }

    protected g6() {
    }

    @Override // com.google.common.collect.wf
    public wf<E> C() {
        return c0().C();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.common.collect.x5
    /* JADX INFO: renamed from: F0, reason: merged with bridge method [inline-methods] */
    public abstract wf<E> c0();

    protected hd.a<E> G0() {
        Iterator<hd.a<E>> it = entrySet().iterator();
        if (!it.hasNext()) {
            return null;
        }
        hd.a<E> next = it.next();
        return md.m(next.getElement(), next.getCount());
    }

    protected hd.a<E> H0() {
        Iterator<hd.a<E>> it = C().entrySet().iterator();
        if (!it.hasNext()) {
            return null;
        }
        hd.a<E> next = it.next();
        return md.m(next.getElement(), next.getCount());
    }

    protected hd.a<E> I0() {
        Iterator<hd.a<E>> it = entrySet().iterator();
        if (!it.hasNext()) {
            return null;
        }
        hd.a<E> next = it.next();
        hd.a<E> aVarM = md.m(next.getElement(), next.getCount());
        it.remove();
        return aVarM;
    }

    protected hd.a<E> J0() {
        Iterator<hd.a<E>> it = C().entrySet().iterator();
        if (!it.hasNext()) {
            return null;
        }
        hd.a<E> next = it.next();
        hd.a<E> aVarM = md.m(next.getElement(), next.getCount());
        it.remove();
        return aVarM;
    }

    protected wf<E> K0(E e8, s0 s0Var, E e9, s0 s0Var2) {
        return o0(e8, s0Var).g0(e9, s0Var2);
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
        return c0().g0(e8, s0Var);
    }

    @Override // com.google.common.collect.wf
    public hd.a<E> lastEntry() {
        return c0().lastEntry();
    }

    @Override // com.google.common.collect.wf
    public wf<E> o0(E e8, s0 s0Var) {
        return c0().o0(e8, s0Var);
    }

    @Override // com.google.common.collect.wf
    public hd.a<E> pollFirstEntry() {
        return c0().pollFirstEntry();
    }

    @Override // com.google.common.collect.wf
    public hd.a<E> pollLastEntry() {
        return c0().pollLastEntry();
    }

    @Override // com.google.common.collect.wf
    public wf<E> v0(E e8, s0 s0Var, E e9, s0 s0Var2) {
        return c0().v0(e8, s0Var, e9, s0Var2);
    }

    @Override // com.google.common.collect.x5, com.google.common.collect.hd
    public NavigableSet<E> e() {
        return c0().e();
    }
}
