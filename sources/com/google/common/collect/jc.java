package com.google.common.collect;

import java.util.AbstractQueue;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Queue;

/* JADX INFO: loaded from: classes2.dex */
@s1.a
@s1.b
public final class jc<E> extends AbstractQueue<E> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final int f20468g = 1431655765;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final int f20469h = -1431655766;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final int f20470i = 11;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final jc<E>.c f20471a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final jc<E>.c f20472b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @s1.d
    final int f20473c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Object[] f20474d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f20475e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f20476f;

    @s1.a
    public static final class b<B> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final int f20477d = -1;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Comparator<B> f20478a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f20479b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f20480c;

        /* JADX INFO: Access modifiers changed from: private */
        public <T extends B> td<T> g() {
            return td.i(this.f20478a);
        }

        public <T extends B> jc<T> c() {
            return d(Collections.emptySet());
        }

        public <T extends B> jc<T> d(Iterable<? extends T> iterable) {
            jc<T> jcVar = new jc<>(this, jc.s(this.f20479b, this.f20480c, iterable));
            Iterator<? extends T> it = iterable.iterator();
            while (it.hasNext()) {
                jcVar.offer(it.next());
            }
            return jcVar;
        }

        @u1.a
        public b<B> e(int i7) {
            com.google.common.base.e0.d(i7 >= 0);
            this.f20479b = i7;
            return this;
        }

        @u1.a
        public b<B> f(int i7) {
            com.google.common.base.e0.d(i7 > 0);
            this.f20480c = i7;
            return this;
        }

        private b(Comparator<B> comparator) {
            this.f20479b = -1;
            this.f20480c = Integer.MAX_VALUE;
            this.f20478a = (Comparator) com.google.common.base.e0.E(comparator);
        }
    }

    private class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final td<E> f20481a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @y1.i
        jc<E>.c f20482b;

        c(td<E> tdVar) {
            this.f20481a = tdVar;
        }

        private int k(int i7) {
            return m(m(i7));
        }

        private int l(int i7) {
            return (i7 * 2) + 1;
        }

        private int m(int i7) {
            return (i7 - 1) / 2;
        }

        private int n(int i7) {
            return (i7 * 2) + 2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean q(int i7) {
            if (l(i7) < jc.this.f20475e && d(i7, l(i7)) > 0) {
                return false;
            }
            if (n(i7) < jc.this.f20475e && d(i7, n(i7)) > 0) {
                return false;
            }
            if (i7 <= 0 || d(i7, m(i7)) <= 0) {
                return i7 <= 2 || d(k(i7), i7) <= 0;
            }
            return false;
        }

        void b(int i7, E e8) {
            c cVar;
            int iF = f(i7, e8);
            if (iF == i7) {
                iF = i7;
                cVar = this;
            } else {
                cVar = this.f20482b;
            }
            cVar.c(iF, e8);
        }

        @u1.a
        int c(int i7, E e8) {
            while (i7 > 2) {
                int iK = k(i7);
                Object objL = jc.this.l(iK);
                if (this.f20481a.compare((E) objL, e8) <= 0) {
                    break;
                }
                jc.this.f20474d[i7] = objL;
                i7 = iK;
            }
            jc.this.f20474d[i7] = e8;
            return i7;
        }

        int d(int i7, int i8) {
            return this.f20481a.compare((E) jc.this.l(i7), (E) jc.this.l(i8));
        }

        int e(int i7, E e8) {
            int i8 = i(i7);
            if (i8 <= 0 || this.f20481a.compare((E) jc.this.l(i8), e8) >= 0) {
                return f(i7, e8);
            }
            jc.this.f20474d[i7] = jc.this.l(i8);
            jc.this.f20474d[i8] = e8;
            return i8;
        }

        int f(int i7, E e8) {
            int iN;
            if (i7 == 0) {
                jc.this.f20474d[0] = e8;
                return 0;
            }
            int iM = m(i7);
            Object objL = jc.this.l(iM);
            if (iM != 0 && (iN = n(m(iM))) != iM && l(iN) >= jc.this.f20475e) {
                Object objL2 = jc.this.l(iN);
                if (this.f20481a.compare((E) objL2, (E) objL) < 0) {
                    iM = iN;
                    objL = objL2;
                }
            }
            if (this.f20481a.compare((E) objL, e8) >= 0) {
                jc.this.f20474d[i7] = e8;
                return i7;
            }
            jc.this.f20474d[i7] = objL;
            jc.this.f20474d[iM] = e8;
            return iM;
        }

        int g(int i7) {
            while (true) {
                int iJ = j(i7);
                if (iJ <= 0) {
                    return i7;
                }
                jc.this.f20474d[i7] = jc.this.l(iJ);
                i7 = iJ;
            }
        }

        int h(int i7, int i8) {
            if (i7 >= jc.this.f20475e) {
                return -1;
            }
            com.google.common.base.e0.g0(i7 > 0);
            int iMin = Math.min(i7, jc.this.f20475e - i8) + i8;
            for (int i9 = i7 + 1; i9 < iMin; i9++) {
                if (d(i9, i7) < 0) {
                    i7 = i9;
                }
            }
            return i7;
        }

        int i(int i7) {
            return h(l(i7), 2);
        }

        int j(int i7) {
            int iL = l(i7);
            if (iL < 0) {
                return -1;
            }
            return h(l(iL), 4);
        }

        int o(E e8) {
            int iN;
            int iM = m(jc.this.f20475e);
            if (iM != 0 && (iN = n(m(iM))) != iM && l(iN) >= jc.this.f20475e) {
                Object objL = jc.this.l(iN);
                if (this.f20481a.compare((E) objL, e8) < 0) {
                    jc.this.f20474d[iN] = e8;
                    jc.this.f20474d[jc.this.f20475e] = objL;
                    return iN;
                }
            }
            return jc.this.f20475e;
        }

        d<E> p(int i7, int i8, E e8) {
            int iE = e(i8, e8);
            if (iE == i8) {
                return null;
            }
            Object objL = iE < i7 ? jc.this.l(i7) : jc.this.l(m(i7));
            if (this.f20482b.c(iE, e8) < i7) {
                return new d<>(e8, objL);
            }
            return null;
        }
    }

    static class d<E> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final E f20484a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final E f20485b;

        d(E e8, E e9) {
            this.f20484a = e8;
            this.f20485b = e9;
        }
    }

    private class e implements Iterator<E> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f20486a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f20487b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f20488c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private Queue<E> f20489d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private List<E> f20490e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private E f20491f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private boolean f20492g;

        private e() {
            this.f20486a = -1;
            this.f20487b = -1;
            this.f20488c = jc.this.f20476f;
        }

        private void a() {
            if (jc.this.f20476f != this.f20488c) {
                throw new ConcurrentModificationException();
            }
        }

        private boolean b(Iterable<E> iterable, E e8) {
            Iterator<E> it = iterable.iterator();
            while (it.hasNext()) {
                if (it.next() == e8) {
                    it.remove();
                    return true;
                }
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        private void c(int i7) {
            if (this.f20487b < i7) {
                if (this.f20490e != null) {
                    while (i7 < jc.this.size() && b(this.f20490e, jc.this.l(i7))) {
                        i7++;
                    }
                }
                this.f20487b = i7;
            }
        }

        private boolean d(Object obj) {
            for (int i7 = 0; i7 < jc.this.f20475e; i7++) {
                if (jc.this.f20474d[i7] == obj) {
                    jc.this.z(i7);
                    return true;
                }
            }
            return false;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            a();
            c(this.f20486a + 1);
            if (this.f20487b < jc.this.size()) {
                return true;
            }
            Queue<E> queue = this.f20489d;
            return (queue == null || queue.isEmpty()) ? false : true;
        }

        @Override // java.util.Iterator
        public E next() {
            a();
            c(this.f20486a + 1);
            if (this.f20487b < jc.this.size()) {
                int i7 = this.f20487b;
                this.f20486a = i7;
                this.f20492g = true;
                return (E) jc.this.l(i7);
            }
            if (this.f20489d != null) {
                this.f20486a = jc.this.size();
                E ePoll = this.f20489d.poll();
                this.f20491f = ePoll;
                if (ePoll != null) {
                    this.f20492g = true;
                    return ePoll;
                }
            }
            throw new NoSuchElementException("iterator moved past last element in queue.");
        }

        @Override // java.util.Iterator
        public void remove() {
            f2.e(this.f20492g);
            a();
            this.f20492g = false;
            this.f20488c++;
            if (this.f20486a >= jc.this.size()) {
                com.google.common.base.e0.g0(d(this.f20491f));
                this.f20491f = null;
                return;
            }
            d<E> dVarZ = jc.this.z(this.f20486a);
            if (dVarZ != null) {
                if (this.f20489d == null) {
                    this.f20489d = new ArrayDeque();
                    this.f20490e = new ArrayList(3);
                }
                if (!b(this.f20490e, dVarZ.f20484a)) {
                    this.f20489d.add(dVarZ.f20484a);
                }
                if (!b(this.f20489d, dVarZ.f20485b)) {
                    this.f20490e.add(dVarZ.f20485b);
                }
            }
            this.f20486a--;
            this.f20487b--;
        }
    }

    private int f() {
        int length = this.f20474d.length;
        return g(length < 64 ? (length + 1) * 2 : com.google.common.math.d.d(length / 2, 3), this.f20473c);
    }

    private static int g(int i7, int i8) {
        return Math.min(i7 - 1, i8) + 1;
    }

    public static <E extends Comparable<E>> jc<E> j() {
        return new b(td.A()).c();
    }

    public static <E extends Comparable<E>> jc<E> k(Iterable<? extends E> iterable) {
        return new b(td.A()).d(iterable);
    }

    public static b<Comparable> m(int i7) {
        return new b(td.A()).e(i7);
    }

    private d<E> n(int i7, E e8) {
        jc<E>.c cVarR = r(i7);
        int iG = cVarR.g(i7);
        int iC = cVarR.c(iG, e8);
        if (iC == iG) {
            return cVarR.p(i7, iG, e8);
        }
        if (iC < i7) {
            return new d<>(e8, l(i7));
        }
        return null;
    }

    private int o() {
        int i7 = this.f20475e;
        if (i7 != 1) {
            return (i7 == 2 || this.f20472b.d(1, 2) <= 0) ? 1 : 2;
        }
        return 0;
    }

    private void p() {
        if (this.f20475e > this.f20474d.length) {
            Object[] objArr = new Object[f()];
            Object[] objArr2 = this.f20474d;
            System.arraycopy(objArr2, 0, objArr, 0, objArr2.length);
            this.f20474d = objArr;
        }
    }

    private jc<E>.c r(int i7) {
        return t(i7) ? this.f20471a : this.f20472b;
    }

    @s1.d
    static int s(int i7, int i8, Iterable<?> iterable) {
        if (i7 == -1) {
            i7 = 11;
        }
        if (iterable instanceof Collection) {
            i7 = Math.max(i7, ((Collection) iterable).size());
        }
        return g(i7, i8);
    }

    @s1.d
    static boolean t(int i7) {
        int i8 = ~(~(i7 + 1));
        com.google.common.base.e0.h0(i8 > 0, "negative index");
        return (f20468g & i8) > (i8 & f20469h);
    }

    public static b<Comparable> v(int i7) {
        return new b(td.A()).f(i7);
    }

    public static <B> b<B> w(Comparator<B> comparator) {
        return new b<>(comparator);
    }

    private E x(int i7) {
        E eL = l(i7);
        z(i7);
        return eL;
    }

    @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection, java.util.Queue
    @u1.a
    public boolean add(E e8) {
        offer(e8);
        return true;
    }

    @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection
    @u1.a
    public boolean addAll(Collection<? extends E> collection) {
        Iterator<? extends E> it = collection.iterator();
        boolean z7 = false;
        while (it.hasNext()) {
            offer(it.next());
            z7 = true;
        }
        return z7;
    }

    @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection
    public void clear() {
        for (int i7 = 0; i7 < this.f20475e; i7++) {
            this.f20474d[i7] = null;
        }
        this.f20475e = 0;
    }

    public Comparator<? super E> comparator() {
        return this.f20471a.f20481a;
    }

    @s1.d
    int h() {
        return this.f20474d.length;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public Iterator<E> iterator() {
        return new e();
    }

    E l(int i7) {
        return (E) this.f20474d[i7];
    }

    @Override // java.util.Queue
    @u1.a
    public boolean offer(E e8) {
        com.google.common.base.e0.E(e8);
        this.f20476f++;
        int i7 = this.f20475e;
        this.f20475e = i7 + 1;
        p();
        r(i7).b(i7, e8);
        return this.f20475e <= this.f20473c || pollLast() != e8;
    }

    @Override // java.util.Queue
    public E peek() {
        if (isEmpty()) {
            return null;
        }
        return l(0);
    }

    public E peekFirst() {
        return peek();
    }

    public E peekLast() {
        if (isEmpty()) {
            return null;
        }
        return l(o());
    }

    @Override // java.util.Queue
    @u1.a
    public E poll() {
        if (isEmpty()) {
            return null;
        }
        return x(0);
    }

    @u1.a
    public E pollFirst() {
        return poll();
    }

    @u1.a
    public E pollLast() {
        if (isEmpty()) {
            return null;
        }
        return x(o());
    }

    @u1.a
    public E removeFirst() {
        return remove();
    }

    @u1.a
    public E removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return x(o());
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        return this.f20475e;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public Object[] toArray() {
        int i7 = this.f20475e;
        Object[] objArr = new Object[i7];
        System.arraycopy(this.f20474d, 0, objArr, 0, i7);
        return objArr;
    }

    @s1.d
    boolean u() {
        for (int i7 = 1; i7 < this.f20475e; i7++) {
            if (!r(i7).q(i7)) {
                return false;
            }
        }
        return true;
    }

    @u1.a
    @s1.d
    d<E> z(int i7) {
        com.google.common.base.e0.d0(i7, this.f20475e);
        this.f20476f++;
        int i8 = this.f20475e - 1;
        this.f20475e = i8;
        if (i8 == i7) {
            this.f20474d[i8] = null;
            return null;
        }
        E eL = l(i8);
        int iO = r(this.f20475e).o(eL);
        if (iO == i7) {
            this.f20474d[this.f20475e] = null;
            return null;
        }
        E eL2 = l(this.f20475e);
        this.f20474d[this.f20475e] = null;
        d<E> dVarN = n(i7, eL2);
        if (iO < i7) {
            return dVarN == null ? new d<>(eL, eL2) : new d<>(eL, dVarN.f20485b);
        }
        return dVarN;
    }

    private jc(b<? super E> bVar, int i7) {
        td tdVarG = bVar.g();
        jc<E>.c cVar = new c(tdVarG);
        this.f20471a = cVar;
        jc<E>.c cVar2 = new c(tdVarG.F());
        this.f20472b = cVar2;
        cVar.f20482b = cVar2;
        cVar2.f20482b = cVar;
        this.f20473c = ((b) bVar).f20480c;
        this.f20474d = new Object[i7];
    }
}
