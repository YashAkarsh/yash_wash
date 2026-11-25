package com.alibaba.fastjson.serializer;

import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import okhttp3.HttpUrl;

/* JADX INFO: loaded from: classes.dex */
public class x0 implements y0, com.alibaba.fastjson.parser.deserializer.e1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final x0 f13183a = new x0();

    /* JADX WARN: Code duplicated, block: B:27:0x0054  */
    private <T> T f(com.alibaba.fastjson.parser.b bVar, Class<?> cls, com.alibaba.fastjson.b bVar2) {
        Object objE;
        if (bVar2 == null) {
            return null;
        }
        int size = bVar2.size();
        T t7 = (T) Array.newInstance(cls, size);
        for (int i7 = 0; i7 < size; i7++) {
            Object objF = bVar2.get(i7);
            if (objF == bVar2) {
                Array.set(t7, i7, t7);
            } else if (cls.isArray()) {
                if (!cls.isInstance(objF)) {
                    objF = f(bVar, cls, (com.alibaba.fastjson.b) objF);
                }
                Array.set(t7, i7, objF);
            } else {
                if (objF instanceof com.alibaba.fastjson.b) {
                    com.alibaba.fastjson.b bVar3 = (com.alibaba.fastjson.b) objF;
                    int size2 = bVar3.size();
                    boolean z7 = false;
                    for (int i8 = 0; i8 < size2; i8++) {
                        if (bVar3.get(i8) == bVar2) {
                            bVar3.set(i7, t7);
                            z7 = true;
                        }
                    }
                    if (z7) {
                        objE = bVar3.toArray();
                    } else {
                        objE = null;
                    }
                } else {
                    objE = null;
                }
                if (objE == null) {
                    objE = com.alibaba.fastjson.util.l.e(objF, cls, bVar.u());
                }
                Array.set(t7, i7, objE);
            }
        }
        bVar2.G1(t7);
        bVar2.F1(cls);
        return t7;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v1, types: [T, byte[]] */
    @Override // com.alibaba.fastjson.parser.deserializer.e1
    public <T> T b(com.alibaba.fastjson.parser.b bVar, Type type, Object obj) {
        Type componentType;
        Class clsN;
        com.alibaba.fastjson.parser.d dVar = bVar.f12789f;
        int iL0 = dVar.L0();
        Type type2 = null;
        if (iL0 == 8) {
            dVar.Q(16);
            return null;
        }
        if (iL0 == 4 || iL0 == 26) {
            ?? r8 = (T) dVar.o0();
            dVar.Q(16);
            if (r8.length != 0 || type == byte[].class) {
                return r8;
            }
            return null;
        }
        if (type instanceof GenericArrayType) {
            componentType = ((GenericArrayType) type).getGenericComponentType();
            if (componentType instanceof TypeVariable) {
                TypeVariable typeVariable = (TypeVariable) componentType;
                Type type3 = bVar.C().f12968d;
                if (type3 instanceof ParameterizedType) {
                    ParameterizedType parameterizedType = (ParameterizedType) type3;
                    Type rawType = parameterizedType.getRawType();
                    if (rawType instanceof Class) {
                        TypeVariable<Class<T>>[] typeParameters = ((Class) rawType).getTypeParameters();
                        for (int i7 = 0; i7 < typeParameters.length; i7++) {
                            if (typeParameters[i7].getName().equals(typeVariable.getName())) {
                                type2 = parameterizedType.getActualTypeArguments()[i7];
                            }
                        }
                    }
                    clsN = type2 instanceof Class ? (Class) type2 : Object.class;
                } else {
                    clsN = com.alibaba.fastjson.util.l.N(typeVariable.getBounds()[0]);
                }
            } else {
                clsN = com.alibaba.fastjson.util.l.N(componentType);
            }
        } else {
            componentType = ((Class) type).getComponentType();
            clsN = componentType;
        }
        com.alibaba.fastjson.b bVar2 = new com.alibaba.fastjson.b();
        bVar.T0(componentType, bVar2, obj);
        return (T) f(bVar, clsN, bVar2);
    }

    @Override // com.alibaba.fastjson.serializer.y0
    public final void c(n0 n0Var, Object obj, Object obj2, Type type, int i7) throws IOException {
        j1 j1Var = n0Var.f13143k;
        Object[] objArr = (Object[]) obj;
        if (obj == null) {
            j1Var.Z1(k1.WriteNullListAsEmpty);
            return;
        }
        int length = objArr.length;
        int i8 = length - 1;
        if (i8 == -1) {
            j1Var.append(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
            return;
        }
        e1 e1Var = n0Var.f13149q;
        n0Var.L(e1Var, obj, obj2, 0);
        try {
            j1Var.append('[');
            if (j1Var.G(k1.PrettyFormat)) {
                n0Var.F();
                n0Var.J();
                for (int i9 = 0; i9 < length; i9++) {
                    if (i9 != 0) {
                        j1Var.write(44);
                        n0Var.J();
                    }
                    n0Var.S(objArr[i9]);
                }
                n0Var.v();
                n0Var.J();
                j1Var.write(93);
                return;
            }
            Class<?> cls = null;
            y0 y0VarB = null;
            for (int i10 = 0; i10 < i8; i10++) {
                Object obj3 = objArr[i10];
                if (obj3 == null) {
                    j1Var.append("null,");
                } else {
                    if (n0Var.u(obj3)) {
                        n0Var.W(obj3);
                    } else {
                        Class<?> cls2 = obj3.getClass();
                        if (cls2 == cls) {
                            y0VarB.c(n0Var, obj3, null, null, 0);
                        } else {
                            y0VarB = n0Var.B(cls2);
                            y0VarB.c(n0Var, obj3, null, null, 0);
                            cls = cls2;
                        }
                    }
                    j1Var.append(',');
                }
            }
            Object obj4 = objArr[i8];
            if (obj4 == null) {
                j1Var.append("null]");
            } else {
                if (n0Var.u(obj4)) {
                    n0Var.W(obj4);
                } else {
                    n0Var.X(obj4, Integer.valueOf(i8));
                }
                j1Var.append(']');
            }
        } finally {
            n0Var.f13149q = e1Var;
        }
    }

    @Override // com.alibaba.fastjson.parser.deserializer.e1
    public int e() {
        return 14;
    }
}
