package com.haier.uhome.usdk.bind;

import com.haier.uhome.usdk.api.uSDKDevice;

/* JADX INFO: loaded from: classes2.dex */
public class SlaveDeviceBindInfo extends BaseBindInfo<Builder> {
    private String extendInfo;
    private uSDKDevice masterDevice;
    private String productCode;
    private String uplusID;

    public static final class Builder extends BaseBindInfo.a<Builder, SlaveDeviceBindInfo> {
        private String extendInfo;
        private uSDKDevice masterDevice;
        private String productCode;
        private String uplusID;

        public Builder extendInfo(String str) {
            this.extendInfo = str;
            return this;
        }

        public Builder masterDevice(uSDKDevice usdkdevice) {
            this.masterDevice = usdkdevice;
            return this;
        }

        public Builder productCode(String str) {
            this.productCode = str;
            return this;
        }

        public Builder uplusID(String str) {
            this.uplusID = str;
            return this;
        }

        public Builder() {
            this.masterDevice = null;
            this.uplusID = null;
            this.productCode = null;
            this.extendInfo = null;
        }

        @Override // com.haier.uhome.usdk.bind.l.a
        public SlaveDeviceBindInfo build() {
            return new SlaveDeviceBindInfo(this);
        }

        private Builder(SlaveDeviceBindInfo slaveDeviceBindInfo) {
            super(slaveDeviceBindInfo);
            this.masterDevice = slaveDeviceBindInfo.masterDevice;
            this.uplusID = slaveDeviceBindInfo.uplusID;
            this.productCode = slaveDeviceBindInfo.productCode;
            this.extendInfo = slaveDeviceBindInfo.extendInfo;
        }
    }

    public String getExtendInfo() {
        return this.extendInfo;
    }

    public uSDKDevice getMasterDevice() {
        return this.masterDevice;
    }

    public String getProductCode() {
        return this.productCode;
    }

    public String getUplusID() {
        return this.uplusID;
    }

    private SlaveDeviceBindInfo(Builder builder) {
        super(builder);
        this.masterDevice = builder.masterDevice;
        this.uplusID = builder.uplusID;
        this.productCode = builder.productCode;
        this.extendInfo = builder.extendInfo;
    }

    @Override // com.haier.uhome.usdk.bind.l
    public Builder rebuild() {
        return new Builder();
    }
}
