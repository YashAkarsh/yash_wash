package com.bumptech.glide.load.engine.bitmap_recycle;

import com.bumptech.glide.load.engine.bitmap_recycle.h;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
class e<K extends h, V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final a<K, V> f14261a = new a<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map<K, a<K, V>> f14262b = new HashMap();

    private static class a<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final K f14263a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private List<V> f14264b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        a<K, V> f14265c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        a<K, V> f14266d;

        public a() {
            this(null);
        }

        public void b(V v7) {
            if (this.f14264b == null) {
                this.f14264b = new ArrayList();
            }
            this.f14264b.add(v7);
        }

        public V c() {
            int iD = d();
            if (iD > 0) {
                return this.f14264b.remove(iD - 1);
            }
            return null;
        }

        public int d() {
            List<V> list = this.f14264b;
            if (list != null) {
                return list.size();
            }
            return 0;
        }

        public a(K k7) {
            this.f14266d = this;
            this.f14265c = this;
            this.f14263a = k7;
        }
    }

    e() {
    }

    private void b(a<K, V> aVar) {
        e(aVar);
        a<K, V> aVar2 = this.f14261a;
        aVar.f14266d = aVar2;
        aVar.f14265c = aVar2.f14265c;
        g(aVar);
    }

    private void c(a<K, V> aVar) {
        e(aVar);
        a<K, V> aVar2 = this.f14261a;
        aVar.f14266d = aVar2.f14266d;
        aVar.f14265c = aVar2;
        g(aVar);
    }

    private static <K, V> void e(a<K, V> aVar) {
        a<K, V> aVar2 = aVar.f14266d;
        aVar2.f14265c = aVar.f14265c;
        aVar.f14265c.f14266d = aVar2;
    }

    private static <K, V> void g(a<K, V> aVar) {
        aVar.f14265c.f14266d = aVar;
        aVar.f14266d.f14265c = aVar;
    }

    public V a(K k7) {
        a<K, V> aVar = this.f14262b.get(k7);
        if (aVar == null) {
            aVar = new a<>(k7);
            this.f14262b.put(k7, aVar);
        } else {
            k7.a();
        }
        b(aVar);
        return aVar.c();
    }

    public void d(K k7, V v7) {
        a<K, V> aVar = this.f14262b.get(k7);
        if (aVar == null) {
            aVar = new a<>(k7);
            c(aVar);
            this.f14262b.put(k7, aVar);
        } else {
            k7.a();
        }
        aVar.b(v7);
    }

    public V f() {
        for (a aVar = this.f14261a.f14266d; !aVar.equals(this.f14261a); aVar = aVar.f14266d) {
            V v7 = (V) aVar.c();
            if (v7 != null) {
                return v7;
            }
            e(aVar);
            this.f14262b.remove(aVar.f14263a);
            ((h) aVar.f14263a).a();
        }
        return null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("GroupedLinkedMap( ");
        a aVar = this.f14261a.f14265c;
        boolean z7 = false;
        while (!aVar.equals(this.f14261a)) {
            sb.append('{');
            sb.append(aVar.f14263a);
            sb.append(':');
            sb.append(aVar.d());
            sb.append("}, ");
            aVar = aVar.f14265c;
            z7 = true;
        }
        if (z7) {
            sb.delete(sb.length() - 2, sb.length());
        }
        sb.append(" )");
        return sb.toString();
    }
}
