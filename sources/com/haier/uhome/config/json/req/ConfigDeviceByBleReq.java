package com.haier.uhome.config.json.req;

import com.haier.uhome.config.json.ProtocolConst;
import com.haier.uhome.usdk.base.json.BasicReq;
import com.paytm.pgsdk.d;
import g3.b;

/* JADX INFO: loaded from: classes2.dex */
public class ConfigDeviceByBleReq extends BasicReq {

    @b(name = "bindCode")
    private long bindCode;

    @b(name = "BLEDevID")
    private String bleDevId;

    @b(name = "protoVer")
    private String protoVer;

    @b(name = "timeStamp")
    private long timestamp;

    @b(name = d.R)
    private String token;

    @b(name = "traceId")
    private String traceId;

    @b(name = "wifiMAC")
    private String wifiMAC;

    @b(name = "withWifi")
    private WithWifi withWifi;

    @b(name = "withoutWifi")
    private WithoutWifi withoutWifi;

    public long getBindCode() {
        return this.bindCode;
    }

    public String getBleDevId() {
        return this.bleDevId;
    }

    public String getProtoVer() {
        return this.protoVer;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public String getToken() {
        return this.token;
    }

    public String getTraceId() {
        return this.traceId;
    }

    public String getWifiMAC() {
        return this.wifiMAC;
    }

    public WithWifi getWithWifi() {
        return this.withWifi;
    }

    public WithoutWifi getWithoutWifi() {
        return this.withoutWifi;
    }

    @Override // com.haier.uhome.usdk.base.json.BasicReq
    protected String protocol() {
        return ProtocolConst.REQ_CONFIG_DEVICE_BY_BLE;
    }

    public void setBindCode(long j7) {
        this.bindCode = j7;
    }

    public void setBleDevId(String str) {
        this.bleDevId = str;
    }

    public void setProtoVer(String str) {
        this.protoVer = str;
    }

    public void setTimestamp(long j7) {
        this.timestamp = j7;
    }

    public void setToken(String str) {
        this.token = str;
    }

    public void setTraceId(String str) {
        this.traceId = str;
    }

    public void setWifiMAC(String str) {
        this.wifiMAC = str;
    }

    public void setWithWifi(WithWifi withWifi) {
        this.withWifi = withWifi;
    }

    public void setWithoutWifi(WithoutWifi withoutWifi) {
        this.withoutWifi = withoutWifi;
    }

    @Override // com.haier.uhome.usdk.base.json.BasicReq
    public String toString() {
        return "ConfigDeviceByBleReq{protoVer='" + this.protoVer + "', bleDevId='" + this.bleDevId + "', wifiMAC='" + this.wifiMAC + "', token='" + this.token + "', bindCode=" + this.bindCode + ", traceId='" + this.traceId + "', withoutWifi=" + this.withoutWifi + ", withWifi=" + this.withWifi + '}';
    }
}
