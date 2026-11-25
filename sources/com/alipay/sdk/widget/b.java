package com.alipay.sdk.widget;

import com.alipay.sdk.widget.a.AlertDialogC0157a;

/* JADX INFO: loaded from: classes.dex */
class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ a f13854a;

    b(a aVar) {
        this.f13854a = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f13854a.f13845a == null) {
            a aVar = this.f13854a;
            a aVar2 = this.f13854a;
            aVar.f13845a = aVar2.new AlertDialogC0157a(aVar2.f13846b);
            this.f13854a.f13845a.setCancelable(this.f13854a.f13851g);
        }
        try {
            if (this.f13854a.f13845a.isShowing()) {
                return;
            }
            this.f13854a.f13845a.show();
            this.f13854a.f13852h.sendEmptyMessageDelayed(1, 15000L);
        } catch (Exception e8) {
            com.alipay.sdk.util.d.d(e8);
        }
    }
}
