package com.haier.globalwasher.modle.bean;

import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public class ProfilePagePassBeen implements Serializable {
    private int code;
    private String content;
    private String phone;
    private String title;

    public ProfilePagePassBeen(String str, String str2, String str3, int i7) {
        this.title = str;
        this.phone = str2;
        this.content = str3;
        this.code = i7;
    }

    public int getCode() {
        return this.code;
    }

    public String getContent() {
        return this.content;
    }

    public String getPhone() {
        return this.phone;
    }

    public String getTitle() {
        return this.title;
    }

    public void setCode(int i7) {
        this.code = i7;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public void setPhone(String str) {
        this.phone = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }
}
