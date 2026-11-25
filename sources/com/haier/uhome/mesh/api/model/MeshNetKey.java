package com.haier.uhome.mesh.api.model;

import com.haier.library.common.util.c;

/* JADX INFO: loaded from: classes2.dex */
public class MeshNetKey {
    private byte[] mData;
    private int mIndex;

    public MeshNetKey(int i7, byte[] bArr) {
        this.mIndex = i7;
        this.mData = bArr;
    }

    public byte[] getData() {
        return this.mData;
    }

    public int getIndex() {
        return this.mIndex;
    }

    public void setData(byte[] bArr) {
        this.mData = bArr;
    }

    public void setIndex(int i7) {
        this.mIndex = i7;
    }

    public String toString() {
        return "MeshNetKey{mIndex=" + this.mIndex + ", mData=" + c.a(this.mData) + '}';
    }
}
