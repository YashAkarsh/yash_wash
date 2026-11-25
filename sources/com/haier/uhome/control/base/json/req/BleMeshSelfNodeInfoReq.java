package com.haier.uhome.control.base.json.req;

import com.alipay.sdk.data.a;
import com.haier.uhome.control.base.json.ProtocolConst;
import com.haier.uhome.usdk.base.json.BasicReq;
import g3.b;

/* JADX INFO: loaded from: classes2.dex */
public class BleMeshSelfNodeInfoReq extends BasicReq {

    @b(name = "clientID")
    private String clientId;

    @b(name = "elementNum")
    private int elementNum = 1;

    @b(name = "idType")
    private String idType = "0";

    @b(name = a.f13674p)
    private int timeout;

    @b(name = "traceId")
    private String traceId;

    @b(name = "userId")
    private String userId;

    public String getClientId() {
        return this.clientId;
    }

    public int getElementNum() {
        return this.elementNum;
    }

    public String getIdType() {
        return this.idType;
    }

    public int getTimeout() {
        return this.timeout;
    }

    public String getTraceId() {
        return this.traceId;
    }

    public String getUserId() {
        return this.userId;
    }

    @Override // com.haier.uhome.usdk.base.json.BasicReq
    protected String protocol() {
        return ProtocolConst.REQ_BLE_MESH_SELF_NODE_INFO;
    }

    public void setClientId(String str) {
        this.clientId = str;
    }

    public void setTimeout(int i7) {
        this.timeout = i7;
    }

    public void setTraceId(String str) {
        this.traceId = str;
    }

    public void setUserId(String str) {
        this.userId = str;
    }

    @Override // com.haier.uhome.usdk.base.json.BasicReq
    public String toString() {
        return "BleMeshSelfNodeInfoReq{timeout=" + this.timeout + ", elementNum=" + this.elementNum + ", userId=" + this.userId + ", idType=" + this.idType + ", clientId=" + this.clientId + '}';
    }
}
