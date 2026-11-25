package com.haier.uhome.config.json.req;

import com.haier.uhome.config.json.ProtocolConst;
import com.haier.uhome.usdk.base.json.BasicReq;
import g3.b;

/* JADX INFO: loaded from: classes2.dex */
public class StopConfigDeviceByBleReq extends BasicReq {

    @b(name = "wifiMAC")
    private String wifiMAC;

    public String getWifiMAC() {
        return this.wifiMAC;
    }

    @Override // com.haier.uhome.usdk.base.json.BasicReq
    protected String protocol() {
        return ProtocolConst.REQ_STOP_BLE_CONFIG;
    }

    public void setWifiMAC(String str) {
        this.wifiMAC = str;
    }

    @Override // com.haier.uhome.usdk.base.json.BasicReq
    public String toString() {
        return "StopConfigDeviceByBleReq{wifiMAC='" + this.wifiMAC + "'}";
    }
}
