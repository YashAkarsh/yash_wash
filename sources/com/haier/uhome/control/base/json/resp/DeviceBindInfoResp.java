package com.haier.uhome.control.base.json.resp;

import g3.b;

/* JADX INFO: loaded from: classes2.dex */
public class DeviceBindInfoResp extends BasicDeviceResp {

    @b(name = "info")
    private String info;

    public String getInfo() {
        return this.info;
    }

    public void setInfo(String str) {
        this.info = str;
    }

    @Override // com.haier.uhome.control.base.json.resp.BasicDeviceResp, com.haier.uhome.usdk.base.json.BasicResp
    public String toString() {
        return "DeviceBindInfoResp{" + super.toString() + '}';
    }
}
