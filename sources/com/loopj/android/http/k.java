package com.loopj.android.http;

import java.util.concurrent.Future;

/* JADX INFO: loaded from: classes2.dex */
public class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Future<?> f32555a;

    public k(Future<?> future) {
        this.f32555a = future;
    }

    public boolean a(boolean z7) {
        Future<?> future = this.f32555a;
        return future != null && future.cancel(z7);
    }

    public boolean b() {
        Future<?> future = this.f32555a;
        return future != null && future.isCancelled();
    }

    public boolean c() {
        Future<?> future = this.f32555a;
        return future == null || future.isDone();
    }
}
