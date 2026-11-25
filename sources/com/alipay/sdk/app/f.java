package com.alipay.sdk.app;

import android.content.DialogInterface;

/* JADX INFO: loaded from: classes.dex */
class f implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ d f13598a;

    f(d dVar) {
        this.f13598a = dVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i7) {
        this.f13598a.f13595b.cancel();
        this.f13598a.f13596c.f13589b = false;
        com.alipay.sdk.app.statistic.a.d("net", com.alipay.sdk.app.statistic.c.D, "1");
        k.c(k.f());
        this.f13598a.f13594a.finish();
    }
}
