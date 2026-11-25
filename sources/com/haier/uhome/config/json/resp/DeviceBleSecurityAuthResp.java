package com.haier.uhome.config.json.resp;

import com.haier.uhome.usdk.base.json.BasicResp;
import g3.b;

/* JADX INFO: loaded from: classes2.dex */
public class DeviceBleSecurityAuthResp extends BasicResp {

    @b(name = "devId")
    private String devId;

    @b(name = "uplusId")
    private String uplusId;

    public String getDevId() {
        return this.devId;
    }

    public String getUplusId() {
        return this.uplusId;
    }

    public void setDevId(String str) {
        this.devId = str;
    }

    public void setUplusId(String str) {
        this.uplusId = str;
    }

    @Override // com.haier.uhome.usdk.base.json.BasicResp
    public String toString() {
        return "DeviceBleSecurityAuthResp{devId='" + this.devId + "', uplusId='" + this.uplusId + "'}";
    }
}
