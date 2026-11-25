package com.alibaba.fastjson;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: loaded from: classes.dex */
public class n<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static ConcurrentMap<Type, Type> f12777b = new ConcurrentHashMap(16, 0.75f, 1);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Type f12778c = new a().a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final Type f12779a;

    static class a extends n<List<String>> {
        a() {
        }
    }

    protected n() {
        Type type = ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        Type type2 = f12777b.get(type);
        if (type2 == null) {
            f12777b.putIfAbsent(type, type);
            type2 = f12777b.get(type);
        }
        this.f12779a = type2;
    }

    public Type a() {
        return this.f12779a;
    }

    protected n(Type... typeArr) {
        Class<?> cls = getClass();
        ParameterizedType parameterizedType = (ParameterizedType) ((ParameterizedType) cls.getGenericSuperclass()).getActualTypeArguments()[0];
        Type rawType = parameterizedType.getRawType();
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        int i7 = 0;
        for (int i8 = 0; i8 < actualTypeArguments.length; i8++) {
            if ((actualTypeArguments[i8] instanceof TypeVariable) && i7 < typeArr.length) {
                actualTypeArguments[i8] = typeArr[i7];
                i7++;
            }
            Type type = actualTypeArguments[i8];
            if (type instanceof GenericArrayType) {
                actualTypeArguments[i8] = com.alibaba.fastjson.util.l.B((GenericArrayType) type);
            }
        }
        com.alibaba.fastjson.util.i iVar = new com.alibaba.fastjson.util.i(actualTypeArguments, cls, rawType);
        Type type2 = f12777b.get(iVar);
        if (type2 == null) {
            f12777b.putIfAbsent(iVar, iVar);
            type2 = f12777b.get(iVar);
        }
        this.f12779a = type2;
    }
}
