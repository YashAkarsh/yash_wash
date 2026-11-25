package kotlin.collections;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
final class h1<K, V> implements g1<K, V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @a7.d
    private final Map<K, V> f34532a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @a7.d
    private final i5.l<K, V> f34533b;

    /* JADX WARN: Multi-variable type inference failed */
    public h1(@a7.d Map<K, V> map, @a7.d i5.l<? super K, ? extends V> lVar) {
        kotlin.jvm.internal.l0.p(map, "map");
        kotlin.jvm.internal.l0.p(lVar, "default");
        this.f34532a = map;
        this.f34533b = lVar;
    }

    @Override // kotlin.collections.x0
    public V A(K k7) {
        Map<K, V> mapV = v();
        V v7 = mapV.get(k7);
        return (v7 != null || mapV.containsKey(k7)) ? v7 : this.f34533b.z(k7);
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
        v().clear();
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
    @a7.e
    public V put(K k7, V v7) {
        return v().put(k7, v7);
    }

    @Override // java.util.Map
    public void putAll(@a7.d Map<? extends K, ? extends V> from) {
        kotlin.jvm.internal.l0.p(from, "from");
        v().putAll(from);
    }

    @Override // java.util.Map
    @a7.e
    public V remove(Object obj) {
        return v().remove(obj);
    }

    @Override // java.util.Map
    public final /* bridge */ int size() {
        return d();
    }

    @a7.d
    public String toString() {
        return v().toString();
    }

    @Override // kotlin.collections.g1, kotlin.collections.x0
    @a7.d
    public Map<K, V> v() {
        return this.f34532a;
    }

    @Override // java.util.Map
    public final /* bridge */ Collection<V> values() {
        return e();
    }
}
