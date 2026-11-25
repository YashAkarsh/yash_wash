package com.google.android.gms.maps;

import com.google.android.gms.maps.internal.w1;

/* JADX INFO: loaded from: classes.dex */
final class g1 extends w1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ d f16517a;

    g1(c cVar, d dVar) {
        this.f16517a = dVar;
    }

    @Override // com.google.android.gms.maps.internal.c
    public final void d1(com.google.android.gms.maps.internal.w wVar) {
        this.f16517a.a(new z0(this, wVar));
    }

    @Override // com.google.android.gms.maps.internal.c
    public final void deactivate() {
        this.f16517a.deactivate();
    }
}
