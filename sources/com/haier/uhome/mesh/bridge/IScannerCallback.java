package com.haier.uhome.mesh.bridge;

/* JADX INFO: loaded from: classes2.dex */
public interface IScannerCallback {
    void onProxyDeviceFound(String str, String str2, int i7, byte[] bArr);

    void onUnProvDeviceFound(String str, String str2, byte[] bArr, byte[] bArr2);
}
