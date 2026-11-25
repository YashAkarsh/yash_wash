package com.google.common.collect;

import java.util.Comparator;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
@s1.b(emulated = true)
abstract class o4<E> extends x5<E> implements wf<E> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private transient Comparator<? super E> f20772a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private transient NavigableSet<E> f20773b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private transient Set<hd.a<E>> f20774c;

    class a extends md.i<E> {
        a() {
        }

        @Override // com.google.common.collect.md.i
        hd<E> g() {
            return o4.this;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<hd.a<E>> iterator() {
            return o4.this.G0();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return o4.this.H0().entrySet().size();
        }
    }

    o4() {
    }

    @Override // com.google.common.collect.wf
    public wf<E> C() {
        return H0();
    }

    Set<hd.a<E>> F0() {
        return new a();
    }

    abstract Iterator<hd.a<E>> G0();

    abstract wf<E> H0();

    @Override // com.google.common.collect.wf, com.google.common.collect.qf
    public Comparator<? super E> comparator() {
        Comparator<? super E> comparator = this.f20772a;
        if (comparator != null) {
            return comparator;
        }
        td tdVarF = td.i(H0().comparator()).F();
        this.f20772a = tdVarF;
        return tdVarF;
    }

    @Override // com.google.common.collect.x5, com.google.common.collect.hd
    public Set<hd.a<E>> entrySet() {
        Set<hd.a<E>> set = this.f20774c;
        if (set != null) {
            return set;
        }
        Set<hd.a<E>> setF0 = F0();
        this.f20774c = setF0;
        return setF0;
    }

    @Override // com.google.common.collect.wf
    public hd.a<E> firstEntry() {
        return H0().lastEntry();
    }

    @Override // com.google.common.collect.wf
    public wf<E> g0(E e8, s0 s0Var) {
        return H0().o0(e8, s0Var).C();
    }

    @Override // com.google.common.collect.j5, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
    public Iterator<E> iterator() {
        return md.p(this);
    }

    @Override // com.google.common.collect.wf
    public hd.a<E> lastEntry() {
        return H0().firstEntry();
    }

    @Override // com.google.common.collect.wf
    public wf<E> o0(E e8, s0 s0Var) {
        return H0().g0(e8, s0Var).C();
    }

    @Override // com.google.common.collect.wf
    public hd.a<E> pollFirstEntry() {
        return H0().pollLastEntry();
    }

    @Override // com.google.common.collect.wf
    public hd.a<E> pollLastEntry() {
        return H0().pollFirstEntry();
    }

    @Override // com.google.common.collect.j5, java.util.Collection, java.util.Set
    public Object[] toArray() {
        return q0();
    }

    @Override // com.google.common.collect.b6
    public String toString() {
        return entrySet().toString();
    }

    @Override // com.google.common.collect.wf
    public wf<E> v0(E e8, s0 s0Var, E e9, s0 s0Var2) {
        return H0().v0(e9, s0Var2, e8, s0Var).C();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.common.collect.x5, com.google.common.collect.j5
    /* JADX INFO: renamed from: w0 */
    public hd<E> c0() {
        return H0();
    }

    @Override // com.google.common.collect.j5, java.util.Collection, java.util.Set
    public <T> T[] toArray(T[] tArr) {
        return (T[]) t0(tArr);
    }

    @Override // com.google.common.collect.x5, com.google.common.collect.hd
    public NavigableSet<E> e() {
        NavigableSet<E> navigableSet = this.f20773b;
        if (navigableSet != null) {
            return navigableSet;
        }
        zf.b bVar = new zf.b(this);
        this.f20773b = bVar;
        return bVar;
    }
}
