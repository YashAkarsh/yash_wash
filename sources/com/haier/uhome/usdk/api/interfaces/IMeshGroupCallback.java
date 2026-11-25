package com.haier.uhome.usdk.api.interfaces;

import com.haier.uhome.usdk.api.uSDKDevice;
import com.haier.uhome.usdk.base.annotation.Keep;
import com.haier.uhome.usdk.base.api.ICallback;
import com.haier.uhome.usdk.base.api.uSDKError;

/* JADX INFO: loaded from: classes2.dex */
@Keep
public interface IMeshGroupCallback<T> extends ICallback<T> {
    @Keep
    void notifyProgress(uSDKDevice usdkdevice, uSDKError usdkerror);
}
