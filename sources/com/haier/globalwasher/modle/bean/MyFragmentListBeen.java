package com.haier.globalwasher.modle.bean;

import c.u;

/* JADX INFO: loaded from: classes2.dex */
public class MyFragmentListBeen {
    private int code;
    private String content;

    @u
    private int drawablrId;
    private String picUrl;
    private String url;

    public MyFragmentListBeen(String str, int i7, int i8) {
        this.content = str;
        this.drawablrId = i7;
        this.code = i8;
    }

    public int getCode() {
        return this.code;
    }

    public String getContent() {
        return this.content;
    }

    public int getDrawablrId() {
        return this.drawablrId;
    }

    public String getPicUrl() {
        return this.picUrl;
    }

    public String getUrl() {
        return this.url;
    }

    public void setCode(int i7) {
        this.code = i7;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public void setDrawablrId(int i7) {
        this.drawablrId = i7;
    }

    public void setPicUrl(String str) {
        this.picUrl = str;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public MyFragmentListBeen(String str, String str2, int i7) {
        this.content = str;
        this.drawablrId = -1;
        this.picUrl = str2;
        this.code = i7;
    }
}
