package com.google.common.cache;

import com.google.common.base.n0;
import com.google.common.base.s0;
import com.google.common.collect.af;
import com.google.common.collect.u8;
import com.google.common.collect.ua;
import com.google.common.collect.v7;
import com.google.common.collect.wb;
import com.google.common.util.concurrent.d2;
import com.google.common.util.concurrent.e1;
import com.google.common.util.concurrent.l1;
import com.google.common.util.concurrent.n2;
import com.google.common.util.concurrent.o0;
import com.google.common.util.concurrent.p2;
import com.google.common.util.concurrent.v1;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.AbstractQueue;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes2.dex */
@s1.b(emulated = true)
class r<K, V> extends AbstractMap<K, V> implements ConcurrentMap<K, V> {
    static final int A = 16;
    static final Logger B = Logger.getLogger(r.class.getName());
    static final a0<Object, Object> C = new a();
    static final Queue<?> D = new b();

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    static final int f19691w = 1073741824;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    static final int f19692x = 65536;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    static final int f19693y = 3;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    static final int f19694z = 63;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final int f19695a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final int f19696b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final C0233r<K, V>[] f19697c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final int f19698d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final com.google.common.base.l<Object> f19699e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final com.google.common.base.l<Object> f19700f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final t f19701g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final t f19702h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final long f19703i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    final com.google.common.cache.d0<K, V> f19704j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    final long f19705k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    final long f19706l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    final long f19707m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    final Queue<com.google.common.cache.b0<K, V>> f19708n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    final com.google.common.cache.z<K, V> f19709o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    final s0 f19710p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    final f f19711q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    final com.google.common.cache.a.b f19712r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    final com.google.common.cache.g<? super K, V> f19713s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    Set<K> f19714t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    Collection<V> f19715u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    Set<Map.Entry<K, V>> f19716v;

    static class a implements a0<Object, Object> {
        a() {
        }

        @Override // com.google.common.cache.r.a0
        public com.google.common.cache.x<Object, Object> a() {
            return null;
        }

        @Override // com.google.common.cache.r.a0
        public boolean b() {
            return false;
        }

        @Override // com.google.common.cache.r.a0
        public void c(Object obj) {
        }

        @Override // com.google.common.cache.r.a0
        public int d() {
            return 0;
        }

        @Override // com.google.common.cache.r.a0
        public boolean e() {
            return false;
        }

        @Override // com.google.common.cache.r.a0
        public Object f() {
            return null;
        }

        @Override // com.google.common.cache.r.a0
        public a0<Object, Object> g(ReferenceQueue<Object> referenceQueue, Object obj, com.google.common.cache.x<Object, Object> xVar) {
            return this;
        }

        @Override // com.google.common.cache.r.a0
        public Object get() {
            return null;
        }
    }

    interface a0<K, V> {
        com.google.common.cache.x<K, V> a();

        boolean b();

        void c(V v7);

        int d();

        boolean e();

        V f() throws ExecutionException;

        a0<K, V> g(ReferenceQueue<V> referenceQueue, V v7, com.google.common.cache.x<K, V> xVar);

        V get();
    }

    static class b extends AbstractQueue<Object> {
        b() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<Object> iterator() {
            return u8.A().iterator();
        }

        @Override // java.util.Queue
        public boolean offer(Object obj) {
            return true;
        }

        @Override // java.util.Queue
        public Object peek() {
            return null;
        }

        @Override // java.util.Queue
        public Object poll() {
            return null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return 0;
        }
    }

    final class b0 extends AbstractCollection<V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ConcurrentMap<?, ?> f19717a;

