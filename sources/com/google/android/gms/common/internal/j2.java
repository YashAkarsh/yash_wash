package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
public final class j2 extends com.google.android.gms.internal.common.a implements n {
    j2(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.ICancelToken");
    }

    @Override // com.google.android.gms.common.internal.n
    public final void cancel() throws RemoteException {
        y0(2, z3());
    }
}
