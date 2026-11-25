package com.google.android.gms.common.api.internal;

/* JADX INFO: loaded from: classes.dex */
final class a4 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ e0 f15167a;

    a4(e0 e0Var) {
        this.f15167a = e0Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f15167a.f15201o.lock();
        try {
            e0.C(this.f15167a);
        } finally {
            this.f15167a.f15201o.unlock();
        }
    }
}
