package com.haier.uhome.usdk.api;

import com.haier.uhome.usdk.base.annotation.Keep;

/* JADX INFO: loaded from: classes2.dex */
@Keep
public class uSDKNetworkQualityInfoV2 {
    private uSDKDeviceConnectStatus mConnectStatus;
    private com.haier.uhome.control.base.api.s mNetworkQualityInfoV2;

    public uSDKNetworkQualityInfoV2(uSDKDeviceConnectStatus usdkdeviceconnectstatus, com.haier.uhome.control.base.api.s sVar) {
        this.mConnectStatus = usdkdeviceconnectstatus;
        this.mNetworkQualityInfoV2 = sVar;
    }

    public uSDKDeviceConnectStatus getDeviceConnectStatus() {
        return this.mConnectStatus;
    }

    public int getIlostRatio() {
        com.haier.uhome.control.base.api.s sVar = this.mNetworkQualityInfoV2;
        if (sVar == null) {
            return 0;
        }
        return sVar.i();
    }

    public int getIts() {
        com.haier.uhome.control.base.api.s sVar = this.mNetworkQualityInfoV2;
        if (sVar == null) {
            return 0;
        }
        return sVar.j();
    }

    public String getLanIP() {
        com.haier.uhome.control.base.api.s sVar = this.mNetworkQualityInfoV2;
        if (sVar == null) {
            return null;
        }
        return sVar.k();
    }

    public String getMachineId() {
        com.haier.uhome.control.base.api.s sVar = this.mNetworkQualityInfoV2;
        if (sVar == null) {
            return null;
        }
        return sVar.a();
    }

    public String getModuleVersion() {
        com.haier.uhome.control.base.api.s sVar = this.mNetworkQualityInfoV2;
        if (sVar == null) {
            return null;
        }
        return sVar.l();
    }

    public String getNetType() {
        com.haier.uhome.control.base.api.s sVar = this.mNetworkQualityInfoV2;
        if (sVar == null) {
            return null;
        }
        return sVar.d();
    }

    public int getPrssi() {
        com.haier.uhome.control.base.api.s sVar = this.mNetworkQualityInfoV2;
        if (sVar == null) {
            return 0;
        }
        return sVar.g();
    }

    public int getRssi() {
        com.haier.uhome.control.base.api.s sVar = this.mNetworkQualityInfoV2;
        if (sVar == null) {
            return 0;
        }
        return sVar.f();
    }

    public int getSignalLevel() {
        com.haier.uhome.control.base.api.s sVar = this.mNetworkQualityInfoV2;
        if (sVar == null) {
            return 0;
        }
        return sVar.h();
    }

    public String getSsid() {
        com.haier.uhome.control.base.api.s sVar = this.mNetworkQualityInfoV2;
        if (sVar == null) {
            return null;
        }
        return sVar.e();
    }

    public long getStatusLastChangeTime() {
        com.haier.uhome.control.base.api.s sVar = this.mNetworkQualityInfoV2;
        if (sVar == null) {
            return 0L;
        }
        return sVar.c();
    }

    public boolean isOnLine() {
        com.haier.uhome.control.base.api.s sVar = this.mNetworkQualityInfoV2;
        if (sVar == null) {
            return false;
        }
        return sVar.b();
    }

    public String toString() {
        return "NetworkQualityInfoV2Dto{connectStatus=" + getDeviceConnectStatus().getDesc() + ", machineId=" + getMachineId() + ", onLine=" + isOnLine() + ", statusLastChangeTime=" + getStatusLastChangeTime() + ", netType=" + getNetType() + ", ssid=" + getSsid() + ", rssi=" + getRssi() + ", prssi=" + getPrssi() + ", signalLevel=" + getSignalLevel() + ", ilostRatio=" + getIlostRatio() + ", its=" + getIts() + ", lanIP=" + getLanIP() + ", moduleVersion=" + getModuleVersion() + '}';
    }
}
