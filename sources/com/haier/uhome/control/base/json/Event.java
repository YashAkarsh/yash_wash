package com.haier.uhome.control.base.json;

import g3.b;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class Event {

    @b(name = "attrs")
    private List<KeyValueItem> mAttrs;

    @b(name = "name")
    private String mName;

    @b(name = "type")
    private String mType;

    public List<KeyValueItem> getAttrs() {
        return this.mAttrs;
    }

    public String getName() {
        return this.mName;
    }

    public String getType() {
        return this.mType;
    }

    public void setAttrs(List<KeyValueItem> list) {
        this.mAttrs = list;
    }

    public void setName(String str) {
        this.mName = str;
    }

    public void setType(String str) {
        this.mType = str;
    }

    public String toString() {
        return "Event{" + this.mName + "," + this.mType + "," + this.mAttrs + '}';
    }
}
