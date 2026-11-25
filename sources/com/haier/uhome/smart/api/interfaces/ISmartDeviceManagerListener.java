package com.haier.uhome.smart.api.interfaces;

/* JADX INFO: loaded from: classes2.dex */
public interface ISmartDeviceManagerListener {
    void onAuthToken(int i7, String str);

    void onCloudState(int i7);

    void onDeviceAdd(String str);

    void onDeviceRemove(String str);
}
