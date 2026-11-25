package com.haier.uhome.mesh.api.model;

import com.haier.library.common.util.c;

/* JADX INFO: loaded from: classes2.dex */
public class MeshDeviceNode {
    private String mBleAddress;
    private final int mElementNum;
    private final byte[] mMeshKey;
    private final int mUnicast;

    public MeshDeviceNode(String str, int i7, byte[] bArr, int i8) {
        this(i7, bArr, i8);
        this.mBleAddress = str;
    }

    public String getBleAddress() {
        return this.mBleAddress;
    }

    public int getElementNum() {
        return this.mElementNum;
    }

    public byte[] getMeshKey() {
        return this.mMeshKey;
    }

    public int getUnicast() {
        return this.mUnicast;
    }

    public String toString() {
        return "MeshDeviceNode{bleAddress=" + this.mBleAddress + ", unicast=" + this.mUnicast + ", meshKey=" + c.a(this.mMeshKey) + ", elementNum=" + this.mElementNum + '}';
    }

    public MeshDeviceNode(int i7, byte[] bArr, int i8) {
        this.mUnicast = i7;
        this.mMeshKey = bArr;
        this.mElementNum = i8;
    }
}
