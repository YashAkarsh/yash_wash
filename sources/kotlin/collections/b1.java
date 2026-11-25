package kotlin.collections;

import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.Properties;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentMap;
import kotlin.l2;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: loaded from: classes2.dex */
public class b1 extends a1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int f34464a = 1073741824;

    @a7.d
    @kotlin.g1(version = "1.3")
    @kotlin.a1
    public static <K, V> Map<K, V> d(@a7.d Map<K, V> builder) {
        kotlin.jvm.internal.l0.p(builder, "builder");
        return ((kotlin.collections.builders.d) builder).l();
    }

    @kotlin.g1(version = "1.3")
    @kotlin.a1
    @kotlin.internal.f
    private static final <K, V> Map<K, V> e(int i7, i5.l<? super Map<K, V>, l2> builderAction) {
        kotlin.jvm.internal.l0.p(builderAction, "builderAction");
        Map mapH = h(i7);
        builderAction.z(mapH);
        return d(mapH);
    }

    @kotlin.g1(version = "1.3")
    @kotlin.a1
    @kotlin.internal.f
    private static final <K, V> Map<K, V> f(i5.l<? super Map<K, V>, l2> builderAction) {
        kotlin.jvm.internal.l0.p(builderAction, "builderAction");
        Map mapG = g();
        builderAction.z(mapG);
        return d(mapG);
    }

    @a7.d
    @kotlin.g1(version = "1.3")
    @kotlin.a1
    public static final <K, V> Map<K, V> g() {
        return new kotlin.collections.builders.d();
    }

    @a7.d
    @kotlin.g1(version = "1.3")
    @kotlin.a1
    public static <K, V> Map<K, V> h(int i7) {
        return new kotlin.collections.builders.d(i7);
    }

    public static final <K, V> V i(@a7.d ConcurrentMap<K, V> concurrentMap, K k7, @a7.d i5.a<? extends V> defaultValue) {
        kotlin.jvm.internal.l0.p(concurrentMap, "<this>");
        kotlin.jvm.internal.l0.p(defaultValue, "defaultValue");
        V v7 = concurrentMap.get(k7);
        if (v7 != null) {
            return v7;
        }
        V vInvoke = defaultValue.invoke();
        V vPutIfAbsent = concurrentMap.putIfAbsent(k7, vInvoke);
        return vPutIfAbsent == null ? vInvoke : vPutIfAbsent;
    }

    @kotlin.a1
    public static int j(int i7) {
        if (i7 < 0) {
            return i7;
        }
        if (i7 < 3) {
            return i7 + 1;
        }
        if (i7 < 1073741824) {
            return (int) ((i7 / 0.75f) + 1.0f);
        }
        return Integer.MAX_VALUE;
    }

    @a7.d
    public static final <K, V> Map<K, V> k(@a7.d kotlin.u0<? extends K, ? extends V> pair) {
        kotlin.jvm.internal.l0.p(pair, "pair");
        Map<K, V> mapSingletonMap = Collections.singletonMap(pair.e(), pair.f());
        kotlin.jvm.internal.l0.o(mapSingletonMap, "singletonMap(pair.first, pair.second)");
        return mapSingletonMap;
    }

    @a7.d
    @kotlin.g1(version = "1.4")
    public static final <K, V> SortedMap<K, V> l(@a7.d Comparator<? super K> comparator, @a7.d kotlin.u0<? extends K, ? extends V>... pairs) {
        kotlin.jvm.internal.l0.p(comparator, "comparator");
        kotlin.jvm.internal.l0.p(pairs, "pairs");
        TreeMap treeMap = new TreeMap(comparator);
        c1.y0(treeMap, pairs);
        return treeMap;
    }

    @a7.d
    public static final <K extends Comparable<? super K>, V> SortedMap<K, V> m(@a7.d kotlin.u0<? extends K, ? extends V>... pairs) {
        kotlin.jvm.internal.l0.p(pairs, "pairs");
        TreeMap treeMap = new TreeMap();
        c1.y0(treeMap, pairs);
        return treeMap;
    }

    @kotlin.internal.f
    private static final Properties n(Map<String, String> map) {
        kotlin.jvm.internal.l0.p(map, "<this>");
        Properties properties = new Properties();
        properties.putAll(map);
        return properties;
    }

    @a7.d
    public static final <K, V> Map<K, V> o(@a7.d Map<? extends K, ? extends V> map) {
        kotlin.jvm.internal.l0.p(map, "<this>");
        Map.Entry<? extends K, ? extends V> next = map.entrySet().iterator().next();
        Map<K, V> mapSingletonMap = Collections.singletonMap(next.getKey(), next.getValue());
        kotlin.jvm.internal.l0.o(mapSingletonMap, "with(entries.iterator().…ingletonMap(key, value) }");
        return mapSingletonMap;
    }

    @kotlin.internal.f
    private static final <K, V> Map<K, V> p(Map<K, ? extends V> map) {
        kotlin.jvm.internal.l0.p(map, "<this>");
        return o(map);
    }

    @a7.d
    public static final <K extends Comparable<? super K>, V> SortedMap<K, V> q(@a7.d Map<? extends K, ? extends V> map) {
        kotlin.jvm.internal.l0.p(map, "<this>");
        return new TreeMap(map);
    }

    @a7.d
    public static final <K, V> SortedMap<K, V> r(@a7.d Map<? extends K, ? extends V> map, @a7.d Comparator<? super K> comparator) {
        kotlin.jvm.internal.l0.p(map, "<this>");
        kotlin.jvm.internal.l0.p(comparator, "comparator");
        TreeMap treeMap = new TreeMap(comparator);
        treeMap.putAll(map);
        return treeMap;
    }
}
