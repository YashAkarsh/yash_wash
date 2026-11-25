package com.haier.uhome.usdk.bind;

import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class SoftApBindInfo extends BaseBindInfo<Builder> {
    private String mBssid;
    private String mCountry;
    private String mIotDevBssid;
    private String mIotDeviceSSID;
    private String mMainGatewayDomain;
    private int mMainGatewayPort;
    private String mPassword;
    private boolean mSecurity;
    private String mSsid;
    private boolean mTimerValidInBackground;
    private List<String> mUplusIds;

    public static final class Builder extends BaseBindInfo.a<Builder, SoftApBindInfo> {
        private String mBssid;
        private String mCountry;
        private String mIotDevBssid;
        private String mIotDeviceSSID;
        private String mMainGatewayDomain;
        private int mMainGatewayPort;
        private String mPassword;
        private boolean mSecurity;
        private String mSsid;
        private boolean mTimerValidInBackground;
        private List<String> mUplusIds;

        public Builder country(String str) {
            this.mCountry = str;
            return this;
        }

        @Deprecated
        public Builder iotDevBssid(String str) {
            this.mIotDevBssid = com.haier.library.common.util.w.c(str);
            return this;
        }

        public Builder iotDeviceSSID(String str) {
            this.mIotDeviceSSID = str;
            return this;
        }

        public Builder mainGateway(String str, int i7) {
            this.mMainGatewayDomain = str;
            this.mMainGatewayPort = i7;
            return this;
        }

        public Builder routerInfo(String str, String str2, String str3) {
            this.mSsid = str;
            this.mBssid = com.haier.library.common.util.w.c(str2);
            this.mPassword = str3;
            return this;
        }

        public Builder security(boolean z7) {
            this.mSecurity = z7;
            return this;
        }

        public Builder timerValidInBackground(boolean z7) {
            this.mTimerValidInBackground = z7;
            return this;
        }

        public Builder() {
            this.mSsid = null;
            this.mBssid = null;
            this.mPassword = null;
            this.mMainGatewayDomain = null;
            this.mMainGatewayPort = 0;
            this.mCountry = null;
            this.mUplusIds = null;
            this.mSecurity = false;
            this.mTimerValidInBackground = true;
            this.mIotDevBssid = null;
        }

        @Override // com.haier.uhome.usdk.bind.l.a
        public SoftApBindInfo build() {
            return new SoftApBindInfo(this);
        }

        private Builder(SoftApBindInfo softApBindInfo) {
            super(softApBindInfo);
            this.mSsid = softApBindInfo.mSsid;
            this.mBssid = softApBindInfo.mBssid;
            this.mPassword = softApBindInfo.mPassword;
            this.mMainGatewayDomain = softApBindInfo.mMainGatewayDomain;
            this.mMainGatewayPort = softApBindInfo.mMainGatewayPort;
            this.mCountry = softApBindInfo.mCountry;
            this.mUplusIds = softApBindInfo.mUplusIds;
            this.mSecurity = softApBindInfo.mSecurity;
            this.mTimerValidInBackground = softApBindInfo.mTimerValidInBackground;
        }
    }

    public String getBssid() {
        return this.mBssid;
    }

    public String getCountry() {
        return this.mCountry;
    }

    public String getIotDevBssid() {
        return this.mIotDevBssid;
    }

    public String getIotDeviceSSID() {
        return this.mIotDeviceSSID;
    }

    public String getMainGatewayDomain() {
        return this.mMainGatewayDomain;
    }

    public int getMainGatewayPort() {
        return this.mMainGatewayPort;
    }

    public String getPassword() {
        return this.mPassword;
    }

    public String getSsid() {
        return this.mSsid;
    }

    public List<String> getUplusIds() {
        return this.mUplusIds;
    }

    public boolean isSecurity() {
        return this.mSecurity;
    }

    public boolean isTimerValidInBackground() {
        return this.mTimerValidInBackground;
    }

    private SoftApBindInfo(Builder builder) {
        super(builder);
        this.mSsid = builder.mSsid;
        this.mBssid = builder.mBssid;
        this.mPassword = builder.mPassword == null ? "" : builder.mPassword;
        this.mMainGatewayDomain = builder.mMainGatewayDomain;
        this.mMainGatewayPort = builder.mMainGatewayPort;
        this.mCountry = builder.mCountry;
        this.mUplusIds = builder.mUplusIds;
        this.mSecurity = builder.mSecurity;
        this.mTimerValidInBackground = builder.mTimerValidInBackground;
        this.mIotDevBssid = builder.mIotDevBssid;
        this.mIotDeviceSSID = builder.mIotDeviceSSID;
    }

    @Override // com.haier.uhome.usdk.bind.l
    public Builder rebuild() {
        return new Builder();
    }
}