        b0(ConcurrentMap<?, ?> concurrentMap) {
            this.f19717a = concurrentMap;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ boolean b(Predicate predicate, Object obj, Object obj2) {
            return predicate.test(obj2);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            this.f19717a.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            return this.f19717a.containsValue(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return this.f19717a.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            return new z();
        }

        @Override // java.util.Collection
        public boolean removeIf(final Predicate<? super V> predicate) {
            com.google.common.base.e0.E(predicate);
            return r.this.e0(new BiPredicate() { // from class: com.google.common.cache.t
                @Override // java.util.function.BiPredicate
                public final boolean test(Object obj, Object obj2) {
                    return r.b0.b(predicate, obj, obj2);
                }
            });
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return this.f19717a.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public Object[] toArray() {
            return r.g0(this).toArray();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public <E> E[] toArray(E[] eArr) {
            return (E[]) r.g0(this).toArray(eArr);
        }
    }

    abstract class c<T> extends AbstractSet<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @y1.i
        final ConcurrentMap<?, ?> f19719a;

        c(ConcurrentMap<?, ?> concurrentMap) {
            this.f19719a = concurrentMap;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            this.f19719a.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return this.f19719a.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.f19719a.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public Object[] toArray() {
            return r.g0(this).toArray();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public <E> E[] toArray(E[] eArr) {
            return (E[]) r.g0(this).toArray(eArr);
        }
    }

    static final class c0<K, V> extends e0<K, V> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        volatile long f19721d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        com.google.common.cache.x<K, V> f19722e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        com.google.common.cache.x<K, V> f19723f;

        c0(ReferenceQueue<K> referenceQueue, K k7, int i7, com.google.common.cache.x<K, V> xVar) {
            super(referenceQueue, k7, i7, xVar);
            this.f19721d = Long.MAX_VALUE;
            this.f19722e = r.P();
            this.f19723f = r.P();
        }

        @Override // com.google.common.cache.r.e0, com.google.common.cache.x
        public com.google.common.cache.x<K, V> d() {
            return this.f19723f;
        }

        @Override // com.google.common.cache.r.e0, com.google.common.cache.x
        public void g(long j7) {
            this.f19721d = j7;
        }

        @Override // com.google.common.cache.r.e0, com.google.common.cache.x
        public long i() {
            return this.f19721d;
        }

        @Override // com.google.common.cache.r.e0, com.google.common.cache.x
        public com.google.common.cache.x<K, V> k() {
            return this.f19722e;
        }

        @Override // com.google.common.cache.r.e0, com.google.common.cache.x
        public void l(com.google.common.cache.x<K, V> xVar) {
            this.f19722e = xVar;
        }

        @Override // com.google.common.cache.r.e0, com.google.common.cache.x
        public void o(com.google.common.cache.x<K, V> xVar) {
            this.f19723f = xVar;
        }
    }

    static abstract class d<K, V> implements com.google.common.cache.x<K, V> {
        d() {
        }

        @Override // com.google.common.cache.x
        public com.google.common.cache.x<K, V> a() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.x
        public a0<K, V> b() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.x
        public int c() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.x
        public com.google.common.cache.x<K, V> d() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.x
        public void e(a0<K, V> a0Var) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.x
        public long f() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.x
        public void g(long j7) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.x
        public K getKey() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.x
        public com.google.common.cache.x<K, V> h() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.x
        public long i() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.x
        public void j(long j7) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.x
        public com.google.common.cache.x<K, V> k() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.x
        public void l(com.google.common.cache.x<K, V> xVar) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.x
        public void m(com.google.common.cache.x<K, V> xVar) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.x
        public void n(com.google.common.cache.x<K, V> xVar) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.x
        public void o(com.google.common.cache.x<K, V> xVar) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.x
        public com.google.common.cache.x<K, V> p() {
            throw new UnsupportedOperationException();
        }
    }

    static final class d0<K, V> extends e0<K, V> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        volatile long f19724d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        com.google.common.cache.x<K, V> f19725e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        com.google.common.cache.x<K, V> f19726f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        volatile long f19727g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        com.google.common.cache.x<K, V> f19728h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        com.google.common.cache.x<K, V> f19729i;

        d0(ReferenceQueue<K> referenceQueue, K k7, int i7, com.google.common.cache.x<K, V> xVar) {
            super(referenceQueue, k7, i7, xVar);
            this.f19724d = Long.MAX_VALUE;
            this.f19725e = r.P();
            this.f19726f = r.P();
            this.f19727g = Long.MAX_VALUE;
            this.f19728h = r.P();
            this.f19729i = r.P();
        }

        @Override // com.google.common.cache.r.e0, com.google.common.cache.x
        public com.google.common.cache.x<K, V> d() {
            return this.f19726f;
        }

        @Override // com.google.common.cache.r.e0, com.google.common.cache.x
        public long f() {
            return this.f19727g;
        }

        @Override // com.google.common.cache.r.e0, com.google.common.cache.x
        public void g(long j7) {
            this.f19724d = j7;
        }

        @Override // com.google.common.cache.r.e0, com.google.common.cache.x
        public com.google.common.cache.x<K, V> h() {
            return this.f19728h;
        }

        @Override // com.google.common.cache.r.e0, com.google.common.cache.x
        public long i() {
            return this.f19724d;
        }

        @Override // com.google.common.cache.r.e0, com.google.common.cache.x
        public void j(long j7) {
            this.f19727g = j7;
        }

        @Override // com.google.common.cache.r.e0, com.google.common.cache.x
        public com.google.common.cache.x<K, V> k() {
            return this.f19725e;
        }

        @Override // com.google.common.cache.r.e0, com.google.common.cache.x
        public void l(com.google.common.cache.x<K, V> xVar) {
            this.f19725e = xVar;
        }

        @Override // com.google.common.cache.r.e0, com.google.common.cache.x
        public void m(com.google.common.cache.x<K, V> xVar) {
            this.f19728h = xVar;
        }

        @Override // com.google.common.cache.r.e0, com.google.common.cache.x
        public void n(com.google.common.cache.x<K, V> xVar) {
            this.f19729i = xVar;
        }

        @Override // com.google.common.cache.r.e0, com.google.common.cache.x
        public void o(com.google.common.cache.x<K, V> xVar) {
            this.f19726f = xVar;
        }

        @Override // com.google.common.cache.r.e0, com.google.common.cache.x
        public com.google.common.cache.x<K, V> p() {
            return this.f19729i;
        }
    }

    static final class e<K, V> extends AbstractQueue<com.google.common.cache.x<K, V>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final com.google.common.cache.x<K, V> f19730a = new a();

        class a extends d<K, V> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            com.google.common.cache.x<K, V> f19731a = this;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            com.google.common.cache.x<K, V> f19732b = this;

            a() {
            }

            @Override // com.google.common.cache.r.d, com.google.common.cache.x
            public com.google.common.cache.x<K, V> d() {
                return this.f19732b;
            }

            @Override // com.google.common.cache.r.d, com.google.common.cache.x
            public void g(long j7) {
            }

            @Override // com.google.common.cache.r.d, com.google.common.cache.x
            public long i() {
                return Long.MAX_VALUE;
            }

            @Override // com.google.common.cache.r.d, com.google.common.cache.x
            public com.google.common.cache.x<K, V> k() {
                return this.f19731a;
            }

            @Override // com.google.common.cache.r.d, com.google.common.cache.x
            public void l(com.google.common.cache.x<K, V> xVar) {
                this.f19731a = xVar;
            }

            @Override // com.google.common.cache.r.d, com.google.common.cache.x
            public void o(com.google.common.cache.x<K, V> xVar) {
                this.f19732b = xVar;
            }
        }

        class b extends com.google.common.collect.b0<com.google.common.cache.x<K, V>> {
            b(com.google.common.cache.x xVar) {
                super(xVar);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.common.collect.b0
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public com.google.common.cache.x<K, V> a(com.google.common.cache.x<K, V> xVar) {
                com.google.common.cache.x<K, V> xVarK = xVar.k();
                if (xVarK == e.this.f19730a) {
                    return null;
                }
                return xVarK;
            }
        }

        e() {
        }

        @Override // java.util.Queue
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean offer(com.google.common.cache.x<K, V> xVar) {
            r.f(xVar.d(), xVar.k());
            r.f(this.f19730a.d(), xVar);
            r.f(xVar, this.f19730a);
            return true;
        }

        @Override // java.util.Queue
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public com.google.common.cache.x<K, V> peek() {
            com.google.common.cache.x<K, V> xVarK = this.f19730a.k();
            if (xVarK == this.f19730a) {
                return null;
            }
            return xVarK;
        }

        @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection
        public void clear() {
            com.google.common.cache.x<K, V> xVarK = this.f19730a.k();
            while (true) {
                com.google.common.cache.x<K, V> xVar = this.f19730a;
                if (xVarK == xVar) {
                    xVar.l(xVar);
                    com.google.common.cache.x<K, V> xVar2 = this.f19730a;
                    xVar2.o(xVar2);
                    return;
                } else {
                    com.google.common.cache.x<K, V> xVarK2 = xVarK.k();
                    r.Q(xVarK);
                    xVarK = xVarK2;
                }
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            return ((com.google.common.cache.x) obj).k() != q.INSTANCE;
        }

        @Override // java.util.Queue
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public com.google.common.cache.x<K, V> poll() {
            com.google.common.cache.x<K, V> xVarK = this.f19730a.k();
            if (xVarK == this.f19730a) {
                return null;
            }
            remove(xVarK);
            return xVarK;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return this.f19730a.k() == this.f19730a;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<com.google.common.cache.x<K, V>> iterator() {
            return new b(peek());
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean remove(Object obj) {
            com.google.common.cache.x xVar = (com.google.common.cache.x) obj;
            com.google.common.cache.x<K, V> xVarD = xVar.d();
            com.google.common.cache.x<K, V> xVarK = xVar.k();
            r.f(xVarD, xVarK);
            r.Q(xVar);
            return xVarK != q.INSTANCE;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            int i7 = 0;
            for (com.google.common.cache.x<K, V> xVarK = this.f19730a.k(); xVarK != this.f19730a; xVarK = xVarK.k()) {
                i7++;
            }
            return i7;
        }
    }

    static class e0<K, V> extends WeakReference<K> implements com.google.common.cache.x<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final int f19735a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final com.google.common.cache.x<K, V> f19736b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        volatile a0<K, V> f19737c;

        e0(ReferenceQueue<K> referenceQueue, K k7, int i7, com.google.common.cache.x<K, V> xVar) {
            super(k7, referenceQueue);
            this.f19737c = r.h0();
            this.f19735a = i7;
            this.f19736b = xVar;
        }

        @Override // com.google.common.cache.x
        public com.google.common.cache.x<K, V> a() {
            return this.f19736b;
        }

        @Override // com.google.common.cache.x
        public a0<K, V> b() {
            return this.f19737c;
        }

        @Override // com.google.common.cache.x
        public int c() {
            return this.f19735a;
        }

        public com.google.common.cache.x<K, V> d() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.x
        public void e(a0<K, V> a0Var) {
            this.f19737c = a0Var;
        }

        public long f() {
            throw new UnsupportedOperationException();
        }

        public void g(long j7) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.x
        public K getKey() {
            return get();
        }

        public com.google.common.cache.x<K, V> h() {
            throw new UnsupportedOperationException();
        }

        public long i() {
            throw new UnsupportedOperationException();
        }

        public void j(long j7) {
            throw new UnsupportedOperationException();
        }

        public com.google.common.cache.x<K, V> k() {
            throw new UnsupportedOperationException();
        }

        public void l(com.google.common.cache.x<K, V> xVar) {
            throw new UnsupportedOperationException();
        }

        public void m(com.google.common.cache.x<K, V> xVar) {
            throw new UnsupportedOperationException();
        }

        public void n(com.google.common.cache.x<K, V> xVar) {
            throw new UnsupportedOperationException();
        }

        public void o(com.google.common.cache.x<K, V> xVar) {
            throw new UnsupportedOperationException();
        }

        public com.google.common.cache.x<K, V> p() {
            throw new UnsupportedOperationException();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    static abstract class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final f f19738a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final f f19739b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final f f19740c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final f f19741d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final f f19742e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final f f19743f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final f f19744g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final f f19745h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        static final int f19746i = 1;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        static final int f19747j = 2;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        static final int f19748k = 4;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        static final f[] f19749l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private static final /* synthetic */ f[] f19750m;

        static enum a extends f {
            a(String str, int i7) {
                super(str, i7, null);
            }

            @Override // com.google.common.cache.r.f
            <K, V> com.google.common.cache.x<K, V> e(C0233r<K, V> c0233r, K k7, int i7, com.google.common.cache.x<K, V> xVar) {
                return new w(k7, i7, xVar);
            }
        }

        static enum b extends f {
            b(String str, int i7) {
                super(str, i7, null);
            }

            @Override // com.google.common.cache.r.f
            <K, V> com.google.common.cache.x<K, V> b(C0233r<K, V> c0233r, com.google.common.cache.x<K, V> xVar, com.google.common.cache.x<K, V> xVar2) {
                com.google.common.cache.x<K, V> xVarB = super.b(c0233r, xVar, xVar2);
                a(xVar, xVarB);
                return xVarB;
            }

            @Override // com.google.common.cache.r.f
            <K, V> com.google.common.cache.x<K, V> e(C0233r<K, V> c0233r, K k7, int i7, com.google.common.cache.x<K, V> xVar) {
                return new u(k7, i7, xVar);
            }
        }

        static enum c extends f {
            c(String str, int i7) {
                super(str, i7, null);
            }

            @Override // com.google.common.cache.r.f
            <K, V> com.google.common.cache.x<K, V> b(C0233r<K, V> c0233r, com.google.common.cache.x<K, V> xVar, com.google.common.cache.x<K, V> xVar2) {
                com.google.common.cache.x<K, V> xVarB = super.b(c0233r, xVar, xVar2);
                c(xVar, xVarB);
                return xVarB;
            }

            @Override // com.google.common.cache.r.f
            <K, V> com.google.common.cache.x<K, V> e(C0233r<K, V> c0233r, K k7, int i7, com.google.common.cache.x<K, V> xVar) {
                return new y(k7, i7, xVar);
            }
        }

        static enum d extends f {
            d(String str, int i7) {
                super(str, i7, null);
            }

            @Override // com.google.common.cache.r.f
            <K, V> com.google.common.cache.x<K, V> b(C0233r<K, V> c0233r, com.google.common.cache.x<K, V> xVar, com.google.common.cache.x<K, V> xVar2) {
                com.google.common.cache.x<K, V> xVarB = super.b(c0233r, xVar, xVar2);
                a(xVar, xVarB);
                c(xVar, xVarB);
                return xVarB;
            }

            @Override // com.google.common.cache.r.f
            <K, V> com.google.common.cache.x<K, V> e(C0233r<K, V> c0233r, K k7, int i7, com.google.common.cache.x<K, V> xVar) {
                return new v(k7, i7, xVar);
            }
        }

        static enum e extends f {
            e(String str, int i7) {
                super(str, i7, null);
            }

            @Override // com.google.common.cache.r.f
            <K, V> com.google.common.cache.x<K, V> e(C0233r<K, V> c0233r, K k7, int i7, com.google.common.cache.x<K, V> xVar) {
                return new e0(c0233r.f19812h, k7, i7, xVar);
            }
        }

        /* JADX INFO: renamed from: com.google.common.cache.r$f$f, reason: collision with other inner class name */
        static enum C0232f extends f {
            C0232f(String str, int i7) {
                super(str, i7, null);
            }

            @Override // com.google.common.cache.r.f
            <K, V> com.google.common.cache.x<K, V> b(C0233r<K, V> c0233r, com.google.common.cache.x<K, V> xVar, com.google.common.cache.x<K, V> xVar2) {
                com.google.common.cache.x<K, V> xVarB = super.b(c0233r, xVar, xVar2);
                a(xVar, xVarB);
                return xVarB;
            }

            @Override // com.google.common.cache.r.f
            <K, V> com.google.common.cache.x<K, V> e(C0233r<K, V> c0233r, K k7, int i7, com.google.common.cache.x<K, V> xVar) {
                return new c0(c0233r.f19812h, k7, i7, xVar);
            }
        }

        static enum g extends f {
            g(String str, int i7) {
                super(str, i7, null);
            }

            @Override // com.google.common.cache.r.f
            <K, V> com.google.common.cache.x<K, V> b(C0233r<K, V> c0233r, com.google.common.cache.x<K, V> xVar, com.google.common.cache.x<K, V> xVar2) {
                com.google.common.cache.x<K, V> xVarB = super.b(c0233r, xVar, xVar2);
                c(xVar, xVarB);
                return xVarB;
            }

            @Override // com.google.common.cache.r.f
            <K, V> com.google.common.cache.x<K, V> e(C0233r<K, V> c0233r, K k7, int i7, com.google.common.cache.x<K, V> xVar) {
                return new g0(c0233r.f19812h, k7, i7, xVar);
            }
        }

        static enum h extends f {
            h(String str, int i7) {
                super(str, i7, null);
            }

            @Override // com.google.common.cache.r.f
            <K, V> com.google.common.cache.x<K, V> b(C0233r<K, V> c0233r, com.google.common.cache.x<K, V> xVar, com.google.common.cache.x<K, V> xVar2) {
                com.google.common.cache.x<K, V> xVarB = super.b(c0233r, xVar, xVar2);
                a(xVar, xVarB);
                c(xVar, xVarB);
                return xVarB;
            }

            @Override // com.google.common.cache.r.f
            <K, V> com.google.common.cache.x<K, V> e(C0233r<K, V> c0233r, K k7, int i7, com.google.common.cache.x<K, V> xVar) {
                return new d0(c0233r.f19812h, k7, i7, xVar);
            }
        }

        static {
            a aVar = new a("STRONG", 0);
            f19738a = aVar;
            b bVar = new b("STRONG_ACCESS", 1);
            f19739b = bVar;
            c cVar = new c("STRONG_WRITE", 2);
            f19740c = cVar;
            d dVar = new d("STRONG_ACCESS_WRITE", 3);
            f19741d = dVar;
            e eVar = new e("WEAK", 4);
            f19742e = eVar;
            C0232f c0232f = new C0232f("WEAK_ACCESS", 5);
            f19743f = c0232f;
            g gVar = new g("WEAK_WRITE", 6);
            f19744g = gVar;
            h hVar = new h("WEAK_ACCESS_WRITE", 7);
            f19745h = hVar;
            f19750m = new f[]{aVar, bVar, cVar, dVar, eVar, c0232f, gVar, hVar};
            f19749l = new f[]{aVar, bVar, cVar, dVar, eVar, c0232f, gVar, hVar};
        }

        private f(String str, int i7) {
            super(str, i7);
        }

        /* JADX WARN: Multi-variable type inference failed */
        static f d(t tVar, boolean z7, boolean z8) {
            return f19749l[((tVar == t.f19827c ? (char) 4 : (char) 0) | (z7 ? 1 : 0) ? 1 : 0) | (z8 ? 2 : 0)];
        }

        public static f valueOf(String str) {
            return (f) Enum.valueOf(f.class, str);
        }

        public static f[] values() {
            return (f[]) f19750m.clone();
        }

        <K, V> void a(com.google.common.cache.x<K, V> xVar, com.google.common.cache.x<K, V> xVar2) {
            xVar2.g(xVar.i());
            r.f(xVar.d(), xVar2);
            r.f(xVar2, xVar.k());
            r.Q(xVar);
        }

        <K, V> com.google.common.cache.x<K, V> b(C0233r<K, V> c0233r, com.google.common.cache.x<K, V> xVar, com.google.common.cache.x<K, V> xVar2) {
            return e(c0233r, xVar.getKey(), xVar.c(), xVar2);
        }

        <K, V> void c(com.google.common.cache.x<K, V> xVar, com.google.common.cache.x<K, V> xVar2) {
            xVar2.j(xVar.f());
            r.g(xVar.p(), xVar2);
            r.g(xVar2, xVar.h());
            r.R(xVar);
        }

        abstract <K, V> com.google.common.cache.x<K, V> e(C0233r<K, V> c0233r, K k7, int i7, com.google.common.cache.x<K, V> xVar);

        /* synthetic */ f(String str, int i7, a aVar) {
            this(str, i7);
        }
    }

    static class f0<K, V> extends WeakReference<V> implements a0<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final com.google.common.cache.x<K, V> f19751a;

        f0(ReferenceQueue<V> referenceQueue, V v7, com.google.common.cache.x<K, V> xVar) {
            super(v7, referenceQueue);
            this.f19751a = xVar;
        }

        @Override // com.google.common.cache.r.a0
        public com.google.common.cache.x<K, V> a() {
            return this.f19751a;
        }

        @Override // com.google.common.cache.r.a0
        public boolean b() {
            return true;
        }

        @Override // com.google.common.cache.r.a0
        public void c(V v7) {
        }

        @Override // com.google.common.cache.r.a0
        public int d() {
            return 1;
        }

        @Override // com.google.common.cache.r.a0
        public boolean e() {
            return false;
        }

        @Override // com.google.common.cache.r.a0
        public V f() {
            return get();
        }

        @Override // com.google.common.cache.r.a0
        public a0<K, V> g(ReferenceQueue<V> referenceQueue, V v7, com.google.common.cache.x<K, V> xVar) {
            return new f0(referenceQueue, v7, xVar);
        }
    }

    final class g extends r<K, V>.i<Map.Entry<K, V>> {
        g() {
            super();
        }

        @Override // com.google.common.cache.r.i, java.util.Iterator
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public Map.Entry<K, V> next() {
            return c();
        }
    }

    static final class g0<K, V> extends e0<K, V> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        volatile long f19753d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        com.google.common.cache.x<K, V> f19754e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        com.google.common.cache.x<K, V> f19755f;

        g0(ReferenceQueue<K> referenceQueue, K k7, int i7, com.google.common.cache.x<K, V> xVar) {
            super(referenceQueue, k7, i7, xVar);
            this.f19753d = Long.MAX_VALUE;
            this.f19754e = r.P();
            this.f19755f = r.P();
        }

        @Override // com.google.common.cache.r.e0, com.google.common.cache.x
        public long f() {
            return this.f19753d;
        }

        @Override // com.google.common.cache.r.e0, com.google.common.cache.x
        public com.google.common.cache.x<K, V> h() {
            return this.f19754e;
        }

        @Override // com.google.common.cache.r.e0, com.google.common.cache.x
        public void j(long j7) {
            this.f19753d = j7;
        }

        @Override // com.google.common.cache.r.e0, com.google.common.cache.x
        public void m(com.google.common.cache.x<K, V> xVar) {
            this.f19754e = xVar;
        }

        @Override // com.google.common.cache.r.e0, com.google.common.cache.x
        public void n(com.google.common.cache.x<K, V> xVar) {
            this.f19755f = xVar;
        }

        @Override // com.google.common.cache.r.e0, com.google.common.cache.x
        public com.google.common.cache.x<K, V> p() {
            return this.f19755f;
        }
    }

    final class h extends r<K, V>.c<Map.Entry<K, V>> {
        h(ConcurrentMap<?, ?> concurrentMap) {
            super(concurrentMap);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ boolean b(Predicate predicate, Object obj, Object obj2) {
            return predicate.test(wb.T(obj, obj2));
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            Map.Entry entry;
            Object key;
            Object obj2;
            return (obj instanceof Map.Entry) && (key = (entry = (Map.Entry) obj).getKey()) != null && (obj2 = r.this.get(key)) != null && r.this.f19700f.d(entry.getValue(), obj2);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return new g();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            Map.Entry entry;
            Object key;
            return (obj instanceof Map.Entry) && (key = (entry = (Map.Entry) obj).getKey()) != null && r.this.remove(key, entry.getValue());
        }

        @Override // java.util.Collection
        public boolean removeIf(final Predicate<? super Map.Entry<K, V>> predicate) {
            com.google.common.base.e0.E(predicate);
            return r.this.e0(new BiPredicate() { // from class: com.google.common.cache.s
                @Override // java.util.function.BiPredicate
                public final boolean test(Object obj, Object obj2) {
                    return r.h.b(predicate, obj, obj2);
                }
            });
        }
    }

    static final class h0<K, V> extends s<K, V> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final int f19757b;

        h0(ReferenceQueue<V> referenceQueue, V v7, com.google.common.cache.x<K, V> xVar, int i7) {
            super(referenceQueue, v7, xVar);
            this.f19757b = i7;
        }

        @Override // com.google.common.cache.r.s, com.google.common.cache.r.a0
        public int d() {
            return this.f19757b;
        }

        @Override // com.google.common.cache.r.s, com.google.common.cache.r.a0
        public a0<K, V> g(ReferenceQueue<V> referenceQueue, V v7, com.google.common.cache.x<K, V> xVar) {
            return new h0(referenceQueue, v7, xVar, this.f19757b);
        }
    }

    abstract class i<T> implements Iterator<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f19758a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f19759b = -1;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        C0233r<K, V> f19760c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        AtomicReferenceArray<com.google.common.cache.x<K, V>> f19761d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        com.google.common.cache.x<K, V> f19762e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        r<K, V>.l0 f19763f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        r<K, V>.l0 f19764g;

        i() {
            this.f19758a = r.this.f19697c.length - 1;
            a();
        }

        final void a() {
            this.f19763f = null;
            if (d() || e()) {
                return;
            }
            while (true) {
                int i7 = this.f19758a;
                if (i7 < 0) {
                    return;
                }
                C0233r<K, V>[] c0233rArr = r.this.f19697c;
                this.f19758a = i7 - 1;
                C0233r<K, V> c0233r = c0233rArr[i7];
                this.f19760c = c0233r;
                if (c0233r.f19806b != 0) {
                    AtomicReferenceArray<com.google.common.cache.x<K, V>> atomicReferenceArray = this.f19760c.f19810f;
                    this.f19761d = atomicReferenceArray;
                    this.f19759b = atomicReferenceArray.length() - 1;
                    if (e()) {
                        return;
                    }
                }
            }
        }

        boolean b(com.google.common.cache.x<K, V> xVar) {
            C0233r<K, V> c0233r;
            try {
                long jA = r.this.f19710p.a();
                K key = xVar.getKey();
                Object objZ = r.this.z(xVar, jA);
                if (objZ == null) {
                    return false;
                }
                this.f19763f = new l0(key, objZ);
                return true;
            } finally {
                this.f19760c.I();
            }
        }

        r<K, V>.l0 c() {
            r<K, V>.l0 l0Var = this.f19763f;
            if (l0Var == null) {
                throw new NoSuchElementException();
            }
            this.f19764g = l0Var;
            a();
            return this.f19764g;
        }

        boolean d() {
            com.google.common.cache.x<K, V> xVar = this.f19762e;
            if (xVar == null) {
                return false;
            }
            while (true) {
                this.f19762e = xVar.a();
                com.google.common.cache.x<K, V> xVar2 = this.f19762e;
                if (xVar2 == null) {
                    return false;
                }
                if (b(xVar2)) {
                    return true;
                }
                xVar = this.f19762e;
            }
        }

        boolean e() {
            while (true) {
                int i7 = this.f19759b;
                if (i7 < 0) {
                    return false;
                }
                AtomicReferenceArray<com.google.common.cache.x<K, V>> atomicReferenceArray = this.f19761d;
                this.f19759b = i7 - 1;
                com.google.common.cache.x<K, V> xVar = atomicReferenceArray.get(i7);
                this.f19762e = xVar;
                if (xVar != null && (b(xVar) || d())) {
                    return true;
                }
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f19763f != null;
        }

        @Override // java.util.Iterator
        public abstract T next();

        @Override // java.util.Iterator
        public void remove() {
            com.google.common.base.e0.g0(this.f19764g != null);
            r.this.remove(this.f19764g.getKey());
            this.f19764g = null;
        }
    }

    static final class i0<K, V> extends x<K, V> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final int f19766b;

        i0(V v7, int i7) {
            super(v7);
            this.f19766b = i7;
        }

        @Override // com.google.common.cache.r.x, com.google.common.cache.r.a0
        public int d() {
            return this.f19766b;
        }
    }

    final class j extends r<K, V>.i<K> {
        j() {
            super();
        }

        @Override // com.google.common.cache.r.i, java.util.Iterator
        public K next() {
            return c().getKey();
        }
    }

    static final class j0<K, V> extends f0<K, V> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final int f19768b;

        j0(ReferenceQueue<V> referenceQueue, V v7, com.google.common.cache.x<K, V> xVar, int i7) {
            super(referenceQueue, v7, xVar);
            this.f19768b = i7;
        }

        @Override // com.google.common.cache.r.f0, com.google.common.cache.r.a0
        public int d() {
            return this.f19768b;
        }

        @Override // com.google.common.cache.r.f0, com.google.common.cache.r.a0
        public a0<K, V> g(ReferenceQueue<V> referenceQueue, V v7, com.google.common.cache.x<K, V> xVar) {
            return new j0(referenceQueue, v7, xVar, this.f19768b);
        }
    }

