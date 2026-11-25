package com.google.common.collect;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes2.dex */
@s1.b
final class u0<E> extends AbstractList<List<E>> implements RandomAccess {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final transient d7<List<E>> f21161a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final transient int[] f21162b;

    class a extends d7<E> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f21163c;

        a(int i7) {
            this.f21163c = i7;
        }

        @Override // java.util.List
        public E get(int i7) {
            com.google.common.base.e0.C(i7, size());
            return (E) ((List) u0.this.f21161a.get(i7)).get(u0.this.g(this.f21163c, i7));
        }

        @Override // com.google.common.collect.x6
        boolean h() {
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return u0.this.f21161a.size();
        }
    }

    u0(d7<List<E>> d7Var) {
        this.f21161a = d7Var;
        int[] iArr = new int[d7Var.size() + 1];
        iArr[d7Var.size()] = 1;
        try {
            for (int size = d7Var.size() - 1; size >= 0; size--) {
                iArr[size] = com.google.common.math.d.d(iArr[size + 1], d7Var.get(size).size());
            }
            this.f21162b = iArr;
        } catch (ArithmeticException unused) {
            throw new IllegalArgumentException("Cartesian product too large; must have size at most Integer.MAX_VALUE");
        }
    }

    static <E> List<List<E>> d(List<? extends List<? extends E>> list) {
        d7.b bVar = new d7.b(list.size());
        Iterator<? extends List<? extends E>> it = list.iterator();
        while (it.hasNext()) {
            d7 d7VarR = d7.r(it.next());
            if (d7VarR.isEmpty()) {
                return d7.x();
            }
            bVar.a(d7VarR);
        }
        return new u0(bVar.e());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int g(int i7, int i8) {
        return (i7 / this.f21162b[i8 + 1]) % this.f21161a.get(i8).size();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    @Override // java.util.AbstractList, java.util.List
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public d7<E> get(int i7) {
        com.google.common.base.e0.C(i7, size());
        return new a(i7);
    }

    @Override // java.util.AbstractList, java.util.List
    public int indexOf(Object obj) {
        if (!(obj instanceof List)) {
            return -1;
        }
        List list = (List) obj;
        if (list.size() != this.f21161a.size()) {
            return -1;
        }
        ListIterator<E> listIterator = list.listIterator();
        int i7 = 0;
        while (listIterator.hasNext()) {
            int iNextIndex = listIterator.nextIndex();
            int iIndexOf = this.f21161a.get(iNextIndex).indexOf(listIterator.next());
            if (iIndexOf == -1) {
                return -1;
            }
            i7 += iIndexOf * this.f21162b[iNextIndex + 1];
        }
        return i7;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f21162b[0];
    }
}
