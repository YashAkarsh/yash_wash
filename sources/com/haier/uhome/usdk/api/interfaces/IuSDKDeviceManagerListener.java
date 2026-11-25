package com.haier.uhome.usdk.api.interfaces;

import com.haier.uhome.usdk.api.uSDKCloudConnectionState;
import com.haier.uhome.usdk.api.uSDKDevice;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public interface IuSDKDeviceManagerListener {
    void onCloudConnectionStateChange(uSDKCloudConnectionState usdkcloudconnectionstate);

    void onDeviceBind(String str);

    void onDeviceUnBind(String str);

    void onDevicesAdd(List<uSDKDevice> list);

    void onDevicesRemove(List<uSDKDevice> list);
}
