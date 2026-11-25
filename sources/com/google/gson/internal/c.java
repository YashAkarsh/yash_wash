package com.google.gson.internal;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;

/* JADX INFO: loaded from: classes2.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<Type, com.google.gson.h<?>> f23146a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.google.gson.internal.reflect.b f23147b = com.google.gson.internal.reflect.b.a();

    /* JADX INFO: Add missing generic type declarations: [T] */
    class a<T> implements com.google.gson.internal.j<T> {
        a() {
        }

        @Override // com.google.gson.internal.j
        public T a() {
            return (T) new ConcurrentHashMap();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    class b<T> implements com.google.gson.internal.j<T> {
        b() {
        }

        @Override // com.google.gson.internal.j
        public T a() {
            return (T) new TreeMap();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: com.google.gson.internal.c$c, reason: collision with other inner class name */
    class C0306c<T> implements com.google.gson.internal.j<T> {
        C0306c() {
        }

        @Override // com.google.gson.internal.j
        public T a() {
            return (T) new LinkedHashMap();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    class d<T> implements com.google.gson.internal.j<T> {
        d() {
        }

        @Override // com.google.gson.internal.j
        public T a() {
            return (T) new com.google.gson.internal.i();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    class e<T> implements com.google.gson.internal.j<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final com.google.gson.internal.n f23152a = com.google.gson.internal.n.b();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Class f23153b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Type f23154c;

        e(Class cls, Type type) {
            this.f23153b = cls;
            this.f23154c = type;
        }

        @Override // com.google.gson.internal.j
        public T a() {
            try {
                return (T) this.f23152a.c(this.f23153b);
            } catch (Exception e8) {
                throw new RuntimeException("Unable to invoke no-args constructor for " + this.f23154c + ". Registering an InstanceCreator with Gson for this type may fix this problem.", e8);
            }
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    class f<T> implements com.google.gson.internal.j<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.google.gson.h f23156a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Type f23157b;

        f(com.google.gson.h hVar, Type type) {
            this.f23156a = hVar;
            this.f23157b = type;
        }

        @Override // com.google.gson.internal.j
        public T a() {
            return (T) this.f23156a.a(this.f23157b);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    class g<T> implements com.google.gson.internal.j<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.google.gson.h f23159a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Type f23160b;

        g(com.google.gson.h hVar, Type type) {
            this.f23159a = hVar;
            this.f23160b = type;
        }

        @Override // com.google.gson.internal.j
        public T a() {
            return (T) this.f23159a.a(this.f23160b);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    class h<T> implements com.google.gson.internal.j<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Constructor f23162a;

        h(Constructor constructor) {
            this.f23162a = constructor;
        }

        @Override // com.google.gson.internal.j
        public T a() {
            try {
                return (T) this.f23162a.newInstance(null);
            } catch (IllegalAccessException e8) {
                throw new AssertionError(e8);
            } catch (InstantiationException e9) {
                throw new RuntimeException("Failed to invoke " + this.f23162a + " with no args", e9);
            } catch (InvocationTargetException e10) {
                throw new RuntimeException("Failed to invoke " + this.f23162a + " with no args", e10.getTargetException());
            }
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    class i<T> implements com.google.gson.internal.j<T> {
        i() {
        }

        @Override // com.google.gson.internal.j
        public T a() {
            return (T) new TreeSet();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    class j<T> implements com.google.gson.internal.j<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Type f23165a;

        j(Type type) {
            this.f23165a = type;
        }

        @Override // com.google.gson.internal.j
        public T a() {
            Type type = this.f23165a;
            if (!(type instanceof ParameterizedType)) {
                throw new com.google.gson.m("Invalid EnumSet type: " + this.f23165a.toString());
            }
            Type type2 = ((ParameterizedType) type).getActualTypeArguments()[0];
            if (type2 instanceof Class) {
                return (T) EnumSet.noneOf((Class) type2);
            }
            throw new com.google.gson.m("Invalid EnumSet type: " + this.f23165a.toString());
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    class k<T> implements com.google.gson.internal.j<T> {
        k() {
        }

        @Override // com.google.gson.internal.j
        public T a() {
            return (T) new LinkedHashSet();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    class l<T> implements com.google.gson.internal.j<T> {
        l() {
        }

        @Override // com.google.gson.internal.j
        public T a() {
            return (T) new ArrayDeque();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    class m<T> implements com.google.gson.internal.j<T> {
        m() {
        }

        @Override // com.google.gson.internal.j
        public T a() {
            return (T) new ArrayList();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    class n<T> implements com.google.gson.internal.j<T> {
        n() {
        }

        @Override // com.google.gson.internal.j
        public T a() {
            return (T) new ConcurrentSkipListMap();
        }
    }

    public c(Map<Type, com.google.gson.h<?>> map) {
        this.f23146a = map;
    }

    private <T> com.google.gson.internal.j<T> b(Class<? super T> cls) {
        try {
            Constructor<? super T> declaredConstructor = cls.getDeclaredConstructor(new Class[0]);
            if (!declaredConstructor.isAccessible()) {
                this.f23147b.b(declaredConstructor);
            }
            return new h(declaredConstructor);
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }

    private <T> com.google.gson.internal.j<T> c(Type type, Class<? super T> cls) {
        if (Collection.class.isAssignableFrom(cls)) {
            if (SortedSet.class.isAssignableFrom(cls)) {
                return new i();
            }
            if (EnumSet.class.isAssignableFrom(cls)) {
                return new j(type);
            }
            if (Set.class.isAssignableFrom(cls)) {
                return new k();
            }
            return Queue.class.isAssignableFrom(cls) ? new l() : new m();
        }
        if (!Map.class.isAssignableFrom(cls)) {
            return null;
        }
        if (ConcurrentNavigableMap.class.isAssignableFrom(cls)) {
            return new n();
        }
        if (ConcurrentMap.class.isAssignableFrom(cls)) {
            return new a();
        }
        if (SortedMap.class.isAssignableFrom(cls)) {
            return new b();
        }
        return (!(type instanceof ParameterizedType) || String.class.isAssignableFrom(com.google.gson.reflect.a.get(((ParameterizedType) type).getActualTypeArguments()[0]).getRawType())) ? new d() : new C0306c();
    }

    private <T> com.google.gson.internal.j<T> d(Type type, Class<? super T> cls) {
        return new e(cls, type);
    }

    public <T> com.google.gson.internal.j<T> a(com.google.gson.reflect.a<T> aVar) {
        Type type = aVar.getType();
        Class<? super T> rawType = aVar.getRawType();
        com.google.gson.h<?> hVar = this.f23146a.get(type);
        if (hVar != null) {
            return new f(hVar, type);
        }
        com.google.gson.h<?> hVar2 = this.f23146a.get(rawType);
        if (hVar2 != null) {
            return new g(hVar2, type);
        }
        com.google.gson.internal.j<T> jVarB = b(rawType);
        if (jVarB != null) {
            return jVarB;
        }
        com.google.gson.internal.j<T> jVarC = c(type, rawType);
        return jVarC != null ? jVarC : d(type, rawType);
    }

    public String toString() {
        return this.f23146a.toString();
    }
}
