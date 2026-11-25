package com.haier.library.json.parser;

import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes2.dex */
public class c implements h3.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Class<?> f26677a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final Enum[] f26678b;

    public c(Class<?> cls) {
        this.f26677a = cls;
        this.f26678b = (Enum[]) cls.getEnumConstants();
    }

    @Override // h3.f
    public <T> T a(b bVar, Type type, Object obj) {
        try {
            e eVar = bVar.f26664e;
            int i7 = eVar.f26705a;
            if (i7 == 2) {
                int iO = eVar.o();
                eVar.y(16);
                if (iO >= 0) {
                    Object[] objArr = this.f26678b;
                    if (iO <= objArr.length) {
                        return (T) objArr[iO];
                    }
                }
                throw new com.haier.library.json.d("parse enum " + this.f26677a.getName() + " error, value : " + iO);
            }
            if (i7 == 4) {
                String strA0 = eVar.a0();
                eVar.y(16);
                if (strA0.length() == 0) {
                    return null;
                }
                return (T) Enum.valueOf(this.f26677a, strA0);
            }
            if (i7 == 8) {
                eVar.y(16);
                return null;
            }
            throw new com.haier.library.json.d("parse enum " + this.f26677a.getName() + " error, value : " + bVar.G());
        } catch (com.haier.library.json.d e8) {
            throw e8;
        } catch (Exception e9) {
            throw new com.haier.library.json.d(e9.getMessage(), e9);
        }
    }
}
