package com.haier.uhome.control.base.json;

import android.text.TextUtils;
import g3.b;

/* JADX INFO: loaded from: classes2.dex */
public class OperArgs {

    @b(name = "name")
    private String name;

    @b(name = "value")
    private String value;

    public OperArgs() {
    }

    public String getName() {
        return this.name;
    }

    public String getValue() {
        return this.value;
    }

    public void setName(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("name should not be null");
        }
        this.name = str;
    }

    public void setValue(String str) {
        this.value = str;
    }

    public String toString() {
        return "OperArgs{name=" + this.name + ", value=" + this.value + '}';
    }

    public OperArgs(String str, String str2) {
        this.name = str;
        this.value = str2;
    }
}
