package com.haier.uhome.mesh.service;

import com.haier.uhome.mesh.bridge.IVendorModel;
import com.haier.uhome.mesh.bridge.RtkCoreMeshWrapper;

/* JADX INFO: loaded from: classes2.dex */
public class HaierClientModel {
    private int mElementIndex;
    private IVendorModel mIVendorModel = RtkCoreMeshWrapper.getInstance();
    private int mModelId;

    HaierClientModel(int i7, int i8) {
        this.mElementIndex = i7;
        this.mModelId = i8;
    }

    public int getElementIndex() {
        return this.mElementIndex;
    }

    public int getModelId() {
        return this.mModelId;
    }

    public int sendData(int i7, int i8, byte[] bArr) {
        return this.mIVendorModel.sendVendorData(i7, i8, bArr, this.mModelId);
    }
}
