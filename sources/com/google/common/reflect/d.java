package com.google.common.reflect;

import com.google.common.collect.u5;
import com.google.common.collect.v7;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@s1.a
public final class d<B> extends u5<m<? extends B>, B> implements l<B> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final v7<m<? extends B>, B> f22441a;

    @s1.a
    public static final class b<B> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final v7.b<m<? extends B>, B> f22442a;

        public d<B> a() {
            return new d<>(this.f22442a.a());
        }

        @u1.a
        public <T extends B> b<B> b(m<T> mVar, T t7) {
            this.f22442a.f(mVar.X(), t7);
            return this;
        }

        @u1.a
        public <T extends B> b<B> c(Class<T> cls, T t7) {
            this.f22442a.f(m.V(cls), t7);
            return this;
        }

        private b() {
            this.f22442a = v7.b();
        }
    }

    public static <B> b<B> t0() {
        return new b<>();
    }

    public static <B> d<B> u0() {
        return new d<>(v7.y());
    }

    private <T extends B> T x0(m<T> mVar) {
        return this.f22441a.get(mVar);
    }

    @Override // com.google.common.reflect.l
    @u1.a
    @Deprecated
    public <T extends B> T F(m<T> mVar, T t7) {
        throw new UnsupportedOperationException();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.common.collect.u5, com.google.common.collect.b6
    /* JADX INFO: renamed from: d0 */
    public Map<m<? extends B>, B> c0() {
        return this.f22441a;
    }

    @Override // com.google.common.reflect.l
    @u1.a
    @Deprecated
    public <T extends B> T h(Class<T> cls, T t7) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.reflect.l
    public <T extends B> T j(Class<T> cls) {
        return (T) x0(m.V(cls));
    }

    @Override // com.google.common.reflect.l
    public <T extends B> T p(m<T> mVar) {
        return (T) x0(mVar.X());
    }

    @Override // com.google.common.collect.u5, java.util.Map, com.google.common.collect.r0
    @Deprecated
    public void putAll(Map<? extends m<? extends B>, ? extends B> map) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.u5, java.util.Map, com.google.common.collect.r0
    @u1.a
    @Deprecated
    /* JADX INFO: renamed from: w0, reason: merged with bridge method [inline-methods] */
    public B put(m<? extends B> mVar, B b8) {
        throw new UnsupportedOperationException();
    }

    private d(v7<m<? extends B>, B> v7Var) {
        this.f22441a = v7Var;
    }
}
