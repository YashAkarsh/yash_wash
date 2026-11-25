package com.haier.globalwasher.modle.bean;

import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public class AppAdInfo implements Serializable {
    private String adId;
    private int countDown;
    private String httpUrl;
    private String id;
    private String imageUrl;
    private String title;

    public String getAdId() {
        return this.adId;
    }

    public int getCountDown() {
        return this.countDown;
    }

    public String getHttpUrl() {
        return this.httpUrl;
    }

    public String getId() {
        return this.id;
    }

    public String getImageUrl() {
        return this.imageUrl;
    }

    public String getTitle() {
        return this.title;
    }

    public void setAdId(String str) {
        this.adId = str;
    }

    public void setCountDown(int i7) {
        this.countDown = i7;
    }

    public void setHttpUrl(String str) {
        this.httpUrl = str;
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setImageUrl(String str) {
        this.imageUrl = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public String toString() {
        return "AppAdInfo{id='" + this.id + "', adId='" + this.adId + "', title='" + this.title + "', imageUrl='" + this.imageUrl + "', countDown=" + this.countDown + ", httpUrl='" + this.httpUrl + "'}";
    }
}
