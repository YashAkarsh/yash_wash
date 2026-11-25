package com.alipay.sdk.widget;

import android.view.View;

/* JADX INFO: loaded from: classes.dex */
class q implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ WebViewWindow f13897a;

    q(WebViewWindow webViewWindow) {
        this.f13897a = webViewWindow;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        WebViewWindow.c cVar = this.f13897a.f13838h;
        if (cVar != null) {
            view.setEnabled(false);
            WebViewWindow.f13830k.postDelayed(new r(this, view), 256L);
            if (view == this.f13897a.f13831a) {
                cVar.h(this.f13897a);
            } else if (view == this.f13897a.f13833c) {
                cVar.d(this.f13897a);
            }
        }
    }
}
