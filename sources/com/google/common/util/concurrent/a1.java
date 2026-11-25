package com.google.common.util.concurrent;

import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
@s1.b
@u1.a
public abstract class a1<V> extends z0<V> implements l1<V> {

    public static abstract class a<V> extends a1<V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final l1<V> f22532a;

        protected a(l1<V> l1Var) {
            this.f22532a = (l1) com.google.common.base.e0.E(l1Var);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.util.concurrent.a1, com.google.common.util.concurrent.z0
        /* JADX INFO: renamed from: e0, reason: merged with bridge method [inline-methods] */
        public final l1<V> c0() {
            return this.f22532a;
        }
    }

    protected a1() {
    }

    @Override // com.google.common.util.concurrent.l1
    public void I(Runnable runnable, Executor executor) {
        c0().I(runnable, executor);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.common.util.concurrent.z0
    /* JADX INFO: renamed from: e0 */
    public abstract l1<? extends V> c0();
}
