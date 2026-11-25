package com.haier.uhome.mesh.service;

import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public class VendorData {
    private int mAppKeyIndex;
    private byte[] mData;
    private int mDst;
    private int mNetKeyIndex;
    private int mOpcode;
    private int mRssi;
    private int mSeqNum;
    private int mSrc;
    private int mTtl;

    public VendorData(int i7, int i8, int i9, int i10, int i11, int i12, int i13, int i14, byte[] bArr) {
        this.mDst = i7;
        this.mSrc = i8;
        this.mTtl = i9;
        this.mRssi = i10;
        this.mSeqNum = i11;
        this.mAppKeyIndex = i12;
        this.mNetKeyIndex = i13;
        this.mOpcode = i14;
        this.mData = bArr;
    }

    public int getAppKeyIndex() {
        return this.mAppKeyIndex;
    }

    public byte[] getData() {
        return this.mData;
    }

    public int getDst() {
        return this.mDst;
    }

    public int getNetKeyIndex() {
        return this.mNetKeyIndex;
    }

    public int getOpcode() {
        return this.mOpcode;
    }

    public int getRssi() {
        return this.mRssi;
    }

    public int getSeqNum() {
        return this.mSeqNum;
    }

    public int getSrc() {
        return this.mSrc;
    }

    public int getTtl() {
        return this.mTtl;
    }

    public String toString() {
        return "VendorData{mDst=" + this.mDst + ", mSrc=" + this.mSrc + ", mTtl=" + this.mTtl + ", mRssi=" + this.mRssi + ", mSeqNum=" + this.mSeqNum + ", mAppKeyIndex=" + this.mAppKeyIndex + ", mNetKeyIndex=" + this.mNetKeyIndex + ", mOpcode=" + this.mOpcode + ", mData=" + Arrays.toString(this.mData) + '}';
    }
}
