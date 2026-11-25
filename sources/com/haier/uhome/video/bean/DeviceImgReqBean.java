package com.haier.uhome.video.bean;

/* JADX INFO: loaded from: classes2.dex */
public class DeviceImgReqBean {
    public int imgID;
    public int segmentId;
    public int segmentLenMax;
    public int sn;

    public int getImgID() {
        return this.imgID;
    }

    public int getSegmentId() {
        return this.segmentId;
    }

    public int getSegmentLenMax() {
        return this.segmentLenMax;
    }

    public int getSn() {
        return this.sn;
    }

    public void setImgID(int i7) {
        this.imgID = i7;
    }

    public void setSegmentId(int i7) {
        this.segmentId = i7;
    }

    public void setSegmentLenMax(int i7) {
        this.segmentLenMax = i7;
    }

    public void setSn(int i7) {
        this.sn = i7;
    }

    public String toString() {
        return "ImgReq [imgID=" + this.imgID + ", sn=" + this.sn + ", segmentLenMax=" + this.segmentLenMax + ", segmentId=" + this.segmentId + "]";
    }
}
