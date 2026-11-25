package com.haier.uhome.usdk.bind;

import com.haier.uhome.usdk.scanner.ConfigurableDevice;

/* JADX INFO: loaded from: classes2.dex */
public class NewDirectLinkVerificationCodeBindInfo extends BaseBindInfo<Builder> {
    private ConfigurableDevice mConfigurableDevice;
    private String mVerificationCode;

    public static final class Builder extends BaseBindInfo.a<Builder, NewDirectLinkVerificationCodeBindInfo> {
        private ConfigurableDevice configurableDevice;
        private String verificationCode;

        public Builder() {
        }

        public Builder setConfigurableDevice(ConfigurableDevice configurableDevice) {
            this.configurableDevice = configurableDevice;
            return this;
        }

        public Builder setVerificationCode(String str) {
            this.verificationCode = str;
            return this;
        }

        public Builder(NewDirectLinkVerificationCodeBindInfo newDirectLinkVerificationCodeBindInfo) {
            super(newDirectLinkVerificationCodeBindInfo);
            this.configurableDevice = newDirectLinkVerificationCodeBindInfo.getConfigurableDevice();
        }

        @Override // com.haier.uhome.usdk.bind.l.a
        public NewDirectLinkVerificationCodeBindInfo build() {
            return new NewDirectLinkVerificationCodeBindInfo(this);
        }
    }

    public ConfigurableDevice getConfigurableDevice() {
        return this.mConfigurableDevice;
    }

    public String getVerificationCode() {
        return this.mVerificationCode;
    }

    private NewDirectLinkVerificationCodeBindInfo(Builder builder) {
        super(builder);
        this.mConfigurableDevice = builder.configurableDevice;
        this.mVerificationCode = builder.verificationCode;
    }

    @Override // com.haier.uhome.usdk.bind.l
    public Builder rebuild() {
        return new Builder(this);
    }
}
