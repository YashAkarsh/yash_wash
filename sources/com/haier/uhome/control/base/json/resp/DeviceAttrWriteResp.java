package com.haier.uhome.control.base.json.resp;

import g3.b;

/* JADX INFO: loaded from: classes2.dex */
public class DeviceAttrWriteResp extends BasicOpResp {

    @b(name = "invalidCode")
    private String invalidCode;

    public String getInvalidCode() {
        return this.invalidCode;
    }

    public void setInvalidCode(String str) {
        this.invalidCode = str;
    }

    @Override // com.haier.uhome.control.base.json.resp.BasicOpResp, com.haier.uhome.control.base.json.resp.BasicDeviceResp, com.haier.uhome.usdk.base.json.BasicResp
    public String toString() {
        return "DeviceAttrWriteResp{invalidCode='" + this.invalidCode + "'}";
    }
}
