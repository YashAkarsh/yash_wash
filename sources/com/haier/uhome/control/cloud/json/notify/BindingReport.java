package com.haier.uhome.control.cloud.json.notify;

import g3.b;

/* JADX INFO: loaded from: classes2.dex */
public class BindingReport {

    @b(name = "bindSn")
    private String bindSn;

    @b(name = "dev")
    private String dev;

    @b(name = "errNo")
    private int errNo;

    @b(name = "status")
    private int status;

    @b(name = "upCodeT")
    private String upCodeT;

    @b(name = "upid")
    private String upid;

    public String getBindSn() {
        return this.bindSn;
    }

    public String getDev() {
        return this.dev;
    }

    public int getErrNo() {
        return this.errNo;
    }

    public int getStatus() {
        return this.status;
    }

    public String getUpCodeT() {
        return this.upCodeT;
    }

    public String getUpid() {
        return this.upid;
    }

    public void setBindSn(String str) {
        this.bindSn = str;
    }

    public void setDev(String str) {
        this.dev = str;
    }

    public void setErrNo(int i7) {
        this.errNo = i7;
    }

    public void setStatus(int i7) {
        this.status = i7;
    }

    public void setUpCodeT(String str) {
        this.upCodeT = str;
    }

    public void setUpid(String str) {
        this.upid = str;
    }

    public String toString() {
        return "BindingReport{dev='" + this.dev + "', bindSn='" + this.bindSn + "', errNo=" + this.errNo + ", upid='" + this.upid + "', upCodeT='" + this.upCodeT + "', status=" + this.status + '}';
    }
}
