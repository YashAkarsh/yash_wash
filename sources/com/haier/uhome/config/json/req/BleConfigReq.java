package com.haier.uhome.config.json.req;

import android.text.TextUtils;
import com.haier.uhome.config.json.ProtocolConst;
import com.haier.uhome.usdk.base.json.BasicReq;
import com.paytm.pgsdk.d;
import g3.b;
import y2.a;

/* JADX INFO: loaded from: classes2.dex */
public class BleConfigReq extends BasicReq {

    @b(name = "bindCode")
    private long bindCode;

    @b(name = "bleDevId")
    private String bleDevId;

    @b(name = "bleType")
    private int bleType;

    @b(name = "bssid")
    private String bssid;

    @b(name = "password")
    private String password;

    @b(name = a.C)
    private String ssid;

    @b(name = "timestamp")
    private long timestamp;

    @b(name = d.R)
    private String token;

    @b(name = "traceId")
    private String traceId;

    public long getBindCode() {
        return this.bindCode;
    }

    public String getBleDevId() {
        return this.bleDevId;
    }

    public int getBleType() {
        return this.bleType;
    }

    public String getBssid() {
        return this.bssid;
    }

    public String getPassword() {
        return this.password;
    }

    public String getSsid() {
        return this.ssid;
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

    @Override // com.haier.uhome.usdk.base.json.BasicReq
    protected String protocol() {
        return ProtocolConst.REQ_BLE_CONFIG;
    }

    public void setBindCode(long j7) {
        this.bindCode = j7;
    }

    public void setBleDevId(String str) {
        if (str == null) {
            throw new IllegalArgumentException("BleConfigReq bleDevId is null");
        }
        this.bleDevId = str.toUpperCase();
    }

    public void setBleType(int i7) {
        this.bleType = i7;
    }

    public void setBssid(String str) {
        this.bssid = str;
    }

    public void setPassword(String str) {
        if (str == null) {
            str = "";
        }
        if (str.length() <= 64) {
            this.password = str;
            return;
        }
        throw new IllegalArgumentException("password length Illegal : " + str);
    }

    public void setSsid(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("ssid should not be null");
        }
        if (str.length() <= 32) {
            this.ssid = str;
            return;
        }
        throw new IllegalArgumentException("ssid length Illegal : " + str);
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

    @Override // com.haier.uhome.usdk.base.json.BasicReq
    public String toString() {
        return "BleConfigReq{bleDevId='" + this.bleDevId + "', ssid='" + this.ssid + "', bssid='" + this.bssid + "', password='" + this.password + "', token='" + this.token + "', traceId='" + this.traceId + "', timestamp=" + this.timestamp + ", bindCode=" + this.bindCode + ", bleType=" + this.bleType + '}';
    }
}
