package com.haier.uhome.mesh.bridge;

/* JADX INFO: loaded from: classes2.dex */
public interface IVendorModel {
    int registerVendorModel(int i7, int i8, IVendorModelCallback iVendorModelCallback);

    int sendVendorData(int i7, int i8, byte[] bArr, int i9);
}
