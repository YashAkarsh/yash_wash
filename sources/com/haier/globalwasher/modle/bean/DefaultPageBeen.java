package com.haier.globalwasher.modle.bean;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class DefaultPageBeen {
    private String content;
    private String hint;
    private int itemId;
    ArrayList<Object> objects;
    private String title;

    public DefaultPageBeen(String str, String str2, String str3, int i7) {
        this.title = str;
        this.content = str2;
        this.hint = str3;
        this.itemId = i7;
    }

    public String getContent() {
        return this.content;
    }

    public String getHint() {
        return this.hint;
    }

    public int getItemId() {
        return this.itemId;
    }

    public ArrayList<Object> getObjects() {
        return this.objects;
    }

    public String getTitle() {
        return this.title;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public void setHint(String str) {
        this.hint = str;
    }

    public void setItemId(int i7) {
        this.itemId = i7;
    }

    public void setObjects(ArrayList<Object> arrayList) {
        this.objects = arrayList;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public DefaultPageBeen(String str, String str2, int i7) {
        this.title = str;
        this.content = str2;
        this.itemId = i7;
    }
}
