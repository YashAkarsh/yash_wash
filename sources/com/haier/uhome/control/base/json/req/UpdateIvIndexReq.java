package com.haier.uhome.control.base.json.req;

import com.alipay.sdk.data.a;
import com.haier.uhome.control.base.json.ProtocolConst;
import com.haier.uhome.usdk.base.json.BasicReq;
import g3.b;

/* JADX INFO: loaded from: classes2.dex */
public class UpdateIvIndexReq extends BasicReq {

    @b(name = "ivIndex")
    private long ivIndex;

    @b(name = "netId")
    private long netId;

    @b(name = a.f13674p)
    private int timeout;

    public long getIvIndex() {
        return this.ivIndex;
    }

    public long getNetId() {
        return this.netId;
    }

    public int getTimeout() {
        return this.timeout;
    }

    @Override // com.haier.uhome.usdk.base.json.BasicReq
    protected String protocol() {
        return ProtocolConst.REQ_UPDATE_IV_INDEX;
    }

    public void setIvIndex(long j7) {
        this.ivIndex = j7;
    }

    public void setNetId(long j7) {
        this.netId = j7;
    }

    public void setTimeout(int i7) {
        this.timeout = i7;
    }

    @Override // com.haier.uhome.usdk.base.json.BasicReq
    public String toString() {
        return "UpdateIvIndexReq{timeout=" + this.timeout + ", netId=" + this.netId + ", ivIndex=" + this.ivIndex + '}';
    }
}
