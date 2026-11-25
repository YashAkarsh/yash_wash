package com.haier.library.sumhttp.plugin.resp;

import com.haier.library.sumhttp.plugin.h;

/* JADX INFO: loaded from: classes2.dex */
public class f extends h<Void> {
    @Override // com.haier.library.sumhttp.plugin.h
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public Void a(String str) throws com.haier.library.sumhttp.plugin.c {
        a aVar = (a) com.haier.library.json.a.z(str, a.class);
        String strA = aVar.a();
        String strC = aVar.c();
        if ("00000".equals(strA)) {
            return null;
        }
        throw new com.haier.library.sumhttp.plugin.c("code:" + strA + " message:" + strC);
    }
}
