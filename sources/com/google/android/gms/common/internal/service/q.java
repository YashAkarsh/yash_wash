package com.google.android.gms.common.internal.service;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import c.m0;
import c.o0;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.internal.c0;

/* JADX INFO: loaded from: classes.dex */
public final class q extends com.google.android.gms.common.internal.i<j> {
    private final c0 O;

    public q(Context context, Looper looper, com.google.android.gms.common.internal.f fVar, c0 c0Var, com.google.android.gms.common.api.internal.f fVar2, com.google.android.gms.common.api.internal.q qVar) {
        super(context, looper, 270, fVar, fVar2, qVar);
        this.O = c0Var;
    }

    @Override // com.google.android.gms.common.internal.e
    @o0
    protected final /* synthetic */ IInterface A(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.service.IClientTelemetryService");
        return iInterfaceQueryLocalInterface instanceof j ? (j) iInterfaceQueryLocalInterface : new j(iBinder);
    }

    @Override // com.google.android.gms.common.internal.e
    public final Feature[] D() {
        return com.google.android.gms.internal.base.d.f16068b;
    }

    @Override // com.google.android.gms.common.internal.e
    protected final Bundle I() {
        return this.O.b();
    }

    @Override // com.google.android.gms.common.internal.e
    @m0
    protected final String N() {
        return "com.google.android.gms.common.internal.service.IClientTelemetryService";
    }

    @Override // com.google.android.gms.common.internal.e
    @m0
    protected final String O() {
        return "com.google.android.gms.common.telemetry.service.START";
    }

    @Override // com.google.android.gms.common.internal.e
    protected final boolean R() {
        return true;
    }

    @Override // com.google.android.gms.common.internal.e, com.google.android.gms.common.api.a.f
    public final int r() {
        return 203400000;
    }
}
