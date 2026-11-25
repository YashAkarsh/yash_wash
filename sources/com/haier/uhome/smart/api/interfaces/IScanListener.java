package com.haier.uhome.smart.api.interfaces;

import com.haier.uhome.usdk.base.annotation.Keep;

/* JADX INFO: loaded from: classes2.dex */
@Keep
public interface IScanListener {
    @Keep
    void notifyWifiDeviceAdd(String str, String str2, int i7, int i8);

    @Keep
    void notifyWifiDeviceDel(String str);

    @Keep
    void notifyWifiScanStatus(int i7);
}
