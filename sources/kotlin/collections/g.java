package kotlin.collections;

import java.util.AbstractMap;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
@kotlin.g1(version = "1.1")
public abstract class g<K, V> extends AbstractMap<K, V> implements Map<K, V>, j5.g {
    protected g() {
    }

    public abstract Set a();

    public /* bridge */ Set<Object> b() {
        return super.keySet();
    }

    public /* bridge */ int d() {
        return super.size();
    }

    public /* bridge */ Collection<Object> e() {
        return super.values();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final /* bridge */ Set<Map.Entry<K, V>> entrySet() {
        return a();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final /* bridge */ Set<K> keySet() {
        return (Set<K>) b();
    }

    @Override // java.util.AbstractMap, java.util.Map
    @a7.e
    public abstract V put(K k7, V v7);

    @Override // java.util.AbstractMap, java.util.Map
    public final /* bridge */ int size() {
        return d();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final /* bridge */ Collection<V> values() {
        return (Collection<V>) e();
    }
}
