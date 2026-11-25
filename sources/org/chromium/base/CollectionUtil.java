package org.chromium.base;

import android.util.Pair;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class CollectionUtil {
    private CollectionUtil() {
    }

    public static boolean[] a(@c.m0 List<Boolean> list) {
        boolean[] zArr = new boolean[list.size()];
        for (int i7 = 0; i7 < list.size(); i7++) {
            zArr[i7] = list.get(i7).booleanValue();
        }
        return zArr;
    }

    public static <T> void b(Collection<? extends T> collection, Callback<T> callback) {
        Iterator<? extends T> it = collection.iterator();
        while (it.hasNext()) {
            callback.onResult(it.next());
        }
    }

    public static <K, V> void c(Map<? extends K, ? extends V> map, Callback<Map.Entry<K, V>> callback) {
        Iterator<Map.Entry<? extends K, ? extends V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            callback.onResult(it.next());
        }
    }

    public static int[] d(@c.m0 List<Integer> list) {
        int[] iArr = new int[list.size()];
        for (int i7 = 0; i7 < list.size(); i7++) {
            iArr[i7] = list.get(i7).intValue();
        }
        return iArr;
    }

    public static long[] e(@c.m0 List<Long> list) {
        long[] jArr = new long[list.size()];
        for (int i7 = 0; i7 < list.size(); i7++) {
            jArr[i7] = list.get(i7).longValue();
        }
        return jArr;
    }

    @s0
    public static <E> ArrayList<E> f(Iterable<E> iterable) {
        ArrayList<E> arrayList = new ArrayList<>();
        Iterator<E> it = iterable.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        return arrayList;
    }

    @SafeVarargs
    public static <E> ArrayList<E> g(E... eArr) {
        ArrayList<E> arrayList = new ArrayList<>(eArr.length);
        Collections.addAll(arrayList, eArr);
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SafeVarargs
    public static <K, V> HashMap<K, V> h(Pair<? extends K, ? extends V>... pairArr) {
        junit.framework.f fVar = (HashMap<K, V>) new HashMap();
        for (Pair<? extends K, ? extends V> pair : pairArr) {
            fVar.put(pair.first, pair.second);
        }
        return fVar;
    }

    @SafeVarargs
    public static <E> HashSet<E> i(E... eArr) {
        HashSet<E> hashSet = new HashSet<>(eArr.length);
        Collections.addAll(hashSet, eArr);
        return hashSet;
    }
}
