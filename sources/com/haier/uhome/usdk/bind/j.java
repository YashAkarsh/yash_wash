package com.haier.uhome.usdk.bind;

import com.haier.uhome.usdk.base.api.uSDKError;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes2.dex */
class j implements IBindCallback<com.haier.uhome.usdk.api.w> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private IBindCallback<com.haier.uhome.usdk.api.w> f31598a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private WeakReference<aa> f31599b;

    j(aa aaVar, IBindCallback<com.haier.uhome.usdk.api.w> iBindCallback) {
        this.f31599b = new WeakReference<>(aaVar);
        this.f31598a = iBindCallback;
    }

    private void b() {
        aa aaVar = this.f31599b.get();
        if (aaVar != null) {
            aaVar.j();
        }
    }

    @Override // com.haier.uhome.usdk.base.api.ICallback
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onSuccess(com.haier.uhome.usdk.api.w wVar) {
        IBindCallback<com.haier.uhome.usdk.api.w> iBindCallback = this.f31598a;
        if (iBindCallback != null) {
            iBindCallback.onSuccess(wVar);
        }
        b();
    }

    @Override // com.haier.uhome.usdk.bind.IBindResultCallback
    public void notifyProgress(BindProgress bindProgress, String str, String str2) {
        IBindCallback<com.haier.uhome.usdk.api.w> iBindCallback = this.f31598a;
        if (iBindCallback != null) {
            iBindCallback.notifyProgress(bindProgress, str, str2);
        }
    }

    @Override // com.haier.uhome.usdk.base.api.ICallback
    public void onFailure(uSDKError usdkerror) {
        aa aaVar = this.f31599b.get();
        if (aaVar != null) {
            usdkerror = aaVar.b(usdkerror);
        }
        IBindCallback<com.haier.uhome.usdk.api.w> iBindCallback = this.f31598a;
        if (iBindCallback != null) {
            iBindCallback.onFailure(usdkerror);
        }
        b();
    }

    @Override // com.haier.uhome.usdk.bind.IBindCallback, com.haier.uhome.usdk.bind.ISoftApResultCallback
    public void switchNetworkNotify() {
        IBindCallback<com.haier.uhome.usdk.api.w> iBindCallback = this.f31598a;
        if (iBindCallback != null) {
            iBindCallback.switchNetworkNotify();
        }
    }

    public void a() {
        if (this.f31598a != null) {
            this.f31598a = null;
        }
    }
}
