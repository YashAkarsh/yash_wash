package kotlin.collections;

import java.util.Map;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes2.dex */
class a1 {
    @h5.h(name = "getOrImplicitDefaultNullable")
    @kotlin.a1
    public static final <K, V> V a(@a7.d Map<K, ? extends V> map, K k7) {
        kotlin.jvm.internal.l0.p(map, "<this>");
        if (map instanceof x0) {
            return (V) ((x0) map).A(k7);
        }
        V v7 = map.get(k7);
        if (v7 != null || map.containsKey(k7)) {
            return v7;
        }
        throw new NoSuchElementException("Key " + k7 + " is missing in the map.");
    }

    @a7.d
    public static final <K, V> Map<K, V> b(@a7.d Map<K, ? extends V> map, @a7.d i5.l<? super K, ? extends V> defaultValue) {
        kotlin.jvm.internal.l0.p(map, "<this>");
        kotlin.jvm.internal.l0.p(defaultValue, "defaultValue");
        return map instanceof x0 ? b(((x0) map).v(), defaultValue) : new y0(map, defaultValue);
    }

    @a7.d
    @h5.h(name = "withDefaultMutable")
    public static final <K, V> Map<K, V> c(@a7.d Map<K, V> map, @a7.d i5.l<? super K, ? extends V> defaultValue) {
        kotlin.jvm.internal.l0.p(map, "<this>");
        kotlin.jvm.internal.l0.p(defaultValue, "defaultValue");
        return map instanceof g1 ? c(((g1) map).v(), defaultValue) : new h1(map, defaultValue);
    }
}
