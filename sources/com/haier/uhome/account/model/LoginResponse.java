package com.haier.uhome.account.model;

import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public class LoginResponse implements Serializable {
    private String access_token;
    private int expires_in;
    private String refresh_token;
    private String scope;
    private String token_type;
    private String uhome_access_token;
    private String uhome_user_id;

    public String getAccess_token() {
        return this.access_token;
    }

    public int getExpires_in() {
        return this.expires_in;
    }

    public String getRefresh_token() {
        return this.refresh_token;
    }

    public String getScope() {
        return this.scope;
    }

    public String getToken_type() {
        return this.token_type;
    }

    public String getUhome_access_token() {
        return this.uhome_access_token;
    }

    public String getUhome_user_id() {
        return this.uhome_user_id;
    }

    public void setAccess_token(String str) {
        this.access_token = str;
    }

    public void setExpires_in(int i7) {
        this.expires_in = i7;
    }

    public void setRefresh_token(String str) {
        this.refresh_token = str;
    }

    public void setScope(String str) {
        this.scope = str;
    }

    public void setToken_type(String str) {
        this.token_type = str;
    }

    public void setUhome_access_token(String str) {
        this.uhome_access_token = str;
    }

    public void setUhome_user_id(String str) {
        this.uhome_user_id = str;
    }

    public String toString() {
        return "LoginResponse{access_token='" + this.access_token + "', token_type='" + this.token_type + "', refresh_token='" + this.refresh_token + "', expires_in=" + this.expires_in + ", scope='" + this.scope + "', uhome_access_token='" + this.uhome_access_token + "', uhome_user_id='" + this.uhome_user_id + "'}";
    }
}
