package com.haier.uhome.smart.api.DeviceGroup;

import com.haier.uhome.smart.api.GroupDevice;
import com.haier.uhome.smart.api.GroupDeviceAccess;
import com.haier.uhome.smart.api.interfaces.IDeviceGroupListener;
import com.haier.uhome.smart.service.SmartDeviceService;
import com.haier.uhome.usdk.base.api.ICallback;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class DeviceGroupControl {
    private SmartDeviceService mSmartDeviceService = SmartDeviceService.getInstance();

    private static class SingletonFactory {
        private static DeviceGroupControl sInstance = new DeviceGroupControl();

        private SingletonFactory() {
        }
    }

    public static DeviceGroupControl getInstance() {
        return SingletonFactory.sInstance;
    }

    public void deviceGroupRsp(DeviceGroupReqType deviceGroupReqType, String str, int i7, int i8, ICallback<Void> iCallback) {
        this.mSmartDeviceService.deviceGroupRsp(deviceGroupReqType, str, i7, i8, iCallback);
    }

    public void fetchGroupMember(String str, ICallback<List<String>> iCallback) {
        this.mSmartDeviceService.fetchGroupMember(str, iCallback);
    }

    public void groupDeviceOnline(GroupDevice groupDevice, ICallback<String> iCallback) {
        new GroupDeviceAccess(groupDevice).deviceOnline(iCallback);
    }

    public void registeDeviceGroupListener(IDeviceGroupListener iDeviceGroupListener, ICallback<Void> iCallback) {
        this.mSmartDeviceService.registeDeviceGroupListener(iDeviceGroupListener, iCallback);
    }
}
