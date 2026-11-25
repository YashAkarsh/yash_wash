package com.haier.uhome.control.cloud.api;

import com.haier.uhome.usdk.base.api.uSDKError;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public class FOTAStatusInfo {
    private final uSDKError upgradeErrorInfo;
    private final int upgradeStatus;

    public FOTAStatusInfo(int i7, uSDKError usdkerror) {
        this.upgradeStatus = i7;
        this.upgradeErrorInfo = usdkerror;
    }

    public boolean equals(Object obj) {
        uSDKError usdkerror;
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        FOTAStatusInfo fOTAStatusInfo = (FOTAStatusInfo) obj;
        return this.upgradeStatus == fOTAStatusInfo.upgradeStatus && (usdkerror = this.upgradeErrorInfo) != null && usdkerror.equals(fOTAStatusInfo.upgradeErrorInfo);
    }

    public uSDKError getUpgradeErrorInfo() {
        return this.upgradeErrorInfo;
    }

    public int getUpgradeStatus() {
        return this.upgradeStatus;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.upgradeStatus), this.upgradeErrorInfo});
    }

    public String toString() {
        return "FOTAStatusInfo{upgradeStatus=" + this.upgradeStatus + ", upgradeErrorInfo=" + this.upgradeErrorInfo + '}';
    }
}
