package com.google.common.collect;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@s1.b
abstract class ne<R, C, V> extends ca<R, C, V> {

    static class a implements Comparator<oj.a<R, C, V>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Comparator f20763a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Comparator f20764b;

        a(Comparator comparator, Comparator comparator2) {
            this.f20763a = comparator;
            this.f20764b = comparator2;
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(oj.a<R, C, V> aVar, oj.a<R, C, V> aVar2) {
            Comparator comparator = this.f20763a;
            int iCompare = comparator == null ? 0 : comparator.compare(aVar.b(), aVar2.b());
            if (iCompare != 0) {
                return iCompare;
            }
            Comparator comparator2 = this.f20764b;
            if (comparator2 == null) {
                return 0;
            }
            return comparator2.compare(aVar.a(), aVar2.a());
        }
    }

    private final class b extends fa<oj.a<R, C, V>> {
        private b() {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.fa
        /* JADX INFO: renamed from: M, reason: merged with bridge method [inline-methods] */
        public oj.a<R, C, V> get(int i7) {
            return ne.this.l0(i7);
        }

        @Override // com.google.common.collect.x6, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            if (!(obj instanceof oj.a)) {
                return false;
            }
            oj.a aVar = (oj.a) obj;
            Object objK = ne.this.k(aVar.b(), aVar.a());
            return objK != null && objK.equals(aVar.getValue());
        }

        @Override // com.google.common.collect.x6
        boolean h() {
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return ne.this.size();
        }

        /* synthetic */ b(ne neVar, a aVar) {
            this();
        }
    }

    private final class c extends d7<V> {
        private c() {
        }

        @Override // java.util.List
        public V get(int i7) {
            return (V) ne.this.m0(i7);
        }

        @Override // com.google.common.collect.x6
        boolean h() {
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return ne.this.size();
        }

        /* synthetic */ c(ne neVar, a aVar) {
            this();
        }
    }

    ne() {
    }

    static <R, C, V> ne<R, C, V> h0(Iterable<oj.a<R, C, V>> iterable) {
        return j0(iterable, null, null);
    }

    static <R, C, V> ne<R, C, V> i0(List<oj.a<R, C, V>> list, Comparator<? super R> comparator, Comparator<? super C> comparator2) {
        com.google.common.base.e0.E(list);
        if (comparator != null || comparator2 != null) {
            Collections.sort(list, new a(comparator, comparator2));
        }
        return j0(list, comparator, comparator2);
    }

    private static <R, C, V> ne<R, C, V> j0(Iterable<oj.a<R, C, V>> iterable, Comparator<? super R> comparator, Comparator<? super C> comparator2) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        LinkedHashSet linkedHashSet2 = new LinkedHashSet();
        d7 d7VarP = d7.p(iterable);
        for (oj.a<R, C, V> aVar : iterable) {
            linkedHashSet.add(aVar.b());
            linkedHashSet2.add(aVar.a());
        }
        return k0(d7VarP, comparator == null ? u8.p(linkedHashSet) : u8.p(d7.S(comparator, linkedHashSet)), comparator2 == null ? u8.p(linkedHashSet2) : u8.p(d7.S(comparator2, linkedHashSet2)));
    }

    static <R, C, V> ne<R, C, V> k0(d7<oj.a<R, C, V>> d7Var, u8<R> u8Var, u8<C> u8Var2) {
        return ((long) d7Var.size()) > (((long) u8Var.size()) * ((long) u8Var2.size())) / 2 ? new l4(d7Var, u8Var, u8Var2) : new cg(d7Var, u8Var, u8Var2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.ca, com.google.common.collect.h0
    /* JADX INFO: renamed from: H, reason: merged with bridge method [inline-methods] */
    public final u8<oj.a<R, C, V>> c() {
        return isEmpty() ? u8.A() : new b(this, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.ca, com.google.common.collect.h0
    /* JADX INFO: renamed from: J, reason: merged with bridge method [inline-methods] */
    public final x6<V> d() {
        return isEmpty() ? d7.x() : new c(this, null);
    }

    abstract oj.a<R, C, V> l0(int i7);

    abstract V m0(int i7);
}
