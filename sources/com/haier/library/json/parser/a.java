package com.haier.library.json.parser;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class a extends h3.d {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected h3.f f26656c;

    public a(m mVar, Class<?> cls, i3.a aVar) {
        super(cls, aVar, 2);
    }

    @Override // h3.d
    public void a(b bVar, Object obj, Type type, Map<String, Object> map) {
        Class<?> cls;
        if (this.f26656c == null) {
            m mVar = bVar.f26661b;
            i3.a aVar = this.f34042a;
            this.f26656c = mVar.b(aVar.f34167g, aVar.f34168h);
        }
        if (type instanceof ParameterizedType) {
            bVar.f26665f.f26767d = type;
        }
        h3.f fVar = this.f26656c;
        i3.a aVar2 = this.f34042a;
        Object objA = fVar.a(bVar, aVar2.f34168h, aVar2.f34161a);
        if (bVar.f26669j == 1) {
            b.a aVarE = bVar.E();
            aVarE.f26675c = this;
            aVarE.f26676d = bVar.f26665f;
            bVar.f26669j = 0;
            return;
        }
        if (obj == null) {
            map.put(this.f34042a.f34161a, objA);
            return;
        }
        if (objA == null && ((cls = this.f34042a.f34167g) == Byte.TYPE || cls == Short.TYPE || cls == Float.TYPE || cls == Double.TYPE)) {
            return;
        }
        f(obj, objA);
    }

    public h3.f g(m mVar) {
        if (this.f26656c == null) {
            i3.a aVar = this.f34042a;
            this.f26656c = mVar.b(aVar.f34167g, aVar.f34168h);
        }
        return this.f26656c;
    }
}
