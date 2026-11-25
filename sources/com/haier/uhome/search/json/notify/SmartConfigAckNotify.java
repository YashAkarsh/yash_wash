package com.haier.uhome.search.json.notify;

import com.haier.uhome.search.b.g;
import com.haier.uhome.trace.api.TraceProtocolConst;
import com.haier.uhome.usdk.base.c.e;
import com.haier.uhome.usdk.base.json.BasicNotify;
import g3.b;

/* JADX INFO: loaded from: classes2.dex */
public class SmartConfigAckNotify extends BasicNotify {

    @b(name = "configMode")
    private int configMode;

    @b(name = "devId")
    private String devId;

    @b(name = TraceProtocolConst.PRO_IP)
    private String ip;

    @b(name = "secVer")
    private int secVer;

    @b(name = "seed")
    private int seed;

    @b(name = "uplusId")
    private String uplusId;

    public int getConfigMode() {
        return this.configMode;
    }

    public String getDevId() {
        return this.devId;
    }

    public String getIp() {
        return this.ip;
    }

    @Override // com.haier.uhome.usdk.base.json.BasicNotify
    protected e getNotifyHandler() {
        return new g();
    }

    public int getSecVer() {
        return this.secVer;
    }

    public int getSeed() {
        return this.seed;
    }

    public String getUplusId() {
        return this.uplusId;
    }

    public void setConfigMode(int i7) {
        this.configMode = i7;
    }

    public void setDevId(String str) {
        this.devId = str;
    }

    public void setIp(String str) {
        this.ip = str;
    }

    public void setSecVer(int i7) {
        this.secVer = i7;
    }

    public void setSeed(int i7) {
        this.seed = i7;
    }

    public void setUplusId(String str) {
        this.uplusId = str;
    }

    @Override // com.haier.uhome.usdk.base.json.BasicNotify
    public String toString() {
        return "SmartConfigAckNotify{devId='" + this.devId + "', ip='" + this.ip + "', uplusId='" + this.uplusId + "', seed=" + this.seed + ", secVer=" + this.secVer + ", configMode=" + this.configMode + '}';
    }
}
