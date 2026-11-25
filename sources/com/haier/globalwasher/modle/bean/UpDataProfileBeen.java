package com.haier.globalwasher.modle.bean;

/* JADX INFO: loaded from: classes2.dex */
public class UpDataProfileBeen {
    private int code;
    private String errorStr;
    private String hint;
    private String title;

    public UpDataProfileBeen(String str, String str2, int i7, String str3) {
        this.hint = str2;
        this.title = str;
        this.code = i7;
        this.errorStr = str3;
    }

    public int getCode() {
        return this.code;
    }

    public String getErrorStr() {
        return this.errorStr;
    }

    public String getHint() {
        return this.hint;
    }

    public String getTitle() {
        return this.title;
    }

    public void setCode(int i7) {
        this.code = i7;
    }

    public void setErrorStr(String str) {
        this.errorStr = str;
    }

    public void setHint(String str) {
        this.hint = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }
}
