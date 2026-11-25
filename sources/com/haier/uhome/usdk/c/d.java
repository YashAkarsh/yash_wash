package com.haier.uhome.usdk.c;

import com.haier.uhome.usdk.base.api.ICallback;
import com.haier.uhome.usdk.base.api.uSDKError;

/* JADX INFO: loaded from: classes2.dex */
public class d<R> implements ICallback<R> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected ICallback<R> f31996b;

    public d(ICallback<R> iCallback) {
        this.f31996b = iCallback;
    }

    @Override // com.haier.uhome.usdk.base.api.ICallback
    public void onFailure(uSDKError usdkerror) {
        a(usdkerror);
    }

    @Override // com.haier.uhome.usdk.base.api.ICallback
    public void onSuccess(R r7) {
        a(r7);
    }

    private void a(final R r7) {
        com.haier.library.common.thread.a.b().c(new Runnable() { // from class: com.haier.uhome.usdk.c.m
            @Override // java.lang.Runnable
            public final void run() {
                this.f32070a.b(r7);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(Object obj) {
        ICallback<R> iCallback = this.f31996b;
        if (iCallback == null) {
            return;
        }
        iCallback.onSuccess(obj);
        this.f31996b = null;
    }

    private void a(final uSDKError usdkerror) {
        com.haier.library.common.thread.a.b().c(new Runnable() { // from class: com.haier.uhome.usdk.c.l
            @Override // java.lang.Runnable
            public final void run() {
                this.f32068a.b(usdkerror);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(uSDKError usdkerror) {
        ICallback<R> iCallback = this.f31996b;
        if (iCallback == null) {
            return;
        }
        iCallback.onFailure(usdkerror);
        this.f31996b = null;
    }
}
