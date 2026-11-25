package com.haier.uhome.config.json.resp;

import com.haier.uhome.usdk.base.json.BasicResp;
import g3.b;

/* JADX INFO: loaded from: classes2.dex */
public class NewDirectLinkBindResp extends BasicResp {

    @b(name = "devId")
    private String mDevId;

    @b(name = "module")
    private String mModule;

    public String getDevId() {
        return this.mDevId;
    }

    public String getModule() {
        return this.mModule;
    }

    public void setDevId(String str) {
        this.mDevId = str;
    }

    public void setModule(String str) {
        this.mModule = str;
    }
}
