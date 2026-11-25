package com.google.android.gms.tasks;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
final class q0 implements Executor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Handler f16815a = new h1.a(Looper.getMainLooper());

    @Override // java.util.concurrent.Executor
    public final void execute(@c.m0 Runnable runnable) {
        this.f16815a.post(runnable);
    }
}
