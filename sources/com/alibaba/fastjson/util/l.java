package com.alibaba.fastjson.util;

import androidx.constraintlayout.core.motion.utils.w;
import com.alibaba.fastjson.parser.deserializer.e1;
import com.alibaba.fastjson.serializer.f1;
import com.alibaba.fastjson.serializer.k1;
import com.alibaba.fastjson.serializer.u;
import java.lang.annotation.Annotation;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.security.AccessControlException;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Currency;
import java.util.Date;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.UUID;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.i0;
import kotlin.reflect.n;

/* JADX INFO: loaded from: classes.dex */
public class l {
    private static volatile boolean A = false;
    private static Class<?> C = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f13374a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f13375b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static boolean f13376c = true;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static boolean f13377d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static Method f13378e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static boolean f13379f = false;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static Method f13380g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static boolean f13381h = false;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static Class<?> f13382i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static boolean f13383j = false;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static Class<? extends Annotation> f13384k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static Class<? extends Annotation> f13385l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static boolean f13386m = false;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static Class<? extends Annotation> f13387n = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static boolean f13388o = false;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static Method f13389p = null;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static boolean f13390q = false;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static volatile Class f13391r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private static volatile boolean f13392s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private static volatile boolean f13393t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private static volatile Constructor f13394u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private static volatile Method f13395v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private static volatile Method f13396w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private static volatile Method f13397x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private static volatile boolean f13398y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private static volatile Map<Class, String[]> f13399z;
    private static ConcurrentMap<String, Class<?>> B = new ConcurrentHashMap(16, 0.75f, 1);
    private static boolean D = false;

    static {
        try {
            f13374a = "true".equals(f.l(f.f13315b));
            f13375b = "true".equals(f.l(f.f13316c));
        } catch (Throwable unused) {
        }
        a();
    }

    public static Timestamp A(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Calendar) {
            return new Timestamp(((Calendar) obj).getTimeInMillis());
        }
        if (obj instanceof Timestamp) {
            return (Timestamp) obj;
        }
        if (obj instanceof Date) {
            return new Timestamp(((Date) obj).getTime());
        }
        long jLongValue = obj instanceof Number ? ((Number) obj).longValue() : 0L;
        if (obj instanceof String) {
            String strSubstring = (String) obj;
            if (strSubstring.length() == 0 || "null".equals(strSubstring) || "NULL".equals(strSubstring)) {
                return null;
            }
            if (strSubstring.endsWith(".000000000")) {
                strSubstring = strSubstring.substring(0, strSubstring.length() - 10);
            } else if (strSubstring.endsWith(".000000")) {
                strSubstring = strSubstring.substring(0, strSubstring.length() - 7);
            }
            if (i0(strSubstring)) {
                jLongValue = Long.parseLong(strSubstring);
            } else {
                com.alibaba.fastjson.parser.g gVar = new com.alibaba.fastjson.parser.g(strSubstring);
                if (!gVar.T2(false)) {
                    throw new com.alibaba.fastjson.d("can not cast to Timestamp, value : " + strSubstring);
                }
                jLongValue = gVar.X1().getTime().getTime();
            }
        }
        if (jLongValue > 0) {
            return new Timestamp(jLongValue);
        }
        throw new com.alibaba.fastjson.d("can not cast to Timestamp, value : " + obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0, types: [java.lang.reflect.GenericArrayType] */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.lang.reflect.Type] */
    /* JADX WARN: Type inference failed for: r3v10 */
    /* JADX WARN: Type inference failed for: r3v12 */
    /* JADX WARN: Type inference failed for: r3v13 */
    /* JADX WARN: Type inference failed for: r3v14 */
    /* JADX WARN: Type inference failed for: r3v15 */
    /* JADX WARN: Type inference failed for: r3v16 */
    /* JADX WARN: Type inference failed for: r3v17 */
    /* JADX WARN: Type inference failed for: r3v18 */
    /* JADX WARN: Type inference failed for: r3v19 */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v20 */
    public static Type B(GenericArrayType genericArrayType) {
        Type genericComponentType = genericArrayType.getGenericComponentType();
        String str = "[";
        while (genericComponentType instanceof GenericArrayType) {
            genericComponentType = ((GenericArrayType) genericComponentType).getGenericComponentType();
            str = str + str;
        }
        if (genericComponentType instanceof Class) {
            Class cls = (Class) genericComponentType;
            if (cls.isPrimitive()) {
                try {
                    if (cls == Boolean.TYPE) {
                        genericArrayType = Class.forName(str + "Z");
                    } else if (cls == Character.TYPE) {
                        genericArrayType = Class.forName(str + "C");
                    } else if (cls == Byte.TYPE) {
                        genericArrayType = Class.forName(str + "B");
                    } else if (cls == Short.TYPE) {
                        genericArrayType = Class.forName(str + "S");
                    } else if (cls == Integer.TYPE) {
                        genericArrayType = Class.forName(str + "I");
                    } else if (cls == Long.TYPE) {
                        genericArrayType = Class.forName(str + "J");
                    } else if (cls == Float.TYPE) {
                        genericArrayType = Class.forName(str + "F");
                    } else if (cls == Double.TYPE) {
                        genericArrayType = genericArrayType;
                        genericArrayType = Class.forName(str + "D");
                    }
                    genericArrayType = genericArrayType;
                } catch (ClassNotFoundException unused) {
                }
            }
        }
        return genericArrayType;
    }

    public static void C() {
        B.clear();
        a();
    }

