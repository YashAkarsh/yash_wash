package com.google.common.cache;

import com.google.common.collect.v7;
import com.google.common.collect.wb;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;

/* JADX INFO: loaded from: classes2.dex */
@s1.b
public abstract class a<K, V> implements c<K, V> {

    /* JADX INFO: renamed from: com.google.common.cache.a$a, reason: collision with other inner class name */
    public static final class C0227a implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final u f19581a = v.a();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final u f19582b = v.a();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final u f19583c = v.a();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final u f19584d = v.a();

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final u f19585e = v.a();

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final u f19586f = v.a();

        @Override // com.google.common.cache.a.b
        public void a() {
            this.f19586f.a();
        }

        @Override // com.google.common.cache.a.b
        public void b(int i7) {
            this.f19581a.c(i7);
        }

        @Override // com.google.common.cache.a.b
        public void c(int i7) {
            this.f19582b.c(i7);
        }

        @Override // com.google.common.cache.a.b
        public void d(long j7) {
            this.f19584d.a();
            this.f19585e.c(j7);
        }

        @Override // com.google.common.cache.a.b
        public void e(long j7) {
            this.f19583c.a();
            this.f19585e.c(j7);
        }

        @Override // com.google.common.cache.a.b
        public h f() {
            return new h(this.f19581a.b(), this.f19582b.b(), this.f19583c.b(), this.f19584d.b(), this.f19585e.b(), this.f19586f.b());
        }

        public void g(b bVar) {
            h hVarF = bVar.f();
            this.f19581a.c(hVarF.c());
            this.f19582b.c(hVarF.j());
            this.f19583c.c(hVarF.h());
            this.f19584d.c(hVarF.f());
            this.f19585e.c(hVarF.n());
            this.f19586f.c(hVarF.b());
        }
    }

    public interface b {
        void a();

        void b(int i7);

        void c(int i7);

        void d(long j7);

        void e(long j7);

        h f();
    }

    protected a() {
    }

    @Override // com.google.common.cache.c
    public void B(Iterable<?> iterable) {
        Iterator<?> it = iterable.iterator();
        while (it.hasNext()) {
            Z(it.next());
        }
    }

    @Override // com.google.common.cache.c
    public v7<K, V> Y(Iterable<?> iterable) {
        V vU;
        LinkedHashMap linkedHashMapM0 = wb.m0();
        for (Object obj : iterable) {
            if (!linkedHashMapM0.containsKey(obj) && (vU = u(obj)) != null) {
                linkedHashMapM0.put(obj, vU);
            }
        }
        return v7.g(linkedHashMapM0);
    }

    @Override // com.google.common.cache.c
    public void Z(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.cache.c
    public h a0() {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.cache.c
    public ConcurrentMap<K, V> asMap() {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.cache.c
    public void b0() {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.cache.c
    public void l() {
    }

    @Override // com.google.common.cache.c
    public void put(K k7, V v7) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.cache.c
    public void putAll(Map<? extends K, ? extends V> map) {
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override // com.google.common.cache.c
    public long size() {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.cache.c
    public V z(K k7, Callable<? extends V> callable) throws ExecutionException {
        throw new UnsupportedOperationException();
    }
}
