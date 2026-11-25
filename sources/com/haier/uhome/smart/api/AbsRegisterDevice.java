package com.haier.uhome.smart.api;

/* JADX INFO: loaded from: classes2.dex */
public abstract class AbsRegisterDevice {
    private String mDeviceKey;
    private String mMac;
    private CommunicationProtocol mProtocol;
    private String mUpCodeT;
    private String mUplusId;

    protected static abstract class Builder<B extends Builder<B>> {
        String mDeviceKey;
        String mMac;
        CommunicationProtocol mProtocol;
        String mUpCodeT;
        String mUplusId;

        protected Builder() {
        }

        public B deviceKey(String str) {
            this.mDeviceKey = str;
            return this;
        }

        public B mac(String str) {
            this.mMac = str;
            return this;
        }

        public B protocol(CommunicationProtocol communicationProtocol) {
            this.mProtocol = communicationProtocol;
            return this;
        }

        public B upCodeT(String str) {
            this.mUpCodeT = str;
            return this;
        }

        public B uplusId(String str) {
            this.mUplusId = str;
            return this;
        }
    }

    public AbsRegisterDevice(Builder builder) {
        this.mMac = builder.mMac;
        this.mUpCodeT = builder.mUpCodeT;
        this.mUplusId = builder.mUplusId;
        this.mDeviceKey = builder.mDeviceKey;
        this.mProtocol = builder.mProtocol;
    }

    public String getDeviceKey() {
        return this.mDeviceKey;
    }

    public String getMac() {
        return this.mMac;
    }

    public CommunicationProtocol getProtocol() {
        return this.mProtocol;
    }

    public String getUpCodeT() {
        return this.mUpCodeT;
    }

    public String getUplusId() {
        return this.mUplusId;
    }
}
