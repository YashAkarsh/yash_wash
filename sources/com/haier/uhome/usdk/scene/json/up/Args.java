package com.haier.uhome.usdk.scene.json.up;

import com.haier.globalwasher.presenter.o;
import g3.b;

/* JADX INFO: loaded from: classes2.dex */
public class Args {

    @b(name = o.f25218y)
    private String deviceId;

    @b(name = "index")
    private int index;

    @b(name = "name")
    private String name;

    @b(name = "subSn")
    private String subSn;

    @b(name = "value")
    private String value;

    public String getDeviceId() {
        return this.deviceId;
    }

    public int getIndex() {
        return this.index;
    }

    public String getName() {
        return this.name;
    }

    public String getSubSn() {
        return this.subSn;
    }

    public String getValue() {
        return this.value;
    }

    public void setDeviceId(String str) {
        this.deviceId = str;
    }

    public void setIndex(int i7) {
        this.index = i7;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setSubSn(String str) {
        this.subSn = str;
    }

    public void setValue(String str) {
        this.value = str;
    }

    public String toString() {
        return "Args{deviceId='" + this.deviceId + "', index=" + this.index + ", name='" + this.name + "', subSn='" + this.subSn + "', value='" + this.value + "'}";
    }
}
