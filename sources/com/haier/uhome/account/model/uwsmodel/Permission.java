package com.haier.uhome.account.model.uwsmodel;

import com.alipay.sdk.app.statistic.c;
import g3.b;

/* JADX INFO: loaded from: classes2.dex */
public class Permission {

    @b(name = c.f13642n)
    private AuthInfo auth;

    @b(name = "authType")
    private String authType;

    public AuthInfo getAuth() {
        return this.auth;
    }

    public String getAuthType() {
        return this.authType;
    }

    public void setAuth(AuthInfo authInfo) {
        this.auth = authInfo;
    }

    public void setAuthType(String str) {
        this.authType = str;
    }
}
