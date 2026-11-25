package com.google.zxing.client.result;

/* JADX INFO: loaded from: classes2.dex */
public final class f extends a {
    @Override // com.google.zxing.client.result.u
    /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
    public c0 k(com.google.zxing.r rVar) {
        String strG = rVar.g();
        if (!strG.startsWith("MEBKM:")) {
            return null;
        }
        String strR = a.r("TITLE:", strG, true);
        String[] strArrQ = a.q("URL:", strG, true);
        if (strArrQ == null) {
            return null;
        }
        String str = strArrQ[0];
        if (d0.q(str)) {
            return new c0(str, strR);
        }
        return null;
    }
}
