package com.alipay.sdk.widget;

import android.view.animation.Animation;

/* JADX INFO: loaded from: classes.dex */
class m extends j.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ WebViewWindow f13890b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ String f13891c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ j f13892d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    m(j jVar, WebViewWindow webViewWindow, String str) {
        super(jVar, null);
        this.f13892d = jVar;
        this.f13890b = webViewWindow;
        this.f13891c = str;
    }

    @Override // com.alipay.sdk.widget.j.a, android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        this.f13892d.removeView(this.f13890b);
        this.f13892d.f13884f.f(this.f13891c);
        this.f13892d.f13882d = false;
    }
}
