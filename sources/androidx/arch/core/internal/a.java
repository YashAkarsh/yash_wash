package androidx.arch.core.internal;

import c.m0;
import c.x0;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@x0({x0.a.LIBRARY_GROUP_PREFIX})
public class a<K, V> extends b<K, V> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private HashMap<K, b.c<K, V>> f2039e = new HashMap<>();

    @Override // androidx.arch.core.internal.b
    protected b.c<K, V> b(K k7) {
        return this.f2039e.get(k7);
    }

    public boolean contains(K k7) {
        return this.f2039e.containsKey(k7);
    }

    @Override // androidx.arch.core.internal.b
    public V h(@m0 K k7, @m0 V v7) {
        b.c<K, V> cVarB = b(k7);
        if (cVarB != null) {
            return cVarB.f2045b;
        }
        this.f2039e.put(k7, g(k7, v7));
        return null;
    }

    @Override // androidx.arch.core.internal.b
    public V j(@m0 K k7) {
        V v7 = (V) super.j(k7);
        this.f2039e.remove(k7);
        return v7;
    }

    public Map.Entry<K, V> k(K k7) {
        if (contains(k7)) {
            return this.f2039e.get(k7).f2047d;
        }
        return null;
    }
}
