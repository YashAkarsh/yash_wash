package com.haier.uhome.usdk.api;

import com.haier.uhome.usdk.base.annotation.Keep;

/* JADX INFO: loaded from: classes2.dex */
@Keep
public class uSDKUserInfo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f30972a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f30973b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f30974c;

    @Keep
    public static class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f30975a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f30976b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private String f30977c;

        @Keep
        public uSDKUserInfo build() {
            uSDKUserInfo usdkuserinfo = new uSDKUserInfo();
            usdkuserinfo.f30972a = this.f30975a;
            usdkuserinfo.f30973b = this.f30976b;
            usdkuserinfo.f30974c = this.f30977c;
            return usdkuserinfo;
        }

        @Keep
        public Builder setFamilyId(String str) {
            this.f30977c = str;
            return this;
        }

        @Keep
        public Builder setUserID(String str) {
            this.f30975a = str;
            return this;
        }

        @Keep
        public Builder setUserToken(String str) {
            this.f30976b = str;
            return this;
        }
    }

    @Keep
    public String getFamilyId() {
        return this.f30974c;
    }

    @Keep
    public String getUserID() {
        return this.f30972a;
    }

    @Keep
    public String getUserToken() {
        return this.f30973b;
    }
}
