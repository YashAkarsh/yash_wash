package com.haier.uhome.usdk.bind;

/* JADX INFO: loaded from: classes2.dex */
public class PureBLEBindInfo extends BaseBleBindInfo<Builder> {

    public static class Builder extends BaseBleBindInfo.a<Builder, PureBLEBindInfo> {
        public Builder() {
        }

        protected Builder(PureBLEBindInfo pureBLEBindInfo) {
            super(pureBLEBindInfo);
        }

        @Override // com.haier.uhome.usdk.bind.l.a
        public PureBLEBindInfo build() {
            return new PureBLEBindInfo(this);
        }
    }

    protected PureBLEBindInfo(Builder builder) {
        super(builder);
    }

    @Override // com.haier.uhome.usdk.bind.l
    public Builder rebuild() {
        return new Builder(this);
    }
}
