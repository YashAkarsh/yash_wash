package com.google.android.gms.common.api;

/* JADX INFO: loaded from: classes.dex */
final class a0 implements n.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ d f15082a;

    a0(d dVar) {
        this.f15082a = dVar;
    }

    @Override // com.google.android.gms.common.api.n.a
    public final void a(Status status) {
        synchronized (this.f15082a.f15090v) {
            if (this.f15082a.g()) {
                return;
            }
            if (status.v0()) {
                this.f15082a.f15088t = true;
            } else if (!status.G0()) {
                this.f15082a.f15087s = true;
            }
            this.f15082a.f15086r--;
            d dVar = this.f15082a;
            if (dVar.f15086r == 0) {
                if (dVar.f15088t) {
                    super/*com.google.android.gms.common.api.internal.BasePendingResult*/.f();
                } else {
                    Status status2 = dVar.f15087s ? new Status(13) : Status.f15063f;
                    d dVar2 = this.f15082a;
                    dVar2.o(new e(status2, dVar2.f15089u));
                }
            }
        }
    }
}
