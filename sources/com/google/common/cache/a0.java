package com.google.common.cache;

import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
@s1.c
public final class a0 {

    /* JADX INFO: Add missing generic type declarations: [V, K] */
    static class a<K, V> implements z<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Executor f19587a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ z f19588b;

        /* JADX INFO: renamed from: com.google.common.cache.a0$a$a, reason: collision with other inner class name */
        class RunnableC0228a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ b0 f19589a;

            RunnableC0228a(b0 b0Var) {
                this.f19589a = b0Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.f19588b.a(this.f19589a);
            }
        }

        a(Executor executor, z zVar) {
            this.f19587a = executor;
            this.f19588b = zVar;
        }

        @Override // com.google.common.cache.z
        public void a(b0<K, V> b0Var) {
            this.f19587a.execute(new RunnableC0228a(b0Var));
        }
    }

    private a0() {
    }

    public static <K, V> z<K, V> a(z<K, V> zVar, Executor executor) {
        com.google.common.base.e0.E(zVar);
        com.google.common.base.e0.E(executor);
        return new a(executor, zVar);
    }
}
