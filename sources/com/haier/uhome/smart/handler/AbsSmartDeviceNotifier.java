package com.haier.uhome.smart.handler;

import com.haier.uhome.smart.json.Pair;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public abstract class AbsSmartDeviceNotifier implements ISmartDeviceNotifier {
    @Override // com.haier.uhome.smart.handler.ISmartDeviceNotifier
    public void notifyDeviceAuthToken(int i7, String str, int i8) {
    }

    @Override // com.haier.uhome.smart.handler.ISmartDeviceNotifier
    public void notifyDeviceBindResult(String str, int i7, int i8, int i9) {
    }

    @Override // com.haier.uhome.smart.handler.ISmartDeviceNotifier
    public void notifyDeviceBindStatus(String str, int i7) {
    }

    @Override // com.haier.uhome.smart.handler.ISmartDeviceNotifier
    public void notifyDeviceBindWindow(String str, String str2, int i7, int i8) {
    }

    @Override // com.haier.uhome.smart.handler.ISmartDeviceNotifier
    public void notifyDeviceBusinessDown(String str, String str2, byte[] bArr, int i7) {
    }

    @Override // com.haier.uhome.smart.handler.ISmartDeviceNotifier
    public void notifyDeviceCloudMsg(String str, int i7, int i8, int i9) {
    }

    @Override // com.haier.uhome.smart.handler.ISmartDeviceNotifier
    public void notifyDeviceCloudState(int i7, int i8) {
    }

    @Override // com.haier.uhome.smart.handler.ISmartDeviceNotifier
    public void notifyDeviceDepairing(String str, String str2, int i7) {
    }

    @Override // com.haier.uhome.smart.handler.ISmartDeviceNotifier
    public void notifyDeviceGetLocalKey(String str, String str2, int i7, int i8, int i9, int i10) {
    }

    @Override // com.haier.uhome.smart.handler.ISmartDeviceNotifier
    public void notifyDeviceOp(String str, int i7, String str2, ArrayList<Pair> arrayList, int i8) {
    }

    @Override // com.haier.uhome.smart.handler.ISmartDeviceNotifier
    public void notifyDevicePairing(String str, int i7, String str2, String str3, String str4, int i8) {
    }

    @Override // com.haier.uhome.smart.handler.ISmartDeviceNotifier
    public void notifyDeviceRead(String str, int i7, String str2, int i8) {
    }

    @Override // com.haier.uhome.smart.handler.ISmartDeviceNotifier
    public void notifyDeviceRegisterRes(String str, String str2, int i7) {
    }

    @Override // com.haier.uhome.smart.handler.ISmartDeviceNotifier
    public void notifyDeviceRelationResult(String str, int i7) {
    }

    @Override // com.haier.uhome.smart.handler.ISmartDeviceNotifier
    public void notifyDeviceResChannalStatus(String str, int i7, int i8) {
    }

    @Override // com.haier.uhome.smart.handler.ISmartDeviceNotifier
    public void notifyDeviceUnbindStatus(String str, int i7) {
    }

    @Override // com.haier.uhome.smart.handler.ISmartDeviceNotifier
    public void notifyDeviceWrite(String str, int i7, String str2, String str3, int i8) {
    }

    @Override // com.haier.uhome.smart.handler.ISmartDeviceNotifier
    public void notifyQueryDeviceBindStatus(String str, int i7, int i8, int i9, int i10) {
    }

    @Override // com.haier.uhome.smart.handler.ISmartDeviceNotifier
    public void notifySlaveDeviceBindResult(String str, int i7) {
    }

    @Override // com.haier.uhome.smart.handler.ISmartDeviceNotifier
    public void notifySlaveDeviceUnbindResult(String str, int i7) {
    }

    @Override // com.haier.uhome.smart.handler.ISmartDeviceNotifier
    public void notifyUSDKReq(String str, int i7, int i8, int i9) {
    }
}
