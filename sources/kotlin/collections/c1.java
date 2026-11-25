package kotlin.collections;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.l2;
import kotlin.q2;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: loaded from: classes2.dex */
public class c1 extends b1 {
    @a7.d
    public static final <K, V> Map<K, V> A(@a7.d Map<? extends K, ? extends V> map, @a7.d i5.l<? super Map.Entry<? extends K, ? extends V>, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(map, "<this>");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            if (predicate.z(entry).booleanValue()) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return linkedHashMap;
    }

    @kotlin.internal.f
    private static final <K, V> void A0(Map<K, V> map, K k7, V v7) {
        kotlin.jvm.internal.l0.p(map, "<this>");
        map.put(k7, v7);
    }

    @a7.d
    public static final <K, V> Map<K, V> B(@a7.d Map<? extends K, ? extends V> map, @a7.d i5.l<? super K, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(map, "<this>");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            if (predicate.z(entry.getKey()).booleanValue()) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return linkedHashMap;
    }

    @a7.d
    public static <K, V> Map<K, V> B0(@a7.d Iterable<? extends kotlin.u0<? extends K, ? extends V>> iterable) {
        kotlin.jvm.internal.l0.p(iterable, "<this>");
        if (!(iterable instanceof Collection)) {
            return k0(C0(iterable, new LinkedHashMap()));
        }
        Collection collection = (Collection) iterable;
        int size = collection.size();
        if (size == 0) {
            return z();
        }
        if (size != 1) {
            return C0(iterable, new LinkedHashMap(b1.j(collection.size())));
        }
        return b1.k(iterable instanceof List ? (kotlin.u0<? extends K, ? extends V>) ((List) iterable).get(0) : iterable.iterator().next());
    }

    @a7.d
    public static final <K, V> Map<K, V> C(@a7.d Map<? extends K, ? extends V> map, @a7.d i5.l<? super Map.Entry<? extends K, ? extends V>, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(map, "<this>");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            if (!predicate.z(entry).booleanValue()) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return linkedHashMap;
    }

    @a7.d
    public static final <K, V, M extends Map<? super K, ? super V>> M C0(@a7.d Iterable<? extends kotlin.u0<? extends K, ? extends V>> iterable, @a7.d M destination) {
        kotlin.jvm.internal.l0.p(iterable, "<this>");
        kotlin.jvm.internal.l0.p(destination, "destination");
        w0(destination, iterable);
        return destination;
    }

