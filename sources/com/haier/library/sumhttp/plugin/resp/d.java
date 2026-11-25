package com.haier.library.sumhttp.plugin.resp;

import com.haier.library.sumhttp.plugin.h;

/* JADX INFO: loaded from: classes2.dex */
public class d<T> extends h<T> {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private Class<T> f27972i;

    public d(Class<T> cls) {
        this.f27972i = cls;
    }

    @Override // com.haier.library.sumhttp.plugin.h
    public T a(String str) throws com.haier.library.sumhttp.plugin.c {
        a aVar = (a) com.haier.library.json.a.z(str, a.class);
        String strA = aVar.a();
        String strC = aVar.c();
        if ("00000".equals(strA)) {
            return (T) com.haier.library.json.a.z(aVar.b(), this.f27972i);
        }
        throw new com.haier.library.sumhttp.plugin.c("code:" + strA + " message:" + strC);
    }
}
