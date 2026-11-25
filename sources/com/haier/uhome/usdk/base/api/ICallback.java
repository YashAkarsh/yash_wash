package com.haier.uhome.usdk.base.api;

import com.haier.uhome.usdk.base.annotation.Keep;

/* JADX INFO: loaded from: classes2.dex */
@Keep
public interface ICallback<R> {
    @Keep
    void onFailure(uSDKError usdkerror);

    @Keep
    void onSuccess(R r7);
}
