package com.google.common.collect;

import java.io.Serializable;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@s1.c
public final class w6<B> extends u5<Class<? extends B>, B> implements v0<B>, Serializable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final w6<Object> f21297b = new w6<>(v7.y());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final v7<Class<? extends B>, B> f21298a;

    public static final class b<B> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final v7.b<Class<? extends B>, B> f21299a = v7.b();

        private static <B, T extends B> T b(Class<T> cls, B b8) {
            return (T) com.google.common.primitives.f0.f(cls).cast(b8);
        }

        public w6<B> a() {
            v7<Class<? extends B>, B> v7VarA = this.f21299a.a();
            return v7VarA.isEmpty() ? w6.w0() : new w6<>(v7VarA);
        }

        @u1.a
        public <T extends B> b<B> c(Class<T> cls, T t7) {
            this.f21299a.f(cls, t7);
            return this;
        }

        @u1.a
        public <T extends B> b<B> d(Map<? extends Class<? extends T>, ? extends T> map) {
            for (Map.Entry<? extends Class<? extends T>, ? extends T> entry : map.entrySet()) {
                Class key = entry.getKey();
                T value = entry.getValue();
                this.f21299a.f((Class<? extends B>) key, (B) b(key, value));
            }
            return this;
        }
    }

    public static <B> b<B> t0() {
        return new b<>();
    }

    public static <B, S extends B> w6<B> u0(Map<? extends Class<? extends S>, ? extends S> map) {
        return map instanceof w6 ? (w6) map : new b().d(map).a();
    }

    public static <B> w6<B> w0() {
        return (w6<B>) f21297b;
    }

    public static <B, T extends B> w6<B> x0(Class<T> cls, T t7) {
        return new w6<>(v7.z(cls, t7));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.common.collect.u5, com.google.common.collect.b6
    /* JADX INFO: renamed from: d0 */
    public Map<Class<? extends B>, B> c0() {
        return this.f21298a;
    }

    @Override // com.google.common.collect.v0
    @u1.a
    @Deprecated
    public <T extends B> T h(Class<T> cls, T t7) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.v0
    public <T extends B> T j(Class<T> cls) {
        return this.f21298a.get(com.google.common.base.e0.E(cls));
    }

    Object readResolve() {
        return isEmpty() ? w0() : this;
    }

    private w6(v7<Class<? extends B>, B> v7Var) {
        this.f21298a = v7Var;
    }
}
