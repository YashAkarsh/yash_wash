package com.haier.uhome.control.local.json.notify;

import com.haier.uhome.control.local.a.d;
import com.haier.uhome.usdk.base.c.e;
import com.haier.uhome.usdk.base.json.BasicNotify;
import g3.b;

/* JADX INFO: loaded from: classes2.dex */
public class ConfigFileReadyNotify extends BasicNotify {

    @b(name = "uplusId")
    private String mUplusId;

    @Override // com.haier.uhome.usdk.base.json.BasicNotify
    protected e getNotifyHandler() {
        return new d();
    }

    public String getUplusId() {
        return this.mUplusId;
    }

    public void setUplusId(String str) {
        this.mUplusId = str;
    }
}
