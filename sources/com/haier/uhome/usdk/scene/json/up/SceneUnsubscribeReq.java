package com.haier.uhome.usdk.scene.json.up;

import com.alipay.sdk.data.a;
import g3.b;

/* JADX INFO: loaded from: classes2.dex */
public class SceneUnsubscribeReq extends BaseUp {

    @b(name = "devId")
    private String devId;

    @b(name = a.f13674p)
    private int timeout;

    public String getDevId() {
        return this.devId;
    }

    public int getTimeout() {
        return this.timeout;
    }

    public void setDevId(String str) {
        this.devId = str;
    }

    public void setTimeout(int i7) {
        this.timeout = i7;
    }

    @Override // com.haier.uhome.usdk.scene.json.up.BaseUp
    public String toString() {
        return "SceneUnsubscribeReq{devId='" + this.devId + "', timeout=" + this.timeout + '}';
    }
}
