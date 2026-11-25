package com.haier.library.json.parser;

import com.haier.library.json.serializer.a0;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Constructor<?> f26749a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final int f26750b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final Constructor<?> f26751c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final Method f26752d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final i3.a[] f26753e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final i3.a[] f26754f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final g3.d f26755g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    boolean f26756h = false;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final boolean f26757i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f26758j;

    h(Class<?> cls, Constructor<?> constructor, Constructor<?> constructor2, Method method, i3.a[] aVarArr, i3.a[] aVarArr2, g3.d dVar) {
        boolean z7;
        this.f26749a = constructor;
        this.f26751c = constructor2;
        this.f26752d = method;
        this.f26753e = aVarArr;
        this.f26755g = dVar;
        if (dVar != null) {
            String strTypeName = dVar.typeName();
            if (strTypeName.length() != 0) {
                this.f26758j = strTypeName;
            } else {
                this.f26758j = cls.getName();
            }
        } else {
            this.f26758j = cls.getName();
        }
        if (dVar != null) {
            d[] features = dVar.parseFeatures();
            z7 = false;
            for (d dVar2 : features) {
                if (dVar2 == d.SupportArrayToBean) {
                    z7 = true;
                }
            }
        } else {
            z7 = false;
        }
        this.f26757i = z7;
        i3.a[] aVarArrC = c(aVarArr, aVarArr2);
        this.f26754f = Arrays.equals(aVarArr, aVarArrC) ? aVarArr : aVarArrC;
        this.f26750b = constructor != null ? constructor.getParameterTypes().length : 0;
    }

    static boolean a(List<i3.a> list, i3.a aVar, boolean z7) {
        if (!z7) {
            int size = list.size();
            for (int i7 = 0; i7 < size; i7++) {
                i3.a aVar2 = list.get(i7);
                if (aVar2.f34161a.equals(aVar.f34161a) && (!aVar2.f34170j || aVar.f34170j)) {
                    return false;
                }
            }
        }
        list.add(aVar);
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:148:0x0305 A[PHI: r21 r22 r26 r27 r28 r29 r30
      0x0305: PHI (r21v6 java.lang.reflect.Method[]) = 
      (r8v7 java.lang.reflect.Method[])
      (r8v7 java.lang.reflect.Method[])
      (r8v7 java.lang.reflect.Method[])
      (r21v8 java.lang.reflect.Method[])
     binds: [B:147:0x0303, B:164:0x0360, B:166:0x036a, B:143:0x029d] A[DONT_GENERATE, DONT_INLINE]
      0x0305: PHI (r22v5 java.lang.reflect.Constructor<?>) = 
      (r9v11 java.lang.reflect.Constructor<?>)
      (r9v11 java.lang.reflect.Constructor<?>)
      (r9v11 java.lang.reflect.Constructor<?>)
      (r22v8 java.lang.reflect.Constructor<?>)
     binds: [B:147:0x0303, B:164:0x0360, B:166:0x036a, B:143:0x029d] A[DONT_GENERATE, DONT_INLINE]
      0x0305: PHI (r26v4 int) = (r1v38 int), (r1v38 int), (r1v38 int), (r26v6 int) binds: [B:147:0x0303, B:164:0x0360, B:166:0x036a, B:143:0x029d] A[DONT_GENERATE, DONT_INLINE]
      0x0305: PHI (r27v4 int) = (r2v27 int), (r2v27 int), (r2v27 int), (r27v6 int) binds: [B:147:0x0303, B:164:0x0360, B:166:0x036a, B:143:0x029d] A[DONT_GENERATE, DONT_INLINE]
      0x0305: PHI (r28v2 java.lang.Class<g3.b>) = (r5v9 java.lang.Class<g3.b>), (r5v9 java.lang.Class<g3.b>), (r5v9 java.lang.Class<g3.b>), (r28v4 java.lang.Class<g3.b>) binds: [B:147:0x0303, B:164:0x0360, B:166:0x036a, B:143:0x029d] A[DONT_GENERATE, DONT_INLINE]
      0x0305: PHI (r29v7 java.lang.Class<? super ?>) = 
      (r6v18 java.lang.Class<? super ?>)
      (r6v18 java.lang.Class<? super ?>)
      (r6v18 java.lang.Class<? super ?>)
      (r29v9 java.lang.Class<? super ?>)
     binds: [B:147:0x0303, B:164:0x0360, B:166:0x036a, B:143:0x029d] A[DONT_GENERATE, DONT_INLINE]
      0x0305: PHI (r30v5 java.lang.Class<g3.d>) = 
      (r10v18 java.lang.Class<g3.d>)
      (r10v18 java.lang.Class<g3.d>)
      (r10v18 java.lang.Class<g3.d>)
      (r30v7 java.lang.Class<g3.d>)
     binds: [B:147:0x0303, B:164:0x0360, B:166:0x036a, B:143:0x029d] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:170:0x037b  */
    /* JADX WARN: Code duplicated, block: B:172:0x0386  */
    /* JADX WARN: Code duplicated, block: B:173:0x03ac  */
    /* JADX WARN: Code duplicated, block: B:176:0x03b0  */
    /* JADX WARN: Code duplicated, block: B:178:0x03b4  */
    /* JADX WARN: Code duplicated, block: B:179:0x03bd  */
    /* JADX WARN: Code duplicated, block: B:181:0x03c1  */
    /* JADX WARN: Code duplicated, block: B:183:0x03d7  */
    /* JADX WARN: Code duplicated, block: B:185:0x03fe  */
    /* JADX WARN: Code duplicated, block: B:187:0x0420  */
    /* JADX WARN: Code duplicated, block: B:261:0x059b  */
    /* JADX WARN: Code duplicated, block: B:263:0x05ee  */
    /* JADX WARN: Instruction removed from duplicated block: B:172:0x0386, please report this as an issue */
    public static h b(Class<?> cls, int i7, Type type, boolean z7, boolean z8, boolean z9, boolean z10) {
        Constructor<?> declaredConstructor;
        Constructor<?> constructor;
        char c8;
        String string;
        String str;
        int i8;
        int i9;
        Class<g3.b> cls2;
        Class<?> returnType;
        int iOrdinal;
        int iA;
        String strU;
        String strSubstring;
        Field fieldW;
        boolean z11;
        Field field;
        Class<g3.b> cls3;
        g3.b bVar;
        Constructor<?> constructor2;
        Method method;
        g3.b bVar2;
        g3.b bVar3;
        Class<?> cls4 = cls;
        int i10 = i7;
        ArrayList arrayList = new ArrayList();
        int i11 = i10 & 1024;
        int i12 = 1;
        int i13 = 0;
        if (i11 == 0) {
            try {
                declaredConstructor = cls4.getDeclaredConstructor(new Class[0]);
            } catch (Exception unused) {
                declaredConstructor = null;
            }
            if (declaredConstructor != null || !cls.isMemberClass() || (i10 & 8) != 0) {
                constructor = declaredConstructor;
                break;
            }
            Constructor<?>[] declaredConstructors = cls.getDeclaredConstructors();
            int length = declaredConstructors.length;
            int i14 = 0;
            while (true) {
                if (i14 >= length) {
                    constructor = declaredConstructor;
                    break;
                }
                Constructor<?> constructor3 = declaredConstructors[i14];
                Class<?>[] parameterTypes = constructor3.getParameterTypes();
                if (parameterTypes.length == 1 && parameterTypes[0].equals(cls.getDeclaringClass())) {
                    constructor = constructor3;
                    break;
                }
                i14++;
            }
        } else {
            constructor = null;
        }
        Method[] methods = z7 ? null : cls.getMethods();
        Field[] declaredFields = cls.getDeclaredFields();
        Class<g3.d> cls5 = g3.d.class;
        if (constructor == null && !cls.isInterface() && i11 == 0) {
            Constructor<?>[] declaredConstructors2 = cls.getDeclaredConstructors();
            int length2 = declaredConstructors2.length;
            int i15 = 0;
            while (true) {
                if (i15 >= length2) {
                    constructor2 = null;
                    break;
                }
                Constructor<?> constructor4 = declaredConstructors2[i15];
                if (((g3.a) constructor4.getAnnotation(g3.a.class)) != null) {
                    constructor2 = constructor4;
                    break;
                }
                i15++;
            }
            if (constructor2 != null) {
                i3.d.D(cls4, constructor2, i10);
                Class<?>[] parameterTypes2 = constructor2.getParameterTypes();
                Type[] genericParameterTypes = z10 ? constructor2.getGenericParameterTypes() : parameterTypes2;
                int i16 = 0;
                while (i16 < parameterTypes2.length) {
                    Annotation[] annotationArr = constructor2.getParameterAnnotations()[i16];
                    int length3 = annotationArr.length;
                    int i17 = i13;
                    while (true) {
                        if (i17 >= length3) {
                            bVar3 = null;
                            break;
                        }
                        Annotation annotation = annotationArr[i17];
                        if (annotation instanceof g3.b) {
                            bVar3 = (g3.b) annotation;
                            break;
                        }
                        i17++;
                    }
                    if (bVar3 == null) {
                        throw new com.haier.library.json.d("illegal json creator");
                    }
                    Class<?> cls6 = parameterTypes2[i16];
                    Type type2 = genericParameterTypes[i16];
                    Field fieldW2 = i3.d.w(cls4, bVar3.name(), declaredFields);
                    if (fieldW2 != null) {
                        i3.d.D(cls4, fieldW2, i10);
                    }
                    a(arrayList, new i3.a(bVar3.name(), cls, cls6, type2, fieldW2, bVar3.ordinal(), a0.a(bVar3.serialzeFeatures())), z7);
                    i16++;
                    cls5 = cls5;
                    declaredFields = declaredFields;
                    i13 = 0;
                    i10 = i7;
                }
                Class<g3.d> cls7 = cls5;
                int size = arrayList.size();
                i3.a[] aVarArr = new i3.a[size];
                arrayList.toArray(aVarArr);
                i3.a[] aVarArr2 = new i3.a[size];
                System.arraycopy(aVarArr, 0, aVarArr2, 0, size);
                Arrays.sort(aVarArr2);
                return new h(cls, null, constructor2, null, aVarArr, aVarArr2, z8 ? (g3.d) cls4.getAnnotation(cls7) : null);
            }
            Field[] fieldArr = declaredFields;
            int length4 = methods.length;
            int i18 = 0;
            while (true) {
                if (i18 >= length4) {
                    method = null;
                    break;
                }
                Method method2 = methods[i18];
                if (Modifier.isStatic(method2.getModifiers()) && cls4.isAssignableFrom(method2.getReturnType()) && ((g3.a) method2.getAnnotation(g3.a.class)) != null) {
                    method = method2;
                    break;
                }
                i18++;
            }
            if (method == null) {
                throw new com.haier.library.json.d("default constructor not found. " + cls4);
            }
            i3.d.D(cls4, method, i7);
            Class<?>[] parameterTypes3 = method.getParameterTypes();
            Type[] genericParameterTypes2 = z10 ? method.getGenericParameterTypes() : parameterTypes3;
            int i19 = 0;
            while (i19 < parameterTypes3.length) {
                Annotation[] annotationArr2 = method.getParameterAnnotations()[i19];
                int length5 = annotationArr2.length;
                int i20 = 0;
                while (true) {
                    if (i20 >= length5) {
                        bVar2 = null;
                        break;
                    }
                    Annotation annotation2 = annotationArr2[i20];
                    if (annotation2 instanceof g3.b) {
                        bVar2 = (g3.b) annotation2;
                        break;
                    }
                    i20++;
                }
                if (bVar2 == null) {
                    throw new com.haier.library.json.d("illegal json creator");
                }
                Field[] fieldArr2 = fieldArr;
                a(arrayList, new i3.a(bVar2.name(), cls, parameterTypes3[i19], genericParameterTypes2[i19], i3.d.w(cls4, bVar2.name(), fieldArr2), bVar2.ordinal(), a0.a(bVar2.serialzeFeatures())), z7);
                i19++;
                parameterTypes3 = parameterTypes3;
                fieldArr = fieldArr2;
            }
            int size2 = arrayList.size();
            i3.a[] aVarArr3 = new i3.a[size2];
            arrayList.toArray(aVarArr3);
            i3.a[] aVarArr4 = new i3.a[size2];
            System.arraycopy(aVarArr3, 0, aVarArr4, 0, size2);
            Arrays.sort(aVarArr4);
            return new h(cls, null, null, method, aVarArr3, Arrays.equals(aVarArr3, aVarArr4) ? aVarArr3 : aVarArr4, z8 ? (g3.d) cls4.getAnnotation(cls5) : null);
        }
        Field[] fieldArr3 = declaredFields;
        Class<g3.d> cls8 = cls5;
        if (constructor != null) {
            i3.d.D(cls4, constructor, i10);
        }
        Class<? super Object> cls9 = Object.class;
        Class<g3.b> cls10 = g3.b.class;
        int i21 = 4;
        if (!z7) {
            int length6 = methods.length;
            int i22 = 0;
            while (i22 < length6) {
                Method method3 = methods[i22];
                String name = method3.getName();
                if (name.length() < i21 || Modifier.isStatic(method3.getModifiers()) || !(((returnType = method3.getReturnType()) == Void.TYPE || returnType == method3.getDeclaringClass()) && method3.getParameterTypes().length == i12 && method3.getDeclaringClass() != cls9)) {
                    i22 = i22;
                    length6 = length6;
                    cls2 = cls10;
                    cls9 = cls9;
                    methods = methods;
                    constructor = constructor;
                    cls8 = cls8;
                    fieldArr3 = fieldArr3;
                } else {
                    g3.b bVarZ = z9 ? (g3.b) method3.getAnnotation(cls10) : null;
                    if (bVarZ == null && z9) {
                        bVarZ = i3.d.z(cls4, method3);
                    }
                    g3.b bVar4 = bVarZ;
                    if (bVar4 == null) {
                        iOrdinal = 0;
                        iA = 0;
                    } else if (bVar4.deserialize()) {
                        int iOrdinal2 = bVar4.ordinal();
                        iA = a0.a(bVar4.serialzeFeatures());
                        if (bVar4.name().length() != 0) {
                            i22 = i22;
                            length6 = length6;
                            cls10 = cls10;
                            cls9 = cls9;
                            methods = methods;
                            constructor = constructor;
                            cls8 = cls8;
                            a(arrayList, new i3.a(bVar4.name(), method3, null, cls, type, iOrdinal2, iA, bVar4, null, z10), z7);
                            i3.d.D(cls4, method3, i10);
                        } else {
                            iOrdinal = iOrdinal2;
                        }
                        fieldArr3 = fieldArr3;
                        cls2 = cls10;
                    } else {
                        i22 = i22;
                        length6 = length6;
                        cls2 = cls10;
                        cls9 = cls9;
                        methods = methods;
                        constructor = constructor;
                        cls8 = cls8;
                        fieldArr3 = fieldArr3;
                    }
                    if (name.startsWith("set")) {
                        char cCharAt = name.charAt(3);
                        if (Character.isUpperCase(cCharAt)) {
                            if (i3.d.f34184a) {
                                strSubstring = i3.d.u(name.substring(3));
                            } else {
                                strU = Character.toLowerCase(name.charAt(3)) + name.substring(4);
                            }
                            fieldW = i3.d.w(cls4, strSubstring, fieldArr3);
                            if (fieldW == null) {
                                z11 = false;
                                if (method3.getParameterTypes()[0] == Boolean.TYPE) {
                                    fieldW = i3.d.w(cls4, "is" + Character.toUpperCase(strSubstring.charAt(0)) + strSubstring.substring(1), fieldArr3);
                                }
                            } else {
                                z11 = false;
                            }
                            field = fieldW;
                            if (field != null) {
                                cls3 = cls10;
                                if (z9) {
                                    bVar = (g3.b) field.getAnnotation(cls3);
                                } else {
                                    bVar = null;
                                }
                                if (bVar != null) {
                                    iOrdinal = bVar.ordinal();
                                    iA = a0.a(bVar.serialzeFeatures());
                                    if (bVar.name().length() != 0) {
                                        cls2 = cls3;
                                        fieldArr3 = fieldArr3;
                                        a(arrayList, new i3.a(bVar.name(), method3, field, cls, type, iOrdinal, iA, bVar4, bVar, z10), z7);
                                    }
                                }
                                cls2 = cls3;
                            } else {
                                cls2 = cls10;
                            }
                            a(arrayList, new i3.a(strSubstring, method3, null, cls, type, iOrdinal, iA, bVar4, null, z10), z7);
                            cls4 = cls;
                            i3.d.D(cls4, method3, i10);
                        } else if (cCharAt == '_') {
                            strU = name.substring(4);
                        } else {
                            if (cCharAt == 'f') {
                                strSubstring = name.substring(3);
                            } else if (name.length() < 5 || !Character.isUpperCase(name.charAt(4))) {
                                fieldArr3 = fieldArr3;
                                cls2 = cls10;
                            } else {
                                strU = i3.d.u(name.substring(3));
                            }
                            fieldW = i3.d.w(cls4, strSubstring, fieldArr3);
                            if (fieldW == null) {
                                z11 = false;
                                if (method3.getParameterTypes()[0] == Boolean.TYPE) {
                                    fieldW = i3.d.w(cls4, "is" + Character.toUpperCase(strSubstring.charAt(0)) + strSubstring.substring(1), fieldArr3);
                                }
                            } else {
                                z11 = false;
                            }
                            field = fieldW;
                            if (field != null) {
                                cls3 = cls10;
                                if (z9) {
                                    bVar = (g3.b) field.getAnnotation(cls3);
                                } else {
                                    bVar = null;
                                }
                                if (bVar != null) {
                                    iOrdinal = bVar.ordinal();
                                    iA = a0.a(bVar.serialzeFeatures());
                                    if (bVar.name().length() != 0) {
                                        cls2 = cls3;
                                        fieldArr3 = fieldArr3;
                                        a(arrayList, new i3.a(bVar.name(), method3, field, cls, type, iOrdinal, iA, bVar4, bVar, z10), z7);
                                    }
                                }
                                cls2 = cls3;
                            } else {
                                cls2 = cls10;
                            }
                            a(arrayList, new i3.a(strSubstring, method3, null, cls, type, iOrdinal, iA, bVar4, null, z10), z7);
                            cls4 = cls;
                            i3.d.D(cls4, method3, i10);
                        }
                        strSubstring = strU;
                        fieldW = i3.d.w(cls4, strSubstring, fieldArr3);
                        if (fieldW == null) {
                            z11 = false;
                            if (method3.getParameterTypes()[0] == Boolean.TYPE) {
                                fieldW = i3.d.w(cls4, "is" + Character.toUpperCase(strSubstring.charAt(0)) + strSubstring.substring(1), fieldArr3);
                            }
                        } else {
                            z11 = false;
                        }
                        field = fieldW;
                        if (field != null) {
                            cls3 = cls10;
                            if (z9) {
                                bVar = (g3.b) field.getAnnotation(cls3);
                            } else {
                                bVar = null;
                            }
                            if (bVar != null) {
                                iOrdinal = bVar.ordinal();
                                iA = a0.a(bVar.serialzeFeatures());
                                if (bVar.name().length() != 0) {
                                    cls2 = cls3;
                                    fieldArr3 = fieldArr3;
                                    a(arrayList, new i3.a(bVar.name(), method3, field, cls, type, iOrdinal, iA, bVar4, bVar, z10), z7);
                                }
                            }
                            cls2 = cls3;
                        } else {
                            cls2 = cls10;
                        }
                        a(arrayList, new i3.a(strSubstring, method3, null, cls, type, iOrdinal, iA, bVar4, null, z10), z7);
                        cls4 = cls;
                        i3.d.D(cls4, method3, i10);
                    } else {
                        fieldArr3 = fieldArr3;
                        cls2 = cls10;
                    }
                }
                i22++;
                methods = methods;
                constructor = constructor;
                length6 = length6;
                cls9 = cls9;
                cls8 = cls8;
                cls10 = cls2;
                fieldArr3 = fieldArr3;
                i21 = 4;
                i12 = 1;
            }
        }
        Class<g3.b> cls11 = cls10;
        Class<? super Object> cls12 = cls9;
        Constructor<?> constructor5 = constructor;
        Class<g3.d> cls13 = cls8;
        Field[] fieldArr4 = fieldArr3;
        ArrayList<Field> arrayList2 = new ArrayList(fieldArr4.length);
        for (Field field2 : fieldArr4) {
            if ((field2.getModifiers() & 8) == 0 && (field2.getModifiers() & 1) != 0) {
                arrayList2.add(field2);
            }
        }
        Class<? super Object> superclass = cls.getSuperclass();
        while (superclass != null) {
            Class<? super Object> cls14 = cls12;
            if (superclass == cls14) {
                break;
            }
            for (Field field3 : superclass.getDeclaredFields()) {
                if ((field3.getModifiers() & 8) == 0 && (field3.getModifiers() & 1) != 0) {
                    arrayList2.add(field3);
                }
            }
            superclass = superclass.getSuperclass();
            cls12 = cls14;
        }
        boolean z12 = true;
        for (Field field4 : arrayList2) {
            String name2 = field4.getName();
            int size3 = arrayList.size();
            boolean z13 = false;
            for (int i23 = 0; i23 < size3; i23++) {
                if (((i3.a) arrayList.get(i23)).f34161a.equals(name2)) {
                    z13 = z12;
                }
            }
            if (!z13) {
                Class<g3.b> cls15 = cls11;
                g3.b bVar5 = z9 ? (g3.b) field4.getAnnotation(cls15) : null;
                if (bVar5 != null) {
                    int iOrdinal3 = bVar5.ordinal();
                    int iA2 = a0.a(bVar5.serialzeFeatures());
                    if (bVar5.name().length() != 0) {
                        name2 = bVar5.name();
                    }
                    i8 = iOrdinal3;
                    i9 = iA2;
                    str = name2;
                } else {
                    str = name2;
                    i8 = 0;
                    i9 = 0;
                }
                i3.d.D(cls4, field4, i10);
                a(arrayList, new i3.a(str, null, field4, cls, type, i8, i9, null, bVar5, z10), z7);
                z12 = true;
                cls11 = cls15;
                cls4 = cls;
            }
        }
        Class<g3.b> cls16 = cls11;
        if (!z7) {
            Method[] methods2 = cls.getMethods();
            int i24 = 0;
            for (int length7 = methods2.length; i24 < length7; length7 = length7) {
                Method method4 = methods2[i24];
                String name3 = method4.getName();
                if (name3.length() >= 4 && !Modifier.isStatic(method4.getModifiers()) && name3.startsWith("get") && Character.isUpperCase(name3.charAt(3)) && method4.getParameterTypes().length == 0) {
                    Class<?> returnType2 = method4.getReturnType();
                    if (Collection.class.isAssignableFrom(returnType2) || Map.class.isAssignableFrom(returnType2)) {
                        g3.b bVar6 = z9 ? (g3.b) method4.getAnnotation(cls16) : null;
                        if (bVar6 != null) {
                            string = bVar6.name();
                            if (string.length() > 0) {
                                c8 = 3;
                            } else {
                                StringBuilder sb = new StringBuilder();
                                c8 = 3;
                                sb.append(Character.toLowerCase(name3.charAt(3)));
                                sb.append(name3.substring(4));
                                string = sb.toString();
                            }
                        } else {
                            StringBuilder sb2 = new StringBuilder();
                            c8 = 3;
                            sb2.append(Character.toLowerCase(name3.charAt(3)));
                            sb2.append(name3.substring(4));
                            string = sb2.toString();
                        }
                        a(arrayList, new i3.a(string, method4, null, cls, type, 0, 0, bVar6, null, z10), z7);
                        i3.d.D(cls, method4, i10);
                    }
                }
                i24++;
                cls16 = cls16;
            }
        }
        int size4 = arrayList.size();
        i3.a[] aVarArr5 = new i3.a[size4];
        arrayList.toArray(aVarArr5);
        i3.a[] aVarArr6 = new i3.a[size4];
        System.arraycopy(aVarArr5, 0, aVarArr6, 0, size4);
        Arrays.sort(aVarArr6);
        return new h(cls, constructor5, null, null, aVarArr5, aVarArr6, z8 ? (g3.d) cls.getAnnotation(cls13) : null);
    }

    private i3.a[] c(i3.a[] aVarArr, i3.a[] aVarArr2) {
        String[] strArrOrders;
        boolean z7;
        boolean z8;
        boolean z9;
        boolean z10;
        g3.d dVar = this.f26755g;
        if (dVar != null && (strArrOrders = dVar.orders()) != null && strArrOrders.length != 0) {
            int i7 = 0;
            while (true) {
                if (i7 >= strArrOrders.length) {
                    z7 = true;
                    break;
                }
                int i8 = 0;
                while (true) {
                    if (i8 >= aVarArr2.length) {
                        z10 = false;
                        break;
                    }
                    if (aVarArr2[i8].f34161a.equals(strArrOrders[i7])) {
                        z10 = true;
                        break;
                    }
                    i8++;
                }
                if (!z10) {
                    z7 = false;
                    break;
                }
                i7++;
            }
            if (!z7) {
                return aVarArr2;
            }
            if (strArrOrders.length == aVarArr.length) {
                int i9 = 0;
                while (true) {
                    if (i9 >= strArrOrders.length) {
                        z9 = true;
                        break;
                    }
                    if (!aVarArr2[i9].f34161a.equals(strArrOrders[i9])) {
                        z9 = false;
                        break;
                    }
                    i9++;
                }
                if (z9) {
                    return aVarArr2;
                }
                i3.a[] aVarArr3 = new i3.a[aVarArr2.length];
                for (int i10 = 0; i10 < strArrOrders.length; i10++) {
                    for (int i11 = 0; i11 < aVarArr2.length; i11++) {
                        if (aVarArr2[i11].f34161a.equals(strArrOrders[i10])) {
                            aVarArr3[i10] = aVarArr2[i11];
                            break;
                        }
                    }
                }
                this.f26756h = true;
                return aVarArr3;
            }
            int length = aVarArr2.length;
            i3.a[] aVarArr4 = new i3.a[length];
            for (int i12 = 0; i12 < strArrOrders.length; i12++) {
                for (int i13 = 0; i13 < aVarArr2.length; i13++) {
                    if (aVarArr2[i13].f34161a.equals(strArrOrders[i12])) {
                        aVarArr4[i12] = aVarArr2[i13];
                        break;
                    }
                }
            }
            int length2 = strArrOrders.length;
            for (int i14 = 0; i14 < aVarArr2.length; i14++) {
                int i15 = 0;
                while (true) {
                    if (i15 >= length || i15 >= length2) {
                        z8 = false;
                        break;
                    }
                    if (aVarArr4[i14].b(aVarArr2[i15])) {
                        z8 = true;
                        break;
                    }
                    i15++;
                }
                if (!z8) {
                    aVarArr4[length2] = aVarArr2[i14];
                    length2++;
                }
            }
            this.f26756h = true;
        }
        return aVarArr2;
    }
}
