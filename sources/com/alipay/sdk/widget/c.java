package com.alipay.sdk.widget;

/* JADX INFO: loaded from: classes.dex */
class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ a f13855a;

    c(a aVar) {
        this.f13855a = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f13855a.f13845a == null || !this.f13855a.f13845a.isShowing()) {
            return;
        }
        try {
            this.f13855a.f13852h.removeMessages(1);
            this.f13855a.f13845a.dismiss();
        } catch (Exception e8) {
            com.alipay.sdk.util.d.d(e8);
        }
    }
}
