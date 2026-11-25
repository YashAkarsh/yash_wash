package com.google.common.cache;

import com.google.common.collect.v7;
import java.util.concurrent.ExecutionException;

/* JADX INFO: loaded from: classes2.dex */
@s1.c
public abstract class j<K, V> extends i<K, V> implements k<K, V> {

    public static abstract class a<K, V> extends j<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final k<K, V> f19685a;

        protected a(k<K, V> kVar) {
            this.f19685a = (k) com.google.common.base.e0.E(kVar);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.cache.j, com.google.common.cache.i
        /* JADX INFO: renamed from: e0, reason: merged with bridge method [inline-methods] */
        public final k<K, V> c0() {
            return this.f19685a;
        }
    }

    protected j() {
    }

    @Override // com.google.common.cache.k
    public v7<K, V> K(Iterable<? extends K> iterable) throws ExecutionException {
        return c0().K(iterable);
    }

    @Override // com.google.common.cache.k
    public void N(K k7) {
        c0().N(k7);
    }

    @Override // com.google.common.cache.k, com.google.common.base.s, java.util.function.Function
    public V apply(K k7) {
        return c0().apply(k7);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.common.cache.i
    /* JADX INFO: renamed from: e0 */
    public abstract k<K, V> c0();

    @Override // com.google.common.cache.k
    public V get(K k7) throws ExecutionException {
        return c0().get(k7);
    }

    @Override // com.google.common.cache.k
    public V o(K k7) {
        return c0().o(k7);
    }
}
