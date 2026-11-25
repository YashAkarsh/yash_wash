package com.haier.uhome.control.cloud.json.notify;

import com.haier.uhome.usdk.base.c.e;
import com.haier.uhome.usdk.base.json.BasicNotify;
import g3.b;

/* JADX INFO: loaded from: classes2.dex */
public class CloudBusinessNotify extends BasicNotify {

    @b(name = "info")
    private String info;

    protected CloudBusinessNotify() {
    }

    public String getInfo() {
        return this.info;
    }

    @Override // com.haier.uhome.usdk.base.json.BasicNotify
    protected e getNotifyHandler() {
        return new com.haier.uhome.control.cloud.a.e();
    }

    public void setInfo(String str) {
        this.info = str;
    }

    @Override // com.haier.uhome.usdk.base.json.BasicNotify
    public String toString() {
        return "CloudBusinessNotify{info=" + this.info + '}';
    }
}
