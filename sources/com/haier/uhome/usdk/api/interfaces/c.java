package com.haier.uhome.usdk.api.interfaces;

import com.haier.uhome.usdk.api.uSDKCloudConnectionState;
import com.haier.uhome.usdk.api.uSDKDevice;
import com.haier.uhome.usdk.api.uSDKDeviceAlarm;
import com.haier.uhome.usdk.api.uSDKDeviceAttribute;
import com.haier.uhome.usdk.api.uSDKDeviceEvent;
import com.haier.uhome.usdk.api.uSDKDeviceStatusConst;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public interface c {
    void a();

    void a(uSDKCloudConnectionState usdkcloudconnectionstate);

    void a(uSDKDevice usdkdevice, uSDKDeviceStatusConst usdkdevicestatusconst, int i7);

    void a(uSDKDevice usdkdevice, ArrayList<uSDKDevice> arrayList);

    void a(uSDKDevice usdkdevice, List<uSDKDeviceEvent> list);

    void a(String str);

    void a(String str, String str2);

    void a(List<uSDKDevice> list);

    void b(uSDKDevice usdkdevice, List<uSDKDeviceAlarm> list);

    void b(String str);

    void b(String str, String str2);

    void b(List<uSDKDevice> list);

    void c(uSDKDevice usdkdevice, List<uSDKDeviceAttribute> list);

    void c(List<uSDKDevice> list);
}
