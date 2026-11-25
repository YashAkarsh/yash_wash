package com.google.android.gms.tasks;

import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
final class p0 implements Executor {
    p0() {
    }

    @Override // java.util.concurrent.Executor
    public final void execute(@c.m0 Runnable runnable) {
        runnable.run();
    }
}
