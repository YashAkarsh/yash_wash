package com.haier.uhome.control.cloud.json.notify;

import com.haier.uhome.control.cloud.a.c;
import com.haier.uhome.usdk.base.c.e;
import com.haier.uhome.usdk.base.json.BasicNotify;
import g3.b;

/* JADX INFO: loaded from: classes2.dex */
public class BoardFOTAStatusNotify extends BasicNotify {

    @b(name = "devId")
    private String devId;

    @b(name = "upgradeErrNo")
    private int errNum;

    @b(name = "upgradeStatus")
    private int status;

    public String getDevId() {
        return this.devId;
    }

    public int getErrNum() {
        return this.errNum;
    }

    @Override // com.haier.uhome.usdk.base.json.BasicNotify
    protected e getNotifyHandler() {
        return new c();
    }

    public int getStatus() {
        return this.status;
    }

    public void setDevId(String str) {
        this.devId = str;
    }

    public void setErrNum(int i7) {
        this.errNum = i7;
    }

    public void setStatus(int i7) {
        this.status = i7;
    }

    @Override // com.haier.uhome.usdk.base.json.BasicNotify
    public String toString() {
        return "BoardFOTAStatusNotify{devId='" + this.devId + "', errNum=" + this.errNum + ", status=" + this.status + '}';
    }
}
