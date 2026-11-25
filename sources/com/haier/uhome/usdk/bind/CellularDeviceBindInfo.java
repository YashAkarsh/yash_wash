package com.haier.uhome.usdk.bind;

import com.haier.uhome.usdk.base.annotation.Keep;

/* JADX INFO: loaded from: classes2.dex */
@Keep
public class CellularDeviceBindInfo extends BaseBindInfo<Builder> {

    @Keep
    private String moduleID;

    @Keep
    public static class Builder extends BaseBindInfo.a<Builder, CellularDeviceBindInfo> {

        @Keep
        private String moduleID;

        @Keep
        public Builder moduleID(String str) {
            this.moduleID = str;
            return this;
        }

        @Keep
        public Builder() {
        }

        @Override // com.haier.uhome.usdk.bind.l.a
        @Keep
        public CellularDeviceBindInfo build() {
            return new CellularDeviceBindInfo(this);
        }

        @Keep
        private Builder(CellularDeviceBindInfo cellularDeviceBindInfo) {
            super(cellularDeviceBindInfo);
            this.moduleID = cellularDeviceBindInfo.moduleID;
        }
    }

    @Keep
    protected CellularDeviceBindInfo(Builder builder) {
        super(builder);
        this.moduleID = builder.moduleID;
    }

    @Keep
    public String getModuleID() {
        return this.moduleID;
    }

    @Override // com.haier.uhome.usdk.bind.l
    @Keep
    public Builder rebuild() {
        return new Builder();
    }
}
