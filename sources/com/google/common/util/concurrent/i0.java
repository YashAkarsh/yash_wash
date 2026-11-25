package com.google.common.util.concurrent;

import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes2.dex */
@s1.b(emulated = true)
public final class i0 {

    /* JADX INFO: Add missing generic type declarations: [T] */
    static class a<T> implements Callable<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Object f22763a;

        a(Object obj) {
            this.f22763a = obj;
        }

        @Override // java.util.concurrent.Callable
        public T call() {
            return (T) this.f22763a;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    static class b<T> implements m<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ q1 f22764a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Callable f22765b;

        b(q1 q1Var, Callable callable) {
            this.f22764a = q1Var;
            this.f22765b = callable;
        }

        @Override // com.google.common.util.concurrent.m
        public l1<T> call() throws Exception {
            return this.f22764a.submit((Callable) this.f22765b);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    static class c<T> implements Callable<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.google.common.base.p0 f22766a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Callable f22767b;

        c(com.google.common.base.p0 p0Var, Callable callable) {
            this.f22766a = p0Var;
            this.f22767b = callable;
        }

        @Override // java.util.concurrent.Callable
        public T call() throws Exception {
            Thread threadCurrentThread = Thread.currentThread();
            String name = threadCurrentThread.getName();
            boolean zF = i0.f((String) this.f22766a.get(), threadCurrentThread);
            try {
                return (T) this.f22767b.call();
            } finally {
                if (zF) {
                    i0.f(name, threadCurrentThread);
                }
            }
        }
    }

    static class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.google.common.base.p0 f22768a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Runnable f22769b;

        d(com.google.common.base.p0 p0Var, Runnable runnable) {
            this.f22768a = p0Var;
            this.f22769b = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            Thread threadCurrentThread = Thread.currentThread();
            String name = threadCurrentThread.getName();
            boolean zF = i0.f((String) this.f22768a.get(), threadCurrentThread);
            try {
                this.f22769b.run();
            } finally {
                if (zF) {
                    i0.f(name, threadCurrentThread);
                }
            }
        }
    }

    private i0() {
    }

    @s1.a
    @s1.c
    public static <T> m<T> b(Callable<T> callable, q1 q1Var) {
        com.google.common.base.e0.E(callable);
        com.google.common.base.e0.E(q1Var);
        return new b(q1Var, callable);
    }

    public static <T> Callable<T> c(T t7) {
        return new a(t7);
    }

    @s1.c
    static Runnable d(Runnable runnable, com.google.common.base.p0<String> p0Var) {
        com.google.common.base.e0.E(p0Var);
        com.google.common.base.e0.E(runnable);
        return new d(p0Var, runnable);
    }

    @s1.c
    static <T> Callable<T> e(Callable<T> callable, com.google.common.base.p0<String> p0Var) {
        com.google.common.base.e0.E(p0Var);
        com.google.common.base.e0.E(callable);
        return new c(p0Var, callable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @s1.c
    public static boolean f(String str, Thread thread) {
        try {
            thread.setName(str);
            return true;
        } catch (SecurityException unused) {
            return false;
        }
    }
}
