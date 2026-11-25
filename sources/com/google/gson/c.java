package com.google.gson;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Collection;

/* JADX INFO: loaded from: classes2.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Field f22954a;

    public c(Field field) {
        com.google.gson.internal.a.b(field);
        this.f22954a = field;
    }

    Object a(Object obj) throws IllegalAccessException {
        return this.f22954a.get(obj);
    }

    public <T extends Annotation> T b(Class<T> cls) {
        return (T) this.f22954a.getAnnotation(cls);
    }

    public Collection<Annotation> c() {
        return Arrays.asList(this.f22954a.getAnnotations());
    }

    public Class<?> d() {
        return this.f22954a.getType();
    }

    public Type e() {
        return this.f22954a.getGenericType();
    }

    public Class<?> f() {
        return this.f22954a.getDeclaringClass();
    }

    public String g() {
        return this.f22954a.getName();
    }

    public boolean h(int i7) {
        return (i7 & this.f22954a.getModifiers()) != 0;
    }

    boolean i() {
        return this.f22954a.isSynthetic();
    }
}
