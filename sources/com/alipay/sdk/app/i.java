package com.alipay.sdk.app;

/* JADX INFO: loaded from: classes.dex */
class i implements com.alipay.sdk.util.f.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ PayTask f13604a;

    i(PayTask payTask) {
        this.f13604a = payTask;
    }

    @Override // com.alipay.sdk.util.f.a
    public void a() {
    }

    @Override // com.alipay.sdk.util.f.a
    public void b() {
        this.f13604a.dismissLoading();
    }
}
