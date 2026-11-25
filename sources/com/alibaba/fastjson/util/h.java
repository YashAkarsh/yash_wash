package com.alibaba.fastjson.util;

import com.alibaba.fastjson.serializer.k1;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Class<?> f13341a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Class<?> f13342b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Constructor<?> f13343c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Constructor<?> f13344d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Method f13345e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Method f13346f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f13347g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final e[] f13348h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final e[] f13349i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f13350j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final e0.d f13351k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f13352l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final String f13353m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String[] f13354n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public Type[] f13355o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public String[] f13356p;

    public h(Class<?> cls, Class<?> cls2, Constructor<?> constructor, Constructor<?> constructor2, Method method, Method method2, e0.d dVar, List<e> list) {
        e0.b bVar;
        this.f13341a = cls;
        this.f13342b = cls2;
        this.f13343c = constructor;
        this.f13344d = constructor2;
        this.f13345e = method;
        this.f13350j = l.W(cls);
        this.f13346f = method2;
        this.f13351k = dVar;
        if (dVar != null) {
            String strTypeName = dVar.typeName();
            String strTypeKey = dVar.typeKey();
            this.f13353m = strTypeKey.length() <= 0 ? null : strTypeKey;
            if (strTypeName.length() != 0) {
                this.f13352l = strTypeName;
            } else {
                this.f13352l = cls.getName();
            }
            String[] strArrOrders = dVar.orders();
            this.f13354n = strArrOrders.length == 0 ? null : strArrOrders;
        } else {
            this.f13352l = cls.getName();
            this.f13353m = null;
            this.f13354n = null;
        }
        e[] eVarArr = new e[list.size()];
        this.f13348h = eVarArr;
        list.toArray(eVarArr);
        e[] eVarArr2 = new e[eVarArr.length];
        boolean z7 = false;
        if (this.f13354n != null) {
            LinkedHashMap linkedHashMap = new LinkedHashMap(list.size());
            for (e eVar : eVarArr) {
                linkedHashMap.put(eVar.f13293a, eVar);
            }
            int i7 = 0;
            for (String str : this.f13354n) {
                e eVar2 = (e) linkedHashMap.get(str);
                if (eVar2 != null) {
                    eVarArr2[i7] = eVar2;
                    linkedHashMap.remove(str);
                    i7++;
                }
            }
            Iterator it = linkedHashMap.values().iterator();
            while (it.hasNext()) {
                eVarArr2[i7] = (e) it.next();
                i7++;
            }
        } else {
            System.arraycopy(eVarArr, 0, eVarArr2, 0, eVarArr.length);
            Arrays.sort(eVarArr2);
        }
        this.f13349i = Arrays.equals(this.f13348h, eVarArr2) ? this.f13348h : eVarArr2;
        if (constructor != null) {
            this.f13347g = constructor.getParameterTypes().length;
        } else if (method != null) {
            this.f13347g = method.getParameterTypes().length;
        } else {
            this.f13347g = 0;
        }
        if (constructor2 != null) {
            this.f13355o = constructor2.getParameterTypes();
            if (!l.g0(cls)) {
                if (this.f13355o.length == this.f13348h.length) {
                    int i8 = 0;
                    while (true) {
                        Type[] typeArr = this.f13355o;
                        if (i8 >= typeArr.length) {
                            z7 = true;
                            break;
                        } else if (typeArr[i8] != this.f13348h[i8].f13297e) {
                            break;
                        } else {
                            i8++;
                        }
                    }
                }
                if (z7) {
                    return;
                }
                this.f13356p = b.g(constructor2);
                return;
            }
            this.f13356p = l.V(cls);
            Annotation[][] parameterAnnotations = constructor2.getParameterAnnotations();
            for (int i9 = 0; i9 < this.f13356p.length && i9 < parameterAnnotations.length; i9++) {
                Annotation[] annotationArr = parameterAnnotations[i9];
                int length = annotationArr.length;
                int i10 = 0;
                while (true) {
                    if (i10 >= length) {
                        bVar = null;
                        break;
                    }
                    Annotation annotation = annotationArr[i10];
                    if (annotation instanceof e0.b) {
                        bVar = (e0.b) annotation;
                        break;
                    }
                    i10++;
                }
                if (bVar != null) {
                    String strName = bVar.name();
                    if (strName.length() > 0) {
                        this.f13356p[i9] = strName;
                    }
                }
            }
        }
    }

    static boolean a(List<e> list, e eVar) {
        int size = list.size() - 1;
        while (size >= 0) {
            e eVar2 = list.get(size);
            if (eVar2.f13293a.equals(eVar.f13293a) && (!eVar2.f13300h || eVar.f13300h)) {
                if (eVar2.f13297e.isAssignableFrom(eVar.f13297e) || eVar2.compareTo(eVar) < 0) {
                    list.remove(size);
                    break;
                }
                return false;
            }
            size--;
        }
        list.add(eVar);
        return true;
    }

    public static h b(Class<?> cls, Type type, com.alibaba.fastjson.m mVar) {
        return c(cls, type, mVar, false, l.f13374a);
    }

    /* JADX WARN: Code duplicated, block: B:120:0x0297  */
    /* JADX WARN: Code duplicated, block: B:124:0x02a9  */
    /* JADX WARN: Code duplicated, block: B:126:0x02af  */
    /* JADX WARN: Code duplicated, block: B:129:0x02bd  */
    /* JADX WARN: Code duplicated, block: B:132:0x02c7  */
    /* JADX WARN: Code duplicated, block: B:133:0x02c9  */
    /* JADX WARN: Code duplicated, block: B:136:0x02ce  */
    /* JADX WARN: Code duplicated, block: B:150:0x0303  */
    /* JADX WARN: Code duplicated, block: B:151:0x0309  */
    /* JADX WARN: Code duplicated, block: B:209:0x0480  */
    /* JADX WARN: Code duplicated, block: B:234:0x0573 A[PHI: r11
      0x0573: PHI (r11v17 java.lang.String) = (r11v16 java.lang.String), (r11v16 java.lang.String), (r11v18 java.lang.String) binds: [B:233:0x0571, B:236:0x057e, B:240:0x0597] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:265:0x0641  */
    /* JADX WARN: Code duplicated, block: B:314:0x077d A[PHI: r27
      0x077d: PHI (r27v4 java.lang.Class<?>) = (r14v4 java.lang.Class<?>), (r14v4 java.lang.Class<?>), (r14v4 java.lang.Class<?>), (r27v6 java.lang.Class<?>) binds: [B:327:0x07b2, B:329:0x07bc, B:313:0x077b, B:308:0x074a] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:404:0x09e9 A[PHI: r4 r5 r6
      0x09e9: PHI (r4v3 java.lang.reflect.Field[]) = (r4v2 java.lang.reflect.Field[]), (r4v4 java.lang.reflect.Field[]) binds: [B:398:0x09d9, B:403:0x09e7] A[DONT_GENERATE, DONT_INLINE]
      0x09e9: PHI (r5v3 char) = (r5v2 char), (r5v4 char) binds: [B:398:0x09d9, B:403:0x09e7] A[DONT_GENERATE, DONT_INLINE]
      0x09e9: PHI (r6v2 char) = (r6v1 char), (r6v3 char) binds: [B:398:0x09d9, B:403:0x09e7] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:452:0x02e4 A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    public static h c(Class<?> cls, Type type, com.alibaba.fastjson.m mVar, boolean z7, boolean z8) {
        Class<?> cls2;
        Class<String> cls3;
        Class<Collection> cls4;
        ArrayList arrayList;
        Method[] methodArr;
        Field[] fieldArr;
        Class<e0.b> cls5;
        int i7;
        Constructor<?> constructorG;
        Field[] fieldArr2;
        String str;
        Class<e0.b> cls6;
        e0.d dVar;
        Method[] methodArr2;
        Class<?> cls7;
        Class<Collection> cls8;
        e0.b bVar;
        char c8;
        char c9;
        String string;
        Field[] fieldArr3;
        e0.b bVar2;
        Class<?> cls9;
        int iE;
        String strJ;
        Class<e0.b> cls10;
        int i8;
        e0.b bVar3;
        com.alibaba.fastjson.m mVar2;
        int i9;
        int i10;
        int i11;
        String str2;
        String str3;
        StringBuilder sb;
        String str4;
        Class<?> cls11;
        Class<String> cls12;
        Class<Collection> cls13;
        int i12;
        String[] strArrG;
        Constructor<?>[] constructorArr;
        int i13;
        int i14;
        int i15;
        String[] strArrG2;
        Class<?>[] parameterTypes;
        e0.b bVar4;
        Class<e0.b> cls14;
        int iOrdinal;
        int iE2;
        int iD;
        e0.b bVar5;
        Class<?> cls15;
        e0.b bVar6;
        String strName;
        Field field;
        int i16;
        int iE3;
        int iD2;
        com.alibaba.fastjson.m mVarNaming;
        e0.d dVar2 = (e0.d) l.M(cls, e0.d.class);
        com.alibaba.fastjson.m mVar3 = (dVar2 == null || (mVarNaming = dVar2.naming()) == null || mVarNaming == com.alibaba.fastjson.m.CamelCase) ? mVar : mVarNaming;
        Class<?> clsF = f(cls, dVar2);
        Field[] declaredFields = cls.getDeclaredFields();
        Method[] methods = cls.getMethods();
        boolean zG0 = l.g0(cls);
        Constructor<?>[] declaredConstructors = cls.getDeclaredConstructors();
        Constructor<?> constructorH = (!zG0 || declaredConstructors.length == 1) ? clsF == null ? h(cls, declaredConstructors) : h(clsF, clsF.getDeclaredConstructors()) : null;
        Method method = null;
        Method method2 = null;
        ArrayList arrayList2 = new ArrayList();
        if (z7) {
            for (Class<?> superclass = cls; superclass != null; superclass = superclass.getSuperclass()) {
                d(cls, type, mVar3, arrayList2, superclass.getDeclaredFields());
            }
            return new h(cls, clsF, constructorH, null, null, null, dVar2, arrayList2);
        }
        boolean z9 = cls.isInterface() || Modifier.isAbstract(cls.getModifiers());
        Class<Collection> cls16 = Collection.class;
        Class<String> cls17 = String.class;
        Class<?> cls18 = Object.class;
        Class<e0.b> cls19 = e0.b.class;
        com.alibaba.fastjson.m mVar4 = mVar3;
        if ((constructorH == null && clsF == null) || z9) {
            constructorG = g(declaredConstructors);
            if (constructorG == null || z9) {
                Class<?> cls20 = cls18;
                cls3 = cls17;
                cls4 = cls16;
                arrayList = arrayList2;
                Class<e0.b> cls21 = cls19;
                Method methodI = i(cls, methods);
                if (methodI != null) {
                    l.p0(methodI);
                    Class<?>[] parameterTypes2 = methodI.getParameterTypes();
                    if (parameterTypes2.length > 0) {
                        Annotation[][] parameterAnnotations = methodI.getParameterAnnotations();
                        int i17 = 0;
                        while (i17 < parameterTypes2.length) {
                            Annotation[] annotationArr = parameterAnnotations[i17];
                            int length = annotationArr.length;
                            int i18 = 0;
                            while (true) {
                                if (i18 >= length) {
                                    bVar5 = null;
                                    break;
                                }
                                Annotation annotation = annotationArr[i18];
                                if (annotation instanceof e0.b) {
                                    bVar5 = (e0.b) annotation;
                                    break;
                                }
                                i18++;
                            }
                            if (bVar5 == null) {
                                throw new com.alibaba.fastjson.d("illegal json creator");
                            }
                            a(arrayList, new e(bVar5.name(), cls, parameterTypes2[i17], methodI.getGenericParameterTypes()[i17], l.R(cls, bVar5.name(), declaredFields), bVar5.ordinal(), k1.e(bVar5.serialzeFeatures()), com.alibaba.fastjson.parser.c.d(bVar5.parseFeatures())));
                            i17++;
                            parameterAnnotations = parameterAnnotations;
                            parameterTypes2 = parameterTypes2;
                        }
                        return new h(cls, clsF, null, null, methodI, null, dVar2, arrayList);
                    }
                } else {
                    if (!z9) {
                        String name = cls.getName();
                        if (!zG0 || declaredConstructors.length <= 0) {
                            int length2 = declaredConstructors.length;
                            String[] strArr = null;
                            int i19 = 0;
                            while (true) {
                                if (i19 < length2) {
                                    Constructor<?> constructor = declaredConstructors[i19];
                                    Class<?>[] parameterTypes3 = constructor.getParameterTypes();
                                    if (name.equals("org.springframework.security.web.authentication.WebAuthenticationDetails") && parameterTypes3.length == 2) {
                                        cls12 = cls3;
                                        constructorArr = declaredConstructors;
                                        if (parameterTypes3[0] == cls12) {
                                            if (parameterTypes3[1] == cls12) {
                                                constructor.setAccessible(true);
                                                strArrG = b.g(constructor);
                                                constructorG = constructor;
                                                methodI = methodI;
                                                cls11 = cls20;
                                            }
                                        }
                                        if (name.equals("org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken") || parameterTypes3.length != 3) {
                                            i13 = length2;
                                            cls11 = cls20;
                                        } else {
                                            cls11 = cls20;
                                            i13 = length2;
                                            if (parameterTypes3[0] == cls11 && parameterTypes3[1] == cls11) {
                                                methodI = methodI;
                                                cls13 = cls4;
                                                if (parameterTypes3[2] == cls13) {
                                                    constructor.setAccessible(true);
                                                    strArrG = new String[]{"principal", "credentials", "authorities"};
                                                    constructorG = constructor;
                                                    i12 = 0;
                                                }
                                            }
                                            if (name.equals("org.springframework.security.core.authority.SimpleGrantedAuthority")) {
                                                i14 = 1;
                                                i12 = 0;
                                                if (parameterTypes3.length == 1 && parameterTypes3[0] == cls12) {
                                                    strArrG = new String[]{"authority"};
                                                    constructorG = constructor;
                                                }
                                            } else {
                                                i14 = 1;
                                                i12 = 0;
                                            }
                                            if ((constructor.getModifiers() & i14) != 0) {
                                                i15 = i14;
                                            } else {
                                                i15 = i12;
                                            }
                                            if (i15 == 0 && (strArrG2 = b.g(constructor)) != null && strArrG2.length != 0 && (constructorG == null || strArr == null || strArrG2.length > strArr.length)) {
                                                strArr = strArrG2;
                                                constructorG = constructor;
                                            }
                                            i19++;
                                            cls20 = cls11;
                                            cls3 = cls12;
                                            cls4 = cls13;
                                            length2 = i13;
                                            declaredConstructors = constructorArr;
                                            methodI = methodI;
                                        }
                                        cls13 = cls4;
                                        if (name.equals("org.springframework.security.core.authority.SimpleGrantedAuthority")) {
                                            i14 = 1;
                                            i12 = 0;
                                            if (parameterTypes3.length == 1) {
                                                strArrG = new String[]{"authority"};
                                                constructorG = constructor;
                                            }
                                        } else {
                                            i14 = 1;
                                            i12 = 0;
                                        }
                                        if ((constructor.getModifiers() & i14) != 0) {
                                            i15 = i14;
                                        } else {
                                            i15 = i12;
                                        }
                                        if (i15 == 0) {
                                            strArr = strArrG2;
                                            constructorG = constructor;
                                        }
                                        i19++;
                                        cls20 = cls11;
                                        cls3 = cls12;
                                        cls4 = cls13;
                                        length2 = i13;
                                        declaredConstructors = constructorArr;
                                        methodI = methodI;
                                    } else {
                                        constructorArr = declaredConstructors;
                                        cls12 = cls3;
                                    }
                                    if (name.equals("org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken")) {
                                        i13 = length2;
                                        cls11 = cls20;
                                        cls13 = cls4;
                                    } else {
                                        i13 = length2;
                                        cls11 = cls20;
                                        cls13 = cls4;
                                    }
                                    if (name.equals("org.springframework.security.core.authority.SimpleGrantedAuthority")) {
                                        i14 = 1;
                                        i12 = 0;
                                        if (parameterTypes3.length == 1) {
                                            strArrG = new String[]{"authority"};
                                            constructorG = constructor;
                                        }
                                    } else {
                                        i14 = 1;
                                        i12 = 0;
                                    }
                                    if ((constructor.getModifiers() & i14) != 0) {
                                        i15 = i14;
                                    } else {
                                        i15 = i12;
                                    }
                                    if (i15 == 0) {
                                        strArr = strArrG2;
                                        constructorG = constructor;
                                    }
                                    i19++;
                                    cls20 = cls11;
                                    cls3 = cls12;
                                    cls4 = cls13;
                                    length2 = i13;
                                    declaredConstructors = constructorArr;
                                    methodI = methodI;
                                } else {
                                    methodI = methodI;
                                    cls11 = cls20;
                                    cls12 = cls3;
                                    cls13 = cls4;
                                    i12 = 0;
                                    strArrG = strArr;
                                }
                                if (strArrG != null) {
                                    parameterTypes = constructorG.getParameterTypes();
                                } else {
                                    parameterTypes = null;
                                }
                                if (strArrG != null || parameterTypes.length != strArrG.length) {
                                    throw new com.alibaba.fastjson.d("default constructor not found. " + cls);
                                }
                                Annotation[][] parameterAnnotations2 = constructorG.getParameterAnnotations();
                                int i20 = i12;
                                while (i20 < parameterTypes.length) {
                                    Annotation[] annotationArr2 = parameterAnnotations2[i20];
                                    String str5 = strArrG[i20];
                                    int length3 = annotationArr2.length;
                                    Class<?> cls22 = cls11;
                                    int i21 = i12;
                                    while (true) {
                                        if (i21 >= length3) {
                                            bVar4 = null;
                                            break;
                                        }
                                        int i22 = length3;
                                        Annotation annotation2 = annotationArr2[i21];
                                        Annotation[] annotationArr3 = annotationArr2;
                                        if (annotation2 instanceof e0.b) {
                                            bVar4 = (e0.b) annotation2;
                                            break;
                                        }
                                        i21++;
                                        annotationArr2 = annotationArr3;
                                        length3 = i22;
                                    }
                                    Class<?> cls23 = parameterTypes[i20];
                                    Type type2 = constructorG.getGenericParameterTypes()[i20];
                                    Field fieldR = l.R(cls, str5, declaredFields);
                                    if (fieldR == null || bVar4 != null) {
                                        cls14 = cls21;
                                    } else {
                                        cls14 = cls21;
                                        bVar4 = (e0.b) fieldR.getAnnotation(cls14);
                                    }
                                    if (bVar4 != null) {
                                        String strName2 = bVar4.name();
                                        if (strName2.length() != 0) {
                                            str5 = strName2;
                                        }
                                        iOrdinal = bVar4.ordinal();
                                        iE2 = k1.e(bVar4.serialzeFeatures());
                                        iD = com.alibaba.fastjson.parser.c.d(bVar4.parseFeatures());
                                    } else if ("org.springframework.security.core.userdetails.User".equals(name) && "password".equals(str5)) {
                                        iD = com.alibaba.fastjson.parser.c.InitStringFieldAsEmpty.f12829a;
                                        iOrdinal = i12;
                                        iE2 = iOrdinal;
                                    } else {
                                        iOrdinal = i12;
                                        iE2 = iOrdinal;
                                        iD = iE2;
                                    }
                                    a(arrayList, new e(str5, cls, cls23, type2, fieldR, iOrdinal, iE2, iD));
                                    i20++;
                                    cls21 = cls14;
                                    strArrG = strArrG;
                                    parameterTypes = parameterTypes;
                                    name = name;
                                    methods = methods;
                                    cls12 = cls12;
                                    cls11 = cls22;
                                    declaredFields = declaredFields;
                                    i12 = i12;
                                    cls13 = cls13;
                                }
                                cls2 = cls11;
                                cls3 = cls12;
                                methodArr = methods;
                                fieldArr = declaredFields;
                                cls4 = cls13;
                                i7 = i12;
                                cls5 = cls21;
                                if (!zG0 && !cls.getName().equals("javax.servlet.http.Cookie")) {
                                    return new h(cls, clsF, null, constructorG, null, null, dVar2, arrayList);
                                }
                            }
                        } else {
                            String[] strArrV = l.V(cls);
                            Constructor<?> constructorU = l.U(declaredConstructors);
                            l.p0(constructorU);
                            constructorG = constructorU;
                            strArrG = strArrV;
                            methodI = methodI;
                            cls11 = cls20;
                            cls12 = cls3;
                        }
                        cls13 = cls4;
                        i12 = 0;
                        if (strArrG != null) {
                            parameterTypes = constructorG.getParameterTypes();
                        } else {
                            parameterTypes = null;
                        }
                        if (strArrG != null) {
                        }
                        throw new com.alibaba.fastjson.d("default constructor not found. " + cls);
                    }
                    method2 = methodI;
                }
                fieldArr = declaredFields;
                methodI = methodI;
                cls5 = cls21;
                cls2 = cls20;
                i7 = 0;
                methodArr = methods;
                method2 = methodI;
            } else {
                l.p0(constructorG);
                Class<?>[] parameterTypes4 = constructorG.getParameterTypes();
                if (parameterTypes4.length > 0) {
                    Annotation[][] parameterAnnotations3 = constructorG.getParameterAnnotations();
                    String[] strArrG3 = null;
                    int i23 = 0;
                    while (i23 < parameterTypes4.length) {
                        Annotation[] annotationArr4 = parameterAnnotations3[i23];
                        int length4 = annotationArr4.length;
                        int i24 = 0;
                        while (true) {
                            if (i24 >= length4) {
                                cls15 = cls18;
                                bVar6 = null;
                                break;
                            }
                            Annotation annotation3 = annotationArr4[i24];
                            cls15 = cls18;
                            if (annotation3 instanceof e0.b) {
                                bVar6 = (e0.b) annotation3;
                                break;
                            }
                            i24++;
                            cls18 = cls15;
                        }
                        Class<?> cls24 = parameterTypes4[i23];
                        Type type3 = constructorG.getGenericParameterTypes()[i23];
                        if (bVar6 != null) {
                            Field fieldR2 = l.R(cls, bVar6.name(), declaredFields);
                            int iOrdinal2 = bVar6.ordinal();
                            iE3 = k1.e(bVar6.serialzeFeatures());
                            iD2 = com.alibaba.fastjson.parser.c.d(bVar6.parseFeatures());
                            field = fieldR2;
                            strName = bVar6.name();
                            i16 = iOrdinal2;
                        } else {
                            strName = null;
                            field = null;
                            i16 = 0;
                            iE3 = 0;
                            iD2 = 0;
                        }
                        if (strName == null || strName.length() == 0) {
                            if (strArrG3 == null) {
                                strArrG3 = b.g(constructorG);
                            }
                            strName = strArrG3[i23];
                        }
                        Class<e0.b> cls25 = cls19;
                        int i25 = i16;
                        ArrayList arrayList3 = arrayList2;
                        a(arrayList3, new e(strName, cls, cls24, type3, field, i25, iE3, iD2));
                        i23++;
                        arrayList2 = arrayList3;
                        cls19 = cls25;
                        parameterTypes4 = parameterTypes4;
                        cls18 = cls15;
                        cls17 = cls17;
                        cls16 = cls16;
                    }
                }
                cls3 = cls17;
                cls4 = cls16;
                arrayList = arrayList2;
                fieldArr = declaredFields;
                cls5 = cls19;
                cls2 = cls18;
                i7 = 0;
                methodArr = methods;
            }
        } else {
            cls2 = cls18;
            cls3 = cls17;
            cls4 = cls16;
            arrayList = arrayList2;
            methodArr = methods;
            fieldArr = declaredFields;
            cls5 = cls19;
            i7 = 0;
            constructorG = null;
        }
        if (constructorH != null) {
            l.p0(constructorH);
        }
        String str6 = "set";
        if (clsF != null) {
            Class<e0.c> cls26 = e0.c.class;
            e0.c cVar = (e0.c) clsF.getAnnotation(cls26);
            String strWithPrefix = cVar != null ? cVar.withPrefix() : null;
            if (strWithPrefix == null || strWithPrefix.length() == 0) {
                strWithPrefix = "with";
            }
            String str7 = strWithPrefix;
            Method[] methods2 = clsF.getMethods();
            int length5 = methods2.length;
            int i26 = i7;
            while (i26 < length5) {
                Method method3 = methods2[i26];
                if (!Modifier.isStatic(method3.getModifiers()) && method3.getReturnType().equals(clsF)) {
                    e0.b bVarA0 = (e0.b) method3.getAnnotation(cls5);
                    if (bVarA0 == null) {
                        bVarA0 = l.a0(cls, method3);
                    }
                    e0.b bVar7 = bVarA0;
                    if (bVar7 == null) {
                        i9 = 0;
                        i10 = 0;
                        i11 = 0;
                    } else if (bVar7.deserialize()) {
                        int iOrdinal3 = bVar7.ordinal();
                        int iE4 = k1.e(bVar7.serialzeFeatures());
                        int iD3 = com.alibaba.fastjson.parser.c.d(bVar7.parseFeatures());
                        if (bVar7.name().length() != 0) {
                            i26 = i26;
                            length5 = length5;
                            methods2 = methods2;
                            cls26 = cls26;
                            methodArr = methodArr;
                            fieldArr = fieldArr;
                            cls5 = cls5;
                            dVar2 = dVar2;
                            clsF = clsF;
                            a(arrayList, new e(bVar7.name(), method3, null, cls, type, iOrdinal3, iE4, iD3, bVar7, null, null));
                            str4 = str7;
                            str2 = str6;
                        } else {
                            i9 = iOrdinal3;
                            i10 = iE4;
                            i11 = iD3;
                        }
                    } else {
                        fieldArr = fieldArr;
                        i26 = i26;
                        length5 = length5;
                        methods2 = methods2;
                        str4 = str7;
                        cls26 = cls26;
                        str2 = str6;
                        cls5 = cls5;
                        dVar2 = dVar2;
                        methodArr = methodArr;
                        clsF = clsF;
                    }
                    String name2 = method3.getName();
                    str2 = str6;
                    if (!name2.startsWith(str2) || name2.length() <= 3) {
                        str3 = str7;
                        if (name2.startsWith(str3) && name2.length() > str3.length()) {
                            sb = new StringBuilder(name2.substring(str3.length()));
                        } else {
                            str4 = str3;
                        }
                    } else {
                        sb = new StringBuilder(name2.substring(3));
                        str3 = str7;
                    }
                    char cCharAt = sb.charAt(0);
                    if (Character.isUpperCase(cCharAt)) {
                        sb.setCharAt(0, Character.toLowerCase(cCharAt));
                        str4 = str3;
                        a(arrayList, new e(sb.toString(), method3, null, cls, type, i9, i10, i11, bVar7, null, null));
                    } else {
                        str4 = str3;
                    }
                } else {
                    fieldArr = fieldArr;
                    i26 = i26;
                    length5 = length5;
                    methods2 = methods2;
                    str4 = str7;
                    cls26 = cls26;
                    str2 = str6;
                    cls5 = cls5;
                    dVar2 = dVar2;
                    methodArr = methodArr;
                    clsF = clsF;
                }
                i26++;
                str6 = str2;
                clsF = clsF;
                str7 = str4;
                length5 = length5;
                methods2 = methods2;
                cls26 = cls26;
                methodArr = methodArr;
                cls5 = cls5;
                dVar2 = dVar2;
                fieldArr = fieldArr;
            }
            fieldArr2 = fieldArr;
            str = str6;
            cls6 = cls5;
            dVar = dVar2;
            methodArr2 = methodArr;
            cls7 = clsF;
            e0.c cVar2 = (e0.c) cls7.getAnnotation(cls26);
            String strBuildMethod = cVar2 != null ? cVar2.buildMethod() : null;
            if (strBuildMethod == null || strBuildMethod.length() == 0) {
                strBuildMethod = "build";
            }
            try {
                method = cls7.getMethod(strBuildMethod, new Class[0]);
            } catch (NoSuchMethodException | SecurityException unused) {
            }
            if (method == null) {
                try {
                    method = cls7.getMethod("create", new Class[0]);
                } catch (NoSuchMethodException | SecurityException unused2) {
                }
            }
            if (method == null) {
                throw new com.alibaba.fastjson.d("buildMethod not found.");
            }
            l.p0(method);
        } else {
            fieldArr2 = fieldArr;
            str = "set";
            cls6 = cls5;
            dVar = dVar2;
            methodArr2 = methodArr;
            cls7 = clsF;
        }
        Method[] methodArr3 = methodArr2;
        int length6 = methodArr3.length;
        int i27 = 0;
        while (i27 < length6) {
            Method method4 = methodArr3[i27];
            int iOrdinal4 = 0;
            int iD4 = 0;
            String name3 = method4.getName();
            if (Modifier.isStatic(method4.getModifiers())) {
                cls9 = cls2;
                cls10 = cls6;
                mVar2 = mVar4;
            } else {
                Class<?> returnType = method4.getReturnType();
                if (returnType.equals(Void.TYPE) || returnType.equals(method4.getDeclaringClass())) {
                    cls9 = cls2;
                    if (method4.getDeclaringClass() != cls9) {
                        Class<?>[] parameterTypes5 = method4.getParameterTypes();
                        if (parameterTypes5.length != 0) {
                            if (parameterTypes5.length > 2) {
                                cls9 = cls9;
                                i27 = i27;
                                length6 = length6;
                                methodArr3 = methodArr3;
                                str = str;
                                cls7 = cls7;
                                cls3 = cls3;
                                cls10 = cls6;
                            } else {
                                Class<e0.b> cls27 = cls6;
                                e0.b bVar8 = (e0.b) method4.getAnnotation(cls27);
                                if (bVar8 == null || parameterTypes5.length != 2) {
                                    cls3 = cls3;
                                    iE = 0;
                                } else {
                                    Class<String> cls28 = cls3;
                                    if (parameterTypes5[0] == cls28 && parameterTypes5[1] == cls9) {
                                        cls27 = cls27;
                                        cls9 = cls9;
                                        cls3 = cls28;
                                        i27 = i27;
                                        length6 = length6;
                                        methodArr3 = methodArr3;
                                        a(arrayList, new e("", method4, null, cls, type, 0, 0, 0, bVar8, null, null));
                                    } else {
                                        cls3 = cls28;
                                        iE = 0;
                                    }
                                    str = str;
                                    cls7 = cls7;
                                    cls10 = cls27;
                                }
                                if (parameterTypes5.length == 1) {
                                    e0.b bVarA1 = bVar8 == null ? l.a0(cls, method4) : bVar8;
                                    if (bVarA1 != null || name3.length() >= 4) {
                                        if (bVarA1 != null) {
                                            if (bVarA1.deserialize()) {
                                                iOrdinal4 = bVarA1.ordinal();
                                                iE = k1.e(bVarA1.serialzeFeatures());
                                                int iD5 = com.alibaba.fastjson.parser.c.d(bVarA1.parseFeatures());
                                                if (bVarA1.name().length() != 0) {
                                                    cls7 = cls7;
                                                    a(arrayList, new e(bVarA1.name(), method4, null, cls, type, iOrdinal4, iE, iD5, bVarA1, null, null));
                                                } else {
                                                    iD4 = iD5;
                                                }
                                                mVar2 = mVar4;
                                                str = str;
                                                cls10 = cls27;
                                            }
                                        }
                                        if (bVarA1 != null || name3.startsWith(str)) {
                                            char cCharAt2 = name3.charAt(3);
                                            if (Character.isUpperCase(cCharAt2) || cCharAt2 > 512) {
                                                strJ = l.f13374a ? l.J(name3.substring(3)) : Character.toLowerCase(name3.charAt(3)) + name3.substring(4);
                                            } else if (cCharAt2 == '_') {
                                                strJ = name3.substring(4);
                                            } else if (cCharAt2 == 'f') {
                                                strJ = name3.substring(3);
                                            } else if (name3.length() < 5 || !Character.isUpperCase(name3.charAt(4))) {
                                                mVar2 = mVar4;
                                                str = str;
                                                cls10 = cls27;
                                            } else {
                                                strJ = l.J(name3.substring(3));
                                            }
                                            Field[] fieldArr4 = fieldArr2;
                                            Field fieldR3 = l.R(cls, strJ, fieldArr4);
                                            if (fieldR3 == null && parameterTypes5[0] == Boolean.TYPE) {
                                                fieldR3 = l.R(cls, "is" + Character.toUpperCase(strJ.charAt(0)) + strJ.substring(1), fieldArr4);
                                            }
                                            if (fieldR3 != null) {
                                                e0.b bVar9 = (e0.b) fieldR3.getAnnotation(cls27);
                                                if (bVar9 != null) {
                                                    if (bVar9.deserialize()) {
                                                        iOrdinal4 = bVar9.ordinal();
                                                        iE = k1.e(bVar9.serialzeFeatures());
                                                        iD4 = com.alibaba.fastjson.parser.c.d(bVar9.parseFeatures());
                                                        if (bVar9.name().length() != 0) {
                                                            cls10 = cls27;
                                                            str = str;
                                                            a(arrayList, new e(bVar9.name(), method4, fieldR3, cls, type, iOrdinal4, iE, iD4, bVarA1, bVar9, null));
                                                            mVar2 = mVar4;
                                                            fieldArr2 = fieldArr4;
                                                        }
                                                    } else {
                                                        mVar2 = mVar4;
                                                        cls10 = cls27;
                                                        fieldArr2 = fieldArr4;
                                                        str = str;
                                                    }
                                                }
                                                cls10 = cls27;
                                                i8 = iD4;
                                                bVar3 = bVar9;
                                            } else {
                                                cls10 = cls27;
                                                i8 = iD4;
                                                bVar3 = null;
                                            }
                                            mVar2 = mVar4;
                                            if (mVar4 != null) {
                                                strJ = mVar2.a(strJ);
                                            }
                                            fieldArr2 = fieldArr4;
                                            a(arrayList, new e(strJ, method4, fieldR3, cls, type, iOrdinal4, iE, i8, bVarA1, bVar3, null));
                                        } else {
                                            mVar2 = mVar4;
                                            str = str;
                                            cls10 = cls27;
                                        }
                                    }
                                }
                                str = str;
                                cls7 = cls7;
                                cls10 = cls27;
                            }
                            mVar2 = mVar4;
                        }
                    }
                    cls9 = cls9;
                } else {
                    cls9 = cls2;
                }
                cls10 = cls6;
                mVar2 = mVar4;
            }
            i27++;
            mVar4 = mVar2;
            cls3 = cls3;
            methodArr3 = methodArr3;
            cls7 = cls7;
            cls2 = cls9;
            length6 = length6;
            cls6 = cls10;
            str = str;
        }
        Class<?> cls29 = cls7;
        com.alibaba.fastjson.m mVar5 = mVar4;
        Class<e0.b> cls30 = cls6;
        d(cls, type, mVar5, arrayList, cls.getFields());
        Method[] methods3 = cls.getMethods();
        int length7 = methods3.length;
        int i28 = 0;
        while (i28 < length7) {
            Method method5 = methods3[i28];
            String name4 = method5.getName();
            if (name4.length() < 4) {
                i28 = i28;
                length7 = length7;
                methods3 = methods3;
                cls30 = cls30;
                cls8 = cls4;
            } else if (!Modifier.isStatic(method5.getModifiers()) && cls29 == null && name4.startsWith("get") && Character.isUpperCase(name4.charAt(3)) && method5.getParameterTypes().length == 0) {
                Class<Collection> cls31 = cls4;
                if ((cls31.isAssignableFrom(method5.getReturnType()) || Map.class.isAssignableFrom(method5.getReturnType()) || AtomicBoolean.class == method5.getReturnType() || AtomicInteger.class == method5.getReturnType() || AtomicLong.class == method5.getReturnType()) && ((bVar = (e0.b) method5.getAnnotation(cls30)) == null || !bVar.deserialize())) {
                    if (bVar == null || bVar.name().length() <= 0) {
                        StringBuilder sb2 = new StringBuilder();
                        c8 = 3;
                        sb2.append(Character.toLowerCase(name4.charAt(3)));
                        c9 = 4;
                        sb2.append(name4.substring(4));
                        string = sb2.toString();
                        fieldArr3 = fieldArr2;
                        Field fieldR4 = l.R(cls, string, fieldArr3);
                        if (fieldR4 != null && (bVar2 = (e0.b) fieldR4.getAnnotation(cls30)) != null && !bVar2.deserialize()) {
                            fieldArr2 = fieldArr3;
                            cls8 = cls31;
                            i28 = i28;
                            length7 = length7;
                            methods3 = methods3;
                            cls30 = cls30;
                        }
                    } else {
                        string = bVar.name();
                        fieldArr3 = fieldArr2;
                        c9 = 4;
                        c8 = 3;
                    }
                    if (mVar5 != null) {
                        string = mVar5.a(string);
                    }
                    String str8 = string;
                    if (j(arrayList, str8) != null) {
                        fieldArr2 = fieldArr3;
                        cls8 = cls31;
                        i28 = i28;
                        length7 = length7;
                        methods3 = methods3;
                        cls30 = cls30;
                    } else {
                        fieldArr2 = fieldArr3;
                        cls8 = cls31;
                        i28 = i28;
                        length7 = length7;
                        methods3 = methods3;
                        cls30 = cls30;
                        a(arrayList, new e(str8, method5, null, cls, type, 0, 0, 0, bVar, null, null));
                    }
                } else {
                    cls8 = cls31;
                }
                i28++;
                methods3 = methods3;
                fieldArr2 = fieldArr2;
                cls4 = cls8;
                length7 = length7;
                cls30 = cls30;
            } else {
                cls8 = cls4;
            }
            i28++;
            methods3 = methods3;
            fieldArr2 = fieldArr2;
            cls4 = cls8;
            length7 = length7;
            cls30 = cls30;
        }
        return new h(cls, cls29, constructorH, constructorG, method2, method, dVar, arrayList);
    }

    /* JADX WARN: Code duplicated, block: B:24:0x004e  */
    /* JADX WARN: Code duplicated, block: B:27:0x0058  */
    /* JADX WARN: Code duplicated, block: B:33:0x006f  */
    /* JADX WARN: Code duplicated, block: B:35:0x007e  */
    /* JADX WARN: Code duplicated, block: B:38:0x0085  */
    /* JADX WARN: Code duplicated, block: B:40:0x00a3  */
    /* JADX WARN: Code duplicated, block: B:42:0x00ab  */
    /* JADX WARN: Code duplicated, block: B:44:0x00b0  */
    /* JADX WARN: Code duplicated, block: B:51:0x006b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:6:0x0012  */
    private static void d(Class<?> cls, Type type, com.alibaba.fastjson.m mVar, List<e> list, Field[] fieldArr) {
        Iterator<e> it;
        String name;
        e0.b bVar;
        int i7;
        int i8;
        int i9;
        for (Field field : fieldArr) {
            int modifiers = field.getModifiers();
            if ((modifiers & 8) == 0) {
                boolean z7 = true;
                if ((modifiers & 16) != 0) {
                    Class<?> type2 = field.getType();
                    if (Map.class.isAssignableFrom(type2) || Collection.class.isAssignableFrom(type2) || AtomicLong.class.equals(type2) || AtomicInteger.class.equals(type2) || AtomicBoolean.class.equals(type2)) {
                        it = list.iterator();
                        do {
                            if (it.hasNext()) {
                                z7 = false;
                                break;
                            }
                        } while (!it.next().f13293a.equals(field.getName()));
                        if (z7) {
                            name = field.getName();
                            bVar = (e0.b) field.getAnnotation(e0.b.class);
                            if (bVar != null) {
                                i7 = 0;
                                i8 = 0;
                                i9 = 0;
                            } else if (!bVar.deserialize()) {
                                int iOrdinal = bVar.ordinal();
                                int iE = k1.e(bVar.serialzeFeatures());
                                int iD = com.alibaba.fastjson.parser.c.d(bVar.parseFeatures());
                                if (bVar.name().length() != 0) {
                                    name = bVar.name();
                                }
                                i7 = iOrdinal;
                                i8 = iE;
                                i9 = iD;
                            }
                            if (mVar != null) {
                                name = mVar.a(name);
                            }
                            a(list, new e(name, null, field, cls, type, i7, i8, i9, null, bVar, null));
                        }
                    }
                } else {
                    it = list.iterator();
                    do {
                        if (it.hasNext()) {
                            z7 = false;
                            break;
                        }
                    } while (!it.next().f13293a.equals(field.getName()));
                    if (z7) {
                        name = field.getName();
                        bVar = (e0.b) field.getAnnotation(e0.b.class);
                        if (bVar != null) {
                            i7 = 0;
                            i8 = 0;
                            i9 = 0;
                        } else if (!bVar.deserialize()) {
                            int iOrdinal2 = bVar.ordinal();
                            int iE2 = k1.e(bVar.serialzeFeatures());
                            int iD2 = com.alibaba.fastjson.parser.c.d(bVar.parseFeatures());
                            if (bVar.name().length() != 0) {
                                name = bVar.name();
                            }
                            i7 = iOrdinal2;
                            i8 = iE2;
                            i9 = iD2;
                        }
                        if (mVar != null) {
                            name = mVar.a(name);
                        }
                        a(list, new e(name, null, field, cls, type, i7, i8, i9, null, bVar, null));
                    }
                }
            }
        }
    }

    public static Class<?> e(e0.d dVar) {
        return f(null, dVar);
    }

    public static Class<?> f(Class<?> cls, e0.d dVar) {
        Class<?> clsBuilder;
        if (cls != null && cls.getName().equals("org.springframework.security.web.savedrequest.DefaultSavedRequest")) {
            return l.m0("org.springframework.security.web.savedrequest.DefaultSavedRequest$Builder");
        }
        if (dVar == null || (clsBuilder = dVar.builder()) == Void.class) {
            return null;
        }
        return clsBuilder;
    }

    public static Constructor<?> g(Constructor[] constructorArr) {
        boolean z7;
        Constructor constructor = null;
        for (Constructor constructor2 : constructorArr) {
            if (((e0.a) constructor2.getAnnotation(e0.a.class)) != null) {
                if (constructor != null) {
                    throw new com.alibaba.fastjson.d("multi-JSONCreator");
                }
                constructor = constructor2;
            }
        }
        if (constructor != null) {
            return constructor;
        }
        for (Constructor constructor3 : constructorArr) {
            Annotation[][] parameterAnnotations = constructor3.getParameterAnnotations();
            if (parameterAnnotations.length != 0) {
                int length = parameterAnnotations.length;
                int i7 = 0;
                while (true) {
                    z7 = true;
                    if (i7 >= length) {
                        break;
                    }
                    Annotation[] annotationArr = parameterAnnotations[i7];
                    int length2 = annotationArr.length;
                    int i8 = 0;
                    while (true) {
                        if (i8 >= length2) {
                            z7 = false;
                            break;
                        }
                        if (annotationArr[i8] instanceof e0.b) {
                            break;
                        }
                        i8++;
                    }
                    if (!z7) {
                        z7 = false;
                        break;
                    }
                    i7++;
                }
                if (!z7) {
                    continue;
                } else {
                    if (constructor != null) {
                        throw new com.alibaba.fastjson.d("multi-JSONCreator");
                    }
                    constructor = constructor3;
                }
            }
        }
        return constructor;
    }

    static Constructor<?> h(Class<?> cls, Constructor<?>[] constructorArr) {
        Constructor<?> constructor = null;
        if (Modifier.isAbstract(cls.getModifiers())) {
            return null;
        }
        for (Constructor<?> constructor2 : constructorArr) {
            if (constructor2.getParameterTypes().length == 0) {
                constructor = constructor2;
                break;
            }
        }
        if (constructor != null || !cls.isMemberClass() || Modifier.isStatic(cls.getModifiers())) {
            return constructor;
        }
        for (Constructor<?> constructor3 : constructorArr) {
            Class<?>[] parameterTypes = constructor3.getParameterTypes();
            if (parameterTypes.length == 1 && parameterTypes[0].equals(cls.getDeclaringClass())) {
                return constructor3;
            }
        }
        return constructor;
    }

    private static Method i(Class<?> cls, Method[] methodArr) {
        Method method = null;
        for (Method method2 : methodArr) {
            if (Modifier.isStatic(method2.getModifiers()) && cls.isAssignableFrom(method2.getReturnType()) && ((e0.a) method2.getAnnotation(e0.a.class)) != null) {
                if (method != null) {
                    throw new com.alibaba.fastjson.d("multi-JSONCreator");
                }
                method = method2;
            }
        }
        return method;
    }

    private static e j(List<e> list, String str) {
        for (e eVar : list) {
            if (eVar.f13293a.equals(str)) {
                return eVar;
            }
            Field field = eVar.f13295c;
            if (field != null && eVar.e() != null && field.getName().equals(str)) {
                return eVar;
            }
        }
        return null;
    }
}
