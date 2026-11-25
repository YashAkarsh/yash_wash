package com.haier.uhome.usdk.bind;

import android.text.TextUtils;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class SmartLinkBindInfo extends BaseBindInfo<Builder> {
    private String appTypeCode;
    private String bssid;
    private String deviceId;
    private boolean isSecurity;
    private String password;
    private String productCode;
    private String ssid;
    private ArrayList<String> uplusIdList;

    public static final class Builder extends BaseBindInfo.a<Builder, SmartLinkBindInfo> {
        private String appTypeCode;
        private String bssid;
        private String deviceId;
        private boolean isSecurity;
        private String password;
        private String productCode;
        private String ssid;
        private ArrayList<String> uplusIdList;

        public Builder() {
            this.ssid = null;
            this.bssid = com.haier.library.common.util.w.j(com.haier.uhome.usdk.base.service.e.a().b());
            this.password = null;
            this.uplusIdList = null;
            this.deviceId = null;
            this.isSecurity = false;
        }

        public Builder appTypeCode(String str) {
            this.appTypeCode = str;
            return this;
        }

        public Builder deviceId(String str) {
            this.deviceId = str == null ? null : str.toUpperCase();
            return this;
        }

        public Builder productCode(String str) {
            this.productCode = str;
            return this;
        }

        public Builder routerInfo(String str, String str2) {
            this.ssid = str;
            this.password = str2;
            return this;
        }

        public Builder security(boolean z7) {
            this.isSecurity = z7;
            return this;
        }

        public Builder uplusIds(ArrayList<String> arrayList) {
            this.uplusIdList = arrayList;
            return this;
        }

        @Override // com.haier.uhome.usdk.bind.l.a
        public SmartLinkBindInfo build() {
            return new SmartLinkBindInfo(this);
        }

        protected Builder(SmartLinkBindInfo smartLinkBindInfo) {
            super(smartLinkBindInfo);
            this.ssid = smartLinkBindInfo.ssid;
            this.bssid = TextUtils.isEmpty(smartLinkBindInfo.bssid) ? com.haier.library.common.util.w.j(com.haier.uhome.usdk.base.service.e.a().b()) : smartLinkBindInfo.bssid;
            this.deviceId = smartLinkBindInfo.deviceId;
            this.password = smartLinkBindInfo.password;
            this.uplusIdList = smartLinkBindInfo.uplusIdList;
            this.isSecurity = smartLinkBindInfo.isSecurity;
        }
    }

    public String getAppTypeCode() {
        return this.appTypeCode;
    }

    public String getBssid() {
        return this.bssid;
    }

    public String getDeviceId() {
        return this.deviceId;
    }

    public String getPassword() {
        return this.password;
    }

    public String getProductCode() {
        return this.productCode;
    }

    public String getSsid() {
        return this.ssid;
    }

    public ArrayList<String> getUplusIdList() {
        return this.uplusIdList;
    }

    public boolean isSecurity() {
        return this.isSecurity;
    }

    private SmartLinkBindInfo(Builder builder) {
        super(builder);
        this.ssid = builder.ssid;
        this.password = builder.password;
        this.deviceId = builder.deviceId;
        this.bssid = builder.bssid;
        this.uplusIdList = builder.uplusIdList;
        this.isSecurity = builder.isSecurity;
        this.productCode = builder.productCode;
        this.appTypeCode = builder.appTypeCode;
    }

    @Override // com.haier.uhome.usdk.bind.l
    public Builder rebuild() {
        return new Builder(this);
    }
}
