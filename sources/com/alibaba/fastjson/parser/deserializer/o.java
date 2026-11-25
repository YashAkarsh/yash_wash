package com.alibaba.fastjson.parser.deserializer;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class o implements e1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final o f12912a = new o();

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.alibaba.fastjson.parser.deserializer.e1
    public <T> T b(com.alibaba.fastjson.parser.b bVar, Type type, Object obj) {
        if (!(type instanceof GenericArrayType)) {
            return (!(type instanceof Class) || type == Object.class || type == Serializable.class) ? (T) bVar.I0(obj) : (T) bVar.w1(type);
        }
        Type genericComponentType = ((GenericArrayType) type).getGenericComponentType();
        if (genericComponentType instanceof TypeVariable) {
            genericComponentType = ((TypeVariable) genericComponentType).getBounds()[0];
        }
        ArrayList arrayList = new ArrayList();
        bVar.Q0(genericComponentType, arrayList);
        if (!(genericComponentType instanceof Class)) {
            return (T) arrayList.toArray();
        }
        T t7 = (T) ((Object[]) Array.newInstance((Class<?>) genericComponentType, arrayList.size()));
        arrayList.toArray((Object[]) t7);
        return t7;
    }

    @Override // com.alibaba.fastjson.parser.deserializer.e1
    public int e() {
        return 12;
    }
}
