package com.haier.globalwasher.modle.bean;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class OrderDetailUIBeen {
    private ArrayList<KeyVelauBeen> arrayList;
    private String title;

    public class KeyVelauBeen {
        public String key;
        public int tag = 0;
        public String value;

        public KeyVelauBeen() {
        }
    }

    public ArrayList<KeyVelauBeen> getArrayList() {
        return this.arrayList;
    }

    public String getTitle() {
        return this.title;
    }

    public void setArrayList(ArrayList<KeyVelauBeen> arrayList) {
        this.arrayList = arrayList;
    }

    public void setTitle(String str) {
        this.title = str;
    }
}
