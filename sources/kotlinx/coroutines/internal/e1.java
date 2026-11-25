package kotlinx.coroutines.internal;

import java.util.WeakHashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* JADX INFO: loaded from: classes3.dex */
final class e1 extends k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @a7.d
    public static final e1 f36976a = new e1();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @a7.d
    private static final ReentrantReadWriteLock f36977b = new ReentrantReadWriteLock();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @a7.d
    private static final WeakHashMap<Class<? extends Throwable>, i5.l<Throwable, Throwable>> f36978c = new WeakHashMap<>();

    private e1() {
    }

    @Override // kotlinx.coroutines.internal.k
    @a7.d
    public i5.l<Throwable, Throwable> a(@a7.d Class<? extends Throwable> cls) {
        ReentrantReadWriteLock reentrantReadWriteLock = f36977b;
        ReentrantReadWriteLock.ReadLock lock = reentrantReadWriteLock.readLock();
        lock.lock();
        try {
            i5.l<Throwable, Throwable> lVar = f36978c.get(cls);
            lock.unlock();
            if (lVar != null) {
                return lVar;
            }
            ReentrantReadWriteLock.ReadLock lock2 = reentrantReadWriteLock.readLock();
            int i7 = 0;
            int readHoldCount = reentrantReadWriteLock.getWriteHoldCount() == 0 ? reentrantReadWriteLock.getReadHoldCount() : 0;
            int i8 = 0;
            while (i8 < readHoldCount) {
                i8++;
                lock2.unlock();
            }
            ReentrantReadWriteLock.WriteLock writeLock = reentrantReadWriteLock.writeLock();
            writeLock.lock();
            try {
                WeakHashMap<Class<? extends Throwable>, i5.l<Throwable, Throwable>> weakHashMap = f36978c;
                i5.l<Throwable, Throwable> lVar2 = weakHashMap.get(cls);
                if (lVar2 != null) {
                    while (i7 < readHoldCount) {
                        i7++;
                        lock2.lock();
                    }
                    writeLock.unlock();
                    return lVar2;
                }
                i5.l<Throwable, Throwable> lVarB = n.b(cls);
                weakHashMap.put(cls, lVarB);
                while (i7 < readHoldCount) {
                    i7++;
                    lock2.lock();
                }
                writeLock.unlock();
                return lVarB;
            } catch (Throwable th) {
                while (i7 < readHoldCount) {
                    i7++;
                    lock2.lock();
                }
                writeLock.unlock();
                throw th;
            }
        } catch (Throwable th2) {
            lock.unlock();
            throw th2;
        }
    }
}
