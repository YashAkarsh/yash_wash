package com.google.common.reflect;

import com.google.common.base.e0;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes2.dex */
abstract class i<T> {
    i() {
    }

    final Type a() {
        Type genericSuperclass = getClass().getGenericSuperclass();
        e0.u(genericSuperclass instanceof ParameterizedType, "%s isn't parameterized", genericSuperclass);
        return ((ParameterizedType) genericSuperclass).getActualTypeArguments()[0];
    }
}
