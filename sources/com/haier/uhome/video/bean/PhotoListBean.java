package com.haier.uhome.video.bean;

/* JADX INFO: loaded from: classes2.dex */
public class PhotoListBean {
    private String describe;
    private int id;
    private String name;
    private String thumbnail;
    private int time;
    private int type;

    public String getDescribe() {
        return this.describe;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getThumbnail() {
        return this.thumbnail;
    }

    public int getTime() {
        return this.time;
    }

    public int getType() {
        return this.type;
    }

    public void setDescribe(String str) {
        this.describe = str;
    }

    public void setId(int i7) {
        this.id = i7;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setThumbnail(String str) {
        this.thumbnail = str;
    }

    public void setTime(int i7) {
        this.time = i7;
    }

    public void setType(int i7) {
        this.type = i7;
    }

    public String toString() {
        return "PhotoListBean{id=" + this.id + ", time=" + this.time + ", type=" + this.type + ", describe='" + this.describe + "', name='" + this.name + "', thumbnail='" + this.thumbnail + "'}";
    }
}
