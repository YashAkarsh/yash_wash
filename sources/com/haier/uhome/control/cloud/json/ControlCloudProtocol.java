package com.haier.uhome.control.cloud.json;

import com.haier.uhome.control.cloud.json.notify.BoardFOTAStatusNotify;
import com.haier.uhome.control.cloud.json.notify.BusinessMsgNotify;
import com.haier.uhome.control.cloud.json.notify.CloudBusinessNotify;
import com.haier.uhome.control.cloud.json.notify.CloudStateNotify;
import com.haier.uhome.control.cloud.json.notify.CloudTraceCbNotify;
import com.haier.uhome.control.cloud.json.notify.DeviceBindNotify;
import com.haier.uhome.control.cloud.json.notify.DeviceBindStateNotify;
import com.haier.uhome.control.cloud.json.notify.DeviceCloudAddNotify;
import com.haier.uhome.control.cloud.json.notify.DeviceDelNotify;
import com.haier.uhome.control.cloud.json.notify.DeviceUnbindNotify;
import com.haier.uhome.control.cloud.json.notify.InvalidTokenNotify;
import com.haier.uhome.control.cloud.json.notify.ResourceConnectStateNotify;
import com.haier.uhome.control.cloud.json.notify.ResourceDataNotify;
import com.haier.uhome.control.cloud.json.notify.ResourceEventNotify;
import com.haier.uhome.control.cloud.json.req.BoardFOTAReq;
import com.haier.uhome.control.cloud.json.req.DeviceStartFotaReq;
import com.haier.uhome.control.cloud.json.req.FetchFotaStatusReq;
import com.haier.uhome.control.cloud.json.req.GatewayStartPairingReq;
import com.haier.uhome.control.cloud.json.req.OpenBindTimeWindowReq;
import com.haier.uhome.control.cloud.json.req.SaveDeviceVersionReq;
import com.haier.uhome.control.cloud.json.req.UpDeviceVersionInfoReq;
import com.haier.uhome.control.cloud.json.resp.BoardFOTAResp;
import com.haier.uhome.control.cloud.json.resp.DeviceStartFotaResp;
import com.haier.uhome.control.cloud.json.resp.FetchFotaStatusResp;
import com.haier.uhome.control.cloud.json.resp.GatewayStartPairingResp;
import com.haier.uhome.control.cloud.json.resp.OpenBindTimeWindowResp;
import com.haier.uhome.control.cloud.json.resp.SaveDeviceVersionResp;
import com.haier.uhome.control.cloud.json.resp.UpDeviceVersionInfoResp;
import com.haier.uhome.usdk.base.a;
import com.haier.uhome.usdk.base.json.ProtocolProcessor;

/* JADX INFO: loaded from: classes2.dex */
public class ControlCloudProtocol {
    public static String parserMethodProtocol(int i7) {
        if (i7 != 1) {
            return i7 != 2 ? "unknown" : a.av;
        }
        return a.au;
    }

    public static void register() {
        ProtocolProcessor.registerProtocol(ProtocolConst.NOTIFY_CLOUD_BUSINESS, CloudBusinessNotify.class);
        ProtocolProcessor.registerProtocol(ProtocolConst.NOTIFY_CLOUD_STATE, CloudStateNotify.class);
        ProtocolProcessor.registerProtocol(ProtocolConst.NOTIFY_DEVICE_BIND, DeviceBindNotify.class);
        ProtocolProcessor.registerProtocol(ProtocolConst.NOTIFY_DEVICE_UNBIND, DeviceUnbindNotify.class);
        ProtocolProcessor.registerProtocol(ProtocolConst.NOTIFY_INVALID_TOKEN, InvalidTokenNotify.class);
        ProtocolProcessor.registerProtocol(ProtocolConst.NOTIFY_CLOUD_DEVICE_ADD, DeviceCloudAddNotify.class);
        ProtocolProcessor.registerProtocol("device_delete_notify", DeviceDelNotify.class);
        ProtocolProcessor.registerProtocol(ProtocolConst.NOTIFY_TRACE_CB, CloudTraceCbNotify.class);
        ProtocolProcessor.registerProtocol(ProtocolConst.NOTIFY_FOTA_STATUS, BoardFOTAStatusNotify.class);
        ProtocolProcessor.registerProtocol(ProtocolConst.NOTIFY_SLAVE_DEVICE_BIND, BusinessMsgNotify.class);
        ProtocolProcessor.registerProtocol(ProtocolConst.NOTIFY_RESOURCE_CONNECT_STATE, ResourceConnectStateNotify.class);
        ProtocolProcessor.registerProtocol(ProtocolConst.NOTIFY_RESOURCE_DATA, ResourceDataNotify.class);
        ProtocolProcessor.registerProtocol(ProtocolConst.NOTIFY_RESOURCE_EVENT, ResourceEventNotify.class);
        ProtocolProcessor.registerProtocol(ProtocolConst.NOTIFY_DEVICE_BIND_STATE, DeviceBindStateNotify.class);
        ProtocolProcessor.registerProtocol(ProtocolConst.RESP_BOARD_FOTA, BoardFOTAResp.class);
        ProtocolProcessor.registerProtocol(ProtocolConst.RESP_FETCH_FOTA_STATUS, FetchFotaStatusResp.class);
        ProtocolProcessor.registerProtocol(ProtocolConst.RESP_DEVICE_START_FOTA, DeviceStartFotaResp.class);
        ProtocolProcessor.registerProtocol(ProtocolConst.RESP_CLOUD_OPEN_USER_BIND_TIME_WINDOW, OpenBindTimeWindowResp.class);
        ProtocolProcessor.registerProtocol(ProtocolConst.RESP_GATEWAY_START_PAIRING, GatewayStartPairingResp.class);
        ProtocolProcessor.registerProtocol(ProtocolConst.RESP_UPDATE_DEVICE_VERSION, UpDeviceVersionInfoResp.class);
        ProtocolProcessor.registerProtocol(ProtocolConst.RESP_SAVE_DEVICE_VERSION, SaveDeviceVersionResp.class);
        ProtocolProcessor.registerProtocolChecker(BoardFOTAReq.class, BoardFOTAResp.class);
        ProtocolProcessor.registerProtocolChecker(DeviceStartFotaReq.class, DeviceStartFotaResp.class);
        ProtocolProcessor.registerProtocolChecker(FetchFotaStatusReq.class, FetchFotaStatusResp.class);
        ProtocolProcessor.registerProtocolChecker(OpenBindTimeWindowReq.class, OpenBindTimeWindowResp.class);
        ProtocolProcessor.registerProtocolChecker(GatewayStartPairingReq.class, GatewayStartPairingResp.class);
        ProtocolProcessor.registerProtocolChecker(UpDeviceVersionInfoReq.class, UpDeviceVersionInfoResp.class);
        ProtocolProcessor.registerProtocolChecker(SaveDeviceVersionReq.class, SaveDeviceVersionResp.class);
    }
}
