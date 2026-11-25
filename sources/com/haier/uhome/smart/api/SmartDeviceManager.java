package com.haier.uhome.smart.api;

import android.content.Context;
import com.haier.uhome.smart.api.interfaces.ISmartDeviceManagerListener;
import com.haier.uhome.smart.service.SmartDeviceService;
import com.haier.uhome.trace.api.TraceNode;
import com.haier.uhome.usdk.base.api.ICallback;
import com.haier.uhome.usdk.base.api.i;
import com.haier.uhome.usdk.base.api.o;
import e3.a;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class SmartDeviceManager {
    public static final int RESULT_ERR = -1;
    public static final int RESULT_OK = 0;
    private SmartDeviceService mSmartDeviceService;

    private static class SingletonFactory {
        private static SmartDeviceManager sInstance = new SmartDeviceManager();

        private SingletonFactory() {
        }
    }

    private void delAnnexDevice(AbsSmartDevice absSmartDevice, i<String> iVar) {
        for (AbsSmartDevice absSmartDevice2 : getOnlineDeviceList()) {
            if ((absSmartDevice2 instanceof AnnexDevice) && ((AnnexDevice) absSmartDevice2).getParentId().equals(absSmartDevice.getDeviceId())) {
                this.mSmartDeviceService.delDevice(absSmartDevice2.getDeviceId(), iVar);
            }
        }
    }

    private void delDeviceInner(AbsSmartDevice absSmartDevice, i<String> iVar) {
        for (AbsSmartDevice absSmartDevice2 : getOnlineDeviceList()) {
            if ((absSmartDevice2 instanceof SlaveDevice) && ((SlaveDevice) absSmartDevice2).getParentId().equals(absSmartDevice.getDeviceId())) {
                delAnnexDevice(absSmartDevice2, iVar);
                this.mSmartDeviceService.delDevice(absSmartDevice2.getDeviceId(), iVar);
            } else if ((absSmartDevice2 instanceof AnnexDevice) && ((AnnexDevice) absSmartDevice2).getParentId().equals(absSmartDevice.getDeviceId())) {
                this.mSmartDeviceService.delDevice(absSmartDevice2.getDeviceId(), iVar);
            }
        }
    }

    public static SmartDeviceManager getInstance() {
        return SingletonFactory.sInstance;
    }

    public void addAuthSlaveDevice(SmartDevice smartDevice, i<String> iVar) {
        this.mSmartDeviceService.addSlaveDevice(smartDevice, iVar);
    }

    public void addDevice(SmartDevice smartDevice, i<String> iVar) {
        this.mSmartDeviceService.addDevice(smartDevice, iVar);
    }

    public void addDeviceByRandomPrefix(SmartDevice smartDevice, boolean z7, i<String> iVar) {
        this.mSmartDeviceService.addDeviceByRandomPrefix(smartDevice, z7, iVar);
    }

    public void addListener(ISmartDeviceManagerListener iSmartDeviceManagerListener) {
        this.mSmartDeviceService.addListener(iSmartDeviceManagerListener);
    }

    public void addSlaveDevice(SmartDevice smartDevice, i<String> iVar) {
        this.mSmartDeviceService.addSlaveDevice(smartDevice, iVar);
    }

    public void annexDeviceOnline(AnnexDevice annexDevice, ICallback<String> iCallback) {
        new AnnexDeviceAccess(annexDevice).deviceOnline(iCallback);
    }

    public void bindDevice(String str, String str2, double d8, o oVar) {
        this.mSmartDeviceService.bindDevice(str, str2, d8, oVar);
    }

    public void bindSlaveDevice(String str, TraceNode traceNode, ICallback<Void> iCallback) {
        this.mSmartDeviceService.bindSlaveDevice(str, traceNode, iCallback);
    }

    public void delDevice(String str, i<String> iVar) {
        if (getOnlineDeviceById(str) == null) {
            a.h("delete device <%s> not found", str);
        } else {
            this.mSmartDeviceService.delDevice(str, iVar);
        }
    }

    public void gatewayDeviceOnline(GatewayDevice gatewayDevice, ICallback<String> iCallback) {
        new GatewayDeviceAccess(gatewayDevice).deviceOnline(iCallback);
    }

    public void gatewayVoiceDeviceOnline(GatewayVoiceDevice gatewayVoiceDevice, ICallback<String> iCallback) {
        new GatewayVoiceDeviceAccess(gatewayVoiceDevice).deviceOnline(iCallback);
    }

    public void generalDeviceOnline(GeneralDevice generalDevice, ICallback<String> iCallback) {
        new GeneralDeviceAccess(generalDevice).deviceOnline(iCallback);
    }

    public void generalVoiceDeviceOnline(GeneralVoiceDevice generalVoiceDevice, ICallback<String> iCallback) {
        new GeneralVoiceDeviceAccess(generalVoiceDevice).deviceOnline(iCallback);
    }

    public void getBindQRCode(SmartDevice smartDevice, double d8, i<String> iVar) {
        this.mSmartDeviceService.getBindQRCode(smartDevice, d8, iVar);
    }

    public int getCloudState() {
        return this.mSmartDeviceService.getCloudState();
    }

    public String getDevIdPrefix() {
        return this.mSmartDeviceService.getDevIdPrefix();
    }

    public SmartDevice getDeviceById(String str) {
        return this.mSmartDeviceService.getDeviceById(str);
    }

    public ArrayList<SmartDevice> getDeviceList() {
        return this.mSmartDeviceService.getDeviceList();
    }

    public AbsSmartDevice getOnlineDeviceById(String str) {
        return this.mSmartDeviceService.getOnlineDeviceById(str);
    }

    public ArrayList<AbsSmartDevice> getOnlineDeviceList() {
        return this.mSmartDeviceService.getOnlineDeviceList();
    }

    public SDKState getRunningState() {
        return this.mSmartDeviceService.getState();
    }

    public void refreshMdns(o oVar) {
        this.mSmartDeviceService.refreshMdns(oVar);
    }

    public void refreshNetwork(ICallback<Void> iCallback) {
        this.mSmartDeviceService.refreshNetwork(iCallback);
    }

    public void registerAnnexDevice(RegisterAnnexDevice registerAnnexDevice, ICallback<RegisterResult> iCallback) {
        new AnnexDeviceAccess(registerAnnexDevice).registerDevice(iCallback);
    }

    public void registerGatewayDevice(RegisterGatewayDevice registerGatewayDevice, ICallback<RegisterResult> iCallback) {
        new GatewayDeviceAccess(registerGatewayDevice).registerDevice(iCallback);
    }

    public void registerGatewayVoiceDevice(RegisterGatewayVoiceDevice registerGatewayVoiceDevice, ICallback<RegisterResult> iCallback) {
        new GatewayVoiceDeviceAccess(registerGatewayVoiceDevice).registerDevice(iCallback);
    }

    public void registerGeneralDevice(RegisterGeneralDevice registerGeneralDevice, ICallback<RegisterResult> iCallback) {
        new GeneralDeviceAccess(registerGeneralDevice).registerDevice(iCallback);
    }

    public void registerGeneralVoiceDevice(RegisterGeneralVoiceDevice registerGeneralVoiceDevice, ICallback<RegisterResult> iCallback) {
        new GeneralVoiceDeviceAccess(registerGeneralVoiceDevice).registerDevice(iCallback);
    }

    public void registerSlaveDevice(RegisterSlaveDevice registerSlaveDevice, ICallback<RegisterResult> iCallback) {
        new SlaveDeviceAccess(registerSlaveDevice).registerDevice(iCallback);
    }

    public void removeListener(ISmartDeviceManagerListener iSmartDeviceManagerListener) {
        this.mSmartDeviceService.removeListener(iSmartDeviceManagerListener);
    }

    public void restartDevGW(o oVar) {
        this.mSmartDeviceService.restartDevGW(oVar);
    }

    public void slaveDeviceOnline(SlaveDevice slaveDevice, ICallback<String> iCallback) {
        new SlaveDeviceAccess(slaveDevice).deviceOnline(iCallback);
    }

    public void startService(Context context, String str, int i7, o oVar) {
        this.mSmartDeviceService.startService(context, str, i7, oVar);
    }

    public void stopService(o oVar) {
        this.mSmartDeviceService.stopService(oVar);
    }

    public void unBindSlaveDevice(String str, TraceNode traceNode, ICallback<Void> iCallback) {
        this.mSmartDeviceService.unBindSlaveDevice(str, traceNode, iCallback);
    }

    private SmartDeviceManager() {
        this.mSmartDeviceService = SmartDeviceService.getInstance();
    }

    public void startService(StartOption startOption, ICallback<Void> iCallback) {
        this.mSmartDeviceService.startService(startOption, iCallback);
    }
}
