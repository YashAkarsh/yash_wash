package com.google.common.collect;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.Spliterator;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@s1.c
public final class nd<B> extends u5<Class<? extends B>, B> implements v0<B>, Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<Class<? extends B>, B> f20757a;

    static class a extends v5<Class<? extends B>, B> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Map.Entry f20758a;

        a(Map.Entry entry) {
            this.f20758a = entry;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.collect.v5, com.google.common.collect.b6
        /* JADX INFO: renamed from: d0 */
        public Map.Entry<Class<? extends B>, B> c0() {
            return this.f20758a;
        }

        @Override // com.google.common.collect.v5, java.util.Map.Entry
        public B setValue(B b8) {
            return (B) super.setValue(nd.w0(getKey(), b8));
        }
    }

    class b extends d6<Map.Entry<Class<? extends B>, B>> {

        class a extends uj<Map.Entry<Class<? extends B>, B>, Map.Entry<Class<? extends B>, B>> {
            a(Iterator it) {
                super(it);
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // com.google.common.collect.uj
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public Map.Entry<Class<? extends B>, B> a(Map.Entry<Class<? extends B>, B> entry) {
                return nd.x0(entry);
            }
        }

        b() {
        }

        @Override // com.google.common.collect.j5, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
        public Iterator<Map.Entry<Class<? extends B>, B>> iterator() {
            return new a(c0().iterator());
        }

        @Override // java.util.Collection, java.lang.Iterable, java.util.Set
        public Spliterator<Map.Entry<Class<? extends B>, B>> spliterator() {
            return q2.e(c0().spliterator(), new Function() { // from class: com.google.common.collect.od
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return nd.x0((Map.Entry) obj);
                }
            });
        }

        @Override // com.google.common.collect.j5, java.util.Collection, java.util.Set
        public Object[] toArray() {
            return q0();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.collect.d6, com.google.common.collect.j5
        /* JADX INFO: renamed from: w0 */
        public Set<Map.Entry<Class<? extends B>, B>> c0() {
            return nd.this.c0().entrySet();
        }

        @Override // com.google.common.collect.j5, java.util.Collection, java.util.Set
        public <T> T[] toArray(T[] tArr) {
            return (T[]) t0(tArr);
        }
    }

    private static final class c<B> implements Serializable {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final long f20761b = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Map<Class<? extends B>, B> f20762a;

        c(Map<Class<? extends B>, B> map) {
            this.f20762a = map;
        }

        Object readResolve() {
            return nd.z0(this.f20762a);
        }
    }

    private nd(Map<Class<? extends B>, B> map) {
        this.f20757a = (Map) com.google.common.base.e0.E(map);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @u1.a
    public static <B, T extends B> T w0(Class<T> cls, B b8) {
        return (T) com.google.common.primitives.f0.f(cls).cast(b8);
    }

    private Object writeReplace() {
        return new c(c0());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <B> Map.Entry<Class<? extends B>, B> x0(Map.Entry<Class<? extends B>, B> entry) {
        return new a(entry);
    }

    public static <B> nd<B> y0() {
        return new nd<>(new HashMap());
    }

    public static <B> nd<B> z0(Map<Class<? extends B>, B> map) {
        return new nd<>(map);
    }

    @Override // com.google.common.collect.u5, java.util.Map, com.google.common.collect.r0
    @u1.a
    /* JADX INFO: renamed from: A0, reason: merged with bridge method [inline-methods] */
    public B put(Class<? extends B> cls, B b8) {
        return (B) super.put(cls, w0(cls, b8));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.common.collect.u5, com.google.common.collect.b6
    /* JADX INFO: renamed from: d0 */
    public Map<Class<? extends B>, B> c0() {
        return this.f20757a;
    }

    @Override // com.google.common.collect.u5, java.util.Map
    public Set<Map.Entry<Class<? extends B>, B>> entrySet() {
        return new b();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.v0
    @u1.a
    public <T extends B> T h(Class<T> cls, T t7) {
        return (T) w0(cls, put(cls, t7));
    }

    @Override // com.google.common.collect.v0
    public <T extends B> T j(Class<T> cls) {
        return (T) w0(cls, get(cls));
    }

    @Override // com.google.common.collect.u5, java.util.Map, com.google.common.collect.r0
    public void putAll(Map<? extends Class<? extends B>, ? extends B> map) {
        LinkedHashMap linkedHashMap = new LinkedHashMap(map);
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            w0((Class) entry.getKey(), entry.getValue());
        }
        super.putAll(linkedHashMap);
    }
}
