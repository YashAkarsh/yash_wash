package com.facebook.login;

/* JADX INFO: loaded from: classes.dex */
public enum LoginBehavior {
    NATIVE_WITH_FALLBACK(true, true, true, false, true, true),
    NATIVE_ONLY(true, true, false, false, false, true),
    KATANA_ONLY(false, true, false, false, false, false),
    WEB_ONLY(false, false, true, false, true, false),
    WEB_VIEW_ONLY(false, false, true, false, false, false),
    DIALOG_ONLY(false, true, true, false, true, true),
    DEVICE_AUTH(false, false, false, true, false, false);

    private final boolean allowsCustomTabAuth;
    private final boolean allowsDeviceAuth;
    private final boolean allowsFacebookLiteAuth;
    private final boolean allowsGetTokenAuth;
    private final boolean allowsKatanaAuth;
    private final boolean allowsWebViewAuth;

    LoginBehavior(boolean z7, boolean z8, boolean z9, boolean z10, boolean z11, boolean z12) {
        this.allowsGetTokenAuth = z7;
        this.allowsKatanaAuth = z8;
        this.allowsWebViewAuth = z9;
        this.allowsDeviceAuth = z10;
        this.allowsCustomTabAuth = z11;
        this.allowsFacebookLiteAuth = z12;
    }

    boolean allowsCustomTabAuth() {
        return this.allowsCustomTabAuth;
    }

    boolean allowsDeviceAuth() {
        return this.allowsDeviceAuth;
    }

    boolean allowsFacebookLiteAuth() {
        return this.allowsFacebookLiteAuth;
    }

    boolean allowsGetTokenAuth() {
        return this.allowsGetTokenAuth;
    }

    boolean allowsKatanaAuth() {
        return this.allowsKatanaAuth;
    }

    boolean allowsWebViewAuth() {
        return this.allowsWebViewAuth;
    }
}
