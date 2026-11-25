package com.haier.uhome.usdk.base.hiwifi;

/* JADX INFO: loaded from: classes2.dex */
public class HiWifiResp {

    @g3.b(name = "app_code")
    private int appCode;

    @g3.b(name = "app_data")
    private String appData;

    @g3.b(name = "app_msg")
    private String appMsg;

    @g3.b(name = "code")
    private int code;

    @g3.b(name = "msg")
    private String msg;

    public int getAppCode() {
        return this.appCode;
    }

    public String getAppData() {
        return this.appData;
    }

    public String getAppMsg() {
        return this.appMsg;
    }

    public int getCode() {
        return this.code;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setAppCode(int i7) {
        this.appCode = i7;
    }

    public void setAppData(String str) {
        this.appData = str;
    }

    public void setAppMsg(String str) {
        this.appMsg = str;
    }

    public void setCode(int i7) {
        this.code = i7;
    }

    public void setMsg(String str) {
        this.msg = str;
    }

    public String toString() {
        return "HiWifiResp{code=" + this.code + ", msg=" + this.msg + ", appCode=" + this.appCode + ", appMsg=" + this.appMsg + ", appData=" + this.appData + '}';
    }
}
