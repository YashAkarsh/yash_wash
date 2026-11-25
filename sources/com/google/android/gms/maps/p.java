package com.google.android.gms.maps;

import com.google.android.gms.maps.internal.o1;

/* JADX INFO: loaded from: classes.dex */
final class p extends o1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final c.a f16711a;

    p(c.a aVar) {
        this.f16711a = aVar;
    }

    @Override // com.google.android.gms.maps.internal.q1
    public final void e() {
        this.f16711a.onCancel();
    }

    @Override // com.google.android.gms.maps.internal.q1
    public final void t() {
        this.f16711a.a();
    }
}
