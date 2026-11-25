package com.alipay.sdk.util;

import com.alipay.sdk.app.AlipayResultActivity;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: loaded from: classes.dex */
class h implements AlipayResultActivity.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ CountDownLatch f13802a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ f f13803b;

    h(f fVar, CountDownLatch countDownLatch) {
        this.f13803b = fVar;
        this.f13802a = countDownLatch;
    }

    @Override // com.alipay.sdk.app.AlipayResultActivity.a
    public void a(int i7, String str, String str2) {
        this.f13803b.f13799g = com.alipay.sdk.app.k.b(i7, str, str2);
        this.f13802a.countDown();
    }
}
