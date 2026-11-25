package com.haier.uhome.usdk.c;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated
abstract class a<K, V> implements Map<K, V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final long f31962a = 60000;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final long f31963b = 500;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ConcurrentHashMap<K, a<K, V>.b> f31964c;

    /* JADX INFO: renamed from: com.haier.uhome.usdk.c.a$a, reason: collision with other inner class name */
    public abstract class AbstractRunnableC0384a implements Runnable {
        public AbstractRunnableC0384a() {
        }

        public abstract boolean a();

        public void b() {
            com.haier.uhome.usdk.api.b.b.a().a(this);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a()) {
                com.haier.uhome.usdk.api.b.b.a().a(this, a.f31963b);
            } else {
                e3.a.v("negative regular do!!", new Object[0]);
            }
        }
    }

    class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        V f31968a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        com.haier.uhome.usdk.a.b f31969b;

        b(V v7, com.haier.uhome.usdk.a.b bVar) {
            this.f31968a = v7;
            this.f31969b = bVar;
        }
    }

    public a() {
        this.f31964c = new ConcurrentHashMap<>();
    }

    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public abstract void c(K k7, V v7);

    @Override // java.util.Map
    public void clear() {
        this.f31964c.clear();
    }

    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        return this.f31964c.containsKey(obj);
    }

    @Override // java.util.Map
    public boolean containsValue(Object obj) {
        return this.f31964c.containsValue(obj);
    }

    @Override // java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        e3.a.h("not support", new Object[0]);
        return null;
    }

    @Override // java.util.Map
    public V get(Object obj) {
        a<K, V>.b bVar = this.f31964c.get(obj);
        if (bVar == null) {
            return null;
        }
        return bVar.f31968a;
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return this.f31964c.isEmpty();
    }

    @Override // java.util.Map
    public Set keySet() {
        return this.f31964c.keySet();
    }

    @Override // java.util.Map
    public V put(K k7, V v7) {
        return a(k7, v7, new com.haier.uhome.usdk.a.c(60000L));
    }

    @Override // java.util.Map
    public void putAll(Map map) {
        this.f31964c.putAll(map);
    }

    @Override // java.util.Map
    public V remove(Object obj) {
        a<K, V>.b bVarRemove = this.f31964c.remove(obj);
        if (bVarRemove == null) {
            return null;
        }
        return bVarRemove.f31968a;
    }

    @Override // java.util.Map
    public int size() {
        return this.f31964c.size();
    }

    @Override // java.util.Map
    public Collection values() {
        return this.f31964c.values();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final K k7, final V v7) {
        com.haier.library.common.thread.a.b().c(new Runnable() { // from class: com.haier.uhome.usdk.c.i
            @Override // java.lang.Runnable
            public final void run() {
                this.f32061a.c(k7, v7);
            }
        });
    }

    public a(int i7) {
        this.f31964c = new ConcurrentHashMap<>(i7);
    }

    public V a(final K k7, V v7, com.haier.uhome.usdk.a.b bVar) {
        if (k7 != null && v7 != null) {
            a<K, V>.b bVarPut = this.f31964c.put(k7, new b(v7, bVar));
            new a<K, V>.AbstractRunnableC0384a() { // from class: com.haier.uhome.usdk.c.a.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super();
                }

                @Override // com.haier.uhome.usdk.c.a.AbstractRunnableC0384a
                public boolean a() {
                    b bVar2 = (b) a.this.f31964c.get(k7);
                    if (bVar2 == null) {
                        return false;
                    }
                    if (!bVar2.f31969b.isTimeout()) {
                        return true;
                    }
                    a.this.f31964c.remove(k7);
                    V v8 = bVar2.f31968a;
                    if (v8 != null) {
                        a.this.b(k7, v8);
                    }
                    return false;
                }
            }.b();
            if (bVarPut == null) {
                return null;
            }
            return bVarPut.f31968a;
        }
        throw null;
    }
}
