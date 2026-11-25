package com.haier.uhome.mesh.api.model;

import com.haier.library.common.util.c;

/* JADX INFO: loaded from: classes2.dex */
public class MeshAppKey {
    private int mBoundNetKeyIndex;
    private byte[] mData;
    private int mIndex;

    public MeshAppKey(int i7, byte[] bArr) {
        this.mIndex = i7;
        this.mData = bArr;
    }

    public int getBoundNetKeyIndex() {
        return this.mBoundNetKeyIndex;
    }

    public byte[] getData() {
        return this.mData;
    }

    public int getIndex() {
        return this.mIndex;
    }

    public void setBoundNetKeyIndex(int i7) {
        this.mBoundNetKeyIndex = i7;
    }

    public void setData(byte[] bArr) {
        this.mData = bArr;
    }

    public void setIndex(int i7) {
        this.mIndex = i7;
    }

    public String toString() {
        return "MeshAppKey{mIndex=" + this.mIndex + ", mData=" + c.a(this.mData) + ", mBoundNetKeyIndex=" + this.mBoundNetKeyIndex + '}';
    }

    public MeshAppKey(int i7, byte[] bArr, int i8) {
        this(i7, bArr);
        this.mBoundNetKeyIndex = i8;
    }
}
