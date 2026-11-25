package com.google.android.gms.location;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.location.zzaa;

/* JADX INFO: loaded from: classes.dex */
final class f0 extends com.google.android.gms.internal.location.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.google.android.gms.tasks.n f16351a;

    f0(e eVar, com.google.android.gms.tasks.n nVar) {
        this.f16351a = nVar;
    }

    @Override // com.google.android.gms.internal.location.i
    public final void Q5(zzaa zzaaVar) throws RemoteException {
        Status statusG = zzaaVar.G();
        if (statusG == null) {
            this.f16351a.d(new com.google.android.gms.common.api.b(new Status(8, "Got null status from location service")));
        } else if (statusG.p0() == 0) {
            this.f16351a.c(Boolean.TRUE);
        } else {
            this.f16351a.d(com.google.android.gms.common.internal.c.a(statusG));
        }
    }

    @Override // com.google.android.gms.internal.location.i
    public final void t() {
    }
}
