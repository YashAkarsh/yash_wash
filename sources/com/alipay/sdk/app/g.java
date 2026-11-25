package com.alipay.sdk.app;

import android.app.Activity;

/* JADX INFO: loaded from: classes.dex */
final class g implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Activity f13599a;

    g(Activity activity) {
        this.f13599a = activity;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f13599a.finish();
    }
}
