package com.haier.globalwasher.modle.bean.advertis;

import w1.c;

/* JADX INFO: loaded from: classes2.dex */
public class FirstPagePopupWindowAdvertisBean extends a {
    private String httpUrl;
    private int id;

    @c("isVideo")
    private int mediaType;
    private String pictureURL;
    private String remark;
    private String title;
    private String videoUrl;

    public String getHttpUrl() {
        return this.httpUrl;
    }

    public int getId() {
        return this.id;
    }

    public int getMediaType() {
        return this.mediaType;
    }

    public String getPictureURL() {
        return this.pictureURL;
    }

    public String getRemark() {
        return this.remark;
    }

    public String getTitle() {
        return this.title;
    }

    public String getVideoUrl() {
        return this.videoUrl;
    }

    public void setHttpUrl(String str) {
        this.httpUrl = str;
    }

    public void setId(int i7) {
        this.id = i7;
    }

    public void setMediaType(int i7) {
        this.mediaType = i7;
    }

    public void setPictureURL(String str) {
        this.pictureURL = str;
    }

    public void setRemark(String str) {
        this.remark = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void setVideoUrl(String str) {
        this.videoUrl = str;
    }

    public String toString() {
        return "FirstPagePopupWindowAdvertisBean{id=" + this.id + ", title='" + this.title + "', remark='" + this.remark + "', httpUrl='" + this.httpUrl + "', isVideo=" + this.mediaType + ", videoUrl='" + this.videoUrl + "', pictureURL='" + this.pictureURL + "'}";
    }
}