    final class k extends r<K, V>.c<K> {
        k(ConcurrentMap<?, ?> concurrentMap) {
            super(concurrentMap);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return this.f19719a.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            return new j();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            return this.f19719a.remove(obj) != null;
        }
    }

    static final class k0<K, V> extends AbstractQueue<com.google.common.cache.x<K, V>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final com.google.common.cache.x<K, V> f19770a = new a();

        class a extends d<K, V> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            com.google.common.cache.x<K, V> f19771a = this;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            com.google.common.cache.x<K, V> f19772b = this;

            a() {
            }

            @Override // com.google.common.cache.r.d, com.google.common.cache.x
            public long f() {
                return Long.MAX_VALUE;
            }

            @Override // com.google.common.cache.r.d, com.google.common.cache.x
            public com.google.common.cache.x<K, V> h() {
                return this.f19771a;
            }

            @Override // com.google.common.cache.r.d, com.google.common.cache.x
            public void j(long j7) {
            }

            @Override // com.google.common.cache.r.d, com.google.common.cache.x
            public void m(com.google.common.cache.x<K, V> xVar) {
                this.f19771a = xVar;
            }

            @Override // com.google.common.cache.r.d, com.google.common.cache.x
            public void n(com.google.common.cache.x<K, V> xVar) {
                this.f19772b = xVar;
            }

