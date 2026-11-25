package com.haier.uhome.usdk.base.json.req;

import com.haier.uhome.usdk.base.json.BasicReq;
import com.haier.uhome.usdk.base.json.ProtocolConst;
import g3.b;

/* JADX INFO: loaded from: classes2.dex */
public class DeviceGetProtocolTypeReq extends BasicReq {

    @b(name = "uplusId")
    private String uplusId;

    public String getUplusId() {
        return this.uplusId;
    }

    @Override // com.haier.uhome.usdk.base.json.BasicReq
    protected String protocol() {
        return ProtocolConst.REQ_DEVICE_GET_PROTOCOL_TYPE;
    }

    public void setUplusId(String str) {
        this.uplusId = str;
    }

    @Override // com.haier.uhome.usdk.base.json.BasicReq
    public String toString() {
        return "DeviceGetProtocolTypeReq{" + super.toString() + "uplusId=" + this.uplusId + '}';
    }
}
