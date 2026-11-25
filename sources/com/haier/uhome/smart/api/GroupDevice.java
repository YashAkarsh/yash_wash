package com.haier.uhome.smart.api;

import com.haier.uhome.smart.api.interfaces.ISmartDevicePairingListener;
import com.haier.uhome.usdk.base.api.ErrorConst;
import com.haier.uhome.usdk.base.api.ICallback;
import com.haier.uhome.usdk.base.utils.b;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class GroupDevice extends AbsSmartDevice {

    public static class Builder extends AbsSmartDevice.Builder<Builder> {
        public GroupDevice builder() {
            return new GroupDevice(this);
        }
    }

    public GroupDevice(AbsSmartDevice.Builder builder) {
        super(builder);
    }

    @Override // com.haier.uhome.smart.api.AbsSmartDevice
    public void addDeviceRelation(String str, String str2, ICallback<Void> iCallback) {
        b.a((ICallback) iCallback, ErrorConst.ERR_USDK_NOT_SUPPORT.toError());
    }

    @Override // com.haier.uhome.smart.api.AbsSmartDevice
    public void addSmartDevicePairingListener(ISmartDevicePairingListener iSmartDevicePairingListener) {
    }

    @Override // com.haier.uhome.smart.api.AbsSmartDevice
    public void bindDevice(String str, double d8, ICallback<Void> iCallback) {
        b.a((ICallback) iCallback, ErrorConst.ERR_USDK_NOT_SUPPORT.toError());
    }

    @Override // com.haier.uhome.smart.api.AbsSmartDevice
    public CopyOnWriteArrayList<ISmartDevicePairingListener> getSmartDevicePairingListeners() {
        return null;
    }

    @Override // com.haier.uhome.smart.api.AbsSmartDevice
    public void reportBindProcess(int i7, String str, String str2, String str3, int i8, String str4, ICallback<Void> iCallback) {
    }

    @Override // com.haier.uhome.smart.api.AbsSmartDevice
    public void rmSmartDevicePairingListener(ISmartDevicePairingListener iSmartDevicePairingListener) {
    }

    @Override // com.haier.uhome.smart.api.AbsSmartDevice
    public void startPairingRsp(int i7, int i8, ICallback<Void> iCallback) {
        b.a((ICallback) iCallback, ErrorConst.ERR_USDK_NOT_SUPPORT.toError());
    }
}
