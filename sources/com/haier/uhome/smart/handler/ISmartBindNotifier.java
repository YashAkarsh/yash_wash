package com.haier.uhome.smart.handler;

/* JADX INFO: loaded from: classes2.dex */
public interface ISmartBindNotifier {
    void notifyConfigProgress(int i7, int i8);

    void notifyConfigResult(int i7, int i8);

    void notifyWifiAddDevice(String str, String str2, int i7, int i8, int i9);

    void notifyWifiDelDevice(String str, int i7);

    void notifyWifiScanStatus(int i7, int i8);
}
