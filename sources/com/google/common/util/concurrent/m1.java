package com.google.common.util.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;

/* JADX INFO: loaded from: classes2.dex */
@s1.c
public class m1<V> extends FutureTask<V> implements l1<V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final p0 f22857a;

    m1(Callable<V> callable) {
        super(callable);
        this.f22857a = new p0();
    }

    public static <V> m1<V> a(Runnable runnable, V v7) {
        return new m1<>(runnable, v7);
    }

    public static <V> m1<V> b(Callable<V> callable) {
        return new m1<>(callable);
    }

    @Override // com.google.common.util.concurrent.l1
    public void I(Runnable runnable, Executor executor) {
        this.f22857a.a(runnable, executor);
    }

    @Override // java.util.concurrent.FutureTask
    protected void done() {
        this.f22857a.b();
    }

    m1(Runnable runnable, V v7) {
        super(runnable, v7);
        this.f22857a = new p0();
    }
}
