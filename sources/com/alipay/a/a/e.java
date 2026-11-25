package com.alipay.a.a;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static List<i> f13404a;

    static {
        ArrayList arrayList = new ArrayList();
        f13404a = arrayList;
        arrayList.add(new l());
        f13404a.add(new d());
        f13404a.add(new c());
        f13404a.add(new h());
        f13404a.add(new k());
        f13404a.add(new b());
        f13404a.add(new a());
        f13404a.add(new g());
    }

    public static final <T> T a(Object obj, Type type) {
        T t7;
        for (i iVar : f13404a) {
            if (iVar.a(h0.a.a(type)) && (t7 = (T) iVar.b(obj, type)) != null) {
                return t7;
            }
        }
        return null;
    }

    public static final Object b(String str, Type type) {
        Object bVar;
        if (str == null || str.length() == 0) {
            return null;
        }
        String strTrim = str.trim();
        if (strTrim.startsWith("[") && strTrim.endsWith("]")) {
            bVar = new org.json.alipay.a(strTrim);
        } else {
            if (!strTrim.startsWith("{") || !strTrim.endsWith(com.alipay.sdk.util.j.f13808d)) {
                return a(strTrim, type);
            }
            bVar = new org.json.alipay.b(strTrim);
        }
        return a(bVar, type);
    }
}
