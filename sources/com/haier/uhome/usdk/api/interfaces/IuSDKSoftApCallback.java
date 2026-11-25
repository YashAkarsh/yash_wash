package com.haier.uhome.usdk.api.interfaces;

import com.haier.uhome.usdk.api.uSDKDevice;
import com.haier.uhome.usdk.api.uSDKErrorConst;

/* JADX INFO: loaded from: classes2.dex */
public interface IuSDKSoftApCallback {
    void onSoftApConfigCallback(uSDKDevice usdkdevice, uSDKErrorConst usdkerrorconst);

    void sendConfigInfoSuccess();
}
