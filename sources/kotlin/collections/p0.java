package kotlin.collections;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
class p0 {
    @a7.d
    @kotlin.g1(version = "1.1")
    public static final <T, K> Map<K, Integer> a(@a7.d n0<T, ? extends K> n0Var) {
        kotlin.jvm.internal.l0.p(n0Var, "<this>");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<T> itB = n0Var.b();
        while (itB.hasNext()) {
            K kA = n0Var.a(itB.next());
            Object fVar = linkedHashMap.get(kA);
            if (fVar == null && !linkedHashMap.containsKey(kA)) {
                fVar = new kotlin.jvm.internal.k1.f();
            }
            kotlin.jvm.internal.k1.f fVar2 = (kotlin.jvm.internal.k1.f) fVar;
            fVar2.f34870a++;
            linkedHashMap.put(kA, fVar2);
        }
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            kotlin.jvm.internal.l0.n(entry, "null cannot be cast to non-null type kotlin.collections.MutableMap.MutableEntry<K of kotlin.collections.GroupingKt__GroupingJVMKt.mapValuesInPlace$lambda-4, R of kotlin.collections.GroupingKt__GroupingJVMKt.mapValuesInPlace$lambda-4>");
            kotlin.jvm.internal.t1.m(entry).setValue(Integer.valueOf(((kotlin.jvm.internal.k1.f) entry.getValue()).f34870a));
        }
        return kotlin.jvm.internal.t1.k(linkedHashMap);
    }

    @kotlin.a1
    @kotlin.internal.f
    private static final <K, V, R> Map<K, R> b(Map<K, V> map, i5.l<? super Map.Entry<? extends K, ? extends V>, ? extends R> f8) {
        kotlin.jvm.internal.l0.p(map, "<this>");
        kotlin.jvm.internal.l0.p(f8, "f");
        Iterator<T> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            kotlin.jvm.internal.l0.n(entry, "null cannot be cast to non-null type kotlin.collections.MutableMap.MutableEntry<K of kotlin.collections.GroupingKt__GroupingJVMKt.mapValuesInPlace$lambda-4, R of kotlin.collections.GroupingKt__GroupingJVMKt.mapValuesInPlace$lambda-4>");
            kotlin.jvm.internal.t1.m(entry).setValue(f8.z(entry));
        }
        return kotlin.jvm.internal.t1.k(map);
    }
}
