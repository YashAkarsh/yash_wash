package com.haier.uhome.config.json.resp;

import com.haier.uhome.usdk.base.json.BasicResp;
import g3.b;

/* JADX INFO: loaded from: classes2.dex */
public class BleMeshDeviceInfoResp extends BasicResp {

    @b(name = "devId")
    private String devId;

    @b(name = "elementAddr")
    private int elementAddr;

    @b(name = "oob")
    private String oob;

    public String getDevId() {
        return this.devId;
    }

    public int getElementAddr() {
        return this.elementAddr;
    }

    public String getOob() {
        return this.oob;
    }

    public void setDevId(String str) {
        this.devId = str;
    }

    public void setElementAddr(int i7) {
        this.elementAddr = i7;
    }

    public void setOob(String str) {
        this.oob = str;
    }

    @Override // com.haier.uhome.usdk.base.json.BasicResp
    public String toString() {
        return "BleMeshDeviceInfoResp{devId='" + this.devId + "', elementAddr=" + this.elementAddr + ", oob='" + this.oob + "'}";
    }
}
