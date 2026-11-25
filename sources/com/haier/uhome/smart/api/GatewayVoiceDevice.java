package com.haier.uhome.smart.api;

import com.haier.uhome.smart.api.interfaces.ISmartDevicePairingListener;
import com.haier.uhome.smart.service.SmartDeviceService;
import com.haier.uhome.usdk.base.api.ErrorConst;
import com.haier.uhome.usdk.base.api.ICallback;
import com.haier.uhome.usdk.base.api.o;
import com.haier.uhome.usdk.base.utils.b;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class GatewayVoiceDevice extends AbsSmartDevice {
    private String mHwType;
    private String mHwVersion;
    private CopyOnWriteArrayList<ISmartDevicePairingListener> mSmartDevicePairingListeners;
    private String mSwType;
    private String mSwVersion;

    public static class Builder extends AbsSmartDevice.Builder<Builder> {
        private String mHwType;
        private String mHwVersion;
        private String mSwType;
        private String mSwVersion;

        public GatewayVoiceDevice build() {
            return new GatewayVoiceDevice(this);
        }

        public Builder hwType(String str) {
            this.mHwType = str;
            return this;
        }

        public Builder hwVersion(String str) {
            this.mHwVersion = str;
            return this;
        }

        public Builder swType(String str) {
            this.mSwType = str;
            return this;
        }

        public Builder swVersion(String str) {
            this.mSwVersion = str;
            return this;
        }
    }

    public GatewayVoiceDevice(Builder builder) {
        super(builder);
        this.mSwVersion = builder.mSwVersion;
        this.mHwVersion = builder.mHwVersion;
        this.mSwType = builder.mSwType;
        this.mHwType = builder.mHwType;
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
        SmartDeviceService.getInstance().bindDevice(str, getDeviceId(), d8, new o() { // from class: com.haier.uhome.smart.api.GatewayVoiceDevice.1
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

    public String getHwType() {
        return this.mHwType;
    }

    public String getHwVersion() {
        return this.mHwVersion;
    }

    @Override // com.haier.uhome.smart.api.AbsSmartDevice
    public CopyOnWriteArrayList<ISmartDevicePairingListener> getSmartDevicePairingListeners() {
        return this.mSmartDevicePairingListeners;
    }

    public String getSwType() {
        return this.mSwType;
    }

    public String getSwVersion() {
        return this.mSwVersion;
    }

    @Override // com.haier.uhome.smart.api.AbsSmartDevice
    public void reportBindProcess(int i7, String str, String str2, String str3, int i8, String str4, ICallback<Void> iCallback) {
        SmartDeviceService.getInstance().reportBindProcess(i7, getDeviceId(), str2, str3, i8, str4, iCallback);
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
