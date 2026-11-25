package com.haier.uhome.usdk.bind;

/* JADX INFO: loaded from: classes2.dex */
public class BLEMeshBindInfo extends BaseBleBindInfo<Builder> {

    public static class Builder extends BaseBleBindInfo.a<Builder, BLEMeshBindInfo> {
        public Builder() {
        }

        public Builder(BLEMeshBindInfo bLEMeshBindInfo) {
            super(bLEMeshBindInfo);
        }

        @Override // com.haier.uhome.usdk.bind.l.a
        public BLEMeshBindInfo build() {
            return new BLEMeshBindInfo(this);
        }
    }

    private BLEMeshBindInfo(Builder builder) {
        super(builder);
    }

    @Override // com.haier.uhome.usdk.bind.l
    public Builder rebuild() {
        return new Builder(this);
    }
}
