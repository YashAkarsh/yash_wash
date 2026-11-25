package com.haier.uhome.control.local.a;

import android.util.Base64;
import com.haier.uhome.control.local.json.notify.BleHistoryNotify;
import com.haier.uhome.control.local.json.notify.BleRealTimeNotify;
import com.haier.uhome.usdk.base.json.BasicNotify;

/* JADX INFO: loaded from: classes2.dex */
public class a extends com.haier.uhome.usdk.base.c.e {
    @Override // com.haier.uhome.usdk.base.c.e
    protected void handleReceive(BasicNotify basicNotify) {
        e3.a.e("notify ble data", basicNotify);
        if (basicNotify instanceof BleHistoryNotify) {
            BleHistoryNotify bleHistoryNotify = (BleHistoryNotify) basicNotify;
            e.a().a(bleHistoryNotify.getDevId(), bleHistoryNotify.getCurrentCount(), bleHistoryNotify.getTotalCount(), Base64.decode(bleHistoryNotify.getHistoryData(), 0));
        } else if (basicNotify instanceof BleRealTimeNotify) {
            BleRealTimeNotify bleRealTimeNotify = (BleRealTimeNotify) basicNotify;
            e.a().a(bleRealTimeNotify.getDevId(), Base64.decode(bleRealTimeNotify.getRealTimeData(), 0));
        } else {
            e3.a.v("BleNotifyHandler with unknown notify " + basicNotify, new Object[0]);
        }
    }
}
