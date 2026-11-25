package com.google.android.gms.location;

import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
final class e0 extends j0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ com.google.android.gms.common.api.internal.n f16336b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ e f16337c;

    e0(e eVar, com.google.android.gms.common.api.internal.n nVar) {
        this.f16337c = eVar;
        this.f16336b = nVar;
    }

    @Override // com.google.android.gms.common.api.internal.v
    public final /* bridge */ /* synthetic */ void accept(com.google.android.gms.internal.location.z zVar, com.google.android.gms.tasks.n<Boolean> nVar) throws RemoteException {
        com.google.android.gms.internal.location.z zVar2 = zVar;
        com.google.android.gms.tasks.n<Boolean> nVar2 = nVar;
        if (a()) {
            f0 f0Var = new f0(this.f16337c, nVar2);
            try {
                com.google.android.gms.common.api.internal.n.a<k> aVarB = this.f16336b.b();
                if (aVarB != null) {
                    zVar2.C0(aVarB, f0Var);
                }
            } catch (RuntimeException e8) {
                nVar2.d(e8);
            }
        }
    }
}
