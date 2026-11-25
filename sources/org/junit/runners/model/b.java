package org.junit.runners.model;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes3.dex */
public class b extends c<b> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Field f40043a;

    b(Field field) {
        if (field == null) {
            throw new NullPointerException("FrameworkField cannot be created without an underlying field.");
        }
        this.f40043a = field;
    }

    @Override // org.junit.runners.model.c
    public Class<?> a() {
        return this.f40043a.getDeclaringClass();
    }

    @Override // org.junit.runners.model.c
    protected int b() {
        return this.f40043a.getModifiers();
    }

    @Override // org.junit.runners.model.c
    public String c() {
        return j().getName();
    }

    @Override // org.junit.runners.model.c
    public Class<?> d() {
        return this.f40043a.getType();
    }

    @Override // org.junit.runners.model.a
    public <T extends Annotation> T getAnnotation(Class<T> cls) {
        return (T) this.f40043a.getAnnotation(cls);
    }

    @Override // org.junit.runners.model.a
    public Annotation[] getAnnotations() {
        return this.f40043a.getAnnotations();
    }

    public Object i(Object obj) throws IllegalAccessException, IllegalArgumentException {
        return this.f40043a.get(obj);
    }

    public Field j() {
        return this.f40043a;
    }

    @Override // org.junit.runners.model.c
    /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
    public boolean g(b bVar) {
        return bVar.c().equals(c());
    }

    public String toString() {
        return this.f40043a.toString();
    }
}
