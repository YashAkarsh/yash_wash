package com.haier.uhome.control.local.json.req;

import com.alipay.sdk.data.a;
import com.haier.uhome.control.base.json.req.BasicDeviceReq;
import com.haier.uhome.control.local.json.ProtocolConst;
import g3.b;

/* JADX INFO: loaded from: classes2.dex */
public class AddDeviceToGroupReq extends BasicDeviceReq {

    @b(name = "cloudOp")
    private boolean cloudOp;

    @b(name = "elementAddr")
    private int elementAddr;

    @b(name = "groupAddr")
    private int groupAddr;

    @b(name = "groupDeviceId")
    private String groupDeviceId;

    @b(name = "isGWSelf")
    private boolean isGWSelf;

    @b(name = "module")
    private String module;

    @b(name = a.f13674p)
    private int timeout;

    public int getElementAddr() {
        return this.elementAddr;
    }

    public int getGroupAddr() {
        return this.groupAddr;
    }

    public String getGroupDeviceId() {
        return this.groupDeviceId;
    }

    public String getModule() {
        return this.module;
    }

    public int getTimeout() {
        return this.timeout;
    }

    public boolean isCloudOp() {
        return this.cloudOp;
    }

    public boolean isGWSelf() {
        return this.isGWSelf;
    }

    @Override // com.haier.uhome.usdk.base.json.BasicReq
    protected String protocol() {
        return ProtocolConst.REQ_ADD_DEVICE_TO_GROUP;
    }

    public void setCloudOp(boolean z7) {
        this.cloudOp = z7;
    }

    public void setElementAddr(int i7) {
        this.elementAddr = i7;
    }

    public void setGWSelf(boolean z7) {
        this.isGWSelf = z7;
    }

    public void setGroupAddr(int i7) {
        this.groupAddr = i7;
    }

    public void setGroupDeviceId(String str) {
        this.groupDeviceId = str;
    }

    public void setModule(String str) {
        this.module = str;
    }

    public void setTimeout(int i7) {
        this.timeout = i7;
    }

    @Override // com.haier.uhome.control.base.json.req.BasicDeviceReq, com.haier.uhome.usdk.base.json.BasicReq
    public String toString() {
        return protocol() + ": {timeout=" + this.timeout + ", module='" + this.module + "', devId='" + getDevId() + "', groupDeviceId='" + this.groupDeviceId + "', elementAddr=" + this.elementAddr + ", groupAddr=" + this.groupAddr + ", cloudOp=" + this.cloudOp + '}';
    }
}