    private static void D(Class<?> cls, Map<String, String> map, com.alibaba.fastjson.m mVar, Map<String, e> map2, Field[] fieldArr) {
        String strLabel;
        int i7;
        int i8;
        int i9;
        for (Field field : fieldArr) {
            if (!Modifier.isStatic(field.getModifiers())) {
                e0.b bVar = (e0.b) field.getAnnotation(e0.b.class);
                String name = field.getName();
                if (bVar == null) {
                    strLabel = null;
                    i7 = 0;
                    i8 = 0;
                    i9 = 0;
                } else if (bVar.serialize()) {
                    int iOrdinal = bVar.ordinal();
                    int iE = k1.e(bVar.serialzeFeatures());
                    int iD = com.alibaba.fastjson.parser.c.d(bVar.parseFeatures());
                    if (bVar.name().length() != 0) {
                        name = bVar.name();
                    }
                    strLabel = bVar.label().length() != 0 ? bVar.label() : null;
                    i7 = iOrdinal;
                    i8 = iE;
                    i9 = iD;
                }
                if (map == null || (name = map.get(name)) != null) {
                    if (mVar != null) {
                        name = mVar.a(name);
                    }
                    String str = name;
                    if (!map2.containsKey(str)) {
                        map2.put(str, new e(str, null, field, cls, null, i7, i8, i9, null, bVar, strLabel));
                    }
                }
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:102:0x0222 A[PHI: r15 r31 r32
      0x0222: PHI (r15v12 java.util.LinkedHashMap) = 
      (r15v4 java.util.LinkedHashMap)
      (r15v4 java.util.LinkedHashMap)
      (r15v4 java.util.LinkedHashMap)
      (r15v4 java.util.LinkedHashMap)
      (r15v4 java.util.LinkedHashMap)
      (r15v4 java.util.LinkedHashMap)
      (r15v4 java.util.LinkedHashMap)
      (r15v15 java.util.LinkedHashMap)
     binds: [B:101:0x0220, B:105:0x022f, B:132:0x02a9, B:149:0x02e4, B:122:0x0264, B:124:0x026e, B:110:0x023e, B:93:0x01be] A[DONT_GENERATE, DONT_INLINE]
      0x0222: PHI (r31v5 int) = (r31v3 int), (r31v3 int), (r31v3 int), (r31v3 int), (r31v3 int), (r31v3 int), (r31v3 int), (r31v8 int) binds: [B:101:0x0220, B:105:0x022f, B:132:0x02a9, B:149:0x02e4, B:122:0x0264, B:124:0x026e, B:110:0x023e, B:93:0x01be] A[DONT_GENERATE, DONT_INLINE]
      0x0222: PHI (r32v5 java.lang.reflect.Method[]) = 
      (r32v3 java.lang.reflect.Method[])
      (r32v3 java.lang.reflect.Method[])
      (r32v3 java.lang.reflect.Method[])
      (r32v3 java.lang.reflect.Method[])
      (r32v3 java.lang.reflect.Method[])
      (r32v3 java.lang.reflect.Method[])
      (r32v3 java.lang.reflect.Method[])
      (r32v8 java.lang.reflect.Method[])
     binds: [B:101:0x0220, B:105:0x022f, B:132:0x02a9, B:149:0x02e4, B:122:0x0264, B:124:0x026e, B:110:0x023e, B:93:0x01be] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:240:0x04df  */
    /* JADX WARN: Code duplicated, block: B:241:0x04e1 A[PHI: r12
      0x04e1: PHI (r12v6 java.lang.Class<?>) = (r12v5 java.lang.Class<?>), (r12v9 java.lang.Class<?>), (r12v9 java.lang.Class<?>) binds: [B:240:0x04df, B:203:0x0426, B:213:0x0445] A[DONT_GENERATE, DONT_INLINE]] */
    public static List<e> E(Class<?> cls, e0.d dVar, Map<String, String> map, Map<String, Field> map2, boolean z7, com.alibaba.fastjson.m mVar) {
        Constructor<?>[] constructorArr;
        int i7;
        int i8;
        Method[] methodArr;
        LinkedHashMap linkedHashMap;
        Annotation[][] annotationArr;
        e0.b bVar;
        short[] sArr;
        LinkedHashMap linkedHashMap2;
        int iOrdinal;
        int iE;
        int iD;
        LinkedHashMap linkedHashMap3;
        int i9;
        String strSubstring;
        int i10;
        int i11;
        e0.b bVar2;
        int i12;
        String strX;
        int i13;
        e0.b bVar3;
        int i14;
        char cCharAt;
        String[] strArrV;
        short[] sArr2;
        Field fieldP;
        Constructor constructorU;
        Class<?> cls2 = cls;
        map = map;
        com.alibaba.fastjson.m mVar2 = mVar;
        LinkedHashMap linkedHashMap4 = new LinkedHashMap();
        boolean zG0 = g0(cls);
        Method[] methods = cls.getMethods();
        int length = methods.length;
        Constructor<?>[] declaredConstructors = null;
        String[] strArr = null;
        short[] sArr3 = null;
        Annotation[][] parameterAnnotations = null;
        int i15 = 0;
        while (i15 < length) {
            Method method = methods[i15];
            String name = method.getName();
            String strLabel = null;
            if (Modifier.isStatic(method.getModifiers()) || method.getReturnType().equals(Void.TYPE) || method.getParameterTypes().length != 0 || method.getReturnType() == ClassLoader.class || ((name.equals("getMetaClass") && method.getReturnType().getName().equals("groovy.lang.MetaClass")) || ((name.equals("getSuppressed") && method.getDeclaringClass() == Throwable.class) || (zG0 && h0(cls2, name))))) {
                constructorArr = declaredConstructors;
                i7 = i15;
                i8 = length;
                methodArr = methods;
                linkedHashMap = linkedHashMap4;
            } else {
                Boolean bool = Boolean.FALSE;
                e0.b bVarA0 = (e0.b) method.getAnnotation(e0.b.class);
                if (bVarA0 == null) {
                    bVarA0 = a0(cls2, method);
                }
                String[] strArr2 = strArr;
                LinkedHashMap linkedHashMap5 = linkedHashMap4;
                if (bVarA0 == null && zG0) {
                    if (declaredConstructors != null || (constructorU = U((declaredConstructors = cls.getDeclaredConstructors()))) == null) {
                        strArrV = strArr2;
                    } else {
                        parameterAnnotations = constructorU.getParameterAnnotations();
                        strArrV = V(cls);
                        if (strArrV != null) {
                            String[] strArr3 = new String[strArrV.length];
                            System.arraycopy(strArrV, 0, strArr3, 0, strArrV.length);
                            Arrays.sort(strArr3);
                            short[] sArr4 = new short[strArrV.length];
                            for (short s7 = 0; s7 < strArrV.length; s7 = (short) (s7 + 1)) {
                                sArr4[Arrays.binarySearch(strArr3, strArrV[s7])] = s7;
                            }
                            strArrV = strArr3;
                            parameterAnnotations = parameterAnnotations;
                            sArr3 = sArr4;
                            declaredConstructors = declaredConstructors;
                        }
                    }
                    if (strArrV == null || sArr3 == null || !name.startsWith("get")) {
                        constructorArr = declaredConstructors;
                        sArr2 = sArr3;
                        annotationArr = parameterAnnotations;
                        i7 = i15;
                    } else {
                        String strJ = J(name.substring(3));
                        int iBinarySearch = Arrays.binarySearch(strArrV, strJ);
                        constructorArr = declaredConstructors;
                        i7 = i15;
                        if (iBinarySearch < 0) {
                            for (int i16 = 0; i16 < strArrV.length; i16++) {
                                if (strJ.equalsIgnoreCase(strArrV[i16])) {
                                    iBinarySearch = i16;
                                    break;
                                }
                            }
                        }
                        if (iBinarySearch >= 0) {
                            Annotation[] annotationArr2 = parameterAnnotations[sArr3[iBinarySearch]];
                            if (annotationArr2 != null) {
                                int length2 = annotationArr2.length;
                                sArr2 = sArr3;
                                int i17 = 0;
                                while (true) {
                                    annotationArr = parameterAnnotations;
                                    if (i17 >= length2) {
                                        break;
                                    }
                                    Annotation annotation = annotationArr2[i17];
                                    Annotation[] annotationArr3 = annotationArr2;
                                    if (annotation instanceof e0.b) {
                                        bVarA0 = (e0.b) annotation;
                                        break;
                                    }
                                    i17++;
                                    parameterAnnotations = annotationArr;
                                    annotationArr2 = annotationArr3;
                                }
                            } else {
                                sArr2 = sArr3;
                                annotationArr = parameterAnnotations;
                            }
                            if (bVarA0 == null && (fieldP = com.alibaba.fastjson.parser.j.p(strJ, map2)) != null) {
                                bVar = (e0.b) fieldP.getAnnotation(e0.b.class);
                            }
                            sArr = sArr2;
                            strArr2 = strArrV;
                        } else {
                            sArr2 = sArr3;
                            annotationArr = parameterAnnotations;
                        }
                    }
                    bVar = bVarA0;
                    sArr = sArr2;
                    strArr2 = strArrV;
                } else {
                    bool = bool;
                    i7 = i15;
                    constructorArr = declaredConstructors;
                    annotationArr = parameterAnnotations;
                    bVar = bVarA0;
                    sArr = sArr3;
                }
                if (bVar != null) {
                    if (bVar.serialize()) {
                        iOrdinal = bVar.ordinal();
                        iE = k1.e(bVar.serialzeFeatures());
                        iD = com.alibaba.fastjson.parser.c.d(bVar.parseFeatures());
                        if (bVar.name().length() != 0) {
                            String strName = bVar.name();
                            if (map == null || (strName = map.get(strName)) != null) {
                                String str = strName;
                                i8 = length;
                                methodArr = methods;
                                linkedHashMap2 = linkedHashMap5;
                                linkedHashMap2.put(str, new e(str, method, null, cls, null, iOrdinal, iE, iD, bVar, null, null));
                            }
                            sArr3 = sArr;
                            strArr = strArr2;
                            parameterAnnotations = annotationArr;
                        } else {
                            i8 = length;
                            methodArr = methods;
                            linkedHashMap2 = linkedHashMap5;
                            if (bVar.label().length() != 0) {
                                strLabel = bVar.label();
                            }
                        }
                        map = map;
                        linkedHashMap = linkedHashMap2;
                        mVar2 = mVar;
                        sArr3 = sArr;
                        strArr = strArr2;
                        parameterAnnotations = annotationArr;
                    }
                    i8 = length;
                    methodArr = methods;
                    linkedHashMap = linkedHashMap5;
                    sArr3 = sArr;
                    strArr = strArr2;
                    parameterAnnotations = annotationArr;
                } else {
                    i8 = length;
                    methodArr = methods;
                    linkedHashMap2 = linkedHashMap5;
                    iOrdinal = 0;
                    iE = 0;
                    iD = 0;
                }
                if (name.startsWith("get")) {
                    if (name.length() < 4 || name.equals("getClass") || (name.equals("getDeclaringClass") && cls.isEnum())) {
                        map = map;
                    } else {
                        char cCharAt2 = name.charAt(3);
                        if (Character.isUpperCase(cCharAt2) || cCharAt2 > 512) {
                            strX = X(map2, name, f13374a ? J(name.substring(3)) : Character.toLowerCase(name.charAt(3)) + name.substring(4), 3);
                        } else if (cCharAt2 == '_') {
                            strX = name.substring(4);
                        } else if (cCharAt2 == 'f') {
                            strX = name.substring(3);
                        } else if (name.length() < 5 || !Character.isUpperCase(name.charAt(4))) {
                            map = map;
                        } else {
                            strX = J(name.substring(3));
                        }
                        if (f0(cls2, strX)) {
                            map = map;
                        } else {
                            Field fieldP2 = com.alibaba.fastjson.parser.j.p(strX, map2);
                            if (fieldP2 != null || strX.length() <= 1 || (cCharAt = strX.charAt(1)) < 'A' || cCharAt > 'Z') {
                                i13 = 3;
                            } else {
                                i13 = 3;
                                fieldP2 = com.alibaba.fastjson.parser.j.p(J(name.substring(3)), map2);
                            }
                            Field field = fieldP2;
                            if (field != null) {
                                e0.b bVar4 = (e0.b) field.getAnnotation(e0.b.class);
                                if (bVar4 == null) {
                                    bVar3 = bVar4;
                                } else if (bVar4.serialize()) {
                                    int iOrdinal2 = bVar4.ordinal();
                                    int iE2 = k1.e(bVar4.serialzeFeatures());
                                    int iD2 = com.alibaba.fastjson.parser.c.d(bVar4.parseFeatures());
                                    if (bVar4.name().length() != 0) {
                                        Boolean bool2 = Boolean.TRUE;
                                        String strName2 = bVar4.name();
                                        map = map;
                                        if (map == null || (strName2 = map.get(strName2)) != null) {
                                            bool = bool2;
                                            strX = strName2;
                                        }
                                        sArr3 = sArr;
                                        strArr = strArr2;
                                        parameterAnnotations = annotationArr;
                                    } else {
                                        map = map;
                                    }
                                    if (bVar4.label().length() != 0) {
                                        i14 = iOrdinal2;
                                        iE = iE2;
                                        iD = iD2;
                                        strLabel = bVar4.label();
                                        bool = bool;
                                        bVar3 = bVar4;
                                    } else {
                                        bVar3 = bVar4;
                                        iE = iE2;
                                        iD = iD2;
                                        strLabel = strLabel;
                                        bool = bool;
                                        i14 = iOrdinal2;
                                    }
                                    if (map != null || (strX = map.get(strX)) != null) {
                                        LinkedHashMap linkedHashMap6 = linkedHashMap2;
                                        if (mVar != null && !bool.booleanValue()) {
                                            strX = mVar.a(strX);
                                        }
                                        String str2 = strX;
                                        i9 = i13;
                                        linkedHashMap3 = linkedHashMap6;
                                        linkedHashMap3.put(str2, new e(str2, method, field, cls, null, i14, iE, iD, bVar, bVar3, strLabel));
                                        iOrdinal = i14;
                                        iE = iE;
                                        strLabel = strLabel;
                                    }
                                    sArr3 = sArr;
                                    strArr = strArr2;
                                    parameterAnnotations = annotationArr;
                                } else {
                                    map = map;
                                }
                            } else {
                                bVar3 = null;
                            }
                            i14 = iOrdinal;
                            if (map != null) {
                            }
                            LinkedHashMap linkedHashMap7 = linkedHashMap2;
                            if (mVar != null) {
                                strX = mVar.a(strX);
                            }
                            String str3 = strX;
                            i9 = i13;
                            linkedHashMap3 = linkedHashMap7;
                            linkedHashMap3.put(str3, new e(str3, method, field, cls, null, i14, iE, iD, bVar, bVar3, strLabel));
                            iOrdinal = i14;
                            iE = iE;
                            strLabel = strLabel;
                        }
                    }
                    linkedHashMap = linkedHashMap2;
                    mVar2 = mVar;
                    sArr3 = sArr;
                    strArr = strArr2;
                    parameterAnnotations = annotationArr;
                } else {
                    linkedHashMap3 = linkedHashMap2;
                    i9 = 3;
                }
                if (name.startsWith("is") && name.length() >= i9 && (method.getReturnType() == Boolean.TYPE || method.getReturnType() == Boolean.class)) {
                    char cCharAt3 = name.charAt(2);
                    if (Character.isUpperCase(cCharAt3)) {
                        strSubstring = X(map2, name, f13374a ? J(name.substring(2)) : Character.toLowerCase(name.charAt(2)) + name.substring(i9), 2);
                    } else if (cCharAt3 == '_') {
                        strSubstring = name.substring(i9);
                    } else {
                        if (cCharAt3 == 'f') {
                            strSubstring = name.substring(2);
                        } else {
                            cls2 = cls;
                        }
                        map = map;
                        mVar2 = mVar;
                        linkedHashMap = linkedHashMap3;
                    }
                    cls2 = cls;
                    if (f0(cls2, strSubstring)) {
                        map = map;
                        mVar2 = mVar;
                        linkedHashMap = linkedHashMap3;
                    } else {
                        Field fieldP3 = com.alibaba.fastjson.parser.j.p(strSubstring, map2);
                        if (fieldP3 == null) {
                            fieldP3 = com.alibaba.fastjson.parser.j.p(name, map2);
                        }
                        Field field2 = fieldP3;
                        if (field2 != null) {
                            e0.b bVar5 = (e0.b) field2.getAnnotation(e0.b.class);
                            if (bVar5 != null) {
                                if (bVar5.serialize()) {
                                    int iOrdinal3 = bVar5.ordinal();
                                    int iE3 = k1.e(bVar5.serialzeFeatures());
                                    int iD3 = com.alibaba.fastjson.parser.c.d(bVar5.parseFeatures());
                                    if (bVar5.name().length() != 0) {
                                        strSubstring = bVar5.name();
                                        map = map;
                                        if (map == null || (strSubstring = map.get(strSubstring)) != null) {
                                        }
                                        linkedHashMap = linkedHashMap3;
                                    } else {
                                        map = map;
                                    }
                                    if (bVar5.label().length() != 0) {
                                        bVar2 = bVar5;
                                        i11 = iE3;
                                        i12 = iD3;
                                        strLabel = bVar5.label();
                                        i10 = iOrdinal3;
                                    } else {
                                        bVar2 = bVar5;
                                        i10 = iOrdinal3;
                                        i11 = iE3;
                                        i12 = iD3;
                                    }
                                } else {
                                    map = map;
                                }
                                mVar2 = mVar;
                                linkedHashMap = linkedHashMap3;
                            } else {
                                map = map;
                                i10 = iOrdinal;
                                i11 = iE;
                                i12 = iD;
                                bVar2 = bVar5;
                            }
                        } else {
                            map = map;
                            i10 = iOrdinal;
                            i11 = iE;
                            bVar2 = null;
                            i12 = iD;
                        }
                        if (map == null || (strSubstring = map.get(strSubstring)) != null) {
                            mVar2 = mVar;
                            if (mVar2 != null) {
                                strSubstring = mVar2.a(strSubstring);
                            }
                            String str4 = strSubstring;
                            if (!linkedHashMap3.containsKey(str4)) {
                                linkedHashMap = linkedHashMap3;
                                linkedHashMap.put(str4, new e(str4, method, field2, cls, null, i10, i11, i12, bVar, bVar2, strLabel));
                            }
                        } else {
                            mVar2 = mVar;
                        }
                        linkedHashMap = linkedHashMap3;
                    }
                } else {
                    cls2 = cls;
                    map = map;
                    mVar2 = mVar;
                    linkedHashMap = linkedHashMap3;
                }
                sArr3 = sArr;
                strArr = strArr2;
                parameterAnnotations = annotationArr;
            }
            i15 = i7 + 1;
            linkedHashMap4 = linkedHashMap;
            declaredConstructors = constructorArr;
            length = i8;
            methods = methodArr;
        }
        LinkedHashMap linkedHashMap8 = linkedHashMap4;
        D(cls2, map, mVar2, linkedHashMap8, cls.getFields());
        return S(cls2, z7, linkedHashMap8);
    }

    public static List<e> F(Class<?> cls, Map<String, String> map) {
        return G(cls, map, true);
    }

    public static List<e> G(Class<?> cls, Map<String, String> map, boolean z7) {
        e0.d dVar = (e0.d) M(cls, e0.d.class);
        HashMap map2 = new HashMap();
        com.alibaba.fastjson.parser.j.x(cls, map2);
        return E(cls, dVar, map, map2, z7, com.alibaba.fastjson.m.CamelCase);
    }

    public static List<e> H(Class<?> cls, Map<String, String> map, boolean z7, com.alibaba.fastjson.m mVar) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Class<?> superclass = cls; superclass != null; superclass = superclass.getSuperclass()) {
            D(superclass, map, mVar, linkedHashMap, superclass.getDeclaredFields());
        }
        return S(cls, z7, linkedHashMap);
    }

    public static Collection I(Type type) {
        Class<?> clsY = Y(type);
        if (clsY == AbstractCollection.class || clsY == Collection.class) {
            return new ArrayList();
        }
        if (clsY.isAssignableFrom(HashSet.class)) {
            return new HashSet();
        }
        if (clsY.isAssignableFrom(LinkedHashSet.class)) {
            return new LinkedHashSet();
        }
        if (clsY.isAssignableFrom(TreeSet.class)) {
            return new TreeSet();
        }
        if (clsY.isAssignableFrom(ArrayList.class)) {
            return new ArrayList();
        }
        if (clsY.isAssignableFrom(EnumSet.class)) {
            return EnumSet.noneOf((Class) (type instanceof ParameterizedType ? ((ParameterizedType) type).getActualTypeArguments()[0] : Object.class));
        }
        try {
            return (Collection) clsY.newInstance();
        } catch (Exception unused) {
            throw new com.alibaba.fastjson.d("create instance error, class " + clsY.getName());
        }
    }

    public static String J(String str) {
        if (str == null || str.length() == 0) {
            return str;
        }
        if (str.length() > 1 && Character.isUpperCase(str.charAt(1)) && Character.isUpperCase(str.charAt(0))) {
            return str;
        }
        char[] charArray = str.toCharArray();
        charArray[0] = Character.toLowerCase(charArray[0]);
        return new String(charArray);
    }

    public static long K(String str) {
        long jCharAt = -3750763034362895579L;
        for (int i7 = 0; i7 < str.length(); i7++) {
            jCharAt = (jCharAt ^ ((long) str.charAt(i7))) * 1099511628211L;
        }
        return jCharAt;
    }

    public static long L(String str) {
        long j7 = -3750763034362895579L;
        for (int i7 = 0; i7 < str.length(); i7++) {
            char cCharAt = str.charAt(i7);
            if (cCharAt != '_' && cCharAt != '-') {
                if (cCharAt >= 'A' && cCharAt <= 'Z') {
                    cCharAt = (char) (cCharAt + ' ');
                }
                j7 = (j7 ^ ((long) cCharAt)) * 1099511628211L;
            }
        }
        return j7;
    }

    public static <A extends Annotation> A M(Class<?> cls, Class<A> cls2) {
        A a8 = (A) cls.getAnnotation(cls2);
        if (a8 != null) {
            return a8;
        }
        if (cls.getAnnotations().length <= 0) {
            return null;
        }
        for (Annotation annotation : cls.getAnnotations()) {
            A a9 = (A) annotation.annotationType().getAnnotation(cls2);
            if (a9 != null) {
                return a9;
            }
        }
        return null;
    }

    public static Class<?> N(Type type) {
        if (type.getClass() == Class.class) {
            return (Class) type;
        }
        if (type instanceof ParameterizedType) {
            return N(((ParameterizedType) type).getRawType());
        }
        if (type instanceof TypeVariable) {
            return (Class) ((TypeVariable) type).getBounds()[0];
        }
        if (!(type instanceof WildcardType)) {
            return Object.class;
        }
        Type[] upperBounds = ((WildcardType) type).getUpperBounds();
        return upperBounds.length == 1 ? N(upperBounds[0]) : Object.class;
    }

    public static Class<?> O(String str) {
        return B.get(str);
    }

    public static Class<?> P(Type type) {
        if (!(type instanceof ParameterizedType)) {
            return Object.class;
        }
        Type type2 = ((ParameterizedType) type).getActualTypeArguments()[0];
        if (type2 instanceof WildcardType) {
            Type[] upperBounds = ((WildcardType) type2).getUpperBounds();
            if (upperBounds.length == 1) {
                type2 = upperBounds[0];
            }
        }
        if (!(type2 instanceof Class)) {
            throw new com.alibaba.fastjson.d("can not create ASMParser");
        }
        Class<?> cls = (Class) type2;
        if (Modifier.isPublic(cls.getModifiers())) {
            return cls;
        }
        throw new com.alibaba.fastjson.d("can not create ASMParser");
    }

    /* JADX WARN: Code duplicated, block: B:14:0x003a  */
    public static Type Q(Type type) {
        Type typeQ;
        if (type instanceof ParameterizedType) {
            typeQ = ((ParameterizedType) type).getActualTypeArguments()[0];
            if (typeQ instanceof WildcardType) {
                Type[] upperBounds = ((WildcardType) typeQ).getUpperBounds();
                if (upperBounds.length == 1) {
                    typeQ = upperBounds[0];
                }
            }
        } else if (type instanceof Class) {
            Class cls = (Class) type;
            if (cls.getName().startsWith("java.")) {
                typeQ = null;
            } else {
                typeQ = Q(cls.getGenericSuperclass());
            }
        } else {
            typeQ = null;
        }
        return typeQ == null ? Object.class : typeQ;
    }

    public static Field R(Class<?> cls, String str, Field[] fieldArr) {
        char cCharAt;
        char cCharAt2;
        for (Field field : fieldArr) {
            String name = field.getName();
            if (str.equals(name)) {
                return field;
            }
            if (str.length() > 2 && (cCharAt = str.charAt(0)) >= 'a' && cCharAt <= 'z' && (cCharAt2 = str.charAt(1)) >= 'A' && cCharAt2 <= 'Z' && str.equalsIgnoreCase(name)) {
                return field;
            }
        }
        Class<? super Object> superclass = cls.getSuperclass();
        if (superclass == null || superclass == Object.class) {
            return null;
        }
        return R(superclass, str, superclass.getDeclaredFields());
    }

    private static List<e> S(Class<?> cls, boolean z7, Map<String, e> map) {
        ArrayList arrayList = new ArrayList();
        e0.d dVar = (e0.d) M(cls, e0.d.class);
        String[] strArrOrders = dVar != null ? dVar.orders() : null;
        if (strArrOrders == null || strArrOrders.length <= 0) {
            Iterator<e> it = map.values().iterator();
            while (it.hasNext()) {
                arrayList.add(it.next());
            }
            if (z7) {
                Collections.sort(arrayList);
            }
        } else {
            LinkedHashMap linkedHashMap = new LinkedHashMap(arrayList.size());
            for (e eVar : map.values()) {
                linkedHashMap.put(eVar.f13293a, eVar);
            }
            for (String str : strArrOrders) {
                e eVar2 = (e) linkedHashMap.get(str);
                if (eVar2 != null) {
                    arrayList.add(eVar2);
                    linkedHashMap.remove(str);
                }
            }
            Iterator it2 = linkedHashMap.values().iterator();
            while (it2.hasNext()) {
                arrayList.add((e) it2.next());
            }
        }
        return arrayList;
    }

    public static Type T(Type type) {
        return (!(type instanceof ParameterizedType) && (type instanceof Class)) ? T(((Class) type).getGenericSuperclass()) : type;
    }

    public static Constructor U(Constructor[] constructorArr) {
        Constructor constructor = null;
        for (Constructor constructor2 : constructorArr) {
            Class<?>[] parameterTypes = constructor2.getParameterTypes();
            if ((parameterTypes.length <= 0 || !parameterTypes[parameterTypes.length - 1].getName().equals("kotlin.jvm.internal.w")) && (constructor == null || constructor.getParameterTypes().length < parameterTypes.length)) {
                constructor = constructor2;
            }
        }
        return constructor;
    }

    public static String[] V(Class cls) {
        if (f13394u == null && !f13393t) {
            try {
                f13394u = Class.forName("kotlin.reflect.jvm.internal.KClassImpl").getConstructor(Class.class);
            } catch (Throwable unused) {
                f13393t = true;
            }
        }
        if (f13394u == null) {
            return null;
        }
        if (f13395v == null && !f13393t) {
            try {
                f13395v = Class.forName("kotlin.reflect.jvm.internal.KClassImpl").getMethod("getConstructors", new Class[0]);
            } catch (Throwable unused2) {
                f13393t = true;
            }
        }
        if (f13396w == null && !f13393t) {
            try {
                f13396w = kotlin.reflect.i.class.getMethod("getParameters", new Class[0]);
            } catch (Throwable unused3) {
                f13393t = true;
            }
        }
        if (f13397x == null && !f13393t) {
            try {
                f13397x = n.class.getMethod("getName", new Class[0]);
            } catch (Throwable unused4) {
                f13393t = true;
            }
        }
        if (f13398y) {
            return null;
        }
        try {
            Iterator it = ((Iterable) f13395v.invoke(f13394u.newInstance(cls), new Object[0])).iterator();
            Object obj = null;
            while (it.hasNext()) {
                Object next = it.next();
                List list = (List) f13396w.invoke(next, new Object[0]);
                if (obj == null || list.size() != 0) {
                    obj = next;
                }
                it.hasNext();
            }
            List list2 = (List) f13396w.invoke(obj, new Object[0]);
            String[] strArr = new String[list2.size()];
            for (int i7 = 0; i7 < list2.size(); i7++) {
                strArr[i7] = (String) f13397x.invoke(list2.get(i7), new Object[0]);
            }
            return strArr;
        } catch (Throwable th) {
            th.printStackTrace();
            f13398y = true;
            return null;
        }
    }

    public static int W(Class<?> cls) {
        e0.d dVar = (e0.d) M(cls, e0.d.class);
        if (dVar == null) {
            return 0;
        }
        return com.alibaba.fastjson.parser.c.d(dVar.parseFeatures());
    }

    private static String X(Map<String, Field> map, String str, String str2, int i7) {
        if (!f13375b || map.containsKey(str2)) {
            return str2;
        }
        String strSubstring = str.substring(i7);
        return map.containsKey(strSubstring) ? strSubstring : str2;
    }

    public static Class<?> Y(Type type) {
        if (type instanceof Class) {
            return (Class) type;
        }
        if (type instanceof ParameterizedType) {
            return Y(((ParameterizedType) type).getRawType());
        }
        throw new com.alibaba.fastjson.d("TODO");
    }

    public static int Z(Class<?> cls) {
        e0.d dVar = (e0.d) M(cls, e0.d.class);
        if (dVar == null) {
            return 0;
        }
        return k1.e(dVar.serialzeFeatures());
    }

    private static void a() {
        B.put("byte", Byte.TYPE);
        B.put("short", Short.TYPE);
        B.put("int", Integer.TYPE);
        B.put("long", Long.TYPE);
        B.put(w.b.f3028c, Float.TYPE);
        B.put("double", Double.TYPE);
        B.put(w.b.f3031f, Boolean.TYPE);
        B.put("char", Character.TYPE);
        B.put("[byte", byte[].class);
        B.put("[short", short[].class);
        B.put("[int", int[].class);
        B.put("[long", long[].class);
        B.put("[float", float[].class);
        B.put("[double", double[].class);
        B.put("[boolean", boolean[].class);
        B.put("[char", char[].class);
        B.put("[B", byte[].class);
        B.put("[S", short[].class);
        B.put("[I", int[].class);
        B.put("[J", long[].class);
        B.put("[F", float[].class);
        B.put("[D", double[].class);
        B.put("[C", char[].class);
        B.put("[Z", boolean[].class);
        Class<?>[] clsArr = {Object.class, Cloneable.class, m0("java.lang.AutoCloseable"), Exception.class, RuntimeException.class, IllegalAccessError.class, IllegalAccessException.class, IllegalArgumentException.class, IllegalMonitorStateException.class, IllegalStateException.class, IllegalThreadStateException.class, IndexOutOfBoundsException.class, InstantiationError.class, InstantiationException.class, InternalError.class, InterruptedException.class, LinkageError.class, NegativeArraySizeException.class, NoClassDefFoundError.class, NoSuchFieldError.class, NoSuchFieldException.class, NoSuchMethodError.class, NoSuchMethodException.class, NullPointerException.class, NumberFormatException.class, OutOfMemoryError.class, SecurityException.class, StackOverflowError.class, StringIndexOutOfBoundsException.class, TypeNotPresentException.class, VerifyError.class, StackTraceElement.class, HashMap.class, Hashtable.class, TreeMap.class, IdentityHashMap.class, WeakHashMap.class, LinkedHashMap.class, HashSet.class, LinkedHashSet.class, TreeSet.class, TimeUnit.class, ConcurrentHashMap.class, m0("java.util.concurrent.ConcurrentSkipListMap"), m0("java.util.concurrent.ConcurrentSkipListSet"), AtomicInteger.class, AtomicLong.class, Collections.EMPTY_MAP.getClass(), BitSet.class, Calendar.class, Date.class, Locale.class, UUID.class, Time.class, java.sql.Date.class, Timestamp.class, SimpleDateFormat.class, com.alibaba.fastjson.e.class};
        for (int i7 = 0; i7 < 58; i7++) {
            Class<?> cls = clsArr[i7];
            if (cls != null) {
                B.put(cls.getName(), cls);
            }
        }
        String[] strArr = {"java.awt.Rectangle", "java.awt.Point", "java.awt.Font", "java.awt.Color"};
        for (int i8 = 0; i8 < 4; i8++) {
            Class<?> clsM0 = m0(strArr[i8]);
            if (clsM0 == null) {
                break;
            }
            B.put(clsM0.getName(), clsM0);
        }
        String[] strArr2 = {"org.springframework.util.LinkedMultiValueMap", "org.springframework.util.LinkedCaseInsensitiveMap", "org.springframework.remoting.support.RemoteInvocation", "org.springframework.remoting.support.RemoteInvocationResult", "org.springframework.security.web.savedrequest.DefaultSavedRequest", "org.springframework.security.web.savedrequest.SavedCookie", "org.springframework.security.web.csrf.DefaultCsrfToken", "org.springframework.security.web.authentication.WebAuthenticationDetails", "org.springframework.security.core.context.SecurityContextImpl", "org.springframework.security.authentication.UsernamePasswordAuthenticationToken", "org.springframework.security.core.authority.SimpleGrantedAuthority", "org.springframework.security.core.userdetails.User"};
        for (int i9 = 0; i9 < 12; i9++) {
            Class<?> clsM1 = m0(strArr2[i9]);
            if (clsM1 == null) {
                return;
            }
            B.put(clsM1.getName(), clsM1);
        }
    }

    public static e0.b a0(Class<?> cls, Method method) {
        boolean z7;
        e0.b bVar;
        boolean z8;
        e0.b bVar2;
        Class<?>[] interfaces = cls.getInterfaces();
        if (interfaces.length > 0) {
            Class<?>[] parameterTypes = method.getParameterTypes();
            for (Class<?> cls2 : interfaces) {
                for (Method method2 : cls2.getMethods()) {
                    Class<?>[] parameterTypes2 = method2.getParameterTypes();
                    if (parameterTypes2.length == parameterTypes.length && method2.getName().equals(method.getName())) {
                        int i7 = 0;
                        while (true) {
                            if (i7 >= parameterTypes.length) {
                                z8 = true;
                                break;
                            }
                            if (!parameterTypes2[i7].equals(parameterTypes[i7])) {
                                z8 = false;
                                break;
                            }
                            i7++;
                        }
                        if (z8 && (bVar2 = (e0.b) method2.getAnnotation(e0.b.class)) != null) {
                            return bVar2;
                        }
                    }
                }
            }
        }
        Class<? super Object> superclass = cls.getSuperclass();
        if (superclass != null && Modifier.isAbstract(superclass.getModifiers())) {
            Class<?>[] parameterTypes3 = method.getParameterTypes();
            for (Method method3 : superclass.getMethods()) {
                Class<?>[] parameterTypes4 = method3.getParameterTypes();
                if (parameterTypes4.length == parameterTypes3.length && method3.getName().equals(method.getName())) {
                    int i8 = 0;
                    while (true) {
                        if (i8 >= parameterTypes3.length) {
                            z7 = true;
                            break;
                        }
                        if (!parameterTypes4[i8].equals(parameterTypes3[i8])) {
                            z7 = false;
                            break;
                        }
                        i8++;
                    }
                    if (z7 && (bVar = (e0.b) method3.getAnnotation(e0.b.class)) != null) {
                        return bVar;
                    }
                }
            }
        }
        return null;
    }

    public static void b(String str, Class<?> cls) {
        B.put(str, cls);
    }

    public static boolean b0(Method method) {
        if (method == null) {
            return false;
        }
        if (f13387n == null && !f13388o) {
            try {
                f13387n = Class.forName("javax.persistence.ManyToMany");
            } catch (Throwable unused) {
                f13388o = true;
            }
        }
        if (f13387n != null) {
            return method.isAnnotationPresent(f13385l) || method.isAnnotationPresent(f13387n);
        }
        return false;
    }

    public static f1 c(Class<?> cls, Map<String, String> map, com.alibaba.fastjson.m mVar) {
        return d(cls, map, mVar, false);
    }

    public static boolean c0(Method method) {
        if (method == null) {
            return false;
        }
        if (f13385l == null && !f13386m) {
            try {
                f13385l = Class.forName("javax.persistence.OneToMany");
            } catch (Throwable unused) {
                f13386m = true;
            }
        }
        Class<? extends Annotation> cls = f13385l;
        return cls != null && method.isAnnotationPresent(cls);
    }

    public static f1 d(Class<?> cls, Map<String, String> map, com.alibaba.fastjson.m mVar, boolean z7) {
        com.alibaba.fastjson.m mVar2;
        int i7;
        String[] strArr;
        String str;
        String str2;
        List<e> listH;
        e0.d dVar = (e0.d) M(cls, e0.d.class);
        if (dVar != null) {
            String[] strArrOrders = dVar.orders();
            String strTypeName = dVar.typeName();
            if (strTypeName.length() == 0) {
                strTypeName = null;
            }
            com.alibaba.fastjson.m mVarNaming = dVar.naming();
            if (mVarNaming == com.alibaba.fastjson.m.CamelCase) {
                mVarNaming = mVar;
            }
            int iE = k1.e(dVar.serialzeFeatures());
            String strTypeKey = null;
            for (Class<? super Object> superclass = cls.getSuperclass(); superclass != null && superclass != Object.class; superclass = superclass.getSuperclass()) {
                e0.d dVar2 = (e0.d) M(superclass, e0.d.class);
                if (dVar2 == null) {
                    break;
                }
                strTypeKey = dVar2.typeKey();
                if (strTypeKey.length() != 0) {
                    break;
                }
            }
            for (Class<?> cls2 : cls.getInterfaces()) {
                e0.d dVar3 = (e0.d) M(cls2, e0.d.class);
                if (dVar3 != null) {
                    strTypeKey = dVar3.typeKey();
                    if (strTypeKey.length() != 0) {
                        break;
                    }
                }
            }
            str2 = (strTypeKey == null || strTypeKey.length() != 0) ? strTypeKey : null;
            str = strTypeName;
            mVar2 = mVarNaming;
            i7 = iE;
            strArr = strArrOrders;
        } else {
            mVar2 = mVar;
            i7 = 0;
            strArr = null;
            str = null;
            str2 = null;
        }
        HashMap map2 = new HashMap();
        com.alibaba.fastjson.parser.j.x(cls, map2);
        List<e> listH2 = z7 ? H(cls, map, false, mVar2) : E(cls, dVar, map, map2, false, mVar2);
        e[] eVarArr = new e[listH2.size()];
        listH2.toArray(eVarArr);
        if (strArr == null || strArr.length == 0) {
            ArrayList arrayList = new ArrayList(listH2);
            Collections.sort(arrayList);
            listH = arrayList;
        } else {
            listH = z7 ? H(cls, map, true, mVar2) : E(cls, dVar, map, map2, true, mVar2);
        }
        e[] eVarArr2 = new e[listH.size()];
        listH.toArray(eVarArr2);
        return new f1(cls, dVar, str, str2, i7, eVarArr, Arrays.equals(eVarArr2, eVarArr) ? eVarArr : eVarArr2);
    }

    public static boolean d0(Type type) {
        if (type instanceof ParameterizedType) {
            return true;
        }
        if (!(type instanceof Class)) {
            return false;
        }
        Type genericSuperclass = ((Class) type).getGenericSuperclass();
        return genericSuperclass != Object.class && d0(genericSuperclass);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> T e(Object obj, Class<T> cls, com.alibaba.fastjson.parser.j jVar) {
        Object obj2;
        int i7 = 0;
        if (obj == 0) {
            if (cls == Integer.TYPE) {
                return (T) 0;
            }
            if (cls == Long.TYPE) {
                return (T) 0L;
            }
            if (cls == Short.TYPE) {
                return (T) (short) 0;
            }
            if (cls == Byte.TYPE) {
                return (T) (byte) 0;
            }
            if (cls == Float.TYPE) {
                return (T) Float.valueOf(0.0f);
            }
            if (cls == Double.TYPE) {
                return (T) Double.valueOf(0.0d);
            }
            if (cls == Boolean.TYPE) {
                return (T) Boolean.FALSE;
            }
            return null;
        }
        if (cls == null) {
            throw new IllegalArgumentException("clazz is null");
        }
        if (cls == obj.getClass()) {
            return obj;
        }
        if (obj instanceof Map) {
            if (cls == Map.class) {
                return obj;
            }
            Map map = (Map) obj;
            return (cls != Object.class || map.containsKey(com.alibaba.fastjson.a.f12529c)) ? (T) u(map, cls, jVar) : obj;
        }
        if (cls.isArray()) {
            if (obj instanceof Collection) {
                Collection collection = (Collection) obj;
                T t7 = (T) Array.newInstance(cls.getComponentType(), collection.size());
                Iterator it = collection.iterator();
                while (it.hasNext()) {
                    Array.set(t7, i7, e(it.next(), cls.getComponentType(), jVar));
                    i7++;
                }
                return t7;
            }
            if (cls == byte[].class) {
                return (T) l(obj);
            }
        }
        if (cls.isAssignableFrom(obj.getClass())) {
            return obj;
        }
        if (cls == Boolean.TYPE || cls == Boolean.class) {
            return (T) j(obj);
        }
        if (cls == Byte.TYPE || cls == Byte.class) {
            return (T) k(obj);
        }
        if (cls == Character.TYPE || cls == Character.class) {
            return (T) m(obj);
        }
        if (cls == Short.TYPE || cls == Short.class) {
            return (T) w(obj);
        }
        if (cls == Integer.TYPE || cls == Integer.class) {
            return (T) s(obj);
        }
        if (cls == Long.TYPE || cls == Long.class) {
            return (T) v(obj);
        }
        if (cls == Float.TYPE || cls == Float.class) {
            return (T) r(obj);
        }
        if (cls == Double.TYPE || cls == Double.class) {
            return (T) p(obj);
        }
        if (cls == String.class) {
            return (T) z(obj);
        }
        if (cls == BigDecimal.class) {
            return (T) h(obj);
        }
        if (cls == BigInteger.class) {
            return (T) i(obj);
        }
        if (cls == Date.class) {
            return (T) n(obj);
        }
        if (cls == java.sql.Date.class) {
            return (T) x(obj);
        }
        if (cls == Time.class) {
            return (T) y(obj);
        }
        if (cls == Timestamp.class) {
            return (T) A(obj);
        }
        if (cls.isEnum()) {
            return (T) q(obj, cls, jVar);
        }
        if (Calendar.class.isAssignableFrom(cls)) {
            Date dateN = n(obj);
            if (cls == Calendar.class) {
                obj2 = (T) Calendar.getInstance(com.alibaba.fastjson.a.f12527a, com.alibaba.fastjson.a.f12528b);
            } else {
                try {
                    obj2 = (T) ((Calendar) cls.newInstance());
                } catch (Exception e8) {
                    throw new com.alibaba.fastjson.d("can not cast to : " + cls.getName(), e8);
                }
            }
            ((Calendar) obj2).setTime(dateN);
            return (T) obj2;
        }
        String name = cls.getName();
        if (name.equals("javax.xml.datatype.XMLGregorianCalendar")) {
            Date dateN2 = n(obj);
            Calendar calendar = Calendar.getInstance(com.alibaba.fastjson.a.f12527a, com.alibaba.fastjson.a.f12528b);
            calendar.setTime(dateN2);
            return (T) u.f13173b.f(calendar);
        }
        if (obj instanceof String) {
            String str = (String) obj;
            if (str.length() == 0 || "null".equals(str) || "NULL".equals(str)) {
                return null;
            }
            if (cls == Currency.class) {
                return (T) Currency.getInstance(str);
            }
            if (cls == Locale.class) {
                return (T) q0(str);
            }
            if (name.startsWith("java.time.")) {
                return (T) com.alibaba.fastjson.a.N(com.alibaba.fastjson.a.y0(str), cls);
            }
        }
        throw new com.alibaba.fastjson.d("can not cast to : " + cls.getName());
    }

    public static boolean e0(Object obj) {
        if (obj == null) {
            return false;
        }
        if (f13389p == null && !f13390q) {
            try {
                f13389p = Class.forName("org.hibernate.Hibernate").getMethod("isInitialized", Object.class);
            } catch (Throwable unused) {
                f13390q = true;
            }
        }
        Method method = f13389p;
        if (method != null) {
            try {
                return ((Boolean) method.invoke(null, obj)).booleanValue();
            } catch (Throwable unused2) {
            }
        }
        return true;
    }

    /* JADX WARN: Type inference failed for: r8v5, types: [T, java.util.HashMap, java.util.Map] */
    public static <T> T f(Object obj, ParameterizedType parameterizedType, com.alibaba.fastjson.parser.j jVar) {
        Type rawType = parameterizedType.getRawType();
        if (rawType == Set.class || rawType == HashSet.class || rawType == TreeSet.class || rawType == Collection.class || rawType == List.class || rawType == ArrayList.class) {
            Type type = parameterizedType.getActualTypeArguments()[0];
            if (obj instanceof Iterable) {
                T t7 = (rawType == Set.class || rawType == HashSet.class) ? (T) new HashSet() : rawType == TreeSet.class ? (T) new TreeSet() : (T) new ArrayList();
                Iterator<T> it = ((Iterable) obj).iterator();
                while (it.hasNext()) {
                    ((Collection) t7).add(g(it.next(), type, jVar));
                }
                return t7;
            }
        }
        if (rawType == Map.class || rawType == HashMap.class) {
            Type type2 = parameterizedType.getActualTypeArguments()[0];
            Type type3 = parameterizedType.getActualTypeArguments()[1];
            if (obj instanceof Map) {
                ?? r8 = (T) new HashMap();
                for (Map.Entry entry : ((Map) obj).entrySet()) {
                    r8.put(g(entry.getKey(), type2, jVar), g(entry.getValue(), type3, jVar));
                }
                return r8;
            }
        }
        if ((obj instanceof String) && ((String) obj).length() == 0) {
            return null;
        }
        if (parameterizedType.getActualTypeArguments().length == 1 && (parameterizedType.getActualTypeArguments()[0] instanceof WildcardType)) {
            return (T) g(obj, rawType, jVar);
        }
        if (rawType == Map.Entry.class && (obj instanceof Map)) {
            Map map = (Map) obj;
            if (map.size() == 1) {
                return (T) ((Map.Entry) map.entrySet().iterator().next());
            }
        }
        if (rawType instanceof Class) {
            if (jVar == null) {
                jVar = com.alibaba.fastjson.parser.j.f12976r;
            }
            e1 e1VarN = jVar.n(rawType);
            if (e1VarN != null) {
                return (T) e1VarN.b(new com.alibaba.fastjson.parser.b(com.alibaba.fastjson.a.y0(obj), jVar), parameterizedType, null);
            }
        }
        throw new com.alibaba.fastjson.d("can not cast to : " + parameterizedType);
    }

    private static boolean f0(Class<?> cls, String str) {
        e0.d dVar = (e0.d) M(cls, e0.d.class);
        if (dVar != null) {
            String[] strArrIncludes = dVar.includes();
            if (strArrIncludes.length > 0) {
                for (String str2 : strArrIncludes) {
                    if (str.equals(str2)) {
                        return false;
                    }
                }
                return true;
            }
            for (String str3 : dVar.ignores()) {
                if (str.equals(str3)) {
                    return true;
                }
            }
        }
        return (cls.getSuperclass() == Object.class || cls.getSuperclass() == null || !f0(cls.getSuperclass(), str)) ? false : true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> T g(Object obj, Type type, com.alibaba.fastjson.parser.j jVar) {
        if (obj == 0) {
            return null;
        }
        if (type instanceof Class) {
            return (T) e(obj, (Class) type, jVar);
        }
        if (type instanceof ParameterizedType) {
            return (T) f(obj, (ParameterizedType) type, jVar);
        }
        if (obj instanceof String) {
            String str = (String) obj;
            if (str.length() == 0 || "null".equals(str) || "NULL".equals(str)) {
                return null;
            }
        }
        if (type instanceof TypeVariable) {
            return obj;
        }
        throw new com.alibaba.fastjson.d("can not cast to : " + type);
    }

    public static boolean g0(Class cls) {
        if (f13391r == null && !f13392s) {
            try {
                f13391r = i0.class;
            } catch (Throwable unused) {
                f13392s = true;
            }
        }
        return f13391r != null && cls.isAnnotationPresent(f13391r);
    }

    public static BigDecimal h(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof BigDecimal) {
            return (BigDecimal) obj;
        }
        if (obj instanceof BigInteger) {
            return new BigDecimal((BigInteger) obj);
        }
        String string = obj.toString();
        if (string.length() == 0) {
            return null;
        }
        if ((obj instanceof Map) && ((Map) obj).size() == 0) {
            return null;
        }
        return new BigDecimal(string);
    }

    private static boolean h0(Class cls, String str) {
        if (f13399z == null && !A) {
            try {
                HashMap map = new HashMap();
                map.put(Class.forName("kotlin.ranges.c"), new String[]{"getEndInclusive", "isEmpty"});
                map.put(Class.forName("kotlin.ranges.k"), new String[]{"getEndInclusive", "isEmpty"});
                map.put(Class.forName("kotlin.ranges.n"), new String[]{"getEndInclusive", "isEmpty"});
                map.put(Class.forName("kotlin.ranges.e"), new String[]{"getEndInclusive", "isEmpty"});
                map.put(Class.forName("kotlin.ranges.d"), new String[]{"getEndInclusive", "isEmpty"});
                f13399z = map;
            } catch (Throwable unused) {
                A = true;
            }
        }
        if (f13399z == null) {
            return false;
        }
        String[] strArr = f13399z.get(cls);
        return strArr != null && Arrays.binarySearch(strArr, str) >= 0;
    }

    public static BigInteger i(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof BigInteger) {
            return (BigInteger) obj;
        }
        if ((obj instanceof Float) || (obj instanceof Double)) {
            return BigInteger.valueOf(((Number) obj).longValue());
        }
        String string = obj.toString();
        if (string.length() == 0 || "null".equals(string) || "NULL".equals(string)) {
            return null;
        }
        return new BigInteger(string);
    }

    public static boolean i0(String str) {
        for (int i7 = 0; i7 < str.length(); i7++) {
            char cCharAt = str.charAt(i7);
            if (cCharAt == '+' || cCharAt == '-') {
                if (i7 != 0) {
                    return false;
                }
            } else if (cCharAt < '0' || cCharAt > '9') {
                return false;
            }
        }
        return true;
    }

    public static Boolean j(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Boolean) {
            return (Boolean) obj;
        }
        if (obj instanceof Number) {
            return Boolean.valueOf(((Number) obj).intValue() == 1);
        }
        if (obj instanceof String) {
            String str = (String) obj;
            if (str.length() == 0 || "null".equals(str) || "NULL".equals(str)) {
                return null;
            }
            if ("true".equalsIgnoreCase(str) || "1".equals(str)) {
                return Boolean.TRUE;
            }
            if (com.paytm.pgsdk.d.G.equalsIgnoreCase(str) || "0".equals(str)) {
                return Boolean.FALSE;
            }
            if ("Y".equalsIgnoreCase(str) || "T".equals(str)) {
                return Boolean.TRUE;
            }
            if ("F".equalsIgnoreCase(str) || "N".equals(str)) {
                return Boolean.FALSE;
            }
        }
        throw new com.alibaba.fastjson.d("can not cast to boolean, value : " + obj);
    }

    public static boolean j0(Class<?> cls) {
        if (C == null && !D) {
            try {
                C = Class.forName("java.nio.file.Path");
            } catch (Throwable unused) {
                D = true;
            }
        }
        Class<?> cls2 = C;
        if (cls2 != null) {
            return cls2.isAssignableFrom(cls);
        }
        return false;
    }

    public static Byte k(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Number) {
            return Byte.valueOf(((Number) obj).byteValue());
        }
        if (!(obj instanceof String)) {
            throw new com.alibaba.fastjson.d("can not cast to byte, value : " + obj);
        }
        String str = (String) obj;
        if (str.length() == 0 || "null".equals(str) || "NULL".equals(str)) {
            return null;
        }
        return Byte.valueOf(Byte.parseByte(str));
    }

