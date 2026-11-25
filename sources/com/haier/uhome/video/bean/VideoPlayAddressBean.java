package com.haier.uhome.video.bean;

/* JADX INFO: loaded from: classes2.dex */
public class VideoPlayAddressBean {
    private int code;
    private PlayAddressBean data;
    private String msg;

    public int getCode() {
        return this.code;
    }

    public PlayAddressBean getData() {
        return this.data;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setCode(int i7) {
        this.code = i7;
    }

    public void setData(PlayAddressBean playAddressBean) {
        this.data = playAddressBean;
    }

    public void setMsg(String str) {
        this.msg = str;
    }

    public String toString() {
        return "VideoPlayAddressBean{code=" + this.code + ", msg='" + this.msg + "', data=" + this.data + '}';
    }
}
