package com.alibaba.fastjson.parser.deserializer;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.IdentityHashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: loaded from: classes.dex */
public class c1 implements e1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static c1 f12877a = new c1();

    public static Object f(com.alibaba.fastjson.parser.b bVar, Map<Object, Object> map, Type type, Type type2, Object obj) {
        com.alibaba.fastjson.parser.d dVar = bVar.f12789f;
        if (dVar.L0() != 12 && dVar.L0() != 16) {
            throw new com.alibaba.fastjson.d("syntax error, expect {, actual " + dVar.A1());
        }
        e1 e1VarN = bVar.u().n(type);
        e1 e1VarN2 = bVar.u().n(type2);
        dVar.Q(e1VarN.e());
        com.alibaba.fastjson.parser.i iVarC = bVar.C();
        while (dVar.L0() != 13) {
            try {
                Object obj2 = null;
                if (dVar.L0() == 4 && dVar.N1() && !dVar.G(com.alibaba.fastjson.parser.c.DisableSpecialKeyDetect)) {
                    dVar.v0(4);
                    if (dVar.L0() != 4) {
                        throw new com.alibaba.fastjson.d("illegal ref, " + com.alibaba.fastjson.parser.h.a(dVar.L0()));
                    }
                    String strX0 = dVar.x0();
                    if ("..".equals(strX0)) {
                        obj2 = iVarC.f12966b.f12965a;
                    } else if ("$".equals(strX0)) {
                        com.alibaba.fastjson.parser.i iVar = iVarC;
                        while (true) {
                            com.alibaba.fastjson.parser.i iVar2 = iVar.f12966b;
                            if (iVar2 == null) {
                                break;
                            }
                            iVar = iVar2;
                        }
                        obj2 = iVar.f12965a;
                    } else {
                        bVar.g(new com.alibaba.fastjson.parser.b.a(iVarC, strX0));
                        bVar.e2(1);
                    }
                    dVar.Q(13);
                    if (dVar.L0() != 13) {
                        throw new com.alibaba.fastjson.d("illegal ref");
                    }
                    dVar.Q(16);
                    bVar.a2(iVarC);
                    return obj2;
                }
                if (map.size() == 0 && dVar.L0() == 4 && com.alibaba.fastjson.a.f12529c.equals(dVar.x0()) && !dVar.G(com.alibaba.fastjson.parser.c.DisableSpecialKeyDetect)) {
                    dVar.v0(4);
                    dVar.Q(16);
                    if (dVar.L0() == 13) {
                        dVar.E();
                        bVar.a2(iVarC);
                        return map;
                    }
                    dVar.Q(e1VarN.e());
                }
                Object objB = e1VarN.b(bVar, type, null);
                if (dVar.L0() != 17) {
                    throw new com.alibaba.fastjson.d("syntax error, expect :, actual " + dVar.L0());
                }
                dVar.Q(e1VarN2.e());
                Object objB2 = e1VarN2.b(bVar, type2, objB);
                bVar.q(map, objB);
                map.put(objB, objB2);
                if (dVar.L0() == 16) {
                    dVar.Q(e1VarN.e());
                }
            } catch (Throwable th) {
                bVar.a2(iVarC);
                throw th;
            }
        }
        dVar.Q(16);
        bVar.a2(iVarC);
        return map;
    }

    public static Map g(com.alibaba.fastjson.parser.b bVar, Map<String, Object> map, Type type, Object obj) {
        String strS0;
        com.alibaba.fastjson.parser.d dVar = bVar.f12789f;
        int iL0 = dVar.L0();
        int i7 = 0;
        if (iL0 != 12) {
            String str = "syntax error, expect {, actual " + dVar.A1();
            if (obj instanceof String) {
                str = (str + ", fieldName ") + obj;
            }
            String str2 = (str + ", ") + dVar.e();
            if (iL0 != 4) {
                com.alibaba.fastjson.b bVar2 = new com.alibaba.fastjson.b();
                bVar.Y0(bVar2, obj);
                if (bVar2.size() == 1) {
                    Object obj2 = bVar2.get(0);
                    if (obj2 instanceof com.alibaba.fastjson.e) {
                        return (com.alibaba.fastjson.e) obj2;
                    }
                }
            }
            throw new com.alibaba.fastjson.d(str2);
        }
        com.alibaba.fastjson.parser.i iVarC = bVar.C();
        while (true) {
            try {
                dVar.q1();
                char cD1 = dVar.d1();
                if (dVar.G(com.alibaba.fastjson.parser.c.AllowArbitraryCommas)) {
                    while (cD1 == ',') {
                        dVar.next();
                        dVar.q1();
                        cD1 = dVar.d1();
                    }
                }
                if (cD1 == '\"') {
                    strS0 = dVar.g0(bVar.r0(), kotlin.text.h0.f35376b);
                    dVar.q1();
                    if (dVar.d1() != ':') {
                        throw new com.alibaba.fastjson.d("expect ':' at " + dVar.b());
                    }
                } else {
                    if (cD1 == '}') {
                        dVar.next();
                        dVar.s1();
                        dVar.Q(16);
                        bVar.a2(iVarC);
                        return map;
                    }
                    if (cD1 == '\'') {
                        if (!dVar.G(com.alibaba.fastjson.parser.c.AllowSingleQuotes)) {
                            throw new com.alibaba.fastjson.d("syntax error");
                        }
                        strS0 = dVar.g0(bVar.r0(), '\'');
                        dVar.q1();
                        if (dVar.d1() != ':') {
                            throw new com.alibaba.fastjson.d("expect ':' at " + dVar.b());
                        }
                    } else {
                        if (!dVar.G(com.alibaba.fastjson.parser.c.AllowUnQuotedFieldNames)) {
                            throw new com.alibaba.fastjson.d("syntax error");
                        }
                        strS0 = dVar.s0(bVar.r0());
                        dVar.q1();
                        char cD2 = dVar.d1();
                        if (cD2 != ':') {
                            throw new com.alibaba.fastjson.d("expect ':' at " + dVar.b() + ", actual " + cD2);
                        }
                    }
                }
                dVar.next();
                dVar.q1();
                dVar.d1();
                dVar.s1();
                Object objZ1 = null;
                if (strS0 != com.alibaba.fastjson.a.f12529c || dVar.G(com.alibaba.fastjson.parser.c.DisableSpecialKeyDetect)) {
                    dVar.E();
                    if (i7 != 0) {
                        bVar.a2(iVarC);
                    }
                    if (dVar.L0() == 8) {
                        dVar.E();
                    } else {
                        objZ1 = bVar.z1(type, strS0);
                    }
                    map.put(strS0, objZ1);
                    bVar.q(map, strS0);
                    bVar.Y1(iVarC, objZ1, strS0);
                    bVar.a2(iVarC);
                    int iL1 = dVar.L0();
                    if (iL1 == 20 || iL1 == 15) {
                        break;
                        break;
                    }
                    if (iL1 == 13) {
                        dVar.E();
                        bVar.a2(iVarC);
                        return map;
                    }
                } else {
                    String strG0 = dVar.g0(bVar.r0(), kotlin.text.h0.f35376b);
                    com.alibaba.fastjson.parser.j jVarU = bVar.u();
                    Class<?> clsF = jVarU.f(strG0, null, dVar.V0());
                    if (!Map.class.isAssignableFrom(clsF)) {
                        e1 e1VarN = jVarU.n(clsF);
                        dVar.Q(16);
                        bVar.e2(2);
                        if (iVarC != null && !(obj instanceof Integer)) {
                            bVar.R1();
                        }
                        Map map2 = (Map) e1VarN.b(bVar, clsF, obj);
                        bVar.a2(iVarC);
                        return map2;
                    }
                    dVar.Q(16);
                    if (dVar.L0() == 13) {
                        dVar.Q(16);
                        bVar.a2(iVarC);
                        return map;
                    }
                }
                i7++;
            } catch (Throwable th) {
                bVar.a2(iVarC);
                throw th;
            }
        }
        bVar.a2(iVarC);
        return map;
    }

    @Override // com.alibaba.fastjson.parser.deserializer.e1
    public <T> T b(com.alibaba.fastjson.parser.b bVar, Type type, Object obj) {
        if (type == com.alibaba.fastjson.e.class && bVar.K() == null) {
            return (T) bVar.q1();
        }
        com.alibaba.fastjson.parser.d dVar = bVar.f12789f;
        if (dVar.L0() == 8) {
            dVar.Q(16);
            return null;
        }
        Map<Object, Object> mapC = c(type);
        com.alibaba.fastjson.parser.i iVarC = bVar.C();
        try {
            bVar.Y1(iVarC, mapC, obj);
            return (T) d(bVar, type, obj, mapC);
        } finally {
            bVar.a2(iVarC);
        }
    }

    public Map<Object, Object> c(Type type) {
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
        if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            Type rawType = parameterizedType.getRawType();
            return EnumMap.class.equals(rawType) ? new EnumMap((Class) parameterizedType.getActualTypeArguments()[0]) : c(rawType);
        }
        Class cls = (Class) type;
        if (cls.isInterface()) {
            throw new com.alibaba.fastjson.d("unsupport type " + type);
        }
        try {
            return (Map) cls.newInstance();
        } catch (Exception e8) {
            throw new com.alibaba.fastjson.d("unsupport type " + type, e8);
        }
    }

    protected Object d(com.alibaba.fastjson.parser.b bVar, Type type, Object obj, Map map) {
        if (!(type instanceof ParameterizedType)) {
            return bVar.B1(map, obj);
        }
        ParameterizedType parameterizedType = (ParameterizedType) type;
        Type type2 = parameterizedType.getActualTypeArguments()[0];
        Type type3 = map.getClass().getName().equals("org.springframework.util.LinkedMultiValueMap") ? List.class : parameterizedType.getActualTypeArguments()[1];
        return String.class == type2 ? g(bVar, map, type3, obj) : f(bVar, map, type2, type3, obj);
    }

    @Override // com.alibaba.fastjson.parser.deserializer.e1
    public int e() {
        return 12;
    }
}
