package com.google.common.util.concurrent;

import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;

/* JADX INFO: loaded from: classes2.dex */
abstract class w0 implements Condition {
    w0() {
    }

    abstract Condition a();

    @Override // java.util.concurrent.locks.Condition
    public void await() throws InterruptedException {
        a().await();
    }

    @Override // java.util.concurrent.locks.Condition
    public long awaitNanos(long j7) throws InterruptedException {
        return a().awaitNanos(j7);
    }

    @Override // java.util.concurrent.locks.Condition
    public void awaitUninterruptibly() {
        a().awaitUninterruptibly();
    }

    @Override // java.util.concurrent.locks.Condition
    public boolean awaitUntil(Date date) throws InterruptedException {
        return a().awaitUntil(date);
    }

    @Override // java.util.concurrent.locks.Condition
    public void signal() {
        a().signal();
    }

    @Override // java.util.concurrent.locks.Condition
    public void signalAll() {
        a().signalAll();
    }

    @Override // java.util.concurrent.locks.Condition
    public boolean await(long j7, TimeUnit timeUnit) throws InterruptedException {
        return a().await(j7, timeUnit);
    }
}
