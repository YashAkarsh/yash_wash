package com.haier.uhome.account.model.geamodel;

import com.alipay.sdk.app.statistic.c;
import g3.b;

/* JADX INFO: loaded from: classes2.dex */
public class GEAPermission {

    @b(name = c.f13642n)
    private GEAAuthInfo auth;

    @b(name = "authType")
    private String authType;

    public GEAAuthInfo getAuth() {
        return this.auth;
    }

    public String getAuthType() {
        return this.authType;
    }

    public void setAuth(GEAAuthInfo gEAAuthInfo) {
        this.auth = gEAAuthInfo;
    }

    public void setAuthType(String str) {
        this.authType = str;
    }
}
