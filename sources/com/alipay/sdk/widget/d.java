package com.alipay.sdk.widget;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* JADX INFO: loaded from: classes.dex */
class d extends Handler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ a f13856a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    d(a aVar, Looper looper) {
        super(looper);
        this.f13856a = aVar;
    }

    @Override // android.os.Handler
    public void dispatchMessage(Message message) {
        this.f13856a.i();
    }
}
