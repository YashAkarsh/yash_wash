package com.haier.library.json.parser;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.text.h0;

/* JADX INFO: loaded from: classes2.dex */
public class g implements h3.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final h3.d[] f26745a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final h3.d[] f26746b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Class<?> f26747c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final h f26748d;

    public g(m mVar, Class<?> cls, Type type) {
        this(mVar, cls, type, h.b(cls, cls.getModifiers(), type, false, true, true, true));
    }

    /*  JADX ERROR: Type inference failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached with updateSeq = 15161. Try increasing type updates limit count.
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:79)
        */
    private <T> T d(com.haier.library.json.parser.b r33, java.lang.reflect.Type r34, java.lang.Object r35, java.lang.Object r36) {
        /*
            Method dump skipped, instruction units count: 1516
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.haier.library.json.parser.g.d(com.haier.library.json.parser.b, java.lang.reflect.Type, java.lang.Object, java.lang.Object):java.lang.Object");
    }

    private <T> T e(b bVar, Type type, Object obj, Object obj2) {
        Enum enumValueOf;
        String strS;
        e eVar = bVar.f26664e;
        T t7 = (T) b(bVar, type);
        int length = this.f26746b.length;
        int i7 = 0;
        while (i7 < length) {
            char c8 = i7 == length + (-1) ? ']' : ',';
            h3.d dVar = this.f26746b[i7];
            i3.a aVar = dVar.f34042a;
            Class<?> cls = aVar.f34167g;
            try {
                if (cls == Integer.TYPE) {
                    int iN = (int) eVar.N();
                    if (aVar.f34164d) {
                        aVar.f34163c.setInt(t7, iN);
                    } else {
                        dVar.f(t7, new Integer(iN));
                    }
                    char c9 = eVar.f26710f;
                    if (c9 == ',') {
                        int i8 = eVar.f26711g + 1;
                        eVar.f26711g = i8;
                        eVar.f26710f = i8 >= eVar.f26720p ? (char) 26 : eVar.f26719o.charAt(i8);
                        eVar.f26705a = 16;
                    } else if (c9 == ']') {
                        int i9 = eVar.f26711g + 1;
                        eVar.f26711g = i9;
                        eVar.f26710f = i9 >= eVar.f26720p ? (char) 26 : eVar.f26719o.charAt(i9);
                        eVar.f26705a = 15;
                    } else {
                        eVar.x();
                    }
                } else {
                    if (cls == String.class) {
                        char c10 = eVar.f26710f;
                        if (c10 == '\"') {
                            strS = eVar.S(h0.f35376b);
                        } else {
                            if (c10 != 'n' || !eVar.f26719o.startsWith("null", eVar.f26711g)) {
                                throw new com.haier.library.json.d("not match string. feild : " + obj);
                            }
                            int i10 = eVar.f26711g + 4;
                            eVar.f26711g = i10;
                            eVar.f26710f = i10 >= eVar.f26720p ? (char) 26 : eVar.f26719o.charAt(i10);
                            strS = null;
                        }
                        if (aVar.f34164d) {
                            aVar.f34163c.set(t7, strS);
                        } else {
                            dVar.f(t7, strS);
                        }
                        char c11 = eVar.f26710f;
                        if (c11 == ',') {
                            int i11 = eVar.f26711g + 1;
                            eVar.f26711g = i11;
                            eVar.f26710f = i11 >= eVar.f26720p ? (char) 26 : eVar.f26719o.charAt(i11);
                            eVar.f26705a = 16;
                        } else if (c11 == ']') {
                            int i12 = eVar.f26711g + 1;
                            eVar.f26711g = i12;
                            eVar.f26710f = i12 >= eVar.f26720p ? (char) 26 : eVar.f26719o.charAt(i12);
                            eVar.f26705a = 15;
                        } else {
                            eVar.x();
                        }
                    } else if (cls == Long.TYPE) {
                        long jN = eVar.N();
                        if (aVar.f34164d) {
                            aVar.f34163c.setLong(t7, jN);
                        } else {
                            dVar.f(t7, new Long(jN));
                        }
                        char c12 = eVar.f26710f;
                        if (c12 == ',') {
                            int i13 = eVar.f26711g + 1;
                            eVar.f26711g = i13;
                            eVar.f26710f = i13 >= eVar.f26720p ? (char) 26 : eVar.f26719o.charAt(i13);
                            eVar.f26705a = 16;
                        } else if (c12 == ']') {
                            int i14 = eVar.f26711g + 1;
                            eVar.f26711g = i14;
                            eVar.f26710f = i14 >= eVar.f26720p ? (char) 26 : eVar.f26719o.charAt(i14);
                            eVar.f26705a = 15;
                        } else {
                            eVar.x();
                        }
                    } else if (cls == Boolean.TYPE) {
                        boolean zC = eVar.C();
                        if (aVar.f34164d) {
                            aVar.f34163c.setBoolean(t7, zC);
                        } else {
                            dVar.f(t7, Boolean.valueOf(zC));
                        }
                        char c13 = eVar.f26710f;
                        if (c13 == ',') {
                            int i15 = eVar.f26711g + 1;
                            eVar.f26711g = i15;
                            eVar.f26710f = i15 >= eVar.f26720p ? (char) 26 : eVar.f26719o.charAt(i15);
                            eVar.f26705a = 16;
                        } else if (c13 == ']') {
                            int i16 = eVar.f26711g + 1;
                            eVar.f26711g = i16;
                            eVar.f26710f = i16 >= eVar.f26720p ? (char) 26 : eVar.f26719o.charAt(i16);
                            eVar.f26705a = 15;
                        } else {
                            eVar.x();
                        }
                    } else if (cls.isEnum()) {
                        char c14 = eVar.f26710f;
                        if (c14 == '\"') {
                            String strT = eVar.T(bVar.f26660a);
                            enumValueOf = strT == null ? null : Enum.valueOf(cls, strT);
                        } else {
                            if (c14 < '0' || c14 > '9') {
                                throw new com.haier.library.json.d("illegal enum." + eVar.n());
                            }
                            enumValueOf = ((c) ((a) dVar).g(bVar.f26661b)).f26678b[(int) eVar.N()];
                        }
                        dVar.f(t7, enumValueOf);
                        char c15 = eVar.f26710f;
                        if (c15 == ',') {
                            int i17 = eVar.f26711g + 1;
                            eVar.f26711g = i17;
                            eVar.f26710f = i17 >= eVar.f26720p ? (char) 26 : eVar.f26719o.charAt(i17);
                            eVar.f26705a = 16;
                        } else if (c15 == ']') {
                            int i18 = eVar.f26711g + 1;
                            eVar.f26711g = i18;
                            eVar.f26710f = i18 >= eVar.f26720p ? (char) 26 : eVar.f26719o.charAt(i18);
                            eVar.f26705a = 15;
                        } else {
                            eVar.x();
                        }
                    } else if (cls == Date.class && eVar.f26710f == '1') {
                        dVar.f(t7, new Date(eVar.N()));
                        char c16 = eVar.f26710f;
                        if (c16 == ',') {
                            int i19 = eVar.f26711g + 1;
                            eVar.f26711g = i19;
                            eVar.f26710f = i19 >= eVar.f26720p ? (char) 26 : eVar.f26719o.charAt(i19);
                            eVar.f26705a = 16;
                        } else if (c16 == ']') {
                            int i20 = eVar.f26711g + 1;
                            eVar.f26711g = i20;
                            eVar.f26710f = i20 >= eVar.f26720p ? (char) 26 : eVar.f26719o.charAt(i20);
                            eVar.f26705a = 15;
                        } else {
                            eVar.x();
                        }
                    } else {
                        char c17 = eVar.f26710f;
                        if (c17 == '[') {
                            int i21 = eVar.f26711g + 1;
                            eVar.f26711g = i21;
                            eVar.f26710f = i21 >= eVar.f26720p ? (char) 26 : eVar.f26719o.charAt(i21);
                            eVar.f26705a = 14;
                        } else if (c17 == '{') {
                            int i22 = eVar.f26711g + 1;
                            eVar.f26711g = i22;
                            eVar.f26710f = i22 >= eVar.f26720p ? (char) 26 : eVar.f26719o.charAt(i22);
                            eVar.f26705a = 12;
                        } else {
                            eVar.x();
                        }
                        dVar.a(bVar, t7, aVar.f34168h, null);
                        if (c8 == ']') {
                            if (eVar.f26705a != 15) {
                                throw new com.haier.library.json.d("syntax error");
                            }
                        } else if (c8 == ',' && eVar.f26705a != 16) {
                            throw new com.haier.library.json.d("syntax error");
                        }
                    }
                    i7++;
                }
                i7++;
            } catch (IllegalAccessException e8) {
                throw new com.haier.library.json.d("set " + aVar.f34161a + "error", e8);
            }
        }
        if (eVar.f26710f == ',') {
            int i23 = eVar.f26711g + 1;
            eVar.f26711g = i23;
            eVar.f26710f = i23 >= eVar.f26720p ? (char) 26 : eVar.f26719o.charAt(i23);
            eVar.f26705a = 16;
        } else {
            eVar.x();
        }
        return t7;
    }

    private boolean i(b bVar, String str, Object obj, Type type, Map<String, Object> map) {
        e eVar = bVar.f26664e;
        h3.d dVarF = f(str);
        if (dVarF == null) {
            boolean zStartsWith = str.startsWith("is");
            for (h3.d dVar : this.f26746b) {
                i3.a aVar = dVar.f34042a;
                Class<?> cls = aVar.f34167g;
                String str2 = aVar.f34161a;
                if (str2.equalsIgnoreCase(str) || (zStartsWith && ((cls == Boolean.TYPE || cls == Boolean.class) && str2.equalsIgnoreCase(str.substring(2))))) {
                    dVarF = dVar;
                    break;
                }
            }
        }
        if (dVarF == null) {
            h(bVar, obj, str);
            return false;
        }
        eVar.z(':');
        dVarF.a(bVar, obj, type, map);
        return true;
    }

    @Override // h3.f
    public <T> T a(b bVar, Type type, Object obj) {
        return (T) d(bVar, type, obj, null);
    }

    protected Object b(b bVar, Type type) {
        if ((type instanceof Class) && this.f26747c.isInterface()) {
            return Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[]{(Class) type}, new com.haier.library.json.e((bVar.f26664e.f26707c & d.OrderedField.f26696a) != 0));
        }
        h hVar = this.f26748d;
        Constructor<?> constructor = hVar.f26749a;
        if (constructor == null) {
            return null;
        }
        try {
            Object objNewInstance = hVar.f26750b == 0 ? constructor.newInstance(new Object[0]) : constructor.newInstance(bVar.f26665f.f26764a);
            if (bVar != null && (bVar.f26664e.f26707c & d.InitStringFieldAsEmpty.f26696a) != 0) {
                for (i3.a aVar : this.f26748d.f26753e) {
                    if (aVar.f34167g == String.class) {
                        aVar.g(objNewInstance, "");
                    }
                }
            }
            return objNewInstance;
        } catch (Exception e8) {
            throw new com.haier.library.json.d("create instance error, class " + this.f26747c.getName(), e8);
        }
    }

    public Object c(Map<String, Object> map, m mVar) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        h hVar = this.f26748d;
        if (hVar.f26751c == null) {
            Object objB = b(null, this.f26747c);
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                h3.d dVarF = f(entry.getKey());
                if (dVarF != null) {
                    Object value = entry.getValue();
                    i3.a aVar = dVarF.f34042a;
                    Method method = aVar.f34162b;
                    if (method != null) {
                        method.invoke(objB, i3.d.c(value, method.getGenericParameterTypes()[0], mVar));
                    } else {
                        aVar.f34163c.set(objB, i3.d.c(value, aVar.f34168h, mVar));
                    }
                }
            }
            return objB;
        }
        i3.a[] aVarArr = hVar.f26753e;
        int length = aVarArr.length;
        Object[] objArr = new Object[length];
        for (int i7 = 0; i7 < length; i7++) {
            objArr[i7] = map.get(aVarArr[i7].f34161a);
        }
        Constructor<?> constructor = this.f26748d.f26751c;
        if (constructor == null) {
            return null;
        }
        try {
            return constructor.newInstance(objArr);
        } catch (Exception e8) {
            throw new com.haier.library.json.d("create instance error, " + this.f26748d.f26751c.toGenericString(), e8);
        }
    }

    protected h3.d f(String str) {
        if (str == null) {
            return null;
        }
        int i7 = 0;
        if (!this.f26748d.f26756h) {
            int length = this.f26746b.length - 1;
            while (i7 <= length) {
                int i8 = (i7 + length) >>> 1;
                int iCompareTo = this.f26746b[i8].f34042a.f34161a.compareTo(str);
                if (iCompareTo < 0) {
                    i7 = i8 + 1;
                } else {
                    if (iCompareTo <= 0) {
                        return this.f26746b[i8];
                    }
                    length = i8 - 1;
                }
            }
            return null;
        }
        while (true) {
            h3.d[] dVarArr = this.f26746b;
            if (i7 >= dVarArr.length) {
                return null;
            }
            if (dVarArr[i7].f34042a.f34161a.equalsIgnoreCase(str)) {
                return this.f26746b[i7];
            }
            i7++;
        }
    }

    protected g g(m mVar, h hVar, String str) {
        g3.d dVar = hVar.f26755g;
        if (dVar == null) {
            return null;
        }
        for (Class<?> cls : dVar.seeAlso()) {
            h3.f fVarC = mVar.c(cls);
            if (fVarC instanceof g) {
                g gVar = (g) fVarC;
                h hVar2 = gVar.f26748d;
                if (hVar2.f26758j.equals(str)) {
                    return gVar;
                }
                g gVarG = g(mVar, hVar2, str);
                if (gVarG != null) {
                    return gVarG;
                }
            }
        }
        return null;
    }

    void h(b bVar, Object obj, String str) {
        e eVar = bVar.f26664e;
        if ((eVar.f26707c & d.IgnoreNotMatch.f26696a) == 0) {
            throw new com.haier.library.json.d("setter not found, class " + this.f26747c.getName() + ", property " + str);
        }
        eVar.z(':');
        List<h3.c> list = bVar.f26670k;
        Type typeB = null;
        if (list != null) {
            Iterator<h3.c> it = list.iterator();
            while (it.hasNext()) {
                typeB = it.next().b(obj, str);
            }
        }
        Object objG = typeB == null ? bVar.G() : bVar.x0(typeB);
        if (obj instanceof h3.a) {
            ((h3.a) obj).a(str, objG);
            return;
        }
        List<h3.b> list2 = bVar.f26671l;
        if (list2 != null) {
            Iterator<h3.b> it2 = list2.iterator();
            while (it2.hasNext()) {
                it2.next().a(obj, str, objG);
            }
        }
    }

    public g(m mVar, Class<?> cls, Type type, h hVar) {
        this.f26747c = cls;
        this.f26748d = hVar;
        i3.a[] aVarArr = hVar.f26754f;
        this.f26746b = new h3.d[aVarArr.length];
        int length = aVarArr.length;
        for (int i7 = 0; i7 < length; i7++) {
            this.f26746b[i7] = mVar.a(mVar, cls, hVar.f26754f[i7]);
        }
        i3.a[] aVarArr2 = hVar.f26753e;
        this.f26745a = new h3.d[aVarArr2.length];
        int length2 = aVarArr2.length;
        for (int i8 = 0; i8 < length2; i8++) {
            this.f26745a[i8] = f(hVar.f26753e[i8].f34161a);
        }
    }
}
