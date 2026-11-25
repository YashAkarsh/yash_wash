package com.haier.globalwasher.mvp_api.presenter;

import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes2.dex */
public class a<T> extends Handler {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int f24796c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int f24797d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    WeakReference<T> f24798a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Handler f24799b = new HandlerC0325a();

    /* JADX INFO: renamed from: com.haier.globalwasher.mvp_api.presenter.a$a, reason: collision with other inner class name */
    class HandlerC0325a extends Handler {
        HandlerC0325a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
        }
    }

    public a(T t7) {
        this.f24798a = new WeakReference<>(t7);
    }
}
