package com.google.android.gms.tasks;

/* JADX INFO: loaded from: classes.dex */
final class c0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ d0 f16783a;

    c0(d0 d0Var) {
        this.f16783a = d0Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.f16783a.f16785b) {
            d0 d0Var = this.f16783a;
            if (d0Var.f16786c != null) {
                d0Var.f16786c.a();
            }
        }
    }
}
