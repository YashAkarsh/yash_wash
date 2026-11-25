package com.haier.uhome.control.base.json.resp;

import com.haier.uhome.usdk.base.json.BasicResp;
import g3.b;

/* JADX INFO: loaded from: classes2.dex */
public class CloudBindDeviceResp extends BasicResp {

    @b(name = "devId")
    private String devId;

    @b(name = "protocol")
    private int protocol;

    public String getDevId() {
        return this.devId;
    }

    public int getProtocol() {
        return this.protocol;
    }

    public void setDevId(String str) {
        this.devId = str;
    }

    public void setProtocol(int i7) {
        this.protocol = i7;
    }

    @Override // com.haier.uhome.usdk.base.json.BasicResp
    public String toString() {
        return "CloudBindDeviceResp{devId=" + this.devId + ", protocol=" + this.protocol + '}';
    }
}
