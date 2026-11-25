package com.haier.uhome.usdk.base.json;

import com.haier.uhome.usdk.base.c.g;
import g3.b;

/* JADX INFO: loaded from: classes2.dex */
public class BasicResp extends InComing {

    @b(name = "errNo")
    private int errNo;

    @b(name = "reason")
    private int reason;

    @b(name = "sn")
    private int sn;

    public BasicResp() {
    }

    public int getErrNo() {
        return this.errNo;
    }

    public int getReason() {
        return this.reason;
    }

    public int getSn() {
        return this.sn;
    }

    @Override // com.haier.uhome.usdk.base.json.InComing
    public void handle() {
        g.a().a(this);
    }

    public void setErrNo(int i7) {
        this.errNo = i7;
    }

    public void setReason(int i7) {
        this.reason = i7;
    }

    public void setSn(int i7) {
        this.sn = i7;
    }

    public String toString() {
        return "BasicResp{sn=" + this.sn + ", errNo=" + this.errNo + ", reason=" + this.reason + '}';
    }

    public BasicResp(int i7, int i8) {
        this.sn = i7;
        this.errNo = i8;
        this.reason = 0;
    }
}
