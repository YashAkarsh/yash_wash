package com.google.common.util.concurrent;

import java.util.concurrent.Executor;
import java.util.concurrent.Future;

/* JADX INFO: loaded from: classes2.dex */
public interface l1<V> extends Future<V> {
    void I(Runnable runnable, Executor executor);
}
