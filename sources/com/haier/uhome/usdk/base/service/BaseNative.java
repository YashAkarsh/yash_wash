package com.haier.uhome.usdk.base.service;

import android.text.TextUtils;
import android.util.Base64;

/* JADX INFO: loaded from: classes2.dex */
public abstract class BaseNative {
    public com.haier.uhome.usdk.base.a.b mPackageReceive;

    static {
        System.loadLibrary("all-in-one");
    }

    public void callback(String str) {
        String str2;
        try {
            str2 = new String(Base64.decode(str.getBytes(), 2));
        } catch (Exception e8) {
            e3.a.g("ignore", e8);
            str2 = null;
        }
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        e3.a.d(getLogMainModule(), getLogSubModule(), "%s get msg:%s", getClass().getSimpleName(), str2);
        com.haier.uhome.usdk.base.a.b bVar = this.mPackageReceive;
        if (bVar != null) {
            bVar.onReceive(str2);
        }
    }

    public void callbackUncode(String str) {
        if (TextUtils.isEmpty(str)) {
            e3.a.u(getLogMainModule(), getLogSubModule(), "data is empty!", new Object[0]);
            return;
        }
        e3.a.d(getLogMainModule(), getLogSubModule(), "%s get uncode msg:%s", getClass().getSimpleName(), str);
        com.haier.uhome.usdk.base.a.b bVar = this.mPackageReceive;
        if (bVar != null) {
            bVar.onReceive(str);
        }
    }

    protected String getLogMainModule() {
        return null;
    }

    protected String getLogSubModule() {
        return null;
    }

    public void setUserPackageReceive(com.haier.uhome.usdk.base.a.b bVar) {
        this.mPackageReceive = bVar;
    }
}
