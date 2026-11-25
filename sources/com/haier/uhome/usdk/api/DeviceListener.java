package com.haier.uhome.usdk.api;

import com.haier.uhome.control.cloud.api.FOTAStatusInfo;
import com.haier.uhome.usdk.api.interfaces.IuSDKDeviceListenerWithResource;
import com.haier.uhome.usdk.base.annotation.Keep;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@Keep
public abstract class DeviceListener implements IuSDKDeviceListenerWithResource {
    @Keep
    public void onBLEHistoryData(uSDKDevice usdkdevice, int i7, int i8, byte[] bArr) {
        e3.a.v(" please implementing interfaces<onBLEHistoryData> that business needs", new Object[0]);
    }

    @Keep
    public void onBLERealTimeData(uSDKDevice usdkdevice, byte[] bArr) {
        e3.a.v(" please implementing interfaces<onBLERealTimeData> that business needs", new Object[0]);
    }

    @Keep
    public void onBoardFOTAStatusChange(uSDKDevice usdkdevice, FOTAStatusInfo fOTAStatusInfo) {
        e3.a.v(" please implementing interfaces<onBoardFOTAStatusChange> that business needs", new Object[0]);
    }

    @Override // com.haier.uhome.usdk.api.interfaces.IuSDKDeviceListener
    public /* synthetic */ void onDeviceEvent(uSDKDevice usdkdevice, List list) {
        q3.b.a(this, usdkdevice, list);
    }

    @Override // com.haier.uhome.usdk.api.interfaces.IuSDKDeviceListenerWithResource
    @Keep
    public void onReceive(uSDKDevice usdkdevice, String str, byte[] bArr) {
        e3.a.v(" please implementing interfaces<onReceive> that business needs", new Object[0]);
    }

    @Override // com.haier.uhome.usdk.api.interfaces.IuSDKDeviceListenerWithResource
    public void onReceiveDecodeResource(uSDKDevice usdkdevice, String str, String str2) {
        e3.a.v("please implementing interfaces<onReceiveDecodeResource> that business needs", new Object[0]);
    }

    @Keep
    public void onUpdateFaultInformation(uSDKFaultInformation usdkfaultinformation) {
        e3.a.v("please implementing interfaces<onUpdateFaultInformation> that business needs", new Object[0]);
    }
}
