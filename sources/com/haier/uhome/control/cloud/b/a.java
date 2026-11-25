package com.haier.uhome.control.cloud.b;

import com.haier.uhome.control.cloud.api.FOTAStatusInfo;
import com.haier.uhome.usdk.base.api.uSDKError;

/* JADX INFO: loaded from: classes2.dex */
public class a {
    private a() {
    }

    public static void a(FOTAStatusInfo fOTAStatusInfo) {
        uSDKError upgradeErrorInfo = fOTAStatusInfo.getUpgradeErrorInfo();
        if (upgradeErrorInfo.getCode() < 0) {
            upgradeErrorInfo.setCode(Math.abs(upgradeErrorInfo.getCode() + 3000));
        }
    }

    public static boolean b(FOTAStatusInfo fOTAStatusInfo) {
        return c(fOTAStatusInfo) || d(fOTAStatusInfo);
    }

    private static boolean c(FOTAStatusInfo fOTAStatusInfo) {
        return fOTAStatusInfo.getUpgradeStatus() == 0 && fOTAStatusInfo.getUpgradeErrorInfo().getCode() == 0;
    }

    private static boolean d(FOTAStatusInfo fOTAStatusInfo) {
        return fOTAStatusInfo.getUpgradeStatus() == 0 && fOTAStatusInfo.getUpgradeErrorInfo().getCode() >= 121;
    }
}
