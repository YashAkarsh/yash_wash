package com.haier.uhome.control.cloud.json.notify;

import com.haier.uhome.control.cloud.a.g;
import com.haier.uhome.usdk.base.c.e;
import com.haier.uhome.usdk.base.json.BasicNotify;
import g3.b;

/* JADX INFO: loaded from: classes2.dex */
public class CloudTraceCbNotify extends BasicNotify {

    @b(name = "bid")
    private String bid;

    @b(name = "bname")
    private String bname;

    @b(name = "code")
    private int code;

    @b(name = "sys")
    private String sys;

    @b(name = "traceId")
    private String traceId;

    public String getBid() {
        return this.bid;
    }

    public String getBname() {
        return this.bname;
    }

    public int getCode() {
        return this.code;
    }

    @Override // com.haier.uhome.usdk.base.json.BasicNotify
    protected e getNotifyHandler() {
        return new g();
    }

    public String getSys() {
        return this.sys;
    }

    public String getTraceId() {
        return this.traceId;
    }

    public void setBid(String str) {
        this.bid = str;
    }

    public void setBname(String str) {
        this.bname = str;
    }

    public void setCode(int i7) {
        this.code = i7;
    }

    public void setSys(String str) {
        this.sys = str;
    }

    public void setTraceId(String str) {
        this.traceId = str;
    }

    @Override // com.haier.uhome.usdk.base.json.BasicNotify
    public String toString() {
        return "CloudTraceCbNotify{traceId='" + this.traceId + "', bid='" + this.bid + "', bname='" + this.bname + "', sys='" + this.sys + "', code=" + this.code + '}';
    }
}
