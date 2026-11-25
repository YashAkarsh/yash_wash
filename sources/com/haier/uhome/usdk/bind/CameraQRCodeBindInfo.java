package com.haier.uhome.usdk.bind;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes2.dex */
public class CameraQRCodeBindInfo extends BaseBindInfo<Builder> {
    private String BSSID;
    private String QRCodeImgSize;
    private String password;
    private String productCode;
    private String ssid;
    private String uplusID;

    public static final class Builder extends BaseBindInfo.a<Builder, CameraQRCodeBindInfo> {
        private String BSSID;
        private String QRCodeImgSize;
        private String password;
        private String productCode;
        private String ssid;
        private String uplusID;

        public Builder BSSID(String str) {
            this.BSSID = str;
            return this;
        }

        public Builder QRCodeImgSize(String str) {
            this.QRCodeImgSize = str;
            return this;
        }

        public Builder password(String str) {
            this.password = str;
            return this;
        }

        public Builder productCode(String str) {
            this.productCode = str;
            return this;
        }

        public Builder ssid(String str) {
            this.ssid = str;
            return this;
        }

        public Builder uplusID(String str) {
            this.uplusID = str;
            return this;
        }

        public Builder() {
        }

        @Override // com.haier.uhome.usdk.bind.l.a
        public CameraQRCodeBindInfo build() {
            return new CameraQRCodeBindInfo(this);
        }

        private Builder(CameraQRCodeBindInfo cameraQRCodeBindInfo) {
            super(cameraQRCodeBindInfo);
            this.ssid = cameraQRCodeBindInfo.ssid;
            this.password = cameraQRCodeBindInfo.password;
        }
    }

    public String getBSSID() {
        String str = this.BSSID;
        return str == null ? "" : str;
    }

    public String getPassword() {
        return this.password;
    }

    public String getProductCode() {
        return this.productCode;
    }

    public String getQRCodeImgSize() {
        return TextUtils.isEmpty(this.QRCodeImgSize) ? "311" : this.QRCodeImgSize;
    }

    public String getSsid() {
        return this.ssid;
    }

    public String getUplusID() {
        return this.uplusID;
    }

    private CameraQRCodeBindInfo(Builder builder) {
        super(builder);
        this.ssid = builder.ssid;
        this.password = builder.password;
        this.uplusID = builder.uplusID;
        this.productCode = builder.productCode;
        this.BSSID = builder.BSSID;
        this.QRCodeImgSize = builder.QRCodeImgSize;
    }

    @Override // com.haier.uhome.usdk.bind.l
    public Builder rebuild() {
        return new Builder();
    }
}
