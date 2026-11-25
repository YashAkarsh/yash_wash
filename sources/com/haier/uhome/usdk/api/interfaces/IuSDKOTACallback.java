package com.haier.uhome.usdk.api.interfaces;

import com.haier.uhome.control.local.api.uSDKOTAStatusInfo;

/* JADX INFO: loaded from: classes2.dex */
public interface IuSDKOTACallback extends IuSDKCallback {
    void progressNotify(uSDKOTAStatusInfo usdkotastatusinfo);
}
