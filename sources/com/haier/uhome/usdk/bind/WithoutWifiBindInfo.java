package com.haier.uhome.usdk.bind;

import com.haier.uhome.usdk.base.annotation.Keep;

/* JADX INFO: loaded from: classes2.dex */
@Keep
public final class WithoutWifiBindInfo extends BaseBleBindInfo<Builder> {

    @Keep
    public static final class Builder extends BaseBleBindInfo.a<Builder, WithoutWifiBindInfo> {
        @Keep
        public Builder() {
        }

        @Keep
        public Builder(WithoutWifiBindInfo withoutWifiBindInfo) {
            super(withoutWifiBindInfo);
        }

        @Override // com.haier.uhome.usdk.bind.l.a
        @Keep
        public WithoutWifiBindInfo build() {
            return new WithoutWifiBindInfo(this);
        }
    }

    private WithoutWifiBindInfo(Builder builder) {
        super(builder);
    }

    @Override // com.haier.uhome.usdk.bind.l
    @Keep
    public Builder rebuild() {
        return new Builder(this);
    }
}
