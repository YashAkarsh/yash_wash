package kotlin.collections;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
final class y0<K, V> implements x0<K, V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @a7.d
    private final Map<K, V> f34634a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @a7.d
    private final i5.l<K, V> f34635b;

    /* JADX WARN: Multi-variable type inference failed */
    public y0(@a7.d Map<K, ? extends V> map, @a7.d i5.l<? super K, ? extends V> lVar) {
        kotlin.jvm.internal.l0.p(map, "map");
        kotlin.jvm.internal.l0.p(lVar, "default");
        this.f34634a = map;
        this.f34635b = lVar;
    }

    @Override // kotlin.collections.x0
    public V A(K k7) {
        Map<K, V> mapV = v();
        V v7 = mapV.get(k7);
        return (v7 != null || mapV.containsKey(k7)) ? v7 : this.f34635b.z(k7);
    }

    @a7.d
    public Set<Map.Entry<K, V>> a() {
        return v().entrySet();
    }

    @a7.d
    public Set<K> b() {
        return v().keySet();
    }

    @Override // java.util.Map
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        return v().containsKey(obj);
    }

    @Override // java.util.Map
    public boolean containsValue(Object obj) {
        return v().containsValue(obj);
    }

    public int d() {
        return v().size();
    }

    @a7.d
    public Collection<V> e() {
        return v().values();
    }

    @Override // java.util.Map
    public final /* bridge */ Set<Map.Entry<K, V>> entrySet() {
        return a();
    }

    @Override // java.util.Map
    public boolean equals(@a7.e Object obj) {
        return v().equals(obj);
    }

    @Override // java.util.Map
    @a7.e
    public V get(Object obj) {
        return v().get(obj);
    }

    @Override // java.util.Map
    public int hashCode() {
        return v().hashCode();
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return v().isEmpty();
    }

    @Override // java.util.Map
    public final /* bridge */ Set<K> keySet() {
        return b();
    }

    @Override // java.util.Map
    public V put(K k7, V v7) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public void putAll(Map<? extends K, ? extends V> map) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public V remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final /* bridge */ int size() {
        return d();
    }

    @a7.d
    public String toString() {
        return v().toString();
    }

    @Override // kotlin.collections.x0
    @a7.d
    public Map<K, V> v() {
        return this.f34634a;
    }

    @Override // java.util.Map
    public final /* bridge */ Collection<V> values() {
        return e();
    }
}
