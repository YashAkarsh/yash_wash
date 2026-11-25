package com.haier.uhome.video.bean;

import com.haier.uhome.video.PlayerImageType;

/* JADX INFO: loaded from: classes2.dex */
public class MonitorPhotoListBean {
    private String describe;
    private int id;
    private String name;
    private String thumbnail;
    private int time;
    private PlayerImageType type;

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

    public PlayerImageType getType() {
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

    public void setType(PlayerImageType playerImageType) {
        this.type = playerImageType;
    }

    public String toString() {
        return "MonitorPhotoListBean{id=" + this.id + ", time=" + this.time + ", type=" + this.type + ", describe='" + this.describe + "', name='" + this.name + "', thumbnail='" + this.thumbnail + "'}";
    }
}
