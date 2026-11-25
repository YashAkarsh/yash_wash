package com.haier.uhome.usdk.scene.json.down;

import com.haier.globalwasher.presenter.o;
import com.haier.library.json.a;
import com.haier.uhome.usdk.scene.json.ProtocolConst;
import g3.b;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public class DeviceAttrResp implements BaseDown {

    @b(name = "attrName")
    private String attrName;

    @b(name = "attrValue")
    private String attrValue;

    @b(name = o.f25218y)
    private String deviceId;

    @b(name = "sn")
    private int sn;

    @Override // com.haier.uhome.usdk.scene.json.down.BaseDown
    public String buildJson() {
        HashMap map = new HashMap(1);
        map.put(ProtocolConst.DOWN_DEVICE_ATTR, this);
        return a.Z(map);
    }

    public String getAttrName() {
        return this.attrName;
    }

    public String getAttrValue() {
        return this.attrValue;
    }

    public String getDeviceId() {
        return this.deviceId;
    }

    public int getSn() {
        return this.sn;
    }

    public void setAttrName(String str) {
        this.attrName = str;
    }

    public void setAttrValue(String str) {
        this.attrValue = str;
    }

    public void setDeviceId(String str) {
        this.deviceId = str;
    }

    public void setSn(int i7) {
        this.sn = i7;
    }

    public String toString() {
        return "DeviceAttrResp{sn=" + this.sn + ", deviceId='" + this.deviceId + "', attrName='" + this.attrName + "', attrValue='" + this.attrValue + "'}";
    }
}
