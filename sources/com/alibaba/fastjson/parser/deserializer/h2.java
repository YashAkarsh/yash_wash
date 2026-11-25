package com.alibaba.fastjson.parser.deserializer;

import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class h2 extends k {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f12887d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final List f12888e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final com.alibaba.fastjson.parser.b f12889f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Object f12890g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Map f12891h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Collection f12892i;

    public h2(com.alibaba.fastjson.parser.b bVar, List list, int i7) {
        super(null, null);
        this.f12889f = bVar;
        this.f12887d = i7;
        this.f12888e = list;
        this.f12890g = null;
        this.f12891h = null;
        this.f12892i = null;
    }

    @Override // com.alibaba.fastjson.parser.deserializer.k
    public void b(com.alibaba.fastjson.parser.b bVar, Object obj, Type type, Map<String, Object> map) {
    }

    @Override // com.alibaba.fastjson.parser.deserializer.k
    public void e(Object obj, Object obj2) {
        com.alibaba.fastjson.b bVar;
        Object objZ1;
        Map map = this.f12891h;
        if (map != null) {
            map.put(this.f12890g, obj2);
            return;
        }
        Collection collection = this.f12892i;
        if (collection != null) {
            collection.add(obj2);
            return;
        }
        this.f12888e.set(this.f12887d, obj2);
        List list = this.f12888e;
        if (!(list instanceof com.alibaba.fastjson.b) || (objZ1 = (bVar = (com.alibaba.fastjson.b) list).z1()) == null || Array.getLength(objZ1) <= this.f12887d) {
            return;
        }
        if (bVar.l1() != null) {
            obj2 = com.alibaba.fastjson.util.l.g(obj2, bVar.l1(), this.f12889f.u());
        }
        Array.set(objZ1, this.f12887d, obj2);
    }

    public h2(Map map, Object obj) {
        super(null, null);
        this.f12889f = null;
        this.f12887d = -1;
        this.f12888e = null;
        this.f12890g = obj;
        this.f12891h = map;
        this.f12892i = null;
    }

    public h2(Collection collection) {
        super(null, null);
        this.f12889f = null;
        this.f12887d = -1;
        this.f12888e = null;
        this.f12890g = null;
        this.f12891h = null;
        this.f12892i = collection;
    }
}
