package com.haier.uhome.usdk.api.interfaces;

import com.haier.uhome.usdk.api.uSDKErrorConst;
import com.haier.uhome.usdk.base.annotation.Keep;

/* JADX INFO: loaded from: classes2.dex */
@Keep
public interface IuSDKResultCallback<RESULT> {
    @Keep
    void onFail(uSDKErrorConst usdkerrorconst);

    @Keep
    void onSuccess(RESULT result);
}
