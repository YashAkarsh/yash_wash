package com.haier.library.json.parser;

import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class i implements h3.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i f26759a = new i();

    /* JADX WARN: Multi-variable type inference failed */
    @Override // h3.f
    public <T> T a(b bVar, Type type, Object obj) {
        if (!(type instanceof GenericArrayType)) {
            return (T) bVar.H(obj);
        }
        Type genericComponentType = ((GenericArrayType) type).getGenericComponentType();
        if (genericComponentType instanceof TypeVariable) {
            genericComponentType = ((TypeVariable) genericComponentType).getBounds()[0];
        }
        ArrayList arrayList = new ArrayList();
        bVar.g0(genericComponentType, arrayList);
        if (!(genericComponentType instanceof Class)) {
            return (T) arrayList.toArray();
        }
        T t7 = (T) ((Object[]) Array.newInstance((Class<?>) genericComponentType, arrayList.size()));
        arrayList.toArray((Object[]) t7);
        return t7;
    }
}
