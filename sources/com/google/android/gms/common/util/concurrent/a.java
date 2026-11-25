package com.google.android.gms.common.util.concurrent;

import android.os.Handler;
import android.os.Looper;
import c.m0;
import com.google.android.gms.internal.common.t;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
@c1.a
public class a implements Executor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Handler f15988a;

    @c1.a
    public a(@m0 Looper looper) {
        this.f15988a = new t(looper);
    }

    @Override // java.util.concurrent.Executor
    public final void execute(@m0 Runnable runnable) {
        this.f15988a.post(runnable);
    }
}
