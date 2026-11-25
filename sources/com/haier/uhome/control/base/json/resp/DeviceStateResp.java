package com.haier.uhome.control.base.json.resp;

import com.facebook.internal.ServerProtocol;
import g3.b;

/* JADX INFO: loaded from: classes2.dex */
public class DeviceStateResp extends BasicDeviceResp {

    @b(name = "module")
    private String module;

    @b(name = ServerProtocol.DIALOG_PARAM_STATE)
    private String state;

    @Override // com.haier.uhome.control.base.json.resp.BasicDeviceResp, com.haier.uhome.usdk.base.json.BasicResp
    public String toString() {
        return "DeviceStateResp{" + super.toString() + "module='" + this.module + "', state='" + this.state + "'}";
    }
}
