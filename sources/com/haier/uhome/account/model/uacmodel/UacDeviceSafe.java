package com.haier.uhome.account.model.uacmodel;

import com.haier.uhome.account.api.RetInfoContent;
import g3.b;

/* JADX INFO: loaded from: classes2.dex */
public class UacDeviceSafe extends UacDevice {

    @b(name = RetInfoContent.BindKEY_ISNULL)
    private String key = "";

    public String getKey() {
        return this.key;
    }

    public void setKey(String str) {
        this.key = str;
    }
}
