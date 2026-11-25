package com.haier.uhome.usdk.base.api;

/* JADX INFO: loaded from: classes2.dex */
public enum q {
    COAP_CAE_DEV_STD,
    COAP_CAE_DEV_EPP,
    UWT_DEV,
    COAP_CAE_DEV_STD_SAFE,
    COAP_CAE_DEV_EPP_SAFE,
    UWT_DEV_SAFE,
    BLE_CAE_DEV_EPP_SAFE,
    BLE_CAE_DEV_EPP;

    public static q a(String str) {
        try {
            return valueOf(str);
        } catch (Exception unused) {
            return COAP_CAE_DEV_STD;
        }
    }
}
