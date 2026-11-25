package com.haier.uhome.smart.json;

import g3.b;

/* JADX INFO: loaded from: classes2.dex */
public class Pair {

    @b(name = "name")
    private String name;

    @b(name = "value")
    private String value;

    public String getName() {
        return this.name;
    }

    public String getValue() {
        return this.value;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setValue(String str) {
        this.value = str;
    }

    public String toString() {
        return "Pair{name=" + this.name + ", value=" + this.value + '}';
    }
}
