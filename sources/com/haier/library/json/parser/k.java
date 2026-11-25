package com.haier.library.json.parser;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.IdentityHashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import kotlin.text.h0;

/* JADX INFO: loaded from: classes2.dex */
class k implements h3.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static k f26763a = new k();

    k() {
    }

    public static Object c(b bVar, Map<Object, Object> map, Type type, Type type2, Object obj) {
        e eVar = bVar.f26664e;
        int i7 = eVar.f26705a;
        if (i7 != 12 && i7 != 16) {
            throw new com.haier.library.json.d("syntax error, expect {, actual " + f.a(i7));
        }
        h3.f fVarC = bVar.f26661b.c(type);
        h3.f fVarC2 = bVar.f26661b.c(type2);
        eVar.x();
        l lVar = bVar.f26665f;
        while (true) {
            try {
                int i8 = eVar.f26705a;
                if (i8 == 13) {
                    eVar.y(16);
                    bVar.Y0(lVar);
                    return map;
                }
                Object obj2 = null;
                if (i8 == 4 && eVar.s() && !eVar.r(d.DisableSpecialKeyDetect)) {
                    eVar.z(':');
                    if (eVar.f26705a != 4) {
                        throw new com.haier.library.json.d("illegal ref, " + f.a(i8));
                    }
                    String strA0 = eVar.a0();
                    if ("..".equals(strA0)) {
                        obj2 = lVar.f26765b.f26764a;
                    } else if ("$".equals(strA0)) {
                        l lVar2 = lVar;
                        while (true) {
                            l lVar3 = lVar2.f26765b;
                            if (lVar3 == null) {
                                break;
                            }
                            lVar2 = lVar3;
                        }
                        obj2 = lVar2.f26764a;
                    } else {
                        bVar.c(new b.a(lVar, strA0));
                        bVar.f26669j = 1;
                    }
                    eVar.y(13);
                    if (eVar.f26705a != 13) {
                        throw new com.haier.library.json.d("illegal ref");
                    }
                    eVar.y(16);
                    bVar.Y0(lVar);
                    return obj2;
                }
                if (map.size() == 0 && i8 == 4 && com.haier.library.json.a.f26646c.equals(eVar.a0()) && !eVar.r(d.DisableSpecialKeyDetect)) {
                    eVar.z(':');
                    eVar.y(16);
                    if (eVar.f26705a == 13) {
                        eVar.x();
                        bVar.Y0(lVar);
                        return map;
                    }
                    eVar.x();
                }
                Object objA = fVarC.a(bVar, type, null);
                if (eVar.f26705a != 17) {
                    throw new com.haier.library.json.d("syntax error, expect :, actual " + eVar.f26705a);
                }
                eVar.x();
                Object objA2 = fVarC2.a(bVar, type2, objA);
                if (bVar.f26669j == 1) {
                    bVar.f(map, objA);
                }
                map.put(objA, objA2);
                if (eVar.f26705a == 16) {
                    eVar.x();
                }
            } catch (Throwable th) {
                bVar.Y0(lVar);
                throw th;
            }
        }
    }

    public static Map d(b bVar, Map<String, Object> map, Type type, Object obj) {
        String strV;
        Object objG0;
        e eVar = bVar.f26664e;
        if (eVar.f26705a != 12) {
            throw new com.haier.library.json.d("syntax error, expect {, actual " + eVar.f26705a);
        }
        l lVar = bVar.f26665f;
        while (true) {
            try {
                eVar.Z();
                char c8 = eVar.f26710f;
                if ((eVar.f26707c & d.AllowArbitraryCommas.f26696a) != 0) {
                    while (c8 == ',') {
                        eVar.v();
                        eVar.Z();
                        c8 = eVar.f26710f;
                    }
                }
                if (c8 == '\"') {
                    strV = eVar.U(bVar.f26660a, h0.f35376b);
                    eVar.Z();
                    if (eVar.f26710f != ':') {
                        throw new com.haier.library.json.d("syntax error, " + eVar.n());
                    }
                } else {
                    if (c8 == '}') {
                        eVar.v();
                        eVar.f26714j = 0;
                        eVar.y(16);
                        bVar.Y0(lVar);
                        return map;
                    }
                    if (c8 == '\'') {
                        if ((eVar.f26707c & d.AllowSingleQuotes.f26696a) == 0) {
                            throw new com.haier.library.json.d("syntax error, " + eVar.n());
                        }
                        strV = eVar.U(bVar.f26660a, '\'');
                        eVar.Z();
                        if (eVar.f26710f != ':') {
                            throw new com.haier.library.json.d("syntax error, " + eVar.n());
                        }
                    } else {
                        if ((eVar.f26707c & d.AllowUnQuotedFieldNames.f26696a) == 0) {
                            throw new com.haier.library.json.d("syntax error");
                        }
                        strV = eVar.V(bVar.f26660a);
                        eVar.Z();
                        char c9 = eVar.f26710f;
                        if (c9 != ':') {
                            throw new com.haier.library.json.d("expect ':' at " + eVar.f26706b + ", actual " + c9);
                        }
                    }
                }
                eVar.v();
                eVar.Z();
                eVar.f26714j = 0;
                if (strV != com.haier.library.json.a.f26646c || eVar.r(d.DisableSpecialKeyDetect)) {
                    eVar.x();
                    bVar.Y0(lVar);
                    if (eVar.f26705a == 8) {
                        eVar.x();
                        objG0 = null;
                    } else {
                        objG0 = bVar.G0(type, strV);
                    }
                    map.put(strV, objG0);
                    if (bVar.f26669j == 1) {
                        bVar.f(map, strV);
                    }
                    bVar.V0(lVar, objG0, strV);
                    int i7 = eVar.f26705a;
                    if (i7 != 20 && i7 != 15) {
                        if (i7 == 13) {
                            eVar.x();
                            bVar.Y0(lVar);
                            return map;
                        }
                    }
                    bVar.Y0(lVar);
                    return map;
                }
                Class<?> clsC = i3.d.C(eVar.U(bVar.f26660a, h0.f35376b), bVar.f26661b.f26771c);
                if (clsC != map.getClass()) {
                    h3.f fVarC = bVar.f26661b.c(clsC);
                    eVar.y(16);
                    bVar.f26669j = 2;
                    if (lVar != null && !(obj instanceof Integer)) {
                        bVar.T0();
                    }
                    Map map2 = (Map) fVarC.a(bVar, clsC, obj);
                    bVar.Y0(lVar);
                    return map2;
                }
                eVar.y(16);
                if (eVar.f26705a == 13) {
                    eVar.y(16);
                    bVar.Y0(lVar);
                    return map;
                }
            } catch (Throwable th) {
                bVar.Y0(lVar);
                throw th;
            }
        }
    }

    @Override // h3.f
    public <T> T a(b bVar, Type type, Object obj) {
        if (type == com.haier.library.json.e.class && bVar.f26672m == null) {
            return (T) bVar.s0();
        }
        e eVar = bVar.f26664e;
        if (eVar.f26705a == 8) {
            eVar.y(16);
            return null;
        }
        Map<?, ?> mapB = b(type);
        l lVar = bVar.f26665f;
        try {
            bVar.V0(lVar, mapB, obj);
            if (!(type instanceof ParameterizedType)) {
                return (T) bVar.J0(mapB, obj);
            }
            ParameterizedType parameterizedType = (ParameterizedType) type;
            Type type2 = parameterizedType.getActualTypeArguments()[0];
            Type type3 = parameterizedType.getActualTypeArguments()[1];
            return String.class == type2 ? (T) d(bVar, mapB, type3, obj) : (T) c(bVar, mapB, type2, type3, obj);
        } finally {
            bVar.Y0(lVar);
        }
    }

    protected Map<?, ?> b(Type type) {
        if (type == Properties.class) {
            return new Properties();
        }
        if (type == Hashtable.class) {
            return new Hashtable();
        }
        if (type == IdentityHashMap.class) {
            return new IdentityHashMap();
        }
        if (type == SortedMap.class || type == TreeMap.class) {
            return new TreeMap();
        }
        if (type == ConcurrentMap.class || type == ConcurrentHashMap.class) {
            return new ConcurrentHashMap();
        }
        if (type == Map.class || type == HashMap.class) {
            return new HashMap();
        }
        if (type == LinkedHashMap.class) {
            return new LinkedHashMap();
        }
        if (type == com.haier.library.json.e.class) {
            return new com.haier.library.json.e();
        }
        if (type instanceof ParameterizedType) {
            return b(((ParameterizedType) type).getRawType());
        }
        Class cls = (Class) type;
        if (cls.isInterface()) {
            throw new com.haier.library.json.d("unsupport type " + type);
        }
        try {
            return (Map) cls.newInstance();
        } catch (Exception e8) {
            throw new com.haier.library.json.d("unsupport type " + type, e8);
        }
    }
}
