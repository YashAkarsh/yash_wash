package com.haier.uhome.control.base.json.entity;

/* JADX INFO: loaded from: classes2.dex */
public class NameAndValue {
    private String mName;
    private String mValue;

    public NameAndValue(String str, String str2) {
        this.mName = str;
        this.mValue = str2;
    }

    public String getName() {
        return this.mName;
    }

    public String getValue() {
        return this.mValue;
    }

    public void setName(String str) {
        this.mName = str;
    }

    public void setValue(String str) {
        this.mValue = str;
    }

    public String toString() {
        return "NameAndValue{mName=" + this.mName + ", mValue=" + this.mValue + '}';
    }
}
