package com.google.android.gms.common.internal.service;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;

/* JADX INFO: loaded from: classes.dex */
public final class i extends com.google.android.gms.common.internal.i<m> {
    public i(Context context, Looper looper, com.google.android.gms.common.internal.f fVar, com.google.android.gms.common.api.k.b bVar, com.google.android.gms.common.api.k.c cVar) {
        super(context, looper, 39, fVar, bVar, cVar);
    }

    @Override // com.google.android.gms.common.internal.e
    protected final /* synthetic */ IInterface A(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.service.ICommonService");
        return iInterfaceQueryLocalInterface instanceof m ? (m) iInterfaceQueryLocalInterface : new m(iBinder);
    }

    @Override // com.google.android.gms.common.internal.e
    protected final String N() {
        return "com.google.android.gms.common.internal.service.ICommonService";
    }

    @Override // com.google.android.gms.common.internal.e
    public final String O() {
        return "com.google.android.gms.common.service.START";
    }
}
