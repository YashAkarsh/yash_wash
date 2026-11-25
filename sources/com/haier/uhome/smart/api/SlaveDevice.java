package com.haier.uhome.smart.api;

import com.haier.uhome.smart.api.interfaces.ISmartDevicePairingListener;
import com.haier.uhome.smart.service.SmartDeviceService;
import com.haier.uhome.usdk.base.api.ErrorConst;
import com.haier.uhome.usdk.base.api.ICallback;
import com.haier.uhome.usdk.base.utils.b;
import e3.a;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class SlaveDevice extends AbsSmartDevice {
    private String mParentId;
    private CommunicationProtocol mProtocol;

    public static class Builder extends AbsSmartDevice.Builder<Builder> {
        private String mParentId = null;
        private CommunicationProtocol mProtocol;

        public SlaveDevice builder() {
            return new SlaveDevice(this);
        }

        public Builder parentId(String str) {
            this.mParentId = str;
            return this;
        }

        public Builder protocol(CommunicationProtocol communicationProtocol) {
            this.mProtocol = communicationProtocol;
            return this;
        }
    }

    public SlaveDevice(Builder builder) {
        super(builder);
        this.mParentId = builder.mParentId;
        this.mProtocol = builder.mProtocol;
    }

    @Override // com.haier.uhome.smart.api.AbsSmartDevice
    public void addDeviceRelation(String str, String str2, ICallback<Void> iCallback) {
        SmartDeviceService.getInstance().addDeviceRelation(str, str2, iCallback);
    }

    @Override // com.haier.uhome.smart.api.AbsSmartDevice
    public void addSmartDevicePairingListener(ISmartDevicePairingListener iSmartDevicePairingListener) {
        a.h("SlaveDevice can not addSmartDevicePairingListener", new Object[0]);
    }

    @Override // com.haier.uhome.smart.api.AbsSmartDevice
    public void bindDevice(String str, double d8, ICallback<Void> iCallback) {
        b.a((ICallback) iCallback, ErrorConst.ERR_USDK_NOT_SUPPORT.toError());
    }

    public String getParentId() {
        return this.mParentId;
    }

    public CommunicationProtocol getProtocol() {
        return this.mProtocol;
    }

    @Override // com.haier.uhome.smart.api.AbsSmartDevice
    public CopyOnWriteArrayList<ISmartDevicePairingListener> getSmartDevicePairingListeners() {
        return null;
    }

    @Override // com.haier.uhome.smart.api.AbsSmartDevice
    public void reportBindProcess(int i7, String str, String str2, String str3, int i8, String str4, ICallback<Void> iCallback) {
        b.a((ICallback) iCallback, ErrorConst.ERR_USDK_NOT_SUPPORT.toError());
    }

    @Override // com.haier.uhome.smart.api.AbsSmartDevice
    public void rmSmartDevicePairingListener(ISmartDevicePairingListener iSmartDevicePairingListener) {
        a.h("SlaveDevice can not rmSmartDevicePairingListener", new Object[0]);
    }

    @Override // com.haier.uhome.smart.api.AbsSmartDevice
    public void startPairingRsp(int i7, int i8, ICallback<Void> iCallback) {
        b.a((ICallback) iCallback, ErrorConst.ERR_USDK_NOT_SUPPORT.toError());
    }
}
