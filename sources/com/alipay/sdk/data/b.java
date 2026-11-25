package com.alipay.sdk.data;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Context f13693a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ a f13694b;

    b(a aVar, Context context) {
        this.f13694b = aVar;
        this.f13693a = context;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            com.alipay.sdk.packet.b bVarA = new com.alipay.sdk.packet.impl.b().a(this.f13693a);
            if (bVarA != null) {
                this.f13694b.g(bVarA.b());
                this.f13694b.o();
            }
        } catch (Throwable th) {
            com.alipay.sdk.util.d.d(th);
        }
    }
}
