package com.haier.uhome.usdk.api;

import com.haier.uhome.smart.api.SmartOpRsp;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private SmartOpRsp f30719a;

    public s(int i7) {
        this.f30719a = new SmartOpRsp(i7);
    }

    public void a(ArrayList<q> arrayList) {
        this.f30719a.setPairList(z.a(arrayList));
    }

    public String toString() {
        return "USmartOpRsp{ReqSn=" + this.f30719a.getReqSn() + ",Result=" + this.f30719a.getResult() + ",PairList=" + this.f30719a.getPairList() + '}';
    }

    public void a(int i7) {
        this.f30719a.setResult(i7);
    }

    public SmartOpRsp a() {
        return this.f30719a;
    }
}
