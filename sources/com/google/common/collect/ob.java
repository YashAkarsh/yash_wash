package com.google.common.collect;

import com.google.common.collect.ob.j;
import com.google.common.collect.ob.o;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: classes2.dex */
@s1.c
class ob<K, V, E extends j<K, V, E>, S extends o<K, V, E, S>> extends AbstractMap<K, V> implements ConcurrentMap<K, V>, Serializable {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    static final int f20779j = 1073741824;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    static final int f20780k = 65536;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    static final int f20781l = 3;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    static final int f20782m = 63;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    static final int f20783n = 16;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    static final long f20784o = 60;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    static final h0<Object, Object, f> f20785p = new a();

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static final long f20786q = 5;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final transient int f20787a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final transient int f20788b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final transient o<K, V, E, S>[] f20789c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final int f20790d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final com.google.common.base.l<Object> f20791e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final transient k<K, V, E, S> f20792f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    transient Set<K> f20793g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    transient Collection<V> f20794h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    transient Set<Map.Entry<K, V>> f20795i;

    static class a implements h0<Object, Object, f> {
        a() {
        }

        @Override // com.google.common.collect.ob.h0
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public h0<Object, Object, f> b(ReferenceQueue<Object> referenceQueue, f fVar) {
            return this;
        }

        @Override // com.google.common.collect.ob.h0
        public void clear() {
        }

        @Override // com.google.common.collect.ob.h0
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public f a() {
            return null;
        }

        @Override // com.google.common.collect.ob.h0
        public Object get() {
            return null;
        }
    }

    static final class a0<K> extends d<K, nb.a, a0<K>> implements x<K, nb.a, a0<K>> {

        static final class a<K> implements k<K, nb.a, a0<K>, b0<K>> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private static final a<?> f20796a = new a<>();

            a() {
            }

            static <K> a<K> h() {
                return (a<K>) f20796a;
            }

            @Override // com.google.common.collect.ob.k
            public q b() {
                return q.f20843b;
            }

            @Override // com.google.common.collect.ob.k
            public q c() {
                return q.f20842a;
            }

            @Override // com.google.common.collect.ob.k
            /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
            public a0<K> a(b0<K> b0Var, a0<K> a0Var, a0<K> a0Var2) {
                if (a0Var.getKey() == null) {
                    return null;
                }
                return a0Var.e(((b0) b0Var).f20804h, a0Var2);
            }

            @Override // com.google.common.collect.ob.k
            /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
            public a0<K> f(b0<K> b0Var, K k7, int i7, a0<K> a0Var) {
                return new a0<>(((b0) b0Var).f20804h, k7, i7, a0Var);
            }

            @Override // com.google.common.collect.ob.k
            /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
            public b0<K> e(ob<K, nb.a, a0<K>, b0<K>> obVar, int i7, int i8) {
                return new b0<>(obVar, i7, i8);
            }

            @Override // com.google.common.collect.ob.k
            /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
            public void d(b0<K> b0Var, a0<K> a0Var, nb.a aVar) {
            }
        }

        a0(ReferenceQueue<K> referenceQueue, K k7, int i7, a0<K> a0Var) {
            super(referenceQueue, k7, i7, a0Var);
        }

        a0<K> e(ReferenceQueue<K> referenceQueue, a0<K> a0Var) {
            return new a0<>(referenceQueue, getKey(), this.f20810a, a0Var);
        }

        @Override // com.google.common.collect.ob.j
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public nb.a getValue() {
            return nb.a.VALUE;
        }

