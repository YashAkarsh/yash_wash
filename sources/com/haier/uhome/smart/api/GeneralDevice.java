package com.haier.uhome.smart.api;

import com.haier.uhome.smart.api.interfaces.ISmartDevicePairingListener;
import com.haier.uhome.smart.service.SmartDeviceService;
import com.haier.uhome.usdk.base.api.ErrorConst;
import com.haier.uhome.usdk.base.api.ICallback;
import com.haier.uhome.usdk.base.api.o;
import com.haier.uhome.usdk.base.utils.b;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class GeneralDevice extends AbsSmartDevice {
    private CopyOnWriteArrayList<ISmartDevicePairingListener> mSmartDevicePairingListeners;

    public static class Builder extends AbsSmartDevice.Builder<Builder> {
        public GeneralDevice builder() {
            return new GeneralDevice(this);
        }
    }

    public GeneralDevice(AbsSmartDevice.Builder builder) {
        super(builder);
        this.mSmartDevicePairingListeners = new CopyOnWriteArrayList<>();
    }

    @Override // com.haier.uhome.smart.api.AbsSmartDevice
    public void addDeviceRelation(String str, String str2, ICallback<Void> iCallback) {
        b.a((ICallback) iCallback, ErrorConst.ERR_USDK_NOT_SUPPORT.toError());
    }

    @Override // com.haier.uhome.smart.api.AbsSmartDevice
    public void addSmartDevicePairingListener(ISmartDevicePairingListener iSmartDevicePairingListener) {
        if (iSmartDevicePairingListener != null) {
            this.mSmartDevicePairingListeners.add(iSmartDevicePairingListener);
        }
    }

    @Override // com.haier.uhome.smart.api.AbsSmartDevice
    public void bindDevice(String str, double d8, final ICallback<Void> iCallback) {
        SmartDeviceService.getInstance().bindDevice(str, getDeviceId(), d8, new o() { // from class: com.haier.uhome.smart.api.GeneralDevice.1
            @Override // com.haier.uhome.usdk.base.api.o
            public void onCallback(ErrorConst errorConst) {
                if (ErrorConst.RET_USDK_OK == errorConst) {
                    b.a((ICallback<Object>) iCallback, (Object) null);
                } else {
                    b.a(iCallback, errorConst.toError());
                }
            }
        });
    }

    @Override // com.haier.uhome.smart.api.AbsSmartDevice
    public CopyOnWriteArrayList<ISmartDevicePairingListener> getSmartDevicePairingListeners() {
        return this.mSmartDevicePairingListeners;
    }

    @Override // com.haier.uhome.smart.api.AbsSmartDevice
    public void reportBindProcess(int i7, String str, String str2, String str3, int i8, String str4, ICallback<Void> iCallback) {
        b.a((ICallback) iCallback, ErrorConst.ERR_USDK_NOT_SUPPORT.toError());
    }

    @Override // com.haier.uhome.smart.api.AbsSmartDevice
    public void rmSmartDevicePairingListener(ISmartDevicePairingListener iSmartDevicePairingListener) {
        if (iSmartDevicePairingListener != null) {
            this.mSmartDevicePairingListeners.remove(iSmartDevicePairingListener);
        }
    }

    @Override // com.haier.uhome.smart.api.AbsSmartDevice
    public void startPairingRsp(int i7, int i8, ICallback<Void> iCallback) {
        SmartDeviceService.getInstance().startPairingRsp(i7, i8, iCallback);
    }
}
