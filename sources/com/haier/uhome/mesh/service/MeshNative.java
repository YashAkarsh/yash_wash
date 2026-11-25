package com.haier.uhome.mesh.service;

import com.haier.uhome.usdk.base.annotation.Keep;
import com.haier.uhome.usdk.base.service.BaseNative;

/* JADX INFO: loaded from: classes2.dex */
@Keep
public class MeshNative extends BaseNative {
    public static native void init(int i7, int i8, int i9);

    @Keep
    private static int registerVendorModel(int i7, int i8, int i9) {
        return MeshNativeService.getInstance().registerVendorModel(i7, i8, i9);
    }

    public static native void sendToLib(int i7, int i8, int i9, int i10, int i11, int i12, int i13, int i14, byte[] bArr);

    @Keep
    private static int sendToStack(int i7, int i8, int i9, int i10, int i11, int i12, byte[] bArr) {
        return MeshNativeService.getInstance().sendToStack(i7, i8, i9, i10, i11, i12, bArr);
    }
}
