package com.haier.uhome.smart.api.interfaces;

/* JADX INFO: loaded from: classes2.dex */
public interface ISmartDeviceBindStatusListener {
    void onDeviceBindStatus(String str);

    void onDeviceUnbindStatus(String str);

    void onQueryDeviceBindStatus(String str, int i7, int i8, int i9);
}
