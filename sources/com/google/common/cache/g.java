package com.google.common.cache;

import com.google.common.base.p0;
import com.google.common.util.concurrent.e1;
import com.google.common.util.concurrent.l1;
import com.google.common.util.concurrent.m1;
import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
@s1.b(emulated = true)
public abstract class g<K, V> {

    static class a extends g<K, V> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Executor f19670b;

        /* JADX INFO: renamed from: com.google.common.cache.g$a$a, reason: collision with other inner class name */
        class CallableC0231a implements Callable<V> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ Object f19671a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ Object f19672b;

            CallableC0231a(Object obj, Object obj2) {
                this.f19671a = obj;
                this.f19672b = obj2;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.concurrent.Callable
            public V call() throws Exception {
                return g.this.f(this.f19671a, this.f19672b).get();
            }
        }

        a(Executor executor) {
            this.f19670b = executor;
        }

        @Override // com.google.common.cache.g
        public V d(K k7) throws Exception {
            return (V) g.this.d(k7);
        }

        @Override // com.google.common.cache.g
        public Map<K, V> e(Iterable<? extends K> iterable) throws Exception {
            return g.this.e(iterable);
        }

        @Override // com.google.common.cache.g
        public l1<V> f(K k7, V v7) throws Exception {
            m1 m1VarB = m1.b(new CallableC0231a(k7, v7));
            this.f19670b.execute(m1VarB);
            return m1VarB;
        }
    }

    private static final class b<K, V> extends g<K, V> implements Serializable {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final long f19674b = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final com.google.common.base.s<K, V> f19675a;

        public b(com.google.common.base.s<K, V> sVar) {
            this.f19675a = (com.google.common.base.s) com.google.common.base.e0.E(sVar);
        }

        @Override // com.google.common.cache.g
        public V d(K k7) {
            return this.f19675a.apply((K) com.google.common.base.e0.E(k7));
        }
    }

    public static final class c extends RuntimeException {
        public c(String str) {
            super(str);
        }
    }

    private static final class d<V> extends g<Object, V> implements Serializable {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final long f19676b = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final p0<V> f19677a;

        public d(p0<V> p0Var) {
            this.f19677a = (p0) com.google.common.base.e0.E(p0Var);
        }

        @Override // com.google.common.cache.g
        public V d(Object obj) {
            com.google.common.base.e0.E(obj);
            return this.f19677a.get();
        }
    }

    public static final class e extends UnsupportedOperationException {
        e() {
        }
    }

    protected g() {
    }

    @s1.c
    public static <K, V> g<K, V> a(g<K, V> gVar, Executor executor) {
        com.google.common.base.e0.E(gVar);
        com.google.common.base.e0.E(executor);
        return gVar.new a(executor);
    }

    public static <K, V> g<K, V> b(com.google.common.base.s<K, V> sVar) {
        return new b(sVar);
    }

    public static <V> g<Object, V> c(p0<V> p0Var) {
        return new d(p0Var);
    }

    public abstract V d(K k7) throws Exception;

    public Map<K, V> e(Iterable<? extends K> iterable) throws Exception {
        throw new e();
    }

    @s1.c
    public l1<V> f(K k7, V v7) throws Exception {
        com.google.common.base.e0.E(k7);
        com.google.common.base.e0.E(v7);
        return e1.n(d(k7));
    }
}
