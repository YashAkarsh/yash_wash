package com.haier.uhome.control.local.json;

import com.haier.uhome.control.local.json.notify.BleHistoryNotify;
import com.haier.uhome.control.local.json.notify.BleOtaModuleProgressNotify;
import com.haier.uhome.control.local.json.notify.BleOtaProgressNotify;
import com.haier.uhome.control.local.json.notify.BleRealTimeNotify;
import com.haier.uhome.control.local.json.notify.ConfigFileReadyNotify;
import com.haier.uhome.control.local.json.notify.ModuleOTAProgressNotify;
import com.haier.uhome.control.local.json.req.AddDeviceToGroupReq;
import com.haier.uhome.control.local.json.req.CancelGetBleHistoryReq;
import com.haier.uhome.control.local.json.req.CreateGroupReq;
import com.haier.uhome.control.local.json.req.DelGroupReq;
import com.haier.uhome.control.local.json.req.EndDeviceBleOtaReq;
import com.haier.uhome.control.local.json.req.GetBleHistoryReq;
import com.haier.uhome.control.local.json.req.GetBleOtaInfoReq;
import com.haier.uhome.control.local.json.req.GetDeviceVersionInfoReq;
import com.haier.uhome.control.local.json.req.OnlineMeshDeviceListReq;
import com.haier.uhome.control.local.json.req.RemoveDeviceFromGroupReq;
import com.haier.uhome.control.local.json.req.StartDeviceBleOtaReq;
import com.haier.uhome.control.local.json.req.StartOTAReq;
import com.haier.uhome.control.local.json.resp.AddDeviceToGroupResp;
import com.haier.uhome.control.local.json.resp.CancelGetBleHistoryResp;
import com.haier.uhome.control.local.json.resp.CreateGroupResp;
import com.haier.uhome.control.local.json.resp.DelGroupResp;
import com.haier.uhome.control.local.json.resp.EndDeviceBleOtaResp;
import com.haier.uhome.control.local.json.resp.GetBleHistoryResp;
import com.haier.uhome.control.local.json.resp.GetBleOtaInfoResp;
import com.haier.uhome.control.local.json.resp.GetDeviceVersionInfoResp;
import com.haier.uhome.control.local.json.resp.OnlineMeshDeviceListResp;
import com.haier.uhome.control.local.json.resp.RemoveDeviceFromGroupResp;
import com.haier.uhome.control.local.json.resp.StartDeviceBleOtaResp;
import com.haier.uhome.control.local.json.resp.StartOTAResp;
import com.haier.uhome.usdk.base.json.ProtocolProcessor;

/* JADX INFO: loaded from: classes2.dex */
public class ControlBaseProtocol {
    public static void registerBLE() {
        ProtocolProcessor.registerProtocol(ProtocolConst.RESP_DEVICE_GET_BLE_HISTORY, GetBleHistoryResp.class);
        ProtocolProcessor.registerProtocol(ProtocolConst.RESP_DEVICE_CANCEL_BLE_HISTORY, CancelGetBleHistoryResp.class);
        ProtocolProcessor.registerProtocol(ProtocolConst.RESP_MODULE_START_OTA, StartOTAResp.class);
        ProtocolProcessor.registerProtocol(ProtocolConst.RESP_DEVICE_BLE_GET_OTA_INFO, GetBleOtaInfoResp.class);
        ProtocolProcessor.registerProtocol(ProtocolConst.RESP_START_DEVICE_BLE_OTA, StartDeviceBleOtaResp.class);
        ProtocolProcessor.registerProtocol(ProtocolConst.RESP_END_DEVICE_BLE_OTA, EndDeviceBleOtaResp.class);
        ProtocolProcessor.registerProtocol(ProtocolConst.RESP_CREATE_GROUP, CreateGroupResp.class);
        ProtocolProcessor.registerProtocol(ProtocolConst.RESP_ADD_DEVICE_TO_GROUP, AddDeviceToGroupResp.class);
        ProtocolProcessor.registerProtocol(ProtocolConst.RESP_REMOVE_DEVICE_FROM_GROUP, RemoveDeviceFromGroupResp.class);
        ProtocolProcessor.registerProtocol(ProtocolConst.RESP_DEL_GROUP, DelGroupResp.class);
        ProtocolProcessor.registerProtocol(ProtocolConst.RESP_DEVICE_GET_VERSION, GetDeviceVersionInfoResp.class);
        ProtocolProcessor.registerProtocol(ProtocolConst.RESP_ONLINE_MESH_DEVICE_LIST, OnlineMeshDeviceListResp.class);
        ProtocolProcessor.registerProtocolChecker(GetBleHistoryReq.class, GetBleHistoryResp.class);
        ProtocolProcessor.registerProtocolChecker(CancelGetBleHistoryReq.class, CancelGetBleHistoryResp.class);
        ProtocolProcessor.registerProtocolChecker(StartOTAReq.class, StartOTAResp.class);
        ProtocolProcessor.registerProtocolChecker(GetBleOtaInfoReq.class, GetBleOtaInfoResp.class);
        ProtocolProcessor.registerProtocolChecker(StartDeviceBleOtaReq.class, StartDeviceBleOtaResp.class);
        ProtocolProcessor.registerProtocolChecker(EndDeviceBleOtaReq.class, EndDeviceBleOtaResp.class);
        ProtocolProcessor.registerProtocolChecker(CreateGroupReq.class, CreateGroupResp.class);
        ProtocolProcessor.registerProtocolChecker(AddDeviceToGroupReq.class, AddDeviceToGroupResp.class);
        ProtocolProcessor.registerProtocolChecker(RemoveDeviceFromGroupReq.class, RemoveDeviceFromGroupResp.class);
        ProtocolProcessor.registerProtocolChecker(DelGroupReq.class, DelGroupResp.class);
        ProtocolProcessor.registerProtocolChecker(GetDeviceVersionInfoReq.class, GetDeviceVersionInfoResp.class);
        ProtocolProcessor.registerProtocolChecker(OnlineMeshDeviceListReq.class, OnlineMeshDeviceListResp.class);
        ProtocolProcessor.registerProtocol(ProtocolConst.NOTIFY_BLE_HISTORY, BleHistoryNotify.class);
        ProtocolProcessor.registerProtocol(ProtocolConst.NOTIFY_BLE_REAL_TIME, BleRealTimeNotify.class);
        ProtocolProcessor.registerProtocol(ProtocolConst.NOTIFY_MODULE_OTA_PROGRESS, ModuleOTAProgressNotify.class);
        ProtocolProcessor.registerProtocol(ProtocolConst.NOTIFY_DEVICE_BLE_OTA_PROGRESS, BleOtaProgressNotify.class);
        ProtocolProcessor.registerProtocol(ProtocolConst.NOTIFY_DEVICE_BLE_OTA_MODULE_PROGRESS, BleOtaModuleProgressNotify.class);
        ProtocolProcessor.registerProtocol(ProtocolConst.NOTIFY_CONFIG_FILE_READY, ConfigFileReadyNotify.class);
    }
}
