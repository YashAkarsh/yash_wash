package com.haier.uhome.usdk.api.interfaces;

import com.haier.uhome.usdk.api.uSDKDevice;

/* JADX INFO: loaded from: classes2.dex */
public interface IuSDKDeviceListenerWithResource extends IuSDKDeviceListener {
    void onReceive(uSDKDevice usdkdevice, String str, byte[] bArr);

    void onReceiveDecodeResource(uSDKDevice usdkdevice, String str, String str2);
}
