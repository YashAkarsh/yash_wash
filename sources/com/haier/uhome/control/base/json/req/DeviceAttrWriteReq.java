package com.haier.uhome.control.base.json.req;

import android.text.TextUtils;
import com.haier.uhome.control.base.json.ProtocolConst;
import g3.b;

/* JADX INFO: loaded from: classes2.dex */
public class DeviceAttrWriteReq extends BasicOpReq {

    @b(name = "name")
    private String name;

    @b(name = "value")
    private String value;

    public String getName() {
        return this.name;
    }

    public String getValue() {
        return this.value;
    }

    @Override // com.haier.uhome.usdk.base.json.BasicReq
    protected String protocol() {
        return ProtocolConst.REQ_DEVICE_ATTR_WRITE;
    }

    public void setName(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("DeviceAttrWriteReq name should not be null");
        }
        this.name = str;
    }

    public void setValue(String str) {
        if (str == null) {
            throw new IllegalArgumentException("DeviceAttrWriteReq value should not be null");
        }
        this.value = str;
    }

    @Override // com.haier.uhome.control.base.json.req.BasicOpReq, com.haier.uhome.control.base.json.req.BasicDeviceReq, com.haier.uhome.usdk.base.json.BasicReq
    public String toString() {
        return "DeviceAttrWriteReq{" + this.name + "=" + this.value + '}';
    }
}
