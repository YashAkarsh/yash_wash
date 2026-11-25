package com.haier.uhome.control.base.json;

import android.text.TextUtils;
import g3.b;

/* JADX INFO: loaded from: classes2.dex */
public class KeyValueItem {

    @b(name = "name")
    private String mName;

    @b(name = "value")
    private String mValue;

    public String getName() {
        return this.mName;
    }

    public String getValue() {
        return this.mValue;
    }

    public void setName(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("name should not be null");
        }
        this.mName = str;
    }

    public void setValue(String str) {
        this.mValue = str;
    }

    public String toString() {
        return "KeyValueItem{mName=" + this.mName + ", mValue=" + this.mValue + '}';
    }
}
