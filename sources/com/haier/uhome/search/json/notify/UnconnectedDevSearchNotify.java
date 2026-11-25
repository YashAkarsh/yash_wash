package com.haier.uhome.search.json.notify;

import com.haier.uhome.search.b.h;
import com.haier.uhome.trace.api.TraceProtocolConst;
import com.haier.uhome.usdk.base.c.e;
import com.haier.uhome.usdk.base.json.BasicNotify;
import g3.b;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class UnconnectedDevSearchNotify extends BasicNotify {

    @b(name = "errNo")
    private int errNo;

    @b(name = "infos")
    private List<UnconnectedDevInfo> infos;

    @b(name = TraceProtocolConst.PRO_IP)
    private String ip;

    public int getErrNo() {
        return this.errNo;
    }

    public List<UnconnectedDevInfo> getInfos() {
        return this.infos;
    }

    public String getIp() {
        return this.ip;
    }

    @Override // com.haier.uhome.usdk.base.json.BasicNotify
    protected e getNotifyHandler() {
        return new h();
    }

    public void setErrNo(int i7) {
        this.errNo = i7;
    }

    public void setInfos(List<UnconnectedDevInfo> list) {
        this.infos = list;
    }

    public void setIp(String str) {
        this.ip = str;
    }

    @Override // com.haier.uhome.usdk.base.json.BasicNotify
    public String toString() {
        return "UnconnectedDevSearchNotify{ip='" + this.ip + "', errNo=" + this.errNo + ", infos=" + this.infos + '}';
    }
}
