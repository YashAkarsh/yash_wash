package com.google.common.util.concurrent;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.locks.Condition;

/* JADX INFO: loaded from: classes2.dex */
@s1.a
@s1.b(emulated = true)
public final class p2 {
    private p2() {
    }

    @s1.c
    public static void a(CountDownLatch countDownLatch) {
        boolean z7 = false;
        while (true) {
            try {
                countDownLatch.await();
                break;
            } catch (InterruptedException unused) {
                z7 = true;
            } catch (Throwable th) {
                if (z7) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z7) {
            Thread.currentThread().interrupt();
        }
    }

    @u1.a
    @s1.c
    public static boolean b(CountDownLatch countDownLatch, long j7, TimeUnit timeUnit) {
        boolean zAwait;
        boolean z7 = false;
        try {
            long nanos = timeUnit.toNanos(j7);
            long jNanoTime = System.nanoTime() + nanos;
            while (true) {
                try {
                    zAwait = countDownLatch.await(nanos, TimeUnit.NANOSECONDS);
                    break;
                } catch (InterruptedException unused) {
                    z7 = true;
                    nanos = jNanoTime - System.nanoTime();
                }
            }
            if (z7) {
                Thread.currentThread().interrupt();
            }
            return zAwait;
        } catch (Throwable th) {
            if (z7) {
                Thread.currentThread().interrupt();
            }
            throw th;
        }
    }

    @s1.c
    public static boolean c(Condition condition, long j7, TimeUnit timeUnit) {
        boolean zAwait;
        boolean z7 = false;
        try {
            long nanos = timeUnit.toNanos(j7);
            long jNanoTime = System.nanoTime() + nanos;
            while (true) {
                try {
                    zAwait = condition.await(nanos, TimeUnit.NANOSECONDS);
                    break;
                } catch (InterruptedException unused) {
                    z7 = true;
                    nanos = jNanoTime - System.nanoTime();
                }
            }
            if (z7) {
                Thread.currentThread().interrupt();
            }
            return zAwait;
        } catch (Throwable th) {
            if (z7) {
                Thread.currentThread().interrupt();
            }
            throw th;
        }
    }

    @u1.a
    public static <V> V d(Future<V> future) throws ExecutionException {
        V v7;
        boolean z7 = false;
        while (true) {
            try {
                v7 = future.get();
                break;
            } catch (InterruptedException unused) {
                z7 = true;
            } catch (Throwable th) {
                if (z7) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z7) {
            Thread.currentThread().interrupt();
        }
        return v7;
    }

    @u1.a
    @s1.c
    public static <V> V e(Future<V> future, long j7, TimeUnit timeUnit) throws ExecutionException, TimeoutException {
        V v7;
        boolean z7 = false;
        try {
            long nanos = timeUnit.toNanos(j7);
            long jNanoTime = System.nanoTime() + nanos;
            while (true) {
                try {
                    v7 = future.get(nanos, TimeUnit.NANOSECONDS);
                    break;
                } catch (InterruptedException unused) {
                    z7 = true;
                    nanos = jNanoTime - System.nanoTime();
                }
            }
            if (z7) {
                Thread.currentThread().interrupt();
            }
            return v7;
        } catch (Throwable th) {
            if (z7) {
                Thread.currentThread().interrupt();
            }
            throw th;
        }
    }

    @s1.c
    public static void f(Thread thread) {
        boolean z7 = false;
        while (true) {
            try {
                thread.join();
                break;
            } catch (InterruptedException unused) {
                z7 = true;
            } catch (Throwable th) {
                if (z7) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z7) {
            Thread.currentThread().interrupt();
        }
    }

    @s1.c
    public static void g(Thread thread, long j7, TimeUnit timeUnit) {
        com.google.common.base.e0.E(thread);
        boolean z7 = false;
        try {
            long nanos = timeUnit.toNanos(j7);
            long jNanoTime = System.nanoTime() + nanos;
            while (true) {
                try {
                    TimeUnit.NANOSECONDS.timedJoin(thread, nanos);
                    break;
                } catch (InterruptedException unused) {
                    z7 = true;
                    nanos = jNanoTime - System.nanoTime();
                }
            }
            if (z7) {
                Thread.currentThread().interrupt();
            }
        } catch (Throwable th) {
            if (z7) {
                Thread.currentThread().interrupt();
            }
            throw th;
        }
    }

    @s1.c
    public static <E> void h(BlockingQueue<E> blockingQueue, E e8) {
        boolean z7 = false;
        while (true) {
            try {
                blockingQueue.put(e8);
                break;
            } catch (InterruptedException unused) {
                z7 = true;
            } catch (Throwable th) {
                if (z7) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z7) {
            Thread.currentThread().interrupt();
        }
    }

    @s1.c
    public static void i(long j7, TimeUnit timeUnit) {
        boolean z7 = false;
        try {
            long nanos = timeUnit.toNanos(j7);
            long jNanoTime = System.nanoTime() + nanos;
            while (true) {
                try {
                    TimeUnit.NANOSECONDS.sleep(nanos);
                    break;
                } catch (InterruptedException unused) {
                    z7 = true;
                    nanos = jNanoTime - System.nanoTime();
                }
            }
            if (z7) {
                Thread.currentThread().interrupt();
            }
        } catch (Throwable th) {
            if (z7) {
                Thread.currentThread().interrupt();
            }
            throw th;
        }
    }

    @s1.c
    public static <E> E j(BlockingQueue<E> blockingQueue) {
        E eTake;
        boolean z7 = false;
        while (true) {
            try {
                eTake = blockingQueue.take();
                break;
            } catch (InterruptedException unused) {
                z7 = true;
            } catch (Throwable th) {
                if (z7) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z7) {
            Thread.currentThread().interrupt();
        }
        return eTake;
    }

    @s1.c
    public static boolean k(Semaphore semaphore, int i7, long j7, TimeUnit timeUnit) {
        boolean zTryAcquire;
        boolean z7 = false;
        try {
            long nanos = timeUnit.toNanos(j7);
            long jNanoTime = System.nanoTime() + nanos;
            while (true) {
                try {
                    zTryAcquire = semaphore.tryAcquire(i7, nanos, TimeUnit.NANOSECONDS);
                    break;
                } catch (InterruptedException unused) {
                    z7 = true;
                    nanos = jNanoTime - System.nanoTime();
                }
            }
            if (z7) {
                Thread.currentThread().interrupt();
            }
            return zTryAcquire;
        } catch (Throwable th) {
            if (z7) {
                Thread.currentThread().interrupt();
            }
            throw th;
        }
    }

    @s1.c
    public static boolean l(Semaphore semaphore, long j7, TimeUnit timeUnit) {
        return k(semaphore, 1, j7, timeUnit);
    }
}
