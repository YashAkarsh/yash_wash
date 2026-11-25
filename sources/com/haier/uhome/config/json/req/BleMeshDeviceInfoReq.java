package com.haier.uhome.config.json.req;

import com.haier.uhome.config.json.ProtocolConst;
import com.haier.uhome.usdk.base.json.BasicReq;
import g3.b;

/* JADX INFO: loaded from: classes2.dex */
public class BleMeshDeviceInfoReq extends BasicReq {
    private int elementNum = 1;
    private String longProductCode;
    private String netID;
    private int timeout;
    private String traceId;
    private String uplusID;

    @b(name = "devUUID")
    private String uuid;

    public int getElementNum() {
        return this.elementNum;
    }

    public String getLongProductCode() {
        return this.longProductCode;
    }

    public String getNetID() {
        return this.netID;
    }

    public int getTimeout() {
        return this.timeout;
    }

    public String getTraceId() {
        return this.traceId;
    }

    public String getUplusID() {
        return this.uplusID;
    }

    public String getUuid() {
        return this.uuid;
    }

    @Override // com.haier.uhome.usdk.base.json.BasicReq
    protected String protocol() {
        return ProtocolConst.REQ_BLE_MESH_DEVICE_INFO;
    }

    public void setElementNum(int i7) {
        this.elementNum = i7;
    }

    public void setLongProductCode(String str) {
        this.longProductCode = str;
    }

    public void setNetID(String str) {
        this.netID = str;
    }

    public void setTimeout(int i7) {
        this.timeout = i7;
    }

    public void setTraceId(String str) {
        this.traceId = str;
    }

    public void setUplusID(String str) {
        this.uplusID = str;
    }

    public void setUuid(String str) {
        this.uuid = str;
    }

    @Override // com.haier.uhome.usdk.base.json.BasicReq
    public String toString() {
        return "BleMeshDeviceInfoReq{timeout=" + this.timeout + ", traceId='" + this.traceId + "', uuid='" + this.uuid + "', elementNum=" + this.elementNum + ", netID='" + this.netID + "', longProductCode='" + this.longProductCode + "', uplusID='" + this.uplusID + "'}";
    }
}
