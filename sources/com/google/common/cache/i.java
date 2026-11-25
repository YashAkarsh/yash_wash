package com.google.common.cache;

import com.google.common.collect.b6;
import com.google.common.collect.v7;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;

/* JADX INFO: loaded from: classes2.dex */
@s1.c
public abstract class i<K, V> extends b6 implements c<K, V> {

    public static abstract class a<K, V> extends i<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final c<K, V> f19684a;

        protected a(c<K, V> cVar) {
            this.f19684a = (c) com.google.common.base.e0.E(cVar);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.cache.i, com.google.common.collect.b6
        /* JADX INFO: renamed from: d0, reason: merged with bridge method [inline-methods] */
        public final c<K, V> c0() {
            return this.f19684a;
        }
    }

    protected i() {
    }

    @Override // com.google.common.cache.c
    public void B(Iterable<?> iterable) {
        c0().B(iterable);
    }

    @Override // com.google.common.cache.c
    public v7<K, V> Y(Iterable<?> iterable) {
        return c0().Y(iterable);
    }

    @Override // com.google.common.cache.c
    public void Z(Object obj) {
        c0().Z(obj);
    }

    @Override // com.google.common.cache.c
    public h a0() {
        return c0().a0();
    }

    @Override // com.google.common.cache.c
    public ConcurrentMap<K, V> asMap() {
        return c0().asMap();
    }

    @Override // com.google.common.cache.c
    public void b0() {
        c0().b0();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.common.collect.b6
    /* JADX INFO: renamed from: d0 */
    public abstract c<K, V> c0();

    @Override // com.google.common.cache.c
    public void l() {
        c0().l();
    }

    @Override // com.google.common.cache.c
    public void put(K k7, V v7) {
        c0().put(k7, v7);
    }

    @Override // com.google.common.cache.c
    public void putAll(Map<? extends K, ? extends V> map) {
        c0().putAll(map);
    }

    @Override // com.google.common.cache.c
    public long size() {
        return c0().size();
    }

    @Override // com.google.common.cache.c
    public V u(Object obj) {
        return c0().u(obj);
    }

    @Override // com.google.common.cache.c
    public V z(K k7, Callable<? extends V> callable) throws ExecutionException {
        return c0().z(k7, callable);
    }
}
