package com.haier.globalwasher.modle.bean;

/* JADX INFO: loaded from: classes2.dex */
public class SettingPageBeen {
    private String content;
    private int itemId;
    private String title;

    public SettingPageBeen(String str, String str2) {
        this.title = str;
        this.content = str2;
    }

    public String getContent() {
        return this.content;
    }

    public int getItemId() {
        return this.itemId;
    }

    public String getTitle() {
        return this.title;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public void setItemId(int i7) {
        this.itemId = i7;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public SettingPageBeen(String str, String str2, int i7) {
        this.title = str;
        this.content = str2;
        this.itemId = i7;
    }
}
