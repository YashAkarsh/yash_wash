package com.haier.uhome.control.local.json.resp;

import com.haier.uhome.usdk.base.json.BasicResp;
import g3.b;

/* JADX INFO: loaded from: classes2.dex */
public class StartOTAResp extends BasicResp {

    @b(name = "devId")
    private String devId;

    @b(name = "module")
    private String module;

    public String getDevId() {
        return this.devId;
    }

    public String getModule() {
        return this.module;
    }

    public void setDevId(String str) {
        this.devId = str;
    }

    public void setModule(String str) {
        this.module = str;
    }

    @Override // com.haier.uhome.usdk.base.json.BasicResp
    public String toString() {
        return "StartOTAResp{module='" + this.module + "', devId='" + this.devId + "'}";
    }
}
