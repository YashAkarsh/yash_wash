package com.haier.uhome.smart.api;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class SmartOpRsp extends BaseSmartRsp {
    private ArrayList<SmartDevicePair> mPairList;

    public SmartOpRsp(int i7) {
        super(i7);
    }

    public ArrayList<SmartDevicePair> getPairList() {
        return this.mPairList;
    }

    public void setPairList(ArrayList<SmartDevicePair> arrayList) {
        this.mPairList = arrayList;
    }

    @Override // com.haier.uhome.smart.api.BaseSmartRsp
    public String toString() {
        return "SmartOpRsp{mPairList=" + this.mPairList + '}';
    }
}
