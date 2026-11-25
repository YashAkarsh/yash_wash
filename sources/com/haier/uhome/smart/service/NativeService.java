package com.haier.uhome.smart.service;

import com.haier.uhome.smart.api.OtaMode;
import com.haier.uhome.smart.api.RegisterResult;
import com.haier.uhome.usdk.base.json.BasicReq;

/* JADX INFO: loaded from: classes2.dex */
public class NativeService implements com.haier.uhome.usdk.base.d.e {
    private SmartDeviceNative mSmartDeviceNative;

    private static class SingletonFactory {
        private static NativeService sInstance = new NativeService();

        private SingletonFactory() {
        }
    }

    public static NativeService getInstance() {
        return SingletonFactory.sInstance;
    }

    public String addDevice(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        return this.mSmartDeviceNative.addDevice(str, str2, str3, str4, str5, str6, str7);
    }

    public String addDeviceByRandomPrefix(String str, String str2, String str3, String str4, String str5, boolean z7) {
        return this.mSmartDeviceNative.addDeviceByRandomPrefix(str, str2, str3, str4, str5, z7);
    }

    public int addDeviceRelation(String str, String str2) {
        return this.mSmartDeviceNative.addDeviceRelation(str, str2);
    }

    public int addGroupDev(String str, String str2) {
        return this.mSmartDeviceNative.addGroupDev(str, str2);
    }

    public String addSlaveDevice(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        return this.mSmartDeviceNative.addSlaveDevice(str, str2, str3, str4, str5, str6, str7);
    }

    public String annexDeviceOnline(String str, String str2, String str3, String str4, String str5, String str6, boolean z7, String str7) {
        return this.mSmartDeviceNative.annexDeviceOnline(str, str2, str3, str4, str5, str6, z7 ? 1 : 0, str7);
    }

    public int bindDevice(String str, String str2, String str3, double d8, int i7) {
        return this.mSmartDeviceNative.bindDevice(str, str2, str3, (int) d8, i7);
    }

    public int bindDeviceBySmartLink(String str, String str2, String str3, String str4, String str5, int i7) {
        return this.mSmartDeviceNative.bindDeviceBySmartLink(str, str2, str3, str4, str5, i7);
    }

    public int bindSlaveDevice(String str, String str2) {
        return this.mSmartDeviceNative.bindSlaveDevice(str, str2);
    }

    public int bindWindow(String str, String str2) {
        return this.mSmartDeviceNative.bindWindow(str, str2);
    }

    public int businessUp(String str, String str2, byte[] bArr, int i7) {
        return this.mSmartDeviceNative.businessUp(str, str2, bArr, i7);
    }

    public void callback(String str) {
        this.mSmartDeviceNative.callback(str);
    }

    public int delDevice(String str) {
        return this.mSmartDeviceNative.delDevice(str);
    }

    public String gatewayDeviceOnline(String str, String str2, String str3, String str4, String str5, boolean z7, String str6) {
        return this.mSmartDeviceNative.gatewayDeviceOnline(str, str2, str3, str4, str5, z7 ? 1 : 0, str6);
    }

    public String gatewayVoiceDeviceOnline(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, boolean z7, String str10) {
        return this.mSmartDeviceNative.gatewayVoiceDeviceOnline(str, str2, str3, str4, str5, str6, str7, str8, str9, z7 ? 1 : 0, str10);
    }

    public String generalDeviceOnline(String str, String str2, String str3, String str4, String str5, boolean z7, String str6) {
        return this.mSmartDeviceNative.generalDeviceOnline(str, str2, str3, str4, str5, z7 ? 1 : 0, str6);
    }

    public String generalVoiceDeviceOnline(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, boolean z7, String str10) {
        return this.mSmartDeviceNative.generalVoiceDeviceOnline(str, str2, str3, str4, str5, str6, str7, str8, str9, z7 ? 1 : 0, str10);
    }

    public String getBindQRCode(String str, String str2) {
        return this.mSmartDeviceNative.getBindQRCode(str, str2);
    }

    public int groupControlInit() {
        return this.mSmartDeviceNative.groupControlInit();
    }

    public int groupControlRsp(int i7, String str, int i8, int i9) {
        return this.mSmartDeviceNative.groupControlRsp(i7, str, i8, i9);
    }

    public int groupFetchDeviceList(String str) {
        return this.mSmartDeviceNative.groupFetchDeviceList(str);
    }

    public int init(String str, int i7, String str2, String str3) {
        return this.mSmartDeviceNative.init(str, i7, str2, str3);
    }

    public int initIotVideo(String str, String str2) {
        return this.mSmartDeviceNative.initIotVideo(str, str2);
    }

    public int mcsServerInit(String str, String str2) {
        return this.mSmartDeviceNative.initMcsServer(str, str2);
    }

    public int messagePushInit() {
        return this.mSmartDeviceNative.messagePushInit();
    }

    public int opRsp(String str, int i7, String str2, int i8) {
        return this.mSmartDeviceNative.opRsp(str, i7, str2, i8);
    }

    public int otaFinish(String str, String str2, int i7) {
        return this.mSmartDeviceNative.otaFinish(str, str2, i7);
    }

    public int otaInit(int i7) {
        return this.mSmartDeviceNative.otaInit(i7);
    }

    public int queryBindStatus(String str, int i7, int i8) {
        return this.mSmartDeviceNative.queryBindStatus(str, i7, i8);
    }

