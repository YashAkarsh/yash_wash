package com.google.android.gms.dynamic;

import android.os.Bundle;

/* JADX INFO: loaded from: classes.dex */
final class l implements q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Bundle f16029a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ a f16030b;

    l(a aVar, Bundle bundle) {
        this.f16030b = aVar;
        this.f16029a = bundle;
    }

    @Override // com.google.android.gms.dynamic.q
    public final void a(e eVar) {
        this.f16030b.f16015a.p(this.f16029a);
    }

    @Override // com.google.android.gms.dynamic.q
    public final int b() {
        return 1;
    }
}
