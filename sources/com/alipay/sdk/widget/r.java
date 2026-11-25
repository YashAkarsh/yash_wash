package com.alipay.sdk.widget;

import android.view.View;

/* JADX INFO: loaded from: classes.dex */
class r implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ View f13898a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ q f13899b;

    r(q qVar, View view) {
        this.f13899b = qVar;
        this.f13898a = view;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f13898a.setEnabled(true);
    }
}
