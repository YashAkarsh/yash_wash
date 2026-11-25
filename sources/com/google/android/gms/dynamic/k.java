package com.google.android.gms.dynamic;

import android.app.Activity;
import android.os.Bundle;

/* JADX INFO: loaded from: classes.dex */
final class k implements q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Activity f16025a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Bundle f16026b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ Bundle f16027c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ a f16028d;

    k(a aVar, Activity activity, Bundle bundle, Bundle bundle2) {
        this.f16028d = aVar;
        this.f16025a = activity;
        this.f16026b = bundle;
        this.f16027c = bundle2;
    }

    @Override // com.google.android.gms.dynamic.q
    public final void a(e eVar) {
        this.f16028d.f16015a.J(this.f16025a, this.f16026b, this.f16027c);
    }

    @Override // com.google.android.gms.dynamic.q
    public final int b() {
        return 0;
    }
}
