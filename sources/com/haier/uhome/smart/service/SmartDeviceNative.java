package com.haier.uhome.smart.service;

import com.haier.library.common.util.w;
import com.haier.uhome.smart.api.AbsSmartDevice;
import com.haier.uhome.smart.api.IotMediaInfo;
import com.haier.uhome.smart.api.OtaMode;
import com.haier.uhome.smart.api.RegisterResult;
import com.haier.uhome.smart.api.interfaces.ISmartDeviceMessageListener;
import com.haier.uhome.smart.api.interfaces.ISmartDeviceVideoListener;
import com.haier.uhome.smart.handler.SmartDeviceNotifier;
import com.haier.uhome.usdk.base.service.BaseNative;
import java.net.InetAddress;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class SmartDeviceNative extends BaseNative {
    private static final com.haier.library.okhttp.a.a DNS = new com.haier.library.okhttp.a.a();

    static {
        System.loadLibrary("mbedtls_dev");
        System.loadLibrary("gpac");
        System.loadLibrary("iconv");
        System.loadLibrary("iotvideo_dev");
        System.loadLibrary("zbar");
        System.loadLibrary("sdl");
    }

    private native int initMsg(String str);

    private native int registerMsg(String str, String str2, String str3, String str4, int i7, int i8, int i9, String str5);

    public static String resolveIpByName(String str) {
        try {
            List<InetAddress> listA = DNS.a(str);
            if (listA == null) {
                return null;
            }
            return listA.get(0).getHostAddress();
        } catch (Exception e8) {
            e3.a.v("resolveIpByName excp -> %s", e8);
            return w.e(str);
        }
    }

    private native int unregisterMsg(String str, String str2, int i7, String str3);

    public native String addDevice(String str, String str2, String str3, String str4, String str5, String str6, String str7);

    public native String addDeviceByRandomPrefix(String str, String str2, String str3, String str4, String str5, boolean z7);

    public int addDeviceRelation(String str, String str2) {
        return addDeviceRelation(str, str2, "onAddDeviceRelationResult");
    }

    public native int addDeviceRelation(String str, String str2, String str3);

    public native int addGroupDev(String str, String str2);

    public native String addSlaveDevice(String str, String str2, String str3, String str4, String str5, String str6, String str7);

    public native String annexDeviceOnline(String str, String str2, String str3, String str4, String str5, String str6, int i7, String str7);

    public int bindDevice(String str, String str2, String str3, int i7, int i8) {
        return bindDevice(str, str2, str3, i7, i8, 0);
    }

    public native int bindDevice(String str, String str2, String str3, int i7, int i8, int i9);

    public native int bindDeviceBySmartLink(String str, String str2, String str3, String str4, String str5, int i7);

    public int bindSlaveDevice(String str, String str2) {
        return bindSlaveDevice(str, str2, "onSlaveDeviceBindResult");
    }

    public native int bindSlaveDevice(String str, String str2, String str3);

    public native int bindWindow(String str, String str2);

    public native int businessUp(String str, String str2, byte[] bArr, int i7);

    public native int delDevice(String str);

    public native String gatewayDeviceOnline(String str, String str2, String str3, String str4, String str5, int i7, String str6);

    public native String gatewayVoiceDeviceOnline(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, int i7, String str10);

    public native String generalDeviceOnline(String str, String str2, String str3, String str4, String str5, int i7, String str6);

    public native String generalVoiceDeviceOnline(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, int i7, String str10);

    public native String getBindQRCode(String str, String str2);

    public IotMediaInfo getCodecInfo() {
        e3.a.e("jni call getCodecInfo", new Object[0]);
        IotMediaInfo iotMediaInfo = new IotMediaInfo();
        iotMediaInfo.video_width = 640;
        iotMediaInfo.video_height = 480;
        iotMediaInfo.video_type = 0;
        iotMediaInfo.video_frame_rate = 20;
        iotMediaInfo.audio_type = 4;
        iotMediaInfo.audio_sub_type = 2;
        iotMediaInfo.audio_bit_width = 1;
        iotMediaInfo.audio_mode = 0;
        iotMediaInfo.audio_sample_num_per_frame = 1024;
        iotMediaInfo.audio_sample_rate = 16000;
        return iotMediaInfo;
    }

    public native int groupControlInit();

    public native int groupControlRsp(int i7, String str, int i8, int i9);

    public native int groupFetchDeviceList(String str);

    public native int init(String str, int i7, String str2, String str3);

    public int initIotVideo(String str, String str2) {
        return initIotVideo(str, str2, "iotVideoCloudState", "iotAudioDataReceiveMethod", "com/haier/uhome/smart/api/IotMediaInfo", "getCodecInfo", "requestKeyFrame");
    }

    public native int initIotVideo(String str, String str2, String str3, String str4, String str5, String str6, String str7);

    public native int initMcsServer(String str, String str2);

    public void iotAudioDataReceiveMethod(String str, byte[] bArr, int i7, int i8, long j7) {
        e3.a.e("jni call iotAudioDataReceiveMethod devId<%s>, data<%s>", str, bArr);
        AbsSmartDevice onlineDeviceById = SmartDeviceService.getInstance().getOnlineDeviceById(str);
        if (onlineDeviceById == null) {
            e3.a.h("iotAudioDataReceiveMethod error device<%s> not online", str);
            return;
        }
        for (ISmartDeviceVideoListener iSmartDeviceVideoListener : onlineDeviceById.getSmartDeviceVideoListeners()) {
            if (iSmartDeviceVideoListener != null) {
                iSmartDeviceVideoListener.onIotAudioDataReceive(bArr, i7, i8, j7);
            }
        }
    }

    public void iotVideoCloudState(String str, int i7) {
        e3.a.e("jni call iotVideoCloudState devId<%s>, state<%d>", str, Integer.valueOf(i7));
        AbsSmartDevice onlineDeviceById = SmartDeviceService.getInstance().getOnlineDeviceById(str);
        if (onlineDeviceById == null) {
            e3.a.h("iotVideoCloudState errr device<%s> not online", str);
            return;
        }
        for (ISmartDeviceVideoListener iSmartDeviceVideoListener : onlineDeviceById.getSmartDeviceVideoListeners()) {
            if (iSmartDeviceVideoListener != null) {
                iSmartDeviceVideoListener.onIotVideoCloudState(i7);
            }
        }
    }

    public int messagePushInit() {
        return initMsg("onMessageReceive");
    }

    public void onAddDeviceRelationResult(String str, int i7) {
        e3.a.e("onAddDeviceRelationResult devId<%s> errNo<%d>", str, Integer.valueOf(i7));
        SmartDeviceNotifier.getInstance().notifyDeviceRelationResult(str, i7);
    }

    public void onMessageReceive(String str, String str2, String str3) {
        e3.a.d("", "", "onMessageReceive devId<%s> pushId<%s> data<%s>", str, str2, str3);
        AbsSmartDevice onlineDeviceById = SmartDeviceService.getInstance().getOnlineDeviceById(str);
        if (onlineDeviceById == null) {
            e3.a.h("onMessageReceive error device<%s> not online", str);
            return;
        }
        for (ISmartDeviceMessageListener iSmartDeviceMessageListener : onlineDeviceById.getSmartDeviceMessageListener()) {
            if (iSmartDeviceMessageListener != null) {
                iSmartDeviceMessageListener.onMessageReceive(str, str2, str3);
            }
        }
    }

    public void onRegisterMessageAck(String str, String str2, int i7, int i8) {
        e3.a.d("", "", "onRegisterMessageAck devId<%s> pushId<%s> sn<%d> code<%d>", str, str2, Integer.valueOf(i7), Integer.valueOf(i8));
        AbsSmartDevice onlineDeviceById = SmartDeviceService.getInstance().getOnlineDeviceById(str);
        if (onlineDeviceById == null) {
            e3.a.h("onRegisterMessageAck error device<%s> not online", str);
            return;
        }
        for (ISmartDeviceMessageListener iSmartDeviceMessageListener : onlineDeviceById.getSmartDeviceMessageListener()) {
            if (iSmartDeviceMessageListener != null) {
                iSmartDeviceMessageListener.onRegisterMessageAck(str, str2, i7, i8);
            }
        }
    }

    public void onSlaveDeviceBindResult(String str, int i7) {
        e3.a.e("onSlaveDeviceBindResult devId<%s> errNo<%d>", str, Integer.valueOf(i7));
        SmartDeviceNotifier.getInstance().notifySlaveDeviceBindResult(str, i7);
    }

    public void onSlaveDeviceUnbindResult(String str, int i7) {
        e3.a.e("onSlaveDeviceUnbindResult devId<%s> errNo<%d>", str, Integer.valueOf(i7));
        SmartDeviceNotifier.getInstance().notifySlaveDeviceUnbindResult(str, i7);
    }

    public void onUnRegisterMessageAck(String str, String str2, int i7, int i8) {
        e3.a.d("", "", "onUnRegisterMessageAck devId<%s> pushId<%s> sn<%d> code<%d>", str, str2, Integer.valueOf(i7), Integer.valueOf(i8));
        AbsSmartDevice onlineDeviceById = SmartDeviceService.getInstance().getOnlineDeviceById(str);
        if (onlineDeviceById == null) {
            e3.a.h("onUnRegisterMessageAck error device<%s> not online", str);
            return;
        }
        for (ISmartDeviceMessageListener iSmartDeviceMessageListener : onlineDeviceById.getSmartDeviceMessageListener()) {
            if (iSmartDeviceMessageListener != null) {
                iSmartDeviceMessageListener.onUnRegisterMessageAck(str, str2, i7, i8);
            }
        }
    }

    public native int opRsp(String str, int i7, String str2, int i8);

    public native int otaFinish(String str, String str2, int i7);

    public native int otaInit(int i7);

    public native int queryBindStatus(String str, int i7, int i8);

    public native int readRsp(String str, int i7, String str2, int i8);

    public native int refreshMdns();

    public native int refreshNetwork();

    public native RegisterResult registerAnnexDevice(String str, String str2, String str3, String str4);

    public native int registerDownloadOtapkgCb(String str, String str2, String str3, String str4);

    public native RegisterResult registerGatewayDevice(String str, String str2, String str3, String str4);

    public native RegisterResult registerGatewayVoiceDevice(String str, String str2, String str3, String str4);

    public native RegisterResult registerGeneralDevice(String str, String str2, String str3, String str4);

    public native RegisterResult registerGeneralVoiceDevice(String str, String str2, String str3, String str4);

    public int registerMessagePush(String str, String str2, String str3, String str4, int i7, int i8, int i9) {
        return registerMsg(str, str2, str3, str4, i7, i8, i9, "onRegisterMessageAck");
    }

    public native int registerResource(String str, String str2);

    public native RegisterResult registerSlaveDevice(String str, String str2, String str3, String str4);

    public native int release();

    public native int reportAlarm(String str, String str2);

    public native int reportBigData(String str, String str2, String str3, int i7);

    public native int reportBindProcess(int i7, String str, String str2, String str3, int i8, String str4);

    public native int reportMsgStatus(String str, String str2, String str3, String str4, int i7);

    public native int reportResource(String str, String str2, String str3, int i7);

    public native int reportStatus(String str, String str2);

    public void requestKeyFrame() {
        e3.a.e("jni call requestKeyFrame", new Object[0]);
    }

    public native int restartDevGW();

    public native int sendIotAudio(byte[] bArr, int i7, int i8, long j7);

    public native int sendIotVideo(byte[] bArr, int i7, int i8, long j7);

    public native int setOtaMode(String str, OtaMode otaMode);

    public native String slaveDeviceOnline(String str, String str2, String str3, String str4, String str5, String str6, int i7, int i8, String str7);

    public native int startPairingRsp(int i7, int i8);

    public native int startService(String str, int i7, String str2, String str3, int i8, String str4, String str5);

    public native int startWifiScanDevice(int i7);

    public native int stopWifiScanDevice();

    public int unBindSlaveDevice(String str, String str2) {
        return unBindSlaveDevice(str, str2, "onSlaveDeviceUnbindResult");
    }

    public native int unBindSlaveDevice(String str, String str2, String str3);

    public int unRegisterMessagePush(String str, String str2, int i7) {
        return unregisterMsg(str, str2, i7, "onUnRegisterMessageAck");
    }

    public native int unRegisterResource(String str, String str2);

    public native int writeRsp(String str, int i7, int i8);
}
