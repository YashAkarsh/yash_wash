package com.google.common.util.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
@s1.a
@u1.a
@s1.c
public final class r0 implements j2 {
    @Override // com.google.common.util.concurrent.j2
    public <T> T a(Callable<T> callable, long j7, TimeUnit timeUnit) throws ExecutionException {
        return (T) c(callable, j7, timeUnit);
    }

    @Override // com.google.common.util.concurrent.j2
    public void b(Runnable runnable, long j7, TimeUnit timeUnit) {
        com.google.common.base.e0.E(runnable);
        com.google.common.base.e0.E(timeUnit);
        try {
            runnable.run();
        } catch (Error e8) {
            throw new o0(e8);
        } catch (RuntimeException e9) {
            throw new n2(e9);
        } catch (Throwable th) {
            throw new n2(th);
        }
    }

    @Override // com.google.common.util.concurrent.j2
    public <T> T c(Callable<T> callable, long j7, TimeUnit timeUnit) throws ExecutionException {
        com.google.common.base.e0.E(callable);
        com.google.common.base.e0.E(timeUnit);
        try {
            return callable.call();
        } catch (Error e8) {
            throw new o0(e8);
        } catch (RuntimeException e9) {
            throw new n2(e9);
        } catch (Exception e10) {
            throw new ExecutionException(e10);
        } catch (Throwable th) {
            throw new ExecutionException(th);
        }
    }

    @Override // com.google.common.util.concurrent.j2
    public <T> T d(T t7, Class<T> cls, long j7, TimeUnit timeUnit) {
        com.google.common.base.e0.E(t7);
        com.google.common.base.e0.E(cls);
        com.google.common.base.e0.E(timeUnit);
        return t7;
    }

    @Override // com.google.common.util.concurrent.j2
    public void e(Runnable runnable, long j7, TimeUnit timeUnit) {
        b(runnable, j7, timeUnit);
    }
}
