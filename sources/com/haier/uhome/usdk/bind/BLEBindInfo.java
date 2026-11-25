package com.haier.uhome.usdk.bind;

/* JADX INFO: loaded from: classes2.dex */
public final class BLEBindInfo extends BaseBleBindInfo<Builder> {
    private String mBssid;
    private String mPassword;
    private String mSsid;

    public static final class Builder extends BaseBleBindInfo.a<Builder, BLEBindInfo> {
        private String mBssid;
        private String mPassword;
        private String mSsid;

        public Builder() {
            this.mSsid = null;
            this.mBssid = null;
            this.mPassword = null;
        }

        public Builder routerInfo(String str, String str2, String str3) {
            this.mSsid = str;
            this.mBssid = str2 == null ? null : str2.replace(":", "").toUpperCase();
            this.mPassword = str3;
            return this;
        }

        @Override // com.haier.uhome.usdk.bind.l.a
        public BLEBindInfo build() {
            return new BLEBindInfo(this);
        }

        public Builder(BLEBindInfo bLEBindInfo) {
            super(bLEBindInfo);
            this.mSsid = bLEBindInfo.mSsid;
            this.mBssid = bLEBindInfo.mBssid;
            this.mPassword = bLEBindInfo.mPassword;
        }
    }

    public String getBssid() {
        return this.mBssid;
    }

    public String getPassword() {
        return this.mPassword;
    }

    public String getSsid() {
        return this.mSsid;
    }

    private BLEBindInfo(Builder builder) {
        super(builder);
        this.mSsid = builder.mSsid;
        this.mBssid = builder.mBssid;
        this.mPassword = builder.mPassword == null ? "" : builder.mPassword;
    }

    @Override // com.haier.uhome.usdk.bind.l
    public Builder rebuild() {
        return new Builder(this);
    }
}
