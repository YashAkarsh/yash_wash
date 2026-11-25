package com.haier.uhome.usdk.base.json.req;

import com.haier.uhome.usdk.base.json.BasicReq;
import com.haier.uhome.usdk.base.json.ProtocolConst;
import g3.b;

/* JADX INFO: loaded from: classes2.dex */
public class SetLogLevelReq extends BasicReq {

    @b(name = "logLevel")
    private int logLevel;

    public int getLogLevel() {
        return this.logLevel;
    }

    @Override // com.haier.uhome.usdk.base.json.BasicReq
    protected String protocol() {
        return ProtocolConst.REQ_SET_LOG_LEVEL;
    }

    public void setLogLevel(int i7) {
        this.logLevel = i7;
    }

    @Override // com.haier.uhome.usdk.base.json.BasicReq
    public String toString() {
        return "SetLogLevelReq{" + super.toString() + ", logLevel=" + this.logLevel + '}';
    }
}
