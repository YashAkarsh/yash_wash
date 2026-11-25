package com.google.common.util.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: classes2.dex */
@s1.a
@s1.c
public interface j2 {
    @u1.a
    <T> T a(Callable<T> callable, long j7, TimeUnit timeUnit) throws ExecutionException, TimeoutException;

    void b(Runnable runnable, long j7, TimeUnit timeUnit) throws InterruptedException, TimeoutException;

    @u1.a
    <T> T c(Callable<T> callable, long j7, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException;

    <T> T d(T t7, Class<T> cls, long j7, TimeUnit timeUnit);

    void e(Runnable runnable, long j7, TimeUnit timeUnit) throws TimeoutException;
}
