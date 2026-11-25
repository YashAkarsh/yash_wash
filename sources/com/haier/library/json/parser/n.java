package com.haier.library.json.parser;

import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class n extends h3.d {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f26772c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final List f26773d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final b f26774e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Object f26775f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Map f26776g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Collection f26777h;

    public n(b bVar, List list, int i7) {
        super(null, null, 0);
        this.f26774e = bVar;
        this.f26772c = i7;
        this.f26773d = list;
        this.f26775f = null;
        this.f26776g = null;
        this.f26777h = null;
    }

    @Override // h3.d
    public void a(b bVar, Object obj, Type type, Map<String, Object> map) {
    }

    @Override // h3.d
    public void f(Object obj, Object obj2) {
        com.haier.library.json.b bVar;
        Object objO0;
        Map map = this.f26776g;
        if (map != null) {
            map.put(this.f26775f, obj2);
            return;
        }
        Collection collection = this.f26777h;
        if (collection != null) {
            collection.add(obj2);
            return;
        }
        this.f26773d.set(this.f26772c, obj2);
        List list = this.f26773d;
        if (!(list instanceof com.haier.library.json.b) || (objO0 = (bVar = (com.haier.library.json.b) list).O0()) == null || Array.getLength(objO0) <= this.f26772c) {
            return;
        }
        if (bVar.B0() != null) {
            obj2 = i3.d.c(obj2, bVar.B0(), this.f26774e.f26661b);
        }
        Array.set(objO0, this.f26772c, obj2);
    }

    public n(Map map, Object obj) {
        super(null, null, 0);
        this.f26774e = null;
        this.f26772c = -1;
        this.f26773d = null;
        this.f26775f = obj;
        this.f26776g = map;
        this.f26777h = null;
    }

    public n(Collection collection) {
        super(null, null, 0);
        this.f26774e = null;
        this.f26772c = -1;
        this.f26773d = null;
        this.f26775f = null;
        this.f26776g = null;
        this.f26777h = collection;
    }
}
