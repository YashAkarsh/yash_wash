package com.haier.uhome.usdk.bind;

import com.haier.uhome.usdk.base.annotation.Keep;

/* JADX INFO: loaded from: classes2.dex */
@Keep
public class BLEAdvBindInfo extends BaseBleBindInfo<Builder> {

    public static final class Builder extends BaseBleBindInfo.a<Builder, BLEAdvBindInfo> {
        public Builder() {
        }

        public Builder(BLEAdvBindInfo bLEAdvBindInfo) {
            super(bLEAdvBindInfo);
        }

        @Override // com.haier.uhome.usdk.bind.l.a
        public BLEAdvBindInfo build() {
            return new BLEAdvBindInfo(this);
        }
    }

    private BLEAdvBindInfo(Builder builder) {
        super(builder);
    }

    @Override // com.haier.uhome.usdk.bind.l
    public Builder rebuild() {
        return new Builder(this);
    }
}
