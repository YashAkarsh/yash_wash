package com.haier.uhome.control.base.json.resp;

import g3.b;

/* JADX INFO: loaded from: classes2.dex */
public class DeviceOperResp extends BasicOpResp {

    @b(name = "addr")
    private String addr;

    @b(name = "channelID")
    private String channelId;

    @b(name = "expired")
    private int expired;

    @b(name = "invalidCode")
    private String invalidCode;

    @b(name = "rPassword")
    private String password;

    @b(name = "port")
    private int port;

    public String getAddr() {
        return this.addr;
    }

    public String getChannelId() {
        return this.channelId;
    }

    public int getExpired() {
        return this.expired;
    }

    public String getInvalidCode() {
        return this.invalidCode;
    }

    public String getPassword() {
        return this.password;
    }

    public int getPort() {
        return this.port;
    }

    public void setAddr(String str) {
        this.addr = str;
    }

    public void setChannelId(String str) {
        this.channelId = str;
    }

    public void setExpired(int i7) {
        this.expired = i7;
    }

    public void setInvalidCode(String str) {
        this.invalidCode = str;
    }

    public void setPassword(String str) {
        this.password = str;
    }

    public void setPort(int i7) {
        this.port = i7;
    }

    @Override // com.haier.uhome.control.base.json.resp.BasicOpResp, com.haier.uhome.control.base.json.resp.BasicDeviceResp, com.haier.uhome.usdk.base.json.BasicResp
    public String toString() {
        return "DeviceOperResp{channelId='" + this.channelId + "', addr='" + this.addr + "', port=" + this.port + ", password='" + this.password + "', expired=" + this.expired + ", invalidCode='" + this.invalidCode + "'}";
    }
}
