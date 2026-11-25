package com.google.android.gms.tasks;

/* JADX INFO: loaded from: classes.dex */
final class i0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ m f16797a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ j0 f16798b;

    i0(j0 j0Var, m mVar) {
        this.f16798b = j0Var;
        this.f16797a = mVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.f16798b.f16800b) {
            j0 j0Var = this.f16798b;
            if (j0Var.f16801c != null) {
                j0Var.f16801c.onSuccess(this.f16797a.r());
            }
        }
    }
}
