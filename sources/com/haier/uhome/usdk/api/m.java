package com.haier.uhome.usdk.api;

/* JADX INFO: loaded from: classes2.dex */
public class m extends l {
    @Override // com.haier.uhome.usdk.api.l
    protected int a(uSDKDevice usdkdevice, com.haier.uhome.control.base.api.a aVar) {
        if (usdkdevice == null || aVar == null) {
            return 0;
        }
        int iA = super.a(usdkdevice, aVar);
        if (aVar.getClass().equals(com.haier.uhome.control.noumenon.a.a.class)) {
            return 9;
        }
        return iA;
    }
}