    public int readRsp(String str, int i7, String str2, int i8) {
        return this.mSmartDeviceNative.readRsp(str, i7, str2, i8);
    }

    public int refreshMdns() {
        return this.mSmartDeviceNative.refreshMdns();
    }

    public int refreshNetwork() {
        return this.mSmartDeviceNative.refreshNetwork();
    }

    public RegisterResult registerAnnexDevice(String str, String str2, String str3, String str4) {
        return this.mSmartDeviceNative.registerAnnexDevice(str, str2, str3, str4);
    }

    public int registerDownloadOtapkgCb(String str, String str2, String str3, String str4) {
        return this.mSmartDeviceNative.registerDownloadOtapkgCb(str, str2, str3, str4);
    }

    public RegisterResult registerGatewayDevice(String str, String str2, String str3, String str4) {
        return this.mSmartDeviceNative.registerGatewayDevice(str, str2, str3, str4);
    }

    public RegisterResult registerGatewayVoiceDevice(String str, String str2, String str3, String str4) {
        return this.mSmartDeviceNative.registerGatewayVoiceDevice(str, str2, str3, str4);
    }

    public RegisterResult registerGeneralDevice(String str, String str2, String str3, String str4) {
        return this.mSmartDeviceNative.registerGeneralDevice(str, str2, str3, str4);
    }

    public RegisterResult registerGeneralVoiceDevice(String str, String str2, String str3, String str4) {
        return this.mSmartDeviceNative.registerGeneralVoiceDevice(str, str2, str3, str4);
    }

    public int registerMessagePush(String str, String str2, String str3, String str4, int i7, int i8, int i9) {
        return this.mSmartDeviceNative.registerMessagePush(str, str2, str3, str4, i7, i8, i9);
    }

    public int registerResource(String str, String str2) {
        return this.mSmartDeviceNative.registerResource(str, str2);
    }

    public RegisterResult registerSlaveDevice(String str, String str2, String str3, String str4) {
        return this.mSmartDeviceNative.registerSlaveDevice(str, str2, str3, str4);
    }

    public int release() {
        return this.mSmartDeviceNative.release();
    }

    public int reportAlarm(String str, String str2) {
        return this.mSmartDeviceNative.reportAlarm(str, str2);
    }

    public int reportBigData(String str, String str2, String str3, int i7) {
        return this.mSmartDeviceNative.reportBigData(str, str2, str3, i7);
    }

    public int reportBindProcess(int i7, String str, String str2, String str3, int i8, String str4) {
        return this.mSmartDeviceNative.reportBindProcess(i7, str, str2, str3, i8, str4);
    }

    public int reportMessageStatus(String str, String str2, String str3, String str4, int i7) {
        return this.mSmartDeviceNative.reportMsgStatus(str, str2, str3, str4, i7);
    }

    public int reportResource(String str, String str2, String str3, int i7) {
        return this.mSmartDeviceNative.reportResource(str, str2, str3, i7);
    }

    public int reportStatus(String str, String str2) {
        return this.mSmartDeviceNative.reportStatus(str, str2);
    }

    public int restartDevGW() {
        return this.mSmartDeviceNative.restartDevGW();
    }

    public int sendIotAudio(byte[] bArr, int i7, long j7, int i8) {
        return this.mSmartDeviceNative.sendIotAudio(bArr, i7, i8, j7);
    }

    public int sendIotVideo(byte[] bArr, int i7, long j7, int i8) {
        return this.mSmartDeviceNative.sendIotVideo(bArr, i7, i8, j7);
    }

    @Override // com.haier.uhome.usdk.base.d.e
    public int sendReq(BasicReq basicReq) {
        return 0;
    }

    public int setOtaMode(String str, OtaMode otaMode) {
        return this.mSmartDeviceNative.setOtaMode(str, otaMode);
    }

    public String slaveDeviceOnline(String str, String str2, String str3, String str4, String str5, String str6, boolean z7, int i7, String str7) {
        return this.mSmartDeviceNative.slaveDeviceOnline(str, str2, str3, str4, str5, str6, z7 ? 1 : 0, i7, str7);
    }

    public int startPairingRsp(int i7, int i8) {
        return this.mSmartDeviceNative.startPairingRsp(i7, i8);
    }

    public int startService(String str, int i7, String str2, String str3, int i8, String str4, String str5) {
        return this.mSmartDeviceNative.startService(str, i7, str2, str3, i8, str4, str5);
    }

    public int startWifiScanDevice(int i7) {
        return this.mSmartDeviceNative.startWifiScanDevice(i7);
    }

    public int stopWifiScanDevice() {
        return this.mSmartDeviceNative.stopWifiScanDevice();
    }

    public int unBindSlaveDevice(String str, String str2) {
        return this.mSmartDeviceNative.unBindSlaveDevice(str, str2);
    }

    public int unRegisterMessagePush(String str, String str2, int i7) {
        return this.mSmartDeviceNative.unRegisterMessagePush(str, str2, i7);
    }

    public int unRegisterResource(String str, String str2) {
        return this.mSmartDeviceNative.unRegisterResource(str, str2);
    }

    public int writeRsp(String str, int i7, int i8) {
        return this.mSmartDeviceNative.writeRsp(str, i7, i8);
    }

    private NativeService() {
        SmartDeviceNative smartDeviceNative = new SmartDeviceNative();
        this.mSmartDeviceNative = smartDeviceNative;
        smartDeviceNative.setUserPackageReceive(com.haier.uhome.usdk.base.d.f.a());
    }
}
