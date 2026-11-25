package com.haier.uhome.control.local.json.resp;

import com.haier.uhome.usdk.base.json.BasicResp;
import g3.b;

/* JADX INFO: loaded from: classes2.dex */
public class CreateGroupResp extends BasicResp {

    @b(name = "devId")
    private String devId;

    @b(name = "elementAddr")
    private int elementAddr;

    public String getDevId() {
        return this.devId;
    }

    public int getElementAddr() {
        return this.elementAddr;
    }

    public void setDevId(String str) {
        this.devId = str;
    }

    public void setElementAddr(int i7) {
        this.elementAddr = i7;
    }

    @Override // com.haier.uhome.usdk.base.json.BasicResp
    public String toString() {
        return "CreateGroupResp{devId='" + this.devId + "', elementAddr=" + this.elementAddr + '}';
    }
}
