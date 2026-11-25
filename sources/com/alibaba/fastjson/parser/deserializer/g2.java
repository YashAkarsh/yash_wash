package com.alibaba.fastjson.parser.deserializer;

import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes.dex */
public class g2 implements e1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Class<f2> f12886a;

    public g2(Class<f2> cls) {
        this.f12886a = cls;
    }

    @Override // com.alibaba.fastjson.parser.deserializer.e1
    public <T> T b(com.alibaba.fastjson.parser.b bVar, Type type, Object obj) {
        try {
            return (T) bVar.G0(this.f12886a.newInstance(), obj);
        } catch (Exception unused) {
            throw new com.alibaba.fastjson.d("craete instance error");
        }
    }

    @Override // com.alibaba.fastjson.parser.deserializer.e1
    public int e() {
        return 12;
    }
}
