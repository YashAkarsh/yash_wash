package com.haier.uhome.config.json.resp;

import com.haier.uhome.usdk.base.json.BasicResp;
import g3.b;

/* JADX INFO: loaded from: classes2.dex */
public class ConfigGetSmartlinkErrNoResp extends BasicResp {

    @b(name = "smartlinkErrNo")
    private int smartlinkErrNo;

    public int getSmartlinkErrNo() {
        return this.smartlinkErrNo;
    }

    public void setSmartlinkErrNo(int i7) {
        this.smartlinkErrNo = i7;
    }

    @Override // com.haier.uhome.usdk.base.json.BasicResp
    public String toString() {
        return "ConfigGetSmartlinkErrNoResp{sn=" + getSn() + ", errNo=" + getErrNo() + ", reason=" + getReason() + ", smartlinkErrNo=" + this.smartlinkErrNo + '}';
    }
}
