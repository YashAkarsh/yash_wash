package com.google.android.gms.common.internal.service;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.common.api.internal.a0;
import com.google.android.gms.common.api.internal.v;
import com.google.android.gms.common.internal.TelemetryData;
import com.google.android.gms.common.internal.b0;
import com.google.android.gms.common.internal.c0;

/* JADX INFO: loaded from: classes.dex */
public final class p extends com.google.android.gms.common.api.j<c0> implements b0 {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final com.google.android.gms.common.api.a.g<q> f15802k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final com.google.android.gms.common.api.a.AbstractC0179a<q, c0> f15803l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final com.google.android.gms.common.api.a<c0> f15804m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final /* synthetic */ int f15805n = 0;

    static {
        com.google.android.gms.common.api.a.g<q> gVar = new com.google.android.gms.common.api.a.g<>();
        f15802k = gVar;
        o oVar = new o();
        f15803l = oVar;
        f15804m = new com.google.android.gms.common.api.a<>("ClientTelemetry.API", oVar, gVar);
    }

    public p(Context context, c0 c0Var) {
        super(context, f15804m, c0Var, com.google.android.gms.common.api.j.a.f15488c);
    }

    @Override // com.google.android.gms.common.internal.b0
    public final com.google.android.gms.tasks.m<Void> a(final TelemetryData telemetryData) {
        a0.a aVarA = a0.a();
        aVarA.e(com.google.android.gms.internal.base.d.f16067a);
        aVarA.d(false);
        aVarA.c(new v() { // from class: com.google.android.gms.common.internal.service.n
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.android.gms.common.api.internal.v
            public final void accept(Object obj, Object obj2) throws RemoteException {
                TelemetryData telemetryData2 = telemetryData;
                int i7 = p.f15805n;
                ((j) ((q) obj).M()).t6(telemetryData2);
                ((com.google.android.gms.tasks.n) obj2).c(null);
            }
        });
        return g(aVarA.a());
    }
}
