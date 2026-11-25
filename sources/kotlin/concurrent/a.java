package kotlin.concurrent;

import h5.h;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.internal.f;
import kotlin.jvm.internal.i0;
import kotlin.jvm.internal.l0;

/* JADX INFO: loaded from: classes2.dex */
@h(name = "LocksKt")
public final class a {
    @f
    private static final <T> T a(ReentrantReadWriteLock reentrantReadWriteLock, i5.a<? extends T> action) {
        l0.p(reentrantReadWriteLock, "<this>");
        l0.p(action, "action");
        ReentrantReadWriteLock.ReadLock lock = reentrantReadWriteLock.readLock();
        lock.lock();
        try {
            return action.invoke();
        } finally {
            i0.d(1);
            lock.unlock();
            i0.c(1);
        }
    }

    @f
    private static final <T> T b(Lock lock, i5.a<? extends T> action) {
        l0.p(lock, "<this>");
        l0.p(action, "action");
        lock.lock();
        try {
            return action.invoke();
        } finally {
            i0.d(1);
            lock.unlock();
            i0.c(1);
        }
    }

    @f
    private static final <T> T c(ReentrantReadWriteLock reentrantReadWriteLock, i5.a<? extends T> action) {
        l0.p(reentrantReadWriteLock, "<this>");
        l0.p(action, "action");
        ReentrantReadWriteLock.ReadLock lock = reentrantReadWriteLock.readLock();
        int i7 = 0;
        int readHoldCount = reentrantReadWriteLock.getWriteHoldCount() == 0 ? reentrantReadWriteLock.getReadHoldCount() : 0;
        for (int i8 = 0; i8 < readHoldCount; i8++) {
            lock.unlock();
        }
        ReentrantReadWriteLock.WriteLock writeLock = reentrantReadWriteLock.writeLock();
        writeLock.lock();
        try {
            return action.invoke();
        } finally {
            i0.d(1);
            while (i7 < readHoldCount) {
                lock.lock();
                i7++;
            }
            writeLock.unlock();
            i0.c(1);
        }
    }
}
