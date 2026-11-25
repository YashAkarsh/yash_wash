package b0;

import java.util.TreeMap;

/* JADX INFO: loaded from: classes.dex */
public class a<K, V> extends TreeMap<K, V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f11263a;

    public a(String str) {
        this.f11263a = str;
    }

    @Override // java.util.TreeMap, java.util.AbstractMap, java.util.Map
    public V put(K k7, V v7) {
        if (containsKey(k7)) {
            throw new RuntimeException(String.format(this.f11263a, k7));
        }
        return (V) super.put(k7, v7);
    }
}
