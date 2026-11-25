package com.haier.uhome.smart.handler;

/* JADX INFO: loaded from: classes2.dex */
public interface ISmartDeviceOtaNotifer {
    void notifyDeviceOtaDownload(String str, String str2, String str3, String str4, int i7);

    void notifyDeviceOtaDownloadFinish(String str, String str2, int i7, String str3, int i8);

    void notifyDeviceOtaDownloadStart(String str, String str2, String str3, String str4, int i7);
}
