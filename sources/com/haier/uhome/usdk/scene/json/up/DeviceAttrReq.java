package com.haier.uhome.usdk.scene.json.up;

import com.haier.globalwasher.presenter.o;
import g3.b;

/* JADX INFO: loaded from: classes2.dex */
public class DeviceAttrReq extends BaseUp {

    @b(name = "attrName")
    private String attrName;

    @b(name = o.f25218y)
    private String devId;

    public String getAttrName() {
        return this.attrName;
    }

    public String getDevId() {
        return this.devId;
    }

    public void setAttrName(String str) {
        this.attrName = str;
    }

    public void setDevId(String str) {
        this.devId = str;
    }

    @Override // com.haier.uhome.usdk.scene.json.up.BaseUp
    public String toString() {
        return "DeviceAttrReq{, devId='" + this.devId + "', attrName='" + this.attrName + "'}";
    }
}
