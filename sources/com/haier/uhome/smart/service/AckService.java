package com.haier.uhome.smart.service;

import android.text.TextUtils;
import android.util.Base64;
import com.facebook.internal.ServerProtocol;
import com.haier.library.common.thread.m;
import com.haier.uhome.control.base.json.ProtocolConst;
import com.haier.uhome.smart.api.AbsSmartDevice;
import com.haier.uhome.smart.api.BaseSmartRsp;
import com.haier.uhome.smart.api.SmartDeviceManager;
import com.haier.uhome.smart.api.SmartDevicePair;
import com.haier.uhome.smart.api.SmartOpRsp;
import com.haier.uhome.smart.api.SmartReadRsp;
import com.haier.uhome.smart.api.interfaces.ISmartDeviceListener;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class AckService {
    public static final int NOUMENON_DEVICE_CONNECT = 0;
    public static final int NOUMENON_DEVICE_DISCONNECT = 1;
    private static final String STATE_CONNECTED = "CONNECTED";
    private static final String STATE_CONNECTING = "CONNECTING";
    private static final String STATE_OFFLINE = "OFFLINE";
    private Set<String> mConnectedDevs;

    private static class SingletonFactory {
        private static AckService sInstance = new AckService();

        private SingletonFactory() {
        }
    }

    private String getConnectStateJson(String str, String str2) {
        com.haier.library.json.e eVar = new com.haier.library.json.e();
        com.haier.library.json.e eVar2 = new com.haier.library.json.e();
        eVar2.put("module", com.haier.uhome.usdk.base.a.ar);
        eVar2.put("devId", str);
        eVar2.put(ServerProtocol.DIALOG_PARAM_STATE, str2);
        eVar2.put("errNo", 0);
        eVar2.put("subDev", new com.haier.library.json.b());
        eVar.put(ProtocolConst.NOTIFY_DEVICE_STATE, eVar2);
        return eVar.k();
    }

    public static AckService getInstance() {
        return SingletonFactory.sInstance;
    }

    private void sendJsonToUSDK(String str, String str2) {
        ArrayList<String> arrayList = new ArrayList<>(1);
        arrayList.add(str2);
        sendJsonToUSDK(str, arrayList);
    }

    private void sendReqACK(String str, int i7) {
        com.haier.library.json.e eVar = new com.haier.library.json.e();
        com.haier.library.json.e eVar2 = new com.haier.library.json.e();
        eVar2.put("errNo", 0);
        eVar2.put("sn", Integer.valueOf(i7));
        eVar2.put("devId", str);
        eVar2.put("subDev", new com.haier.library.json.b());
        eVar.put(com.haier.uhome.control.noumenon.b.b.f29471g, eVar2);
        sendJsonToUSDK(str, eVar.k());
    }

    public void handlerConnectState(String str) {
        ArrayList<String> arrayList = new ArrayList<>(2);
        arrayList.add(getConnectStateJson(str, "CONNECTING"));
        arrayList.add(getConnectStateJson(str, "CONNECTED"));
        sendJsonToUSDK(str, arrayList);
    }

    public void sendAlarmNotify(String str, List<SmartDevicePair> list) {
        com.haier.library.json.e eVar = new com.haier.library.json.e();
        com.haier.library.json.e eVar2 = new com.haier.library.json.e();
        eVar2.put("module", com.haier.uhome.usdk.base.a.ar);
        eVar2.put("devId", str);
        if (list != null) {
            com.haier.library.json.b bVar = new com.haier.library.json.b();
            for (SmartDevicePair smartDevicePair : list) {
                com.haier.library.json.e eVar3 = new com.haier.library.json.e();
                eVar3.put("name", smartDevicePair.getName());
                eVar3.put("value", smartDevicePair.getValue());
                bVar.add(eVar3);
            }
            eVar2.put("alarms", bVar);
        }
        eVar2.put("subDev", new com.haier.library.json.b());
        eVar.put(ProtocolConst.NOTIFY_DEVICE_ALARM, eVar2);
        sendJsonToUSDK(str, eVar.k());
    }

    public void sendAttrNotify(String str, List<SmartDevicePair> list) {
        com.haier.library.json.e eVar = new com.haier.library.json.e();
        com.haier.library.json.e eVar2 = new com.haier.library.json.e();
        eVar2.put("module", com.haier.uhome.usdk.base.a.ar);
        eVar2.put("devId", str);
        if (list != null) {
            com.haier.library.json.b bVar = new com.haier.library.json.b();
            for (SmartDevicePair smartDevicePair : list) {
                com.haier.library.json.e eVar3 = new com.haier.library.json.e();
                eVar3.put("name", smartDevicePair.getName());
                eVar3.put("value", smartDevicePair.getValue());
                bVar.add(eVar3);
            }
            eVar2.put("attrs", bVar);
        }
        eVar2.put("subDev", new com.haier.library.json.b());
        eVar.put(ProtocolConst.NOTIFY_DEVICE_ATTR, eVar2);
        sendJsonToUSDK(str, eVar.k());
    }

    public void sendBigDataNotify(String str, String str2, String str3) {
    }

    public void sendOpAck(String str, String str2, SmartOpRsp smartOpRsp) {
        com.haier.library.json.e eVar = new com.haier.library.json.e();
        com.haier.library.json.e eVar2 = new com.haier.library.json.e();
        eVar2.put("sn", Integer.valueOf(smartOpRsp.getReqSn()));
        eVar2.put("devId", str);
        eVar2.put("errNo", Integer.valueOf(smartOpRsp.getResult()));
        eVar2.put("subDev", new com.haier.library.json.b());
        eVar.put(com.haier.uhome.control.noumenon.b.b.f29474j, eVar2);
        sendJsonToUSDK(str, eVar.k());
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        if (com.haier.uhome.usdk.base.a.ag.equals(str2)) {
            sendAttrNotify(str, smartOpRsp.getPairList());
        } else if (com.haier.uhome.usdk.base.a.af.equals(str2)) {
            sendAlarmNotify(str, smartOpRsp.getPairList());
        }
    }

    public void sendPushMessageNotify(String str, List<SmartDevicePair> list) {
    }

    public void sendReadAck(String str, String str2, SmartReadRsp smartReadRsp) {
        com.haier.library.json.e eVar = new com.haier.library.json.e();
        com.haier.library.json.e eVar2 = new com.haier.library.json.e();
        eVar2.put("sn", Integer.valueOf(smartReadRsp.getReqSn()));
        eVar2.put("errNo", Integer.valueOf(smartReadRsp.getResult()));
        eVar2.put("devId", str);
        eVar2.put("name", str2);
        eVar2.put("value", smartReadRsp.getValue());
        eVar2.put("subDev", new com.haier.library.json.b());
        eVar.put(com.haier.uhome.control.noumenon.b.b.f29472h, eVar2);
        sendJsonToUSDK(str, eVar.k());
    }

    public void sendReqAck(String str, String str2, int i7, int i8) {
        e3.a.e("AckService sendReqAck devId = %s,sn = %d, type = %d", str, Integer.valueOf(i7), Integer.valueOf(i8));
        if (i8 != 0) {
            if (i8 != 1) {
                return;
            }
            sendReqACK(str, i7);
            this.mConnectedDevs.remove(str);
            return;
        }
        this.mConnectedDevs.add(str);
        sendReqACK(str, i7);
        handlerConnectState(str);
        AbsSmartDevice onlineDeviceById = SmartDeviceManager.getInstance().getOnlineDeviceById(str);
        if (onlineDeviceById != null) {
            for (ISmartDeviceListener iSmartDeviceListener : onlineDeviceById.getSmartDeviceListerner()) {
                if (iSmartDeviceListener != null) {
                    sendAttrNotify(str, iSmartDeviceListener.onDeviceOpCallback(str2, i7, com.haier.uhome.usdk.base.a.ag, null).getPairList());
                    sendAlarmNotify(str, iSmartDeviceListener.onDeviceOpCallback(str2, i7, com.haier.uhome.usdk.base.a.af, null).getPairList());
                }
            }
        }
    }

    public void sendWriteAck(String str, BaseSmartRsp baseSmartRsp) {
        com.haier.library.json.e eVar = new com.haier.library.json.e();
        com.haier.library.json.e eVar2 = new com.haier.library.json.e();
        eVar2.put("sn", Integer.valueOf(baseSmartRsp.getReqSn()));
        eVar2.put("errNo", Integer.valueOf(baseSmartRsp.getResult()));
        eVar2.put("devId", str);
        eVar2.put("subDev", new com.haier.library.json.b());
        eVar.put(com.haier.uhome.control.noumenon.b.b.f29473i, eVar2);
        sendJsonToUSDK(str, eVar.k());
    }

    private AckService() {
        this.mConnectedDevs = new HashSet();
    }

    private void sendJsonToUSDK(final String str, final ArrayList<String> arrayList) {
        if (!this.mConnectedDevs.contains(str)) {
            e3.a.h("sendJsonToUSDK <%s>Not Connected!!", str);
        } else {
            new m<Void, Void, Void>() { // from class: com.haier.uhome.smart.service.AckService.1
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.haier.library.common.thread.m
                public Void doInBackground(Void... voidArr) {
                    try {
                        Object objInvoke = com.haier.uhome.control.noumenon.service.a.class.getMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
                        Method method = com.haier.uhome.control.noumenon.service.a.class.getMethod("callback", String.class);
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            String str2 = new String(Base64.encode(((String) it.next()).getBytes(), 2));
                            if (!TextUtils.isEmpty(str2)) {
                                method.invoke(objInvoke, str2);
                                e3.a.d("sendJsonToUSDK <%s> to <%s> success!", str2, str, new Object[0]);
                            }
                        }
                    } catch (Exception e8) {
                        e3.a.g("sendJsonToUSDK <%s>", e8.getCause());
                    }
                    return null;
                }
            }.execute(new Void[0]);
        }
    }
}
