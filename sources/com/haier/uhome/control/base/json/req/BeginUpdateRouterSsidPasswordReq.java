package com.haier.uhome.control.base.json.req;

import com.haier.uhome.control.base.json.ProtocolConst;
import com.haier.uhome.usdk.base.json.BasicReq;
import com.paytm.pgsdk.d;
import g3.b;
import y2.a;

/* JADX INFO: loaded from: classes2.dex */
public class BeginUpdateRouterSsidPasswordReq extends BasicReq {

    @b(name = "bindCode")
    private long bindCode;

    @b(name = "bleDevId")
    private String bleDevId;

    @b(name = "bssid")
    private String bssid;

    @b(name = "cfgVer")
    private int cfgVer;

    @b(name = "country")
    private String country;

    @b(name = "devId")
    private String devId;

    @b(name = "deviceType")
    private int deviceType;

    @b(name = "domain")
    private String domain;

    @b(name = "isReconnection")
    private int isReconnection;

    @b(name = "module")
    private String module;

    @b(name = "password")
    private String password;

    @b(name = "protocol")
    private String protocol;

    @b(name = a.C)
    private String ssid;

    @b(name = com.alipay.sdk.data.a.f13674p)
    private int timeout;

    @b(name = "timestamp")
    private long timestamp;

    @b(name = d.R)
    private String token;

    @b(name = "traceId")
    private String traceId;

    @b(name = "uplusId")
    private String uplusId;

    public long getBindCode() {
        return this.bindCode;
    }

    public String getBleDevId() {
        return this.bleDevId;
    }

    public String getBssid() {
        return this.bssid;
    }

    public int getCfgVer() {
        return this.cfgVer;
    }

    public String getCountry() {
        return this.country;
    }

    public String getDevId() {
        return this.devId;
    }

    public int getDeviceType() {
        return this.deviceType;
    }

    public String getDomain() {
        return this.domain;
    }

    public int getIsReconnection() {
        return this.isReconnection;
    }

    public String getModule() {
        return this.module;
    }

    public String getPassword() {
        return this.password;
    }

    public String getProtocol() {
        return this.protocol;
    }

    public String getSsid() {
        return this.ssid;
    }

    public int getTimeout() {
        return this.timeout;
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

    public String getUplusId() {
        return this.uplusId;
    }

    @Override // com.haier.uhome.usdk.base.json.BasicReq
    protected String protocol() {
        return ProtocolConst.REQ_BEGIN_UPDATE_ROUTER_SSID_PASSWORD;
    }

    public void setBindCode(long j7) {
        this.bindCode = j7;
    }

    public void setBleDevId(String str) {
        this.bleDevId = str;
    }

    public void setBssid(String str) {
        this.bssid = str;
    }

    public void setCfgVer(int i7) {
        this.cfgVer = i7;
    }

    public void setCountry(String str) {
        this.country = str;
    }

    public void setDevId(String str) {
        this.devId = str;
    }

    public void setDeviceType(int i7) {
        this.deviceType = i7;
    }

    public void setDomain(String str) {
        this.domain = str;
    }

    public void setIsReconnection(int i7) {
        this.isReconnection = i7;
    }

    public void setModule(String str) {
        this.module = str;
    }

    public void setPassword(String str) {
        this.password = str;
    }

    public void setProtocol(String str) {
        this.protocol = str;
    }

    public void setSsid(String str) {
        this.ssid = str;
    }

    public void setTimeout(int i7) {
        this.timeout = i7;
    }

    public void setTimestamp(long j7) {
        this.timestamp = j7;
    }

    public void setToken(String str) {
        if (str == null) {
            str = "";
        }
        this.token = str;
    }

    public void setTraceId(String str) {
        this.traceId = str;
    }

    public void setUplusId(String str) {
        this.uplusId = str;
    }

    @Override // com.haier.uhome.usdk.base.json.BasicReq
    public String toString() {
        return "BeginUpdateRouterSsidPasswordReq{module='" + this.module + "', devId='" + this.devId + "', bleDevId='" + this.bleDevId + "', uplusId='" + this.uplusId + "', protocol='" + this.protocol + "', deviceType='" + this.deviceType + "', isReconnection='" + this.isReconnection + "', timeout='" + this.timeout + "', cfgVer='" + this.cfgVer + "', ssid='" + this.ssid + "', password='" + this.password + "', token='" + this.token + "', traceId='" + this.traceId + "', bssid='" + this.bssid + "', domain='" + this.domain + "', country='" + this.country + "', timestamp='" + this.timestamp + "', bindCode='" + this.bindCode + "'}";
    }
}
