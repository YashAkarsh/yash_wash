package com.haier.uhome.smart.api.interfaces;

/* JADX INFO: loaded from: classes2.dex */
public interface ISmartDeviceMessageListener {
    void onMessageReceive(String str, String str2, String str3);

    void onRegisterMessageAck(String str, String str2, int i7, int i8);

    void onUnRegisterMessageAck(String str, String str2, int i7, int i8);
}
