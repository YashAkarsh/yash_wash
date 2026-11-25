package com.haier.uhome.usdk.api;

/* JADX INFO: loaded from: classes2.dex */
public class uSDKSecurityException extends SecurityException {
    protected String[] failedGratendPermissions;
    protected String[] notGratendPermissions;

    public uSDKSecurityException() {
    }

    public String[] getFailedGratendPermissions() {
        return this.failedGratendPermissions;
    }

    public String[] getNotGratendPermissions() {
        return this.notGratendPermissions;
    }

    public uSDKSecurityException(String str) {
        super(str);
    }
}
