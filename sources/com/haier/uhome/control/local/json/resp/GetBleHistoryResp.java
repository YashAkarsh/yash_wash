package com.haier.uhome.control.local.json.resp;

import com.haier.uhome.usdk.base.json.BasicResp;
import g3.b;

/* JADX INFO: loaded from: classes2.dex */
public class GetBleHistoryResp extends BasicResp {

    @b(name = "devId")
    private String devId;

    public String getDevId() {
        return this.devId;
    }

    public void setDevId(String str) {
        this.devId = str;
    }

    @Override // com.haier.uhome.usdk.base.json.BasicResp
    public String toString() {
        return "GetBleHistoryResp{" + super.toString() + "devId='" + this.devId + "'}";
    }
}
