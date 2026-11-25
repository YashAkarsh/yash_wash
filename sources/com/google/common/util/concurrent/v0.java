package com.google.common.util.concurrent;

import java.lang.Exception;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated
@s1.a
@s1.c
public abstract class v0<V, X extends Exception> extends a1<V> implements j0<V, X> {

    @Deprecated
    @s1.a
    public static abstract class a<V, X extends Exception> extends v0<V, X> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final j0<V, X> f22915a;

        protected a(j0<V, X> j0Var) {
            this.f22915a = (j0) com.google.common.base.e0.E(j0Var);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.util.concurrent.v0, com.google.common.util.concurrent.a1
        /* JADX INFO: renamed from: f0, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
        public final j0<V, X> c0() {
            return this.f22915a;
        }
    }

    @Override // com.google.common.util.concurrent.j0
    @u1.a
    public V J(long j7, TimeUnit timeUnit) throws Exception {
        return d0().J(j7, timeUnit);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.common.util.concurrent.a1
    /* JADX INFO: renamed from: f0, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public abstract j0<V, X> c0();

    @Override // com.google.common.util.concurrent.j0
    @u1.a
    public V w() throws Exception {
        return d0().w();
    }
}
