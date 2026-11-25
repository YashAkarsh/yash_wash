package com.haier.uhome.video.bean;

/* JADX INFO: loaded from: classes2.dex */
public class DeviceImgRespBean {
    public int errorCode;
    public int imgID;
    public int imgSize;
    public byte[] segment;
    public int segmentId;
    public int segmentLen;
    public int segmentNum;
    public int sn;

    public int getErrorCode() {
        return this.errorCode;
    }

    public int getImgID() {
        return this.imgID;
    }

    public int getImgSize() {
        return this.imgSize;
    }

    public byte[] getSegment() {
        return this.segment;
    }

    public int getSegmentId() {
        return this.segmentId;
    }

    public int getSegmentLen() {
        return this.segmentLen;
    }

    public int getSegmentNum() {
        return this.segmentNum;
    }

    public int getSn() {
        return this.sn;
    }

    public void setErrorCode(int i7) {
        this.errorCode = i7;
    }

    public void setImgID(int i7) {
        this.imgID = i7;
    }

    public void setImgSize(int i7) {
        this.imgSize = i7;
    }

    public void setSegment(byte[] bArr) {
        this.segment = bArr;
    }

    public void setSegmentId(int i7) {
        this.segmentId = i7;
    }

    public void setSegmentLen(int i7) {
        this.segmentLen = i7;
    }

    public void setSegmentNum(int i7) {
        this.segmentNum = i7;
    }

    public void setSn(int i7) {
        this.sn = i7;
    }

    public String toString() {
        return "ImgResp [imgID=" + this.imgID + ", sn=" + this.sn + ", errorCode=" + this.errorCode + ", imgSize=" + this.imgSize + ", segmentNum=" + this.segmentNum + ", segmentId=" + this.segmentId + ", segmentLen=" + this.segmentLen + "]";
    }
}
