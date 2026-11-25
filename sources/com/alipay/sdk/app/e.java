package com.alipay.sdk.app;

import android.content.DialogInterface;

/* JADX INFO: loaded from: classes.dex */
class e implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ d f13597a;

    e(d dVar) {
        this.f13597a = dVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i7) {
        this.f13597a.f13596c.f13589b = true;
        com.alipay.sdk.app.statistic.a.d("net", com.alipay.sdk.app.statistic.c.C, "1");
        this.f13597a.f13595b.proceed();
        dialogInterface.dismiss();
    }
}
