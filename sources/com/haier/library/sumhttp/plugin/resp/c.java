package com.haier.library.sumhttp.plugin.resp;

import com.haier.library.sumhttp.plugin.h;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class c<T> extends h<List<T>> {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private Class<T> f27971i;

    public c(Class<T> cls) {
        this.f27971i = cls;
    }

    @Override // com.haier.library.sumhttp.plugin.h
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public List<T> a(String str) throws com.haier.library.sumhttp.plugin.c {
        a aVar = (a) com.haier.library.json.a.z(str, a.class);
        String strA = aVar.a();
        String strC = aVar.c();
        if ("00000".equals(strA)) {
            return com.haier.library.json.a.o(aVar.b(), this.f27971i);
        }
        throw new com.haier.library.sumhttp.plugin.c("code:" + strA + " message:" + strC);
    }
}
