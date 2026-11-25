package org.hamcrest.core;

/* JADX INFO: loaded from: classes3.dex */
public class j extends org.hamcrest.h<Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Class<?> f39719a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Class<?> f39720b;

    public j(Class<?> cls) {
        this.f39719a = cls;
        this.f39720b = h(cls);
    }

    @org.hamcrest.i
    public static <T> org.hamcrest.k<T> f(Class<T> cls) {
        return new j(cls);
    }

    @org.hamcrest.i
    public static <T> org.hamcrest.k<T> g(Class<?> cls) {
        return new j(cls);
    }

    private static Class<?> h(Class<?> cls) {
        if (Boolean.TYPE.equals(cls)) {
            return Boolean.class;
        }
        if (Byte.TYPE.equals(cls)) {
            return Byte.class;
        }
        if (Character.TYPE.equals(cls)) {
            return Character.class;
        }
        if (Double.TYPE.equals(cls)) {
            return Double.class;
        }
        if (Float.TYPE.equals(cls)) {
            return Float.class;
        }
        if (Integer.TYPE.equals(cls)) {
            return Integer.class;
        }
        if (Long.TYPE.equals(cls)) {
            return Long.class;
        }
        return Short.TYPE.equals(cls) ? Short.class : cls;
    }

    @Override // org.hamcrest.m
    public void b(org.hamcrest.g gVar) {
        gVar.d("an instance of ").d(this.f39719a.getName());
    }

    @Override // org.hamcrest.h
    protected boolean e(Object obj, org.hamcrest.g gVar) {
        if (obj == null) {
            gVar.d("null");
            return false;
        }
        if (this.f39720b.isInstance(obj)) {
            return true;
        }
        gVar.e(obj).d(" is a " + obj.getClass().getName());
        return false;
    }
}
