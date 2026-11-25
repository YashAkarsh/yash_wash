package com.haier.library.common.thread;

import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public interface b<R> {
    R a();

    R a(Runnable runnable, R r7, long j7, TimeUnit timeUnit);

    void a(R r7);

    R b(Runnable runnable, R r7, long j7);
}
