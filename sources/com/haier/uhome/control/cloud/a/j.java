package com.haier.uhome.control.cloud.a;

import android.text.TextUtils;
import com.haier.uhome.control.cloud.json.notify.DeviceAddNotify;
import com.haier.uhome.control.cloud.json.notify.DeviceCloudAddNotify;
import com.haier.uhome.usdk.base.json.BasicNotify;

/* JADX INFO: loaded from: classes2.dex */
public class j extends com.haier.uhome.usdk.base.c.e {
    @Override // com.haier.uhome.usdk.base.c.e
    protected void handleReceive(BasicNotify basicNotify) {
        DeviceAddNotify deviceAddNotify = (DeviceAddNotify) basicNotify;
        if (TextUtils.isEmpty(deviceAddNotify.getUplusId())) {
            e3.a.e("receive a null typeId device so ignore this device id = " + deviceAddNotify.getDevId(), new Object[0]);
            return;
        }
        if (!(deviceAddNotify instanceof DeviceCloudAddNotify)) {
            e3.a.h("notify cloud device added with wrong Type" + basicNotify.getClass().getSimpleName(), new Object[0]);
            return;
        }
        DeviceCloudAddNotify deviceCloudAddNotify = (DeviceCloudAddNotify) deviceAddNotify;
        com.haier.uhome.usdk.base.api.f fVarB = com.haier.uhome.usdk.base.api.g.a().b(deviceCloudAddNotify.getDevId());
        if (fVarB != null) {
            fVarB.a(deviceCloudAddNotify.getChannel());
            fVarB.d(deviceCloudAddNotify.getProductCode());
            fVarB.b(deviceCloudAddNotify.getBindTimestamp());
            fVarB.b(deviceCloudAddNotify.getUplusId());
            fVarB.s().a(deviceCloudAddNotify.isGroup());
            fVarB.s().a(deviceCloudAddNotify.getGroupId());
            fVarB.s().a(deviceCloudAddNotify.getElementAddr());
            fVarB.q().a(deviceCloudAddNotify.getDevVer());
        }
        h.a().a(deviceAddNotify.getDevId(), deviceAddNotify.getOnline(), deviceAddNotify.getUplusId(), deviceAddNotify.getStateCode());
        if (deviceCloudAddNotify.getElementAddr() != 0) {
            h.a().a(deviceCloudAddNotify.getDevId(), deviceCloudAddNotify.getElementAddr(), deviceCloudAddNotify.isGroup(), deviceCloudAddNotify.getUplusId());
        }
        e3.a.e("notify cloud device added (deviceId = %s, online = %d, uplusId = %s, elementAddr = %d, groupId = %s", deviceAddNotify.getDevId(), Integer.valueOf(deviceAddNotify.getOnline()), deviceAddNotify.getUplusId(), Integer.valueOf(deviceCloudAddNotify.getElementAddr()), deviceCloudAddNotify.getGroupId());
    }
}
