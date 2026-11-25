package com.haier.uhome.control.base.json.req;

import android.text.TextUtils;
import com.haier.uhome.control.base.json.ProtocolConst;
import g3.b;

/* JADX INFO: loaded from: classes2.dex */
public class DeviceAttrReadReq extends BasicOpReq {

    @b(name = "name")
    private String name;

    public String getName() {
        return this.name;
    }

    @Override // com.haier.uhome.usdk.base.json.BasicReq
    protected String protocol() {
        return ProtocolConst.REQ_DEVICE_ATTR_READ;
    }

    public void setName(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("DeviceAttrReadReq name should not be null");
        }
        this.name = str;
    }

    @Override // com.haier.uhome.control.base.json.req.BasicOpReq, com.haier.uhome.control.base.json.req.BasicDeviceReq, com.haier.uhome.usdk.base.json.BasicReq
    public String toString() {
        return "DeviceAttrReadReq{name=" + this.name + '}';
    }
}
