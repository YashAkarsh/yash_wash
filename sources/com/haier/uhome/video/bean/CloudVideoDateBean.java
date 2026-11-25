package com.haier.uhome.video.bean;

/* JADX INFO: loaded from: classes2.dex */
public class CloudVideoDateBean {
    private int code;
    private DateBean data;
    private String msg;

    public int getCode() {
        return this.code;
    }

    public DateBean getData() {
        return this.data;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setCode(int i7) {
        this.code = i7;
    }

    public void setData(DateBean dateBean) {
        this.data = dateBean;
    }

    public void setMsg(String str) {
        this.msg = str;
    }

    public String toString() {
        return "CloudVideoDateBean{code=" + this.code + ", msg='" + this.msg + "', data=" + this.data + '}';
    }
}
