package com.haier.uhome.usdk.bind;

/* JADX INFO: loaded from: classes2.dex */
public class CameraQRCodeInfo {

    @g3.b(name = "bindCode")
    private long bindCode;

    @g3.b(name = "expireTime")
    private long expireTime;

    @g3.b(name = "img")
    private String img;

    public long getBindCode() {
        return this.bindCode;
    }

    public long getExpireTime() {
        return this.expireTime;
    }

    public String getImg() {
        return this.img;
    }

    public void setBindCode(long j7) {
        this.bindCode = j7;
    }

    public void setExpireTime(long j7) {
        this.expireTime = j7;
    }

    public void setImg(String str) {
        this.img = str;
    }

    public String toString() {
        return "CameraQRCodeInfo{bindCode=" + this.bindCode + ", img='" + this.img + "', expireTime=" + this.expireTime + '}';
    }
}
