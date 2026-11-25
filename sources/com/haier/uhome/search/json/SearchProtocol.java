package com.haier.uhome.search.json;

import com.haier.uhome.search.json.notify.DeviceBleAdvUnboundNotify;
import com.haier.uhome.search.json.notify.DeviceBleEventNotify;
import com.haier.uhome.search.json.notify.DeviceDeleteNotify;
import com.haier.uhome.search.json.notify.DeviceUpdateNotify;
import com.haier.uhome.search.json.notify.SmartConfigAckNotify;
import com.haier.uhome.search.json.notify.UnconnectedDevSearchNotify;
import com.haier.uhome.usdk.base.json.ProtocolProcessor;

/* JADX INFO: loaded from: classes2.dex */
public class SearchProtocol {
    public static void register() {
        ProtocolProcessor.registerProtocol(ProtocolConst.NOTIFY_DEVICE_UPDATE, DeviceUpdateNotify.class);
        ProtocolProcessor.registerProtocol("device_add_notify", DeviceUpdateNotify.class);
        ProtocolProcessor.registerProtocol("device_delete_notify", DeviceDeleteNotify.class);
        ProtocolProcessor.registerProtocol(ProtocolConst.NOTIFY_SMART_ACK, SmartConfigAckNotify.class);
        ProtocolProcessor.registerProtocol(ProtocolConst.DEVICE_BLE_EVENT_NOTIFY, DeviceBleEventNotify.class);
        ProtocolProcessor.registerProtocol(ProtocolConst.DEVICE_BLE_ADV_UNBOUND_NOTIFY, DeviceBleAdvUnboundNotify.class);
        ProtocolProcessor.registerProtocol(ProtocolConst.NOTIFY_SEARCH_UNCONNECTED_DEV, UnconnectedDevSearchNotify.class);
    }
}
