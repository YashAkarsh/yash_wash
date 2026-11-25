package com.google.android.gms.signin;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.k;

/* JADX INFO: loaded from: classes.dex */
final class b extends com.google.android.gms.common.api.a.AbstractC0179a<com.google.android.gms.signin.internal.a, a> {
    b() {
    }

    @Override // com.google.android.gms.common.api.a.AbstractC0179a
    public final /* bridge */ /* synthetic */ com.google.android.gms.common.api.a.f c(Context context, Looper looper, com.google.android.gms.common.internal.f fVar, a aVar, k.b bVar, k.c cVar) {
        return new com.google.android.gms.signin.internal.a(context, looper, true, fVar, com.google.android.gms.signin.internal.a.u0(fVar), bVar, cVar);
    }
}
