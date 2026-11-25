package com.google.android.gms.internal.location;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.Feature;
import com.google.android.gms.location.h2;

/* JADX INFO: loaded from: classes.dex */
public class a1 extends com.google.android.gms.common.internal.i<m> {
    private final String O;
    protected final e0<m> P;

    public a1(Context context, Looper looper, com.google.android.gms.common.api.k.b bVar, com.google.android.gms.common.api.k.c cVar, String str, com.google.android.gms.common.internal.f fVar) {
        super(context, looper, 23, fVar, bVar, cVar);
        this.P = new z0(this);
        this.O = str;
    }

    @Override // com.google.android.gms.common.internal.e
    protected final /* bridge */ /* synthetic */ IInterface A(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
        return iInterfaceQueryLocalInterface instanceof m ? (m) iInterfaceQueryLocalInterface : new l(iBinder);
    }

    @Override // com.google.android.gms.common.internal.e
    public final Feature[] D() {
        return h2.f16363f;
    }

    @Override // com.google.android.gms.common.internal.e
    protected final Bundle I() {
        Bundle bundle = new Bundle();
        bundle.putString("client_name", this.O);
        return bundle;
    }

    @Override // com.google.android.gms.common.internal.e
    protected final String N() {
        return "com.google.android.gms.location.internal.IGoogleLocationManagerService";
    }

    @Override // com.google.android.gms.common.internal.e
    protected final String O() {
        return "com.google.android.location.internal.GoogleLocationManagerService.START";
    }

    @Override // com.google.android.gms.common.internal.e, com.google.android.gms.common.api.a.f
    public final int r() {
        return 11717000;
    }
}