        void g(nb.a aVar) {
        }
    }

    static abstract class b<K, V> extends k5<K, V> implements Serializable {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private static final long f20797g = 3;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final q f20798a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final q f20799b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final com.google.common.base.l<Object> f20800c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final com.google.common.base.l<Object> f20801d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final int f20802e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        transient ConcurrentMap<K, V> f20803f;

        b(q qVar, q qVar2, com.google.common.base.l<Object> lVar, com.google.common.base.l<Object> lVar2, int i7, ConcurrentMap<K, V> concurrentMap) {
            this.f20798a = qVar;
            this.f20799b = qVar2;
            this.f20800c = lVar;
            this.f20801d = lVar2;
            this.f20802e = i7;
            this.f20803f = concurrentMap;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.collect.k5, com.google.common.collect.u5
        /* JADX INFO: renamed from: t0 */
        public ConcurrentMap<K, V> c0() {
            return this.f20803f;
        }

        void u0(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
            while (true) {
                Object object = objectInputStream.readObject();
                if (object == null) {
                    return;
                }
                this.f20803f.put((K) object, (V) objectInputStream.readObject());
            }
        }

        nb w0(ObjectInputStream objectInputStream) throws IOException {
            return new nb().g(objectInputStream.readInt()).j(this.f20798a).k(this.f20799b).h(this.f20800c).a(this.f20802e);
        }

        void x0(ObjectOutputStream objectOutputStream) throws IOException {
            objectOutputStream.writeInt(this.f20803f.size());
            for (Map.Entry<K, V> entry : this.f20803f.entrySet()) {
                objectOutputStream.writeObject(entry.getKey());
                objectOutputStream.writeObject(entry.getValue());
            }
            objectOutputStream.writeObject(null);
        }
    }

    static final class b0<K> extends o<K, nb.a, a0<K>, b0<K>> {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final ReferenceQueue<K> f20804h;

        b0(ob<K, nb.a, a0<K>, b0<K>> obVar, int i7, int i8) {
            super(obVar, i7, i8);
            this.f20804h = new ReferenceQueue<>();
        }

        @Override // com.google.common.collect.ob.o
        /* JADX INFO: renamed from: a0, reason: merged with bridge method [inline-methods] */
        public a0<K> a(j<K, nb.a, ?> jVar) {
            return (a0) jVar;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.ob.o
        /* JADX INFO: renamed from: b0, reason: merged with bridge method [inline-methods] */
        public b0<K> T() {
            return this;
        }

        @Override // com.google.common.collect.ob.o
        ReferenceQueue<K> o() {
            return this.f20804h;
        }

        @Override // com.google.common.collect.ob.o
        void x() {
            c(this.f20804h);
        }

        @Override // com.google.common.collect.ob.o
        void y() {
            i(this.f20804h);
        }
    }

    static abstract class c<K, V, E extends j<K, V, E>> implements j<K, V, E> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final K f20805a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final int f20806b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final E f20807c;

        c(K k7, int i7, E e8) {
            this.f20805a = k7;
            this.f20806b = i7;
            this.f20807c = e8;
        }

        @Override // com.google.common.collect.ob.j
        public E a() {
            return this.f20807c;
        }

        @Override // com.google.common.collect.ob.j
        public int c() {
            return this.f20806b;
        }

        @Override // com.google.common.collect.ob.j
        public K getKey() {
            return this.f20805a;
        }
    }

    static final class c0<K, V> extends d<K, V, c0<K, V>> implements x<K, V, c0<K, V>> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private volatile V f20808c;

        static final class a<K, V> implements k<K, V, c0<K, V>, d0<K, V>> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private static final a<?, ?> f20809a = new a<>();

            a() {
            }

            static <K, V> a<K, V> h() {
                return (a<K, V>) f20809a;
            }

            @Override // com.google.common.collect.ob.k
            public q b() {
                return q.f20843b;
            }

            @Override // com.google.common.collect.ob.k
            public q c() {
                return q.f20842a;
            }

            @Override // com.google.common.collect.ob.k
            /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
            public c0<K, V> a(d0<K, V> d0Var, c0<K, V> c0Var, c0<K, V> c0Var2) {
                if (c0Var.getKey() == null) {
                    return null;
                }
                return c0Var.e(((d0) d0Var).f20812h, c0Var2);
            }

            @Override // com.google.common.collect.ob.k
            /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
            public c0<K, V> f(d0<K, V> d0Var, K k7, int i7, c0<K, V> c0Var) {
                return new c0<>(((d0) d0Var).f20812h, k7, i7, c0Var);
            }

            @Override // com.google.common.collect.ob.k
            /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
            public d0<K, V> e(ob<K, V, c0<K, V>, d0<K, V>> obVar, int i7, int i8) {
                return new d0<>(obVar, i7, i8);
            }

            @Override // com.google.common.collect.ob.k
            /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
            public void d(d0<K, V> d0Var, c0<K, V> c0Var, V v7) {
                c0Var.f(v7);
            }
        }

        c0(ReferenceQueue<K> referenceQueue, K k7, int i7, c0<K, V> c0Var) {
            super(referenceQueue, k7, i7, c0Var);
            this.f20808c = null;
        }

        c0<K, V> e(ReferenceQueue<K> referenceQueue, c0<K, V> c0Var) {
            c0<K, V> c0Var2 = new c0<>(referenceQueue, getKey(), this.f20810a, c0Var);
            c0Var2.f(this.f20808c);
            return c0Var2;
        }

        void f(V v7) {
            this.f20808c = v7;
        }

        @Override // com.google.common.collect.ob.j
        public V getValue() {
            return this.f20808c;
        }
    }

    static abstract class d<K, V, E extends j<K, V, E>> extends WeakReference<K> implements j<K, V, E> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final int f20810a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final E f20811b;

        d(ReferenceQueue<K> referenceQueue, K k7, int i7, E e8) {
            super(k7, referenceQueue);
            this.f20810a = i7;
            this.f20811b = e8;
        }

        @Override // com.google.common.collect.ob.j
        public E a() {
            return this.f20811b;
        }

        @Override // com.google.common.collect.ob.j
        public int c() {
            return this.f20810a;
        }

        @Override // com.google.common.collect.ob.j
        public K getKey() {
            return get();
        }
    }

    static final class d0<K, V> extends o<K, V, c0<K, V>, d0<K, V>> {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final ReferenceQueue<K> f20812h;

        d0(ob<K, V, c0<K, V>, d0<K, V>> obVar, int i7, int i8) {
            super(obVar, i7, i8);
            this.f20812h = new ReferenceQueue<>();
        }

        @Override // com.google.common.collect.ob.o
        /* JADX INFO: renamed from: a0, reason: merged with bridge method [inline-methods] */
        public c0<K, V> a(j<K, V, ?> jVar) {
            return (c0) jVar;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.ob.o
        /* JADX INFO: renamed from: b0, reason: merged with bridge method [inline-methods] */
        public d0<K, V> T() {
            return this;
        }

        @Override // com.google.common.collect.ob.o
        ReferenceQueue<K> o() {
            return this.f20812h;
        }

        @Override // com.google.common.collect.ob.o
        void x() {
            c(this.f20812h);
        }

        @Override // com.google.common.collect.ob.o
        void y() {
            i(this.f20812h);
        }
    }

    static final class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final WeakReference<ob<?, ?, ?, ?>> f20813a;

        public e(ob<?, ?, ?, ?> obVar) {
            this.f20813a = new WeakReference<>(obVar);
        }

        @Override // java.lang.Runnable
        public void run() {
            ob<?, ?, ?, ?> obVar = this.f20813a.get();
            if (obVar == null) {
                throw new CancellationException();
            }
            for (o<?, ?, E, S> oVar : obVar.f20789c) {
                oVar.R();
            }
        }
    }

    static final class e0<K, V> extends d<K, V, e0<K, V>> implements g0<K, V, e0<K, V>> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private volatile h0<K, V, e0<K, V>> f20814c;

        static final class a<K, V> implements k<K, V, e0<K, V>, f0<K, V>> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private static final a<?, ?> f20815a = new a<>();

            a() {
            }

            static <K, V> a<K, V> h() {
                return (a<K, V>) f20815a;
            }

            @Override // com.google.common.collect.ob.k
            public q b() {
                return q.f20843b;
            }

            @Override // com.google.common.collect.ob.k
            public q c() {
                return q.f20843b;
            }

            @Override // com.google.common.collect.ob.k
            /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
            public e0<K, V> a(f0<K, V> f0Var, e0<K, V> e0Var, e0<K, V> e0Var2) {
                if (e0Var.getKey() == null || o.w(e0Var)) {
                    return null;
                }
                return e0Var.g(((f0) f0Var).f20816h, ((f0) f0Var).f20817i, e0Var2);
            }

            @Override // com.google.common.collect.ob.k
            /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
            public e0<K, V> f(f0<K, V> f0Var, K k7, int i7, e0<K, V> e0Var) {
                return new e0<>(((f0) f0Var).f20816h, k7, i7, e0Var);
            }

            @Override // com.google.common.collect.ob.k
            /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
            public f0<K, V> e(ob<K, V, e0<K, V>, f0<K, V>> obVar, int i7, int i8) {
                return new f0<>(obVar, i7, i8);
            }

            @Override // com.google.common.collect.ob.k
            /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
            public void d(f0<K, V> f0Var, e0<K, V> e0Var, V v7) {
                e0Var.h(v7, ((f0) f0Var).f20817i);
            }
        }

        e0(ReferenceQueue<K> referenceQueue, K k7, int i7, e0<K, V> e0Var) {
            super(referenceQueue, k7, i7, e0Var);
            this.f20814c = ob.u();
        }

        @Override // com.google.common.collect.ob.g0
        public h0<K, V, e0<K, V>> b() {
            return this.f20814c;
        }

        @Override // com.google.common.collect.ob.g0
        public void d() {
            this.f20814c.clear();
        }

        e0<K, V> g(ReferenceQueue<K> referenceQueue, ReferenceQueue<V> referenceQueue2, e0<K, V> e0Var) {
            e0<K, V> e0Var2 = new e0<>(referenceQueue, getKey(), this.f20810a, e0Var);
            e0Var2.f20814c = this.f20814c.b(referenceQueue2, e0Var2);
            return e0Var2;
        }

        @Override // com.google.common.collect.ob.j
        public V getValue() {
            return this.f20814c.get();
        }

        void h(V v7, ReferenceQueue<V> referenceQueue) {
            h0<K, V, e0<K, V>> h0Var = this.f20814c;
            this.f20814c = new i0(referenceQueue, v7, this);
            h0Var.clear();
        }
    }

    static final class f implements j<Object, Object, f> {
        private f() {
            throw new AssertionError();
        }

        @Override // com.google.common.collect.ob.j
        public int c() {
            throw new AssertionError();
        }

        @Override // com.google.common.collect.ob.j
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public f a() {
            throw new AssertionError();
        }

        @Override // com.google.common.collect.ob.j
        public Object getKey() {
            throw new AssertionError();
        }

        @Override // com.google.common.collect.ob.j
        public Object getValue() {
            throw new AssertionError();
        }
    }

    static final class f0<K, V> extends o<K, V, e0<K, V>, f0<K, V>> {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final ReferenceQueue<K> f20816h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private final ReferenceQueue<V> f20817i;

        f0(ob<K, V, e0<K, V>, f0<K, V>> obVar, int i7, int i8) {
            super(obVar, i7, i8);
            this.f20816h = new ReferenceQueue<>();
            this.f20817i = new ReferenceQueue<>();
        }

        @Override // com.google.common.collect.ob.o
        public h0<K, V, e0<K, V>> B(j<K, V, ?> jVar, V v7) {
            return new i0(this.f20817i, v7, a(jVar));
        }

        @Override // com.google.common.collect.ob.o
        public void X(j<K, V, ?> jVar, h0<K, V, ? extends j<K, V, ?>> h0Var) {
            e0<K, V> e0VarA = a(jVar);
            h0 h0Var2 = ((e0) e0VarA).f20814c;
            ((e0) e0VarA).f20814c = h0Var;
            h0Var2.clear();
        }

        @Override // com.google.common.collect.ob.o
        /* JADX INFO: renamed from: b0, reason: merged with bridge method [inline-methods] */
        public e0<K, V> a(j<K, V, ?> jVar) {
            return (e0) jVar;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.ob.o
        /* JADX INFO: renamed from: c0, reason: merged with bridge method [inline-methods] */
        public f0<K, V> T() {
            return this;
        }

        @Override // com.google.common.collect.ob.o
        ReferenceQueue<K> o() {
            return this.f20816h;
        }

        @Override // com.google.common.collect.ob.o
        ReferenceQueue<V> t() {
            return this.f20817i;
        }

        @Override // com.google.common.collect.ob.o
        public h0<K, V, e0<K, V>> u(j<K, V, ?> jVar) {
            return a(jVar).b();
        }

        @Override // com.google.common.collect.ob.o
        void x() {
            c(this.f20816h);
        }

        @Override // com.google.common.collect.ob.o
        void y() {
            i(this.f20816h);
            j(this.f20817i);
        }
    }

    final class g extends ob<K, V, E, S>.i<Map.Entry<K, V>> {
        g() {
            super();
        }

        @Override // com.google.common.collect.ob.i, java.util.Iterator
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public Map.Entry<K, V> next() {
            return c();
        }
    }

    interface g0<K, V, E extends j<K, V, E>> extends j<K, V, E> {
        h0<K, V, E> b();

        void d();
    }

    final class h extends n<Map.Entry<K, V>> {
        h() {
            super(null);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            ob.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            Map.Entry entry;
            Object key;
            Object obj2;
            return (obj instanceof Map.Entry) && (key = (entry = (Map.Entry) obj).getKey()) != null && (obj2 = ob.this.get(key)) != null && ob.this.w().d(entry.getValue(), obj2);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return ob.this.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return new g();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            Map.Entry entry;
            Object key;
            return (obj instanceof Map.Entry) && (key = (entry = (Map.Entry) obj).getKey()) != null && ob.this.remove(key, entry.getValue());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return ob.this.size();
        }
    }

    interface h0<K, V, E extends j<K, V, E>> {
        E a();

        h0<K, V, E> b(ReferenceQueue<V> referenceQueue, E e8);

        void clear();

        V get();
    }

    abstract class i<T> implements Iterator<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f20820a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f20821b = -1;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        o<K, V, E, S> f20822c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        AtomicReferenceArray<E> f20823d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        E f20824e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        ob<K, V, E, S>.j0 f20825f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        ob<K, V, E, S>.j0 f20826g;

        i() {
            this.f20820a = ob.this.f20789c.length - 1;
            a();
        }

        final void a() {
            this.f20825f = null;
            if (d() || e()) {
                return;
            }
            while (true) {
                int i7 = this.f20820a;
                if (i7 < 0) {
                    return;
                }
                o<K, V, E, S>[] oVarArr = ob.this.f20789c;
                this.f20820a = i7 - 1;
                o<K, V, E, S> oVar = oVarArr[i7];
                this.f20822c = oVar;
                if (oVar.f20835b != 0) {
                    AtomicReferenceArray<E> atomicReferenceArray = this.f20822c.f20838e;
                    this.f20823d = atomicReferenceArray;
                    this.f20821b = atomicReferenceArray.length() - 1;
                    if (e()) {
                        return;
                    }
                }
            }
        }

        boolean b(E e8) {
            o<K, V, E, S> oVar;
            try {
                Object key = e8.getKey();
                Object objG = ob.this.g(e8);
                if (objG == null) {
                    return false;
                }
                this.f20825f = new j0(key, objG);
                return true;
            } finally {
                this.f20822c.C();
            }
        }

        ob<K, V, E, S>.j0 c() {
            ob<K, V, E, S>.j0 j0Var = this.f20825f;
            if (j0Var == null) {
                throw new NoSuchElementException();
            }
            this.f20826g = j0Var;
            a();
            return this.f20826g;
        }

        boolean d() {
            E e8 = this.f20824e;
            if (e8 == null) {
                return false;
            }
            while (true) {
                this.f20824e = (E) e8.a();
                E e9 = this.f20824e;
                if (e9 == null) {
                    return false;
                }
                if (b(e9)) {
                    return true;
                }
                e8 = this.f20824e;
            }
        }

        boolean e() {
            while (true) {
                int i7 = this.f20821b;
                if (i7 < 0) {
                    return false;
                }
                AtomicReferenceArray<E> atomicReferenceArray = this.f20823d;
                this.f20821b = i7 - 1;
                E e8 = atomicReferenceArray.get(i7);
                this.f20824e = e8;
                if (e8 != null && (b(e8) || d())) {
                    return true;
                }
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f20825f != null;
        }

        @Override // java.util.Iterator
        public abstract T next();

        @Override // java.util.Iterator
        public void remove() {
            f2.e(this.f20826g != null);
            ob.this.remove(this.f20826g.getKey());
            this.f20826g = null;
        }
    }

    static final class i0<K, V, E extends j<K, V, E>> extends WeakReference<V> implements h0<K, V, E> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @y1.i
        final E f20828a;

        i0(ReferenceQueue<V> referenceQueue, V v7, E e8) {
            super(v7, referenceQueue);
            this.f20828a = e8;
        }

        @Override // com.google.common.collect.ob.h0
        public E a() {
            return this.f20828a;
        }

        @Override // com.google.common.collect.ob.h0
        public h0<K, V, E> b(ReferenceQueue<V> referenceQueue, E e8) {
            return new i0(referenceQueue, get(), e8);
        }
    }

    interface j<K, V, E extends j<K, V, E>> {
        E a();

        int c();

        K getKey();

        V getValue();
    }

    final class j0 extends com.google.common.collect.v<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final K f20829a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        V f20830b;

        j0(K k7, V v7) {
            this.f20829a = k7;
            this.f20830b = v7;
        }

        @Override // com.google.common.collect.v, java.util.Map.Entry
        public boolean equals(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            return this.f20829a.equals(entry.getKey()) && this.f20830b.equals(entry.getValue());
        }

        @Override // com.google.common.collect.v, java.util.Map.Entry
        public K getKey() {
            return this.f20829a;
        }

        @Override // com.google.common.collect.v, java.util.Map.Entry
        public V getValue() {
            return this.f20830b;
        }

        @Override // com.google.common.collect.v, java.util.Map.Entry
        public int hashCode() {
            return this.f20829a.hashCode() ^ this.f20830b.hashCode();
        }

        @Override // com.google.common.collect.v, java.util.Map.Entry
        public V setValue(V v7) {
            V v8 = (V) ob.this.put(this.f20829a, v7);
            this.f20830b = v7;
            return v8;
        }
    }

    interface k<K, V, E extends j<K, V, E>, S extends o<K, V, E, S>> {
        E a(S s7, E e8, E e9);

        q b();

        q c();

        void d(S s7, E e8, V v7);

        S e(ob<K, V, E, S> obVar, int i7, int i8);

        E f(S s7, K k7, int i7, E e8);
    }

    final class l extends ob<K, V, E, S>.i<K> {
        l() {
            super();
        }

        @Override // com.google.common.collect.ob.i, java.util.Iterator
        public K next() {
            return c().getKey();
        }
    }

    final class m extends n<K> {
        m() {
            super(null);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            ob.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return ob.this.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return ob.this.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            return new l();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            return ob.this.remove(obj) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return ob.this.size();
        }
    }

    private static abstract class n<E> extends AbstractSet<E> {
        private n() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public Object[] toArray() {
            return ob.t(this).toArray();
        }

        /* synthetic */ n(a aVar) {
            this();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public <T> T[] toArray(T[] tArr) {
            return (T[]) ob.t(this).toArray(tArr);
        }
    }

    static abstract class o<K, V, E extends j<K, V, E>, S extends o<K, V, E, S>> extends ReentrantLock {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @y1.i
        final ob<K, V, E, S> f20834a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        volatile int f20835b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f20836c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f20837d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        volatile AtomicReferenceArray<E> f20838e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final int f20839f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final AtomicInteger f20840g = new AtomicInteger();

        o(ob<K, V, E, S> obVar, int i7, int i8) {
            this.f20834a = obVar;
            this.f20839f = i8;
            v(z(i7));
        }

        static <K, V, E extends j<K, V, E>> boolean w(E e8) {
            return e8.getValue() == null;
        }

        E A(K k7, int i7, j<K, V, ?> jVar) {
            return (E) this.f20834a.f20792f.f(T(), k7, i7, a(jVar));
        }

        h0<K, V, E> B(j<K, V, ?> jVar, V v7) {
            throw new AssertionError();
        }

        void C() {
            if ((this.f20840g.incrementAndGet() & 63) == 0) {
                R();
            }
        }

        @v1.a("this")
        void D() {
            S();
        }

        V E(K k7, int i7, V v7, boolean z7) {
            lock();
            try {
                D();
                int i8 = this.f20835b + 1;
                if (i8 > this.f20837d) {
                    k();
                    i8 = this.f20835b + 1;
                }
                AtomicReferenceArray<E> atomicReferenceArray = this.f20838e;
                int length = (atomicReferenceArray.length() - 1) & i7;
                E e8 = atomicReferenceArray.get(length);
                for (j jVarA = e8; jVarA != null; jVarA = jVarA.a()) {
                    Object key = jVarA.getKey();
                    if (jVarA.c() == i7 && key != null && this.f20834a.f20791e.d(k7, key)) {
                        V v8 = (V) jVarA.getValue();
                        if (v8 == null) {
                            this.f20836c++;
                            V(jVarA, v7);
                            this.f20835b = this.f20835b;
                            return null;
                        }
                        if (z7) {
                            return v8;
                        }
                        this.f20836c++;
                        V(jVarA, v7);
                        return v8;
                    }
                }
                this.f20836c++;
                j jVarF = this.f20834a.f20792f.f(T(), k7, i7, e8);
                V(jVarF, v7);
                atomicReferenceArray.set(length, (E) jVarF);
                this.f20835b = i8;
                return null;
            } finally {
                unlock();
            }
        }

        @u1.a
        boolean F(E e8, int i7) {
            lock();
            try {
                AtomicReferenceArray<E> atomicReferenceArray = this.f20838e;
                int length = i7 & (atomicReferenceArray.length() - 1);
                E e9 = atomicReferenceArray.get(length);
                for (j jVarA = e9; jVarA != null; jVarA = jVarA.a()) {
                    if (jVarA == e8) {
                        this.f20836c++;
                        j jVarL = L(e9, jVarA);
                        int i8 = this.f20835b - 1;
                        atomicReferenceArray.set(length, (E) jVarL);
                        this.f20835b = i8;
                        return true;
                    }
                }
                return false;
            } finally {
                unlock();
            }
        }

        @u1.a
        boolean H(K k7, int i7, h0<K, V, E> h0Var) {
            lock();
            try {
                AtomicReferenceArray<E> atomicReferenceArray = this.f20838e;
                int length = (atomicReferenceArray.length() - 1) & i7;
                E e8 = atomicReferenceArray.get(length);
                for (j jVarA = e8; jVarA != null; jVarA = jVarA.a()) {
                    Object key = jVarA.getKey();
                    if (jVarA.c() == i7 && key != null && this.f20834a.f20791e.d(k7, key)) {
                        if (((g0) jVarA).b() != h0Var) {
                            return false;
                        }
                        this.f20836c++;
                        j jVarL = L(e8, jVarA);
                        int i8 = this.f20835b - 1;
                        atomicReferenceArray.set(length, (E) jVarL);
                        this.f20835b = i8;
                        return true;
                    }
                }
                return false;
            } finally {
                unlock();
            }
        }

        @u1.a
        V I(Object obj, int i7) {
            lock();
            try {
                D();
                AtomicReferenceArray<E> atomicReferenceArray = this.f20838e;
                int length = (atomicReferenceArray.length() - 1) & i7;
                E e8 = atomicReferenceArray.get(length);
                for (j jVarA = e8; jVarA != null; jVarA = jVarA.a()) {
                    Object key = jVarA.getKey();
                    if (jVarA.c() == i7 && key != null && this.f20834a.f20791e.d(obj, key)) {
                        V v7 = (V) jVarA.getValue();
                        if (v7 == null && !w(jVarA)) {
                            return null;
                        }
                        this.f20836c++;
                        j jVarL = L(e8, jVarA);
                        int i8 = this.f20835b - 1;
                        atomicReferenceArray.set(length, (E) jVarL);
                        this.f20835b = i8;
                        return v7;
                    }
                }
                return null;
            } finally {
                unlock();
            }
        }

        boolean J(Object obj, int i7, Object obj2) {
            lock();
            try {
                D();
                AtomicReferenceArray<E> atomicReferenceArray = this.f20838e;
                int length = (atomicReferenceArray.length() - 1) & i7;
                E e8 = atomicReferenceArray.get(length);
                j jVarA = e8;
                while (true) {
                    boolean z7 = false;
                    if (jVarA == null) {
                        return false;
                    }
                    Object key = jVarA.getKey();
                    if (jVarA.c() == i7 && key != null && this.f20834a.f20791e.d(obj, key)) {
                        if (this.f20834a.w().d(obj2, jVarA.getValue())) {
                            z7 = true;
                        } else if (!w(jVarA)) {
                            return false;
                        }
                        this.f20836c++;
                        j jVarL = L(e8, jVarA);
                        int i8 = this.f20835b - 1;
                        atomicReferenceArray.set(length, (E) jVarL);
                        this.f20835b = i8;
                        return z7;
                    }
                    jVarA = jVarA.a();
                }
            } finally {
                unlock();
            }
        }

        @v1.a("this")
        boolean K(E e8) {
            int iC = e8.c();
            AtomicReferenceArray<E> atomicReferenceArray = this.f20838e;
            int length = iC & (atomicReferenceArray.length() - 1);
            E e9 = atomicReferenceArray.get(length);
            for (j jVarA = e9; jVarA != null; jVarA = jVarA.a()) {
                if (jVarA == e8) {
                    this.f20836c++;
                    j jVarL = L(e9, jVarA);
                    int i7 = this.f20835b - 1;
                    atomicReferenceArray.set(length, (E) jVarL);
                    this.f20835b = i7;
                    return true;
                }
            }
            return false;
        }

        @v1.a("this")
        E L(E e8, E e9) {
            int i7 = this.f20835b;
            E e10 = (E) e9.a();
            while (e8 != e9) {
                j jVarG = g(e8, e10);
                if (jVarG != null) {
                    e10 = (E) jVarG;
                } else {
                    i7--;
                }
                e8 = (E) e8.a();
            }
            this.f20835b = i7;
            return e10;
        }

        E M(j<K, V, ?> jVar, j<K, V, ?> jVar2) {
            return (E) L(a(jVar), a(jVar2));
        }

        @u1.a
        boolean N(j<K, V, ?> jVar) {
            return K(a(jVar));
        }

        V O(K k7, int i7, V v7) {
            lock();
            try {
                D();
                AtomicReferenceArray<E> atomicReferenceArray = this.f20838e;
                int length = (atomicReferenceArray.length() - 1) & i7;
                E e8 = atomicReferenceArray.get(length);
                for (j jVarA = e8; jVarA != null; jVarA = jVarA.a()) {
                    Object key = jVarA.getKey();
                    if (jVarA.c() == i7 && key != null && this.f20834a.f20791e.d(k7, key)) {
                        V v8 = (V) jVarA.getValue();
                        if (v8 != null) {
                            this.f20836c++;
                            V(jVarA, v7);
                            return v8;
                        }
                        if (w(jVarA)) {
                            this.f20836c++;
                            j jVarL = L(e8, jVarA);
                            int i8 = this.f20835b - 1;
                            atomicReferenceArray.set(length, (E) jVarL);
                            this.f20835b = i8;
                        }
                        return null;
                    }
                }
                return null;
            } finally {
                unlock();
            }
        }

        boolean P(K k7, int i7, V v7, V v8) {
            lock();
            try {
                D();
                AtomicReferenceArray<E> atomicReferenceArray = this.f20838e;
                int length = (atomicReferenceArray.length() - 1) & i7;
                E e8 = atomicReferenceArray.get(length);
                for (j jVarA = e8; jVarA != null; jVarA = jVarA.a()) {
                    Object key = jVarA.getKey();
                    if (jVarA.c() == i7 && key != null && this.f20834a.f20791e.d(k7, key)) {
                        Object value = jVarA.getValue();
                        if (value != null) {
                            if (!this.f20834a.w().d(v7, value)) {
                                return false;
                            }
                            this.f20836c++;
                            V(jVarA, v8);
                            return true;
                        }
                        if (w(jVarA)) {
                            this.f20836c++;
                            j jVarL = L(e8, jVarA);
                            int i8 = this.f20835b - 1;
                            atomicReferenceArray.set(length, (E) jVarL);
                            this.f20835b = i8;
                        }
                        return false;
                    }
                }
                return false;
            } finally {
                unlock();
            }
        }

        void R() {
            S();
        }

        void S() {
            if (tryLock()) {
                try {
                    y();
                    this.f20840g.set(0);
                } finally {
                    unlock();
                }
            }
        }

        abstract S T();

        void U(int i7, j<K, V, ?> jVar) {
            this.f20838e.set(i7, (E) a(jVar));
        }

        void V(E e8, V v7) {
            this.f20834a.f20792f.d(T(), e8, v7);
        }

        void W(j<K, V, ?> jVar, V v7) {
            this.f20834a.f20792f.d(T(), a(jVar), v7);
        }

        void X(j<K, V, ?> jVar, h0<K, V, ? extends j<K, V, ?>> h0Var) {
            throw new AssertionError();
        }

        void Y() {
            if (tryLock()) {
                try {
                    y();
                } finally {
                    unlock();
                }
            }
        }

        abstract E a(j<K, V, ?> jVar);

        void b() {
            if (this.f20835b != 0) {
                lock();
                try {
                    AtomicReferenceArray<E> atomicReferenceArray = this.f20838e;
                    for (int i7 = 0; i7 < atomicReferenceArray.length(); i7++) {
                        atomicReferenceArray.set(i7, null);
                    }
                    x();
                    this.f20840g.set(0);
                    this.f20836c++;
                    this.f20835b = 0;
                } finally {
                    unlock();
                }
            }
        }

        <T> void c(ReferenceQueue<T> referenceQueue) {
            while (referenceQueue.poll() != null) {
            }
        }

        @u1.a
        boolean d(K k7, int i7, h0<K, V, ? extends j<K, V, ?>> h0Var) {
            lock();
            try {
                AtomicReferenceArray<E> atomicReferenceArray = this.f20838e;
                int length = (atomicReferenceArray.length() - 1) & i7;
                E e8 = atomicReferenceArray.get(length);
                for (j jVarA = e8; jVarA != null; jVarA = jVarA.a()) {
                    Object key = jVarA.getKey();
                    if (jVarA.c() == i7 && key != null && this.f20834a.f20791e.d(k7, key)) {
                        if (((g0) jVarA).b() != h0Var) {
                            return false;
                        }
                        atomicReferenceArray.set(length, (E) L(e8, jVarA));
                        return true;
                    }
                }
                return false;
            } finally {
                unlock();
            }
        }

        boolean e(Object obj, int i7) {
            try {
                boolean z7 = false;
                if (this.f20835b == 0) {
                    return false;
                }
                j jVarP = p(obj, i7);
                if (jVarP != null && jVarP.getValue() != null) {
                    z7 = true;
                }
                return z7;
            } finally {
                C();
            }
        }

        @s1.d
        boolean f(Object obj) {
            try {
                if (this.f20835b != 0) {
                    AtomicReferenceArray<E> atomicReferenceArray = this.f20838e;
                    int length = atomicReferenceArray.length();
                    for (int i7 = 0; i7 < length; i7++) {
                        for (E eA = atomicReferenceArray.get(i7); eA != null; eA = eA.a()) {
                            V vQ = q(eA);
                            if (vQ != null && this.f20834a.w().d(obj, vQ)) {
                                return true;
                            }
                        }
                    }
                }
                return false;
            } finally {
                C();
            }
        }

        E g(E e8, E e9) {
            return (E) this.f20834a.f20792f.a(T(), e8, e9);
        }

        E h(j<K, V, ?> jVar, j<K, V, ?> jVar2) {
            return (E) this.f20834a.f20792f.a(T(), a(jVar), a(jVar2));
        }

        @v1.a("this")
        void i(ReferenceQueue<K> referenceQueue) {
            int i7 = 0;
            do {
                Reference<? extends K> referencePoll = referenceQueue.poll();
                if (referencePoll == null) {
                    return;
                }
                this.f20834a.n((j) referencePoll);
                i7++;
            } while (i7 != 16);
        }

        @v1.a("this")
        void j(ReferenceQueue<V> referenceQueue) {
            int i7 = 0;
            do {
                Reference<? extends V> referencePoll = referenceQueue.poll();
                if (referencePoll == null) {
                    return;
                }
                this.f20834a.o((h0) referencePoll);
                i7++;
            } while (i7 != 16);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @v1.a("this")
        void k() {
            AtomicReferenceArray<E> atomicReferenceArray = this.f20838e;
            int length = atomicReferenceArray.length();
            if (length >= 1073741824) {
                return;
            }
            int i7 = this.f20835b;
            AtomicReferenceArray<E> atomicReferenceArrayZ = z(length << 1);
            this.f20837d = (atomicReferenceArrayZ.length() * 3) / 4;
            int length2 = atomicReferenceArrayZ.length() - 1;
            for (int i8 = 0; i8 < length; i8++) {
                E eA = atomicReferenceArray.get(i8);
                if (eA != null) {
                    j jVarA = eA.a();
                    int iC = eA.c() & length2;
                    if (jVarA == null) {
                        atomicReferenceArrayZ.set(iC, eA);
                    } else {
                        j jVar = eA;
                        while (jVarA != null) {
                            int iC2 = jVarA.c() & length2;
                            if (iC2 != iC) {
                                jVar = jVarA;
                                iC = iC2;
                            }
                            jVarA = jVarA.a();
                        }
                        atomicReferenceArrayZ.set(iC, jVar);
                        while (eA != jVar) {
                            int iC3 = eA.c() & length2;
                            j jVarG = g(eA, (j) atomicReferenceArrayZ.get(iC3));
                            if (jVarG != null) {
                                atomicReferenceArrayZ.set(iC3, jVarG);
                            } else {
                                i7--;
                            }
                            eA = eA.a();
                        }
                    }
                }
            }
            this.f20838e = atomicReferenceArrayZ;
            this.f20835b = i7;
        }

        V l(Object obj, int i7) {
            try {
                j jVarP = p(obj, i7);
                if (jVarP == null) {
                    return null;
                }
                V v7 = (V) jVarP.getValue();
                if (v7 == null) {
                    Y();
                }
                return v7;
            } finally {
                C();
            }
        }

        E m(Object obj, int i7) {
            if (this.f20835b == 0) {
                return null;
            }
            for (E e8 = (E) n(i7); e8 != null; e8 = (E) e8.a()) {
                if (e8.c() == i7) {
                    Object key = e8.getKey();
                    if (key == null) {
                        Y();
                    } else if (this.f20834a.f20791e.d(obj, key)) {
                        return e8;
                    }
                }
            }
            return null;
        }

        E n(int i7) {
            AtomicReferenceArray<E> atomicReferenceArray = this.f20838e;
            return atomicReferenceArray.get(i7 & (atomicReferenceArray.length() - 1));
        }

        ReferenceQueue<K> o() {
            throw new AssertionError();
        }

        E p(Object obj, int i7) {
            return (E) m(obj, i7);
        }

        V q(E e8) {
            if (e8.getKey() == null) {
                Y();
                return null;
            }
            V v7 = (V) e8.getValue();
            if (v7 != null) {
                return v7;
            }
            Y();
            return null;
        }

        V r(j<K, V, ?> jVar) {
            return q(a(jVar));
        }

        ReferenceQueue<V> t() {
            throw new AssertionError();
        }

        h0<K, V, E> u(j<K, V, ?> jVar) {
            throw new AssertionError();
        }

        void v(AtomicReferenceArray<E> atomicReferenceArray) {
            int length = (atomicReferenceArray.length() * 3) / 4;
            this.f20837d = length;
            if (length == this.f20839f) {
                this.f20837d = length + 1;
            }
            this.f20838e = atomicReferenceArray;
        }

        void x() {
        }

        @v1.a("this")
        void y() {
        }

        AtomicReferenceArray<E> z(int i7) {
            return new AtomicReferenceArray<>(i7);
        }
    }

    private static final class p<K, V> extends b<K, V> {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private static final long f20841h = 3;

        p(q qVar, q qVar2, com.google.common.base.l<Object> lVar, com.google.common.base.l<Object> lVar2, int i7, ConcurrentMap<K, V> concurrentMap) {
            super(qVar, qVar2, lVar, lVar2, i7, concurrentMap);
        }

        private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
            objectInputStream.defaultReadObject();
            this.f20803f = w0(objectInputStream).i();
            u0(objectInputStream);
        }

        private Object readResolve() {
            return this.f20803f;
        }

        private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
            objectOutputStream.defaultWriteObject();
            x0(objectOutputStream);
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    static abstract class q {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final q f20842a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final q f20843b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final /* synthetic */ q[] f20844c;

        static enum a extends q {
            a(String str, int i7) {
                super(str, i7, null);
            }

            @Override // com.google.common.collect.ob.q
            com.google.common.base.l<Object> a() {
                return com.google.common.base.l.c();
            }
        }

        static enum b extends q {
            b(String str, int i7) {
                super(str, i7, null);
            }

            @Override // com.google.common.collect.ob.q
            com.google.common.base.l<Object> a() {
                return com.google.common.base.l.g();
            }
        }

        static {
            a aVar = new a("STRONG", 0);
            f20842a = aVar;
            b bVar = new b("WEAK", 1);
            f20843b = bVar;
            f20844c = new q[]{aVar, bVar};
        }

        private q(String str, int i7) {
            super(str, i7);
        }

        public static q valueOf(String str) {
            return (q) Enum.valueOf(q.class, str);
        }

        public static q[] values() {
            return (q[]) f20844c.clone();
        }

        abstract com.google.common.base.l<Object> a();

        /* synthetic */ q(String str, int i7, a aVar) {
            this(str, i7);
        }
    }

    static final class r<K> extends c<K, nb.a, r<K>> implements x<K, nb.a, r<K>> {

        static final class a<K> implements k<K, nb.a, r<K>, s<K>> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private static final a<?> f20845a = new a<>();

            a() {
            }

            static <K> a<K> h() {
                return (a<K>) f20845a;
            }

            @Override // com.google.common.collect.ob.k
            public q b() {
                return q.f20842a;
            }

            @Override // com.google.common.collect.ob.k
            public q c() {
                return q.f20842a;
            }

            @Override // com.google.common.collect.ob.k
            /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
            public r<K> a(s<K> sVar, r<K> rVar, r<K> rVar2) {
                return rVar.e(rVar2);
            }

            @Override // com.google.common.collect.ob.k
            /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
            public r<K> f(s<K> sVar, K k7, int i7, r<K> rVar) {
                return new r<>(k7, i7, rVar);
            }

            @Override // com.google.common.collect.ob.k
            /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
            public s<K> e(ob<K, nb.a, r<K>, s<K>> obVar, int i7, int i8) {
                return new s<>(obVar, i7, i8);
            }

            @Override // com.google.common.collect.ob.k
            /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
            public void d(s<K> sVar, r<K> rVar, nb.a aVar) {
            }
        }

        r(K k7, int i7, r<K> rVar) {
            super(k7, i7, rVar);
        }

        r<K> e(r<K> rVar) {
            return new r<>(this.f20805a, this.f20806b, rVar);
        }

        @Override // com.google.common.collect.ob.j
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public nb.a getValue() {
            return nb.a.VALUE;
        }

        void g(nb.a aVar) {
        }
    }

    static final class s<K> extends o<K, nb.a, r<K>, s<K>> {
        s(ob<K, nb.a, r<K>, s<K>> obVar, int i7, int i8) {
            super(obVar, i7, i8);
        }

        @Override // com.google.common.collect.ob.o
        /* JADX INFO: renamed from: Z, reason: merged with bridge method [inline-methods] */
        public r<K> a(j<K, nb.a, ?> jVar) {
            return (r) jVar;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.ob.o
        /* JADX INFO: renamed from: a0, reason: merged with bridge method [inline-methods] */
        public s<K> T() {
            return this;
        }
    }

    static final class t<K, V> extends c<K, V, t<K, V>> implements x<K, V, t<K, V>> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private volatile V f20846d;

        static final class a<K, V> implements k<K, V, t<K, V>, u<K, V>> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private static final a<?, ?> f20847a = new a<>();

            a() {
            }

            static <K, V> a<K, V> h() {
                return (a<K, V>) f20847a;
            }

            @Override // com.google.common.collect.ob.k
            public q b() {
                return q.f20842a;
            }

            @Override // com.google.common.collect.ob.k
            public q c() {
                return q.f20842a;
            }

            @Override // com.google.common.collect.ob.k
            /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
            public t<K, V> a(u<K, V> uVar, t<K, V> tVar, t<K, V> tVar2) {
                return tVar.e(tVar2);
            }

            @Override // com.google.common.collect.ob.k
            /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
            public t<K, V> f(u<K, V> uVar, K k7, int i7, t<K, V> tVar) {
                return new t<>(k7, i7, tVar);
            }

            @Override // com.google.common.collect.ob.k
            /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
            public u<K, V> e(ob<K, V, t<K, V>, u<K, V>> obVar, int i7, int i8) {
                return new u<>(obVar, i7, i8);
            }

            @Override // com.google.common.collect.ob.k
            /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
            public void d(u<K, V> uVar, t<K, V> tVar, V v7) {
                tVar.f(v7);
            }
        }

        t(K k7, int i7, t<K, V> tVar) {
            super(k7, i7, tVar);
            this.f20846d = null;
        }

        t<K, V> e(t<K, V> tVar) {
            t<K, V> tVar2 = new t<>(this.f20805a, this.f20806b, tVar);
            tVar2.f20846d = this.f20846d;
            return tVar2;
        }

        void f(V v7) {
            this.f20846d = v7;
        }

        @Override // com.google.common.collect.ob.j
        public V getValue() {
            return this.f20846d;
        }
    }

    static final class u<K, V> extends o<K, V, t<K, V>, u<K, V>> {
        u(ob<K, V, t<K, V>, u<K, V>> obVar, int i7, int i8) {
            super(obVar, i7, i8);
        }

        @Override // com.google.common.collect.ob.o
        /* JADX INFO: renamed from: Z, reason: merged with bridge method [inline-methods] */
        public t<K, V> a(j<K, V, ?> jVar) {
            return (t) jVar;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.ob.o
        /* JADX INFO: renamed from: a0, reason: merged with bridge method [inline-methods] */
        public u<K, V> T() {
            return this;
        }
    }

    static final class v<K, V> extends c<K, V, v<K, V>> implements g0<K, V, v<K, V>> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private volatile h0<K, V, v<K, V>> f20848d;

        static final class a<K, V> implements k<K, V, v<K, V>, w<K, V>> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private static final a<?, ?> f20849a = new a<>();

            a() {
            }

            static <K, V> a<K, V> h() {
                return (a<K, V>) f20849a;
            }

            @Override // com.google.common.collect.ob.k
            public q b() {
                return q.f20842a;
            }

            @Override // com.google.common.collect.ob.k
            public q c() {
                return q.f20843b;
            }

            @Override // com.google.common.collect.ob.k
            /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
            public v<K, V> a(w<K, V> wVar, v<K, V> vVar, v<K, V> vVar2) {
                if (o.w(vVar)) {
                    return null;
                }
                return vVar.g(((w) wVar).f20850h, vVar2);
            }

            @Override // com.google.common.collect.ob.k
            /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
            public v<K, V> f(w<K, V> wVar, K k7, int i7, v<K, V> vVar) {
                return new v<>(k7, i7, vVar);
            }

            @Override // com.google.common.collect.ob.k
            /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
            public w<K, V> e(ob<K, V, v<K, V>, w<K, V>> obVar, int i7, int i8) {
                return new w<>(obVar, i7, i8);
            }

            @Override // com.google.common.collect.ob.k
            /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
            public void d(w<K, V> wVar, v<K, V> vVar, V v7) {
                vVar.h(v7, ((w) wVar).f20850h);
            }
        }

        v(K k7, int i7, v<K, V> vVar) {
            super(k7, i7, vVar);
            this.f20848d = ob.u();
        }

        @Override // com.google.common.collect.ob.g0
        public h0<K, V, v<K, V>> b() {
            return this.f20848d;
        }

        @Override // com.google.common.collect.ob.g0
        public void d() {
            this.f20848d.clear();
        }

        v<K, V> g(ReferenceQueue<V> referenceQueue, v<K, V> vVar) {
            v<K, V> vVar2 = new v<>(this.f20805a, this.f20806b, vVar);
            vVar2.f20848d = this.f20848d.b(referenceQueue, vVar2);
            return vVar2;
        }

        @Override // com.google.common.collect.ob.j
        public V getValue() {
            return this.f20848d.get();
        }

        void h(V v7, ReferenceQueue<V> referenceQueue) {
            h0<K, V, v<K, V>> h0Var = this.f20848d;
            this.f20848d = new i0(referenceQueue, v7, this);
            h0Var.clear();
        }
    }

    static final class w<K, V> extends o<K, V, v<K, V>, w<K, V>> {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final ReferenceQueue<V> f20850h;

        w(ob<K, V, v<K, V>, w<K, V>> obVar, int i7, int i8) {
            super(obVar, i7, i8);
            this.f20850h = new ReferenceQueue<>();
        }

        @Override // com.google.common.collect.ob.o
        public h0<K, V, v<K, V>> B(j<K, V, ?> jVar, V v7) {
            return new i0(this.f20850h, v7, a(jVar));
        }

        @Override // com.google.common.collect.ob.o
        public void X(j<K, V, ?> jVar, h0<K, V, ? extends j<K, V, ?>> h0Var) {
            v<K, V> vVarA = a(jVar);
            h0 h0Var2 = ((v) vVarA).f20848d;
            ((v) vVarA).f20848d = h0Var;
            h0Var2.clear();
        }

        @Override // com.google.common.collect.ob.o
        /* JADX INFO: renamed from: a0, reason: merged with bridge method [inline-methods] */
        public v<K, V> a(j<K, V, ?> jVar) {
            return (v) jVar;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.ob.o
        /* JADX INFO: renamed from: b0, reason: merged with bridge method [inline-methods] */
        public w<K, V> T() {
            return this;
        }

        @Override // com.google.common.collect.ob.o
        ReferenceQueue<V> t() {
            return this.f20850h;
        }

        @Override // com.google.common.collect.ob.o
        public h0<K, V, v<K, V>> u(j<K, V, ?> jVar) {
            return a(jVar).b();
        }

        @Override // com.google.common.collect.ob.o
        void x() {
            c(this.f20850h);
        }

        @Override // com.google.common.collect.ob.o
        void y() {
            j(this.f20850h);
        }
    }

    interface x<K, V, E extends j<K, V, E>> extends j<K, V, E> {
    }

    final class y extends ob<K, V, E, S>.i<V> {
        y() {
            super();
        }

        @Override // com.google.common.collect.ob.i, java.util.Iterator
        public V next() {
            return c().getValue();
        }
    }

    final class z extends AbstractCollection<V> {
        z() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            ob.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            return ob.this.containsValue(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return ob.this.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            return new y();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return ob.this.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public Object[] toArray() {
            return ob.t(this).toArray();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public <T> T[] toArray(T[] tArr) {
            return (T[]) ob.t(this).toArray(tArr);
        }
    }

    private ob(nb nbVar, k<K, V, E, S> kVar) {
        this.f20790d = Math.min(nbVar.b(), 65536);
        this.f20791e = nbVar.d();
        this.f20792f = kVar;
        int iMin = Math.min(nbVar.c(), 1073741824);
        int i7 = 0;
        int i8 = 1;
        int i9 = 0;
        int i10 = 1;
        while (i10 < this.f20790d) {
            i9++;
            i10 <<= 1;
        }
        this.f20788b = 32 - i9;
        this.f20787a = i10 - 1;
        this.f20789c = m(i10);
        int i11 = iMin / i10;
        while (i8 < (i10 * i11 < iMin ? i11 + 1 : i11)) {
            i8 <<= 1;
        }
        while (true) {
            o<K, V, E, S>[] oVarArr = this.f20789c;
            if (i7 >= oVarArr.length) {
                return;
            }
            oVarArr[i7] = d(i8, -1);
            i7++;
        }
    }

    static <K, V> ob<K, V, ? extends j<K, V, ?>, ?> c(nb nbVar) {
        q qVarE = nbVar.e();
        q qVar = q.f20842a;
        if (qVarE == qVar && nbVar.f() == qVar) {
            return new ob<>(nbVar, t.a.h());
        }
        if (nbVar.e() == qVar && nbVar.f() == q.f20843b) {
            return new ob<>(nbVar, v.a.h());
        }
        q qVarE2 = nbVar.e();
        q qVar2 = q.f20843b;
        if (qVarE2 == qVar2 && nbVar.f() == qVar) {
            return new ob<>(nbVar, c0.a.h());
        }
        if (nbVar.e() == qVar2 && nbVar.f() == qVar2) {
            return new ob<>(nbVar, e0.a.h());
        }
        throw new AssertionError();
    }

    static <K> ob<K, nb.a, ? extends j<K, nb.a, ?>, ?> e(nb nbVar) {
        q qVarE = nbVar.e();
        q qVar = q.f20842a;
        if (qVarE == qVar && nbVar.f() == qVar) {
            return new ob<>(nbVar, r.a.h());
        }
        q qVarE2 = nbVar.e();
        q qVar2 = q.f20843b;
        if (qVarE2 == qVar2 && nbVar.f() == qVar) {
            return new ob<>(nbVar, a0.a.h());
        }
        if (nbVar.f() == qVar2) {
            throw new IllegalArgumentException("Map cannot have both weak and dummy values");
        }
        throw new AssertionError();
    }

    static int q(int i7) {
        int i8 = i7 + ((i7 << 15) ^ (-12931));
        int i9 = i8 ^ (i8 >>> 10);
        int i10 = i9 + (i9 << 3);
        int i11 = i10 ^ (i10 >>> 6);
        int i12 = i11 + (i11 << 2) + (i11 << 14);
        return i12 ^ (i12 >>> 16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <E> ArrayList<E> t(Collection<E> collection) {
        ArrayList<E> arrayList = new ArrayList<>(collection.size());
        ua.a(arrayList, collection.iterator());
        return arrayList;
    }

    static <K, V, E extends j<K, V, E>> h0<K, V, E> u() {
        return (h0<K, V, E>) f20785p;
    }

    @s1.d
    E b(E e8, E e9) {
        return (E) r(e8.c()).g(e8, e9);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        for (o<K, V, E, S> oVar : this.f20789c) {
            oVar.b();
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        if (obj == null) {
            return false;
        }
        int i7 = i(obj);
        return r(i7).e(obj, i7);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v0 */
    /* JADX WARN: Type inference failed for: r10v1, types: [int] */
    /* JADX WARN: Type inference failed for: r10v3 */
    /* JADX WARN: Type inference failed for: r13v0 */
    /* JADX WARN: Type inference failed for: r13v1, types: [int] */
    /* JADX WARN: Type inference failed for: r13v3 */
    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsValue(Object obj) {
        boolean z7 = false;
        if (obj == null) {
            return false;
        }
        o<K, V, E, S>[] oVarArr = this.f20789c;
        long j7 = -1;
        int i7 = 0;
        while (i7 < 3) {
            int length = oVarArr.length;
            long j8 = 0;
            for (?? r10 = z7; r10 < length; r10++) {
                o<K, V, E, S> oVar = oVarArr[r10];
                int i8 = oVar.f20835b;
                AtomicReferenceArray<E> atomicReferenceArray = oVar.f20838e;
                for (?? r13 = z7; r13 < atomicReferenceArray.length(); r13++) {
                    for (E eA = atomicReferenceArray.get(r13); eA != null; eA = eA.a()) {
                        V vQ = oVar.q(eA);
                        if (vQ != null && w().d(obj, vQ)) {
                            return true;
                        }
                    }
                }
                j8 += (long) oVar.f20836c;
                z7 = false;
            }
            if (j8 == j7) {
                return false;
            }
            i7++;
            j7 = j8;
            z7 = false;
        }
        return z7;
    }

    o<K, V, E, S> d(int i7, int i8) {
        return this.f20792f.e(this, i7, i8);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> set = this.f20795i;
        if (set != null) {
            return set;
        }
        h hVar = new h();
        this.f20795i = hVar;
        return hVar;
    }

    E f(Object obj) {
        if (obj == null) {
            return null;
        }
        int i7 = i(obj);
        return (E) r(i7).m(obj, i7);
    }

    V g(E e8) {
        V v7;
        if (e8.getKey() == null || (v7 = (V) e8.getValue()) == null) {
            return null;
        }
        return v7;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        if (obj == null) {
            return null;
        }
        int i7 = i(obj);
        return r(i7).l(obj, i7);
    }

    int i(Object obj) {
        return q(this.f20791e.f(obj));
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean isEmpty() {
        o<K, V, E, S>[] oVarArr = this.f20789c;
        long j7 = 0;
        for (int i7 = 0; i7 < oVarArr.length; i7++) {
            if (oVarArr[i7].f20835b != 0) {
                return false;
            }
            j7 += (long) oVarArr[i7].f20836c;
        }
        if (j7 == 0) {
            return true;
        }
        for (int i8 = 0; i8 < oVarArr.length; i8++) {
            if (oVarArr[i8].f20835b != 0) {
                return false;
            }
            j7 -= (long) oVarArr[i8].f20836c;
        }
        return j7 == 0;
    }

    @s1.d
    boolean k(j<K, V, ?> jVar) {
        return r(jVar.c()).r(jVar) != null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<K> keySet() {
        Set<K> set = this.f20793g;
        if (set != null) {
            return set;
        }
        m mVar = new m();
        this.f20793g = mVar;
        return mVar;
    }

    @s1.d
    q l() {
        return this.f20792f.b();
    }

    final o<K, V, E, S>[] m(int i7) {
        return new o[i7];
    }

    void n(E e8) {
        int iC = e8.c();
        r(iC).F(e8, iC);
    }

    /* JADX WARN: Multi-variable type inference failed */
    void o(h0<K, V, E> h0Var) {
        j jVarA = h0Var.a();
        int iC = jVarA.c();
        r(iC).H(jVarA.getKey(), iC, h0Var);
    }

    @Override // java.util.AbstractMap, java.util.Map
    @u1.a
    public V put(K k7, V v7) {
        com.google.common.base.e0.E(k7);
        com.google.common.base.e0.E(v7);
        int i7 = i(k7);
        return r(i7).E(k7, i7, v7, false);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void putAll(Map<? extends K, ? extends V> map) {
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    @u1.a
    public V putIfAbsent(K k7, V v7) {
        com.google.common.base.e0.E(k7);
        com.google.common.base.e0.E(v7);
        int i7 = i(k7);
        return r(i7).E(k7, i7, v7, true);
    }

    o<K, V, E, S> r(int i7) {
        return this.f20789c[(i7 >>> this.f20788b) & this.f20787a];
    }

    @Override // java.util.AbstractMap, java.util.Map
    @u1.a
    public V remove(Object obj) {
        if (obj == null) {
            return null;
        }
        int i7 = i(obj);
        return r(i7).I(obj, i7);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    @u1.a
    public boolean replace(K k7, V v7, V v8) {
        com.google.common.base.e0.E(k7);
        com.google.common.base.e0.E(v8);
        if (v7 == null) {
            return false;
        }
        int i7 = i(k7);
        return r(i7).P(k7, i7, v7, v8);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        long j7 = 0;
        for (o<K, V, E, S> oVar : this.f20789c) {
            j7 += (long) oVar.f20835b;
        }
        return com.google.common.primitives.c0.x(j7);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Collection<V> values() {
        Collection<V> collection = this.f20794h;
        if (collection != null) {
            return collection;
        }
        z zVar = new z();
        this.f20794h = zVar;
        return zVar;
    }

    @s1.d
    com.google.common.base.l<Object> w() {
        return this.f20792f.c().a();
    }

    Object writeReplace() {
        return new p(this.f20792f.b(), this.f20792f.c(), this.f20791e, this.f20792f.c().a(), this.f20790d, this);
    }

    @s1.d
    q y() {
        return this.f20792f.c();
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    @u1.a
    public boolean remove(Object obj, Object obj2) {
        if (obj == null || obj2 == null) {
            return false;
        }
        int i7 = i(obj);
        return r(i7).J(obj, i7, obj2);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    @u1.a
    public V replace(K k7, V v7) {
        com.google.common.base.e0.E(k7);
        com.google.common.base.e0.E(v7);
        int i7 = i(k7);
        return r(i7).O(k7, i7, v7);
    }
}
