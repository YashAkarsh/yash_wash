package com.haier.uhome.account.model.uacmodel;

import com.haier.uhome.account.api.RetInfoContent;
import g3.b;

/* JADX INFO: loaded from: classes2.dex */
public class UacModulesInfoItem {

    @b(name = RetInfoContent.BindKEY_ISNULL)
    private String key;

    @b(name = "value")
    private String value;

    public String getKey() {
        return this.key;
    }

    public String getValue() {
        return this.value;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public void setValue(String str) {
        this.value = str;
    }
}
