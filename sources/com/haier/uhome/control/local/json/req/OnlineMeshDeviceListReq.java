package com.haier.uhome.control.local.json.req;

import com.alipay.sdk.data.a;
import com.haier.uhome.control.base.json.req.BasicDeviceReq;
import com.haier.uhome.control.local.json.ProtocolConst;
import com.paytm.pgsdk.d;
import g3.b;

/* JADX INFO: loaded from: classes2.dex */
public class OnlineMeshDeviceListReq extends BasicDeviceReq {

    @b(name = "elementAddr")
    private int elementAddr;

    @b(name = "module")
    private String module;

    @b(name = a.f13674p)
    private int timeout;

    @b(name = d.R)
    private String token;

    public int getElementAddr() {
        return this.elementAddr;
    }

    public String getModule() {
        return this.module;
    }

    public int getTimeout() {
        return this.timeout;
    }

    public String getToken() {
        return this.token;
    }

    @Override // com.haier.uhome.usdk.base.json.BasicReq
    protected String protocol() {
        return ProtocolConst.REQ_ONLINE_MESH_DEVICE_LIST;
    }

    public void setElementAddr(int i7) {
        this.elementAddr = i7;
    }

    public void setModule(String str) {
        this.module = str;
    }

    public void setTimeout(int i7) {
        this.timeout = i7;
    }

    public void setToken(String str) {
        this.token = str;
    }
}
