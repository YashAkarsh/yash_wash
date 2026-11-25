package com.haier.uhome.account.model;

import com.haier.uhome.account.api.RetInfoContent;
import g3.b;

/* JADX INFO: loaded from: classes2.dex */
public class UacUserBase {

    @b(name = "email")
    private String email;

    @b(name = "id")
    private String id;

    @b(name = "loginName")
    private String loginName;

    @b(name = RetInfoContent.MOBILE_ISNULL)
    private String mobile;

    @b(name = "status")
    private int status;

    public String getEmail() {
        return this.email;
    }

    public String getId() {
        return this.id;
    }

    public String getLoginName() {
        return this.loginName;
    }

    public String getMobile() {
        return this.mobile;
    }

    public int getStatus() {
        return this.status;
    }

    public void setEmail(String str) {
        this.email = str;
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setLoginName(String str) {
        this.loginName = str;
    }

    public void setMobile(String str) {
        this.mobile = str;
    }

    public void setStatus(int i7) {
        this.status = i7;
    }
}
