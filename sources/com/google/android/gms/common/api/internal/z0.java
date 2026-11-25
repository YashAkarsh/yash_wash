package com.google.android.gms.common.api.internal;

import java.util.concurrent.locks.Lock;

/* JADX INFO: loaded from: classes.dex */
abstract class z0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ a1 f15468a;

    @c.h1
    protected abstract void a();

    @Override // java.lang.Runnable
    @c.h1
    public final void run() {
        Lock lock;
        this.f15468a.f15145b.lock();
        try {
            try {
                if (Thread.interrupted()) {
                    lock = this.f15468a.f15145b;
                } else {
                    a();
                    lock = this.f15468a.f15145b;
                }
            } catch (RuntimeException e8) {
                this.f15468a.f15144a.t(e8);
                lock = this.f15468a.f15145b;
            }
            lock.unlock();
        } catch (Throwable th) {
            this.f15468a.f15145b.unlock();
            throw th;
        }
    }
}
