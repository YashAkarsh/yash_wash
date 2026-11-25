package com.google.common.util.concurrent;

import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes2.dex */
@u1.a
@s1.c
public abstract class b1 extends x0 implements q1 {
    protected b1() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.common.util.concurrent.x0
    /* JADX INFO: renamed from: e0, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public abstract q1 c0();

    @Override // com.google.common.util.concurrent.x0, java.util.concurrent.ExecutorService, com.google.common.util.concurrent.q1
    public <T> l1<T> submit(Callable<T> callable) {
        return z0().submit((Callable) callable);
    }

    @Override // com.google.common.util.concurrent.x0, java.util.concurrent.ExecutorService, com.google.common.util.concurrent.q1
    public l1<?> submit(Runnable runnable) {
        return z0().submit(runnable);
    }

    @Override // com.google.common.util.concurrent.x0, java.util.concurrent.ExecutorService, com.google.common.util.concurrent.q1
    public <T> l1<T> submit(Runnable runnable, T t7) {
        return z0().submit(runnable, (Object) t7);
    }
}
