package com.haier.globalwasher.modle.bean;

import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public class VideoActivityBean implements Serializable {
    private String firstImgUrl;
    private String vedioUrl;

    public String getFirstImgUrl() {
        return this.firstImgUrl;
    }

    public String getVedioUrl() {
        return this.vedioUrl;
    }

    public void setFirstImgUrl(String str) {
        this.firstImgUrl = str;
    }

    public void setVedioUrl(String str) {
        this.vedioUrl = str;
    }
}