    @a7.d
    public static final <K, V, M extends Map<? super K, ? super V>> M D(@a7.d Map<? extends K, ? extends V> map, @a7.d M destination, @a7.d i5.l<? super Map.Entry<? extends K, ? extends V>, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(map, "<this>");
        kotlin.jvm.internal.l0.p(destination, "destination");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            if (!predicate.z(entry).booleanValue()) {
                destination.put(entry.getKey(), entry.getValue());
            }
        }
        return destination;
    }

    @a7.d
    @kotlin.g1(version = "1.1")
    public static <K, V> Map<K, V> D0(@a7.d Map<? extends K, ? extends V> map) {
        kotlin.jvm.internal.l0.p(map, "<this>");
        int size = map.size();
        if (size != 0) {
            return size != 1 ? J0(map) : b1.o(map);
        }
        return z();
    }

    @a7.d
    public static final <K, V, M extends Map<? super K, ? super V>> M E(@a7.d Map<? extends K, ? extends V> map, @a7.d M destination, @a7.d i5.l<? super Map.Entry<? extends K, ? extends V>, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(map, "<this>");
        kotlin.jvm.internal.l0.p(destination, "destination");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            if (predicate.z(entry).booleanValue()) {
                destination.put(entry.getKey(), entry.getValue());
            }
        }
        return destination;
    }

    @a7.d
    @kotlin.g1(version = "1.1")
    public static final <K, V, M extends Map<? super K, ? super V>> M E0(@a7.d Map<? extends K, ? extends V> map, @a7.d M destination) {
        kotlin.jvm.internal.l0.p(map, "<this>");
        kotlin.jvm.internal.l0.p(destination, "destination");
        destination.putAll(map);
        return destination;
    }

    @a7.d
    public static final <K, V> Map<K, V> F(@a7.d Map<? extends K, ? extends V> map, @a7.d i5.l<? super V, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(map, "<this>");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            if (predicate.z(entry.getValue()).booleanValue()) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return linkedHashMap;
    }

    @a7.d
    public static final <K, V> Map<K, V> F0(@a7.d kotlin.sequences.m<? extends kotlin.u0<? extends K, ? extends V>> mVar) {
        kotlin.jvm.internal.l0.p(mVar, "<this>");
        return k0(G0(mVar, new LinkedHashMap()));
    }

    @kotlin.internal.f
    private static final <K, V> V G(Map<? extends K, ? extends V> map, K k7) {
        kotlin.jvm.internal.l0.p(map, "<this>");
        return map.get(k7);
    }

    @a7.d
    public static final <K, V, M extends Map<? super K, ? super V>> M G0(@a7.d kotlin.sequences.m<? extends kotlin.u0<? extends K, ? extends V>> mVar, @a7.d M destination) {
        kotlin.jvm.internal.l0.p(mVar, "<this>");
        kotlin.jvm.internal.l0.p(destination, "destination");
        x0(destination, mVar);
        return destination;
    }

    @kotlin.internal.f
    private static final <K, V> V H(Map<K, ? extends V> map, K k7, i5.a<? extends V> defaultValue) {
        kotlin.jvm.internal.l0.p(map, "<this>");
        kotlin.jvm.internal.l0.p(defaultValue, "defaultValue");
        V v7 = map.get(k7);
        return v7 == null ? defaultValue.invoke() : v7;
    }

    @a7.d
    public static final <K, V> Map<K, V> H0(@a7.d kotlin.u0<? extends K, ? extends V>[] u0VarArr) {
        kotlin.jvm.internal.l0.p(u0VarArr, "<this>");
        int length = u0VarArr.length;
        if (length != 0) {
            return length != 1 ? I0(u0VarArr, new LinkedHashMap(b1.j(u0VarArr.length))) : b1.k(u0VarArr[0]);
        }
        return z();
    }

    public static final <K, V> V I(@a7.d Map<K, ? extends V> map, K k7, @a7.d i5.a<? extends V> defaultValue) {
        kotlin.jvm.internal.l0.p(map, "<this>");
        kotlin.jvm.internal.l0.p(defaultValue, "defaultValue");
        V v7 = map.get(k7);
        return (v7 != null || map.containsKey(k7)) ? v7 : defaultValue.invoke();
    }

    @a7.d
    public static final <K, V, M extends Map<? super K, ? super V>> M I0(@a7.d kotlin.u0<? extends K, ? extends V>[] u0VarArr, @a7.d M destination) {
        kotlin.jvm.internal.l0.p(u0VarArr, "<this>");
        kotlin.jvm.internal.l0.p(destination, "destination");
        y0(destination, u0VarArr);
        return destination;
    }

    public static final <K, V> V J(@a7.d Map<K, V> map, K k7, @a7.d i5.a<? extends V> defaultValue) {
        kotlin.jvm.internal.l0.p(map, "<this>");
        kotlin.jvm.internal.l0.p(defaultValue, "defaultValue");
        V v7 = map.get(k7);
        if (v7 != null) {
            return v7;
        }
        V vInvoke = defaultValue.invoke();
        map.put(k7, vInvoke);
        return vInvoke;
    }

    @a7.d
    @kotlin.g1(version = "1.1")
    public static <K, V> Map<K, V> J0(@a7.d Map<? extends K, ? extends V> map) {
        kotlin.jvm.internal.l0.p(map, "<this>");
        return new LinkedHashMap(map);
    }

    @kotlin.g1(version = "1.1")
    public static final <K, V> V K(@a7.d Map<K, ? extends V> map, K k7) {
        kotlin.jvm.internal.l0.p(map, "<this>");
        return (V) a1.a(map, k7);
    }

    @kotlin.internal.f
    private static final <K, V> kotlin.u0<K, V> K0(Map.Entry<? extends K, ? extends V> entry) {
        kotlin.jvm.internal.l0.p(entry, "<this>");
        return new kotlin.u0<>(entry.getKey(), entry.getValue());
    }

    @kotlin.g1(version = "1.1")
    @kotlin.internal.f
    private static final <K, V> HashMap<K, V> L() {
        return new HashMap<>();
    }

    @a7.d
    public static final <K, V> HashMap<K, V> M(@a7.d kotlin.u0<? extends K, ? extends V>... pairs) {
        kotlin.jvm.internal.l0.p(pairs, "pairs");
        HashMap<K, V> map = new HashMap<>(b1.j(pairs.length));
        y0(map, pairs);
        return map;
    }

    /* JADX WARN: Incorrect types in method signature: <M::Ljava/util/Map<**>;:TR;R:Ljava/lang/Object;>(TM;Li5/a<+TR;>;)TR; */
    @kotlin.g1(version = "1.3")
    @kotlin.internal.f
    private static final Object N(Map map, i5.a defaultValue) {
        kotlin.jvm.internal.l0.p(defaultValue, "defaultValue");
        return map.isEmpty() ? defaultValue.invoke() : map;
    }

    @kotlin.internal.f
    private static final <K, V> boolean O(Map<? extends K, ? extends V> map) {
        kotlin.jvm.internal.l0.p(map, "<this>");
        return !map.isEmpty();
    }

    @kotlin.g1(version = "1.3")
    @kotlin.internal.f
    private static final <K, V> boolean P(Map<? extends K, ? extends V> map) {
        return map == null || map.isEmpty();
    }

    @kotlin.internal.f
    private static final <K, V> Iterator<Map.Entry<K, V>> Q(Map<? extends K, ? extends V> map) {
        kotlin.jvm.internal.l0.p(map, "<this>");
        return map.entrySet().iterator();
    }

    @kotlin.g1(version = "1.1")
    @kotlin.internal.f
    private static final <K, V> LinkedHashMap<K, V> R() {
        return new LinkedHashMap<>();
    }

    @a7.d
    public static final <K, V> LinkedHashMap<K, V> S(@a7.d kotlin.u0<? extends K, ? extends V>... pairs) {
        kotlin.jvm.internal.l0.p(pairs, "pairs");
        return (LinkedHashMap) I0(pairs, new LinkedHashMap(b1.j(pairs.length)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @a7.d
    public static final <K, V, R> Map<R, V> T(@a7.d Map<? extends K, ? extends V> map, @a7.d i5.l<? super Map.Entry<? extends K, ? extends V>, ? extends R> transform) {
        kotlin.jvm.internal.l0.p(map, "<this>");
        kotlin.jvm.internal.l0.p(transform, "transform");
        LinkedHashMap linkedHashMap = new LinkedHashMap(b1.j(map.size()));
        Iterator<T> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Object) it.next();
            linkedHashMap.put(transform.z(entry), entry.getValue());
        }
        return linkedHashMap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @a7.d
    public static final <K, V, R, M extends Map<? super R, ? super V>> M U(@a7.d Map<? extends K, ? extends V> map, @a7.d M destination, @a7.d i5.l<? super Map.Entry<? extends K, ? extends V>, ? extends R> transform) {
        kotlin.jvm.internal.l0.p(map, "<this>");
        kotlin.jvm.internal.l0.p(destination, "destination");
        kotlin.jvm.internal.l0.p(transform, "transform");
        Iterator<T> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Object) it.next();
            destination.put(transform.z(entry), entry.getValue());
        }
        return destination;
    }

    @kotlin.internal.f
    private static final <K, V> Map<K, V> V() {
        return z();
    }

    @a7.d
    public static final <K, V> Map<K, V> W(@a7.d kotlin.u0<? extends K, ? extends V>... pairs) {
        kotlin.jvm.internal.l0.p(pairs, "pairs");
        return pairs.length > 0 ? I0(pairs, new LinkedHashMap(b1.j(pairs.length))) : z();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @a7.d
    public static final <K, V, R> Map<K, R> X(@a7.d Map<? extends K, ? extends V> map, @a7.d i5.l<? super Map.Entry<? extends K, ? extends V>, ? extends R> transform) {
        kotlin.jvm.internal.l0.p(map, "<this>");
        kotlin.jvm.internal.l0.p(transform, "transform");
        LinkedHashMap linkedHashMap = new LinkedHashMap(b1.j(map.size()));
        Iterator<T> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Object) it.next();
            linkedHashMap.put(entry.getKey(), transform.z(entry));
        }
        return linkedHashMap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @a7.d
    public static final <K, V, R, M extends Map<? super K, ? super R>> M Y(@a7.d Map<? extends K, ? extends V> map, @a7.d M destination, @a7.d i5.l<? super Map.Entry<? extends K, ? extends V>, ? extends R> transform) {
        kotlin.jvm.internal.l0.p(map, "<this>");
        kotlin.jvm.internal.l0.p(destination, "destination");
        kotlin.jvm.internal.l0.p(transform, "transform");
        Iterator<T> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Object) it.next();
            destination.put(entry.getKey(), transform.z(entry));
        }
        return destination;
    }

    @a7.d
    @kotlin.g1(version = "1.1")
    public static final <K, V> Map<K, V> Z(@a7.d Map<? extends K, ? extends V> map, @a7.d Iterable<? extends K> keys) {
        kotlin.jvm.internal.l0.p(map, "<this>");
        kotlin.jvm.internal.l0.p(keys, "keys");
        Map mapJ0 = J0(map);
        d0.E0(mapJ0.keySet(), keys);
        return k0(mapJ0);
    }

    @a7.d
    @kotlin.g1(version = "1.1")
    public static final <K, V> Map<K, V> a0(@a7.d Map<? extends K, ? extends V> map, K k7) {
        kotlin.jvm.internal.l0.p(map, "<this>");
        Map mapJ0 = J0(map);
        mapJ0.remove(k7);
        return k0(mapJ0);
    }

    @a7.d
    @kotlin.g1(version = "1.1")
    public static final <K, V> Map<K, V> b0(@a7.d Map<? extends K, ? extends V> map, @a7.d kotlin.sequences.m<? extends K> keys) {
        kotlin.jvm.internal.l0.p(map, "<this>");
        kotlin.jvm.internal.l0.p(keys, "keys");
        Map mapJ0 = J0(map);
        d0.G0(mapJ0.keySet(), keys);
        return k0(mapJ0);
    }

    @a7.d
    @kotlin.g1(version = "1.1")
    public static final <K, V> Map<K, V> c0(@a7.d Map<? extends K, ? extends V> map, @a7.d K[] keys) {
        kotlin.jvm.internal.l0.p(map, "<this>");
        kotlin.jvm.internal.l0.p(keys, "keys");
        Map mapJ0 = J0(map);
        d0.H0(mapJ0.keySet(), keys);
        return k0(mapJ0);
    }

    @kotlin.g1(version = "1.1")
    @kotlin.internal.f
    private static final <K, V> void d0(Map<K, V> map, Iterable<? extends K> keys) {
        kotlin.jvm.internal.l0.p(map, "<this>");
        kotlin.jvm.internal.l0.p(keys, "keys");
        d0.E0(map.keySet(), keys);
    }

    @kotlin.g1(version = "1.1")
    @kotlin.internal.f
    private static final <K, V> void e0(Map<K, V> map, K k7) {
        kotlin.jvm.internal.l0.p(map, "<this>");
        map.remove(k7);
    }

    @kotlin.g1(version = "1.1")
    @kotlin.internal.f
    private static final <K, V> void f0(Map<K, V> map, kotlin.sequences.m<? extends K> keys) {
        kotlin.jvm.internal.l0.p(map, "<this>");
        kotlin.jvm.internal.l0.p(keys, "keys");
        d0.G0(map.keySet(), keys);
    }

    @kotlin.g1(version = "1.1")
    @kotlin.internal.f
    private static final <K, V> void g0(Map<K, V> map, K[] keys) {
        kotlin.jvm.internal.l0.p(map, "<this>");
        kotlin.jvm.internal.l0.p(keys, "keys");
        d0.H0(map.keySet(), keys);
    }

    @h5.h(name = "mutableIterator")
    @kotlin.internal.f
    private static final <K, V> Iterator<Map.Entry<K, V>> h0(Map<K, V> map) {
        kotlin.jvm.internal.l0.p(map, "<this>");
        return map.entrySet().iterator();
    }

    @kotlin.g1(version = "1.1")
    @kotlin.internal.f
    private static final <K, V> Map<K, V> i0() {
        return new LinkedHashMap();
    }

    @a7.d
    public static final <K, V> Map<K, V> j0(@a7.d kotlin.u0<? extends K, ? extends V>... pairs) {
        kotlin.jvm.internal.l0.p(pairs, "pairs");
        LinkedHashMap linkedHashMap = new LinkedHashMap(b1.j(pairs.length));
        y0(linkedHashMap, pairs);
        return linkedHashMap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @a7.d
    public static final <K, V> Map<K, V> k0(@a7.d Map<K, ? extends V> map) {
        kotlin.jvm.internal.l0.p(map, "<this>");
        int size = map.size();
        if (size != 0) {
            return size != 1 ? map : b1.o(map);
        }
        return z();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @kotlin.internal.f
    private static final <K, V> Map<K, V> l0(Map<K, ? extends V> map) {
        return map == 0 ? z() : map;
    }

    @a7.d
    public static final <K, V> Map<K, V> m0(@a7.d Map<? extends K, ? extends V> map, @a7.d Iterable<? extends kotlin.u0<? extends K, ? extends V>> pairs) {
        kotlin.jvm.internal.l0.p(map, "<this>");
        kotlin.jvm.internal.l0.p(pairs, "pairs");
        if (map.isEmpty()) {
            return B0(pairs);
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(map);
        w0(linkedHashMap, pairs);
        return linkedHashMap;
    }

    @a7.d
    public static final <K, V> Map<K, V> n0(@a7.d Map<? extends K, ? extends V> map, @a7.d Map<? extends K, ? extends V> map2) {
        kotlin.jvm.internal.l0.p(map, "<this>");
        kotlin.jvm.internal.l0.p(map2, "map");
        LinkedHashMap linkedHashMap = new LinkedHashMap(map);
        linkedHashMap.putAll(map2);
        return linkedHashMap;
    }

    @a7.d
    public static final <K, V> Map<K, V> o0(@a7.d Map<? extends K, ? extends V> map, @a7.d kotlin.u0<? extends K, ? extends V> pair) {
        kotlin.jvm.internal.l0.p(map, "<this>");
        kotlin.jvm.internal.l0.p(pair, "pair");
        if (map.isEmpty()) {
            return b1.k(pair);
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(map);
        linkedHashMap.put(pair.e(), pair.f());
        return linkedHashMap;
    }

    @a7.d
    public static final <K, V> Map<K, V> p0(@a7.d Map<? extends K, ? extends V> map, @a7.d kotlin.sequences.m<? extends kotlin.u0<? extends K, ? extends V>> pairs) {
        kotlin.jvm.internal.l0.p(map, "<this>");
        kotlin.jvm.internal.l0.p(pairs, "pairs");
        LinkedHashMap linkedHashMap = new LinkedHashMap(map);
        x0(linkedHashMap, pairs);
        return k0(linkedHashMap);
    }

    @a7.d
    public static final <K, V> Map<K, V> q0(@a7.d Map<? extends K, ? extends V> map, @a7.d kotlin.u0<? extends K, ? extends V>[] pairs) {
        kotlin.jvm.internal.l0.p(map, "<this>");
        kotlin.jvm.internal.l0.p(pairs, "pairs");
        if (map.isEmpty()) {
            return H0(pairs);
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(map);
        y0(linkedHashMap, pairs);
        return linkedHashMap;
    }

    @kotlin.internal.f
    private static final <K, V> void r0(Map<? super K, ? super V> map, Iterable<? extends kotlin.u0<? extends K, ? extends V>> pairs) {
        kotlin.jvm.internal.l0.p(map, "<this>");
        kotlin.jvm.internal.l0.p(pairs, "pairs");
        w0(map, pairs);
    }

    @kotlin.g1(version = i2.a.f34096f)
    @q2(markerClass = {kotlin.s.class})
    @kotlin.internal.f
    private static final <K, V> Map<K, V> s(int i7, @kotlin.b i5.l<? super Map<K, V>, l2> builderAction) {
        kotlin.jvm.internal.l0.p(builderAction, "builderAction");
        Map mapH = b1.h(i7);
        builderAction.z(mapH);
        return b1.d(mapH);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @kotlin.internal.f
    private static final <K, V> void s0(Map<? super K, ? super V> map, Map<K, ? extends V> map2) {
        kotlin.jvm.internal.l0.p(map, "<this>");
        kotlin.jvm.internal.l0.p(map2, "map");
        map.putAll(map2);
    }

    @kotlin.g1(version = i2.a.f34096f)
    @q2(markerClass = {kotlin.s.class})
    @kotlin.internal.f
    private static final <K, V> Map<K, V> t(@kotlin.b i5.l<? super Map<K, V>, l2> builderAction) {
        kotlin.jvm.internal.l0.p(builderAction, "builderAction");
        Map mapG = b1.g();
        builderAction.z(mapG);
        return b1.d(mapG);
    }

    @kotlin.internal.f
    private static final <K, V> void t0(Map<? super K, ? super V> map, kotlin.u0<? extends K, ? extends V> pair) {
        kotlin.jvm.internal.l0.p(map, "<this>");
        kotlin.jvm.internal.l0.p(pair, "pair");
        map.put(pair.e(), pair.f());
    }

    @kotlin.internal.f
    private static final <K, V> K u(Map.Entry<? extends K, ? extends V> entry) {
        kotlin.jvm.internal.l0.p(entry, "<this>");
        return entry.getKey();
    }

    @kotlin.internal.f
    private static final <K, V> void u0(Map<? super K, ? super V> map, kotlin.sequences.m<? extends kotlin.u0<? extends K, ? extends V>> pairs) {
        kotlin.jvm.internal.l0.p(map, "<this>");
        kotlin.jvm.internal.l0.p(pairs, "pairs");
        x0(map, pairs);
    }

    @kotlin.internal.f
    private static final <K, V> V v(Map.Entry<? extends K, ? extends V> entry) {
        kotlin.jvm.internal.l0.p(entry, "<this>");
        return entry.getValue();
    }

    @kotlin.internal.f
    private static final <K, V> void v0(Map<? super K, ? super V> map, kotlin.u0<? extends K, ? extends V>[] pairs) {
        kotlin.jvm.internal.l0.p(map, "<this>");
        kotlin.jvm.internal.l0.p(pairs, "pairs");
        y0(map, pairs);
    }

    @kotlin.internal.f
    private static final <K, V> boolean w(Map<? extends K, ? extends V> map, K k7) {
        kotlin.jvm.internal.l0.p(map, "<this>");
        return map.containsKey(k7);
    }

    public static final <K, V> void w0(@a7.d Map<? super K, ? super V> map, @a7.d Iterable<? extends kotlin.u0<? extends K, ? extends V>> pairs) {
        kotlin.jvm.internal.l0.p(map, "<this>");
        kotlin.jvm.internal.l0.p(pairs, "pairs");
        for (kotlin.u0<? extends K, ? extends V> u0Var : pairs) {
            map.put(u0Var.a(), u0Var.b());
        }
    }

    @kotlin.internal.f
    private static final <K> boolean x(Map<? extends K, ?> map, K k7) {
        kotlin.jvm.internal.l0.p(map, "<this>");
        return map.containsKey(k7);
    }

    public static final <K, V> void x0(@a7.d Map<? super K, ? super V> map, @a7.d kotlin.sequences.m<? extends kotlin.u0<? extends K, ? extends V>> pairs) {
        kotlin.jvm.internal.l0.p(map, "<this>");
        kotlin.jvm.internal.l0.p(pairs, "pairs");
        for (kotlin.u0<? extends K, ? extends V> u0Var : pairs) {
            map.put(u0Var.a(), u0Var.b());
        }
    }

    @kotlin.internal.f
    private static final <K, V> boolean y(Map<K, ? extends V> map, V v7) {
        kotlin.jvm.internal.l0.p(map, "<this>");
        return map.containsValue(v7);
    }

    public static final <K, V> void y0(@a7.d Map<? super K, ? super V> map, @a7.d kotlin.u0<? extends K, ? extends V>[] pairs) {
        kotlin.jvm.internal.l0.p(map, "<this>");
        kotlin.jvm.internal.l0.p(pairs, "pairs");
        for (kotlin.u0<? extends K, ? extends V> u0Var : pairs) {
            map.put(u0Var.a(), u0Var.b());
        }
    }

    @a7.d
    public static <K, V> Map<K, V> z() {
        k0 k0Var = k0.f34549a;
        kotlin.jvm.internal.l0.n(k0Var, "null cannot be cast to non-null type kotlin.collections.Map<K of kotlin.collections.MapsKt__MapsKt.emptyMap, V of kotlin.collections.MapsKt__MapsKt.emptyMap>");
        return k0Var;
    }

    @kotlin.internal.f
    private static final <K, V> V z0(Map<? extends K, V> map, K k7) {
        kotlin.jvm.internal.l0.p(map, "<this>");
        return (V) kotlin.jvm.internal.t1.k(map).remove(k7);
    }
}
