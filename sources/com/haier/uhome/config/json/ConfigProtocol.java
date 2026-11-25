package com.haier.uhome.config.json;

import com.haier.uhome.config.json.notify.BleConfigProcessNotify;
import com.haier.uhome.config.json.notify.ConfigProcessNotify;
import com.haier.uhome.config.json.notify.ConfigStateNotify;
import com.haier.uhome.config.json.notify.ModuleConfigStateNotify;
import com.haier.uhome.config.json.notify.NewDirectLinkBindProgressNotify;
import com.haier.uhome.config.json.req.BleCfgSetSimpleParamReq;
import com.haier.uhome.config.json.req.BleConfigReq;
import com.haier.uhome.config.json.req.BleMeshDeviceInfoReq;
import com.haier.uhome.config.json.req.ConfigDeviceByBleReq;
import com.haier.uhome.config.json.req.ConfigGetSmartlinkErrNoReq;
import com.haier.uhome.config.json.req.DeviceBleSecurityAuthReq;
import com.haier.uhome.config.json.req.DeviceGetWifiInfoReq;
import com.haier.uhome.config.json.req.NewDirectLinkBindReq;
import com.haier.uhome.config.json.req.NoPasswordRxAckReq;
import com.haier.uhome.config.json.req.SoftapConfigReq;
import com.haier.uhome.config.json.req.SoftapGetConfigInfoReq;
import com.haier.uhome.config.json.req.StopConfigDeviceByBleReq;
import com.haier.uhome.config.json.resp.BleCfgSetSimpleParamResp;
import com.haier.uhome.config.json.resp.BleConfigResp;
import com.haier.uhome.config.json.resp.BleMeshDeviceInfoResp;
import com.haier.uhome.config.json.resp.ConfigDeviceByBleResp;
import com.haier.uhome.config.json.resp.ConfigGetSmartlinkErrNoResp;
import com.haier.uhome.config.json.resp.DeviceBleSecurityAuthResp;
import com.haier.uhome.config.json.resp.DeviceGetWifiInfoResp;
import com.haier.uhome.config.json.resp.NewDirectLinkBindResp;
import com.haier.uhome.config.json.resp.NoPasswordRxAckResp;
import com.haier.uhome.config.json.resp.SoftapConfigResp;
import com.haier.uhome.config.json.resp.SoftapGetConfigInfoResp;
import com.haier.uhome.config.json.resp.StopConfigDeviceByBleResp;
import com.haier.uhome.usdk.base.json.ProtocolProcessor;

/* JADX INFO: loaded from: classes2.dex */
public class ConfigProtocol {
    public static void registerBle() {
        ProtocolProcessor.registerProtocol(ProtocolConst.NOTIFY_BLE_CONFIG_PROGRESS, BleConfigProcessNotify.class);
        ProtocolProcessor.registerProtocol(ProtocolConst.RESP_BLE_CONFIG, BleConfigResp.class);
        ProtocolProcessor.registerProtocol(ProtocolConst.RESP_CFG_SET_SIMPLE_PARAM, BleCfgSetSimpleParamResp.class);
        ProtocolProcessor.registerProtocol(ProtocolConst.RESP_DEVICE_BLE_SECURITY_AUTH, DeviceBleSecurityAuthResp.class);
        ProtocolProcessor.registerProtocolChecker(BleConfigReq.class, BleConfigResp.class);
        ProtocolProcessor.registerProtocolChecker(BleCfgSetSimpleParamReq.class, BleConfigResp.class);
        ProtocolProcessor.registerProtocolChecker(DeviceBleSecurityAuthReq.class, DeviceBleSecurityAuthResp.class);
        ProtocolProcessor.registerProtocol(ProtocolConst.NOTIFY_CONFIG_STATE_PROGRESS, ConfigProcessNotify.class);
        ProtocolProcessor.registerProtocol(ProtocolConst.NOTIFY_UCOM_CONFIG_STATE, ConfigStateNotify.class);
        ProtocolProcessor.registerProtocol(ProtocolConst.NOTIFY_MODULE_CONFIG_STATE, ModuleConfigStateNotify.class);
        ProtocolProcessor.registerProtocol(ProtocolConst.RESP_CONFIG_DEVICE_BY_BLE, ConfigDeviceByBleResp.class);
        ProtocolProcessor.registerProtocol(ProtocolConst.RESP_STOP_BLE_CONFIG, StopConfigDeviceByBleResp.class);
        ProtocolProcessor.registerProtocolChecker(ConfigDeviceByBleReq.class, ConfigDeviceByBleResp.class);
        ProtocolProcessor.registerProtocolChecker(StopConfigDeviceByBleReq.class, StopConfigDeviceByBleResp.class);
    }

    public static void registerBleMesh() {
        ProtocolProcessor.registerProtocol(ProtocolConst.RESP_BLE_MESH_DEVICE_INFO, BleMeshDeviceInfoResp.class);
        ProtocolProcessor.registerProtocolChecker(BleMeshDeviceInfoReq.class, BleMeshDeviceInfoResp.class);
    }

    public static void registerNewDirectLink() {
        ProtocolProcessor.registerProtocol(ProtocolConst.NOTIFY_NEW_DIRECT_LINK_BIND_PROGRESS, NewDirectLinkBindProgressNotify.class);
        ProtocolProcessor.registerProtocol(ProtocolConst.RESP_NEW_DIRECT_LINK_BIND, NewDirectLinkBindResp.class);
        ProtocolProcessor.registerProtocolChecker(NewDirectLinkBindReq.class, NewDirectLinkBindResp.class);
    }

    public static void registerNoPassword() {
        ProtocolProcessor.registerProtocol(ProtocolConst.RESP_NO_PASS_RX_ACK, NoPasswordRxAckResp.class);
        ProtocolProcessor.registerProtocolChecker(NoPasswordRxAckReq.class, NoPasswordRxAckResp.class);
    }

    public static void registerPasswordAutoFilling() {
        ProtocolProcessor.registerProtocol(ProtocolConst.RESP_DEVICE_GET_WIFI_INFO, DeviceGetWifiInfoResp.class);
        ProtocolProcessor.registerProtocolChecker(DeviceGetWifiInfoReq.class, DeviceGetWifiInfoResp.class);
    }

    public static void registerSmartlink() {
        ProtocolProcessor.registerProtocol(ProtocolConst.RESP_SMARTLINK_ERRINFO_GET, ConfigGetSmartlinkErrNoResp.class);
        ProtocolProcessor.registerProtocolChecker(ConfigGetSmartlinkErrNoReq.class, ConfigGetSmartlinkErrNoResp.class);
    }

    public static void registerSoftAP() {
        ProtocolProcessor.registerProtocol(ProtocolConst.RESP_SOFTAP_APLIST_GET, SoftapGetConfigInfoResp.class);
        ProtocolProcessor.registerProtocol(ProtocolConst.RESP_SOFTAP_CONFIG, SoftapConfigResp.class);
        ProtocolProcessor.registerProtocolChecker(SoftapGetConfigInfoReq.class, SoftapGetConfigInfoResp.class);
        ProtocolProcessor.registerProtocolChecker(SoftapConfigReq.class, SoftapConfigResp.class);
    }
}
