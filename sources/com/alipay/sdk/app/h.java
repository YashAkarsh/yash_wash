package com.alipay.sdk.app;

/* JADX INFO: loaded from: classes.dex */
class h implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f13600a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ boolean f13601b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ H5PayCallback f13602c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ PayTask f13603d;

    h(PayTask payTask, String str, boolean z7, H5PayCallback h5PayCallback) {
        this.f13603d = payTask;
        this.f13600a = str;
        this.f13601b = z7;
        this.f13602c = h5PayCallback;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f13602c.onPayResult(this.f13603d.h5Pay(this.f13600a, this.f13601b));
    }
}
