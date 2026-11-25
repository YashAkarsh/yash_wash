package com.haier.uhome.config.json.req;

import android.text.TextUtils;
import com.haier.uhome.config.json.ProtocolConst;
import com.haier.uhome.trace.api.TraceProtocolConst;
import com.haier.uhome.usdk.base.json.BasicReq;
import com.paytm.pgsdk.d;
import g3.b;
import y2.a;

/* JADX INFO: loaded from: classes2.dex */
public class SoftapConfigReq extends BasicReq {

    @b(name = "bindCode")
    private long bindCode;

    @b(name = "bssid")
    private String bssid;

    @b(name = "country")
    private String country;

    @b(name = "mainGatewayDomain")
    private String mainGatewayDomain;

    @b(name = "mainGatewayPort")
    private int mainGatewayPort;

    @b(name = "password")
    private String password;

    @b(name = "security")
    private int security;

    @b(name = a.C)
    private String ssid;

    @b(name = d.R)
    private String token;

    @b(name = "traceId")
    private String traceId;

    @b(name = TraceProtocolConst.PRO_TIMESTAMP)
    private long ts;

    @b(name = "uplusId")
    private String uplusId;

    public long getBindCode() {
        return this.bindCode;
    }

    public String getBssid() {
        String str = this.bssid;
        return str == null ? "" : str;
    }

    public String getCountry() {
        String str = this.country;
        return str == null ? "" : str;
    }

    public String getMainGatewayDomain() {
        String str = this.mainGatewayDomain;
        return str == null ? "" : str;
    }

    public int getMainGatewayPort() {
        return this.mainGatewayPort;
    }

    public String getPassword() {
        String str = this.password;
        return str == null ? "" : str;
    }

    public int getSecurity() {
        return this.security;
    }

    public String getSsid() {
        return this.ssid;
    }

    public String getToken() {
        String str = this.token;
        return str == null ? "" : str;
    }

    public String getTraceId() {
        String str = this.traceId;
        return str == null ? "" : str;
    }

    public long getTs() {
        return this.ts;
    }

    public String getUplusId() {
        String str = this.uplusId;
        return str == null ? "" : str;
    }

    @Override // com.haier.uhome.usdk.base.json.BasicReq
    protected String protocol() {
        return ProtocolConst.REQ_SOFTAP_CONFIG;
    }

    public void setBindCode(long j7) {
        this.bindCode = j7;
    }

    public void setBssid(String str) {
        this.bssid = str;
    }

    public void setCountry(String str) {
        this.country = str;
    }

    public void setMainGatewayDomain(String str) {
        this.mainGatewayDomain = str;
    }

    public void setMainGatewayPort(int i7) {
        if (i7 >= 0) {
            this.mainGatewayPort = i7;
            return;
        }
        throw new IllegalArgumentException("mainGatewayPort : " + i7);
    }

    public void setPassword(String str) {
        this.password = str;
    }

    public void setSecurity(int i7) {
        this.security = i7;
    }

    public void setSsid(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("apSid should not be null");
        }
        if (str.length() <= 32) {
            this.ssid = str;
            return;
        }
        throw new IllegalArgumentException("ssid length Illegal : " + str);
    }

    public void setToken(String str) {
        this.token = str;
    }

    public void setTraceId(String str) {
        this.traceId = str;
    }

    public void setTs(long j7) {
        this.ts = j7;
    }

    public void setUplusId(String str) {
        this.uplusId = str;
    }

    @Override // com.haier.uhome.usdk.base.json.BasicReq
    public String toString() {
        return "SoftapConfigReq{sn=" + getSn() + ", uplusId=" + this.uplusId + ", ssid=" + this.ssid + ", password=" + this.password + ", mainGatewayDomain=" + this.mainGatewayDomain + ", mainGatewayPort=" + this.mainGatewayPort + ", country=" + this.country + ", security=" + this.security + ", traceId=" + this.traceId + ", token=" + this.token + ", bssid=" + this.bssid + ", ts=" + this.ts + ", bindCode=" + this.bindCode + "} ";
    }
}
