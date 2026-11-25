package com.haier.uhome.search.service;

import com.haier.uhome.usdk.base.service.BaseNative;

/* JADX INFO: loaded from: classes2.dex */
public class SearchNative extends BaseNative {
    public static final int SEARCH_ALL_MODULE = 3;
    public static final int SEARCH_BLE_MODULE = 2;
    public static final int SEARCH_WIFI_MODULE = 1;
    private long handle;

    public native int openWifiStateNotify(byte[] bArr);

    public native String parserDeviceUUID(byte[] bArr);

    public native int smlkCloseAck();

    public native int smlkOpenAck();

    public native int startSearch(int i7);

    public native int startUnconnectedDevSearch(String str);

    public native int stopSearch(int i7);
}
