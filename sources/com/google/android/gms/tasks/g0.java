package com.google.android.gms.tasks;

/* JADX INFO: loaded from: classes.dex */
final class g0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ m f16792a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ h0 f16793b;

    g0(h0 h0Var, m mVar) {
        this.f16793b = h0Var;
        this.f16792a = mVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.f16793b.f16795b) {
            h0 h0Var = this.f16793b;
            if (h0Var.f16796c != null) {
                h0Var.f16796c.c((Exception) com.google.android.gms.common.internal.u.k(this.f16792a.q()));
            }
        }
    }
}
