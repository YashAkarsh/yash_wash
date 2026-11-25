package com.haier.uhome.smart.json;

import com.haier.uhome.smart.json.notify.ConfigProgressNotify;
import com.haier.uhome.smart.json.notify.ConfigResultNotify;
import com.haier.uhome.smart.json.notify.DeviceAuthTokenNotify;
import com.haier.uhome.smart.json.notify.DeviceBindResultNotify;
import com.haier.uhome.smart.json.notify.DeviceBindStatusNotify;
import com.haier.uhome.smart.json.notify.DeviceBindWindowNotify;
import com.haier.uhome.smart.json.notify.DeviceBusinessNotify;
import com.haier.uhome.smart.json.notify.DeviceCloudMsgNotify;
import com.haier.uhome.smart.json.notify.DeviceCloudStateNotify;
import com.haier.uhome.smart.json.notify.DeviceDepairingNotify;
import com.haier.uhome.smart.json.notify.DeviceGetLocalKeyNotify;
import com.haier.uhome.smart.json.notify.DeviceGroupControlNotify;
import com.haier.uhome.smart.json.notify.DeviceGroupMemberNotify;
import com.haier.uhome.smart.json.notify.DeviceOpNotify;
import com.haier.uhome.smart.json.notify.DeviceOtaDownloadFinishNotify;
import com.haier.uhome.smart.json.notify.DeviceOtaDownloadNotify;
import com.haier.uhome.smart.json.notify.DeviceOtaDownloadStartNotify;
import com.haier.uhome.smart.json.notify.DevicePairingNotify;
import com.haier.uhome.smart.json.notify.DeviceReadNotify;
import com.haier.uhome.smart.json.notify.DeviceRegisterResNotify;
import com.haier.uhome.smart.json.notify.DeviceResChannelStatusNotify;
import com.haier.uhome.smart.json.notify.DeviceUnbindStatusNotify;
import com.haier.uhome.smart.json.notify.DeviceWriteNotify;
import com.haier.uhome.smart.json.notify.NoumenonDeviceNotify;
import com.haier.uhome.smart.json.notify.QueryDeviceBindStatusNotify;
import com.haier.uhome.smart.json.notify.WifiAddDeviceNotify;
import com.haier.uhome.smart.json.notify.WifiDelDeviceNotify;
import com.haier.uhome.smart.json.notify.WifiScanStatusNotify;
import com.haier.uhome.usdk.base.json.ProtocolProcessor;

/* JADX INFO: loaded from: classes2.dex */
public class SmartProtocol {
    public static void register() {
        ProtocolProcessor.registerProtocol(ProtocolConst.NOTIFY_DEVICE_READ, DeviceReadNotify.class);
        ProtocolProcessor.registerProtocol(ProtocolConst.NOTIFY_DEVICE_WRITE, DeviceWriteNotify.class);
        ProtocolProcessor.registerProtocol(ProtocolConst.NOTIFY_DEVICE_OP, DeviceOpNotify.class);
        ProtocolProcessor.registerProtocol(ProtocolConst.NOTIFY_DEVICE_CLOUD_STATE, DeviceCloudStateNotify.class);
        ProtocolProcessor.registerProtocol(ProtocolConst.NOTIFY_DEVICE_BUSINESS, DeviceBusinessNotify.class);
        ProtocolProcessor.registerProtocol(ProtocolConst.NOTIFY_DEVICE_BIND_WINDOW, DeviceBindWindowNotify.class);
        ProtocolProcessor.registerProtocol(ProtocolConst.NOTIFY_DEVICE_GET_LOCAL_KEY, DeviceGetLocalKeyNotify.class);
        ProtocolProcessor.registerProtocol(ProtocolConst.NOTIFY_DEVICE_CLOUD_MSG, DeviceCloudMsgNotify.class);
        ProtocolProcessor.registerProtocol("noumenon_device_req", NoumenonDeviceNotify.class);
        ProtocolProcessor.registerProtocol("noumenon_device_attr_read_req", DeviceReadNotify.class);
        ProtocolProcessor.registerProtocol("noumenon_device_attr_write_req", DeviceWriteNotify.class);
        ProtocolProcessor.registerProtocol("noumenon_device_oper_req", DeviceOpNotify.class);
        ProtocolProcessor.registerProtocol(ProtocolConst.NOTIFY_DEVICE_AUTH_TOKEN, DeviceAuthTokenNotify.class);
        ProtocolProcessor.registerProtocol(ProtocolConst.NOTIFY_DEVICE_BIND_RESULT, DeviceBindResultNotify.class);
        ProtocolProcessor.registerProtocol(ProtocolConst.NOTIFY_WIFI_SCAN_STATUS, WifiScanStatusNotify.class);
        ProtocolProcessor.registerProtocol(ProtocolConst.NOTIFY_WIFI_ADD_DEVICE, WifiAddDeviceNotify.class);
        ProtocolProcessor.registerProtocol(ProtocolConst.NOTIFY_WIFI_DEL_DEVICE, WifiDelDeviceNotify.class);
        ProtocolProcessor.registerProtocol(ProtocolConst.NOTIFY_CONFIG_PROGRESS, ConfigProgressNotify.class);
        ProtocolProcessor.registerProtocol(ProtocolConst.NOTIFY_CONFIG_RESULT, ConfigResultNotify.class);
        ProtocolProcessor.registerProtocol(ProtocolConst.NOTIFY_DEVICE_REGISTER_RES, DeviceRegisterResNotify.class);
        ProtocolProcessor.registerProtocol(ProtocolConst.NOTIFY_DEVICE_RES_CHANNEL_STATUS, DeviceResChannelStatusNotify.class);
        ProtocolProcessor.registerProtocol(ProtocolConst.NOTIFY_DEVICE_OTA_DOWNLOAD, DeviceOtaDownloadNotify.class);
        ProtocolProcessor.registerProtocol(ProtocolConst.NOTIFY_DEVICE_OTA_DOWNLOAD_START, DeviceOtaDownloadStartNotify.class);
        ProtocolProcessor.registerProtocol(ProtocolConst.NOTIFY_DEVICE_OTA_DOWNLOAD_FINISH, DeviceOtaDownloadFinishNotify.class);
        ProtocolProcessor.registerProtocol(ProtocolConst.NOTIFY_DEVICE_PAIRING, DevicePairingNotify.class);
        ProtocolProcessor.registerProtocol(ProtocolConst.NOTIFY_DEVICE_DEPAIRING, DeviceDepairingNotify.class);
        ProtocolProcessor.registerProtocol(ProtocolConst.NOTIFY_DEVICE_BIND_STATUS, DeviceBindStatusNotify.class);
        ProtocolProcessor.registerProtocol(ProtocolConst.NOTIFY_DEVICE_UNBIND_STATUS, DeviceUnbindStatusNotify.class);
        ProtocolProcessor.registerProtocol(ProtocolConst.NOTIFY_DEVICE_QUERY_BIND_STATUS, QueryDeviceBindStatusNotify.class);
        ProtocolProcessor.registerProtocol(ProtocolConst.NOTIFY_DEVICE_GROUP_CONTROL, DeviceGroupControlNotify.class);
        ProtocolProcessor.registerProtocol(ProtocolConst.NOTIFY_DEVICE_GROUP_MEMBER, DeviceGroupMemberNotify.class);
    }
}
