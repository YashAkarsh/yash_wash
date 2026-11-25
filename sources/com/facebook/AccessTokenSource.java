package com.facebook;

/* JADX INFO: loaded from: classes.dex */
public enum AccessTokenSource {
    NONE(false),
    FACEBOOK_APPLICATION_WEB(true),
    FACEBOOK_APPLICATION_NATIVE(true),
    FACEBOOK_APPLICATION_SERVICE(true),
    WEB_VIEW(true),
    CHROME_CUSTOM_TAB(true),
    TEST_USER(true),
    CLIENT_TOKEN(true),
    DEVICE_AUTH(true);

    private final boolean canExtendToken;

    AccessTokenSource(boolean z7) {
        this.canExtendToken = z7;
    }

    boolean canExtendToken() {
        return this.canExtendToken;
    }
}
