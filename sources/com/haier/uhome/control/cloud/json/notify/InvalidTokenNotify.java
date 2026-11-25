package com.haier.uhome.control.cloud.json.notify;

import com.haier.uhome.control.cloud.a.q;
import com.haier.uhome.usdk.base.c.e;
import com.haier.uhome.usdk.base.json.BasicNotify;
import com.paytm.pgsdk.d;
import g3.b;

/* JADX INFO: loaded from: classes2.dex */
public class InvalidTokenNotify extends BasicNotify {

    @b(name = d.R)
    private String token;

    protected InvalidTokenNotify() {
    }

    @Override // com.haier.uhome.usdk.base.json.BasicNotify
    protected e getNotifyHandler() {
        return new q();
    }

    public String getToken() {
        return this.token;
    }

    public void setToken(String str) {
        this.token = str;
    }

    @Override // com.haier.uhome.usdk.base.json.BasicNotify
    public String toString() {
        return "InvalidTokenNotify{token=" + this.token + '}';
    }
}
