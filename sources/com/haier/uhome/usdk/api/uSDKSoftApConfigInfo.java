package com.haier.uhome.usdk.api;

import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class uSDKSoftApConfigInfo {
    private final String country;
    private final String mainGatewayDomain;
    private final int mainGatewayPort;
    private final String password;
    private final boolean security;
    private final String ssid;
    private final int timeout;
    private final boolean timerValidInBackground;
    private final List<String> uplusIDList;

    public String getCountry() {
        return this.country;
    }

    public String getMainGatewayDomain() {
        return this.mainGatewayDomain;
    }

    public int getMainGatewayPort() {
        return this.mainGatewayPort;
    }

    public String getPassword() {
        return this.password;
    }

    public String getSsid() {
        return this.ssid;
    }

    public int getTimeout() {
        return this.timeout;
    }

    public List<String> getUplusIDList() {
        return this.uplusIDList;
    }

    public boolean isSecurity() {
        return this.security;
    }

    public boolean isTimerValidInBackground() {
        return this.timerValidInBackground;
    }

    public String toString() {
        return "uSDKSoftApConfigInfo{ssid='" + this.ssid + "', password='****', timeout=" + this.timeout + ", security=" + this.security + ", uplusIDList=" + this.uplusIDList + ", timerValidInBackground=" + this.timerValidInBackground + ", mainGatewayDomain='" + this.mainGatewayDomain + "', mainGatewayPort=" + this.mainGatewayPort + ", country='" + this.country + "'}";
    }

    private uSDKSoftApConfigInfo(Builder builder) {
        this.ssid = builder.ssid;
        this.password = builder.password == null ? "" : builder.password;
        this.timeout = builder.timeout;
        this.security = builder.security;
        this.uplusIDList = builder.uplusIDList;
        this.timerValidInBackground = builder.timerValidInBackground;
        this.mainGatewayDomain = builder.mainGatewayDomain;
        this.mainGatewayPort = builder.mainGatewayPort;
        this.country = builder.country;
    }

    public static final class Builder {
        private String country;
        private String mainGatewayDomain;
        private int mainGatewayPort;
        private String password;
        private boolean security;
        private String ssid;
        private int timeout;
        private boolean timerValidInBackground;
        private List<String> uplusIDList;

        public Builder() {
            this.ssid = null;
            this.password = "";
            this.timeout = 60;
            this.security = false;
            this.uplusIDList = null;
            this.timerValidInBackground = true;
            this.mainGatewayDomain = null;
            this.mainGatewayPort = 0;
            this.country = null;
        }

        public uSDKSoftApConfigInfo build() {
            return new uSDKSoftApConfigInfo(this);
        }

        @Deprecated
        public uSDKSoftApConfigInfo builder() {
            return build();
        }

        public Builder configTimeout(int i7) {
            this.timeout = i7;
            return this;
        }

        public Builder country(String str) {
            this.country = str;
            return this;
        }

        public Builder mainGateway(String str, int i7) {
            this.mainGatewayDomain = str;
            this.mainGatewayPort = i7;
            return this;
        }

        public Builder routerInfo(String str, String str2) {
            this.ssid = str;
            this.password = str2;
            return this;
        }

        public Builder security(boolean z7) {
            this.security = z7;
            return this;
        }

        public Builder timerValidInBackground(boolean z7) {
            this.timerValidInBackground = z7;
            return this;
        }

        @Deprecated
        public Builder uplusIDList(List<String> list) {
            this.uplusIDList = list;
            return this;
        }

        public Builder(uSDKSoftApConfigInfo usdksoftapconfiginfo) {
            this.ssid = usdksoftapconfiginfo.ssid;
            this.password = usdksoftapconfiginfo.password;
            this.timeout = usdksoftapconfiginfo.timeout;
            this.security = usdksoftapconfiginfo.security;
            this.uplusIDList = usdksoftapconfiginfo.uplusIDList;
            this.timerValidInBackground = usdksoftapconfiginfo.timerValidInBackground;
            this.mainGatewayDomain = usdksoftapconfiginfo.mainGatewayDomain;
            this.mainGatewayPort = usdksoftapconfiginfo.mainGatewayPort;
        }
    }
}
