package com.alipay.sdk.widget;

import android.content.DialogInterface;

/* JADX INFO: loaded from: classes.dex */
class p implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ n f13896a;

    p(n nVar) {
        this.f13896a = nVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i7) {
        this.f13896a.f13893a.cancel();
        this.f13896a.f13894b.f13883e = false;
        com.alipay.sdk.app.statistic.a.d("net", com.alipay.sdk.app.statistic.c.D, "2");
        com.alipay.sdk.app.k.c(com.alipay.sdk.app.k.f());
        this.f13896a.f13894b.f13858a.finish();
    }
}
