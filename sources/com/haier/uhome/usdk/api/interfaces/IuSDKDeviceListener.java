package com.haier.uhome.usdk.api.interfaces;

import com.haier.uhome.usdk.api.uSDKDevice;
import com.haier.uhome.usdk.api.uSDKDeviceAlarm;
import com.haier.uhome.usdk.api.uSDKDeviceAttribute;
import com.haier.uhome.usdk.api.uSDKDeviceEvent;
import com.haier.uhome.usdk.api.uSDKDeviceStatusConst;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public interface IuSDKDeviceListener {
    void onDeviceAlarm(uSDKDevice usdkdevice, List<uSDKDeviceAlarm> list);

    void onDeviceAttributeChange(uSDKDevice usdkdevice, List<uSDKDeviceAttribute> list);

    void onDeviceBaseInfoChange(uSDKDevice usdkdevice);

    void onDeviceEvent(uSDKDevice usdkdevice, List<uSDKDeviceEvent> list);

    void onDeviceOnlineStatusChange(uSDKDevice usdkdevice, uSDKDeviceStatusConst usdkdevicestatusconst, int i7);

    void onSubDeviceListChange(uSDKDevice usdkdevice, ArrayList<uSDKDevice> arrayList);
}
