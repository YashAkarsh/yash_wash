package com.google.common.primitives;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
@s1.c
public final class f0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Map<Class<?>, Class<?>> f22360a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Map<Class<?>, Class<?>> f22361b;

    static {
        LinkedHashMap linkedHashMap = new LinkedHashMap(16);
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(16);
        a(linkedHashMap, linkedHashMap2, Boolean.TYPE, Boolean.class);
        a(linkedHashMap, linkedHashMap2, Byte.TYPE, Byte.class);
        a(linkedHashMap, linkedHashMap2, Character.TYPE, Character.class);
        a(linkedHashMap, linkedHashMap2, Double.TYPE, Double.class);
        a(linkedHashMap, linkedHashMap2, Float.TYPE, Float.class);
        a(linkedHashMap, linkedHashMap2, Integer.TYPE, Integer.class);
        a(linkedHashMap, linkedHashMap2, Long.TYPE, Long.class);
        a(linkedHashMap, linkedHashMap2, Short.TYPE, Short.class);
        a(linkedHashMap, linkedHashMap2, Void.TYPE, Void.class);
        f22360a = Collections.unmodifiableMap(linkedHashMap);
        f22361b = Collections.unmodifiableMap(linkedHashMap2);
    }

    private f0() {
    }

    private static void a(Map<Class<?>, Class<?>> map, Map<Class<?>, Class<?>> map2, Class<?> cls, Class<?> cls2) {
        map.put(cls, cls2);
        map2.put(cls2, cls);
    }

    public static Set<Class<?>> b() {
        return f22360a.keySet();
    }

    public static Set<Class<?>> c() {
        return f22361b.keySet();
    }

    public static boolean d(Class<?> cls) {
        return f22361b.containsKey(com.google.common.base.e0.E(cls));
    }

    public static <T> Class<T> e(Class<T> cls) {
        com.google.common.base.e0.E(cls);
        Class<T> cls2 = (Class) f22361b.get(cls);
        return cls2 == null ? cls : cls2;
    }

    public static <T> Class<T> f(Class<T> cls) {
        com.google.common.base.e0.E(cls);
        Class<T> cls2 = (Class) f22360a.get(cls);
        return cls2 == null ? cls : cls2;
    }
}
