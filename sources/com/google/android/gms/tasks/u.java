package com.google.android.gms.tasks;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
final class u implements v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final CountDownLatch f16828a = new CountDownLatch(1);

    private u() {
    }

    @Override // com.google.android.gms.tasks.e
    public final void a() {
        this.f16828a.countDown();
    }

    public final void b() throws InterruptedException {
        this.f16828a.await();
    }

    @Override // com.google.android.gms.tasks.g
    public final void c(@c.m0 Exception exc) {
        this.f16828a.countDown();
    }

    public final boolean d(long j7, TimeUnit timeUnit) throws InterruptedException {
        return this.f16828a.await(j7, timeUnit);
    }

    @Override // com.google.android.gms.tasks.h
    public final void onSuccess(Object obj) {
        this.f16828a.countDown();
    }

    /* synthetic */ u(t tVar) {
    }
}
