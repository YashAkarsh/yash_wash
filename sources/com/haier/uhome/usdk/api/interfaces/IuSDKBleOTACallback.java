package com.haier.uhome.usdk.api.interfaces;

import com.haier.uhome.usdk.api.uSDKErrorConst;
import com.haier.uhome.usdk.base.api.uSDKError;

/* JADX INFO: loaded from: classes2.dex */
public interface IuSDKBleOTACallback extends IuSDKCallback {
    @Override // com.haier.uhome.usdk.api.interfaces.IuSDKCallback
    void onCallback(uSDKErrorConst usdkerrorconst);

    void onCallback(uSDKError usdkerror);

    void progressNotify(String str, int i7);
}
