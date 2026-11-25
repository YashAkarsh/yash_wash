package com.haier.uhome.usdk.b;

import com.haier.uhome.usdk.base.api.ICallback;
import com.haier.uhome.usdk.base.api.uSDKError;

/* JADX INFO: loaded from: classes2.dex */
@com.haier.uhome.usdk.base.e.a
public class a<T> implements ICallback<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ICallback<T> f31042a;

    public a(ICallback<T> iCallback) {
        this.f31042a = iCallback;
    }

    @Override // com.haier.uhome.usdk.base.api.ICallback
    public void onFailure(uSDKError usdkerror) {
        this.f31042a.onFailure(usdkerror);
    }

    @Override // com.haier.uhome.usdk.base.api.ICallback
    public void onSuccess(T t7) {
        this.f31042a.onSuccess(t7);
    }
}