    public static boolean k0(Class<?> cls) {
        for (Class<?> cls2 : cls.getInterfaces()) {
            String name = cls2.getName();
            if (name.equals("net.sf.cglib.proxy.Factory") || name.equals("org.springframework.cglib.proxy.Factory") || name.equals("javassist.util.proxy.ProxyObject") || name.equals("org.apache.ibatis.javassist.util.proxy.ProxyObject")) {
                return true;
            }
        }
        return false;
    }

    public static byte[] l(Object obj) {
        if (obj instanceof byte[]) {
            return (byte[]) obj;
        }
        if (obj instanceof String) {
            return f.c((String) obj);
        }
        throw new com.alibaba.fastjson.d("can not cast to int, value : " + obj);
    }

    public static boolean l0(Method method) {
        if (method == null) {
            return false;
        }
        if (!f13383j) {
            try {
                f13384k = Class.forName("java.beans.Transient");
            } catch (Exception unused) {
            } finally {
                f13383j = true;
            }
        }
        Class<? extends Annotation> cls = f13384k;
        return (cls == null || method.getAnnotation(cls) == null) ? false : true;
    }

    public static Character m(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Character) {
            return (Character) obj;
        }
        if (!(obj instanceof String)) {
            throw new com.alibaba.fastjson.d("can not cast to char, value : " + obj);
        }
        String str = (String) obj;
        if (str.length() == 0) {
            return null;
        }
        if (str.length() == 1) {
            return Character.valueOf(str.charAt(0));
        }
        throw new com.alibaba.fastjson.d("can not cast to char, value : " + obj);
    }

    public static Class<?> m0(String str) {
        return n0(str, null);
    }

    public static Date n(Object obj) {
        return o(obj, null);
    }

    public static Class<?> n0(String str, ClassLoader classLoader) {
        return o0(str, classLoader, false);
    }

    public static Date o(Object obj, String str) {
        long j7;
        if (obj == null) {
            return null;
        }
        if (obj instanceof Date) {
            return (Date) obj;
        }
        if (obj instanceof Calendar) {
            return ((Calendar) obj).getTime();
        }
        if (obj instanceof Number) {
            return new Date(((Number) obj).longValue());
        }
        if (obj instanceof String) {
            String strSubstring = (String) obj;
            com.alibaba.fastjson.parser.g gVar = new com.alibaba.fastjson.parser.g(strSubstring);
            try {
                if (gVar.T2(false)) {
                    Date time = gVar.X1().getTime();
                    gVar.close();
                    return time;
                }
                gVar.close();
                if (strSubstring.startsWith("/Date(") && strSubstring.endsWith(")/")) {
                    strSubstring = strSubstring.substring(6, strSubstring.length() - 2);
                }
                if (strSubstring.indexOf(45) != -1) {
                    if (str == null) {
                        if (strSubstring.length() == com.alibaba.fastjson.a.f12531e.length() || (strSubstring.length() == 22 && com.alibaba.fastjson.a.f12531e.equals("yyyyMMddHHmmssSSSZ"))) {
                            str = com.alibaba.fastjson.a.f12531e;
                        } else if (strSubstring.length() == 10) {
                            str = "yyyy-MM-dd";
                        } else if (strSubstring.length() == 19) {
                            str = com.haier.library.json.a.f26647d;
                        } else {
                            str = (strSubstring.length() == 29 && strSubstring.charAt(26) == ':' && strSubstring.charAt(28) == '0') ? "yyyy-MM-dd'T'HH:mm:ss.SSSXXX" : "yyyy-MM-dd HH:mm:ss.SSS";
                        }
                    }
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str, com.alibaba.fastjson.a.f12528b);
                    simpleDateFormat.setTimeZone(com.alibaba.fastjson.a.f12527a);
                    try {
                        return simpleDateFormat.parse(strSubstring);
                    } catch (ParseException unused) {
                        throw new com.alibaba.fastjson.d("can not cast to Date, value : " + strSubstring);
                    }
                }
                if (strSubstring.length() == 0) {
                    return null;
                }
                j7 = Long.parseLong(strSubstring);
            } catch (Throwable th) {
                gVar.close();
                throw th;
            }
        } else {
            j7 = -1;
        }
        if (j7 >= 0) {
            return new Date(j7);
        }
        Class<?> cls = obj.getClass();
        if ("oracle.sql.TIMESTAMP".equals(cls.getName())) {
            if (f13378e == null && !f13377d) {
                try {
                    f13378e = cls.getMethod("toJdbc", new Class[0]);
                } catch (NoSuchMethodException unused2) {
                } finally {
                    f13377d = true;
                }
            }
            try {
                return (Date) f13378e.invoke(obj, new Object[0]);
            } catch (Exception e8) {
                throw new com.alibaba.fastjson.d("can not cast oracle.sql.TIMESTAMP to Date", e8);
            }
        }
        if (!"oracle.sql.DATE".equals(cls.getName())) {
            throw new com.alibaba.fastjson.d("can not cast to Date, value : " + obj);
        }
        if (f13380g == null && !f13379f) {
            try {
                f13380g = cls.getMethod("toJdbc", new Class[0]);
            } catch (NoSuchMethodException unused3) {
            } finally {
                f13379f = true;
            }
        }
        try {
            return (Date) f13380g.invoke(obj, new Object[0]);
        } catch (Exception e9) {
            throw new com.alibaba.fastjson.d("can not cast oracle.sql.DATE to Date", e9);
        }
    }

    public static Class<?> o0(String str, ClassLoader classLoader, boolean z7) {
        if (str == null || str.length() == 0 || str.length() > 128) {
            return null;
        }
        Class<?> clsLoadClass = B.get(str);
        if (clsLoadClass != null) {
            return clsLoadClass;
        }
        if (str.charAt(0) == '[') {
            return Array.newInstance(n0(str.substring(1), classLoader), 0).getClass();
        }
        if (str.startsWith("L") && str.endsWith(com.alipay.sdk.util.j.f13806b)) {
            return n0(str.substring(1, str.length() - 1), classLoader);
        }
        if (classLoader != null) {
            try {
                clsLoadClass = classLoader.loadClass(str);
                if (z7) {
                    B.put(str, clsLoadClass);
                }
                return clsLoadClass;
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        if (contextClassLoader != null && contextClassLoader != classLoader) {
            Class<?> clsLoadClass2 = contextClassLoader.loadClass(str);
            if (z7) {
                try {
                    B.put(str, clsLoadClass2);
                } catch (Throwable unused) {
                    clsLoadClass = clsLoadClass2;
                }
            }
            return clsLoadClass2;
        }
        try {
            clsLoadClass = Class.forName(str);
            if (z7) {
                B.put(str, clsLoadClass);
            }
        } catch (Throwable unused2) {
        }
        return clsLoadClass;
    }

    public static Double p(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Number) {
            return Double.valueOf(((Number) obj).doubleValue());
        }
        if (!(obj instanceof String)) {
            throw new com.alibaba.fastjson.d("can not cast to double, value : " + obj);
        }
        String string = obj.toString();
        if (string.length() == 0 || "null".equals(string) || "NULL".equals(string)) {
            return null;
        }
        if (string.indexOf(44) != 0) {
            string = string.replaceAll(",", "");
        }
        return Double.valueOf(Double.parseDouble(string));
    }

    static void p0(AccessibleObject accessibleObject) {
        if (f13376c && !accessibleObject.isAccessible()) {
            try {
                accessibleObject.setAccessible(true);
            } catch (AccessControlException unused) {
                f13376c = false;
            }
        }
    }

    public static <T> T q(Object obj, Class<T> cls, com.alibaba.fastjson.parser.j jVar) {
        try {
            if (obj instanceof String) {
                String str = (String) obj;
                if (str.length() == 0) {
                    return null;
                }
                if (jVar == null) {
                    jVar = com.alibaba.fastjson.parser.j.q();
                }
                e1 e1VarN = jVar.n(cls);
                return e1VarN instanceof com.alibaba.fastjson.parser.deserializer.g ? (T) ((com.alibaba.fastjson.parser.deserializer.g) e1VarN).c(K(str)) : (T) Enum.valueOf(cls, str);
            }
            if (obj instanceof Number) {
                int iIntValue = ((Number) obj).intValue();
                T[] enumConstants = cls.getEnumConstants();
                if (iIntValue < enumConstants.length) {
                    return enumConstants[iIntValue];
                }
            }
            throw new com.alibaba.fastjson.d("can not cast to : " + cls.getName());
        } catch (Exception e8) {
            throw new com.alibaba.fastjson.d("can not cast to : " + cls.getName(), e8);
        }
    }

    public static Locale q0(String str) {
        String[] strArrSplit = str.split("_");
        if (strArrSplit.length == 1) {
            return new Locale(strArrSplit[0]);
        }
        return strArrSplit.length == 2 ? new Locale(strArrSplit[0], strArrSplit[1]) : new Locale(strArrSplit[0], strArrSplit[1], strArrSplit[2]);
    }

    public static Float r(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Number) {
            return Float.valueOf(((Number) obj).floatValue());
        }
        if (!(obj instanceof String)) {
            throw new com.alibaba.fastjson.d("can not cast to float, value : " + obj);
        }
        String string = obj.toString();
        if (string.length() == 0 || "null".equals(string) || "NULL".equals(string)) {
            return null;
        }
        if (string.indexOf(44) != 0) {
            string = string.replaceAll(",", "");
        }
        return Float.valueOf(Float.parseFloat(string));
    }

    public static Type r0(Type type) {
        if (!f13381h) {
            try {
                f13382i = Class.forName("java.util.Optional");
            } catch (Exception unused) {
            } finally {
                f13381h = true;
            }
        }
        if (!(type instanceof ParameterizedType)) {
            return type;
        }
        ParameterizedType parameterizedType = (ParameterizedType) type;
        return parameterizedType.getRawType() == f13382i ? parameterizedType.getActualTypeArguments()[0] : type;
    }

    public static Integer s(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Integer) {
            return (Integer) obj;
        }
        if (obj instanceof Number) {
            return Integer.valueOf(((Number) obj).intValue());
        }
        if (obj instanceof String) {
            String strReplaceAll = (String) obj;
            if (strReplaceAll.length() == 0 || "null".equals(strReplaceAll) || "NULL".equals(strReplaceAll)) {
                return null;
            }
            if (strReplaceAll.indexOf(44) != 0) {
                strReplaceAll = strReplaceAll.replaceAll(",", "");
            }
            return Integer.valueOf(Integer.parseInt(strReplaceAll));
        }
        if (obj instanceof Boolean) {
            return Integer.valueOf(((Boolean) obj).booleanValue() ? 1 : 0);
        }
        if (obj instanceof Map) {
            Map map = (Map) obj;
            if (map.size() == 2 && map.containsKey("andIncrement") && map.containsKey("andDecrement")) {
                Iterator it = map.values().iterator();
                it.next();
                return s(it.next());
            }
        }
        throw new com.alibaba.fastjson.d("can not cast to int, value : " + obj);
    }

    public static <T> T t(Object obj, Class<T> cls) {
        return (T) e(obj, cls, com.alibaba.fastjson.parser.j.q());
    }

    public static <T> T u(Map<String, Object> map, Class<T> cls, com.alibaba.fastjson.parser.j jVar) {
        int iIntValue = 0;
        try {
            if (cls == StackTraceElement.class) {
                String str = (String) map.get("className");
                String str2 = (String) map.get("methodName");
                String str3 = (String) map.get("fileName");
                Number number = (Number) map.get("lineNumber");
                if (number != null) {
                    iIntValue = number.intValue();
                }
                return (T) new StackTraceElement(str, str2, str3, iIntValue);
            }
            Object obj = map.get(com.alibaba.fastjson.a.f12529c);
            if (obj instanceof String) {
                String str4 = (String) obj;
                if (jVar == null) {
                    jVar = com.alibaba.fastjson.parser.j.f12976r;
                }
                Class<?> clsE = jVar.e(str4, null);
                if (clsE == null) {
                    throw new ClassNotFoundException(str4 + " not found");
                }
                if (!clsE.equals(cls)) {
                    return (T) u(map, clsE, jVar);
                }
            }
            if (cls.isInterface()) {
                com.alibaba.fastjson.e eVar = map instanceof com.alibaba.fastjson.e ? (com.alibaba.fastjson.e) map : new com.alibaba.fastjson.e(map);
                if (jVar == null) {
                    jVar = com.alibaba.fastjson.parser.j.q();
                }
                return jVar.o().c(cls) != null ? (T) com.alibaba.fastjson.a.N(com.alibaba.fastjson.a.y0(eVar), cls) : (T) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[]{cls}, eVar);
            }
            if (cls == Locale.class) {
                Object obj2 = map.get("language");
                Object obj3 = map.get("country");
                if (obj2 instanceof String) {
                    String str5 = (String) obj2;
                    if (obj3 instanceof String) {
                        return (T) new Locale(str5, (String) obj3);
                    }
                    if (obj3 == null) {
                        return (T) new Locale(str5);
                    }
                }
            }
            if (cls == String.class && (map instanceof com.alibaba.fastjson.e)) {
                return (T) map.toString();
            }
            if (cls == LinkedHashMap.class && (map instanceof com.alibaba.fastjson.e)) {
                T t7 = (T) ((com.alibaba.fastjson.e) map).l1();
                if (t7 instanceof LinkedHashMap) {
                    return t7;
                }
                new LinkedHashMap().putAll(t7);
            }
            if (jVar == null) {
                jVar = com.alibaba.fastjson.parser.j.q();
            }
            e1 e1VarN = jVar.n(cls);
            com.alibaba.fastjson.parser.deserializer.n nVar = e1VarN instanceof com.alibaba.fastjson.parser.deserializer.n ? (com.alibaba.fastjson.parser.deserializer.n) e1VarN : null;
            if (nVar != null) {
                return (T) nVar.f(map, jVar);
            }
            throw new com.alibaba.fastjson.d("can not get javaBeanDeserializer. " + cls.getName());
        } catch (Exception e8) {
            throw new com.alibaba.fastjson.d(e8.getMessage(), e8);
        }
    }

    public static Long v(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Number) {
            return Long.valueOf(((Number) obj).longValue());
        }
        if (obj instanceof String) {
            String strReplaceAll = (String) obj;
            if (strReplaceAll.length() == 0 || "null".equals(strReplaceAll) || "NULL".equals(strReplaceAll)) {
                return null;
            }
            if (strReplaceAll.indexOf(44) != 0) {
                strReplaceAll = strReplaceAll.replaceAll(",", "");
            }
            try {
                return Long.valueOf(Long.parseLong(strReplaceAll));
            } catch (NumberFormatException unused) {
                com.alibaba.fastjson.parser.g gVar = new com.alibaba.fastjson.parser.g(strReplaceAll);
                Calendar calendarX1 = gVar.T2(false) ? gVar.X1() : null;
                gVar.close();
                if (calendarX1 != null) {
                    return Long.valueOf(calendarX1.getTimeInMillis());
                }
            }
        }
        if (obj instanceof Map) {
            Map map = (Map) obj;
            if (map.size() == 2 && map.containsKey("andIncrement") && map.containsKey("andDecrement")) {
                Iterator it = map.values().iterator();
                it.next();
                return v(it.next());
            }
        }
        throw new com.alibaba.fastjson.d("can not cast to long, value : " + obj);
    }

    public static Short w(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Number) {
            return Short.valueOf(((Number) obj).shortValue());
        }
        if (!(obj instanceof String)) {
            throw new com.alibaba.fastjson.d("can not cast to short, value : " + obj);
        }
        String str = (String) obj;
        if (str.length() == 0 || "null".equals(str) || "NULL".equals(str)) {
            return null;
        }
        return Short.valueOf(Short.parseShort(str));
    }

    public static java.sql.Date x(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof java.sql.Date) {
            return (java.sql.Date) obj;
        }
        if (obj instanceof Date) {
            return new java.sql.Date(((Date) obj).getTime());
        }
        if (obj instanceof Calendar) {
            return new java.sql.Date(((Calendar) obj).getTimeInMillis());
        }
        long jLongValue = obj instanceof Number ? ((Number) obj).longValue() : 0L;
        if (obj instanceof String) {
            String str = (String) obj;
            if (str.length() == 0 || "null".equals(str) || "NULL".equals(str)) {
                return null;
            }
            if (i0(str)) {
                jLongValue = Long.parseLong(str);
            } else {
                com.alibaba.fastjson.parser.g gVar = new com.alibaba.fastjson.parser.g(str);
                if (!gVar.T2(false)) {
                    throw new com.alibaba.fastjson.d("can not cast to Timestamp, value : " + str);
                }
                jLongValue = gVar.X1().getTime().getTime();
            }
        }
        if (jLongValue > 0) {
            return new java.sql.Date(jLongValue);
        }
        throw new com.alibaba.fastjson.d("can not cast to Date, value : " + obj);
    }

    public static Time y(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Time) {
            return (Time) obj;
        }
        if (obj instanceof Date) {
            return new Time(((Date) obj).getTime());
        }
        if (obj instanceof Calendar) {
            return new Time(((Calendar) obj).getTimeInMillis());
        }
        long jLongValue = obj instanceof Number ? ((Number) obj).longValue() : 0L;
        if (obj instanceof String) {
            String str = (String) obj;
            if (str.length() == 0 || "null".equalsIgnoreCase(str)) {
                return null;
            }
            if (i0(str)) {
                jLongValue = Long.parseLong(str);
            } else {
                com.alibaba.fastjson.parser.g gVar = new com.alibaba.fastjson.parser.g(str);
                if (!gVar.T2(false)) {
                    throw new com.alibaba.fastjson.d("can not cast to Timestamp, value : " + str);
                }
                jLongValue = gVar.X1().getTime().getTime();
            }
        }
        if (jLongValue > 0) {
            return new Time(jLongValue);
        }
        throw new com.alibaba.fastjson.d("can not cast to Date, value : " + obj);
    }

    public static String z(Object obj) {
        if (obj == null) {
            return null;
        }
        return obj.toString();
    }
}
