package com.google.android.gms.location;

import android.content.Context;
import android.os.Looper;

/* JADX INFO: loaded from: classes.dex */
final class c1 extends com.google.android.gms.common.api.a.AbstractC0179a<com.google.android.gms.internal.location.z, com.google.android.gms.common.api.a.d.C0181d> {
    c1() {
    }

    @Override // com.google.android.gms.common.api.a.AbstractC0179a
    public final /* bridge */ /* synthetic */ com.google.android.gms.common.api.a.f c(Context context, Looper looper, com.google.android.gms.common.internal.f fVar, com.google.android.gms.common.api.a.d.C0181d c0181d, com.google.android.gms.common.api.k.b bVar, com.google.android.gms.common.api.k.c cVar) {
        return new com.google.android.gms.internal.location.z(context, looper, bVar, cVar, "locationServices", fVar);
    }
}
