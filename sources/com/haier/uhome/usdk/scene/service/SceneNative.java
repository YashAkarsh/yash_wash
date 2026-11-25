package com.haier.uhome.usdk.scene.service;

import android.text.TextUtils;
import android.util.Base64;
import com.haier.uhome.usdk.base.service.BaseNative;

/* JADX INFO: loaded from: classes2.dex */
public class SceneNative extends BaseNative {
    public native int init();

    public native int unInit();

    public native int userDataDown(String str);

    public void userDataUp(String str) {
        String str2;
        try {
            str2 = new String(Base64.decode(str.getBytes(), 2));
        } catch (Exception unused) {
            e3.a.h("ignore", new Object[0]);
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
}
