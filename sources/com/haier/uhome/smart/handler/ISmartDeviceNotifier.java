package com.haier.uhome.smart.handler;

import com.haier.uhome.smart.json.Pair;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public interface ISmartDeviceNotifier {
    void notifyDeviceAuthToken(int i7, String str, int i8);

    void notifyDeviceBindResult(String str, int i7, int i8, int i9);

    void notifyDeviceBindStatus(String str, int i7);

    void notifyDeviceBindWindow(String str, String str2, int i7, int i8);

    void notifyDeviceBusinessDown(String str, String str2, byte[] bArr, int i7);

    void notifyDeviceCloudMsg(String str, int i7, int i8, int i9);

    void notifyDeviceCloudState(int i7, int i8);

    void notifyDeviceDepairing(String str, String str2, int i7);

    void notifyDeviceGetLocalKey(String str, String str2, int i7, int i8, int i9, int i10);

    void notifyDeviceOp(String str, int i7, String str2, ArrayList<Pair> arrayList, int i8);

    void notifyDevicePairing(String str, int i7, String str2, String str3, String str4, int i8);

    void notifyDeviceRead(String str, int i7, String str2, int i8);

    void notifyDeviceRegisterRes(String str, String str2, int i7);

    void notifyDeviceRelationResult(String str, int i7);

    void notifyDeviceResChannalStatus(String str, int i7, int i8);

    void notifyDeviceUnbindStatus(String str, int i7);

    void notifyDeviceWrite(String str, int i7, String str2, String str3, int i8);

    void notifyQueryDeviceBindStatus(String str, int i7, int i8, int i9, int i10);

    void notifySlaveDeviceBindResult(String str, int i7);

    void notifySlaveDeviceUnbindResult(String str, int i7);

    void notifyUSDKReq(String str, int i7, int i8, int i9);
}
