package com.haier.uhome.usdk.bind;

import com.haier.uhome.usdk.scanner.ConfigurableDevice;

/* JADX INFO: loaded from: classes2.dex */
public class NewDirectLinkManualConfirmBindInfo extends BaseBindInfo<Builder> {
    private ConfigurableDevice mConfigurableDevice;

    public static final class Builder extends BaseBindInfo.a<Builder, NewDirectLinkManualConfirmBindInfo> {
        private ConfigurableDevice configurableDevice;

        public Builder setConfigurableDevice(ConfigurableDevice configurableDevice) {
            this.configurableDevice = configurableDevice;
            return this;
        }

        public Builder() {
        }

        @Override // com.haier.uhome.usdk.bind.l.a
        public NewDirectLinkManualConfirmBindInfo build() {
            return new NewDirectLinkManualConfirmBindInfo(this);
        }

        private Builder(NewDirectLinkManualConfirmBindInfo newDirectLinkManualConfirmBindInfo) {
            super(newDirectLinkManualConfirmBindInfo);
            this.configurableDevice = newDirectLinkManualConfirmBindInfo.mConfigurableDevice;
        }
    }

    public ConfigurableDevice getConfigurableDevice() {
        return this.mConfigurableDevice;
    }

    private NewDirectLinkManualConfirmBindInfo(Builder builder) {
        super(builder);
        this.mConfigurableDevice = builder.configurableDevice;
    }

    @Override // com.haier.uhome.usdk.bind.l
    public Builder rebuild() {
        return new Builder();
    }
}
