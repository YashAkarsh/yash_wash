package com.haier.uhome.usdk.bind;

import com.haier.uhome.usdk.base.annotation.Keep;
import com.haier.uhome.usdk.bind.BaseBleBindInfo.a;
import com.haier.uhome.usdk.scanner.ConfigurableDevice;

/* JADX INFO: loaded from: classes2.dex */
@Keep
public abstract class BaseBleBindInfo<B extends a> extends BaseBindInfo<B> {
    private ConfigurableDevice mConfigurableDevice;

    public static abstract class a<B extends BaseBindInfo.a, I extends BaseBleBindInfo> extends BaseBindInfo.a<B, I> {
        ConfigurableDevice mConfigurableDevice;

        public a() {
        }

        @Keep
        public B setConfigurableDevice(ConfigurableDevice configurableDevice) {
            this.mConfigurableDevice = configurableDevice;
            return this;
        }

        protected a(I i7) {
            super(i7);
            this.mConfigurableDevice = i7.getConfigurableDevice();
        }
    }

    protected BaseBleBindInfo(B b8) {
        super(b8);
        this.mConfigurableDevice = b8.mConfigurableDevice;
    }

    public ConfigurableDevice getConfigurableDevice() {
        return this.mConfigurableDevice;
    }

    @Deprecated
    public void setConfigurableDevice(ConfigurableDevice configurableDevice) {
        this.mConfigurableDevice = configurableDevice;
    }
}
