package com.haier.uhome.usdk.api.interfaces;

import com.haier.uhome.usdk.base.annotation.Keep;
import com.haier.uhome.usdk.base.api.uSDKError;

/* JADX INFO: loaded from: classes2.dex */
@Keep
public interface IProgressCallback<PT, CT> {
    @Keep
    void onComplete(CT ct, uSDKError usdkerror);

    @Keep
    void onProgress(PT pt, uSDKError usdkerror);
}
