package com.haier.uhome.control.base.handler;

import com.haier.library.common.util.u;
import com.haier.uhome.control.base.json.KeyValueItem;
import com.haier.uhome.control.base.json.entity.DeviceBleAdvEpp;
import com.haier.uhome.control.base.json.entity.NameAndValue;
import com.haier.uhome.control.base.json.notify.DeviceBleAdvEppNotify;
import com.haier.uhome.usdk.base.json.BasicNotify;

/* JADX INFO: loaded from: classes2.dex */
public class c extends com.haier.uhome.usdk.base.c.e {
    private DeviceBleAdvEpp a(DeviceBleAdvEppNotify deviceBleAdvEppNotify) {
        DeviceBleAdvEpp deviceBleAdvEpp = new DeviceBleAdvEpp();
        deviceBleAdvEpp.setDevId(deviceBleAdvEppNotify.getDevId());
        deviceBleAdvEpp.setBleDevId(deviceBleAdvEppNotify.getBleDevId());
        deviceBleAdvEpp.setUplusId(deviceBleAdvEppNotify.getUplusId());
        deviceBleAdvEpp.setLongProduceCode(deviceBleAdvEppNotify.getLongProductCode());
        deviceBleAdvEpp.setProtocol(deviceBleAdvEppNotify.getProtocol());
        deviceBleAdvEpp.setUniqueId(deviceBleAdvEppNotify.getUniqueId());
        deviceBleAdvEpp.setEppType(deviceBleAdvEppNotify.getEppType());
        deviceBleAdvEpp.setEppValue(u.a(deviceBleAdvEppNotify.getEppValue(), new com.haier.library.common.util.p() { // from class: com.haier.uhome.control.base.handler.q
            @Override // com.haier.library.common.util.p
            public final Object transform(Object obj) {
                return c.a((KeyValueItem) obj);
            }
        }));
        return deviceBleAdvEpp;
    }

    @Override // com.haier.uhome.usdk.base.c.e
    protected void handleReceive(BasicNotify basicNotify) {
        e3.a.e("DeviceBleAdvEppNotifyHandler : %s", basicNotify);
        DeviceBleAdvEppNotify deviceBleAdvEppNotify = (DeviceBleAdvEppNotify) basicNotify;
        if (deviceBleAdvEppNotify.getDupAdv() == 1) {
            return;
        }
        ControlBaseNotifier.getInstance().notifyBleAdvEpp(a(deviceBleAdvEppNotify));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ NameAndValue a(KeyValueItem keyValueItem) {
        return new NameAndValue(keyValueItem.getName(), keyValueItem.getValue());
    }
}
