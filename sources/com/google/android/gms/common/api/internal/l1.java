package com.google.android.gms.common.api.internal;

import java.util.concurrent.locks.Lock;

/* JADX INFO: loaded from: classes.dex */
abstract class l1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final k1 f15321a;

    protected l1(k1 k1Var) {
        this.f15321a = k1Var;
    }

    protected abstract void a();

    public final void b(n1 n1Var) {
        Lock lock;
        n1Var.f15340a.lock();
        try {
            if (n1Var.f15350m != this.f15321a) {
                lock = n1Var.f15340a;
            } else {
                a();
                lock = n1Var.f15340a;
            }
            lock.unlock();
        } catch (Throwable th) {
            n1Var.f15340a.unlock();
            throw th;
        }
    }
}
