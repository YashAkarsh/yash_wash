package com.google.common.collect;

import java.util.Comparator;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.NoSuchElementException;
import java.util.SortedSet;

/* JADX INFO: loaded from: classes2.dex */
@s1.b(emulated = true)
final class zf {

    static class a<E> extends md.h<E> implements SortedSet<E> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @y1.i
        private final wf<E> f21496a;

        a(wf<E> wfVar) {
            this.f21496a = wfVar;
        }

        @Override // java.util.SortedSet
        public Comparator<? super E> comparator() {
            return g().comparator();
        }

        @Override // java.util.SortedSet
        public E first() {
            return (E) zf.d(g().firstEntry());
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.md.h
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public final wf<E> g() {
            return this.f21496a;
        }

        @Override // java.util.SortedSet
        public SortedSet<E> headSet(E e8) {
            return g().g0(e8, s0.OPEN).e();
        }

        @Override // com.google.common.collect.md.h, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<E> iterator() {
            return md.j(g().entrySet().iterator());
        }

        @Override // java.util.SortedSet
        public E last() {
            return (E) zf.d(g().lastEntry());
        }

        @Override // java.util.SortedSet
        public SortedSet<E> subSet(E e8, E e9) {
            return g().v0(e8, s0.CLOSED, e9, s0.OPEN).e();
        }

        @Override // java.util.SortedSet
        public SortedSet<E> tailSet(E e8) {
            return g().o0(e8, s0.CLOSED).e();
        }
    }

    @s1.c
    static class b<E> extends a<E> implements NavigableSet<E> {
        b(wf<E> wfVar) {
            super(wfVar);
        }

        @Override // java.util.NavigableSet
        public E ceiling(E e8) {
            return (E) zf.c(g().o0(e8, s0.CLOSED).firstEntry());
        }

        @Override // java.util.NavigableSet
        public Iterator<E> descendingIterator() {
            return descendingSet().iterator();
        }

        @Override // java.util.NavigableSet
        public NavigableSet<E> descendingSet() {
            return new b(g().C());
        }

        @Override // java.util.NavigableSet
        public E floor(E e8) {
            return (E) zf.c(g().g0(e8, s0.CLOSED).lastEntry());
        }

        @Override // java.util.NavigableSet
        public NavigableSet<E> headSet(E e8, boolean z7) {
            return new b(g().g0(e8, s0.b(z7)));
        }

        @Override // java.util.NavigableSet
        public E higher(E e8) {
            return (E) zf.c(g().o0(e8, s0.OPEN).firstEntry());
        }

        @Override // java.util.NavigableSet
        public E lower(E e8) {
            return (E) zf.c(g().g0(e8, s0.OPEN).lastEntry());
        }

        @Override // java.util.NavigableSet
        public E pollFirst() {
            return (E) zf.c(g().pollFirstEntry());
        }

        @Override // java.util.NavigableSet
        public E pollLast() {
            return (E) zf.c(g().pollLastEntry());
        }

        @Override // java.util.NavigableSet
        public NavigableSet<E> subSet(E e8, boolean z7, E e9, boolean z8) {
            return new b(g().v0(e8, s0.b(z7), e9, s0.b(z8)));
        }

        @Override // java.util.NavigableSet
        public NavigableSet<E> tailSet(E e8, boolean z7) {
            return new b(g().o0(e8, s0.b(z7)));
        }
    }

    private zf() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <E> E c(hd.a<E> aVar) {
        if (aVar == null) {
            return null;
        }
        return aVar.getElement();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <E> E d(hd.a<E> aVar) {
        if (aVar != null) {
            return aVar.getElement();
        }
        throw new NoSuchElementException();
    }
}
