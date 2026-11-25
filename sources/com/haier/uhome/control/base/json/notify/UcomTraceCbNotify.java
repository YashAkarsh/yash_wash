package com.haier.uhome.control.base.json.notify;

import com.haier.uhome.control.base.handler.g;
import com.haier.uhome.trace.api.TraceProtocolConst;
import com.haier.uhome.usdk.base.c.e;
import com.haier.uhome.usdk.base.json.BasicNotify;
import g3.b;

/* JADX INFO: loaded from: classes2.dex */
public class UcomTraceCbNotify extends BasicNotify {

    @b(name = "devId")
    private String devId;

    @b(name = "module")
    private String module;

    @b(name = TraceProtocolConst.PRO_SUB_SYSTEM)
    private String subSys;

    @b(name = "sysErrInfo")
    private String sysErrInfo;

    @b(name = "ucomErrno")
    private int ucomErrno;

    @b(name = "uplusId")
    private String uplusId;

    public String getDevId() {
        return this.devId;
    }

    public String getModule() {
        return this.module;
    }

    @Override // com.haier.uhome.usdk.base.json.BasicNotify
    protected e getNotifyHandler() {
        return new g();
    }

    public String getSubSys() {
        return this.subSys;
    }

    public String getSysErrInfo() {
        return this.sysErrInfo;
    }

    public int getUcomErrno() {
        return this.ucomErrno;
    }

    public String getUplusId() {
        return this.uplusId;
    }

    public void setDevId(String str) {
        this.devId = str;
    }

    public void setModule(String str) {
        this.module = str;
    }

    public void setSubSys(String str) {
        this.subSys = str;
    }

    public void setSysErrInfo(String str) {
        this.sysErrInfo = str;
    }

    public void setUcomErrno(int i7) {
        this.ucomErrno = i7;
    }

    public void setUplusId(String str) {
        this.uplusId = str;
    }

    @Override // com.haier.uhome.usdk.base.json.BasicNotify
    public String toString() {
        return "UcomTraceCbNotify{subSys='" + this.subSys + "', module='" + this.module + "', devId='" + this.devId + "', uplusId='" + this.uplusId + "', ucomErrno='" + this.ucomErrno + "', sysErrInfo='" + this.sysErrInfo + "'}";
    }
}
