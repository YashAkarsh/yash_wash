package com.facebook;

import com.alipay.sdk.util.j;

/* JADX INFO: loaded from: classes.dex */
public class FacebookDialogException extends FacebookException {
    static final long serialVersionUID = 1;
    private int errorCode;
    private String failingUrl;

    public FacebookDialogException(String str, int i7, String str2) {
        super(str);
        this.errorCode = i7;
        this.failingUrl = str2;
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public String getFailingUrl() {
        return this.failingUrl;
    }

    @Override // com.facebook.FacebookException, java.lang.Throwable
    public final String toString() {
        return "{FacebookDialogException: errorCode: " + getErrorCode() + ", message: " + getMessage() + ", url: " + getFailingUrl() + j.f13808d;
    }
}
