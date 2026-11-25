package org.hamcrest.core;

import java.lang.reflect.Array;

/* JADX INFO: loaded from: classes3.dex */
public class i<T> extends org.hamcrest.b<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f39718a;

    public i(T t7) {
        this.f39718a = t7;
    }

    private static boolean e(Object obj, Object obj2) {
        for (int i7 = 0; i7 < Array.getLength(obj); i7++) {
            if (!h(Array.get(obj, i7), Array.get(obj2, i7))) {
                return false;
            }
        }
        return true;
    }

    private static boolean f(Object obj, Object obj2) {
        return Array.getLength(obj) == Array.getLength(obj2);
    }

    private static boolean g(Object obj, Object obj2) {
        return f(obj, obj2) && e(obj, obj2);
    }

    private static boolean h(Object obj, Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        if (obj2 == null || !j(obj)) {
            return obj.equals(obj2);
        }
        return j(obj2) && g(obj, obj2);
    }

    @org.hamcrest.i
    public static <T> org.hamcrest.k<T> i(T t7) {
        return new i(t7);
    }

    private static boolean j(Object obj) {
        return obj.getClass().isArray();
    }

    @Override // org.hamcrest.m
    public void b(org.hamcrest.g gVar) {
        gVar.e(this.f39718a);
    }

    @Override // org.hamcrest.k
    public boolean c(Object obj) {
        return h(obj, this.f39718a);
    }
}
