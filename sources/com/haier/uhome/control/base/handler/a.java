package com.haier.uhome.control.base.handler;

import com.haier.library.common.util.u;
import com.haier.uhome.control.base.json.KeyValueItem;
import com.haier.uhome.control.base.json.notify.DeviceAlarmNotify;
import com.haier.uhome.usdk.base.json.BasicNotify;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public class a extends com.haier.uhome.usdk.base.c.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.haier.library.common.util.p<KeyValueItem, com.haier.uhome.control.base.api.b> f28982a = new com.haier.library.common.util.p() { // from class: com.haier.uhome.control.base.handler.o
        @Override // com.haier.library.common.util.p
        public final Object transform(Object obj) {
            return a.a((KeyValueItem) obj);
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ com.haier.uhome.control.base.api.b a(KeyValueItem keyValueItem) {
        return new com.haier.uhome.control.base.api.b(keyValueItem.getName(), keyValueItem.getValue());
    }

    @Override // com.haier.uhome.usdk.base.c.e
    protected void handleReceive(BasicNotify basicNotify) {
        DeviceAlarmNotify deviceAlarmNotify = (DeviceAlarmNotify) basicNotify;
        ArrayList arrayListA = u.a(deviceAlarmNotify.getAlarms(), this.f28982a);
        if (arrayListA != null) {
            Iterator it = arrayListA.iterator();
            while (it.hasNext()) {
                ((com.haier.uhome.control.base.api.b) it.next()).a(deviceAlarmNotify.getUniqueId());
            }
        }
        e3.a.e("notify device %s alarm msg %s", deviceAlarmNotify.getDevId(), arrayListA);
        if (com.haier.uhome.usdk.base.a.at.equals(deviceAlarmNotify.getModule())) {
            ControlBaseNotifier.getInstance().notifyDevAlarmChange("local", deviceAlarmNotify.getDevId(), deviceAlarmNotify.getElementAddr(), deviceAlarmNotify.getSubdeviceList(), arrayListA);
        }
        ControlBaseNotifier.getInstance().notifyDevAlarmChange(deviceAlarmNotify.getModule(), deviceAlarmNotify.getDevId(), deviceAlarmNotify.getElementAddr(), deviceAlarmNotify.getSubdeviceList(), arrayListA);
    }
}
