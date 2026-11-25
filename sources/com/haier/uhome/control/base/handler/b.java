package com.haier.uhome.control.base.handler;

import com.haier.library.common.util.u;
import com.haier.uhome.control.base.json.KeyValueItem;
import com.haier.uhome.control.base.json.notify.DeviceAttrNotify;
import com.haier.uhome.usdk.base.json.BasicNotify;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class b extends com.haier.uhome.usdk.base.c.e {
    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ com.haier.uhome.control.base.api.d a(KeyValueItem keyValueItem) {
        return new com.haier.uhome.control.base.api.d(keyValueItem.getName(), keyValueItem.getValue());
    }

    @Override // com.haier.uhome.usdk.base.c.e
    protected void handleReceive(BasicNotify basicNotify) {
        DeviceAttrNotify deviceAttrNotify = (DeviceAttrNotify) basicNotify;
        boolean z7 = false;
        e3.a.e("notify device %s attr msg %s", deviceAttrNotify.getDevId(), deviceAttrNotify);
        ArrayList<com.haier.uhome.control.base.api.d> arrayListA = u.a(deviceAttrNotify.getAttrs(), new com.haier.library.common.util.p() { // from class: com.haier.uhome.control.base.handler.p
            @Override // com.haier.library.common.util.p
            public final Object transform(Object obj) {
                return b.a((KeyValueItem) obj);
            }
        });
        String module = deviceAttrNotify.getModule();
        com.haier.uhome.usdk.base.api.f fVarA = com.haier.uhome.usdk.base.api.g.a().a(deviceAttrNotify.getDevId());
        if (com.haier.uhome.usdk.base.a.ao.equals(module) && fVarA != null && com.haier.uhome.usdk.base.api.e.a(fVarA.n())) {
            z7 = true;
        }
        for (com.haier.uhome.control.base.api.d dVar : arrayListA) {
            dVar.a(a(deviceAttrNotify.getUniqueId()));
            if (z7) {
                dVar.b(System.currentTimeMillis());
            }
        }
        if (com.haier.uhome.usdk.base.a.at.equals(deviceAttrNotify.getModule())) {
            ControlBaseNotifier.getInstance().notifyDevAttrChange("local", deviceAttrNotify.getDevId(), deviceAttrNotify.getElementAddr(), deviceAttrNotify.getSubdeviceList(), arrayListA);
        }
        ControlBaseNotifier.getInstance().notifyDevAttrChange(module, deviceAttrNotify.getDevId(), deviceAttrNotify.getElementAddr(), deviceAttrNotify.getSubdeviceList(), arrayListA);
    }

    public static long a(String str) {
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException unused) {
            e3.a.v("NumberFormat num = %s", str);
            return 0L;
        }
    }
}
