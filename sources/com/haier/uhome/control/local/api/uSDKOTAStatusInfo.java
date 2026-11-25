package com.haier.uhome.control.local.api;

/* JADX INFO: loaded from: classes2.dex */
public class uSDKOTAStatusInfo {
    private final float upgradeProgress;
    private final uSDKOTAStatus upgradeStatus;

    public uSDKOTAStatusInfo(uSDKOTAStatus usdkotastatus, float f8) {
        this.upgradeStatus = usdkotastatus;
        this.upgradeProgress = f8;
    }

    public float getUpgradeProgress() {
        return this.upgradeProgress;
    }

    public uSDKOTAStatus getUpgradeStatus() {
        return this.upgradeStatus;
    }

    public String toString() {
        return "uSDKOTAStatusInfo{upgradeStatus=" + this.upgradeStatus + ", upgradeProgress=" + this.upgradeProgress + '}';
    }
}
