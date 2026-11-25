package com.haier.uhome.usdk.api.b;

import com.haier.uhome.usdk.base.api.ErrorConst;
import com.haier.uhome.usdk.base.api.ICallback;
import com.haier.uhome.usdk.base.api.uSDKError;

/* JADX INFO: loaded from: classes2.dex */
public class a<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ICallback<T> f30451a;

    public a(ICallback<T> iCallback) {
        this.f30451a = iCallback;
    }

    protected ICallback<T> b() {
        return this.f30451a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(uSDKError usdkerror, Object obj) {
        if (this.f30451a == null) {
            return;
        }
        if (usdkerror.a(ErrorConst.RET_USDK_OK)) {
            this.f30451a.onSuccess(obj);
        } else {
            this.f30451a.onFailure(usdkerror);
        }
        this.f30451a = null;
    }

    public boolean a() {
        return this.f30451a != null;
    }

    protected void a(final uSDKError usdkerror, final T t7) {
        com.haier.library.common.thread.a.b().c(new Runnable() { // from class: com.haier.uhome.usdk.api.b.c
            @Override // java.lang.Runnable
            public final void run() {
                this.f30454a.b(usdkerror, t7);
            }
        });
    }
}
