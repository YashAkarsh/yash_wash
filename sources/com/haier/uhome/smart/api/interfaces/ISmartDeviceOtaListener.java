package com.haier.uhome.smart.api.interfaces;

/* JADX INFO: loaded from: classes2.dex */
public interface ISmartDeviceOtaListener {
    void onOtaDownload(String str, String str2, String str3, String str4);

    void onOtaDownloadFinish(String str, String str2, int i7, String str3);

    void onOtaDownloadStart(String str, String str2, String str3, String str4);
}
