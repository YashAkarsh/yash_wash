package com.haier.uhome.usdk.bind;

import android.graphics.Bitmap;
import android.os.Looper;
import com.haier.uhome.usdk.api.uSDKDevice;
import com.haier.uhome.usdk.base.api.uSDKError;

/* JADX INFO: loaded from: classes2.dex */
final class i implements IBindByCameraScanQRCodeCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private IBindByCameraScanQRCodeCallback f31588a;

    i(IBindByCameraScanQRCodeCallback iBindByCameraScanQRCodeCallback) {
        this.f31588a = iBindByCameraScanQRCodeCallback;
    }

    @Override // com.haier.uhome.usdk.base.api.ICallback
    public void onFailure(final uSDKError usdkerror) {
        if (this.f31588a == null) {
            e3.a.h("Origin callback is null!", new Object[0]);
        } else if (Looper.myLooper() != Looper.getMainLooper()) {
            com.haier.library.common.thread.a.b().c(new Runnable() { // from class: com.haier.uhome.usdk.bind.w0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f31867a.a(usdkerror);
                }
            });
        } else {
            this.f31588a.onFailure(usdkerror);
        }
    }

    @Override // com.haier.uhome.usdk.bind.IBindByCameraScanQRCodeCallback
    public void onQRCodeImageCallback(final Bitmap bitmap) {
        if (this.f31588a == null) {
            e3.a.h("Origin callback is null!", new Object[0]);
        } else if (Looper.myLooper() != Looper.getMainLooper()) {
            com.haier.library.common.thread.a.b().c(new Runnable() { // from class: com.haier.uhome.usdk.bind.v0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f31846a.a(bitmap);
                }
            });
        } else {
            this.f31588a.onQRCodeImageCallback(bitmap);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(Bitmap bitmap) {
        this.f31588a.onQRCodeImageCallback(bitmap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(uSDKDevice usdkdevice) {
        this.f31588a.onSuccess(usdkdevice);
    }

    @Override // com.haier.uhome.usdk.base.api.ICallback
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onSuccess(final uSDKDevice usdkdevice) {
        if (this.f31588a == null) {
            e3.a.h("Origin callback is null!", new Object[0]);
        } else if (Looper.myLooper() != Looper.getMainLooper()) {
            com.haier.library.common.thread.a.b().c(new Runnable() { // from class: com.haier.uhome.usdk.bind.x0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f31892a.b(usdkdevice);
                }
            });
        } else {
            this.f31588a.onSuccess(usdkdevice);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(uSDKError usdkerror) {
        this.f31588a.onFailure(usdkerror);
    }
}
