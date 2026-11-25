package com.alipay.sdk.widget;

import android.view.animation.Animation;

/* JADX INFO: loaded from: classes.dex */
class l extends j.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ WebViewWindow f13888b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ j f13889c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    l(j jVar, WebViewWindow webViewWindow) {
        super(jVar, null);
        this.f13889c = jVar;
        this.f13888b = webViewWindow;
    }

    @Override // com.alipay.sdk.widget.j.a, android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        this.f13888b.c();
        this.f13889c.f13882d = false;
    }
}