            @Override // com.google.common.cache.r.d, com.google.common.cache.x
            public com.google.common.cache.x<K, V> p() {
                return this.f19772b;
            }
        }

        class b extends com.google.common.collect.b0<com.google.common.cache.x<K, V>> {
            b(com.google.common.cache.x xVar) {
                super(xVar);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.common.collect.b0
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public com.google.common.cache.x<K, V> a(com.google.common.cache.x<K, V> xVar) {
                com.google.common.cache.x<K, V> xVarH = xVar.h();
                if (xVarH == k0.this.f19770a) {
                    return null;
                }
                return xVarH;
            }
        }

        k0() {
        }

        @Override // java.util.Queue
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean offer(com.google.common.cache.x<K, V> xVar) {
            r.g(xVar.p(), xVar.h());
            r.g(this.f19770a.p(), xVar);
            r.g(xVar, this.f19770a);
            return true;
        }

        @Override // java.util.Queue
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public com.google.common.cache.x<K, V> peek() {
            com.google.common.cache.x<K, V> xVarH = this.f19770a.h();
            if (xVarH == this.f19770a) {
                return null;
            }
            return xVarH;
        }

        @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection
        public void clear() {
            com.google.common.cache.x<K, V> xVarH = this.f19770a.h();
            while (true) {
                com.google.common.cache.x<K, V> xVar = this.f19770a;
                if (xVarH == xVar) {
                    xVar.m(xVar);
                    com.google.common.cache.x<K, V> xVar2 = this.f19770a;
                    xVar2.n(xVar2);
                    return;
                } else {
                    com.google.common.cache.x<K, V> xVarH2 = xVarH.h();
                    r.R(xVarH);
                    xVarH = xVarH2;
                }
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            return ((com.google.common.cache.x) obj).h() != q.INSTANCE;
        }

        @Override // java.util.Queue
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public com.google.common.cache.x<K, V> poll() {
            com.google.common.cache.x<K, V> xVarH = this.f19770a.h();
            if (xVarH == this.f19770a) {
                return null;
            }
            remove(xVarH);
            return xVarH;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return this.f19770a.h() == this.f19770a;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<com.google.common.cache.x<K, V>> iterator() {
            return new b(peek());
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean remove(Object obj) {
            com.google.common.cache.x xVar = (com.google.common.cache.x) obj;
            com.google.common.cache.x<K, V> xVarP = xVar.p();
            com.google.common.cache.x<K, V> xVarH = xVar.h();
            r.g(xVarP, xVarH);
            r.R(xVar);
            return xVarH != q.INSTANCE;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            int i7 = 0;
            for (com.google.common.cache.x<K, V> xVarH = this.f19770a.h(); xVarH != this.f19770a; xVarH = xVarH.h()) {
                i7++;
            }
            return i7;
        }
    }

    static final class l<K, V> extends p<K, V> implements com.google.common.cache.k<K, V>, Serializable {

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        private static final long f19775p = 1;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        transient com.google.common.cache.k<K, V> f19776o;

        l(r<K, V> rVar) {
            super(rVar);
        }

        private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
            objectInputStream.defaultReadObject();
            this.f19776o = (com.google.common.cache.k<K, V>) e0().b(this.f19801l);
        }

        private Object readResolve() {
            return this.f19776o;
        }

        @Override // com.google.common.cache.k
        public v7<K, V> K(Iterable<? extends K> iterable) throws ExecutionException {
            return this.f19776o.K(iterable);
        }

        @Override // com.google.common.cache.k
        public void N(K k7) {
            this.f19776o.N(k7);
        }

        @Override // com.google.common.cache.k, com.google.common.base.s, java.util.function.Function
        public final V apply(K k7) {
            return this.f19776o.apply(k7);
        }

        @Override // com.google.common.cache.k
        public V get(K k7) throws ExecutionException {
            return this.f19776o.get(k7);
        }

        @Override // com.google.common.cache.k
        public V o(K k7) {
            return this.f19776o.o(k7);
        }
    }

    final class l0 implements Map.Entry<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final K f19777a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        V f19778b;

        l0(K k7, V v7) {
            this.f19777a = k7;
            this.f19778b = v7;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            return this.f19777a.equals(entry.getKey()) && this.f19778b.equals(entry.getValue());
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.f19777a;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.f19778b;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            return this.f19777a.hashCode() ^ this.f19778b.hashCode();
        }

        @Override // java.util.Map.Entry
        public V setValue(V v7) {
            V v8 = (V) r.this.put(this.f19777a, v7);
            this.f19778b = v7;
            return v8;
        }

        public String toString() {
            return getKey() + "=" + getValue();
        }
    }

    static class m<K, V> implements a0<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        volatile a0<K, V> f19780a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final d2<V> f19781b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final n0 f19782c;

        class a implements com.google.common.base.s<V, V> {
            a() {
            }

            @Override // com.google.common.base.s, java.util.function.Function
            public V apply(V v7) {
                m.this.m(v7);
                return v7;
            }
        }

        public m() {
            this(null);
        }

        private l1<V> j(Throwable th) {
            return e1.m(th);
        }

        @Override // com.google.common.cache.r.a0
        public com.google.common.cache.x<K, V> a() {
            return null;
        }

        @Override // com.google.common.cache.r.a0
        public boolean b() {
            return this.f19780a.b();
        }

        @Override // com.google.common.cache.r.a0
        public void c(V v7) {
            if (v7 != null) {
                m(v7);
            } else {
                this.f19780a = r.h0();
            }
        }

        @Override // com.google.common.cache.r.a0
        public int d() {
            return this.f19780a.d();
        }

        @Override // com.google.common.cache.r.a0
        public boolean e() {
            return true;
        }

        @Override // com.google.common.cache.r.a0
        public V f() throws ExecutionException {
            return (V) p2.d(this.f19781b);
        }

        @Override // com.google.common.cache.r.a0
        public a0<K, V> g(ReferenceQueue<V> referenceQueue, V v7, com.google.common.cache.x<K, V> xVar) {
            return this;
        }

        @Override // com.google.common.cache.r.a0
        public V get() {
            return this.f19780a.get();
        }

        public V h(K k7, BiFunction<? super K, ? super V, ? extends V> biFunction) {
            V vF;
            this.f19782c.l();
            try {
                vF = this.f19780a.f();
            } catch (ExecutionException unused) {
                vF = null;
            }
            try {
                V v7 = (V) biFunction.apply(k7, vF);
                m(v7);
                return v7;
            } catch (Throwable th) {
                n(th);
                throw th;
            }
        }

        public long i() {
            return this.f19782c.g(TimeUnit.NANOSECONDS);
        }

        public a0<K, V> k() {
            return this.f19780a;
        }

        public l1<V> l(K k7, com.google.common.cache.g<? super K, V> gVar) {
            try {
                this.f19782c.l();
                V v7 = this.f19780a.get();
                if (v7 == null) {
                    V vD = gVar.d(k7);
                    return m(vD) ? this.f19781b : e1.n(vD);
                }
                l1<V> l1VarF = gVar.f(k7, v7);
                return l1VarF == null ? e1.n(null) : e1.w(l1VarF, new a(), v1.c());
            } catch (Throwable th) {
                l1<V> l1VarJ = n(th) ? this.f19781b : j(th);
                if (th instanceof InterruptedException) {
                    Thread.currentThread().interrupt();
                }
                return l1VarJ;
            }
        }

        public boolean m(V v7) {
            return this.f19781b.A(v7);
        }

        public boolean n(Throwable th) {
            return this.f19781b.B(th);
        }

        public m(a0<K, V> a0Var) {
            this.f19781b = d2.F();
            this.f19782c = n0.e();
            this.f19780a = a0Var == null ? r.h0() : a0Var;
        }
    }

    static class n<K, V> extends o<K, V> implements com.google.common.cache.k<K, V> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final long f19784c = 1;

        n(com.google.common.cache.e<? super K, ? super V> eVar, com.google.common.cache.g<? super K, V> gVar) {
            super(new r(eVar, (com.google.common.cache.g) com.google.common.base.e0.E(gVar)), null);
        }

        @Override // com.google.common.cache.k
        public v7<K, V> K(Iterable<? extends K> iterable) throws ExecutionException {
            return this.f19786a.t(iterable);
        }

        @Override // com.google.common.cache.k
        public void N(K k7) {
            this.f19786a.b0(k7);
        }

        @Override // com.google.common.cache.k, com.google.common.base.s, java.util.function.Function
        public final V apply(K k7) {
            return o(k7);
        }

        @Override // com.google.common.cache.k
        public V get(K k7) throws ExecutionException {
            return this.f19786a.B(k7);
        }

        @Override // com.google.common.cache.k
        public V o(K k7) {
            try {
                return get(k7);
            } catch (ExecutionException e8) {
                throw new n2(e8.getCause());
            }
        }

        @Override // com.google.common.cache.r.o
        Object writeReplace() {
            return new l(this.f19786a);
        }
    }

    static class o<K, V> implements com.google.common.cache.c<K, V>, Serializable {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final long f19785b = 1;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final r<K, V> f19786a;

        class a extends com.google.common.cache.g<Object, V> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ Callable f19787a;

            a(Callable callable) {
                this.f19787a = callable;
            }

            @Override // com.google.common.cache.g
            public V d(Object obj) throws Exception {
                return (V) this.f19787a.call();
            }
        }

        /* synthetic */ o(r rVar, a aVar) {
            this(rVar);
        }

        @Override // com.google.common.cache.c
        public void B(Iterable<?> iterable) {
            this.f19786a.D(iterable);
        }

        @Override // com.google.common.cache.c
        public v7<K, V> Y(Iterable<?> iterable) {
            return this.f19786a.u(iterable);
        }

        @Override // com.google.common.cache.c
        public void Z(Object obj) {
            com.google.common.base.e0.E(obj);
            this.f19786a.remove(obj);
        }

        @Override // com.google.common.cache.c
        public com.google.common.cache.h a0() {
            com.google.common.cache.a.C0227a c0227a = new com.google.common.cache.a.C0227a();
            c0227a.g(this.f19786a.f19712r);
            for (C0233r<K, V> c0233r : this.f19786a.f19697c) {
                c0227a.g(c0233r.f19818n);
            }
            return c0227a.f();
        }

        @Override // com.google.common.cache.c
        public ConcurrentMap<K, V> asMap() {
            return this.f19786a;
        }

        @Override // com.google.common.cache.c
        public void b0() {
            this.f19786a.clear();
        }

        @Override // com.google.common.cache.c
        public void l() {
            this.f19786a.e();
        }

        @Override // com.google.common.cache.c
        public void put(K k7, V v7) {
            this.f19786a.put(k7, v7);
        }

        @Override // com.google.common.cache.c
        public void putAll(Map<? extends K, ? extends V> map) {
            this.f19786a.putAll(map);
        }

        @Override // com.google.common.cache.c
        public long size() {
            return this.f19786a.L();
        }

        @Override // com.google.common.cache.c
        public V u(Object obj) {
            return this.f19786a.y(obj);
        }

        Object writeReplace() {
            return new p(this.f19786a);
        }

        @Override // com.google.common.cache.c
        public V z(K k7, Callable<? extends V> callable) throws ExecutionException {
            com.google.common.base.e0.E(callable);
            return this.f19786a.s(k7, new a(callable));
        }

        o(com.google.common.cache.e<? super K, ? super V> eVar) {
            this(new r(eVar, null));
        }

        private o(r<K, V> rVar) {
            this.f19786a = rVar;
        }
    }

    static class p<K, V> extends com.google.common.cache.i<K, V> implements Serializable {

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private static final long f19789n = 1;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final t f19790a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final t f19791b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final com.google.common.base.l<Object> f19792c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final com.google.common.base.l<Object> f19793d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final long f19794e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final long f19795f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final long f19796g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final com.google.common.cache.d0<K, V> f19797h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final int f19798i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final com.google.common.cache.z<? super K, ? super V> f19799j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        final s0 f19800k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        final com.google.common.cache.g<? super K, V> f19801l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        transient com.google.common.cache.c<K, V> f19802m;

        p(r<K, V> rVar) {
            this(rVar.f19701g, rVar.f19702h, rVar.f19699e, rVar.f19700f, rVar.f19706l, rVar.f19705k, rVar.f19703i, rVar.f19704j, rVar.f19698d, rVar.f19709o, rVar.f19710p, rVar.f19713s);
        }

        private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
            objectInputStream.defaultReadObject();
            this.f19802m = (com.google.common.cache.c<K, V>) e0().a();
        }

        private Object readResolve() {
            return this.f19802m;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.cache.i, com.google.common.collect.b6
        /* JADX INFO: renamed from: d0 */
        public com.google.common.cache.c<K, V> c0() {
            return this.f19802m;
        }

        com.google.common.cache.e<K, V> e0() {
            com.google.common.cache.e<K, V> eVar = (com.google.common.cache.e<K, V>) com.google.common.cache.e.F().K(this.f19790a).L(this.f19791b).B(this.f19792c).O(this.f19793d).e(this.f19798i).J(this.f19799j);
            eVar.f19629a = false;
            long j7 = this.f19794e;
            if (j7 > 0) {
                eVar.h(j7, TimeUnit.NANOSECONDS);
            }
            long j8 = this.f19795f;
            if (j8 > 0) {
                eVar.f(j8, TimeUnit.NANOSECONDS);
            }
            com.google.common.cache.d0 d0Var = this.f19797h;
            if (d0Var != com.google.common.cache.e.EnumC0229e.INSTANCE) {
                eVar.R(d0Var);
                long j9 = this.f19796g;
                if (j9 != -1) {
                    eVar.E(j9);
                }
            } else {
                long j10 = this.f19796g;
                if (j10 != -1) {
                    eVar.D(j10);
                }
            }
            s0 s0Var = this.f19800k;
            if (s0Var != null) {
                eVar.N(s0Var);
            }
            return eVar;
        }

        private p(t tVar, t tVar2, com.google.common.base.l<Object> lVar, com.google.common.base.l<Object> lVar2, long j7, long j8, long j9, com.google.common.cache.d0<K, V> d0Var, int i7, com.google.common.cache.z<? super K, ? super V> zVar, s0 s0Var, com.google.common.cache.g<? super K, V> gVar) {
            this.f19790a = tVar;
            this.f19791b = tVar2;
            this.f19792c = lVar;
            this.f19793d = lVar2;
            this.f19794e = j7;
            this.f19795f = j8;
            this.f19796g = j9;
            this.f19797h = d0Var;
            this.f19798i = i7;
            this.f19799j = zVar;
            this.f19800k = (s0Var == s0.b() || s0Var == com.google.common.cache.e.f19626x) ? null : s0Var;
            this.f19801l = gVar;
        }
    }

    private enum q implements com.google.common.cache.x<Object, Object> {
        INSTANCE;

        @Override // com.google.common.cache.x
        public com.google.common.cache.x<Object, Object> a() {
            return null;
        }

        @Override // com.google.common.cache.x
        public a0<Object, Object> b() {
            return null;
        }

        @Override // com.google.common.cache.x
        public int c() {
            return 0;
        }

        @Override // com.google.common.cache.x
        public com.google.common.cache.x<Object, Object> d() {
            return this;
        }

        @Override // com.google.common.cache.x
        public void e(a0<Object, Object> a0Var) {
        }

        @Override // com.google.common.cache.x
        public long f() {
            return 0L;
        }

        @Override // com.google.common.cache.x
        public void g(long j7) {
        }

        @Override // com.google.common.cache.x
        public Object getKey() {
            return null;
        }

        @Override // com.google.common.cache.x
        public com.google.common.cache.x<Object, Object> h() {
            return this;
        }

        @Override // com.google.common.cache.x
        public long i() {
            return 0L;
        }

        @Override // com.google.common.cache.x
        public void j(long j7) {
        }

        @Override // com.google.common.cache.x
        public com.google.common.cache.x<Object, Object> k() {
            return this;
        }

        @Override // com.google.common.cache.x
        public void l(com.google.common.cache.x<Object, Object> xVar) {
        }

        @Override // com.google.common.cache.x
        public void m(com.google.common.cache.x<Object, Object> xVar) {
        }

        @Override // com.google.common.cache.x
        public void n(com.google.common.cache.x<Object, Object> xVar) {
        }

        @Override // com.google.common.cache.x
        public void o(com.google.common.cache.x<Object, Object> xVar) {
        }

        @Override // com.google.common.cache.x
        public com.google.common.cache.x<Object, Object> p() {
            return this;
        }
    }

    /* JADX INFO: renamed from: com.google.common.cache.r$r, reason: collision with other inner class name */
    static class C0233r<K, V> extends ReentrantLock {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @y1.i
        final r<K, V> f19805a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        volatile int f19806b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @v1.a("this")
        long f19807c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f19808d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f19809e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        volatile AtomicReferenceArray<com.google.common.cache.x<K, V>> f19810f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final long f19811g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final ReferenceQueue<K> f19812h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final ReferenceQueue<V> f19813i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final Queue<com.google.common.cache.x<K, V>> f19814j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        final AtomicInteger f19815k = new AtomicInteger();

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        @v1.a("this")
        final Queue<com.google.common.cache.x<K, V>> f19816l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        @v1.a("this")
        final Queue<com.google.common.cache.x<K, V>> f19817m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        final com.google.common.cache.a.b f19818n;

        /* JADX INFO: renamed from: com.google.common.cache.r$r$a */
        class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ Object f19819a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ int f19820b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ m f19821c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            final /* synthetic */ l1 f19822d;

            a(Object obj, int i7, m mVar, l1 l1Var) {
                this.f19819a = obj;
                this.f19820b = i7;
                this.f19821c = mVar;
                this.f19822d = l1Var;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference fix 'apply assigned field type' failed
            java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
            	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
            	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
            	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
             */
            @Override // java.lang.Runnable
            public void run() {
                try {
                    C0233r.this.u(this.f19819a, this.f19820b, this.f19821c, this.f19822d);
                } catch (Throwable th) {
                    r.B.log(Level.WARNING, "Exception thrown during refresh", th);
                    this.f19821c.n(th);
                }
            }
        }

        C0233r(r<K, V> rVar, int i7, long j7, com.google.common.cache.a.b bVar) {
            this.f19805a = rVar;
            this.f19811g = j7;
            this.f19818n = (com.google.common.cache.a.b) com.google.common.base.e0.E(bVar);
            A(H(i7));
            this.f19812h = rVar.k0() ? new ReferenceQueue<>() : null;
            this.f19813i = rVar.l0() ? new ReferenceQueue<>() : null;
            this.f19814j = rVar.j0() ? new ConcurrentLinkedQueue<>() : r.m();
            this.f19816l = rVar.n0() ? new k0<>() : r.m();
            this.f19817m = rVar.j0() ? new e<>() : r.m();
        }

        void A(AtomicReferenceArray<com.google.common.cache.x<K, V>> atomicReferenceArray) {
            this.f19809e = (atomicReferenceArray.length() * 3) / 4;
            if (!this.f19805a.l()) {
                int i7 = this.f19809e;
                if (i7 == this.f19811g) {
                    this.f19809e = i7 + 1;
                }
            }
            this.f19810f = atomicReferenceArray;
        }

        m<K, V> B(K k7, int i7, boolean z7) {
            lock();
            try {
                long jA = this.f19805a.f19710p.a();
                K(jA);
                AtomicReferenceArray<com.google.common.cache.x<K, V>> atomicReferenceArray = this.f19810f;
                int length = (atomicReferenceArray.length() - 1) & i7;
                com.google.common.cache.x<K, V> xVar = (com.google.common.cache.x) atomicReferenceArray.get(length);
                for (com.google.common.cache.x xVarA = xVar; xVarA != null; xVarA = xVarA.a()) {
                    Object key = xVarA.getKey();
                    if (xVarA.c() == i7 && key != null && this.f19805a.f19699e.d(k7, key)) {
                        a0<K, V> a0VarB = xVarA.b();
                        if (!a0VarB.e() && (!z7 || jA - xVarA.f() >= this.f19805a.f19707m)) {
                            this.f19808d++;
                            m<K, V> mVar = new m<>(a0VarB);
                            xVarA.e(mVar);
                            return mVar;
                        }
                        return null;
                    }
                }
                this.f19808d++;
                m<K, V> mVar2 = new m<>();
                com.google.common.cache.x<K, V> xVarF = F(k7, i7, xVar);
                xVarF.e(mVar2);
                atomicReferenceArray.set(length, xVarF);
                return mVar2;
            } finally {
                unlock();
                J();
            }
        }

        l1<V> C(K k7, int i7, m<K, V> mVar, com.google.common.cache.g<? super K, V> gVar) {
            l1<V> l1VarL = mVar.l(k7, gVar);
            l1VarL.I(new a(k7, i7, mVar, l1VarL), v1.c());
            return l1VarL;
        }

        V D(K k7, int i7, m<K, V> mVar, com.google.common.cache.g<? super K, V> gVar) throws ExecutionException {
            return u(k7, i7, mVar, mVar.l(k7, gVar));
        }

        V E(K k7, int i7, com.google.common.cache.g<? super K, V> gVar) throws ExecutionException {
            m<K, V> mVar;
            boolean z7;
            a0<K, V> a0Var;
            V vD;
            lock();
            try {
                long jA = this.f19805a.f19710p.a();
                K(jA);
                int i8 = this.f19806b - 1;
                AtomicReferenceArray<com.google.common.cache.x<K, V>> atomicReferenceArray = this.f19810f;
                int length = i7 & (atomicReferenceArray.length() - 1);
                com.google.common.cache.x<K, V> xVar = atomicReferenceArray.get(length);
                com.google.common.cache.x<K, V> xVarF = xVar;
                while (true) {
                    mVar = null;
                    if (xVarF == null) {
                        z7 = true;
                        a0Var = null;
                        break;
                    }
                    K key = xVarF.getKey();
                    if (xVarF.c() == i7 && key != null && this.f19805a.f19699e.d(k7, key)) {
                        a0<K, V> a0VarB = xVarF.b();
                        if (a0VarB.e()) {
                            z7 = false;
                        } else {
                            V v7 = a0VarB.get();
                            if (v7 == null) {
                                n(key, i7, v7, a0VarB.d(), com.google.common.cache.y.f19853c);
                            } else {
                                if (!this.f19805a.E(xVarF, jA)) {
                                    O(xVarF, jA);
                                    this.f19818n.b(1);
                                    unlock();
                                    J();
                                    return v7;
                                }
                                n(key, i7, v7, a0VarB.d(), com.google.common.cache.y.f19854d);
                            }
                            this.f19816l.remove(xVarF);
                            this.f19817m.remove(xVarF);
                            this.f19806b = i8;
                            z7 = true;
                        }
                        a0Var = a0VarB;
                        break;
                    }
                    xVarF = xVarF.a();
                }
                if (z7) {
                    mVar = new m<>();
                    if (xVarF == null) {
                        xVarF = F(k7, i7, xVar);
                        xVarF.e(mVar);
                        atomicReferenceArray.set(length, xVarF);
                    } else {
                        xVarF.e(mVar);
                    }
                }
                unlock();
                J();
                if (!z7) {
                    return j0(xVarF, k7, a0Var);
                }
                try {
                    synchronized (xVarF) {
                        vD = D(k7, i7, mVar, gVar);
                    }
                    this.f19818n.c(1);
                    return vD;
                } catch (Throwable th) {
                    this.f19818n.c(1);
                    throw th;
                }
            } catch (Throwable th2) {
                unlock();
                J();
                throw th2;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @v1.a("this")
        com.google.common.cache.x<K, V> F(K k7, int i7, com.google.common.cache.x<K, V> xVar) {
            return this.f19805a.f19711q.e(this, com.google.common.base.e0.E(k7), i7, xVar);
        }

        AtomicReferenceArray<com.google.common.cache.x<K, V>> H(int i7) {
            return new AtomicReferenceArray<>(i7);
        }

        void I() {
            if ((this.f19815k.incrementAndGet() & 63) == 0) {
                a();
            }
        }

        void J() {
            d0();
        }

        @v1.a("this")
        void K(long j7) {
            c0(j7);
        }

        V L(K k7, int i7, V v7, boolean z7) {
            int i8;
            lock();
            try {
                long jA = this.f19805a.f19710p.a();
                K(jA);
                if (this.f19806b + 1 > this.f19809e) {
                    p();
                }
                AtomicReferenceArray<com.google.common.cache.x<K, V>> atomicReferenceArray = this.f19810f;
                int length = i7 & (atomicReferenceArray.length() - 1);
                com.google.common.cache.x<K, V> xVar = atomicReferenceArray.get(length);
                for (com.google.common.cache.x<K, V> xVarA = xVar; xVarA != null; xVarA = xVarA.a()) {
                    K key = xVarA.getKey();
                    if (xVarA.c() == i7 && key != null && this.f19805a.f19699e.d(k7, key)) {
                        a0<K, V> a0VarB = xVarA.b();
                        V v8 = a0VarB.get();
                        if (v8 != null) {
                            if (z7) {
                                O(xVarA, jA);
                            } else {
                                this.f19808d++;
                                n(k7, i7, v8, a0VarB.d(), com.google.common.cache.y.f19852b);
                                f0(xVarA, k7, v7, jA);
                                o(xVarA);
                            }
                            return v8;
                        }
                        this.f19808d++;
                        if (a0VarB.b()) {
                            n(k7, i7, v8, a0VarB.d(), com.google.common.cache.y.f19853c);
                            f0(xVarA, k7, v7, jA);
                            i8 = this.f19806b;
                        } else {
                            f0(xVarA, k7, v7, jA);
                            i8 = this.f19806b + 1;
                        }
                        this.f19806b = i8;
                        o(xVarA);
                        return null;
                    }
                }
                this.f19808d++;
                com.google.common.cache.x<K, V> xVarF = F(k7, i7, xVar);
                f0(xVarF, k7, v7, jA);
                atomicReferenceArray.set(length, xVarF);
                this.f19806b++;
                o(xVarF);
                return null;
            } finally {
                unlock();
                J();
            }
        }

        boolean M(com.google.common.cache.x<K, V> xVar, int i7) {
            lock();
            try {
                AtomicReferenceArray<com.google.common.cache.x<K, V>> atomicReferenceArray = this.f19810f;
                int length = (atomicReferenceArray.length() - 1) & i7;
                com.google.common.cache.x<K, V> xVar2 = atomicReferenceArray.get(length);
                for (com.google.common.cache.x<K, V> xVarA = xVar2; xVarA != null; xVarA = xVarA.a()) {
                    if (xVarA == xVar) {
                        this.f19808d++;
                        com.google.common.cache.x<K, V> xVarZ = Z(xVar2, xVarA, xVarA.getKey(), i7, xVarA.b().get(), xVarA.b(), com.google.common.cache.y.f19853c);
                        int i8 = this.f19806b - 1;
                        atomicReferenceArray.set(length, xVarZ);
                        this.f19806b = i8;
                        return true;
                    }
                }
                return false;
            } finally {
                unlock();
                J();
            }
        }

        boolean N(K k7, int i7, a0<K, V> a0Var) {
            lock();
            try {
                AtomicReferenceArray<com.google.common.cache.x<K, V>> atomicReferenceArray = this.f19810f;
                int length = (atomicReferenceArray.length() - 1) & i7;
                com.google.common.cache.x<K, V> xVar = atomicReferenceArray.get(length);
                for (com.google.common.cache.x<K, V> xVarA = xVar; xVarA != null; xVarA = xVarA.a()) {
                    K key = xVarA.getKey();
                    if (xVarA.c() == i7 && key != null && this.f19805a.f19699e.d(k7, key)) {
                        if (xVarA.b() != a0Var) {
                            return false;
                        }
                        this.f19808d++;
                        com.google.common.cache.x<K, V> xVarZ = Z(xVar, xVarA, key, i7, a0Var.get(), a0Var, com.google.common.cache.y.f19853c);
                        int i8 = this.f19806b - 1;
                        atomicReferenceArray.set(length, xVarZ);
                        this.f19806b = i8;
                        return true;
                    }
                }
                return false;
            } finally {
                unlock();
                if (!isHeldByCurrentThread()) {
                    J();
                }
            }
        }

        @v1.a("this")
        void O(com.google.common.cache.x<K, V> xVar, long j7) {
            if (this.f19805a.Y()) {
                xVar.g(j7);
            }
            this.f19817m.add(xVar);
        }

        void P(com.google.common.cache.x<K, V> xVar, long j7) {
            if (this.f19805a.Y()) {
                xVar.g(j7);
            }
            this.f19814j.add(xVar);
        }

        @v1.a("this")
        void R(com.google.common.cache.x<K, V> xVar, int i7, long j7) {
            k();
            this.f19807c += (long) i7;
            if (this.f19805a.Y()) {
                xVar.g(j7);
            }
            if (this.f19805a.a0()) {
                xVar.j(j7);
            }
            this.f19817m.add(xVar);
            this.f19816l.add(xVar);
        }

        V S(K k7, int i7, com.google.common.cache.g<? super K, V> gVar, boolean z7) {
            m<K, V> mVarB = B(k7, i7, z7);
            if (mVarB == null) {
                return null;
            }
            l1<V> l1VarC = C(k7, i7, mVarB, gVar);
            if (l1VarC.isDone()) {
                try {
                    return (V) p2.d(l1VarC);
                } catch (Throwable unused) {
                }
            }
            return null;
        }

        V T(Object obj, int i7) {
            com.google.common.cache.y yVar;
            lock();
            try {
                K(this.f19805a.f19710p.a());
                AtomicReferenceArray<com.google.common.cache.x<K, V>> atomicReferenceArray = this.f19810f;
                int length = (atomicReferenceArray.length() - 1) & i7;
                com.google.common.cache.x<K, V> xVar = atomicReferenceArray.get(length);
                for (com.google.common.cache.x<K, V> xVarA = xVar; xVarA != null; xVarA = xVarA.a()) {
                    K key = xVarA.getKey();
                    if (xVarA.c() == i7 && key != null && this.f19805a.f19699e.d(obj, key)) {
                        a0<K, V> a0VarB = xVarA.b();
                        V v7 = a0VarB.get();
                        if (v7 == null) {
                            if (!a0VarB.b()) {
                                break;
                            }
                            yVar = com.google.common.cache.y.f19853c;
                        } else {
                            yVar = com.google.common.cache.y.f19851a;
                        }
                        com.google.common.cache.y yVar2 = yVar;
                        this.f19808d++;
                        com.google.common.cache.x<K, V> xVarZ = Z(xVar, xVarA, key, i7, v7, a0VarB, yVar2);
                        int i8 = this.f19806b - 1;
                        atomicReferenceArray.set(length, xVarZ);
                        this.f19806b = i8;
                        return v7;
                    }
                }
                return null;
            } finally {
                unlock();
                J();
            }
        }

        boolean U(Object obj, int i7, Object obj2) {
            com.google.common.cache.y yVar;
            lock();
            try {
                K(this.f19805a.f19710p.a());
                AtomicReferenceArray<com.google.common.cache.x<K, V>> atomicReferenceArray = this.f19810f;
                int length = (atomicReferenceArray.length() - 1) & i7;
                com.google.common.cache.x<K, V> xVar = atomicReferenceArray.get(length);
                for (com.google.common.cache.x<K, V> xVarA = xVar; xVarA != null; xVarA = xVarA.a()) {
                    K key = xVarA.getKey();
                    if (xVarA.c() == i7 && key != null && this.f19805a.f19699e.d(obj, key)) {
                        a0<K, V> a0VarB = xVarA.b();
                        V v7 = a0VarB.get();
                        if (!this.f19805a.f19700f.d(obj2, v7)) {
                            if (v7 != null || !a0VarB.b()) {
                                break;
                                break;
                            }
                            yVar = com.google.common.cache.y.f19853c;
                        } else {
                            yVar = com.google.common.cache.y.f19851a;
                        }
                        this.f19808d++;
                        com.google.common.cache.x<K, V> xVarZ = Z(xVar, xVarA, key, i7, v7, a0VarB, yVar);
                        int i8 = this.f19806b - 1;
                        atomicReferenceArray.set(length, xVarZ);
                        this.f19806b = i8;
                        return yVar == com.google.common.cache.y.f19851a;
                    }
                }
                return false;
            } finally {
                unlock();
                J();
            }
        }

        @v1.a("this")
        void V(com.google.common.cache.x<K, V> xVar) {
            n(xVar.getKey(), xVar.c(), xVar.b().get(), xVar.b().d(), com.google.common.cache.y.f19853c);
            this.f19816l.remove(xVar);
            this.f19817m.remove(xVar);
        }

        @v1.a("this")
        @s1.d
        boolean W(com.google.common.cache.x<K, V> xVar, int i7, com.google.common.cache.y yVar) {
            AtomicReferenceArray<com.google.common.cache.x<K, V>> atomicReferenceArray = this.f19810f;
            int length = (atomicReferenceArray.length() - 1) & i7;
            com.google.common.cache.x<K, V> xVar2 = atomicReferenceArray.get(length);
            for (com.google.common.cache.x<K, V> xVarA = xVar2; xVarA != null; xVarA = xVarA.a()) {
                if (xVarA == xVar) {
                    this.f19808d++;
                    com.google.common.cache.x<K, V> xVarZ = Z(xVar2, xVarA, xVarA.getKey(), i7, xVarA.b().get(), xVarA.b(), yVar);
                    int i8 = this.f19806b - 1;
                    atomicReferenceArray.set(length, xVarZ);
                    this.f19806b = i8;
                    return true;
                }
            }
            return false;
        }

        @v1.a("this")
        com.google.common.cache.x<K, V> X(com.google.common.cache.x<K, V> xVar, com.google.common.cache.x<K, V> xVar2) {
            int i7 = this.f19806b;
            com.google.common.cache.x<K, V> xVarA = xVar2.a();
            while (xVar != xVar2) {
                com.google.common.cache.x<K, V> xVarI = i(xVar, xVarA);
                if (xVarI != null) {
                    xVarA = xVarI;
                } else {
                    V(xVar);
                    i7--;
                }
                xVar = xVar.a();
            }
            this.f19806b = i7;
            return xVarA;
        }

        boolean Y(K k7, int i7, m<K, V> mVar) {
            lock();
            try {
                AtomicReferenceArray<com.google.common.cache.x<K, V>> atomicReferenceArray = this.f19810f;
                int length = (atomicReferenceArray.length() - 1) & i7;
                com.google.common.cache.x<K, V> xVar = atomicReferenceArray.get(length);
                for (com.google.common.cache.x<K, V> xVarA = xVar; xVarA != null; xVarA = xVarA.a()) {
                    K key = xVarA.getKey();
                    if (xVarA.c() == i7 && key != null && this.f19805a.f19699e.d(k7, key)) {
                        if (xVarA.b() != mVar) {
                            break;
                        }
                        if (mVar.b()) {
                            xVarA.e(mVar.k());
                        } else {
                            atomicReferenceArray.set(length, X(xVar, xVarA));
                        }
                        return true;
                    }
                }
                return false;
            } finally {
                unlock();
                J();
            }
        }

        @v1.a("this")
        com.google.common.cache.x<K, V> Z(com.google.common.cache.x<K, V> xVar, com.google.common.cache.x<K, V> xVar2, K k7, int i7, V v7, a0<K, V> a0Var, com.google.common.cache.y yVar) {
            n(k7, i7, v7, a0Var.d(), yVar);
            this.f19816l.remove(xVar2);
            this.f19817m.remove(xVar2);
            if (!a0Var.e()) {
                return X(xVar, xVar2);
            }
            a0Var.c(null);
            return xVar;
        }

        void a() {
            c0(this.f19805a.f19710p.a());
            d0();
        }

        V a0(K k7, int i7, V v7) {
            lock();
            try {
                long jA = this.f19805a.f19710p.a();
                K(jA);
                AtomicReferenceArray<com.google.common.cache.x<K, V>> atomicReferenceArray = this.f19810f;
                int length = i7 & (atomicReferenceArray.length() - 1);
                com.google.common.cache.x<K, V> xVar = atomicReferenceArray.get(length);
                for (com.google.common.cache.x<K, V> xVarA = xVar; xVarA != null; xVarA = xVarA.a()) {
                    K key = xVarA.getKey();
                    if (xVarA.c() == i7 && key != null) {
                        if (this.f19805a.f19699e.d(k7, key)) {
                            a0<K, V> a0VarB = xVarA.b();
                            V v8 = a0VarB.get();
                            if (v8 != null) {
                                this.f19808d++;
                                n(k7, i7, v8, a0VarB.d(), com.google.common.cache.y.f19852b);
                                f0(xVarA, k7, v7, jA);
                                o(xVarA);
                                return v8;
                            }
                            if (!a0VarB.b()) {
                                break;
                            }
                            this.f19808d++;
                            com.google.common.cache.x<K, V> xVarZ = Z(xVar, xVarA, key, i7, v8, a0VarB, com.google.common.cache.y.f19853c);
                            int i8 = this.f19806b - 1;
                            atomicReferenceArray.set(length, xVarZ);
                            this.f19806b = i8;
                            break;
                        }
                    }
                }
                return null;
            } finally {
                unlock();
                J();
            }
        }

        void b() {
            if (this.f19806b != 0) {
                lock();
                try {
                    K(this.f19805a.f19710p.a());
                    AtomicReferenceArray<com.google.common.cache.x<K, V>> atomicReferenceArray = this.f19810f;
                    for (int i7 = 0; i7 < atomicReferenceArray.length(); i7++) {
                        for (com.google.common.cache.x<K, V> xVarA = atomicReferenceArray.get(i7); xVarA != null; xVarA = xVarA.a()) {
                            if (xVarA.b().b()) {
                                K key = xVarA.getKey();
                                V v7 = xVarA.b().get();
                                n(key, xVarA.c(), v7, xVarA.b().d(), (key == null || v7 == null) ? com.google.common.cache.y.f19853c : com.google.common.cache.y.f19851a);
                            }
                        }
                    }
                    for (int i8 = 0; i8 < atomicReferenceArray.length(); i8++) {
                        atomicReferenceArray.set(i8, null);
                    }
                    d();
                    this.f19816l.clear();
                    this.f19817m.clear();
                    this.f19815k.set(0);
                    this.f19808d++;
                    this.f19806b = 0;
                } finally {
                    unlock();
                    J();
                }
            }
        }

        boolean b0(K k7, int i7, V v7, V v8) {
            lock();
            try {
                long jA = this.f19805a.f19710p.a();
                K(jA);
                AtomicReferenceArray<com.google.common.cache.x<K, V>> atomicReferenceArray = this.f19810f;
                int length = i7 & (atomicReferenceArray.length() - 1);
                com.google.common.cache.x<K, V> xVar = atomicReferenceArray.get(length);
                for (com.google.common.cache.x<K, V> xVarA = xVar; xVarA != null; xVarA = xVarA.a()) {
                    K key = xVarA.getKey();
                    if (xVarA.c() == i7 && key != null) {
                        if (this.f19805a.f19699e.d(k7, key)) {
                            a0<K, V> a0VarB = xVarA.b();
                            V v9 = a0VarB.get();
                            if (v9 != null) {
                                if (!this.f19805a.f19700f.d(v7, v9)) {
                                    O(xVarA, jA);
                                    break;
                                }
                                this.f19808d++;
                                n(k7, i7, v9, a0VarB.d(), com.google.common.cache.y.f19852b);
                                f0(xVarA, k7, v8, jA);
                                o(xVarA);
                                return true;
                            }
                            if (!a0VarB.b()) {
                                break;
                            }
                            this.f19808d++;
                            com.google.common.cache.x<K, V> xVarZ = Z(xVar, xVarA, key, i7, v9, a0VarB, com.google.common.cache.y.f19853c);
                            int i8 = this.f19806b - 1;
                            atomicReferenceArray.set(length, xVarZ);
                            this.f19806b = i8;
                            break;
                        }
                    }
                }
                return false;
            } finally {
                unlock();
                J();
            }
        }

        void c() {
            while (this.f19812h.poll() != null) {
            }
        }

        void c0(long j7) {
            if (tryLock()) {
                try {
                    l();
                    q(j7);
                    this.f19815k.set(0);
                } finally {
                    unlock();
                }
            }
        }

        void d() {
            if (this.f19805a.k0()) {
                c();
            }
            if (this.f19805a.l0()) {
                e();
            }
        }

        void d0() {
            if (isHeldByCurrentThread()) {
                return;
            }
            this.f19805a.S();
        }

        void e() {
            while (this.f19813i.poll() != null) {
            }
        }

        V e0(com.google.common.cache.x<K, V> xVar, K k7, int i7, V v7, long j7, com.google.common.cache.g<? super K, V> gVar) {
            V vS;
            return (!this.f19805a.c0() || j7 - xVar.f() <= this.f19805a.f19707m || xVar.b().e() || (vS = S(k7, i7, gVar, true)) == null) ? v7 : vS;
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        V f(K k7, int i7, BiFunction<? super K, ? super V, ? extends V> biFunction) {
            int i8;
            a0<K, V> a0Var;
            int i9;
            int i10;
            lock();
            try {
                long jA = this.f19805a.f19710p.a();
                K(jA);
                AtomicReferenceArray<com.google.common.cache.x<K, V>> atomicReferenceArray = this.f19810f;
                int length = i7 & (atomicReferenceArray.length() - 1);
                com.google.common.cache.x<K, V> xVar = (com.google.common.cache.x) atomicReferenceArray.get(length);
                com.google.common.cache.x<K, V> xVarF = xVar;
                while (true) {
                    i8 = 0;
                    if (xVarF == null) {
                        i8 = 0;
                        a0Var = null;
                        i9 = 1;
                        break;
                    }
                    K key = xVarF.getKey();
                    if (xVarF.c() == i7 && key != null && this.f19805a.f19699e.d(k7, key)) {
                        a0<K, V> a0VarB = xVarF.b();
                        if (this.f19805a.E(xVarF, jA)) {
                            n(key, i7, a0VarB.get(), a0VarB.d(), com.google.common.cache.y.f19854d);
                        }
                        this.f19816l.remove(xVarF);
                        this.f19817m.remove(xVarF);
                        i9 = i8;
                        a0Var = a0VarB;
                        break;
                    }
                    xVarF = xVarF.a();
                }
                m<K, V> mVar = new m<>(a0Var);
                if (xVarF == null) {
                    xVarF = F(k7, i7, xVar);
                    xVarF.e(mVar);
                    atomicReferenceArray.set(length, xVarF);
                    i10 = 1;
                } else {
                    xVarF.e(mVar);
                    i10 = i9;
                }
                V vH = mVar.h(k7, biFunction);
                if (vH == null) {
                    if (i10 != 0) {
                        Y(k7, i7, mVar);
                    } else {
                        W(xVarF, i7, com.google.common.cache.y.f19851a);
                    }
                    unlock();
                    J();
                    return null;
                }
                if (a0Var == null || vH != a0Var.get()) {
                    try {
                        V vU = u(k7, i7, mVar, e1.n(vH));
                        unlock();
                        J();
                        return vU;
                    } catch (ExecutionException unused) {
                        throw new AssertionError("impossible; Futures.immediateFuture can't throw");
                    }
                }
                mVar.m(vH);
                xVarF.e(a0Var);
                R(xVarF, i8, jA);
                unlock();
                J();
                return vH;
            } catch (Throwable th) {
                unlock();
                J();
                throw th;
            }
        }

        @v1.a("this")
        void f0(com.google.common.cache.x<K, V> xVar, K k7, V v7, long j7) {
            a0<K, V> a0VarB = xVar.b();
            int iA = this.f19805a.f19704j.a(k7, v7);
            com.google.common.base.e0.h0(iA >= 0, "Weights must be non-negative");
            xVar.e(this.f19805a.f19702h.b(this, xVar, v7, iA));
            R(xVar, iA, j7);
            a0VarB.c(v7);
        }

        boolean g(Object obj, int i7) {
            try {
                if (this.f19806b == 0) {
                    return false;
                }
                com.google.common.cache.x<K, V> xVarX = x(obj, i7, this.f19805a.f19710p.a());
                if (xVarX == null) {
                    return false;
                }
                return xVarX.b().get() != null;
            } finally {
                I();
            }
        }

        boolean g0(K k7, int i7, m<K, V> mVar, V v7) {
            lock();
            try {
                long jA = this.f19805a.f19710p.a();
                K(jA);
                int i8 = this.f19806b + 1;
                if (i8 > this.f19809e) {
                    p();
                    i8 = this.f19806b + 1;
                }
                int i9 = i8;
                AtomicReferenceArray<com.google.common.cache.x<K, V>> atomicReferenceArray = this.f19810f;
                int length = i7 & (atomicReferenceArray.length() - 1);
                com.google.common.cache.x<K, V> xVar = atomicReferenceArray.get(length);
                for (com.google.common.cache.x<K, V> xVarA = xVar; xVarA != null; xVarA = xVarA.a()) {
                    K key = xVarA.getKey();
                    if (xVarA.c() == i7 && key != null && this.f19805a.f19699e.d(k7, key)) {
                        a0<K, V> a0VarB = xVarA.b();
                        V v8 = a0VarB.get();
                        if (mVar != a0VarB && (v8 != null || a0VarB == r.C)) {
                            n(k7, i7, v7, 0, com.google.common.cache.y.f19852b);
                            return false;
                        }
                        this.f19808d++;
                        if (mVar.b()) {
                            n(k7, i7, v8, mVar.d(), v8 == null ? com.google.common.cache.y.f19853c : com.google.common.cache.y.f19852b);
                            i9--;
                        }
                        f0(xVarA, k7, v7, jA);
                        this.f19806b = i9;
                        o(xVarA);
                        return true;
                    }
                }
                this.f19808d++;
                com.google.common.cache.x<K, V> xVarF = F(k7, i7, xVar);
                f0(xVarF, k7, v7, jA);
                atomicReferenceArray.set(length, xVarF);
                this.f19806b = i9;
                o(xVarF);
                return true;
            } finally {
                unlock();
                J();
            }
        }

        @s1.d
        boolean h(Object obj) {
            try {
                if (this.f19806b != 0) {
                    long jA = this.f19805a.f19710p.a();
                    AtomicReferenceArray<com.google.common.cache.x<K, V>> atomicReferenceArray = this.f19810f;
                    int length = atomicReferenceArray.length();
                    for (int i7 = 0; i7 < length; i7++) {
                        for (com.google.common.cache.x<K, V> xVarA = atomicReferenceArray.get(i7); xVarA != null; xVarA = xVarA.a()) {
                            V vY = y(xVarA, jA);
                            if (vY != null && this.f19805a.f19700f.d(obj, vY)) {
                                return true;
                            }
                        }
                    }
                }
                return false;
            } finally {
                I();
            }
        }

        void h0() {
            if (tryLock()) {
                try {
                    l();
                } finally {
                    unlock();
                }
            }
        }

        @v1.a("this")
        com.google.common.cache.x<K, V> i(com.google.common.cache.x<K, V> xVar, com.google.common.cache.x<K, V> xVar2) {
            if (xVar.getKey() == null) {
                return null;
            }
            a0<K, V> a0VarB = xVar.b();
            V v7 = a0VarB.get();
            if (v7 == null && a0VarB.b()) {
                return null;
            }
            com.google.common.cache.x<K, V> xVarB = this.f19805a.f19711q.b(this, xVar, xVar2);
            xVarB.e(a0VarB.g(this.f19813i, v7, xVarB));
            return xVarB;
        }

        void i0(long j7) {
            if (tryLock()) {
                try {
                    q(j7);
                } finally {
                    unlock();
                }
            }
        }

        @v1.a("this")
        void j() {
            int i7 = 0;
            do {
                Reference<? extends K> referencePoll = this.f19812h.poll();
                if (referencePoll == null) {
                    return;
                }
                this.f19805a.W((com.google.common.cache.x) referencePoll);
                i7++;
            } while (i7 != 16);
        }

        V j0(com.google.common.cache.x<K, V> xVar, K k7, a0<K, V> a0Var) throws ExecutionException {
            if (!a0Var.e()) {
                throw new AssertionError();
            }
            com.google.common.base.e0.x0(!Thread.holdsLock(xVar), "Recursive load of: %s", k7);
            try {
                V vF = a0Var.f();
                if (vF != null) {
                    P(xVar, this.f19805a.f19710p.a());
                    this.f19818n.c(1);
                    return vF;
                }
                throw new com.google.common.cache.g.c("CacheLoader returned null for key " + k7 + com.alibaba.android.arouter.utils.b.f12515h);
            } catch (Throwable th) {
                this.f19818n.c(1);
                throw th;
            }
        }

        @v1.a("this")
        void k() {
            while (true) {
                com.google.common.cache.x<K, V> xVarPoll = this.f19814j.poll();
                if (xVarPoll == null) {
                    return;
                }
                if (this.f19817m.contains(xVarPoll)) {
                    this.f19817m.add(xVarPoll);
                }
            }
        }

        @v1.a("this")
        void l() {
            if (this.f19805a.k0()) {
                j();
            }
            if (this.f19805a.l0()) {
                m();
            }
        }

        @v1.a("this")
        void m() {
            int i7 = 0;
            do {
                Reference<? extends V> referencePoll = this.f19813i.poll();
                if (referencePoll == null) {
                    return;
                }
                this.f19805a.X((a0) referencePoll);
                i7++;
            } while (i7 != 16);
        }

        @v1.a("this")
        void n(K k7, int i7, V v7, int i8, com.google.common.cache.y yVar) {
            this.f19807c -= (long) i8;
            if (yVar.a()) {
                this.f19818n.a();
            }
            if (this.f19805a.f19708n != r.D) {
                this.f19805a.f19708n.offer(com.google.common.cache.b0.a(k7, v7, yVar));
            }
        }

        @v1.a("this")
        void o(com.google.common.cache.x<K, V> xVar) {
            if (this.f19805a.n()) {
                k();
                if (xVar.b().d() > this.f19811g && !W(xVar, xVar.c(), com.google.common.cache.y.f19855e)) {
                    throw new AssertionError();
                }
                while (this.f19807c > this.f19811g) {
                    com.google.common.cache.x<K, V> xVarZ = z();
                    if (!W(xVarZ, xVarZ.c(), com.google.common.cache.y.f19855e)) {
                        throw new AssertionError();
                    }
                }
            }
        }

        @v1.a("this")
        void p() {
            AtomicReferenceArray<com.google.common.cache.x<K, V>> atomicReferenceArray = this.f19810f;
            int length = atomicReferenceArray.length();
            if (length >= 1073741824) {
                return;
            }
            int i7 = this.f19806b;
            AtomicReferenceArray<com.google.common.cache.x<K, V>> atomicReferenceArrayH = H(length << 1);
            this.f19809e = (atomicReferenceArrayH.length() * 3) / 4;
            int length2 = atomicReferenceArrayH.length() - 1;
            for (int i8 = 0; i8 < length; i8++) {
                com.google.common.cache.x<K, V> xVarA = atomicReferenceArray.get(i8);
                if (xVarA != null) {
                    com.google.common.cache.x<K, V> xVarA2 = xVarA.a();
                    int iC = xVarA.c() & length2;
                    if (xVarA2 == null) {
                        atomicReferenceArrayH.set(iC, xVarA);
                    } else {
                        com.google.common.cache.x<K, V> xVar = xVarA;
                        while (xVarA2 != null) {
                            int iC2 = xVarA2.c() & length2;
                            if (iC2 != iC) {
                                xVar = xVarA2;
                                iC = iC2;
                            }
                            xVarA2 = xVarA2.a();
                        }
                        atomicReferenceArrayH.set(iC, xVar);
                        while (xVarA != xVar) {
                            int iC3 = xVarA.c() & length2;
                            com.google.common.cache.x<K, V> xVarI = i(xVarA, atomicReferenceArrayH.get(iC3));
                            if (xVarI != null) {
                                atomicReferenceArrayH.set(iC3, xVarI);
                            } else {
                                V(xVarA);
                                i7--;
                            }
                            xVarA = xVarA.a();
                        }
                    }
                }
            }
            this.f19810f = atomicReferenceArrayH;
            this.f19806b = i7;
        }

        @v1.a("this")
        void q(long j7) {
            com.google.common.cache.x<K, V> xVarPeek;
            com.google.common.cache.x<K, V> xVarPeek2;
            k();
            do {
                xVarPeek = this.f19816l.peek();
                if (xVarPeek == null || !this.f19805a.E(xVarPeek, j7)) {
                    do {
                        xVarPeek2 = this.f19817m.peek();
                        if (xVarPeek2 == null || !this.f19805a.E(xVarPeek2, j7)) {
                            return;
                        }
                    } while (W(xVarPeek2, xVarPeek2.c(), com.google.common.cache.y.f19854d));
                    throw new AssertionError();
                }
            } while (W(xVarPeek, xVarPeek.c(), com.google.common.cache.y.f19854d));
            throw new AssertionError();
        }

        V r(Object obj, int i7) {
            try {
                if (this.f19806b != 0) {
                    long jA = this.f19805a.f19710p.a();
                    com.google.common.cache.x<K, V> xVarX = x(obj, i7, jA);
                    if (xVarX == null) {
                        return null;
                    }
                    V v7 = xVarX.b().get();
                    if (v7 != null) {
                        P(xVarX, jA);
                        return e0(xVarX, xVarX.getKey(), i7, v7, jA, this.f19805a.f19713s);
                    }
                    h0();
                }
                return null;
            } finally {
                I();
            }
        }

        V t(K k7, int i7, com.google.common.cache.g<? super K, V> gVar) throws ExecutionException {
            com.google.common.cache.x<K, V> xVarV;
            com.google.common.base.e0.E(k7);
            com.google.common.base.e0.E(gVar);
            try {
                try {
                    if (this.f19806b != 0 && (xVarV = v(k7, i7)) != null) {
                        long jA = this.f19805a.f19710p.a();
                        V vY = y(xVarV, jA);
                        if (vY != null) {
                            P(xVarV, jA);
                            this.f19818n.b(1);
                            V vE0 = e0(xVarV, k7, i7, vY, jA, gVar);
                            I();
                            return vE0;
                        }
                        a0<K, V> a0VarB = xVarV.b();
                        if (a0VarB.e()) {
                            V vJ0 = j0(xVarV, k7, a0VarB);
                            I();
                            return vJ0;
                        }
                    }
                    V vE = E(k7, i7, gVar);
                    I();
                    return vE;
                } catch (ExecutionException e8) {
                    Throwable cause = e8.getCause();
                    if (cause instanceof Error) {
                        throw new o0((Error) cause);
                    }
                    if (cause instanceof RuntimeException) {
                        throw new n2(cause);
                    }
                    throw e8;
                }
            } catch (Throwable th) {
                I();
                throw th;
            }
        }

        V u(K k7, int i7, m<K, V> mVar, l1<V> l1Var) throws Throwable {
            V v7;
            try {
                v7 = (V) p2.d(l1Var);
                try {
                    if (v7 != null) {
                        this.f19818n.e(mVar.i());
                        g0(k7, i7, mVar, v7);
                        return v7;
                    }
                    throw new com.google.common.cache.g.c("CacheLoader returned null for key " + k7 + com.alibaba.android.arouter.utils.b.f12515h);
                } catch (Throwable th) {
                    th = th;
                    if (v7 == null) {
                        this.f19818n.d(mVar.i());
                        Y(k7, i7, mVar);
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                v7 = null;
            }
        }

        com.google.common.cache.x<K, V> v(Object obj, int i7) {
            for (com.google.common.cache.x<K, V> xVarW = w(i7); xVarW != null; xVarW = xVarW.a()) {
                if (xVarW.c() == i7) {
                    K key = xVarW.getKey();
                    if (key == null) {
                        h0();
                    } else if (this.f19805a.f19699e.d(obj, key)) {
                        return xVarW;
                    }
                }
            }
            return null;
        }

        com.google.common.cache.x<K, V> w(int i7) {
            AtomicReferenceArray<com.google.common.cache.x<K, V>> atomicReferenceArray = this.f19810f;
            return atomicReferenceArray.get(i7 & (atomicReferenceArray.length() - 1));
        }

        com.google.common.cache.x<K, V> x(Object obj, int i7, long j7) {
            com.google.common.cache.x<K, V> xVarV = v(obj, i7);
            if (xVarV == null) {
                return null;
            }
            if (!this.f19805a.E(xVarV, j7)) {
                return xVarV;
            }
            i0(j7);
            return null;
        }

        V y(com.google.common.cache.x<K, V> xVar, long j7) {
            if (xVar.getKey() == null) {
                h0();
                return null;
            }
            V v7 = xVar.b().get();
            if (v7 == null) {
                h0();
                return null;
            }
            if (!this.f19805a.E(xVar, j7)) {
                return v7;
            }
            i0(j7);
            return null;
        }

        @v1.a("this")
        com.google.common.cache.x<K, V> z() {
            for (com.google.common.cache.x<K, V> xVar : this.f19817m) {
                if (xVar.b().d() > 0) {
                    return xVar;
                }
            }
            throw new AssertionError();
        }
    }

    static class s<K, V> extends SoftReference<V> implements a0<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final com.google.common.cache.x<K, V> f19824a;

        s(ReferenceQueue<V> referenceQueue, V v7, com.google.common.cache.x<K, V> xVar) {
            super(v7, referenceQueue);
            this.f19824a = xVar;
        }

        @Override // com.google.common.cache.r.a0
        public com.google.common.cache.x<K, V> a() {
            return this.f19824a;
        }

        @Override // com.google.common.cache.r.a0
        public boolean b() {
            return true;
        }

        @Override // com.google.common.cache.r.a0
        public void c(V v7) {
        }

        public int d() {
            return 1;
        }

        @Override // com.google.common.cache.r.a0
        public boolean e() {
            return false;
        }

        @Override // com.google.common.cache.r.a0
        public V f() {
            return get();
        }

        public a0<K, V> g(ReferenceQueue<V> referenceQueue, V v7, com.google.common.cache.x<K, V> xVar) {
            return new s(referenceQueue, v7, xVar);
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    static abstract class t {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final t f19825a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final t f19826b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final t f19827c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final /* synthetic */ t[] f19828d;

        static enum a extends t {
            a(String str, int i7) {
                super(str, i7, null);
            }

            @Override // com.google.common.cache.r.t
            com.google.common.base.l<Object> a() {
                return com.google.common.base.l.c();
            }

            @Override // com.google.common.cache.r.t
            <K, V> a0<K, V> b(C0233r<K, V> c0233r, com.google.common.cache.x<K, V> xVar, V v7, int i7) {
                return i7 == 1 ? new x(v7) : new i0(v7, i7);
            }
        }

        static enum b extends t {
            b(String str, int i7) {
                super(str, i7, null);
            }

            @Override // com.google.common.cache.r.t
            com.google.common.base.l<Object> a() {
                return com.google.common.base.l.g();
            }

            @Override // com.google.common.cache.r.t
            <K, V> a0<K, V> b(C0233r<K, V> c0233r, com.google.common.cache.x<K, V> xVar, V v7, int i7) {
                return i7 == 1 ? new s(c0233r.f19813i, v7, xVar) : new h0(c0233r.f19813i, v7, xVar, i7);
            }
        }

        static enum c extends t {
            c(String str, int i7) {
                super(str, i7, null);
            }

            @Override // com.google.common.cache.r.t
            com.google.common.base.l<Object> a() {
                return com.google.common.base.l.g();
            }

            @Override // com.google.common.cache.r.t
            <K, V> a0<K, V> b(C0233r<K, V> c0233r, com.google.common.cache.x<K, V> xVar, V v7, int i7) {
                return i7 == 1 ? new f0(c0233r.f19813i, v7, xVar) : new j0(c0233r.f19813i, v7, xVar, i7);
            }
        }

        static {
            a aVar = new a("STRONG", 0);
            f19825a = aVar;
            b bVar = new b("SOFT", 1);
            f19826b = bVar;
            c cVar = new c("WEAK", 2);
            f19827c = cVar;
            f19828d = new t[]{aVar, bVar, cVar};
        }

        private t(String str, int i7) {
            super(str, i7);
        }

        public static t valueOf(String str) {
            return (t) Enum.valueOf(t.class, str);
        }

        public static t[] values() {
            return (t[]) f19828d.clone();
        }

        abstract com.google.common.base.l<Object> a();

        abstract <K, V> a0<K, V> b(C0233r<K, V> c0233r, com.google.common.cache.x<K, V> xVar, V v7, int i7);

        /* synthetic */ t(String str, int i7, a aVar) {
            this(str, i7);
        }
    }

    static final class u<K, V> extends w<K, V> {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        volatile long f19829e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        com.google.common.cache.x<K, V> f19830f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        com.google.common.cache.x<K, V> f19831g;

        u(K k7, int i7, com.google.common.cache.x<K, V> xVar) {
            super(k7, i7, xVar);
            this.f19829e = Long.MAX_VALUE;
            this.f19830f = r.P();
            this.f19831g = r.P();
        }

        @Override // com.google.common.cache.r.d, com.google.common.cache.x
        public com.google.common.cache.x<K, V> d() {
            return this.f19831g;
        }

        @Override // com.google.common.cache.r.d, com.google.common.cache.x
        public void g(long j7) {
            this.f19829e = j7;
        }

        @Override // com.google.common.cache.r.d, com.google.common.cache.x
        public long i() {
            return this.f19829e;
        }

        @Override // com.google.common.cache.r.d, com.google.common.cache.x
        public com.google.common.cache.x<K, V> k() {
            return this.f19830f;
        }

        @Override // com.google.common.cache.r.d, com.google.common.cache.x
        public void l(com.google.common.cache.x<K, V> xVar) {
            this.f19830f = xVar;
        }

        @Override // com.google.common.cache.r.d, com.google.common.cache.x
        public void o(com.google.common.cache.x<K, V> xVar) {
            this.f19831g = xVar;
        }
    }

    static final class v<K, V> extends w<K, V> {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        volatile long f19832e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        com.google.common.cache.x<K, V> f19833f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        com.google.common.cache.x<K, V> f19834g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        volatile long f19835h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        com.google.common.cache.x<K, V> f19836i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        com.google.common.cache.x<K, V> f19837j;

        v(K k7, int i7, com.google.common.cache.x<K, V> xVar) {
            super(k7, i7, xVar);
            this.f19832e = Long.MAX_VALUE;
            this.f19833f = r.P();
            this.f19834g = r.P();
            this.f19835h = Long.MAX_VALUE;
            this.f19836i = r.P();
            this.f19837j = r.P();
        }

        @Override // com.google.common.cache.r.d, com.google.common.cache.x
        public com.google.common.cache.x<K, V> d() {
            return this.f19834g;
        }

        @Override // com.google.common.cache.r.d, com.google.common.cache.x
        public long f() {
            return this.f19835h;
        }

        @Override // com.google.common.cache.r.d, com.google.common.cache.x
        public void g(long j7) {
            this.f19832e = j7;
        }

        @Override // com.google.common.cache.r.d, com.google.common.cache.x
        public com.google.common.cache.x<K, V> h() {
            return this.f19836i;
        }

        @Override // com.google.common.cache.r.d, com.google.common.cache.x
        public long i() {
            return this.f19832e;
        }

        @Override // com.google.common.cache.r.d, com.google.common.cache.x
        public void j(long j7) {
            this.f19835h = j7;
        }

        @Override // com.google.common.cache.r.d, com.google.common.cache.x
        public com.google.common.cache.x<K, V> k() {
            return this.f19833f;
        }

        @Override // com.google.common.cache.r.d, com.google.common.cache.x
        public void l(com.google.common.cache.x<K, V> xVar) {
            this.f19833f = xVar;
        }

        @Override // com.google.common.cache.r.d, com.google.common.cache.x
        public void m(com.google.common.cache.x<K, V> xVar) {
            this.f19836i = xVar;
        }

        @Override // com.google.common.cache.r.d, com.google.common.cache.x
        public void n(com.google.common.cache.x<K, V> xVar) {
            this.f19837j = xVar;
        }

        @Override // com.google.common.cache.r.d, com.google.common.cache.x
        public void o(com.google.common.cache.x<K, V> xVar) {
            this.f19834g = xVar;
        }

        @Override // com.google.common.cache.r.d, com.google.common.cache.x
        public com.google.common.cache.x<K, V> p() {
            return this.f19837j;
        }
    }

    static class w<K, V> extends d<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final K f19838a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final int f19839b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final com.google.common.cache.x<K, V> f19840c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        volatile a0<K, V> f19841d = r.h0();

        w(K k7, int i7, com.google.common.cache.x<K, V> xVar) {
            this.f19838a = k7;
            this.f19839b = i7;
            this.f19840c = xVar;
        }

        @Override // com.google.common.cache.r.d, com.google.common.cache.x
        public com.google.common.cache.x<K, V> a() {
            return this.f19840c;
        }

        @Override // com.google.common.cache.r.d, com.google.common.cache.x
        public a0<K, V> b() {
            return this.f19841d;
        }

        @Override // com.google.common.cache.r.d, com.google.common.cache.x
        public int c() {
            return this.f19839b;
        }

        @Override // com.google.common.cache.r.d, com.google.common.cache.x
        public void e(a0<K, V> a0Var) {
            this.f19841d = a0Var;
        }

        @Override // com.google.common.cache.r.d, com.google.common.cache.x
        public K getKey() {
            return this.f19838a;
        }
    }

    static class x<K, V> implements a0<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final V f19842a;

        x(V v7) {
            this.f19842a = v7;
        }

        @Override // com.google.common.cache.r.a0
        public com.google.common.cache.x<K, V> a() {
            return null;
        }

        @Override // com.google.common.cache.r.a0
        public boolean b() {
            return true;
        }

        @Override // com.google.common.cache.r.a0
        public void c(V v7) {
        }

        @Override // com.google.common.cache.r.a0
        public int d() {
            return 1;
        }

        @Override // com.google.common.cache.r.a0
        public boolean e() {
            return false;
        }

        @Override // com.google.common.cache.r.a0
        public V f() {
            return get();
        }

        @Override // com.google.common.cache.r.a0
        public a0<K, V> g(ReferenceQueue<V> referenceQueue, V v7, com.google.common.cache.x<K, V> xVar) {
            return this;
        }

        @Override // com.google.common.cache.r.a0
        public V get() {
            return this.f19842a;
        }
    }

    static final class y<K, V> extends w<K, V> {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        volatile long f19843e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        com.google.common.cache.x<K, V> f19844f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        com.google.common.cache.x<K, V> f19845g;

        y(K k7, int i7, com.google.common.cache.x<K, V> xVar) {
            super(k7, i7, xVar);
            this.f19843e = Long.MAX_VALUE;
            this.f19844f = r.P();
            this.f19845g = r.P();
        }

        @Override // com.google.common.cache.r.d, com.google.common.cache.x
        public long f() {
            return this.f19843e;
        }

        @Override // com.google.common.cache.r.d, com.google.common.cache.x
        public com.google.common.cache.x<K, V> h() {
            return this.f19844f;
        }

        @Override // com.google.common.cache.r.d, com.google.common.cache.x
        public void j(long j7) {
            this.f19843e = j7;
        }

        @Override // com.google.common.cache.r.d, com.google.common.cache.x
        public void m(com.google.common.cache.x<K, V> xVar) {
            this.f19844f = xVar;
        }

        @Override // com.google.common.cache.r.d, com.google.common.cache.x
        public void n(com.google.common.cache.x<K, V> xVar) {
            this.f19845g = xVar;
        }

        @Override // com.google.common.cache.r.d, com.google.common.cache.x
        public com.google.common.cache.x<K, V> p() {
            return this.f19845g;
        }
    }

    final class z extends r<K, V>.i<V> {
        z() {
            super();
        }

        @Override // com.google.common.cache.r.i, java.util.Iterator
        public V next() {
            return c().getValue();
        }
    }

    r(com.google.common.cache.e<? super K, ? super V> eVar, com.google.common.cache.g<? super K, V> gVar) {
        this.f19698d = Math.min(eVar.l(), 65536);
        t tVarQ = eVar.q();
        this.f19701g = tVarQ;
        this.f19702h = eVar.x();
        this.f19699e = eVar.p();
        this.f19700f = eVar.w();
        long jR = eVar.r();
        this.f19703i = jR;
        this.f19704j = (com.google.common.cache.d0<K, V>) eVar.y();
        this.f19705k = eVar.m();
        this.f19706l = eVar.n();
        this.f19707m = eVar.s();
        com.google.common.cache.e.d dVar = (com.google.common.cache.z<K, V>) eVar.t();
        this.f19709o = dVar;
        this.f19708n = dVar == com.google.common.cache.e.d.INSTANCE ? m() : new ConcurrentLinkedQueue<>();
        this.f19710p = eVar.v(Z());
        this.f19711q = f.d(tVarQ, i0(), m0());
        this.f19712r = eVar.u().get();
        this.f19713s = gVar;
        int iMin = Math.min(eVar.o(), 1073741824);
        if (n() && !l()) {
            iMin = (int) Math.min(iMin, jR);
        }
        int i7 = 0;
        int i8 = 1;
        int i9 = 0;
        int i10 = 1;
        while (i10 < this.f19698d && (!n() || i10 * 20 <= this.f19703i)) {
            i9++;
            i10 <<= 1;
        }
        this.f19696b = 32 - i9;
        this.f19695a = i10 - 1;
        this.f19697c = N(i10);
        int i11 = iMin / i10;
        while (i8 < (i11 * i10 < iMin ? i11 + 1 : i11)) {
            i8 <<= 1;
        }
        if (n()) {
            long j7 = this.f19703i;
            long j8 = i10;
            long j9 = (j7 / j8) + 1;
            long j10 = j7 % j8;
            while (true) {
                C0233r<K, V>[] c0233rArr = this.f19697c;
                if (i7 >= c0233rArr.length) {
                    return;
                }
                if (i7 == j10) {
                    j9--;
                }
                c0233rArr[i7] = k(i8, j9, eVar.u().get());
                i7++;
            }
        } else {
            while (true) {
                C0233r<K, V>[] c0233rArr2 = this.f19697c;
                if (i7 >= c0233rArr2.length) {
                    return;
                }
                c0233rArr2[i7] = k(i8, -1L, eVar.u().get());
                i7++;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object H(Function function, Object obj, Object obj2, Object obj3) {
        return obj3 == null ? function.apply(obj) : obj3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object I(BiFunction biFunction, Object obj, Object obj2) {
        if (obj2 == null) {
            return null;
        }
        return biFunction.apply(obj, obj2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object J(Object obj, BiFunction biFunction, Object obj2, Object obj3) {
        return obj3 == null ? obj : biFunction.apply(obj3, obj);
    }

    static <K, V> com.google.common.cache.x<K, V> P() {
        return q.INSTANCE;
    }

    static <K, V> void Q(com.google.common.cache.x<K, V> xVar) {
        com.google.common.cache.x<K, V> xVarP = P();
        xVar.l(xVarP);
        xVar.o(xVarP);
    }

    static <K, V> void R(com.google.common.cache.x<K, V> xVar) {
        com.google.common.cache.x<K, V> xVarP = P();
        xVar.m(xVarP);
        xVar.n(xVarP);
    }

    static int d0(int i7) {
        int i8 = i7 + ((i7 << 15) ^ (-12931));
        int i9 = i8 ^ (i8 >>> 10);
        int i10 = i9 + (i9 << 3);
        int i11 = i10 ^ (i10 >>> 6);
        int i12 = i11 + (i11 << 2) + (i11 << 14);
        return i12 ^ (i12 >>> 16);
    }

    static <K, V> void f(com.google.common.cache.x<K, V> xVar, com.google.common.cache.x<K, V> xVar2) {
        xVar.l(xVar2);
        xVar2.o(xVar);
    }

    static <K, V> void g(com.google.common.cache.x<K, V> xVar, com.google.common.cache.x<K, V> xVar2) {
        xVar.m(xVar2);
        xVar2.n(xVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <E> ArrayList<E> g0(Collection<E> collection) {
        ArrayList<E> arrayList = new ArrayList<>(collection.size());
        ua.a(arrayList, collection.iterator());
        return arrayList;
    }

    static <K, V> a0<K, V> h0() {
        return (a0<K, V>) C;
    }

    static <E> Queue<E> m() {
        return (Queue<E>) D;
    }

    V B(K k7) throws ExecutionException {
        return s(k7, this.f19713s);
    }

    int C(Object obj) {
        return d0(this.f19699e.f(obj));
    }

    void D(Iterable<?> iterable) {
        Iterator<?> it = iterable.iterator();
        while (it.hasNext()) {
            remove(it.next());
        }
    }

    boolean E(com.google.common.cache.x<K, V> xVar, long j7) {
        com.google.common.base.e0.E(xVar);
        if (!q() || j7 - xVar.i() < this.f19705k) {
            return r() && j7 - xVar.f() >= this.f19706l;
        }
        return true;
    }

    @s1.d
    boolean G(com.google.common.cache.x<K, V> xVar, long j7) {
        return f0(xVar.c()).y(xVar, j7) != null;
    }

    /* JADX WARN: Code duplicated, block: B:39:0x00b9  */
    Map<K, V> K(Set<? extends K> set, com.google.common.cache.g<? super K, V> gVar) throws Throwable {
        com.google.common.base.e0.E(gVar);
        com.google.common.base.e0.E(set);
        n0 n0VarC = n0.c();
        boolean z7 = true;
        boolean z8 = false;
        try {
            try {
                try {
                    Map<? super K, V> mapE = gVar.e(set);
                    if (mapE == null) {
                        this.f19712r.d(n0VarC.g(TimeUnit.NANOSECONDS));
                        throw new com.google.common.cache.g.c(gVar + " returned null map from loadAll");
                    }
                    n0VarC.m();
                    for (Map.Entry<K, V> entry : mapE.entrySet()) {
                        K key = entry.getKey();
                        V value = entry.getValue();
                        if (key == null || value == null) {
                            z8 = true;
                        } else {
                            put(key, value);
                        }
                    }
                    if (!z8) {
                        this.f19712r.e(n0VarC.g(TimeUnit.NANOSECONDS));
                        return mapE;
                    }
                    this.f19712r.d(n0VarC.g(TimeUnit.NANOSECONDS));
                    throw new com.google.common.cache.g.c(gVar + " returned null keys or values from loadAll");
                } catch (RuntimeException e8) {
                    throw new n2(e8);
                } catch (Exception e9) {
                    throw new ExecutionException(e9);
                }
            } catch (com.google.common.cache.g.e e10) {
                try {
                    throw e10;
                } catch (Throwable th) {
                    th = th;
                    if (!z7) {
                        this.f19712r.d(n0VarC.g(TimeUnit.NANOSECONDS));
                    }
                    throw th;
                }
            } catch (Error e11) {
                throw new o0(e11);
            } catch (InterruptedException e12) {
                Thread.currentThread().interrupt();
                throw new ExecutionException(e12);
            }
        } catch (Throwable th2) {
            th = th2;
            z7 = false;
            if (!z7) {
                this.f19712r.d(n0VarC.g(TimeUnit.NANOSECONDS));
            }
            throw th;
        }
    }

    long L() {
        long jMax = 0;
        for (C0233r<K, V> c0233r : this.f19697c) {
            jMax += (long) Math.max(0, c0233r.f19806b);
        }
        return jMax;
    }

    @s1.d
    com.google.common.cache.x<K, V> M(K k7, int i7, com.google.common.cache.x<K, V> xVar) {
        C0233r<K, V> c0233rF0 = f0(i7);
        c0233rF0.lock();
        try {
            return c0233rF0.F(k7, i7, xVar);
        } finally {
            c0233rF0.unlock();
        }
    }

    final C0233r<K, V>[] N(int i7) {
        return new C0233r[i7];
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @s1.d
    a0<K, V> O(com.google.common.cache.x<K, V> xVar, V v7, int i7) {
        return this.f19702h.b(f0(xVar.c()), xVar, com.google.common.base.e0.E(v7), i7);
    }

    void S() {
        while (true) {
            com.google.common.cache.b0<K, V> b0VarPoll = this.f19708n.poll();
            if (b0VarPoll == null) {
                return;
            }
            try {
                this.f19709o.a(b0VarPoll);
            } catch (Throwable th) {
                B.log(Level.WARNING, "Exception thrown by removal listener", th);
            }
        }
    }

    void W(com.google.common.cache.x<K, V> xVar) {
        int iC = xVar.c();
        f0(iC).M(xVar, iC);
    }

    void X(a0<K, V> a0Var) {
        com.google.common.cache.x<K, V> xVarA = a0Var.a();
        int iC = xVarA.c();
        f0(iC).N(xVarA.getKey(), iC, a0Var);
    }

    boolean Y() {
        return q();
    }

    boolean Z() {
        return a0() || Y();
    }

    boolean a0() {
        return r() || c0();
    }

    void b0(K k7) {
        int iC = C(com.google.common.base.e0.E(k7));
        f0(iC).S(k7, iC, this.f19713s, false);
    }

    boolean c0() {
        return this.f19707m > 0;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        for (C0233r<K, V> c0233r : this.f19697c) {
            c0233r.b();
        }
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public V compute(K k7, BiFunction<? super K, ? super V, ? extends V> biFunction) {
        com.google.common.base.e0.E(k7);
        com.google.common.base.e0.E(biFunction);
        int iC = C(k7);
        return f0(iC).f(k7, iC, biFunction);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public V computeIfAbsent(final K k7, final Function<? super K, ? extends V> function) {
        com.google.common.base.e0.E(k7);
        com.google.common.base.e0.E(function);
        return compute(k7, new BiFunction() { // from class: com.google.common.cache.o
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return r.H(function, k7, obj, obj2);
            }
        });
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public V computeIfPresent(K k7, final BiFunction<? super K, ? super V, ? extends V> biFunction) {
        com.google.common.base.e0.E(k7);
        com.google.common.base.e0.E(biFunction);
        return compute(k7, new BiFunction() { // from class: com.google.common.cache.p
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return r.I(biFunction, obj, obj2);
            }
        });
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        if (obj == null) {
            return false;
        }
        int iC = C(obj);
        return f0(iC).g(obj, iC);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v0 */
    /* JADX WARN: Type inference failed for: r12v1, types: [int] */
    /* JADX WARN: Type inference failed for: r12v3 */
    /* JADX WARN: Type inference failed for: r15v0 */
    /* JADX WARN: Type inference failed for: r15v1, types: [int] */
    /* JADX WARN: Type inference failed for: r15v3 */
    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsValue(Object obj) {
        boolean z7 = false;
        if (obj == null) {
            return false;
        }
        long jA = this.f19710p.a();
        C0233r<K, V>[] c0233rArr = this.f19697c;
        long j7 = -1;
        int i7 = 0;
        while (i7 < 3) {
            int length = c0233rArr.length;
            long j8 = 0;
            for (?? r12 = z7; r12 < length; r12++) {
                C0233r<K, V> c0233r = c0233rArr[r12];
                int i8 = c0233r.f19806b;
                AtomicReferenceArray<com.google.common.cache.x<K, V>> atomicReferenceArray = c0233r.f19810f;
                for (?? r15 = z7; r15 < atomicReferenceArray.length(); r15++) {
                    com.google.common.cache.x<K, V> xVarA = atomicReferenceArray.get(r15);
                    while (xVarA != null) {
                        C0233r<K, V>[] c0233rArr2 = c0233rArr;
                        V vY = c0233r.y(xVarA, jA);
                        long j9 = jA;
                        if (vY != null && this.f19700f.d(obj, vY)) {
                            return true;
                        }
                        xVarA = xVarA.a();
                        c0233rArr = c0233rArr2;
                        jA = j9;
                    }
                }
                j8 += (long) c0233r.f19808d;
                jA = jA;
                z7 = false;
            }
            long j10 = jA;
            C0233r<K, V>[] c0233rArr3 = c0233rArr;
            if (j8 == j7) {
                return false;
            }
            i7++;
            j7 = j8;
            c0233rArr = c0233rArr3;
            jA = j10;
            z7 = false;
        }
        return z7;
    }

    public void e() {
        for (C0233r<K, V> c0233r : this.f19697c) {
            c0233r.a();
        }
    }

    boolean e0(BiPredicate<? super K, ? super V> biPredicate) {
        com.google.common.base.e0.E(biPredicate);
        boolean z7 = false;
        for (K k7 : keySet()) {
            while (true) {
                V v7 = get(k7);
                if (v7 == null || !biPredicate.test(k7, v7)) {
                    break;
                }
                if (remove(k7, v7)) {
                    z7 = true;
                    break;
                }
            }
        }
        return z7;
    }

    @Override // java.util.AbstractMap, java.util.Map
    @s1.c
    public Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> set = this.f19716v;
        if (set != null) {
            return set;
        }
        h hVar = new h(this);
        this.f19716v = hVar;
        return hVar;
    }

    C0233r<K, V> f0(int i7) {
        return this.f19697c[(i7 >>> this.f19696b) & this.f19695a];
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        if (obj == null) {
            return null;
        }
        int iC = C(obj);
        return f0(iC).r(obj, iC);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public V getOrDefault(Object obj, V v7) {
        V v8 = get(obj);
        return v8 != null ? v8 : v7;
    }

    @s1.d
    com.google.common.cache.x<K, V> i(com.google.common.cache.x<K, V> xVar, com.google.common.cache.x<K, V> xVar2) {
        return f0(xVar.c()).i(xVar, xVar2);
    }

    boolean i0() {
        return j0() || Y();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean isEmpty() {
        C0233r<K, V>[] c0233rArr = this.f19697c;
        long j7 = 0;
        for (int i7 = 0; i7 < c0233rArr.length; i7++) {
            if (c0233rArr[i7].f19806b != 0) {
                return false;
            }
            j7 += (long) c0233rArr[i7].f19808d;
        }
        if (j7 == 0) {
            return true;
        }
        for (int i8 = 0; i8 < c0233rArr.length; i8++) {
            if (c0233rArr[i8].f19806b != 0) {
                return false;
            }
            j7 -= (long) c0233rArr[i8].f19808d;
        }
        return j7 == 0;
    }

    boolean j0() {
        return q() || n();
    }

    C0233r<K, V> k(int i7, long j7, com.google.common.cache.a.b bVar) {
        return new C0233r<>(this, i7, j7, bVar);
    }

    boolean k0() {
        return this.f19701g != t.f19825a;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<K> keySet() {
        Set<K> set = this.f19714t;
        if (set != null) {
            return set;
        }
        k kVar = new k(this);
        this.f19714t = kVar;
        return kVar;
    }

    boolean l() {
        return this.f19704j != com.google.common.cache.e.EnumC0229e.INSTANCE;
    }

    boolean l0() {
        return this.f19702h != t.f19825a;
    }

    boolean m0() {
        return n0() || a0();
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public V merge(K k7, final V v7, final BiFunction<? super V, ? super V, ? extends V> biFunction) {
        com.google.common.base.e0.E(k7);
        com.google.common.base.e0.E(v7);
        com.google.common.base.e0.E(biFunction);
        return compute(k7, new BiFunction() { // from class: com.google.common.cache.q
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return r.J(v7, biFunction, obj, obj2);
            }
        });
    }

    boolean n() {
        return this.f19703i >= 0;
    }

    boolean n0() {
        return r();
    }

    boolean o() {
        return r() || q();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V put(K k7, V v7) {
        com.google.common.base.e0.E(k7);
        com.google.common.base.e0.E(v7);
        int iC = C(k7);
        return f0(iC).L(k7, iC, v7, false);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void putAll(Map<? extends K, ? extends V> map) {
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public V putIfAbsent(K k7, V v7) {
        com.google.common.base.e0.E(k7);
        com.google.common.base.e0.E(v7);
        int iC = C(k7);
        return f0(iC).L(k7, iC, v7, true);
    }

    boolean q() {
        return this.f19705k > 0;
    }

    boolean r() {
        return this.f19706l > 0;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        if (obj == null) {
            return null;
        }
        int iC = C(obj);
        return f0(iC).T(obj, iC);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public boolean replace(K k7, V v7, V v8) {
        com.google.common.base.e0.E(k7);
        com.google.common.base.e0.E(v8);
        if (v7 == null) {
            return false;
        }
        int iC = C(k7);
        return f0(iC).b0(k7, iC, v7, v8);
    }

    V s(K k7, com.google.common.cache.g<? super K, V> gVar) throws ExecutionException {
        int iC = C(com.google.common.base.e0.E(k7));
        return f0(iC).t(k7, iC, gVar);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return com.google.common.primitives.c0.x(L());
    }

    /* JADX WARN: Multi-variable type inference failed */
    v7<K, V> t(Iterable<? extends K> iterable) throws ExecutionException {
        LinkedHashMap linkedHashMapM0 = wb.m0();
        LinkedHashSet linkedHashSetA = af.A();
        int i7 = 0;
        int i8 = 0;
        for (K k7 : iterable) {
            Object obj = get(k7);
            if (!linkedHashMapM0.containsKey(k7)) {
                linkedHashMapM0.put(k7, obj);
                if (obj == null) {
                    i8++;
                    linkedHashSetA.add(k7);
                } else {
                    i7++;
                }
            }
        }
        try {
            if (!linkedHashSetA.isEmpty()) {
                try {
                    Map mapK = K(linkedHashSetA, this.f19713s);
                    for (Object obj2 : linkedHashSetA) {
                        Object obj3 = mapK.get(obj2);
                        if (obj3 == null) {
                            throw new com.google.common.cache.g.c("loadAll failed to return a value for " + obj2);
                        }
                        linkedHashMapM0.put(obj2, obj3);
                    }
                } catch (com.google.common.cache.g.e unused) {
                    for (Object obj4 : linkedHashSetA) {
                        i8--;
                        linkedHashMapM0.put(obj4, s(obj4, this.f19713s));
                    }
                }
            }
            v7<K, V> v7VarG = v7.g(linkedHashMapM0);
            this.f19712r.b(i7);
            this.f19712r.c(i8);
            return v7VarG;
        } catch (Throwable th) {
            this.f19712r.b(i7);
            this.f19712r.c(i8);
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    v7<K, V> u(Iterable<?> iterable) {
        LinkedHashMap linkedHashMapM0 = wb.m0();
        int i7 = 0;
        int i8 = 0;
        for (Object obj : iterable) {
            V v7 = get(obj);
            if (v7 == null) {
                i8++;
            } else {
                linkedHashMapM0.put(obj, v7);
                i7++;
            }
        }
        this.f19712r.b(i7);
        this.f19712r.c(i8);
        return v7.g(linkedHashMapM0);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Collection<V> values() {
        Collection<V> collection = this.f19715u;
        if (collection != null) {
            return collection;
        }
        b0 b0Var = new b0(this);
        this.f19715u = b0Var;
        return b0Var;
    }

    com.google.common.cache.x<K, V> w(Object obj) {
        if (obj == null) {
            return null;
        }
        int iC = C(obj);
        return f0(iC).v(obj, iC);
    }

    public V y(Object obj) {
        int iC = C(com.google.common.base.e0.E(obj));
        V vR = f0(iC).r(obj, iC);
        if (vR == null) {
            this.f19712r.c(1);
        } else {
            this.f19712r.b(1);
        }
        return vR;
    }

    V z(com.google.common.cache.x<K, V> xVar, long j7) {
        V v7;
        if (xVar.getKey() == null || (v7 = xVar.b().get()) == null || E(xVar, j7)) {
            return null;
        }
        return v7;
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public boolean remove(Object obj, Object obj2) {
        if (obj == null || obj2 == null) {
            return false;
        }
        int iC = C(obj);
        return f0(iC).U(obj, iC, obj2);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public V replace(K k7, V v7) {
        com.google.common.base.e0.E(k7);
        com.google.common.base.e0.E(v7);
        int iC = C(k7);
        return f0(iC).a0(k7, iC, v7);
    }
}
