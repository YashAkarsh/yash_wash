package com.google.common.reflect;

import com.google.common.collect.af;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
abstract class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Set<Type> f22499a = af.u();

    n() {
    }

    public final void a(Type... typeArr) {
        for (Type type : typeArr) {
            if (type != null && this.f22499a.add(type)) {
                try {
                    if (type instanceof TypeVariable) {
                        e((TypeVariable) type);
                    } else if (type instanceof WildcardType) {
                        f((WildcardType) type);
                    } else if (type instanceof ParameterizedType) {
                        d((ParameterizedType) type);
                    } else if (type instanceof Class) {
                        b((Class) type);
                    } else {
                        if (!(type instanceof GenericArrayType)) {
                            throw new AssertionError("Unknown type: " + type);
                        }
                        c((GenericArrayType) type);
                    }
                } catch (Throwable th) {
                    this.f22499a.remove(type);
                    throw th;
                }
            }
        }
    }

    void b(Class<?> cls) {
    }

    void c(GenericArrayType genericArrayType) {
    }

    void d(ParameterizedType parameterizedType) {
    }

    void e(TypeVariable<?> typeVariable) {
    }

    void f(WildcardType wildcardType) {
    }
}
