package com.haier.globalwasher.modle.bean;

/* JADX INFO: loaded from: classes2.dex */
public class ProfilePageBeen {
    private String content;
    private String title;
    private int type;

    public ProfilePageBeen(String str, String str2, int i7) {
        this.title = str;
        this.content = str2;
        this.type = i7;
    }

    public String getContent() {
        return this.content;
    }

    public String getTitle() {
        return this.title;
    }

    public int getType() {
        return this.type;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void setType(int i7) {
        this.type = i7;
    }
}
