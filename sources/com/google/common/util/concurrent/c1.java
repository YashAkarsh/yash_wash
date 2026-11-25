package com.google.common.util.concurrent;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/* JADX INFO: loaded from: classes2.dex */
abstract class c1 implements Lock {
    c1() {
    }

    abstract Lock a();

    @Override // java.util.concurrent.locks.Lock
    public void lock() {
        a().lock();
    }

    @Override // java.util.concurrent.locks.Lock
    public void lockInterruptibly() throws InterruptedException {
        a().lockInterruptibly();
    }

    @Override // java.util.concurrent.locks.Lock
    public Condition newCondition() {
        return a().newCondition();
    }

    @Override // java.util.concurrent.locks.Lock
    public boolean tryLock() {
        return a().tryLock();
    }

    @Override // java.util.concurrent.locks.Lock
    public void unlock() {
        a().unlock();
    }

    @Override // java.util.concurrent.locks.Lock
    public boolean tryLock(long j7, TimeUnit timeUnit) throws InterruptedException {
        return a().tryLock(j7, timeUnit);
    }
}
