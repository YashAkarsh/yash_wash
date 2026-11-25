package com.haier.uhome.control.base.json.req;

import android.text.TextUtils;
import com.haier.uhome.usdk.base.json.BasicReq;
import g3.b;

/* JADX INFO: loaded from: classes2.dex */
public abstract class BasicDeviceReq extends BasicReq {

    @b(name = "devId")
    protected String devId;

    protected BasicDeviceReq() {
    }

    public String getDevId() {
        return this.devId;
    }

    public void setDevId(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("BasicDeviceReq devId is empty");
        }
        this.devId = str;
    }

    @Override // com.haier.uhome.usdk.base.json.BasicReq
    public String toString() {
        return "BasicDeviceReq{" + super.toString() + "devId=" + this.devId + '}';
    }
}
