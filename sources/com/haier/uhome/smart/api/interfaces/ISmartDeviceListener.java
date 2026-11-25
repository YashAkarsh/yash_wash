package com.haier.uhome.smart.api.interfaces;

import com.haier.uhome.smart.api.BaseSmartRsp;
import com.haier.uhome.smart.api.SmartDevicePair;
import com.haier.uhome.smart.api.SmartOpRsp;
import com.haier.uhome.smart.api.SmartReadRsp;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public interface ISmartDeviceListener {
    void onBusinessDown(String str, String str2, byte[] bArr);

    void onCloudMsg(String str, int i7, int i8);

    void onDeviceBindCallback(String str, int i7, int i8);

    SmartOpRsp onDeviceOpCallback(String str, int i7, String str2, List<SmartDevicePair> list);

    SmartReadRsp onDeviceReadCallback(String str, int i7, String str2);

    BaseSmartRsp onDeviceWriteCallback(String str, int i7, String str2, String str3);
}
