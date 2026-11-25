package com.haier.uhome.smart.handler;

import com.haier.uhome.smart.json.notify.DeviceGroupMemberNotify;
import com.haier.uhome.usdk.base.json.BasicNotify;

/* JADX INFO: loaded from: classes2.dex */
public class DeviceGroupMemberNotifyHandler extends com.haier.uhome.usdk.base.c.e {
    @Override // com.haier.uhome.usdk.base.c.e
    protected void handleReceive(BasicNotify basicNotify) {
        e3.a.o("notify device group member msg: " + basicNotify.toString(), new Object[0]);
        DeviceGroupMemberNotify deviceGroupMemberNotify = (DeviceGroupMemberNotify) basicNotify;
        SmartDeviceNotifier.getInstance().notifyDeviceGroupMember(deviceGroupMemberNotify.getGroupId(), deviceGroupMemberNotify.getErrNo(), deviceGroupMemberNotify.getMemberList());
        e3.a.o("notify device group member msg: " + deviceGroupMemberNotify.toString(), new Object[0]);
    }
}
