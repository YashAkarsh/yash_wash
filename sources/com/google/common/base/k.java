package com.google.common.base;

import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
@s1.b(emulated = true)
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @s1.c
    private static final Map<Class<? extends Enum<?>>, Map<String, WeakReference<? extends Enum<?>>>> f19438a = new WeakHashMap();

    private static final class a<T extends Enum<T>> extends i<String, T> implements Serializable {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final long f19439d = 0;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Class<T> f19440c;

        a(Class<T> cls) {
            this.f19440c = (Class) e0.E(cls);
        }

        @Override // com.google.common.base.i, com.google.common.base.s
        public boolean equals(Object obj) {
            if (obj instanceof a) {
                return this.f19440c.equals(((a) obj).f19440c);
            }
            return false;
        }

        public int hashCode() {
            return this.f19440c.hashCode();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.base.i
        /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
        public String g(T t7) {
            return t7.name();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.base.i
        /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
        public T h(String str) {
            return (T) Enum.valueOf(this.f19440c, str);
        }

        public String toString() {
            return "Enums.stringConverter(" + this.f19440c.getName() + ".class)";
        }
    }

    private k() {
    }

    @s1.c
    static <T extends Enum<T>> Map<String, WeakReference<? extends Enum<?>>> a(Class<T> cls) {
        Map<String, WeakReference<? extends Enum<?>>> mapD;
        Map<Class<? extends Enum<?>>, Map<String, WeakReference<? extends Enum<?>>>> map = f19438a;
        synchronized (map) {
            mapD = map.get(cls);
            if (mapD == null) {
                mapD = d(cls);
            }
        }
        return mapD;
    }

    @s1.c
    public static Field b(Enum<?> r7) {
        try {
            return r7.getDeclaringClass().getDeclaredField(r7.name());
        } catch (NoSuchFieldException e8) {
            throw new AssertionError(e8);
        }
    }

    public static <T extends Enum<T>> a0<T> c(Class<T> cls, String str) {
        e0.E(cls);
        e0.E(str);
        return d0.d(cls, str);
    }

    @s1.c
    private static <T extends Enum<T>> Map<String, WeakReference<? extends Enum<?>>> d(Class<T> cls) {
        HashMap map = new HashMap();
        for (Enum r7 : EnumSet.allOf(cls)) {
            map.put(r7.name(), new WeakReference(r7));
        }
        f19438a.put(cls, map);
        return map;
    }

    public static <T extends Enum<T>> i<String, T> e(Class<T> cls) {
        return new a(cls);
    }
}
