package com.alipay.sdk.widget;

import android.content.DialogInterface;

/* JADX INFO: loaded from: classes.dex */
class o implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ n f13895a;

    o(n nVar) {
        this.f13895a = nVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i7) {
        this.f13895a.f13894b.f13883e = true;
        com.alipay.sdk.app.statistic.a.d("net", com.alipay.sdk.app.statistic.c.C, "2");
        this.f13895a.f13893a.proceed();
        dialogInterface.dismiss();
    }
}
