package com.google.common.reflect;

import com.google.common.base.e0;
import com.google.common.base.s;
import com.google.common.collect.d6;
import com.google.common.collect.u5;
import com.google.common.collect.ua;
import com.google.common.collect.v5;
import com.google.common.collect.wb;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
@s1.a
public final class f<B> extends u5<m<? extends B>, B> implements l<B> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<m<? extends B>, B> f22445a = wb.i0();

    private static final class b<K, V> extends v5<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Map.Entry<K, V> f22446a;

        static class a extends d6<Map.Entry<K, V>> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ Set f22447a;

            a(Set set) {
                this.f22447a = set;
            }

            @Override // com.google.common.collect.j5, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
            public Iterator<Map.Entry<K, V>> iterator() {
                return b.k0(super.iterator());
            }

            @Override // com.google.common.collect.j5, java.util.Collection, java.util.Set
            public Object[] toArray() {
                return q0();
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.common.collect.d6, com.google.common.collect.j5
            /* JADX INFO: renamed from: w0, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
            public Set<Map.Entry<K, V>> c0() {
                return this.f22447a;
            }

            @Override // com.google.common.collect.j5, java.util.Collection, java.util.Set
            public <T> T[] toArray(T[] tArr) {
                return (T[]) t0(tArr);
            }
        }

        /* JADX INFO: renamed from: com.google.common.reflect.f$b$b, reason: collision with other inner class name */
        static class C0288b implements s<Map.Entry<K, V>, Map.Entry<K, V>> {
            C0288b() {
            }

            @Override // com.google.common.base.s, java.util.function.Function
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Map.Entry<K, V> apply(Map.Entry<K, V> entry) {
                return new b(entry);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static <K, V> Iterator<Map.Entry<K, V>> k0(Iterator<Map.Entry<K, V>> it) {
            return ua.c0(it, new C0288b());
        }

        static <K, V> Set<Map.Entry<K, V>> m0(Set<Map.Entry<K, V>> set) {
            return new a(set);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.collect.v5, com.google.common.collect.b6
        /* JADX INFO: renamed from: d0 */
        public Map.Entry<K, V> c0() {
            return this.f22446a;
        }

        @Override // com.google.common.collect.v5, java.util.Map.Entry
        public V setValue(V v7) {
            throw new UnsupportedOperationException();
        }

        private b(Map.Entry<K, V> entry) {
            this.f22446a = (Map.Entry) e0.E(entry);
        }
    }

    private <T extends B> T u0(m<T> mVar) {
        return this.f22445a.get(mVar);
    }

    private <T extends B> T w0(m<T> mVar, T t7) {
        return this.f22445a.put(mVar, t7);
    }

    @Override // com.google.common.reflect.l
    @u1.a
    public <T extends B> T F(m<T> mVar, T t7) {
        return (T) w0(mVar.X(), t7);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.common.collect.u5, com.google.common.collect.b6
    /* JADX INFO: renamed from: d0 */
    public Map<m<? extends B>, B> c0() {
        return this.f22445a;
    }

    @Override // com.google.common.collect.u5, java.util.Map
    public Set<Map.Entry<m<? extends B>, B>> entrySet() {
        return b.m0(super.entrySet());
    }

    @Override // com.google.common.reflect.l
    @u1.a
    public <T extends B> T h(Class<T> cls, T t7) {
        return (T) w0(m.V(cls), t7);
    }

    @Override // com.google.common.reflect.l
    public <T extends B> T j(Class<T> cls) {
        return (T) u0(m.V(cls));
    }

    @Override // com.google.common.reflect.l
    public <T extends B> T p(m<T> mVar) {
        return (T) u0(mVar.X());
    }

    @Override // com.google.common.collect.u5, java.util.Map, com.google.common.collect.r0
    @Deprecated
    public void putAll(Map<? extends m<? extends B>, ? extends B> map) {
        throw new UnsupportedOperationException("Please use putInstance() instead.");
    }

    @Override // com.google.common.collect.u5, java.util.Map, com.google.common.collect.r0
    @u1.a
    @Deprecated
    /* JADX INFO: renamed from: t0, reason: merged with bridge method [inline-methods] */
    public B put(m<? extends B> mVar, B b8) {
        throw new UnsupportedOperationException("Please use putInstance() instead.");
    }
}
